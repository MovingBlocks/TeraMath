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
 * Defines a circle
 * @author Martin Steiger
 */
public final class Circle implements Shape {

    private final ImmutableVector2d center;
    private final double radius;

    /**
     * @param centerX the center X coord
     * @param centerY the center Y coord
     * @param radius the radius
     */
    public Circle(double centerX, double centerY, double radius) {
        this.center = new ImmutableVector2d(centerX, centerY);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [center: " + center + ", radius: " + radius + "]";
    }

    /**
     * @return the center of the cirle
     */
    public ImmutableVector2d getCenter() {
        return center;
    }

    /**
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public boolean contains(BaseVector2d v) {
        double dx = v.x() - center.x();
        double dy = v.y() - center.y();

        return dx * dx + dy * dy <= radius * radius;
    }
}

