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

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath;

import java.math.RoundingMode;

/**
 * A vector/point in 3D space
 * @author auto-generated
 */
@Deprecated
public abstract class BaseVector3i extends org.joml.Vector3i {

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector3i ZERO = new ImmutableVector3i(0, 0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector3i ONE = new ImmutableVector3i(1, 1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract int getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract int getY(); 
    /**
      * @return z the z coordinate
      */
    public abstract int getZ(); 

    /**
      * @return x the x coordinate
      */
    public abstract int x(); 
    /**
      * @return y the y coordinate
      */
    public abstract int y(); 
    /**
      * @return z the z coordinate
      */
    public abstract int z(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @param mode the rounding mode to use
     * @return the interpolated point
     */
    public static Vector3i lerp(BaseVector3i a, BaseVector3i b, double t, RoundingMode mode) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1 - t) + b.getX() * t; 
        double y = a.getY() * (1 - t) + b.getY() * t; 
        double z = a.getZ() * (1 - t) + b.getZ() * t; 

        return new Vector3i(
            DoubleMath.roundToInt(x, mode),
            DoubleMath.roundToInt(y, mode),
            DoubleMath.roundToInt(z, mode));
    }

    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector3i other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ());
    }


   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector3i v1) {
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
    public int distanceSquared(BaseVector3i other) {
        int dx = other.getX() - this.getX();
        int dy = other.getY() - this.getY();
        int dz = other.getZ() - this.getZ();

        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(BaseVector3i other) {
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * @param other the other point
     * @return the grid distance in between (aka 1-Norm, Minkowski or Manhattan distance)
     */
    public int gridDistance(BaseVector3i other) {
        return Math.abs(other.getX() - getX()) + Math.abs(other.getY() - getY()) + Math.abs(other.getZ() - getZ());
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(BaseVector3i p1, BaseVector3i p2) {
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
        if (obj instanceof BaseVector3i) {
            BaseVector3i other = (BaseVector3i) obj;
            return getX() == other.getX()
                && getY() == other.getY()
                && getZ() == other.getZ();
        }
        return false;
    }

    /**
     * All point implementations with the same coordinate have the same hashcode
     */
    @Override
    public final int hashCode() {
        int result = 1;
        final int prime = 1021;
        result = prime * result + getX();
        result = prime * result + getY();
        result = prime * result + getZ();
        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}
