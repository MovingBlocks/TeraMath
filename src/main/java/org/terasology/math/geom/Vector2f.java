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
 * Vector2f is the mutable implementation of BaseVector2f, for representing points or vectors in 2 dimensional space of type
 * float.
 *
 * @author auto-generated
 */
public class Vector2f extends BaseVector2f {

    /**
     * Default constructor - all components are set to 0
     */
    public Vector2f() {
    }

    /**
     * @param x the x component
     * @param y the y component
     */
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2f to copy.
     */
    public Vector2f(org.joml.Vector2f other) {
        this(other.x, other.y);
    }



    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector2f one() {
        return new Vector2f(1, 1);
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
     * @param newX the new x coordinate
     * @return this Vector2f, to allow method chaining
     */
    public Vector2f setX(float newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector2f, to allow method chaining
     */
    public Vector2f setY(float newY) {
        this.y = newY;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector2f set(BaseVector2f other) {
        this.x = other.getX();
        this.y = other.getY();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @return this
     */
    public Vector2f set(float newX, float newY) {
        this.x = newX;
        this.y = newY;
        return this;
    }

    /**
     * Adds to the x component
     *
     * @param value the value to add to x
     * @return this
     */
    public Vector2f addX(float value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector2f addY(float value) {
        this.y += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector2f subX(float value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector2f subY(float value) {
        this.y -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector2f mulX(float value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector2f mulY(float value) {
        this.y *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector2f div(float value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    /**
     * Divides the x component
     *
     * @param value the value by which to divide x
     * @return this
     */
    public Vector2f divX(float value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector2f divY(float value) {
        this.y /= value;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @return this
     */
    public Vector2f add(float valueX, float valueY) {
        this.x += valueX;
        this.y += valueY;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public Vector2f add(BaseVector2f other) {
        this.x += other.getX();
        this.y += other.getY();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @return this
     */
    public Vector2f sub(float valueX, float valueY) {
        this.x -= valueX;
        this.y -= valueY;
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public Vector2f sub(BaseVector2f other) {
        this.x -= other.getX();
        this.y -= other.getY();
        return this;
    }

    /**
     *  Sets each component of this tuple to its absolute value.
     */
    public final void absolute() {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
    }

    /**
     * Negate each component
     * @return this
     */
    public Vector2f negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    /**
     * Sets the value of this vector to the vector difference
     * of vector t1 and t2 (this = t1 - t2).
     * @param t1 the first vector
     * @param t2 the second vector
     */
    public final void sub(BaseVector2f t1, BaseVector2f t2) {
        this.x = t1.getX() - t2.getX();
        this.y = t1.getY() - t2.getY();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @return this
     */
    public Vector2f mul(float valueX, float valueY) {
        this.x *= valueX;
        this.y *= valueY;
        return this;
    }

    /**
     * Multiplies this with a scalar value
     * This is equivalent to calling scale(value).
     * @param value a scalar value
     * @return this
     */
    public Vector2f mul(float value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector2f scale(float value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector2f invert() {
        this.x *= -1;
        this.y *= -1;
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min(BaseVector2f other) {
        x = Math.min(x, other.getX());
        y = Math.min(y, other.getY());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(BaseVector2f other) {
        x = Math.max(x, other.getX());
        y = Math.max(y, other.getY());
    }

     /**
     * Set the length of this vector to one if and only if the length is greater then zero
     * else return a vector of length zero.
     *
     * @return this
     */
    public Vector2f safeNormalize() {
         final float EPSILON = 0.000001f;

        normalize();
        if(length() < EPSILON){
            x = 0;
            y = 0;
        }
        return this;
    }

     /**
      * Set the length of this vector to one
      *
      * @return this
      */
    public Vector2f normalize() {
        return scale(1 / length());
    }

}
