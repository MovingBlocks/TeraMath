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
import org.joml.Matrix3x2dc;
import org.joml.Vector2dc;
import org.joml.Vector2fc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * A vector/point in 2D space
 * @author auto-generated
 */
public abstract class BaseVector2d implements Vector2dc{

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector2d ZERO = new ImmutableVector2d(0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector2d ONE = new ImmutableVector2d(1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract double getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract double getY(); 

    /**
      * @return x the x coordinate
      */
    public abstract double x(); 
    /**
      * @return y the y coordinate
      */
    public abstract double y(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector2d lerp(Vector2dc a, Vector2dc b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.x() * (1 - t) + b.x() * t;
        double y = a.y() * (1 - t) + b.y() * t;
        return new Vector2d(x, y);
    }
    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
    public final float dot(BaseVector2d other) {
        return (float) (this.getX() * other.getX() + this.getY() * other.getY());
    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector2d project( Vector2dc v)
    {
        return new Vector2d(v).mul(this.dot(v)/ (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public double lengthSquared() {
        return getX() * getX() + getY() * getY();
    }
   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(BaseVector2d v1) {
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
    public double distanceSquared(BaseVector2d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(BaseVector2d other) {
        return Math.sqrt(distanceSquared(other));
    }


    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(BaseVector2d p1, BaseVector2d p2) {
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
        if (obj instanceof BaseVector2d) {
            BaseVector2d other = (BaseVector2d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY());
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

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return null;
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return null;
    }

    @Override
    public DoubleBuffer get(DoubleBuffer buffer) {
        return null;
    }

    @Override
    public DoubleBuffer get(int index, DoubleBuffer buffer) {
        return null;
    }

    @Override
    public Vector2dc  getToAddress(long address) {
        return null;
    }

    @Override
    public org.joml.Vector2d mul(double scalar, org.joml.Vector2d dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       return dest;
    }

    @Override
    public org.joml.Vector2d mul(Vector2dc v, org.joml.Vector2d dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();

        return dest;
    }

    @Override
    public double dot(Vector2dc v) {
        return x() * v.x() +y() * v.y() ;
    }

    @Override
    public double angle(Vector2dc v) {
        return new org.joml.Vector2d(this).angle(v);
    }

    @Override
    public org.joml.Vector2d normalize(org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).normalize(dest);
    }

    @Override
    public org.joml.Vector2d normalize(double length, org.joml.Vector2d dest) {
         return new org.joml.Vector2d(this).normalize(length,dest);
    }

    @Override
    public org.joml.Vector2d mul(double X, double Y, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(X,Y).mul(dest);
    }

    @Override
    public  double distance(Vector2fc v) {
        return new org.joml.Vector2d(this).distance(v);
    }

    @Override
    public  double distance(Vector2dc v) {
        return new org.joml.Vector2d(this).distance(v);
    }

    @Override
    public double distance(double X, double Y) {
       return new org.joml.Vector2d(this).distance(X,Y);
    }


    @Override
    public org.joml.Vector2d sub(Vector2fc v, org.joml.Vector2d dest) {
          return new org.joml.Vector2d(this).sub(v,dest);
    }

    @Override
    public org.joml.Vector2d sub(Vector2dc v, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).sub(v,dest);
    }


    @Override
    public org.joml.Vector2d sub(double X, double Y, org.joml.Vector2d dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        return dest;
    }


    @Override
    public org.joml.Vector2d add(Vector2fc v, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).add(v,dest);
    }

    @Override
    public org.joml.Vector2d add(Vector2dc v, org.joml.Vector2d dest) {
       return new org.joml.Vector2d(this).add(v,dest);
    }

    @Override
    public  org.joml.Vector2d add(double X, double Y,  org.joml.Vector2d dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        return dest;
    }

    @Override
    public org.joml.Vector2d negate(org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).negate(dest);
    }

    @Override
    public org.joml.Vector2d mulPosition(Matrix3x2dc mat, org.joml.Vector2d dest) {
         return new org.joml.Vector2d(this).mulPosition(mat,dest);
    }

    @Override
    public org.joml.Vector2d mulDirection(Matrix3x2dc mat, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector2d lerp(Vector2dc other, double t, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).lerp(other,t,dest);
    }
    @Override
    public org.joml.Vector2d fma(Vector2dc a, Vector2dc b, org.joml.Vector2d dest) {
       return new org.joml.Vector2d(this).fma(b,dest);
    }

    @Override
    public org.joml.Vector2d fma(double a, Vector2dc b, org.joml.Vector2d dest) {
      return new org.joml.Vector2d(this).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector2d min(Vector2dc v, org.joml.Vector2d dest) {
       return new org.joml.Vector2d(this).min(v,dest);
    }

    @Override
    public org.joml.Vector2d max(Vector2dc v, org.joml.Vector2d dest) {
        return new org.joml.Vector2d(this).max(v,dest);
    }

    @Override
    public double get(int component) throws IllegalArgumentException {
       return new org.joml.Vector2d(this).get(component);
    }



    @Override
    public boolean equals(Vector2dc v, double delta) {
        return new org.joml.Vector2d(v.x(),v.y()).equals(v,delta);
    }


}
