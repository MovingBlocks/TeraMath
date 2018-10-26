/*
 * Copyright 2018 MovingBlocks
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
 * An immutable implementation of BaseVector2f, which is a point or vector in 2D space with float components.
 * This type is intended for use for constants, or any time you want a BaseVector2f that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector2f extends BaseVector2f {

    private final float x;
    private final float y;

    /**
    * @param x the x component
    * @param y the y component
     */
    public ImmutableVector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2f to copy.
     */
    public ImmutableVector2f(BaseVector2f other) {
        this(other.getX(), other.getY());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector2f createOrUse(BaseVector2f other) {
        if (other instanceof ImmutableVector2f) {
            return (ImmutableVector2f) other;
        }

        return new ImmutableVector2f(other);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }


    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }


    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @return a new instance
     */
    public ImmutableVector2f add(float valueX, float valueY) {
        float nx = x + valueX;
        float ny = y + valueY;
        return new ImmutableVector2f(nx, ny);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2f add(BaseVector2f other) {
        float nx = x + other.getX();
        float ny = y + other.getY();
        return new ImmutableVector2f(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @return a new instance
     */
    public ImmutableVector2f sub(float valueX, float valueY) {
        float nx = x - valueX;
        float ny = y - valueY;
        return new ImmutableVector2f(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2f sub(BaseVector2f other) {
        float nx = x - other.getX();
        float ny = y - other.getY();
        return new ImmutableVector2f(nx, ny);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector2f scale(float value) {
        float nx = x * value;
        float ny = y * value;
        return new ImmutableVector2f(nx, ny);
    }

}
