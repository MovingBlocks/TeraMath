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
import org.joml.Matrix3dc;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2dc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * A vector/point in 3D space
 * @author auto-generated
 */
public abstract class BaseVector3d implements Vector3dc{

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
    public static Vector3d lerp(Vector3dc a, Vector3dc b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.x() * (1 - t) + b.x() * t;
        double y = a.y() * (1 - t) + b.y() * t;
        double z = a.z() * (1 - t) + b.z() * t;
        return new Vector3d(x, y, z);
    }
//    /**
//     * Returns the dot product of this vector and vector other.
//     * @param other the other vector
//     * @return the dot product of this and other
//     */
//    public final float dot(Vector3dc other) {
//        return (float) (this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ());
//    }


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
//   public final float angle(Vector3dc v1) {
//      double vDot = this.dot(v1) / (this.length() * v1.length());
//
//      if (vDot < -1.0) {
//          vDot = -1.0;
//      }
//
//      if (vDot >  1.0) {
//          vDot =  1.0;
//      }
//
//      return (float) Math.acos(vDot);
//   }

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
//    public double distanceSquared(Vector3dc other) {
//        double dx = other.x() - this.getX();
//        double dy = other.y() - this.getY();
//        double dz = other.z() - this.getZ();
//
//        return dx * dx + dy * dy + dz * dz;
//    }

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
    public static double distance(Vector3dc p1, Vector3dc p2) {
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
        if (obj instanceof Vector3dc) {
            Vector3dc other = (Vector3dc) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.x())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.y())
                && Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(other.z());
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
    public Vector3dc  getToAddress(long address) {
        return null;
    }

    @Override
    public org.joml.Vector3d mul(double scalar, org.joml.Vector3d dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       dest.z = scalar * getZ();
       return dest;
    }

    @Override
    public org.joml.Vector3d mul(Vector3dc v, org.joml.Vector3d dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();
        dest.z = v.z() * z();

        return dest;
    }

