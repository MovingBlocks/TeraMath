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

import org.joml.AxisAngle4f;
import org.joml.Matrix4x3d;
import org.joml.Matrix4x3f;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector4dc;
import org.joml.Vector4fc;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * A 4-element quaternion represented by float precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public abstract class BaseQuat4f implements Quaternionfc {

    /**
     * The immutable identity quaternion
     */
    public static final ImmutableQuat4f IDENTITY = new ImmutableQuat4f(0, 0, 0, 1);

    protected static final float EPS = 1.0e-12f;

    /**
     * As defined by BulletGlobals
     */
    protected static final float FLT_EPSILON = 1.1920929E-7f;

    /**
     * @return the x component
     */
    public abstract float getX();

    /**
     * @return the y component
     */
    public abstract float getY();

    /**
     * @return the z component
     */
    public abstract float getZ();

    /**
     * @return the w component
     */
    public abstract float getW();

    /**
     * @return the rotation angle
     */
    public float getAngle() {
        return (float) (Math.acos(getW()) * 2.0);
    }

    /**
     * @return the Euler yaw angle (heading)
     */
    public float getYaw() {
        return (float) (Math.atan2(2.0 * (getW() * getY() + getZ() * getX()),
                1.0 - 2.0 * (getX() * getX() + getY() * getY())));
    }

    /**
     * @return the Euler pitch angle (attitude)
     */
    public float getPitch() {
        return (float) (Math.asin(2.0 * (getW() * getX() - getY() * getZ())));
    }

    /**
     * @return the Euler roll angle (bank)
     */
    public float getRoll() {
        return (float) (Math.atan2(2.0 * (getW() * getZ() + getX() * getY()),
                1.0 - 2.0 * (getZ() * getZ() + getX() * getX())));
    }

    /**
     * @return a copy of the axis components
     */
    public Vector3f getAxis() {
        return new Vector3f(getX(), getY(), getZ());
    }

    public Vector3f rotate(Vector3f v) {
        return rotate(v, new Vector3f());
    }

    public Vector3f rotate(Vector3f v, Vector3f out) {
        Quat4f q = new Quat4f(this);
        q.mul(v);

        Quat4f tmp = new Quat4f();
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
    public static final Quat4f interpolate(BaseQuat4f q1, BaseQuat4f q2, float alpha) {
        // From "Advanced Animation and Rendering Techniques"
        // by Watt and Watt pg. 364, function as implemented appeared to be
        // incorrect.  Fails to choose the same quaternion for the double
        // covering. Resulting in change of direction for rotations.

        float dot = q2.getX() * q1.getX() + q2.getY() * q1.getY() + q2.getZ() * q1.getZ() + q2.getW() * q1.getW();

        float q1x;
        float q1Y;
        float q1Z;
        float q1W;

        // Negate the first quaternion in the case that the
        // dot product of q1 and this is negative.
        if (dot < 0) {
            q1x = -q1.getX();
            q1Y = -q1.getY();
            q1Z = -q1.getZ();
            q1W = -q1.getW();
            dot = -dot;
        } else {
            q1x = q1.getX();
            q1Y = q1.getY();
            q1Z = q1.getZ();
            q1W = q1.getW();
        }

        float s1;
        float s2;

        if ((1.0f - dot) > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = (float) (Math.sin((1.0 - alpha) * om) / sinom);
            s2 = (float) (Math.sin(alpha * om) / sinom);
        } else {
            s1 = 1.0f - alpha;
            s2 = alpha;
        }

        float w = s1 * q1W + s2 * q2.getW();
        float x = s1 * q1x + s2 * q2.getX();
        float y = s1 * q1Y + s2 * q2.getY();
        float z = s1 * q1Z + s2 * q2.getZ();

        return new Quat4f(x, y, z, w);
    }

    /**
     * All implementations with the same coordinates are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseQuat4f) {
            BaseQuat4f other = (BaseQuat4f) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX())
                && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY())
                && Float.floatToIntBits(getZ()) == Float.floatToIntBits(other.getZ())
                && Float.floatToIntBits(getW()) == Float.floatToIntBits(other.getW());
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
    public float x() {
        return getX();
    }

    @Override
    public float y() {
        return getY();
    }

    @Override
    public float z() {
        return getZ();
    }

    @Override
    public float w() {
        return getW();
    }

    @Override
    public Quaternionf normalize(Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).normalize(dest);
    }

    @Override
    public Quaternionf add(float x, float y, float z, float w, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).add(x,y,z,w,dest);
    }

    @Override
    public Quaternionf add(Quaternionfc q2, Quaternionf dest) {

        return new Quaternionf(x(),y(),z(),w()).add(q2,dest);
    }

    @Override
    public float angle() {
        return 0;
    }

    @Override
    public org.joml.Matrix3d get(org.joml.Matrix3d dest) {
        return new Quaternionf(x(),y(),z(),w()).get(dest);
    }

    @Override
    public org.joml.Matrix3f get(org.joml.Matrix3f dest) {
        return new Quaternionf(x(),y(),z(),w()).get(dest);
    }

    @Override
    public org.joml.Matrix4d get(org.joml.Matrix4d dest) {
        return new Quaternionf(x(),y(),z(),w()).get(dest);
    }

    @Override
    public org.joml.Matrix4f get(org.joml.Matrix4f dest) {
        return new Quaternionf(x(),y(),z(),w()).get(dest);
    }

    @Override
    public Quaternionf get(Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).get(dest);
    }

    @Override
    public Quaternionf mul(Quaternionfc q, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).mul(q,dest);
    }

    @Override
    public Quaternionf mul(float qx, float qy, float qz, float qw, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).mul(qx,qy,qz,qw,dest);
    }

    @Override
    public Quaternionf premul(Quaternionfc q, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).premul(q,dest);
    }

    @Override
    public Quaternionf premul(float qx, float qy, float qz, float qw, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).premul(qx,qy,qz,qw,dest);
    }

    @Override
    public org.joml.Vector3f transform(org.joml.Vector3f vec) {
        return new Quaternionf(x(),y(),z(),w()).transform(vec);
    }

    @Override
    public org.joml.Vector3f transformPositiveX(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveX(dest);
    }

    @Override
    public org.joml.Vector4f transformPositiveX(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveX(dest);
    }

    @Override
    public org.joml.Vector3f transformUnitPositiveX(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveX(dest);
    }

    @Override
    public org.joml.Vector4f transformUnitPositiveX(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveX(dest);
    }

    @Override
    public org.joml.Vector3f transformPositiveY(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveY(dest);
    }

    @Override
    public org.joml.Vector4f transformPositiveY(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveY(dest);
    }

    @Override
    public org.joml.Vector3f transformUnitPositiveY(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveY(dest);
    }

    @Override
    public org.joml.Vector4f transformUnitPositiveY(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveY(dest);
    }

    @Override
    public org.joml.Vector3f transformPositiveZ(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4f transformPositiveZ(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformPositiveZ(dest);
    }

    @Override
    public org.joml.Vector3f transformUnitPositiveZ(org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4f transformUnitPositiveZ(org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transformUnitPositiveZ(dest);
    }

    @Override
    public org.joml.Vector4f transform(org.joml.Vector4f vec) {
        return new Quaternionf(x(),y(),z(),w()).transform(vec);
    }

    @Override
    public org.joml.Vector3f transform(Vector3fc vec, org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transform(vec,dest);
    }

    @Override
    public org.joml.Vector3f transform(float x, float y, float z, org.joml.Vector3f dest) {
        return new Quaternionf(x(),y(),z(),w()).transform(x,y,z,dest);
    }

    @Override
    public org.joml.Vector4f transform(Vector4fc vec, org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transform(vec,dest);
    }

    @Override
    public org.joml.Vector4f transform(float x, float y, float z, org.joml.Vector4f dest) {
        return new Quaternionf(x(),y(),z(),w()).transform(x,y,z,dest);
    }

    @Override
    public Quaternionf invert(Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).invert(dest);
    }

    @Override
    public Quaternionf div(Quaternionfc b, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).div(b,dest);
    }

    @Override
    public Quaternionf conjugate(Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).conjugate(dest);
    }

    @Override
    public float lengthSquared() {
        return new Quaternionf(x(),y(),z(),w()).lengthSquared();
    }

    @Override
    public Quaternionf slerp(Quaternionfc target, float alpha, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).slerp(target,alpha,dest);
    }

    @Override
    public Quaternionf scale(float factor, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).scale(factor,dest);
    }

    @Override
    public Quaternionf integrate(float dt, float vx, float vy, float vz, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).integrate(dt,vx,vy,vz,dest);
    }

    @Override
    public Quaternionf nlerp(Quaternionfc q, float factor, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).nlerp(q,factor,dest);
    }

    @Override
    public Quaternionf nlerpIterative(Quaternionfc q, float alpha, float dotThreshold, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).nlerpIterative(q,alpha,dotThreshold,dest);
    }

    @Override
    public Quaternionf lookAlong(Vector3fc dir, Vector3fc up, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).lookAlong(dir,up,dest);
    }

    @Override
    public Quaternionf lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).lookAlong(dirX,dirY,dirZ,upX,upY,upZ,dest);
    }

    @Override
    public Quaternionf difference(Quaternionf other, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).difference(other,dest);
    }

    @Override
    public Quaternionf rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateTo(fromDirX,fromDirY,fromDirZ,toDirX,toDirY,toDirZ,dest);
    }

    @Override
    public Quaternionf rotateTo(Vector3fc fromDir, Vector3fc toDir, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateTo(fromDir,toDir,dest);
    }

    @Override
    public Quaternionf rotateX(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateX(angle,dest);
    }

    @Override
    public Quaternionf rotateY(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateY(angle,dest);
    }

    @Override
    public Quaternionf rotateZ(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateZ(angle,dest);
    }

    @Override
    public Quaternionf rotateLocalX(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateLocalX(angle,dest);
    }

    @Override
    public Quaternionf rotateLocalY(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateLocalY(angle,dest);
    }

    @Override
    public Quaternionf rotateLocalZ(float angle, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateLocalZ(angle,dest);
    }

    @Override
    public Quaternionf rotateXYZ(float angleX, float angleY, float angleZ, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateXYZ(angleX,angleY,angleZ,dest);
    }

    @Override
    public Quaternionf rotateZYX(float angleZ, float angleY, float angleX, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateZYX(angleZ,angleY,angleX,dest);
    }

    @Override
    public Quaternionf rotateYXZ(float angleY, float angleX, float angleZ, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateYXZ(angleY,angleX,angleZ,dest);
    }

    @Override
    public org.joml.Vector3f getEulerAnglesXYZ(org.joml.Vector3f eulerAngles) {
        return new Quaternionf(x(),y(),z(),w()).getEulerAnglesXYZ(eulerAngles);
    }

    @Override
    public Quaternionf rotateAxis(float angle, float axisX, float axisY, float axisZ, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateAxis(angle,axisX,axisY,axisZ,dest);
    }

    @Override
    public Quaternionf rotateAxis(float angle, Vector3fc axis, Quaternionf dest) {
        return new Quaternionf(x(),y(),z(),w()).rotateAxis(angle,axis,dest);
    }

    @Override
    public org.joml.Vector3f positiveX(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).positiveX(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveX(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).normalizedPositiveX(dir);
    }

    @Override
    public org.joml.Vector3f positiveY(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).positiveY(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveY(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).normalizedPositiveY(dir);
    }

    @Override
    public org.joml.Vector3f positiveZ(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).positiveZ(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveZ(org.joml.Vector3f dir) {
        return new Quaternionf(x(),y(),z(),w()).normalizedPositiveZ(dir);
    }
}

