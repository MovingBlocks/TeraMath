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
 * A vector/point in 4D space
 * @author auto-generated
 */
@Deprecated
public abstract class BaseVector4d extends org.joml.Vector4d {

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector4d ZERO = new ImmutableVector4d(0, 0, 0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector4d ONE = new ImmutableVector4d(1, 1, 1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract double getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract double getY(); 
    /**
      * @return z the z coordinate
      */
    public abstract double getZ(); 
    /**
      * @return w the w coordinate
      */
    public abstract double getW(); 

    /**
      * @return x the x coordinate
      */
    public abstract double x(); 
    /**
      * @return y the y coordinate
      */
    public abstract double y(); 
    /**
      * @return z the z coordinate
      */
    public abstract double z(); 
    /**
      * @return w the w coordinate
      */
    public abstract double w(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector4d lerp(BaseVector4d a, BaseVector4d b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1 - t) + b.getX() * t; 
        double y = a.getY() * (1 - t) + b.getY() * t; 
        double z = a.getZ() * (1 - t) + b.getZ() * t; 
        double w = a.getW() * (1 - t) + b.getW() * t; 
        return new Vector4d(x, y, z, w);
    }
    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector4d other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ() + this.getW() * other.getW());
    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector4d project( BaseVector4d v)
    {
        return new Vector4d(v).mul(this.dot(v)/ (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public double lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW();
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector4d v1) {
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
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distanceSquared(BaseVector4d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();
        double dz = other.getZ() - this.getZ();
        double dw = other.getW() - this.getW();

        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(BaseVector4d other) {
        return Math.sqrt(distanceSquared(other));
    }


    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(BaseVector4d p1, BaseVector4d p2) {
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
        if (obj instanceof BaseVector4d) {
            BaseVector4d other = (BaseVector4d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY())
                && Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(other.getZ())
                && Double.doubleToLongBits(getW()) == Double.doubleToLongBits(other.getW());
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
        temp = Double.doubleToLongBits(getX());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getZ());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getW());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ", " + getW() + ")";
    }
}
