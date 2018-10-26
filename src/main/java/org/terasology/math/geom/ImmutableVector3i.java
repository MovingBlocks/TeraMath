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
 * An immutable implementation of BaseVector3i, which is a point or vector in 3D space with int components.
 * This type is intended for use for constants, or any time you want a BaseVector3i that is guaranteed immutable.
 *
 * @author auto-generated
 */
@Deprecated
public final class ImmutableVector3i extends BaseVector3i {


    /**
    * @param x the x component
    * @param y the y component
    * @param z the z component
     */
    public ImmutableVector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3i to copy.
     */
    public ImmutableVector3i(BaseVector3i other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector3i createOrUse(BaseVector3i other) {
        if (other instanceof ImmutableVector3i) {
            return (ImmutableVector3i) other;
        }

        return new ImmutableVector3i(other);
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
    public int getZ() {
        return z;
    }


    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public int z() {
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
    public ImmutableVector3i add(int valueX, int valueY, int valueZ) {
        int nx = x + valueX;
        int ny = y + valueY;
        int nz = z + valueZ;
        return new ImmutableVector3i(nx, ny, nz);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3i add(BaseVector3i other) {
        int nx = x + other.getX();
        int ny = y + other.getY();
        int nz = z + other.getZ();
        return new ImmutableVector3i(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @return a new instance
     */
    public ImmutableVector3i sub(int valueX, int valueY, int valueZ) {
        int nx = x - valueX;
        int ny = y - valueY;
        int nz = z - valueZ;
        return new ImmutableVector3i(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3i sub(BaseVector3i other) {
        int nx = x - other.getX();
        int ny = y - other.getY();
        int nz = z - other.getZ();
        return new ImmutableVector3i(nx, ny, nz);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector3i scale(int value) {
        int nx = x * value;
        int ny = y * value;
        int nz = z * value;
        return new ImmutableVector3i(nx, ny, nz);
    }

}
