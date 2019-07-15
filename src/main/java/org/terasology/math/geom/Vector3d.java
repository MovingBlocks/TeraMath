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

import org.joml.Vector3dc;

/**
 * Vector3d is the mutable implementation of BaseVector3d, for representing points or vectors in 3 dimensional space of type
 * double.
 *
 */
public class Vector3d extends BaseVector3d {

    public double x;
    public double y;
    public double z;

    /**
     * Default constructor - all components are set to 0
     */
    public Vector3d() {
    }

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3d to copy.
     */
    public Vector3d(BaseVector3d other) {
        this(other.getX(), other.getY(), other.getZ());
    }


    /**
     * A new vector with all entries explicitly set to zero
     */
    public static Vector3d zero() {
        return new Vector3d(0, 0, 0);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector3d one() {
        return new Vector3d(1, 1, 1);
    }

    public static Vector3d north() {
        return new Vector3d(0, 0, 1);
    }

    public static Vector3d south() {
        return new Vector3d(0, 0, -1);
    }

    public static Vector3d west() {
        return new Vector3d(1, 0, 0);
    }

    public static Vector3d east() {
        return new Vector3d(-1, 0, 0);
    }

    public static Vector3d up() {
        return new Vector3d(0, 1, 0);
    }

    public static Vector3d down() {
        return new Vector3d(0, -1, 0);
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
     * @param newX the new x coordinate
     * @return this Vector3d, to allow method chaining
     */
    public Vector3d setX(double newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector3d, to allow method chaining
     */
    public Vector3d setY(double newY) {
        this.y = newY;
        return this;
    }
    /**
     * @param newZ the new x coordinate
     * @return this Vector3d, to allow method chaining
     */
    public Vector3d setZ(double newZ) {
        this.z = newZ;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector3d set(Vector3dc other) {
        this.x = other.x();
        this.y = other.y();
        this.z = other.z();
        return this;
    }

    /**
     * @param newX the x component
     * @param newY the y component
     * @param newZ the z component
     * @return this
     */
    public Vector3d set(double newX, double newY, double newZ) {
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
    public Vector3d addX(double value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector3d addY(double value) {
        this.y += value;
        return this;
    }
    /**
     * Adds to the z component
     *
     * @param value the value to add to z
     * @return this
     */
    public Vector3d addZ(double value) {
        this.z += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector3d subX(double value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector3d subY(double value) {
        this.y -= value;
        return this;
    }
    /**
     * Subtracts from the z component
     *
     * @param value the value to subtract from z
     * @return this
     */
    public Vector3d subZ(double value) {
        this.z -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector3d mulX(double value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector3d mulY(double value) {
        this.y *= value;
        return this;
    }
    /**
     * Multiplies the z component
     *
     * @param value the value by which to multiply z
     * @return this
     */
    public Vector3d mulZ(double value) {
        this.z *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector3d div(double value) {
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
    public Vector3d divX(double value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector3d divY(double value) {
        this.y /= value;
        return this;
    }
    /**
     * Divides the z component
     *
     * @param value the value by which to divide z
     * @return this
     */
    public Vector3d divZ(double value) {
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
    public Vector3d add(double valueX, double valueY, double valueZ) {
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
    public Vector3d add(Vector3dc other) {
        this.x += other.x();
        this.y += other.y();
        this.z += other.z();
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
    public Vector3d sub(double valueX, double valueY, double valueZ) {
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
    public Vector3d sub(Vector3dc other) {
        this.x -= other.x();
        this.y -= other.y();
        this.z -= other.z();
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
    public Vector3d negate() {
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
    public final void sub(Vector3dc t1, BaseVector3d t2) {
        this.x = t1.x() - t2.x();
        this.y = t1.y() - t2.y();
        this.z = t1.z() - t2.z();
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     * @param valueX the value to multiply the x component with
     * @param valueY the value to multiply the y component with
     * @param valueZ the value to multiply the z component with
     * @return this
     */
    public Vector3d mul(double valueX, double valueY, double valueZ) {
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
    public Vector3d mul(double value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector3d scale(double value) {
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
    public Vector3d invert() {
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
    public void min(Vector3dc other) {
        x = Math.min(x, other.x());
        y = Math.min(y, other.y());
        z = Math.min(z, other.z());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(Vector3dc other) {
        x = Math.max(x, other.x());
        y = Math.max(y, other.y());
        z = Math.max(z, other.z());
    }

    /**
     * Sets this vector to the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final Vector3d cross(Vector3dc v1, BaseVector3d v2) {
        this.x = v1.y() * v2.z() - v1.z() * v2.y();
        this.y = v2.x() * v1.z() - v2.z() * v1.x();
        this.z = v1.x() * v2.y() - v1.y() * v2.x();
        return this;
    }



    /**
     * @return The reflection of direction against normal
     */
    public final Vector3d reflect(Vector3d direction, BaseVector3d normal) {
        set(normal);
        scale(-2.0f * direction.dot(normal));
        add(direction);
        return this;
    }

   /**
    * @return the portion of the diriction that is parallel to the normal
    */
   public final Vector3d parallelComponent(Vector3d direction, BaseVector3d normal) {
       set(normal);
       scale(direction.dot(normal));
       return this;
   }

   /**
    * @return the portion of direction that is perpendicular to normal
    */
   public final Vector3d perpendicularComponent(Vector3d direction, BaseVector3d normal) {
       parallelComponent(direction, normal);
       scale(-1);
       add(direction);
       return this;
   }



     /**
     * Set the length of this vector to one if and only if the length is greater then zero
     * else return a vector of length zero.
     *
     * @return this
     */
    public Vector3d safeNormalize() {
         final float EPSILON = 0.000001f;

        normalize();
        if(length() < EPSILON){
            x = 0;
            y = 0;
            z = 0;
        }
        return this;
    }

     /**
      * Set the length of this vector to one
      *
      * @return this
      */
    public Vector3d normalize() {
        return scale(1 / length());
    }

}
