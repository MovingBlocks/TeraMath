/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
 * @author Martin Steiger
 */
public final class Polygon implements Shape {

    private final ImmutableList<ImmutableVector2f> vertices;
    private Rect2f bbox;

    private Polygon(ImmutableList<ImmutableVector2f> vertices) {
        Preconditions.checkArgument(!vertices.isEmpty(), "vertices must not be empty");

        this.vertices = vertices;
    }

    /**
     * @param vertices a list of vertices (vertices are copied)
     */
    public static Polygon createCopy(List<Vector2f> vertices) {
        Builder<ImmutableVector2f> bldr = ImmutableList.builder();
        for (BaseVector2f v : vertices) {
            bldr.add(new ImmutableVector2f(v));
        }

        return new Polygon(bldr.build());
    }

    /**
     * @param vertices a list of vertices (vertices are directly used)
     */
    public static Polygon create(List<ImmutableVector2f> vertices) {
        return new Polygon(ImmutableList.copyOf(vertices));
    }

    /**
     * @return the area of the polygon
     */
    public float area() {
        return (float) Math.abs(signedArea());
    }

    @Override
    public Rect2f getBounds() {
        if (bbox == null) {
            bbox = BoundingBox.compute(vertices);
        }
        return bbox;
    }

    /**
     * @return the winding of the polygon
     */
    public Winding winding() {
        double signedArea = signedArea();

        return (signedArea <= 0)
            ? Winding.CLOCKWISE
            : Winding.COUNTERCLOCKWISE;
    }

    private double signedArea() {
        int index;
        int nextIndex;
        int n = vertices.size();
        ImmutableVector2f point;
        ImmutableVector2f next;
        double signedDoubleArea = 0;
        for (index = 0; index < n; ++index) {
            nextIndex = (index + 1) % n;
            point = vertices.get(index);
            next = vertices.get(nextIndex);
            signedDoubleArea += point.getX() * next.getY() - next.getX() * point.getY();
        }
        return signedDoubleArea * 0.5;
    }

    /**
     * A point is considered to lie inside a
     * <code>Polygon</code> if and only if:
     * <ul>
     * <li> it lies completely
     * inside the<code>Shape</code> boundary <i>or</i>
     * <li>
     * it lies exactly on the <code>Shape</code> boundary <i>and</i> the
     * space immediately adjacent to the
     * point in the increasing <code>X</code> direction is
     * entirely inside the boundary <i>or</i>
     * <li>
     * it lies exactly on a horizontal boundary segment <b>and</b> the
     * space immediately adjacent to the point in the
     * increasing <code>Y</code> direction is inside the boundary.
     * </ul>
     * @param x the x coord
     * @param y the y coord
     * @return true if the polygon contains the point
     */
    @Override
    public boolean contains(BaseVector2f v) {
        return contains(v.x(), v.y());
    }

    /**
     * A point is considered to lie inside a
     * <code>Polygon</code> if and only if:
     * <ul>
     * <li> it lies completely
     * inside the<code>Shape</code> boundary <i>or</i>
     * <li>
     * it lies exactly on the <code>Shape</code> boundary <i>and</i> the
     * space immediately adjacent to the
     * point in the increasing <code>X</code> direction is
     * entirely inside the boundary <i>or</i>
     * <li>
     * it lies exactly on a horizontal boundary segment <b>and</b> the
     * space immediately adjacent to the point in the
     * increasing <code>Y</code> direction is inside the boundary.
     * </ul>
     * @param x the x coord
     * @param y the y coord
     * @return true if the polygon contains the point
     */
    @Override
    public boolean contains(BaseVector2i v) {
        return contains(v.x(), v.y());
    }

    /**
     * A point is considered to lie inside a
     * <code>Polygon</code> if and only if:
     * <ul>
     * <li> it lies completely
     * inside the<code>Shape</code> boundary <i>or</i>
     * <li>
     * it lies exactly on the <code>Shape</code> boundary <i>and</i> the
     * space immediately adjacent to the
     * point in the increasing <code>X</code> direction is
     * entirely inside the boundary <i>or</i>
     * <li>
     * it lies exactly on a horizontal boundary segment <b>and</b> the
     * space immediately adjacent to the point in the
     * increasing <code>Y</code> direction is inside the boundary.
     * </ul>
     * @param x the x coord
     * @param y the y coord
     * @return true if the polygon contains the point
     */
    @Override
    public boolean contains(float x, float y) {
        int npoints = vertices.size();

        if (npoints <= 2) { // || !getBoundingBox().contains(x, y)) {
            return false;
        }
        int hits = 0;

        ImmutableVector2f last = vertices.get(npoints - 1);

        double lastx = last.x();
        double lasty = last.y();
        double curx;
        double cury;

        // Walk the edges of the polygon
        for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
            ImmutableVector2f cur = vertices.get(i);
            curx = cur.x();
            cury = cur.y();

            if (cury == lasty) {
                continue;
            }

            double leftx;
            if (curx < lastx) {
                if (x >= lastx) {
                    continue;
                }
                leftx = curx;
            } else {
                if (x >= curx) {
                    continue;
                }
                leftx = lastx;
            }

            double test1;
            double test2;
            if (cury < lasty) {
                if (y < cury || y >= lasty) {
                    continue;
                }
                if (x < leftx) {
                    hits++;
                    continue;
                }
                test1 = x - curx;
                test2 = y - cury;
            } else {
                if (y < lasty || y >= cury) {
                    continue;
                }
                if (x < leftx) {
                    hits++;
                    continue;
                }
                test1 = x - lastx;
                test2 = y - lasty;
            }

            if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
                hits++;
            }
        }

        return ((hits & 1) != 0);
    }
}
