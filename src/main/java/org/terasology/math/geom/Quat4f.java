/*
 * Copyright 2018 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

/**
 * A 4-element quaternion represented by float precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
@Deprecated
public class Quat4f extends BaseQuat4f {

    // required in set(Matrix4 m)
    private static final double EPS2 = 1.0e-30;
    /**
     * Constructs and initializes a Quat4f with (0 / 0 / 0 / 0)
     */
    public Quat4f() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    /**
     * Constructs and initializes a Quat4f from the specified BaseQuat4f.
     * @param other the BaseQuat4f containing the initialization x y z w data
     */
    public Quat4f(org.joml.Quaternionf other) {
        this.x = other.x();
        this.y = other.y();
        this.z = other.z();
        this.w = other.w();
    }

    /**
     * Constructs and initializes a Quat4d from the specified xyzw coordinates and normalizes.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w scalar component
     */
    public Quat4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.normalize();
    }

    /**
     * Constructs and initializes a Quat4d from the array of length 4. 
     * @param q the array of length 4 containing xyzw in order
     */
    public Quat4f(float[] q) {
        this(q[0], q[1], q[2], q[3]);
    }

    /** 
     * Constructs and initializes a Quat4d from the specified Vector4f.  
     * @param t the Vector4f containing the initialization x y z w data 
     */
    public Quat4f(org.joml.Vector4f t) {
        this(t.x(), t.y(), t.z(), t.y());
    }

    /**
     * @param axis the axis. Length must be != 0
     * @param angle the rotation angle in radians
     */
    public Quat4f(org.joml.Vector3f axis, float angle) {
        set(axis, angle);
    }

    /**
     * @param yaw the yaw angle (in radians)
     * @param pitch the pitch angle (in radians)
     * @param roll the roll angle (in radians)
     */
    public Quat4f(float yaw, float pitch, float roll) {
        float halfYaw = yaw * 0.5f;
        float halfPitch = pitch * 0.5f;
        float halfRoll = roll * 0.5f;
        float cosYaw = (float) (Math.cos(halfYaw));
        float sinYaw = (float) (Math.sin(halfYaw));
        float cosPitch = (float) (Math.cos(halfPitch));
        float sinPitch = (float) (Math.sin(halfPitch));
        float cosRoll = (float) (Math.cos(halfRoll));
        float sinRoll = (float) (Math.sin(halfRoll));
        x = cosRoll * sinPitch * cosYaw + sinRoll * cosPitch * sinYaw;
        y = cosRoll * cosPitch * sinYaw - sinRoll * sinPitch * cosYaw;
        z = sinRoll * cosPitch * cosYaw - cosRoll * sinPitch * sinYaw;
        w = cosRoll * cosPitch * cosYaw + sinRoll * sinPitch * sinYaw;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public float getW() {
        return w;
    }

    /**
     * Sets the value of this BaseQuat4f to the value of Quat4f other.
     * @param other the Quat4f to be copied
     */
    public final void set(BaseQuat4f other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
    }

    /**
     * Sets the value of this quaternion to the rotational component of
     * the passed matrix.
     * @param m1 the matrix
     */
    public final void set(BaseMatrix3f m1) {
        float ww = 0.25f * (m1.getM00() + m1.getM11() + m1.getM22() + 1.0f);

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = (float) (Math.sqrt(ww));
                ww = 0.25f / this.w;
                this.x = (m1.getM21() - m1.getM12()) * ww;
                this.y = (m1.getM02() - m1.getM20()) * ww;
                this.z = (m1.getM10() - m1.getM01()) * ww;
                return;
            }
        } else {
            this.w = 0;
            this.x = 0;
            this.y = 0;
            this.z = 1;
            return;
        }

        this.w = 0;
        ww = -0.5f * (m1.getM11() + m1.getM22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = (float) (Math.sqrt(ww));
                ww = 0.5f / this.x;
                this.y = m1.getM10() * ww;
                this.z = m1.getM20() * ww;
                return;
            }
        } else {
            this.x = 0;
            this.y = 0;
            this.z = 1;
            return;
        }

        this.x = 0;
        ww = 0.5f * (1.0f - m1.getM22());
        if (ww >= EPS2) {
            this.y = (float) (Math.sqrt(ww));
            this.z = m1.getM21() / (2.0f * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
    }

    public void set(org.joml.Vector3f axis, float angle) {
        double d = axis.length();
        float s = (float) (Math.sin(angle * 0.5) / d);
        x = axis.x() * s;
        y = axis.y() * s;
        z = axis.z() * s;
        w = (float) (Math.cos(angle * 0.5));
    }

    /**
     * Sets the value of this quaternion to the rotational component of
     * the passed matrix.
     * @param m1 the matrix
     */
    public final void set(org.joml.Matrix4f m1) {
        float ww = 0.25f * (m1.m00() + m1.m11() + m1.m22() + m1.m33());

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = (float) (Math.sqrt(ww));
                ww = 0.25f / this.w;
                this.x = (m1.m21() - m1.m12()) * ww;
                this.y = (m1.m02() - m1.m20()) * ww;
                this.z = (m1.m10() - m1.m01()) * ww;
                return;
            }
        } else {
            this.w = 0;
            this.x = 0;
            this.y = 0;
            this.z = 1;
            return;
        }

        this.w = 0;
        ww = -0.5f * (m1.m11() + m1.m22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = (float) (Math.sqrt(ww));
                ww = 0.5f / this.x;
                this.y = m1.m10() * ww;
                this.z = m1.m20() * ww;
                return;
            }
        } else {
            this.x = 0;
            this.y = 0;
            this.z = 1;
            return;
        }

        this.x = 0;
        ww = 0.5f * (1.0f - m1.m22());
        if (ww >= EPS2) {
            this.y = (float) (Math.sqrt(ww));
            this.z = m1.m21() / (2.0f * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
    }

    /**
     * Sets the value of this quaternion to quaternion inverse of quaternion q1.
     * @param q1 the quaternion to be inverted
     */
    public final void inverse(org.joml.Quaternionf q1) {
        this.w =  q1.w();
        this.x = -q1.x();
        this.y = -q1.y();
        this.z = -q1.z();
    }

    /**
     * @param v the vector to multiply with
     */
    public void mul(Vector3f v) {
        float rx = w * v.getX() + y * v.getZ() - z * v.getY();
        float ry = w * v.getY() + z * v.getX() - x * v.getZ();
        float rz = w * v.getZ() + x * v.getY() - y * v.getX();
        this.w = -x * v.getX() - y * v.getY() - z * v.getZ();
        this.x = rx;
        this.y = ry;
        this.z = rz;
    }

    /**
      * Multiplies this quaternion by the inverse of quaternion q1 and places
      * the value into this quaternion.  The value of the argument quaternion
      * is preserved (this = this * q^-1).
      * @param q1 the other quaternion
      */
    public final void mulInverse(org.joml.Quaternionf q1) {
        Quat4f tempQuat = new Quat4f(q1);

        tempQuat.inverse();
        this.mul(tempQuat);
    }

    /**
     * Invert this quaternion
     */
    public final void inverse() {
        x = -x;
        y = -y;
        z = -z;
    }

    /** 
     * See Game Programming Gems 2.10. 
     * @param v0 must be normalized
     * @param v1 must be normalized
     */
    public static Quat4f shortestArcQuat(org.joml.Vector3f v0, org.joml.Vector3f v1) {
        Vector3f c = new Vector3f();
        c.cross(v0, v1);
        float d = v0.dot(v1);

        if (d < -1.0 + FLT_EPSILON) {
            // just pick any vector
            return new Quat4f(0.0f, 1.0f, 0.0f, 0.0f);
        }

        float s = (float) Math.sqrt((1.0f + d) * 2.0f);
        float rs = 1.0f / s;

        return new Quat4f(c.x * rs, c.y * rs, c.z * rs, s * 0.5f);
    }

}
