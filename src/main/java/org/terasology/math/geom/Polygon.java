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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Steiger
 */
public final class Polygon implements Shape {

    private final List<Vector2d> vertices;

    /**
     * @param vertices a list of vertices (copied for internal storage)
     */
    public Polygon(List<Vector2d> vertices) {
        this.vertices = new ArrayList<Vector2d>(vertices);
    }

    /**
     * @return the area of the polygon
     */
    public double area() {
        return Math.abs(signedDoubleArea() * 0.5);
    }

    /**
     * @return the winding of the polygon
     */
    public Winding winding() {
        double signedDoubleArea = signedDoubleArea();
        if (signedDoubleArea < 0) {
            return Winding.CLOCKWISE;
        }
        if (signedDoubleArea > 0) {
            return Winding.COUNTERCLOCKWISE;
        }
        return Winding.NONE;
    }

    private double signedDoubleArea() {
        int index;
        int nextIndex;
        int n = vertices.size();
        Vector2d point;
        Vector2d next;
        double signedDoubleArea = 0;
        for (index = 0; index < n; ++index) {
            nextIndex = (index + 1) % n;
            point = vertices.get(index);
            next = vertices.get(nextIndex);
            signedDoubleArea += point.getX() * next.getY() - next.getX() * point.getY();
        }
        return signedDoubleArea;
    }

    @Override
    public boolean contains(BaseVector2d v) {
        return contains(v.x(), v.y());
    }

    /**
     * @see java.awt.Polygon#contains(double, double)
     * @param x the x coord
     * @param y the y coord
     * @return true if the polygon contains the point
     */
    public boolean contains(double x, double y) {
        int npoints = vertices.size();
        
        if (npoints <= 2) { // || !getBoundingBox().contains(x, y)) {
            return false;
        }
        int hits = 0;

        Vector2d last = vertices.get(npoints - 1);
        
        double lastx = last.x();
        double lasty = last.y();
        double curx;
        double cury;

        // Walk the edges of the polygon
        for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
            Vector2d cur = vertices.get(i);
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
