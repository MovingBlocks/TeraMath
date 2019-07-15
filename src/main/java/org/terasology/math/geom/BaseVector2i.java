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

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath;
import org.joml.Vector2ic;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * A vector/point in 2D space
 */
public abstract class BaseVector2i implements Vector2ic{

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
    public static Vector2i lerp(Vector2ic a, Vector2ic b, double t, RoundingMode mode) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.x() * (1 - t) + b.x() * t;
        double y = a.y() * (1 - t) + b.y() * t;

        return new Vector2i(
            DoubleMath.roundToInt(x, mode),
            DoubleMath.roundToInt(y, mode));
    }

    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector2i other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY());
    }


    /**
     * @return the squared distance to the origin
     */
    public long lengthSquared() {
        return getX() * getX() + getY() * getY();
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector2i v1) {
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

//    /**
//     * @param other the other point
//     * @return the distance in between
//     */
//    public int distanceSquared(Vector2ic other) {
//        int dx = other.x() - this.getX();
//        int dy = other.y() - this.getY();
//
//        return dx * dx + dy * dy;
//    }

    /**
     * @param other the other point
     * @return the distance in between
     */
//    public double distance(Vector2ic other) {
//        return Math.sqrt(distanceSquared(other));
//    }

    /**
     * @param other the other point
     * @return the grid distance in between (aka 1-Norm, Minkowski or Manhattan distance)
     */
    public int gridDistance(Vector2ic other) {
        return Math.abs(other.x() - getX()) + Math.abs(other.y() - getY());
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(Vector2ic p1, Vector2ic p2) {
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

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
       return new org.joml.Vector2i(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new org.joml.Vector2i(this).get(index,buffer);
    }

    @Override
    public IntBuffer get(IntBuffer buffer) {
        return new org.joml.Vector2i(this).get(buffer);
    }

    @Override
    public IntBuffer get(int index, IntBuffer buffer) {
        return new org.joml.Vector2i(this).get(index,buffer);
    }

    @Override
    public Vector2ic  getToAddress(long address) {
        return new org.joml.Vector2i(this).getToAddress(address);
    }

    @Override
    public org.joml.Vector2i mul(int scalar, org.joml.Vector2i dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       return dest;
    }

    @Override
    public org.joml.Vector2i mul(Vector2ic v, org.joml.Vector2i dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();

        return dest;
    }

    @Override
    public long distanceSquared(Vector2ic v) {
        return new org.joml.Vector2i(x(),y()).distanceSquared(v);
    }

    @Override
    public long distanceSquared(int X, int Y) {
        return new org.joml.Vector2i(x(),y()).distanceSquared(X,Y);
    }
    @Override
    public org.joml.Vector2i mul(int X, int Y, org.joml.Vector2i dest) {
        return new org.joml.Vector2i(X,Y).mul(dest);
    }

    @Override
    public  double distance(Vector2ic v) {
        return new org.joml.Vector2i(x(),y()).distance(v);
    }

    @Override
    public double distance(int X, int Y) {
       return new org.joml.Vector2i(x(),y()).distance(X,Y);
    }

    @Override
    public org.joml.Vector2i sub(Vector2ic v, org.joml.Vector2i dest) {
        return new org.joml.Vector2i(x(),y()).sub(v,dest);
    }


    @Override
    public org.joml.Vector2i sub(int X, int Y, org.joml.Vector2i dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        return dest;
    }


    @Override
    public org.joml.Vector2i add(Vector2ic v, org.joml.Vector2i dest) {
       return new org.joml.Vector2i(x(),y()).add(v,dest);
    }

    @Override
    public  org.joml.Vector2i add(int X, int Y,  org.joml.Vector2i dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        return dest;
    }

    @Override
    public org.joml.Vector2i negate(org.joml.Vector2i dest) {
        return new org.joml.Vector2i(x(),y()).negate(dest);
    }

    @Override
    public org.joml.Vector2i min(Vector2ic v, org.joml.Vector2i dest) {
       return new org.joml.Vector2i(x(),y()).min(v,dest);
    }

    @Override
    public org.joml.Vector2i max(Vector2ic v, org.joml.Vector2i dest) {
        return new org.joml.Vector2i(x(),y()).max(v,dest);
    }

    @Override
    public int get(int component) throws IllegalArgumentException {
       return new org.joml.Vector2i(x(),y()).get(component);
    }




}
