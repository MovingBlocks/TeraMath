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

import com.google.common.base.Preconditions;

/**
 * A vector/point in 2D space
 * @author auto-generated
 */
public abstract class BaseVector2f extends org.joml.Vector2f{

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector2f ZERO = new ImmutableVector2f(0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector2f ONE = new ImmutableVector2f(1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract float getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract float getY(); 

    /**
      * @return x the x coordinate
      */
    public abstract float x(); 
    /**
      * @return y the y coordinate
      */
    public abstract float y(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector2f lerp(BaseVector2f a, BaseVector2f b, float t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        float x = a.getX() * (1 - t) + b.getX() * t; 
        float y = a.getY() * (1 - t) + b.getY() * t; 
        return new Vector2f(x, y);
    }
    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector2f other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY());
    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector2f project( BaseVector2f v)
    {
        return new Vector2f(v).mul(this.dot(v)/ (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public float lengthSquared() {
        return getX() * getX() + getY() * getY();
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector2f v1) {
      double vDot = this.dot(v1) / (this.length() * v1.length());

      if (vDot < -1.0) {
          vDot = -1.0;
      }

      if (vDot >  1.0) {
          vDot =  1.0;
      }

      return (float) Math.acos(vDot);
   }

    /**
     * @return the distance to the origin
     */
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public float distanceSquared(BaseVector2f other) {
        float dx = other.getX() - this.getX();
        float dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public float distance(BaseVector2f other) {
        return (float) Math.sqrt(distanceSquared(other));
    }


    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static float distance(BaseVector2f p1, BaseVector2f p2) {
        return p1.distance(p2);
    }

    /**
     * All point implementations with the same coordinate are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseVector2f) {
            BaseVector2f other = (BaseVector2f) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX())
                && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY());
        }
        return false;
    }

    /**
     * All point implementations with the same coordinate have the same hashcode
     */
    @Override
    public final int hashCode() {
        int result = 1;
        final int prime = 31;
        long temp;
        temp = Float.floatToIntBits(getX());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getY());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