    @Override
    public org.joml.Vector3d div(Vector3fc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).div(dest);
    }

    @Override
    public org.joml.Vector3d div(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).div(v,dest);
    }

    @Override
    public double dot(Vector3dc v) {
        return x() * v.x() +y() * v.y() +z() * v.z() ;
    }

    @Override
    public double dot(double x, double y, double z) {
        return 0;
    }

    @Override
    public double angleCos(Vector3dc v) {
        return 0;
    }

    @Override
    public double angle(Vector3dc v) {
        return new org.joml.Vector3d(x(),y(),z()).angle(v);
    }

    @Override
    public org.joml.Vector3d normalize(org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).normalize(dest);
    }

    @Override
    public org.joml.Vector3d normalize(double length, org.joml.Vector3d dest) {
         return new org.joml.Vector3d(x(),y(),z()).normalize(length,dest);
    }

    @Override
    public org.joml.Vector3d mul(double X, double Y, double Z, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(X,Y,Z).mul(dest);
    }


    @Override
    public  double distance(Vector3dc v) {
        return new org.joml.Vector3d(x(),y(),z()).distance(v);
    }

    @Override
    public double distance(double X, double Y, double Z) {
       return new org.joml.Vector3d(x(),y(),z()).distance(X,Y,Z);
    }

    @Override
    public double distanceSquared(Vector3dc v) {
        return new org.joml.Vector3d(x(),y(),z()).distanceSquared(v);
    }

    @Override
    public double distanceSquared(double x, double y, double z) {
        return new org.joml.Vector3d(x(),y(),z()).distanceSquared(x,y,z);
    }


    @Override
    public org.joml.Vector3d sub(Vector3fc v, org.joml.Vector3d dest) {
          return new org.joml.Vector3d(x(),y(),z()).sub(v,dest);
    }

    @Override
    public org.joml.Vector3d sub(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).sub(v,dest);
    }


    @Override
    public org.joml.Vector3d sub(double X, double Y, double Z, org.joml.Vector3d dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        dest.z = z() - Z;
        return dest;
    }


    @Override
    public org.joml.Vector3d add(Vector3fc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).add(v,dest);
    }

    @Override
    public org.joml.Vector3d add(Vector3dc v, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).add(v,dest);
    }

    @Override
    public  org.joml.Vector3d add(double X, double Y, double Z,  org.joml.Vector3d dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        dest.z = z() + Z;
        return dest;
    }

    @Override
    public org.joml.Vector3d negate(org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).negate(dest);
    }

    @Override
    public org.joml.Vector3d absolute(org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).absolute(dest);
    }

    @Override
    public org.joml.Vector3d reflect(Vector3dc normal, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).reflect(normal,dest);
    }

    @Override
    public org.joml.Vector3d reflect(double x, double y, double z, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).reflect(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3d half(Vector3dc other, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).half(other,dest);
    }

    @Override
    public org.joml.Vector3d half(double x, double y, double z, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).half(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3d lerp(Vector3dc other, double t, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).lerp(other,t,dest);
    }
    @Override
    public org.joml.Vector3d fma(Vector3dc a, Vector3dc b, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector3d fma(double a, Vector3dc b, org.joml.Vector3d dest) {
      return new org.joml.Vector3d(x(),y(),z()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector3d fma(Vector3dc a, Vector3fc b, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector3d fma(Vector3fc a, Vector3fc b, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector3d fma(double a, Vector3fc b, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector3d mul(Vector3fc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mul(v,dest);
    }

    @Override
    public org.joml.Vector3d min(Vector3dc v, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).min(v,dest);
    }

    @Override
    public org.joml.Vector3d max(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).max(v,dest);
    }

    @Override
    public double get(int component) throws IllegalArgumentException {
       return new org.joml.Vector3d(x(),y(),z()).get(component);
    }

    @Override
    public org.joml.Vector3d mulProject(Matrix4dc mat, org.joml.Vector3d dest) {
          return new org.joml.Vector3d(x(),y(),z()).mulProject(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulProject(Matrix4fc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulProject(mat,dest);
    }

    @Override
    public org.joml.Vector3d mul(Matrix3dc mat, org.joml.Vector3d dest) {
      return new org.joml.Vector3d(x(),y(),z()).mul(mat,dest);
    }

    @Override
    public org.joml.Vector3d mul(Matrix3fc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mul(mat,dest);
    }
    @Override
    public org.joml.Vector3d mul(Matrix3x2dc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mul(mat,dest);
    }

    @Override
    public org.joml.Vector3d mul(Matrix3x2fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mul(mat,dest);
    }
    @Override
    public org.joml.Vector3d mulTranspose(Matrix3dc mat, org.joml.Vector3d dest) {
     return new org.joml.Vector3d(x(),y(),z()).mulTranspose(mat,dest);
    }
    @Override
    public org.joml.Vector3d mulTranspose(Matrix3fc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulTranspose(mat,dest);
    }
    @Override
    public org.joml.Vector3d mulPosition(Matrix4dc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulPosition(mat,dest);
    }
    @Override
    public org.joml.Vector3d mulPosition(Matrix4fc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulPosition(mat,dest);
    }
    @Override
    public org.joml.Vector3d mulPosition(Matrix4x3dc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulPosition(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulPosition(Matrix4x3fc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulPosition(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulTransposePosition(Matrix4dc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulTransposePosition(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulTransposePosition(Matrix4fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulTransposePosition(mat,dest);
    }

    @Override
    public double mulPositionW(Matrix4fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulPositionW(mat,dest);
    }
    @Override
    public double mulPositionW(Matrix4dc mat, org.joml.Vector3d dest) {
      return new org.joml.Vector3d(x(),y(),z()).mulPositionW(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulDirection(Matrix4dc mat, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulDirection(Matrix4fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulDirection(Matrix4x3dc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulDirection(Matrix4x3fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulTransposeDirection(Matrix4dc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulTransposeDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d mulTransposeDirection(Matrix4fc mat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).mulTransposeDirection(mat,dest);
    }

    @Override
    public org.joml.Vector3d rotate(Quaterniondc quat, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotate(quat,dest);
    }

    @Override
    public Quaterniond rotationTo(Vector3dc toDir, Quaterniond dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotationTo(toDir,dest);
    }

    @Override
    public Quaterniond rotationTo(double toDirX, double toDirY, double toDirZ, Quaterniond dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotationTo(toDirX,toDirY,toDirZ,dest);
    }

    @Override
    public org.joml.Vector3d rotateAxis(double angle, double aX, double aY, double aZ, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotateAxis(angle,aX,aY,aZ,dest);
    }

    @Override
    public org.joml.Vector3d rotateX(double angle, org.joml.Vector3d dest) {
         return new org.joml.Vector3d(x(),y(),z()).rotateX(angle,dest);
    }

    @Override
    public org.joml.Vector3d rotateY(double angle, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotateY(angle,dest);
    }

    @Override
    public org.joml.Vector3d rotateZ(double angle, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).rotateZ(angle,dest);
    }

    @Override
    public org.joml.Vector3d div(double scalar, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).div(scalar,dest);
    }

    @Override
    public org.joml.Vector3d div(double x, double y, double z, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).div(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3d cross(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).cross(v,dest);
    }

    @Override
    public org.joml.Vector3d cross(double x, double y, double z, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).cross(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3d smoothStep(Vector3dc v, double t, org.joml.Vector3d dest) {
       return new org.joml.Vector3d(x(),y(),z()).smoothStep(v,t,dest);
    }

    @Override
    public org.joml.Vector3d hermite(Vector3dc t0, Vector3dc v1, Vector3dc t1, double t, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).hermite(t0,v1,t1,t,dest);
    }

    @Override
    public int maxComponent() {
        return new org.joml.Vector3d(x(),y(),z()).maxComponent();
    }

    @Override
    public int minComponent() {
        return new org.joml.Vector3d(x(),y(),z()).minComponent();
    }

    @Override
    public org.joml.Vector3d orthogonalize(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).orthogonalize(v,dest);
    }

    @Override
    public org.joml.Vector3d orthogonalizeUnit(Vector3dc v, org.joml.Vector3d dest) {
        return new org.joml.Vector3d(x(),y(),z()).orthogonalizeUnit(v,dest);
    }


    @Override
    public boolean equals(Vector3dc v, double delta) {
        return new org.joml.Vector3d(v.x(),v.y(),v.z()).equals(v,delta);
    }


}
