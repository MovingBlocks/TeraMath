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
import org.joml.Vector3ic;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * A vector/point in 3D space
 */
public abstract class BaseVector3i implements Vector3ic{

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
    public static Vector3i lerp(Vector3ic a, Vector3ic b, double t, RoundingMode mode) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.x() * (1 - t) + b.x() * t;
        double y = a.y() * (1 - t) + b.y() * t;
        double z = a.z() * (1 - t) + b.z() * t;

        return new Vector3i(
            DoubleMath.roundToInt(x, mode),
            DoubleMath.roundToInt(y, mode),
            DoubleMath.roundToInt(z, mode));
    }

//    /**
//     * Returns the dot product of this vector and vector other.
//     * @param other the other vector
//     * @return the dot product of this and other
//     */
    public final float dot(Vector3ic other) {
        return (float) (this.getX() * other.x() + this.getY() * other.y() + this.getZ() * other.z());
    }


    /**
     * @return the squared distance to the origin
     */
    public long lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ();
    }

   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final float angle(Vector3ic v1) {
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
//    public int distanceSquared(Vector3ic other) {
//        int dx = other.getX() - this.getX();
//        int dy = other.getY() - this.getY();
//        int dz = other.getZ() - this.getZ();
//
//        return dx * dx + dy * dy + dz * dz;
//    }

    /**
     * @param other the other point
     * @return the distance in between
     */
//    public double distance(Vector3ic other) {
//        return Math.sqrt(distanceSquared(other));
//    }

    /**
     * @param other the other point
     * @return the grid distance in between (aka 1-Norm, Minkowski or Manhattan distance)
     */
    public int gridDistance(Vector3ic other) {
        return Math.abs(other.x() - getX()) + Math.abs(other.y() - getY()) + Math.abs(other.z() - getZ());
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(Vector3ic p1, Vector3ic p2) {
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

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new org.joml.Vector3i(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new org.joml.Vector3i(this).get(index,buffer);
    }

    @Override
    public IntBuffer get(IntBuffer buffer) {
        return new org.joml.Vector3i(this).get(buffer);
    }

    @Override
    public IntBuffer get(int index, IntBuffer buffer) {
        return new org.joml.Vector3i(this).get(index,buffer);
    }

    @Override
    public Vector3ic  getToAddress(long address) {
        return new org.joml.Vector3i(this).getToAddress(address);
    }

    @Override
    public org.joml.Vector3i mul(int scalar, org.joml.Vector3i dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       dest.z = scalar * getZ();
       return dest;
    }

    @Override
    public org.joml.Vector3i mul(Vector3ic v, org.joml.Vector3i dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();
        dest.z = v.z() * z();

        return dest;
    }

    @Override
    public long distanceSquared(Vector3ic v) {
        return new org.joml.Vector3i(x(),y(),z()).distanceSquared(v);
    }

    @Override
    public long distanceSquared(int X, int Y, int Z) {
        return new org.joml.Vector3i(x(),y(),z()).distanceSquared(X,Y,Z);
    }
    @Override
    public org.joml.Vector3i mul(int X, int Y, int Z, org.joml.Vector3i dest) {
        return new org.joml.Vector3i(X,Y,Z).mul(dest);
    }

    @Override
    public  double distance(Vector3ic v) {
        return new org.joml.Vector3i(x(),y(),z()).distance(v);
    }

    @Override
    public double distance(int X, int Y, int Z) {
       return new org.joml.Vector3i(x(),y(),z()).distance(X,Y,Z);
    }

    @Override
    public org.joml.Vector3i sub(Vector3ic v, org.joml.Vector3i dest) {
        return new org.joml.Vector3i(x(),y(),z()).sub(v,dest);
    }


    @Override
    public org.joml.Vector3i sub(int X, int Y, int Z, org.joml.Vector3i dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        dest.z = z() - Z;
        return dest;
    }


    @Override
    public org.joml.Vector3i add(Vector3ic v, org.joml.Vector3i dest) {
       return new org.joml.Vector3i(x(),y(),z()).add(v,dest);
    }

    @Override
    public  org.joml.Vector3i add(int X, int Y, int Z,  org.joml.Vector3i dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        dest.z = z() + Z;
        return dest;
    }

    @Override
    public org.joml.Vector3i negate(org.joml.Vector3i dest) {
        return new org.joml.Vector3i(x(),y(),z()).negate(dest);
    }

    @Override
    public org.joml.Vector3i min(Vector3ic v, org.joml.Vector3i dest) {
       return new org.joml.Vector3i(x(),y(),z()).min(v,dest);
    }

    @Override
    public org.joml.Vector3i max(Vector3ic v, org.joml.Vector3i dest) {
        return new org.joml.Vector3i(x(),y(),z()).max(v,dest);
    }

    @Override
    public int get(int component) throws IllegalArgumentException {
       return new org.joml.Vector3i(x(),y(),z()).get(component);
    }




}
