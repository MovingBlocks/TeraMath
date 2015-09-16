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

import com.google.common.base.Preconditions;


/**
 * Defines a circle
 * @author Martin Steiger
 */
public final class Circle implements Shape {

    private final ImmutableVector2f center;
    private final float radius;

    /**
     * @param centerX the center X coord
     * @param centerY the center Y coord
     * @param radius the radius
     */
    public Circle(float centerX, float centerY, float radius) {
        Preconditions.checkArgument(radius >= 0, "radius must be >= 0");

        this.center = new ImmutableVector2f(centerX, centerY);
        this.radius = radius;
    }

    /**
     * @param centerX the center X coord
     * @param centerY the center Y coord
     * @param radius the radius
     */
    public Circle(BaseVector2f center, float radius) {
        this(center.getX(), center.getY(), radius);
    }

    @Override
    public String toString() {
        return "Circle [center: " + center + ", radius: " + radius + "]";
    }

    /**
     * @return the center of the cirle
     */
    public ImmutableVector2f getCenter() {
        return center;
    }

    /**
     * @return the radius of the circle
     */
    public float getRadius() {
        return radius;
    }

    @Override
    public Rect2f getBounds() {
        float dia = radius * 2f;
        return Rect2f.createFromMinAndSize(center.x() - radius, center.y() - radius, dia, dia);
    }

    /**
     * @return true if the distance is <= radius
     */
    @Override
    public boolean contains(BaseVector2f v) {
        return contains(v.getX(), v.getY());
    }

    /**
     * @return true if the distance is <= radius
     */
    @Override
    public boolean contains(BaseVector2i v) {
        return contains(v.getX(), v.getY());
    }

    /**
     * @return true if the distance is <= radius
     */
    @Override
    public boolean contains(float x, float y) {
        float dx = x - center.x();
        float dy = y - center.y();

        return dx * dx + dy * dy <= radius * radius;
    }

    public boolean intersects(Rect2i rect) {
        return intersects(center.getX(), center.getY(), radius, rect);
    }

    /**
     * @param pos the center of the circle
     * @param radius the radius of the circle
     * @param rect the rectangle to test against
     * @return true if the distance is <= radius
     */
    public static boolean intersects(BaseVector2i pos, float radius, Rect2i rect) {
        return intersects(pos.getX(), pos.getY(), radius, rect);
    }

    /**
     * @param pos the center of the circle
     * @param radius the radius of the circle
     * @param rect the rectangle to test against
     * @return true if the distance is <= radius
     */
    public static boolean intersects(BaseVector2f pos, float radius, Rect2i rect) {
        return intersects(pos.getX(), pos.getY(), radius, rect);
    }

    /**
     * @param x the center x coord of the circle
     * @param y the center y coord of the circle
     * @param radius the radius of the circle
     * @param rect the rectangle to test against
     * @return true if the distance is <= radius
     */
    public static boolean intersects(float x, float y, float radius, Rect2i rect) {
        if (rect.isEmpty()) {
            return false;
        }

        float halfWidth = rect.width() * 0.5f;
        float circleDistanceX = Math.abs(x - rect.minX() - halfWidth);
        if (circleDistanceX > (halfWidth + radius)) {
            return false;
        }
        float halfHeight = rect.height() * 0.5f;
        float circleDistanceY = Math.abs(y - rect.minY() - halfHeight);
        if (circleDistanceY > (halfHeight + radius)) {
            return false;
        }

        if (circleDistanceX <= halfWidth) {
            return true;
        }

        if (circleDistanceY <= halfHeight) {
            return true;
        }

        return sqr(circleDistanceX - halfWidth) + sqr(circleDistanceY - halfHeight) <= sqr(radius);
    }

    private static float sqr(float f) {
        return f * f;
    }
}

