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
 * An immutable implementation of BaseVector3f, which is a point or vector in 3D space with float components.
 * This type is intended for use for constants, or any time you want a BaseVector3f that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector3f extends BaseVector3f {

    private final float x;
    private final float y;
    private final float z;

    /**
    * @param x the x component
    * @param y the y component
    * @param z the z component
     */
    public ImmutableVector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3f to copy.
     */
    public ImmutableVector3f(BaseVector3f other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector3f createOrUse(BaseVector3f other) {
        if (other instanceof ImmutableVector3f) {
            return (ImmutableVector3f) other;
        }

        return new ImmutableVector3f(other);
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


    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @param valueZ the value to add to the z component
     * @return a new instance
     */
    public ImmutableVector3f add(float valueX, float valueY, float valueZ) {
        float nx = x + valueX;
        float ny = y + valueY;
        float nz = z + valueZ;
        return new ImmutableVector3f(nx, ny, nz);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3f add(BaseVector3f other) {
        float nx = x + other.getX();
        float ny = y + other.getY();
        float nz = z + other.getZ();
        return new ImmutableVector3f(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @return a new instance
     */
    public ImmutableVector3f sub(float valueX, float valueY, float valueZ) {
        float nx = x - valueX;
        float ny = y - valueY;
        float nz = z - valueZ;
        return new ImmutableVector3f(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3f sub(BaseVector3f other) {
        float nx = x - other.getX();
        float ny = y - other.getY();
        float nz = z - other.getZ();
        return new ImmutableVector3f(nx, ny, nz);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector3f scale(float value) {
        float nx = x * value;
        float ny = y * value;
        float nz = z * value;
        return new ImmutableVector3f(nx, ny, nz);
    }


}
