/*
 * Copyright 2018 MovingBlocks
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

import java.math.RoundingMode;

/**
 * Vector3i is the mutable implementation of BaseVector3i, for representing points or vectors in 3 dimensional space of type
 * int.
 *
 * @author auto-generated
 */
@Deprecated
public class Vector3i extends BaseVector3i {

    /**
     * Default constructor - all components are set to 0
     */
    public Vector3i() {
    }

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3i to copy.
     */
    public Vector3i(BaseVector3i other) {
        this(other.getX(), other.getY(), other.getZ());
    }


    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public Vector3i(float x, float y, float z) {
        this(DoubleMath.roundToInt(x, RoundingMode.FLOOR),
            DoubleMath.roundToInt(y, RoundingMode.FLOOR),
            DoubleMath.roundToInt(z, RoundingMode.FLOOR));
    }

    /**
     * Constructs the integer version of a floating-point vector by flooring it
     * @param vector The vector to copy.
     */
    public Vector3i(BaseVector3f vector) {
        this(DoubleMath.roundToInt(vector.getX(), RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.getY(), RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.getZ(), RoundingMode.FLOOR));
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param rm the rounding mode
     */
    public Vector3i(BaseVector3f vector, RoundingMode rm) {
        this(DoubleMath.roundToInt(vector.getX(), rm), DoubleMath.roundToInt(vector.getY(), rm), DoubleMath.roundToInt(vector.getZ(), rm));
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param offset the offset to add to all components
     * @deprecated specify a rounding mode instead
     */
    @Deprecated
    public Vector3i(BaseVector3f vector, double offset) {
        this(DoubleMath.roundToInt(vector.getX() + offset, RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.getY() + offset, RoundingMode.FLOOR),
            DoubleMath.roundToInt(vector.getZ() + offset, RoundingMode.FLOOR));
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector3i one() {
        return new Vector3i(1, 1, 1);
    }

    public static Vector3i north() {
        return new Vector3i(0, 0, 1);
    }

    public static Vector3i south() {
        return new Vector3i(0, 0, -1);
    }

    public static Vector3i west() {
        return new Vector3i(1, 0, 0);
    }

    public static Vector3i east() {
        return new Vector3i(-1, 0, 0);
    }

    public static Vector3i up() {
        return new Vector3i(0, 1, 0);
    }

    public static Vector3i down() {
        return new Vector3i(0, -1, 0);
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
     * @param newX the new x coordinate
     * @return this Vector3i, to allow method chaining
     */
    public Vector3i setX(int newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector3i, to allow method chaining
     */
    public Vector3i setY(int newY) {
        this.y = newY;
        return this;
    }
    /**
     * @param newZ the new x coordinate
     * @return this Vector3i, to allow method chaining
     */
    public Vector3i setZ(int newZ) {
        this.z = newZ;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector3i set(BaseVector3i other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @param newZ the z component
     * @return this
     */
    public Vector3i set(int newX, int newY, int newZ) {
        this.x = newX;
        this.y = newY;
        this.z = newZ;
        return this;
    }

    /**
     * Adds to the x component
     *
     * @param value the value to add to x
     * @return this
     */
    public Vector3i addX(int value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector3i addY(int value) {
        this.y += value;
        return this;
    }
    /**
     * Adds to the z component
     *
     * @param value the value to add to z
     * @return this
     */
    public Vector3i addZ(int value) {
        this.z += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector3i subX(int value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector3i subY(int value) {
        this.y -= value;
        return this;
    }
    /**
     * Subtracts from the z component
     *
     * @param value the value to subtract from z
     * @return this
     */
    public Vector3i subZ(int value) {
        this.z -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector3i mulX(int value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector3i mulY(int value) {
        this.y *= value;
        return this;
    }
    /**
     * Multiplies the z component
     *
     * @param value the value by which to multiply z
     * @return this
     */
    public Vector3i mulZ(int value) {
        this.z *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector3i div(int value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    /**
     * Divides the x component
     *
     * @param value the value by which to divide x
     * @return this
     */
    public Vector3i divX(int value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector3i divY(int value) {
        this.y /= value;
        return this;
    }
    /**
     * Divides the z component
     *
     * @param value the value by which to divide z
     * @return this
     */
    public Vector3i divZ(int value) {
        this.z /= value;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param valueX the value to add to the x component
     * @param valueY the value to add to the y component
     * @param valueZ the value to add to the z component
     * @return this
     */
    public Vector3i add(int valueX, int valueY, int valueZ) {
        this.x += valueX;
        this.y += valueY;
        this.z += valueZ;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public Vector3i add(BaseVector3i other) {
        this.x += other.getX();
        this.y += other.getY();
        this.z += other.getZ();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the value to subtract from the x component
     * @param valueY the value to subtract from the y component
     * @param valueZ the value to subtract from the z component
     * @return this
     */
    public Vector3i sub(int valueX, int valueY, int valueZ) {
        this.x -= valueX;
        this.y -= valueY;
        this.z -= valueZ;
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public Vector3i sub(BaseVector3i other) {
        this.x -= other.getX();
        this.y -= other.getY();
        this.z -= other.getZ();
        return this;
    }

    /**
     *  Sets each component of this tuple to its absolute value.
     */
    public final void absolute() {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
        this.z = Math.abs(z);
    }

    /**
     * Negate each component
     * @return this
     */
    public Vector3i negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    /**
     * Sets the value of this vector to the vector difference
     * of vector t1 and t2 (this = t1 - t2).
     * @param t1 the first vector
     * @param t2 the second vector
     */
    public final void sub(BaseVector3i t1, BaseVector3i t2) {
        this.x = t1.getX() - t2.getX();
        this.y = t1.getY() - t2.getY();
        this.z = t1.getZ() - t2.getZ();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @param valueZ the value to multiply the z component with
     * @return this
     */
    public Vector3i mul(int valueX, int valueY, int valueZ) {
        this.x *= valueX;
        this.y *= valueY;
        this.z *= valueZ;
        return this;
    }

    /**
     * Multiplies this with a scalar value
     * This is equivalent to calling scale(value).
     * @param value a scalar value
     * @return this
     */
    public Vector3i mul(int value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector3i scale(int value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector3i invert() {
        this.x *= -1;
        this.y *= -1;
        this.z *= -1;
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min(BaseVector3i other) {
        x = Math.min(x, other.getX());
        y = Math.min(y, other.getY());
        z = Math.min(z, other.getZ());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(BaseVector3i other) {
        x = Math.max(x, other.getX());
        y = Math.max(y, other.getY());
        z = Math.max(z, other.getZ());
    }

    /**
     * Sets this vector to the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final Vector3i cross(BaseVector3i v1, BaseVector3i v2) {
        this.x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        this.y = v2.getX() * v1.getZ() - v2.getZ() * v1.getX();
        this.z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        return this;
    }



    /**
     * @return The equivalent Vector3f
     */
    public Vector3f toVector3f() {
        return new Vector3f(x, y, z);
    }

    /**
     * @return The equivalent Vector3d
     */
    public Vector3d toVector3d() {
        return new Vector3d(x, y, z);
    }

}
