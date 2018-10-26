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
 * A vector/point in 2D space
 * @author auto-generated
 */
public abstract class BaseVector2i extends org.joml.Vector2i{

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector2i ZERO = new ImmutableVector2i(0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector2i ONE = new ImmutableVector2i(1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract int getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract int getY(); 

    /**
      * @return x the x coordinate
      */
    public abstract int x(); 
    /**
      * @return y the y coordinate
      */
    public abstract int y(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @param mode the rounding mode to use
     * @return the interpolated point
     */
    public static Vector2i lerp(BaseVector2i a, BaseVector2i b, double t, RoundingMode mode) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1 - t) + b.getX() * t; 
        double y = a.getY() * (1 - t) + b.getY() * t; 

        return new Vector2i(
            DoubleMath.roundToInt(x, mode),
            DoubleMath.roundToInt(y, mode));
    }

    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(org.joml.Vector2i other) {
        return (float) (this.getX() * other.x + this.getY() * other.y);
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(org.joml.Vector2i v1) {
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
    public int distanceSquared(org.joml.Vector2i other) {
        int dx = other.x - this.getX();
        int dy = other.y - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(org.joml.Vector2i other) {
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * @param other the other point
     * @return the grid distance in between (aka 1-Norm, Minkowski or Manhattan distance)
     */
    public int gridDistance(org.joml.Vector2i other) {
        return Math.abs(other.x - getX()) + Math.abs(other.y - getY());
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(org.joml.Vector2i p1, org.joml.Vector2i p2) {
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
        if (obj instanceof BaseVector2i) {
            BaseVector2i other = (BaseVector2i) obj;
            return getX() == other.getX()
                && getY() == other.getY();
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
        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
