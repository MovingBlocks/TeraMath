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
import org.joml.Matrix4fc;
import org.joml.Matrix4x3fc;
import org.joml.Quaternionfc;
import org.joml.Vector4fc;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * A vector/point in 4D space
 * @author auto-generated
 */
public abstract class BaseVector4f implements Vector4fc{

    /**
     * An immutable instance with all components set to 0
     */
    public static final ImmutableVector4f ZERO = new ImmutableVector4f(0, 0, 0, 0);

    /**
     * An immutable instance with all components set to 1
     */
    public static final ImmutableVector4f ONE = new ImmutableVector4f(1, 1, 1, 1);

    /**
      * @return x the x coordinate
      */
    public abstract float getX(); 
    /**
      * @return y the y coordinate
      */
    public abstract float getY(); 
    /**
      * @return z the z coordinate
      */
    public abstract float getZ(); 
    /**
      * @return w the w coordinate
      */
    public abstract float getW(); 

    /**
      * @return x the x coordinate
      */
    public abstract float x(); 
    /**
      * @return y the y coordinate
      */
    public abstract float y(); 
    /**
      * @return z the z coordinate
      */
    public abstract float z(); 
    /**
      * @return w the w coordinate
      */
    public abstract float w(); 

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector4f lerp(Vector4fc a, Vector4fc b, float t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        float x = a.x() * (1 - t) + b.x() * t;
        float y = a.y() * (1 - t) + b.y() * t;
        float z = a.z() * (1 - t) + b.z() * t;
        float w = a.w() * (1 - t) + b.w() * t;
        return new Vector4f(x, y, z, w);
    }
    /**
     * Returns the dot product of this vector and vector other.
     * @param other the other vector
     * @return the dot product of this and other
     */
//    public final float dot(Vector4fc other) {
//        return (float) (this.getX() * other.x() + this.getY() * other.y() + this.getZ() * other.z() + this.getW() * other.w());
//    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector4f project( Vector4fc v)
    {
        return new Vector4f(v).mul(this.dot(v)/ (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public float lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW();
    }
   /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
//   public final float angle(Vector4fc v1) {
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
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public float distanceSquared(BaseVector4f other) {
        float dx = other.getX() - this.getX();
        float dy = other.getY() - this.getY();
        float dz = other.getZ() - this.getZ();
        float dw = other.getW() - this.getW();

        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public float distance(BaseVector4f other) {
        return (float) Math.sqrt(distanceSquared(other));
    }


    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static float distance(BaseVector4f p1, BaseVector4f p2) {
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
        if (obj instanceof BaseVector4f) {
            BaseVector4f other = (BaseVector4f) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX())
                && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY())
                && Float.floatToIntBits(getZ()) == Float.floatToIntBits(other.getZ())
                && Float.floatToIntBits(getW()) == Float.floatToIntBits(other.getW());
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
        temp = Float.floatToIntBits(getZ());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getW());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ", " + getW() + ")";
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new Vector4f(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new Vector4f(this).get(index,buffer);
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return new Vector4f(this).get(buffer);
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return new Vector4f(this).get(buffer);
    }

    @Override
    public Vector4fc  getToAddress(long address) {
        return new Vector4f(this).getToAddress(address);
    }

    @Override
    public org.joml.Vector4f mul(float scalar, org.joml.Vector4f dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       dest.z = scalar * getZ();
       dest.w = scalar * getW();
       return dest;
    }

    @Override
    public org.joml.Vector4f mul(float x, float y, float z, float w, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).mul(x,y,z,w,dest);
    }

    @Override
    public org.joml.Vector4f div(float scalar, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).div(scalar,dest);
    }

