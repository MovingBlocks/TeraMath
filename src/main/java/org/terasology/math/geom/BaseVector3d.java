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
 * A vector/point in 3D space
 * @author auto-generated
 */
@Deprecated
public abstract class BaseVector3d extends org.joml.Vector3d {

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector3d ZERO = new ImmutableVector3d(0, 0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector3d ONE = new ImmutableVector3d(1, 1, 1);

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
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector3d lerp(BaseVector3d a, BaseVector3d b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1 - t) + b.getX() * t; 
        double y = a.getY() * (1 - t) + b.getY() * t; 
        double z = a.getZ() * (1 - t) + b.getZ() * t; 
        return new Vector3d(x, y, z);
    }
    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector3d other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ());
    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector3d project( BaseVector3d v)
    {
        return new Vector3d(v).mul(this.dot(v)/ (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public double lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ();
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector3d v1) {
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
    public double distanceSquared(BaseVector3d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();
        double dz = other.getZ() - this.getZ();

        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(BaseVector3d other) {
        return Math.sqrt(distanceSquared(other));
    }


    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(BaseVector3d p1, BaseVector3d p2) {
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
        if (obj instanceof BaseVector3d) {
            BaseVector3d other = (BaseVector3d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY())
                && Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(other.getZ());
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

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}
