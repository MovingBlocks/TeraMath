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
 * A 4-element quaternion represented by double precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public class Quat4d extends BaseQuat4d {

    // required in set(Matrix4 m)
    private static final double EPS2 = 1.0e-30;

    /**
     * Constructs and initializes a Quat4d with (0 / 0 / 0 / 0)
     */
    public Quat4d() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    /**
     * Constructs and initializes a Quat4d from the specified BaseQuat4d.
     * @param other the BaseQuat4d containing the initialization x y z w data
     */
    public Quat4d(BaseQuat4d other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
    }

    /**
     * Constructs and initializes a Quat4d from the specified xyzw coordinates and normalizes.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w scalar component
     */
    public Quat4d(double x, double y, double z, double w) {
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
    public Quat4d(double[] q) {
        this(q[0], q[1], q[2], q[3]);
    }

    /** 
     * Constructs and initializes a Quat4d from the specified Vector4d.  
     * @param t the Vector4d containing the initialization x y z w data 
     */
    public Quat4d(Vector4d t) {
        this(t.getX(), t.getY(), t.getZ(), t.getW());
    }

    /**
     * @param axis the axis. Length must be != 0
     * @param angle the rotation angle in radians
     */
    public Quat4d(Vector3d axis, double angle) {
        set(axis, angle);
    }

    /**
     * @param yaw the yaw angle (in radians)
     * @param pitch the pitch angle (in radians)
     * @param roll the roll angle (in radians)
     */
    public Quat4d(double yaw, double pitch, double roll) {
        double halfYaw = yaw * 0.5f;
        double halfPitch = pitch * 0.5f;
        double halfRoll = roll * 0.5f;
        double cosYaw = Math.cos(halfYaw);
        double sinYaw = Math.sin(halfYaw);
        double cosPitch = Math.cos(halfPitch);
        double sinPitch = Math.sin(halfPitch);
        double cosRoll = Math.cos(halfRoll);
        double sinRoll = Math.sin(halfRoll);
        x = cosRoll * sinPitch * cosYaw + sinRoll * cosPitch * sinYaw;
        y = cosRoll * cosPitch * sinYaw - sinRoll * sinPitch * cosYaw;
        z = sinRoll * cosPitch * cosYaw - cosRoll * sinPitch * sinYaw;
        w = cosRoll * cosPitch * cosYaw + sinRoll * sinPitch * sinYaw;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double getW() {
        return w;
    }

    /**
     * Sets the value of this BaseQuat4d to the value of Quat4d other.
     * @param other the Quat4d to be copied
     */
    public final void set(BaseQuat4d other) {
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
    public final void set(BaseMatrix3d m1) {
        double ww = 0.25d * (m1.getM00() + m1.getM11() + m1.getM22() + 1.0d);

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = Math.sqrt(ww);
                ww = 0.25d / this.w;
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
        ww = -0.5d * (m1.getM11() + m1.getM22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = Math.sqrt(ww);
                ww = 0.5d / this.x;
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
        ww = 0.5d * (1.0d - m1.getM22());
        if (ww >= EPS2) {
            this.y = Math.sqrt(ww);
            this.z = m1.getM21() / (2.0d * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
    }

    public void set(Vector3d axis, double angle) {
        double d = axis.length();
        double s = Math.sin(angle * 0.5) / d;
        x = axis.getX() * s;
        y = axis.getY() * s;
        z = axis.getZ() * s;
        w = Math.cos(angle * 0.5);
    }

    /**
     * Sets the value of this quaternion to the rotational component of
     * the passed matrix.
     * @param m1 the matrix
     */
    public final void set(BaseMatrix4d m1) {
        double ww = 0.25d * (m1.getM00() + m1.getM11() + m1.getM22() + m1.getM33());

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = Math.sqrt(ww);
                ww = 0.25d / this.w;
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
        ww = -0.5d * (m1.getM11() + m1.getM22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = Math.sqrt(ww);
                ww = 0.5d / this.x;
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
        ww = 0.5d * (1.0d - m1.getM22());
        if (ww >= EPS2) {
            this.y = Math.sqrt(ww);
            this.z = m1.getM21() / (2.0d * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
    }



    /**
     * Sets the value of this quaternion to quaternion inverse of quaternion q1.
     * @param q1 the quaternion to be inverted
     */
    public final void inverse(BaseQuat4d q1) {
        this.w =  q1.getW();
        this.x = -q1.getX();
        this.y = -q1.getY();
        this.z = -q1.getZ();
    }

    /**
     * @param v the vector to multiply with
     */
    public void mul(Vector3d v) {
        double rx = w * v.getX() + y * v.getZ() - z * v.getY();
        double ry = w * v.getY() + z * v.getX() - x * v.getZ();
        double rz = w * v.getZ() + x * v.getY() - y * v.getX();
        this.w = -x * v.getX() - y * v.getY() - z * v.getZ();
        this.x = rx;
        this.y = ry;
        this.z = rz;
    }

    /**
      * Sets the value of this quaternion to the quaternion product of
      * itself and q1 (this = this * q1).  
      * @param q1 the other quaternion
      */
    public final void mul(BaseQuat4d q1) {
        double nw = this.w * q1.getW() - this.x * q1.getX() - this.y * q1.getY() - this.z * q1.getZ();
        double nx = this.w * q1.getX() + q1.getW() * this.x + this.y * q1.getZ() - this.z * q1.getY();
        double ny = this.w * q1.getY() + q1.getW() * this.y - this.x * q1.getZ() + this.z * q1.getX();
        this.z = this.w * q1.getZ() + q1.getW() * this.z + this.x * q1.getY() - this.y * q1.getX();
        this.w = nw;
        this.x = nx;
        this.y = ny;
    }

    /**
     * Sets the value of this quaternion to the quaternion product of
     * quaternions q1 and q2 (this = q1 * q2).
     * Note that this is safe for aliasing (e.g. this can be q1 or q2).
     * @param q1 the first quaternion
     * @param q2 the second quaternion
     */
    public final void mul(BaseQuat4d q1, BaseQuat4d q2) {
        double nw = q1.getW() * q2.getW() - q1.getX() * q2.getX() - q1.getY() * q2.getY() - q1.getZ() * q2.getZ();
        double nx = q1.getW() * q2.getX() + q2.getW() * q1.getX() + q1.getY() * q2.getZ() - q1.getZ() * q2.getY();
        double ny = q1.getW() * q2.getY() + q2.getW() * q1.getY() - q1.getX() * q2.getZ() + q1.getZ() * q2.getX();
        this.z =  q1.getW() * q2.getZ() + q2.getW() * q1.getZ() + q1.getX() * q2.getY() - q1.getY() * q2.getX();
        this.w = nw;
        this.x = nx;
        this.y = ny;
    }

    /**
      * Multiplies this quaternion by the inverse of quaternion q1 and places
      * the value into this quaternion.  The value of the argument quaternion
      * is preserved (this = this * q^-1).
      * @param q1 the other quaternion
      */
    public final void mulInverse(BaseQuat4d q1) {
        Quat4d tempQuat = new Quat4d(q1);

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
    public static Quat4d shortestArcQuat(Vector3d v0, Vector3d v1) {
        Vector3d c = new Vector3d();
        c.cross(v0, v1);
        float d = v0.dot(v1);

        if (d < -1.0 + FLT_EPSILON) {
            // just pick any vector
            return new Quat4d(0.0f, 1.0f, 0.0f, 0.0f);
        }

        float s = (float) Math.sqrt((1.0f + d) * 2.0f);
        float rs = 1.0f / s;

        return new Quat4d(c.x * rs, c.y * rs, c.z * rs, s * 0.5f);
    }



}
