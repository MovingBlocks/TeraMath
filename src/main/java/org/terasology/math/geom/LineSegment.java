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

/**
 * Defines a line segment
 * @author Martin Steiger
 */
public final class LineSegment {

    private final ImmutableVector2f start;
    private final ImmutableVector2f end;

    /**
     * @param p0 the first point
     * @param p1 the second point
     */
    public LineSegment(BaseVector2f start, BaseVector2f end) {
        this.start = new ImmutableVector2f(start);
        this.end = new ImmutableVector2f(end);
    }

    /**
     * @return the starting point
     */
    public ImmutableVector2f getStart() {
        return start;
    }

    /**
     * @return the end point
     */
    public ImmutableVector2f getEnd() {
        return end;
    }

    /**
     * @return the direction (not normalized)
     */
    public ImmutableVector2f getDir() {
        return end.sub(start);
    }

    /**
     * Computes the smallest distance to a given point in 2D space
     * @param pointP the point to test
     * @return the smallest distance
     */
    public float distanceToPoint(BaseVector2f pointP) {
        return distanceToPoint(getStart(), getEnd(), pointP);
    }

    /**
     * Computes the smallest distance to a given point in 2D space
     * @param pointA the start of the line segment
     * @param pointB the end of the line segment
     * @param pointP the point to test
     * @return the smallest distance
     */
    public static float distanceToPoint(BaseVector2f pointA, BaseVector2f pointB, BaseVector2f pointP) {
        return distanceToPoint(
                pointA.getX(), pointA.getY(),
                pointB.getX(), pointB.getY(),
                pointP.getX(), pointP.getY());
    }
    /**
     * Computes the smallest distance to a given point in 2D space
     * @param pointA the start of the line segment
     * @param pointB the end of the line segment
     * @param pointP the point to test
     * @return the smallest distance
     */
    public static float distanceToPoint(float pointAx, float pointAy, float pointBx, float pointBy,
                                        float pointPx, float pointPy) {

        float ab0 = pointBx - pointAx;
        float ab1 = pointBy - pointAy;

        float ac0 = pointPx - pointAx;
        float ac1 = pointPy - pointAy;

        float bc0 = pointPx - pointBx;
        float bc1 = pointPy - pointBy;

        float dot1 = ab0 * bc0 + ab1 * bc1;

        if (dot1 > 0) {
            return distance(pointBx, pointBy, pointPx, pointPy);
        }

        float dot2 = -ab0 * ac0 - ab1 * ac1;

        if (dot2 > 0) {
            return distance(pointAx, pointAy, pointPx, pointPy);
        }

        float cross = ab0 * ac1 - ab1 * ac0;
        float dist = cross / distance(pointAx, pointAy, pointBx, pointBy);

        return Math.abs(dist);
    }

    private static float distance(float x0, float y0, float x1, float y1) {
        float dx = x1 - x0;
        float dy = y1 - y0;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
