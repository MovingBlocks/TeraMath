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
    public boolean contains(BaseVector2f v) {
        float dx = v.x() - center.x();
        float dy = v.y() - center.y();

        return dx * dx + dy * dy <= radius * radius;
    }
}

