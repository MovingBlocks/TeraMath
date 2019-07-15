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

import com.google.common.math.DoubleMath;
import org.joml.Vector2fc;
import org.joml.Vector2ic;

import java.math.RoundingMode;

/**
 * Vector2i is the mutable implementation of BaseVector2i, for representing points or vectors in 2 dimensional space of type
 * int.
 *
 */
public class Vector2i extends BaseVector2i {

    public int x;
    public int y;

    /**
     * Default constructor - all components are set to 0
     */
    public Vector2i() {
    }

    /**
     * @param x the x component
     * @param y the y component
     */
    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The BaseVector2i to copy.
     */
    public Vector2i(Vector2ic other) {
        this(other.x(), other.y());
    }


    /**
     * @param x the x component
     * @param y the y component
     */
    public Vector2i(float x, float y) {
        this(DoubleMath.roundToInt(x, RoundingMode.FLOOR),
            DoubleMath.roundToInt(y, RoundingMode.FLOOR));
    }

    /**
     * Constructs the integer version of a floating-point vector by flooring it
     * @param vector The vector to copy.
     */
    public Vector2i(Vector2fc vector) {
        this(DoubleMath.roundToInt(vector.x(), RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.y(), RoundingMode.FLOOR));
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param rm the rounding mode
     */
    public Vector2i(Vector2fc vector, RoundingMode rm) {
        this(DoubleMath.roundToInt(vector.x(), rm), DoubleMath.roundToInt(vector.y(), rm));
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param offset the offset to add to all components
     * @deprecated specify a rounding mode instead
     */
    @Deprecated
    public Vector2i(BaseVector2f vector, double offset) {
        this(DoubleMath.roundToInt(vector.getX() + offset, RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.getY() + offset, RoundingMode.FLOOR));
    }

    /**
     * A new vector with all entries explicitly set to zero
     */
    public static Vector2i zero() {
        return new Vector2i(0, 0);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector2i one() {
        return new Vector2i(1, 1);
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
     * @param newX the new x coordinate
     * @return this Vector2i, to allow method chaining
     */
    public Vector2i setX(int newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector2i, to allow method chaining
     */
    public Vector2i setY(int newY) {
        this.y = newY;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector2i set(Vector2ic other) {
        this.x = other.x();
        this.y = other.y();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @return this
     */
    public Vector2i set(int newX, int newY) {
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
    public Vector2i addX(int value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector2i addY(int value) {
        this.y += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector2i subX(int value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector2i subY(int value) {
        this.y -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector2i mulX(int value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector2i mulY(int value) {
        this.y *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector2i div(int value) {
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
    public Vector2i divX(int value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector2i divY(int value) {
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
    public Vector2i add(int valueX, int valueY) {
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
    public Vector2i add(Vector2ic other) {
        this.x += other.x();
        this.y += other.y();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @return this
     */
    public Vector2i sub(int valueX, int valueY) {
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
    public Vector2i sub(Vector2ic other) {
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
    public Vector2i negate() {
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
    public final void sub(Vector2ic t1, BaseVector2i t2) {
        this.x = t1.x() - t2.getX();
        this.y = t1.y() - t2.getY();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @return this
     */
    public Vector2i mul(int valueX, int valueY) {
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
    public Vector2i mul(int value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector2i scale(int value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector2i invert() {
        this.x *= -1;
        this.y *= -1;
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min(Vector2ic other) {
        x = Math.min(x, other.x());
        y = Math.min(y, other.y());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(Vector2ic other) {
        x = Math.max(x, other.x());
        y = Math.max(y, other.y());
    }

    /**
     * @return The equivalent Vector2f
     */
    public Vector2f toVector2f() {
        return new Vector2f(x, y);
    }

    /**
     * @return The equivalent Vector2d
     */
    public Vector2d toVector2d() {
        return new Vector2d(x, y);
    }

}
