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
 * An immutable implementation of BaseVector4d, which is a point or vector in 4D space with double components.
 * This type is intended for use for constants, or any time you want a BaseVector4d that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class ImmutableVector4d extends BaseVector4d {

    private final double x;
    private final double y;
    private final double z;
    private final double w;

    /**
    * @param x the x component
    * @param y the y component
    * @param z the z component
    * @param w the w component
     */
    public ImmutableVector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor
     * @param other The BaseVector4d to copy.
     */
    public ImmutableVector4d(BaseVector4d other) {
        this(other.getX(), other.getY(), other.getZ(), other.getW());
    }

    /**
     * Returns an immutable version of the provided vector.
     * @param other the vector to use
     */
    public static ImmutableVector4d createOrUse(BaseVector4d other) {
        if (other instanceof ImmutableVector4d) {
            return (ImmutableVector4d) other;
        }

        return new ImmutableVector4d(other);
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
    public double getW() {
        return w;
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

    @Override
    public double w() {
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
    public ImmutableVector4d add(double valueX, double valueY, double valueZ, double valueW) {
        double nx = x + valueX;
        double ny = y + valueY;
        double nz = z + valueZ;
        double nw = w + valueW;
        return new ImmutableVector4d(nx, ny, nz, nw);
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector4d add(BaseVector4d other) {
        double nx = x + other.getX();
        double ny = y + other.getY();
        double nz = z + other.getZ();
        double nw = w + other.getW();
        return new ImmutableVector4d(nx, ny, nz, nw);
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
    public ImmutableVector4d sub(double valueX, double valueY, double valueZ, double valueW) {
        double nx = x - valueX;
        double ny = y - valueY;
        double nz = z - valueZ;
        double nw = w - valueW;
        return new ImmutableVector4d(nx, ny, nz, nw);
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return a new instance
     */
    public ImmutableVector4d sub(BaseVector4d other) {
        double nx = x - other.getX();
        double ny = y - other.getY();
        double nz = z - other.getZ();
        double nw = w - other.getW();
        return new ImmutableVector4d(nx, ny, nz, nw);
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return a new instance
     */
    public ImmutableVector4d scale(double value) {
        double nx = x * value;
        double ny = y * value;
        double nz = z * value;
        double nw = w * value;
        return new ImmutableVector4d(nx, ny, nz, nw);
    }


}