    @Override
    public org.joml.Vector4f div(float x, float y, float z, float w, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).div(x,y,z,w,dest);
    }

    @Override
    public org.joml.Vector4f mul(Vector4fc v, org.joml.Vector4f dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();
        dest.z = v.z() * z();
        dest.w = v.w() * w();

        return dest;
    }

    @Override
    public float dot(Vector4fc v) {
        return x() * v.x() +y() * v.y() +z() * v.z() +w() * v.w() ;
    }

    @Override
    public float angle(Vector4fc v) {
        return new org.joml.Vector4f(this).angle(v);
    }

    @Override
    public org.joml.Vector4f normalize(org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).normalize(dest);
    }

    @Override
    public org.joml.Vector4f normalize(float length, org.joml.Vector4f dest) {
         return new org.joml.Vector4f(this).normalize(length,dest);
    }


    @Override
    public  float distance(Vector4fc v) {
        return new org.joml.Vector4f(this).distance(v);
    }

    @Override
    public float distance(float X, float Y, float Z, float W) {
       return new org.joml.Vector4f(this).distance(X,Y,Z,W);
    }


    @Override
    public org.joml.Vector4f sub(Vector4fc v, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).sub(v,dest);
    }


    @Override
    public org.joml.Vector4f sub(float X, float Y, float Z, float W, org.joml.Vector4f dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        dest.z = z() - Z;
        dest.w = w() - W;
        return dest;
    }


    @Override
    public org.joml.Vector4f add(Vector4fc v, org.joml.Vector4f dest) {
       return new org.joml.Vector4f(this).add(v,dest);
    }

    @Override
    public  org.joml.Vector4f add(float X, float Y, float Z, float W,  org.joml.Vector4f dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        dest.z = z() + Z;
        dest.w = w() + W;
        return dest;
    }

    @Override
    public org.joml.Vector4f negate(org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).negate(dest);
    }

    @Override
    public org.joml.Vector4f lerp(Vector4fc other, float t, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).lerp(other,t,dest);
    }
    @Override
    public org.joml.Vector4f fma(Vector4fc a, Vector4fc b, org.joml.Vector4f dest) {
       return new org.joml.Vector4f(this).fma(b,dest);
    }

    @Override
    public org.joml.Vector4f fma(float a, Vector4fc b, org.joml.Vector4f dest) {
      return new org.joml.Vector4f(this).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector4f min(Vector4fc v, org.joml.Vector4f dest) {
       return new org.joml.Vector4f(this).min(v,dest);
    }

    @Override
    public org.joml.Vector4f max(Vector4fc v, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).max(v,dest);
    }

    @Override
    public float get(int component) throws IllegalArgumentException {
       return new org.joml.Vector4f(this).get(component);
    }


    @Override
    public org.joml.Vector4f div(Vector4fc v, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).div(v,dest);
    }

    @Override
    public org.joml.Vector4f mul(Matrix4fc mat, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).mul(mat,dest);
    }

    @Override
    public org.joml.Vector4f mulAffine(Matrix4fc mat, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).mulAffine(mat,dest);
    }

    @Override
    public org.joml.Vector4f mul(Matrix4x3fc mat, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).mul(mat,dest);
    }

    @Override
    public org.joml.Vector4f mulProject(Matrix4fc mat, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).mulProject(mat,dest);
    }

    @Override
    public org.joml.Vector4f rotate(Quaternionfc quat, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).rotate(quat,dest);
    }

    @Override
    public org.joml.Vector4f rotateAxis(float angle, float aX, float aY, float aZ, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).rotateAxis(angle,aX,aY,aZ,dest);
    }

    @Override
    public org.joml.Vector4f rotateX(float angle, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).rotateX(angle,dest);
    }

    @Override
    public org.joml.Vector4f rotateY(float angle, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).rotateY(angle,dest);
    }

    @Override
    public org.joml.Vector4f rotateZ(float angle, org.joml.Vector4f dest) {
        return new org.joml.Vector4f(this).rotateZ(angle,dest);
    }

    @Override
    public float dot(float x, float y, float z, float w) {
        return x() * x + y() * y + z() * z + w() * w;
    }

    @Override
    public float angleCos(Vector4fc v) {
        return new Vector4f(this).angleCos(v);
    }

    @Override
    public org.joml.Vector4f smoothStep(Vector4fc v, float t, org.joml.Vector4f dest) {
        return new Vector4f(this).smoothStep(v,t,dest);
    }

    @Override
    public org.joml.Vector4f hermite(Vector4fc t0, Vector4fc v1, Vector4fc t1, float t, org.joml.Vector4f dest) {
        return new Vector4f(this).hermite(t0,v1,t1,t,dest);
    }


    @Override
    public boolean equals(Vector4fc v, float delta) {
        return new org.joml.Vector4f(v.x(),v.y(),v.z(),v.w()).equals(v,delta);
    }


}
