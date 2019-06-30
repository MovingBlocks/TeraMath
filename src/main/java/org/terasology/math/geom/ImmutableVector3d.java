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
 * An immutable implementation of BaseVector3d, which is a point or vector in 3D space with double components.
 * This type is intended for use for constants, or any time you want a BaseVector3d that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector3d extends BaseVector3d {

    private final double x;
    private final double y;
    private final double z;

    /**
    * @param x the x component
    * @param y the y component
    * @param z the z component
     */
    public ImmutableVector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3d to copy.
     */
    public ImmutableVector3d(BaseVector3d other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector3d createOrUse(BaseVector3d other) {
        if (other instanceof ImmutableVector3d) {
            return (ImmutableVector3d) other;
        }

        return new ImmutableVector3d(other);
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
    public double getZ() {
        return z;
    }


    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double z() {
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
    public ImmutableVector3d add(double valueX, double valueY, double valueZ) {
        double nx = x + valueX;
        double ny = y + valueY;
        double nz = z + valueZ;
        return new ImmutableVector3d(nx, ny, nz);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3d add(BaseVector3d other) {
        double nx = x + other.getX();
        double ny = y + other.getY();
        double nz = z + other.getZ();
        return new ImmutableVector3d(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @return a new instance
     */
    public ImmutableVector3d sub(double valueX, double valueY, double valueZ) {
        double nx = x - valueX;
        double ny = y - valueY;
        double nz = z - valueZ;
        return new ImmutableVector3d(nx, ny, nz);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector3d sub(BaseVector3d other) {
        double nx = x - other.getX();
        double ny = y - other.getY();
        double nz = z - other.getZ();
        return new ImmutableVector3d(nx, ny, nz);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector3d scale(double value) {
        double nx = x * value;
        double ny = y * value;
        double nz = z * value;
        return new ImmutableVector3d(nx, ny, nz);
    }


}
