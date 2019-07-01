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
import org.joml.Matrix3x2fc;
import org.joml.Vector2fc;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * A vector/point in 2D space
 * @author auto-generated
 */
public abstract class BaseVector2f implements Vector2fc{

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
    public static Vector2f lerp(Vector2fc a, Vector2fc b, float t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        float x = a.x() * (1 - t) + b.x() * t;
        float y = a.y() * (1 - t) + b.y() * t;
        return new Vector2f(x, y);
    }
//    /**
//     * Returns the dot product of this vector and vector other.
//     * @param other the other vector
//     * @return the dot product of this and other
//     */
//    public final float dot(Vector2fc other) {
//        return (float) (this.getX() * other.getX() + this.getY() * other.getY());
//    }


    /**
    * Returns the current vector projected onto v
    * @param v other vector to project onto
    *
    */
    public final Vector2f project( Vector2fc v)
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
//   public final float angle(Vector2fc v1) {
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

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new org.joml.Vector2f(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new org.joml.Vector2f(this).get(index,buffer);
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return new org.joml.Vector2f(this).get(buffer);
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return new org.joml.Vector2f(this).get(index,buffer);
    }

    @Override
    public Vector2fc  getToAddress(long address) {
        return new org.joml.Vector2f(this).getToAddress(address);
    }

    @Override
    public org.joml.Vector2f mul(float scalar, org.joml.Vector2f dest) {
       dest.x = scalar * getX();
       dest.y = scalar * getY();
       return dest;
    }

    @Override
    public org.joml.Vector2f mul(Vector2fc v, org.joml.Vector2f dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();

        return dest;
    }

    @Override
    public float dot(Vector2fc v) {
        return x() * v.x() +y() * v.y() ;
    }

    @Override
    public float angle(Vector2fc v) {
        return new org.joml.Vector2f(x(),y()).angle(v);
    }

    @Override
    public org.joml.Vector2f normalize(org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).normalize(dest);
    }

    @Override
    public org.joml.Vector2f normalize(float length, org.joml.Vector2f dest) {
         return new org.joml.Vector2f(x(),y()).normalize(length,dest);
    }

    @Override
    public org.joml.Vector2f mul(float X, float Y, org.joml.Vector2f dest) {
        return new org.joml.Vector2f(X,Y).mul(dest);
    }


    @Override
    public  float distance(Vector2fc v) {
        return new org.joml.Vector2f(x(),y()).distance(v);
    }

    @Override
    public float distance(float X, float Y) {
       return new org.joml.Vector2f(x(),y()).distance(X,Y);
    }


    @Override
    public org.joml.Vector2f sub(Vector2fc v, org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).sub(v,dest);
    }


    @Override
    public org.joml.Vector2f sub(float X, float Y, org.joml.Vector2f dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        return dest;
    }


    @Override
    public org.joml.Vector2f add(Vector2fc v, org.joml.Vector2f dest) {
       return new org.joml.Vector2f(x(),y()).add(v,dest);
    }

    @Override
    public  org.joml.Vector2f add(float X, float Y,  org.joml.Vector2f dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        return dest;
    }

    @Override
    public org.joml.Vector2f negate(org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).negate(dest);
    }

    @Override
    public org.joml.Vector2f mulPosition(Matrix3x2fc mat, org.joml.Vector2f dest) {
         return new org.joml.Vector2f(x(),y()).mulPosition(mat,dest);
    }

    @Override
    public org.joml.Vector2f mulDirection(Matrix3x2fc mat, org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).mulDirection(mat,dest);
    }

    @Override
    public org.joml.Vector2f lerp(Vector2fc other, float t, org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).lerp(other,t,dest);
    }
    @Override
    public org.joml.Vector2f fma(Vector2fc a, Vector2fc b, org.joml.Vector2f dest) {
       return new org.joml.Vector2f(x(),y()).fma(b,dest);
    }

    @Override
    public org.joml.Vector2f fma(float a, Vector2fc b, org.joml.Vector2f dest) {
      return new org.joml.Vector2f(x(),y()).fma(a,b,dest);
    }

    @Override
    public org.joml.Vector2f min(Vector2fc v, org.joml.Vector2f dest) {
       return new org.joml.Vector2f(x(),y()).min(v,dest);
    }

    @Override
    public org.joml.Vector2f max(Vector2fc v, org.joml.Vector2f dest) {
        return new org.joml.Vector2f(x(),y()).max(v,dest);
    }

    @Override
    public float get(int component) throws IllegalArgumentException {
       return new org.joml.Vector2f(x(),y()).get(component);
    }

    @Override
    public float distanceSquared(Vector2fc v) {
        return new Vector2f(this).distanceSquared(v);
    }

    @Override
    public float distanceSquared(float x, float y) {
        return new Vector2f(this).distanceSquared(x,y);
    }

    @Override
    public boolean equals(Vector2fc v, float delta) {
        return new org.joml.Vector2f(v.x(),v.y()).equals(v,delta);
    }


}
