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
 * An immutable implementation of BaseVector4f, which is a point or vector in 4D space with float components.
 * This type is intended for use for constants, or any time you want a BaseVector4f that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector4f extends BaseVector4f {

    private final float x;
    private final float y;
    private final float z;
    private final float w;

    /**
    * @param x the x component
    * @param y the y component
    * @param z the z component
    * @param w the w component
     */
    public ImmutableVector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor
     * @param other The BaseVector4f to copy.
     */
    public ImmutableVector4f(BaseVector4f other) {
        this(other.getX(), other.getY(), other.getZ(), other.getW());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector4f createOrUse(BaseVector4f other) {
        if (other instanceof ImmutableVector4f) {
            return (ImmutableVector4f) other;
        }

        return new ImmutableVector4f(other);
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
    public float getZ() {
        return z;
    }

    @Override
    public float getW() {
        return w;
    }


    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public float z() {
        return z;
    }

    @Override
    public float w() {
        return w;
    }


    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @param valueZ the value to add to the z component
     * @param valueW the value to add to the w component
     * @return a new instance
     */
    public ImmutableVector4f add(float valueX, float valueY, float valueZ, float valueW) {
        float nx = x + valueX;
        float ny = y + valueY;
        float nz = z + valueZ;
        float nw = w + valueW;
        return new ImmutableVector4f(nx, ny, nz, nw);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector4f add(BaseVector4f other) {
        float nx = x + other.getX();
        float ny = y + other.getY();
        float nz = z + other.getZ();
        float nw = w + other.getW();
        return new ImmutableVector4f(nx, ny, nz, nw);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @param valueW the value to subtract from the w component
     * @return a new instance
     */
    public ImmutableVector4f sub(float valueX, float valueY, float valueZ, float valueW) {
        float nx = x - valueX;
        float ny = y - valueY;
        float nz = z - valueZ;
        float nw = w - valueW;
        return new ImmutableVector4f(nx, ny, nz, nw);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector4f sub(BaseVector4f other) {
        float nx = x - other.getX();
        float ny = y - other.getY();
        float nz = z - other.getZ();
        float nw = w - other.getW();
        return new ImmutableVector4f(nx, ny, nz, nw);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector4f scale(float value) {
        float nx = x * value;
        float ny = y * value;
        float nz = z * value;
        float nw = w * value;
        return new ImmutableVector4f(nx, ny, nz, nw);
    }

}
