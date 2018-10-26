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
 * Vector4f is the mutable implementation of BaseVector4f, for representing points or vectors in 4 dimensional space of type
 * float.
 *
 * @author auto-generated
 */
public class Vector4f extends BaseVector4f {

    /**
     * Default constructor - all components are set to 0
     */
    public Vector4f() {
    }

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @param w the w component
     */
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor
     * @param other The BaseVector4f to copy.
     */
    public Vector4f(org.joml.Vector4f other) {
        this(other.x, other.y, other.z, other.w);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector4f one() {
        return new Vector4f(1, 1, 1, 1);
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
     * @param newX the new x coordinate
     * @return this Vector4f, to allow method chaining
     */
    public Vector4f setX(float newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector4f, to allow method chaining
     */
    public Vector4f setY(float newY) {
        this.y = newY;
        return this;
    }
    /**
     * @param newZ the new x coordinate
     * @return this Vector4f, to allow method chaining
     */
    public Vector4f setZ(float newZ) {
        this.z = newZ;
        return this;
    }
    /**
     * @param newW the new x coordinate
     * @return this Vector4f, to allow method chaining
     */
    public Vector4f setW(float newW) {
        this.w = newW;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector4f set(org.joml.Vector4f other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @param newZ the z component
     * @param newW the w component
     * @return this
     */
    public Vector4f set(float newX, float newY, float newZ, float newW) {
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
    public Vector4f addX(float value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector4f addY(float value) {
        this.y += value;
        return this;
    }
    /**
     * Adds to the z component
     *
     * @param value the value to add to z
     * @return this
     */
    public Vector4f addZ(float value) {
        this.z += value;
        return this;
    }
    /**
     * Adds to the w component
     *
     * @param value the value to add to w
     * @return this
     */
    public Vector4f addW(float value) {
        this.w += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector4f subX(float value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector4f subY(float value) {
        this.y -= value;
        return this;
    }
    /**
     * Subtracts from the z component
     *
     * @param value the value to subtract from z
     * @return this
     */
    public Vector4f subZ(float value) {
        this.z -= value;
        return this;
    }
    /**
     * Subtracts from the w component
     *
     * @param value the value to subtract from w
     * @return this
     */
    public Vector4f subW(float value) {
        this.w -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector4f mulX(float value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector4f mulY(float value) {
        this.y *= value;
        return this;
    }
    /**
     * Multiplies the z component
     *
     * @param value the value by which to multiply z
     * @return this
     */
    public Vector4f mulZ(float value) {
        this.z *= value;
        return this;
    }
    /**
     * Multiplies the w component
     *
     * @param value the value by which to multiply w
     * @return this
     */
    public Vector4f mulW(float value) {
        this.w *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector4f div(float value) {
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
    public Vector4f divX(float value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector4f divY(float value) {
        this.y /= value;
        return this;
    }
    /**
     * Divides the z component
     *
     * @param value the value by which to divide z
     * @return this
     */
    public Vector4f divZ(float value) {
        this.z /= value;
        return this;
    }
    /**
     * Divides the w component
     *
     * @param value the value by which to divide w
     * @return this
     */
    public Vector4f divW(float value) {
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
    public Vector4f add(float valueX, float valueY, float valueZ, float valueW) {
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
    public Vector4f add(org.joml.Vector4f other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        this.w += other.w;
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
    public Vector4f sub(float valueX, float valueY, float valueZ, float valueW) {
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
    public Vector4f sub(org.joml.Vector4f other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        this.w -= other.w;
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
    public Vector4f negate() {
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
    public final void sub(org.joml.Vector4f t1, org.joml.Vector4f t2) {
        this.x = t1.x - t2.x;
        this.y = t1.y - t2.y;
        this.z = t1.z - t2.z;
        this.w = t1.w - t2.w;
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
    public Vector4f mul(float valueX, float valueY, float valueZ, float valueW) {
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
    public Vector4f mul(float value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector4f scale(float value) {
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
    public Vector4f invert() {
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
    public void min(org.joml.Vector4f other) {
        x = Math.min(x, other.x);
        y = Math.min(y, other.y);
        z = Math.min(z, other.z);
        w = Math.min(w, other.w);
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(org.joml.Vector4f other) {
        x = Math.max(x, other.x);
        y = Math.max(y, other.y);
        z = Math.max(z, other.z);
        w = Math.max(w, other.w);
    }

     /**
     * Set the length of this vector to one if and only if the length is greater then zero
     * else return a vector of length zero.
     *
     * @return this
     */
    public Vector4f safeNormalize() {
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
    public Vector4f normalize() {
        return scale(1 / length());
    }

}
