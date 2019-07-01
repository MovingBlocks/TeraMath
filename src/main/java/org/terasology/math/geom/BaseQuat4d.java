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

import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.Vector4dc;

/**
 * A 4-element quaternion represented by double precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public abstract class BaseQuat4d implements Quaterniondc {

    /**
     * The immutable identity quaternion
     */
    public static final ImmutableQuat4d IDENTITY = new ImmutableQuat4d(0, 0, 0, 1);

    protected static final double EPS = 1.0e-12d;

    /**
     * As defined by BulletGlobals
     */
    protected static final float FLT_EPSILON = 1.1920929E-7f;

    /**
     * @return the x component
     */
    public abstract double getX();

    /**
     * @return the y component
     */
    public abstract double getY();

    /**
     * @return the z component
     */
    public abstract double getZ();

    /**
     * @return the w component
     */
    public abstract double getW();

    /**
     * @return the rotation angle
     */
    public double getAngle() {
        return Math.acos(getW()) * 2.0;
    }

    /**
     * @return the Euler yaw angle (heading)
     */
    public double getYaw() {
        return Math.atan2(2.0 * (getW() * getY() + getZ() * getX()),
                1.0 - 2.0 * (getX() * getX() + getY() * getY()));
    }

    /**
     * @return the Euler pitch angle (attitude)
     */
    public double getPitch() {
        return Math.asin(2.0 * (getW() * getX() - getY() * getZ()));
    }

    /**
     * @return the Euler roll angle (bank)
     */
    public double getRoll() {
        return Math.atan2(2.0 * (getW() * getZ() + getX() * getY()),
                1.0 - 2.0 * (getZ() * getZ() + getX() * getX()));
    }

    /**
     * @return a copy of the axis components
     */
    public Vector3d getAxis() {
        return new Vector3d(getX(), getY(), getZ());
    }

    public Vector3d rotate(Vector3d v) {
        return rotate(v, new Vector3d());
    }

    public Vector3d rotate(Vector3d v, Vector3d out) {
        Quat4d q = new Quat4d(this);
        q.mul(v);

        Quat4d tmp = new Quat4d();
        tmp.inverse(this);
        q.mul(tmp);

        out.set(q.x, q.y, q.z);
        return out;
    }

    /**
     * Performs a great circle interpolation between quaternion q1
     * and quaternion q2 and places the result into this quaternion.
     * @param q1  the first quaternion
     * @param q2  the second quaternion
     * @param alpha  the alpha interpolation parameter
     * @return the interpolated quaternion
     */
    public static final Quat4d interpolate(Quaterniond q1, Quaterniond q2, double alpha) {
        // From "Advanced Animation and Rendering Techniques"
        // by Watt and Watt pg. 364, function as implemented appeared to be
        // incorrect.  Fails to choose the same quaternion for the double
        // covering. Resulting in change of direction for rotations.

        double dot = q2.x() * q1.x() + q2.y() * q1.y() + q2.z() * q1.z() + q2.w() * q1.w();

        double q1x;
        double q1Y;
        double q1Z;
        double q1W;

        // Negate the first quaternion in the case that the
        // dot product of q1 and this is negative.
        if (dot < 0) {
            q1x = -q1.x();
            q1Y = -q1.y();
            q1Z = -q1.z();
            q1W = -q1.w();
            dot = -dot;
        } else {
            q1x = q1.x();
            q1Y = q1.y();
            q1Z = q1.z();
            q1W = q1.w();
        }

        double s1;
        double s2;

        if ((1.0d - dot) > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = Math.sin((1.0 - alpha) * om) / sinom;
            s2 = Math.sin(alpha * om) / sinom;
        } else {
            s1 = 1.0d - alpha;
            s2 = alpha;
        }

        double w = s1 * q1W + s2 * q2.w();
        double x = s1 * q1x + s2 * q2.x();
        double y = s1 * q1Y + s2 * q2.y();
        double z = s1 * q1Z + s2 * q2.z();

        return new Quat4d(x, y, z, w);
    }

    /**
     * All implementations with the same coordinates are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseQuat4d) {
            BaseQuat4d other = (BaseQuat4d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY())
                && Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(other.getZ())
                && Double.doubleToLongBits(getW()) == Double.doubleToLongBits(other.getW());
        }
        return false;
    }

    /**
     * All implementations with the same coordinates have the same hash code
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
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
    public double x() {
        return getX();
    }

    @Override
    public double y() {
        return getY();
    }

    @Override
    public double z() {
        return getZ();
    }

    @Override
    public double w() {
        return getW();
    }

    @Override
    public Quaterniond normalize(Quaterniond dest) {
        return new Quaterniond(this).normalize(dest);
    }

    @Override
    public Quaterniond add(double x, double y, double z, double w, Quaterniond dest) {
        return new Quaterniond(this).add(x,y,z,w,dest);
    }

    @Override
    public Quaterniond add(Quaterniondc q2, Quaterniond dest) {
        return new Quaterniond(this).add(q2,dest);
    }

    @Override
    public double dot(Quaterniondc otherQuat) {
        return new Quaterniond(this).dot(otherQuat);
    }

    @Override
    public double angle() {
        return new Quaterniond(this).angle();
    }

    @Override
    public org.joml.Matrix3d get(org.joml.Matrix3d dest) {
         return new Quaterniond(this).get(dest);
    }

    @Override
    public org.joml.Matrix3f get(org.joml.Matrix3f dest) {
         return new Quaterniond(this).get(dest);
    }

    @Override
    public org.joml.Matrix4d get(org.joml.Matrix4d dest) {
         return new Quaterniond(this).get(dest);
    }

    @Override
    public org.joml.Matrix4f get(org.joml.Matrix4f dest) {
         return new Quaterniond(this).get(dest);
    }

    @Override
    public Quaterniond get(Quaterniond dest) {
         return new Quaterniond(this).get(dest);
    }

    @Override
    public Quaterniond mul(Quaterniondc q, Quaterniond dest) {
         return new Quaterniond(this).mul(q,dest);
    }

    @Override
    public Quaterniond mul(double qx, double qy, double qz, double qw, Quaterniond dest) {
         return new Quaterniond(this).mul(qx,qy,qz,qw,dest);
    }

    @Override
    public Quaterniond premul(Quaterniondc q, Quaterniond dest) {
         return new Quaterniond(this).premul(q,dest);
    }

    @Override
    public Quaterniond premul(double qx, double qy, double qz, double qw, Quaterniond dest) {
         return new Quaterniond(this).premul(qx,qy,qz,qw,dest);
    }

    @Override
    public org.joml.Vector3d transform(org.joml.Vector3d vec) {
         return new Quaterniond(this).transform(vec);
    }

    @Override
    public org.joml.Vector3d transformPositiveX(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformPositiveX(dest);
    }

    @Override
    public org.joml.Vector4d transformPositiveX(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformPositiveX(dest);
    }

    @Override
    public org.joml.Vector3d transformUnitPositiveX(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformUnitPositiveX(dest);
    }

    @Override
    public org.joml.Vector4d transformUnitPositiveX(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformUnitPositiveX(dest);
    }

    @Override
    public org.joml.Vector3d transformPositiveY(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformPositiveY(dest);
    }

    @Override
    public org.joml.Vector4d transformPositiveY(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformPositiveY(dest);
    }

    @Override
    public org.joml.Vector3d transformUnitPositiveY(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformUnitPositiveY(dest);
    }

    @Override
    public org.joml.Vector4d transformUnitPositiveY(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformUnitPositiveY(dest);
    }

    @Override
    public org.joml.Vector3d transformPositiveZ(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4d transformPositiveZ(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformPositiveZ(dest);
    }

    @Override
    public org.joml.Vector3d transformUnitPositiveZ(org.joml.Vector3d dest) {
         return new Quaterniond(this).transformUnitPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4d transformUnitPositiveZ(org.joml.Vector4d dest) {
         return new Quaterniond(this).transformUnitPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4d transform(org.joml.Vector4d vec) {
         return new Quaterniond(this).transform(vec);
    }

    @Override
    public org.joml.Vector3d transform(Vector3dc vec, org.joml.Vector3d dest) {
         return new Quaterniond(this).transform(vec,dest);
    }

    @Override
    public org.joml.Vector3d transform(double x, double y, double z, org.joml.Vector3d dest) {
         return new Quaterniond(this).transform(x,y,z,dest);
    }

    @Override
    public org.joml.Vector4d transform(Vector4dc vec, org.joml.Vector4d dest) {
         return new Quaterniond(this).transform(vec,dest);
    }

    @Override
    public org.joml.Vector4d transform(double x, double y, double z, org.joml.Vector4d dest) {
         return new Quaterniond(this).transform(x,y,z,dest);
    }

    @Override
    public Quaterniond invert(Quaterniond dest) {
         return new Quaterniond(this).invert(dest);
    }

    @Override
    public Quaterniond div(Quaterniondc b, Quaterniond dest) {
         return new Quaterniond(this).div(b,dest);
    }

    @Override
    public Quaterniond conjugate(Quaterniond dest) {
         return new Quaterniond(this).conjugate(dest);
    }

    @Override
    public double lengthSquared() {
        return new Quaterniond(this).lengthSquared();
    }

    @Override
    public Quaterniond slerp(Quaterniondc target, double alpha, Quaterniond dest) {
         return new Quaterniond(this).slerp(target,alpha,dest);
    }

    @Override
    public Quaterniond scale(double factor, Quaterniond dest) {
         return new Quaterniond(this).scale(factor,dest);
    }

    @Override
    public Quaterniond integrate(double dt, double vx, double vy, double vz, Quaterniond dest) {
         return new Quaterniond(this).integrate(dt,vx,vy,vz,dest);
    }

    @Override
    public Quaterniond nlerp(Quaterniondc q, double factor, Quaterniond dest) {
         return new Quaterniond(this).nlerp(q,factor,dest);
    }

    @Override
    public Quaterniond nlerpIterative(Quaterniondc q, double alpha, double dotThreshold, Quaterniond dest) {
         return new Quaterniond(this).nlerpIterative(q,alpha,dotThreshold,dest);
    }

    @Override
    public Quaterniond lookAlong(Vector3dc dir, Vector3dc up, Quaterniond dest) {
         return new Quaterniond(this).lookAlong(dir,up,dest);
    }

    @Override
    public Quaterniond lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Quaterniond dest) {
         return new Quaterniond(this).lookAlong(dirX,dirY,dirZ,upX,upY,upZ,dest);
    }

    @Override
    public Quaterniond difference(Quaterniondc other, Quaterniond dest) {
         return new Quaterniond(this).difference(other,dest);
    }

    @Override
    public Quaterniond rotateTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ, Quaterniond dest) {
         return new Quaterniond(this).rotateTo(fromDirX,fromDirY,fromDirZ,toDirX,toDirY,toDirZ,dest);
    }

    @Override
    public Quaterniond rotateTo(Vector3dc fromDir, Vector3dc toDir, Quaterniond dest) {
         return new Quaterniond(this).rotateTo(fromDir,toDir,dest);
    }

    @Override
    public Quaterniond rotateX(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateX(angle,dest);
    }

    @Override
    public Quaterniond rotateY(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateY(angle,dest);
    }

    @Override
    public Quaterniond rotateZ(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateZ(angle,dest);
    }

    @Override
    public Quaterniond rotateLocalX(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateLocalX(angle,dest);
    }

    @Override
    public Quaterniond rotateLocalY(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateLocalY(angle,dest);
    }

    @Override
    public Quaterniond rotateLocalZ(double angle, Quaterniond dest) {
         return new Quaterniond(this).rotateLocalZ(angle,dest);
    }

    @Override
    public Quaterniond rotateXYZ(double angleX, double angleY, double angleZ, Quaterniond dest) {
         return new Quaterniond(this).rotateXYZ(angleX,angleY,angleZ,dest);
    }

    @Override
    public Quaterniond rotateZYX(double angleZ, double angleY, double angleX, Quaterniond dest) {
         return new Quaterniond(this).rotateZYX(angleZ,angleY,angleX,dest);
    }

    @Override
    public Quaterniond rotateYXZ(double angleY, double angleX, double angleZ, Quaterniond dest) {
         return new Quaterniond(this).rotateYXZ(angleY,angleX,angleZ,dest);
    }

    @Override
    public org.joml.Vector3d getEulerAnglesXYZ(org.joml.Vector3d eulerAngles) {
         return new Quaterniond(this).getEulerAnglesXYZ(eulerAngles);
    }

    @Override
    public Quaterniond rotateAxis(double angle, double axisX, double axisY, double axisZ, Quaterniond dest) {
         return new Quaterniond(this).rotateAxis(angle,axisX,axisY,axisZ,dest);
    }

    @Override
    public Quaterniond rotateAxis(double angle, Vector3dc axis, Quaterniond dest) {
         return new Quaterniond(this).rotateAxis(angle,axis,dest);
    }

    @Override
    public org.joml.Vector3d positiveX(org.joml.Vector3d dir) {
         return new Quaterniond(this).positiveX(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveX(org.joml.Vector3d dir) {
         return new Quaterniond(this).normalizedPositiveX(dir);
    }

    @Override
    public org.joml.Vector3d positiveY(org.joml.Vector3d dir) {
         return new Quaterniond(this).positiveY(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveY(org.joml.Vector3d dir) {
         return new Quaterniond(this).normalizedPositiveY(dir);
    }

    @Override
    public org.joml.Vector3d positiveZ(org.joml.Vector3d dir) {
         return new Quaterniond(this).positiveZ(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveZ(org.joml.Vector3d dir) {
         return new Quaterniond(this).normalizedPositiveZ(dir);
    }
}

