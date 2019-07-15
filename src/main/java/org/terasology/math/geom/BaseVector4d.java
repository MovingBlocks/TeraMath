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
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.Quaterniondc;
import org.joml.Vector4dc;
import org.joml.Vector4fc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * A vector/point in 4D space
 */
public abstract class BaseVector4d implements Vector4dc {

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
    public static Vector4d lerp(Vector4dc a, Vector4dc b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.x() * (1 - t) + b.x() * t;
        double y = a.y() * (1 - t) + b.y() * t;
        double z = a.z() * (1 - t) + b.z() * t;
        double w = a.w() * (1 - t) + b.w() * t;
        return new Vector4d(x, y, z, w);
    }

    /**
     * Returns the dot product of this vector and vector other.
     *
     * @param other the other vector
     * @return the dot product of this and other
     */
//    public final float dot(Vector4dc other) {
//        return (float) (this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ() + this.getW() * other.getW());
//    }


    /**
     * Returns the current vector projected onto v
     *
     * @param v other vector to project onto
     */
    public final Vector4d project(Vector4dc v) {
        return new Vector4d(v).mul(this.dot(v) / (v.lengthSquared()));
    }

    /**
     * @return the squared distance to the origin
     */
    public double lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW();
    }

    /**
     * Returns the angle in radians between this vector and the vector
     * parameter; the return value is constrained to the range [0,PI].
     *
     * @param v1 the other vector
     * @return the angle in radians in the range [0,PI]
     */
