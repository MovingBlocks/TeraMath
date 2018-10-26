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
 * An immutable implementation of BaseVector2i, which is a point or vector in 2D space with int components.
 * This type is intended for use for constants, or any time you want a BaseVector2i that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector2i extends BaseVector2i {

    private final int x;
    private final int y;

    /**
    * @param x the x component
    * @param y the y component
     */
    public ImmutableVector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2i to copy.
     */
    public ImmutableVector2i(BaseVector2i other) {
        this(other.getX(), other.getY());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector2i createOrUse(BaseVector2i other) {
        if (other instanceof ImmutableVector2i) {
            return (ImmutableVector2i) other;
        }

        return new ImmutableVector2i(other);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }


    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @return a new instance
     */
    public ImmutableVector2i add(int valueX, int valueY) {
        int nx = x + valueX;
        int ny = y + valueY;
        return new ImmutableVector2i(nx, ny);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2i add(BaseVector2i other) {
        int nx = x + other.getX();
        int ny = y + other.getY();
        return new ImmutableVector2i(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @return a new instance
     */
    public ImmutableVector2i sub(int valueX, int valueY) {
        int nx = x - valueX;
        int ny = y - valueY;
        return new ImmutableVector2i(nx, ny);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector2i sub(BaseVector2i other) {
        int nx = x - other.getX();
        int ny = y - other.getY();
        return new ImmutableVector2i(nx, ny);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector2i scale(int value) {
        int nx = x * value;
        int ny = y * value;
        return new ImmutableVector2i(nx, ny);
    }

}
