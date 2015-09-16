/*
 * Copyright 2015 MovingBlocks
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

import java.util.Collection;

/**
 * Defines a axis-aligned bounding box based on a set of {@link BaseVector2f} instances.
 */
public final class BoundingBox {
    private float x1;
    private float y1;
    private float x2;
    private float y2;

    private boolean empty = true;

    /**
     * Default, empty constructor
     */
    public BoundingBox() {
        x1 = Float.POSITIVE_INFINITY;
        y1 = Float.POSITIVE_INFINITY;
        x2 = Float.NEGATIVE_INFINITY;
        y2 = Float.NEGATIVE_INFINITY;
    }

    /**
     * @param pt the initial point
     */
    public BoundingBox(BaseVector2f pt) {
        x1 = pt.getX();
        y1 = pt.getY();
        x2 = pt.getX();
        y2 = pt.getY();

        empty = false;
    }

    /**
     * Computes the bounding box of the given point set
     * @param pts a non-empty collection of points
     * @return the bounding box
     */
    public static Rect2f compute(Collection<? extends BaseVector2f> pts) {
        BoundingBox bbox = new BoundingBox();
        bbox.addAll(pts);
        return bbox.toRect2f();
    }

    /**
     * Resizes to include the given point
     * @param pt the Vector2i
     */
    public void add(BaseVector2f pt) {
        add(pt.getX(), pt.getY());
    }

    /**
     * Resizes to include all points
     * @param pts a collection of points
     */
    public void addAll(Collection<? extends BaseVector2f> pts) {
        for (BaseVector2f pt : pts) {
            add(pt.getX(), pt.getY());
        }
    }

    /**
     * Resizes to include (x, y)
     * @param x the x coord.
     * @param y the y coord.
     */
    public void add(float x, float y) {
        if (x < x1) {
            x1 = x;
        }

        if (y < y1) {
            y1 = y;
        }

        if (x > x2) {
            x2 = x;
        }

        if (y > y2) {
            y2 = y;
        }

        empty = false;
    }

    /**
     * @return true if the bounding box is empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * @return a new Rect2f instance containing the bounds or {@link Rect2f#EMPTY} if empty.
     */
    public Rect2f toRect2f() {
        if (empty) {
            return Rect2f.EMPTY;
        }

        return Rect2f.createFromMinAndMax(x1, y1, x2, y2);
    }
}