//    public final float angle(Vector4dc v1) {
//        double vDot = this.dot(v1) / (this.length() * v1.length());
//
//        if (vDot < -1.0) {
//            vDot = -1.0;
//        }
//
//        if (vDot > 1.0) {
//            vDot = 1.0;
//        }
//
//        return (float) Math.acos(vDot);
//    }

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
    public double distanceSquared(Vector4dc other) {
        double dx = other.x() - this.getX();
        double dy = other.y() - this.getY();
        double dz = other.z() - this.getZ();
        double dw = other.w() - this.getW();

        return dx * dx + dy * dy + dz * dz + dw * dw;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
//    public double distance(Vector4dc other) {
//        return Math.sqrt(distanceSquared(other));
//    }


    /**
     * Computes the distance between two points
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(Vector4dc p1, Vector4dc p2) {
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

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new org.joml.Vector4d(this).get(buffer)
;    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
       return new org.joml.Vector4d(this).get(index,buffer);
    }

    @Override
    public DoubleBuffer get(DoubleBuffer buffer) {
       return new org.joml.Vector4d(this).get(buffer);
    }

    @Override
    public DoubleBuffer get(int index, DoubleBuffer buffer) {
       return new org.joml.Vector4d(this).get(index,buffer);
    }

    @Override
    public Vector4dc getToAddress(long address) {
       return new org.joml.Vector4d(this).getToAddress(address);
    }

    @Override
    public org.joml.Vector4d mul(double scalar, org.joml.Vector4d dest) {
        dest.x = scalar * getX();
        dest.y = scalar * getY();
        dest.z = scalar * getZ();
        dest.w = scalar * getW();
        return dest;
    }

    @Override
    public org.joml.Vector4d div(double scalar, org.joml.Vector4d dest) {
       return new org.joml.Vector4d(this).div(scalar,dest);
    }

    @Override
    public org.joml.Vector4d mul(Vector4dc v, org.joml.Vector4d dest) {
        dest.x = v.x() * x();
        dest.y = v.y() * y();
        dest.z = v.z() * z();
        dest.w = v.w() * w();

        return dest;
    }

    @Override
    public org.joml.Vector4d mul(Vector4fc v, org.joml.Vector4d dest) {
       return new org.joml.Vector4d(this).mul(v,dest);
    }

    @Override
    public double dot(Vector4dc v) {
        return x() * v.x() + y() * v.y() + z() * v.z() + w() * v.w();
    }

    @Override
    public double angle(Vector4dc v) {
        return new org.joml.Vector4d(x(), y(), z(), w()).angle(v);
    }

    @Override
    public org.joml.Vector4d normalize(org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).normalize(dest);
    }

    @Override
    public org.joml.Vector4d normalize(double length, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).normalize(length, dest);
    }

    @Override
    public org.joml.Vector4d normalize3(org.joml.Vector4d dest) {
       return new org.joml.Vector4d(this).normalize3(dest);
    }


    @Override
    public double distance(Vector4dc v) {
        return new org.joml.Vector4d(x(), y(), z(), w()).distance(v);
    }

    @Override
    public double distance(double X, double Y, double Z, double W) {
        return new org.joml.Vector4d(x(), y(), z(), w()).distance(X, Y, Z, W);
    }


    @Override
    public org.joml.Vector4d sub(Vector4fc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).sub(v, dest);
    }

    @Override
    public org.joml.Vector4d sub(Vector4dc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).sub(v, dest);
    }


    @Override
    public org.joml.Vector4d sub(double X, double Y, double Z, double W, org.joml.Vector4d dest) {
        dest.x = x() - X;
        dest.y = y() - Y;
        dest.z = z() - Z;
        dest.w = w() - W;
        return dest;
    }


    @Override
    public org.joml.Vector4d add(Vector4fc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).add(v, dest);
    }

    @Override
    public org.joml.Vector4d add(Vector4dc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).add(v, dest);
    }

    @Override
    public org.joml.Vector4d add(double X, double Y, double Z, double W, org.joml.Vector4d dest) {
        dest.x = x() + X;
        dest.y = y() + Y;
        dest.z = z() + Z;
        dest.w = w() + W;
        return dest;
    }

    @Override
    public org.joml.Vector4d negate(org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).negate(dest);
    }

    @Override
    public org.joml.Vector4d lerp(Vector4dc other, double t, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).lerp(other, t, dest);
    }

    @Override
    public org.joml.Vector4d fma(Vector4dc a, Vector4dc b, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).fma(b, dest);
    }

    @Override
    public org.joml.Vector4d fma(double a, Vector4dc b, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).fma(a, b, dest);
    }

    @Override
    public org.joml.Vector4d min(Vector4dc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).min(v, dest);
    }

    @Override
    public org.joml.Vector4d max(Vector4dc v, org.joml.Vector4d dest) {
        return new org.joml.Vector4d(x(), y(), z(), w()).max(v, dest);
    }

    @Override
    public double get(int component) throws IllegalArgumentException {
        return new org.joml.Vector4d(x(), y(), z(), w()).get(component);
    }


    @Override
    public org.joml.Vector4d div(Vector4dc v, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).div(v, dest);
    }

    @Override
    public org.joml.Vector4d mul(Matrix4dc mat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).mul(mat, dest);
    }

    @Override
    public org.joml.Vector4d mul(Matrix4x3dc mat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).mul(mat, dest);
    }

    @Override
    public org.joml.Vector4d mul(Matrix4x3fc mat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).mul(mat, dest);
    }

    @Override
    public org.joml.Vector4d mul(Matrix4fc mat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).mul(mat, dest);
    }

    @Override
    public org.joml.Vector4d mulProject(Matrix4dc mat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).mulProject(mat, dest);
    }

    @Override
    public org.joml.Vector4d rotate(Quaterniondc quat, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).rotate(quat, dest);
    }

    @Override
    public org.joml.Vector4d rotateAxis(double angle, double aX, double aY, double aZ, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).rotateAxis(angle, aX, aY, aZ, dest);
    }

    @Override
    public org.joml.Vector4d rotateX(double angle, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).rotateX(angle, dest);
    }

    @Override
    public org.joml.Vector4d rotateY(double angle, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).rotateY(angle, dest);
    }

    @Override
    public org.joml.Vector4d rotateZ(double angle, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).rotateZ(angle, dest);
    }

    @Override
    public double dot(double x, double y, double z, double w) {
        return x() * x + y() * y + z() * z + w() * w;
    }

    @Override
    public double angleCos(Vector4dc v) {
        return new Vector4d(x(), y(), z(), w()).angleCos(v);
    }

    @Override
    public org.joml.Vector4d smoothStep(Vector4dc v, double t, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).smoothStep(v, t, dest);
    }

    @Override
    public org.joml.Vector4d hermite(Vector4dc t0, Vector4dc v1, Vector4dc t1, double t, org.joml.Vector4d dest) {
        return new Vector4d(x(), y(), z(), w()).hermite(t0, v1, t1, t, dest);
    }


    @Override
    public boolean equals(Vector4dc v, double delta) {
        return new org.joml.Vector4d(v.x(), v.y(), v.z(), v.w()).equals(v, delta);
    }

}
