/*
 * Copyright 2019 MovingBlocks
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

import org.joml.Vector4dc;

/**
 * Vector4d is the mutable implementation of BaseVector4d, for representing points or vectors in 4 dimensional space of type
 * double.
 *
 * @author auto-generated
 */
public class Vector4d extends BaseVector4d {

    public double x;
    public double y;
    public double z;
    public double w;

    /**
     * Default constructor - all components are set to 0
     */
    public Vector4d() {
    }

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @param w the w component
     */
    public Vector4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor
     * @param other The BaseVector4d to copy.
     */
    public Vector4d(Vector4dc other) {
        this(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * A new vector with all entries explicitly set to zero
     */
    public static Vector4d zero() {
        return new Vector4d(0, 0, 0, 0);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector4d one() {
        return new Vector4d(1, 1, 1, 1);
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
     * @param newX the new x coordinate
     * @return this Vector4d, to allow method chaining
     */
    public Vector4d setX(double newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector4d, to allow method chaining
     */
    public Vector4d setY(double newY) {
        this.y = newY;
        return this;
    }
    /**
     * @param newZ the new x coordinate
     * @return this Vector4d, to allow method chaining
     */
    public Vector4d setZ(double newZ) {
        this.z = newZ;
        return this;
    }
    /**
     * @param newW the new x coordinate
     * @return this Vector4d, to allow method chaining
     */
    public Vector4d setW(double newW) {
        this.w = newW;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector4d set(BaseVector4d other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @param newZ the z component
     * @param newW the w component
     * @return this
     */
    public Vector4d set(double newX, double newY, double newZ, double newW) {
        this.x = newX;
        this.y = newY;
        this.z = newZ;
        this.w = newW;
        return this;
    }

    /**
     * Adds to the x component
     *
     * @param value the value to add to x
     * @return this
     */
    public Vector4d addX(double value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector4d addY(double value) {
        this.y += value;
        return this;
    }
    /**
     * Adds to the z component
     *
     * @param value the value to add to z
     * @return this
     */
    public Vector4d addZ(double value) {
        this.z += value;
        return this;
    }
    /**
     * Adds to the w component
     *
     * @param value the value to add to w
     * @return this
     */
    public Vector4d addW(double value) {
        this.w += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector4d subX(double value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector4d subY(double value) {
        this.y -= value;
        return this;
    }
    /**
     * Subtracts from the z component
     *
     * @param value the value to subtract from z
     * @return this
     */
    public Vector4d subZ(double value) {
        this.z -= value;
        return this;
    }
    /**
     * Subtracts from the w component
     *
     * @param value the value to subtract from w
     * @return this
     */
    public Vector4d subW(double value) {
        this.w -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector4d mulX(double value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector4d mulY(double value) {
        this.y *= value;
        return this;
    }
    /**
     * Multiplies the z component
     *
     * @param value the value by which to multiply z
     * @return this
     */
    public Vector4d mulZ(double value) {
        this.z *= value;
        return this;
    }
    /**
     * Multiplies the w component
     *
     * @param value the value by which to multiply w
     * @return this
     */
    public Vector4d mulW(double value) {
        this.w *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector4d div(double value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        this.w /= value;
        return this;
    }

    /**
     * Divides the x component
     *
     * @param value the value by which to divide x
     * @return this
     */
    public Vector4d divX(double value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector4d divY(double value) {
        this.y /= value;
        return this;
    }
    /**
     * Divides the z component
     *
     * @param value the value by which to divide z
     * @return this
     */
    public Vector4d divZ(double value) {
        this.z /= value;
        return this;
    }
    /**
     * Divides the w component
     *
     * @param value the value by which to divide w
     * @return this
     */
    public Vector4d divW(double value) {
        this.w /= value;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @param valueZ the value to add to the z component
     * @param valueW the value to add to the w component
     * @return this
     */
    public Vector4d add(double valueX, double valueY, double valueZ, double valueW) {
        this.x += valueX;
        this.y += valueY;
        this.z += valueZ;
        this.w += valueW;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public Vector4d add(BaseVector4d other) {
        this.x += other.getX();
        this.y += other.getY();
        this.z += other.getZ();
        this.w += other.getW();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @param valueW the value to subtract from the w component
     * @return this
     */
    public Vector4d sub(double valueX, double valueY, double valueZ, double valueW) {
        this.x -= valueX;
        this.y -= valueY;
        this.z -= valueZ;
        this.w -= valueW;
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public Vector4d sub(BaseVector4d other) {
        this.x -= other.getX();
        this.y -= other.getY();
        this.z -= other.getZ();
        this.w -= other.getW();
        return this;
    }

    /**
     *  Sets each component of this tuple to its absolute value.
     */
    public final void absolute() {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
        this.z = Math.abs(z);
        this.w = Math.abs(w);
    }

    /**
     * Negate each component
     * @return this
     */
    public Vector4d negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    /**
     * Sets the value of this vector to the vector difference
     * of vector t1 and t2 (this = t1 - t2).
     * @param t1 the first vector
     * @param t2 the second vector
     */
    public final void sub(BaseVector4d t1, BaseVector4d t2) {
        this.x = t1.getX() - t2.getX();
        this.y = t1.getY() - t2.getY();
        this.z = t1.getZ() - t2.getZ();
        this.w = t1.getW() - t2.getW();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @param valueZ the value to multiply the z component with
     * @param valueW the value to multiply the w component with
     * @return this
     */
    public Vector4d mul(double valueX, double valueY, double valueZ, double valueW) {
        this.x *= valueX;
        this.y *= valueY;
        this.z *= valueZ;
        this.w *= valueW;
        return this;
    }

    /**
     * Multiplies this with a scalar value
     * This is equivalent to calling scale(value).
     * @param value a scalar value
     * @return this
     */
    public Vector4d mul(double value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector4d scale(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        this.w *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector4d invert() {
        this.x *= -1;
        this.y *= -1;
        this.z *= -1;
        this.w *= -1;
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min(BaseVector4d other) {
        x = Math.min(x, other.getX());
        y = Math.min(y, other.getY());
        z = Math.min(z, other.getZ());
        w = Math.min(w, other.getW());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(BaseVector4d other) {
        x = Math.max(x, other.getX());
        y = Math.max(y, other.getY());
        z = Math.max(z, other.getZ());
        w = Math.max(w, other.getW());
    }

     /**
     * Set the length of this vector to one if and only if the length is greater then zero
     * else return a vector of length zero.
     *
     * @return this
     */
    public Vector4d safeNormalize() {
         final float EPSILON = 0.000001f;

        normalize();
        if(length() < EPSILON){
            x = 0;
            y = 0;
            z = 0;
            w = 0;
        }
        return this;
    }

     /**
      * Set the length of this vector to one
      *
      * @return this
      */
    public Vector4d normalize() {
        return scale(1 / length());
    }

}
