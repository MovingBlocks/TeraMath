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

import org.joml.Vector3fc;

/**
 * Vector3f is the mutable implementation of BaseVector3f, for representing points or vectors in 3 dimensional space of type
 * float.
 *
 */
public class Vector3f extends BaseVector3f {

    public float x;
    public float y;
    public float z;

    /**
     * Default constructor - all components are set to 0
     */
    public Vector3f() {
    }

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The BaseVector3f to copy.
     */
    public Vector3f(Vector3fc other) {
        this(other.x(), other.y(), other.z());
    }


    /**
     * A new vector with all entries explicitly set to zero
     */
    public static Vector3f zero() {
        return new Vector3f(0, 0, 0);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static Vector3f one() {
        return new Vector3f(1, 1, 1);
    }

    public static Vector3f north() {
        return new Vector3f(0, 0, 1);
    }

    public static Vector3f south() {
        return new Vector3f(0, 0, -1);
    }

    public static Vector3f west() {
        return new Vector3f(1, 0, 0);
    }

    public static Vector3f east() {
        return new Vector3f(-1, 0, 0);
    }

    public static Vector3f up() {
        return new Vector3f(0, 1, 0);
    }

    public static Vector3f down() {
        return new Vector3f(0, -1, 0);
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

    /**
     * @param newX the new x coordinate
     * @return this Vector3f, to allow method chaining
     */
    public Vector3f setX(float newX) {
        this.x = newX;
        return this;
    }
    /**
     * @param newY the new x coordinate
     * @return this Vector3f, to allow method chaining
     */
    public Vector3f setY(float newY) {
        this.y = newY;
        return this;
    }
    /**
     * @param newZ the new x coordinate
     * @return this Vector3f, to allow method chaining
     */
    public Vector3f setZ(float newZ) {
        this.z = newZ;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector3f set(BaseVector3f other) {
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
    public Vector3f set(float newX, float newY, float newZ) {
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
    public Vector3f addX(float value) {
        this.x += value;
        return this;
    }
    /**
     * Adds to the y component
     *
     * @param value the value to add to y
     * @return this
     */
    public Vector3f addY(float value) {
        this.y += value;
        return this;
    }
    /**
     * Adds to the z component
     *
     * @param value the value to add to z
     * @return this
     */
    public Vector3f addZ(float value) {
        this.z += value;
        return this;
    }

    /**
     * Subtracts from the x component
     *
     * @param value the value to subtract from x
     * @return this
     */
    public Vector3f subX(float value) {
        this.x -= value;
        return this;
    }
    /**
     * Subtracts from the y component
     *
     * @param value the value to subtract from y
     * @return this
     */
    public Vector3f subY(float value) {
        this.y -= value;
        return this;
    }
    /**
     * Subtracts from the z component
     *
     * @param value the value to subtract from z
     * @return this
     */
    public Vector3f subZ(float value) {
        this.z -= value;
        return this;
    }

    /**
     * Multiplies the x component
     *
     * @param value the value by which to multiply x
     * @return this
     */
    public Vector3f mulX(float value) {
        this.x *= value;
        return this;
    }
    /**
     * Multiplies the y component
     *
     * @param value the value by which to multiply y
     * @return this
     */
    public Vector3f mulY(float value) {
        this.y *= value;
        return this;
    }
    /**
     * Multiplies the z component
     *
     * @param value the value by which to multiply z
     * @return this
     */
    public Vector3f mulZ(float value) {
        this.z *= value;
        return this;
    }

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public Vector3f div(float value) {
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
    public Vector3f divX(float value) {
        this.x /= value;
        return this;
    }
    /**
     * Divides the y component
     *
     * @param value the value by which to divide y
     * @return this
     */
    public Vector3f divY(float value) {
        this.y /= value;
        return this;
    }
    /**
     * Divides the z component
     *
     * @param value the value by which to divide z
     * @return this
     */
    public Vector3f divZ(float value) {
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
    public Vector3f add(float valueX, float valueY, float valueZ) {
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
    public Vector3f add(BaseVector3f other) {
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
    public Vector3f sub(float valueX, float valueY, float valueZ) {
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
    public Vector3f sub(BaseVector3f other) {
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
    public Vector3f negate() {
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
    public final void sub(BaseVector3f t1, BaseVector3f t2) {
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
    public Vector3f mul(float valueX, float valueY, float valueZ) {
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
    public Vector3f mul(float value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public Vector3f scale(float value) {
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
    public Vector3f invert() {
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
    public void min(BaseVector3f other) {
        x = Math.min(x, other.getX());
        y = Math.min(y, other.getY());
        z = Math.min(z, other.getZ());
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max(BaseVector3f other) {
        x = Math.max(x, other.getX());
        y = Math.max(y, other.getY());
        z = Math.max(z, other.getZ());
    }

    /**
     * Sets this vector to the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final Vector3f cross(BaseVector3f v1, BaseVector3f v2) {
        this.x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        this.y = v2.getX() * v1.getZ() - v2.getZ() * v1.getX();
        this.z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        return this;
    }



    /**
     * @return The reflection of direction against normal
     */
    public final Vector3f reflect(Vector3f direction, Vector3f normal) {
        set(normal);
        scale(-2.0f * direction.dot(normal));
        add(direction);
        return this;
    }

   /**
    * @return the portion of the diriction that is parallel to the normal
    */
   public final Vector3f parallelComponent(Vector3f direction, Vector3f normal) {
       set(normal);
       scale(direction.dot(normal));
       return this;
   }

   /**
    * @return the portion of direction that is perpendicular to normal
    */
   public final Vector3f perpendicularComponent(Vector3f direction, Vector3f normal) {
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
    public Vector3f safeNormalize() {
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
    public Vector3f normalize() {
        return scale(1 / length());
    }

}
