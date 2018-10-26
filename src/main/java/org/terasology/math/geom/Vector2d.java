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
 * Vector2d is the mutable implementation of BaseVector2d, for representing points or vectors in 2 dimensional space of type
 * double.
 *
 * @author auto-generated
 */
public class Vector2d extends BaseVector2d {
    /**
     * Default constructor - all components are set to 0
     */
    public Vector2d() {
    }

    /**
     * @param x the x component
     * @param y the y component
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2d to copy.
     */
    public Vector2d(org.joml.Vector2d other) {
        this(other.x, other.y);
    }



    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector2d one() {
        return new Vector2d(1, 1);
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
    public double x() {
        return x;
    }
    @Override
    public double y() {
        return y;
    }

    /**
     * @param newX the new x coordinate
     * @return this Vector2d, to allow method chaining
     */
    public Vector2d setX(double newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector2d, to allow method chaining
     */
    public Vector2d setY(double newY) {
        this.y = newY;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector2d set(org.joml.Vector2d other) {
        this.x = other.x();
        this.y = other.y();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @return this
     */
    public Vector2d set(double newX, double newY) {
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
    public Vector2d addX(double value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector2d addY(double value) {
        this.y += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector2d subX(double value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector2d subY(double value) {
        this.y -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector2d mulX(double value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector2d mulY(double value) {
        this.y *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector2d div(double value) {
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
    public Vector2d divX(double value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector2d divY(double value) {
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
    public Vector2d add(double valueX, double valueY) {
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
    public Vector2d add(BaseVector2d other) {
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
    public Vector2d sub(double valueX, double valueY) {
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
    public Vector2d sub(org.joml.Vector2d other) {
        this.x -= other.x();
        this.y -= other.y();
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
    public Vector2d negate() {
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
    public final void sub(org.joml.Vector2d t1, org.joml.Vector2d t2) {
        this.x = t1.x() - t2.x();
        this.y = t1.y() - t2.y();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @return this
     */
    public Vector2d mul(double valueX, double valueY) {
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
    public Vector2d mul(double value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector2d scale(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector2d invert() {
        this.x *= -1;
        this.y *= -1;
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min(org.joml.Vector2d other) {
        x = Math.min(x, other.x());
        y = Math.min(y, other.y());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(org.joml.Vector2d other) {
        x = Math.max(x, other.x());
        y = Math.max(y, other.y());
    }

     /**
     * Set the length of this vector to one if and only if the length is greater then zero
     * else return a vector of length zero.
     *
     * @return this
     */
    public Vector2d safeNormalize() {
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
    public Vector2d normalize() {
        return scale(1 / length());
    }

}
