/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

/**
 * An immutable implementation of BaseVector2d, which is a point or vector in 2D space with double components.
 * This type is intended for use for constants, or any time you want a BaseVector2d that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector2d extends BaseVector2d {

    private final double x;
    private final double y;

    /**
    * @param x the x component
    * @param y the y component
     */
    public ImmutableVector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2d to copy.
     */
    public ImmutableVector2d(BaseVector2d other) {
        this(other.getX(), other.getY());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector2d createOrUse(BaseVector2d other) {
        if (other instanceof ImmutableVector2d) {
            return (ImmutableVector2d) other;
        }

        return new ImmutableVector2d(other);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }


    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }


    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @return a new instance
     */
    public ImmutableVector2d add(double valueX, double valueY) {
        double nx = x + valueX;
        double ny = y + valueY;
        return new ImmutableVector2d(nx, ny);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2d add(BaseVector2d other) {
        double nx = x + other.getX();
        double ny = y + other.getY();
        return new ImmutableVector2d(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @return a new instance
     */
    public ImmutableVector2d sub(double valueX, double valueY) {
        double nx = x - valueX;
        double ny = y - valueY;
        return new ImmutableVector2d(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2d sub(BaseVector2d other) {
        double nx = x - other.getX();
        double ny = y - other.getY();
        return new ImmutableVector2d(nx, ny);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector2d scale(double value) {
        double nx = x * value;
        double ny = y * value;
        return new ImmutableVector2d(nx, ny);
    }


}
