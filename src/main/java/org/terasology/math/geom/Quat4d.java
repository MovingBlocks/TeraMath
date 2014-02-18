/*
 * Copyright 2014 MovingBlocks
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

    private double x;
    private double y;
    private double z;
    private double w;

    /**
     * Constructs and initializes a Quat4d from the specified Quat4d.
     * @param other the Quat4d containing the initialization x y z w data
     */
    public Quat4d(BaseQuat4d other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
    }

    /**
     * Constructs and initializes a Quat4d from the specified xyzw coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w scalar component
     */
    public Quat4d(double x, double y, double z, double w) {
        double mag = 1.0 / Math.sqrt(x * x + y * y + z * z + w * w);
        this.x = x * mag;
        this.y = y * mag;
        this.z = z * mag;
        this.w = w * mag;
    }

    /**
     * Constructs and initializes a Quat4d from the array of length 4. 
     * @param q the array of length 4 containing xyzw in order
     */
    public Quat4d(double[] q) {
        this(q[0], q[1], q[2], q[3]);
    }

    /** 
     * Constructs and initializes a Quat4d from the specified Tuple4d.  
     * @param t the Tuple4d containing the initialization x y z w data 
     */
    public Quat4d(BaseVector4d t) {
        this(t.getX(), t.getY(), t.getZ(), t.getW());
    }

    /**
     * @param axis the axis. Length must be != 0
     * @param angle the rotation angle in radians
     */
    public Quat4d(Vector3d axis, double angle) {
        double d = axis.length();
        double s = Math.sin(angle * 0.5) / d;
        x = axis.getX() * s;
        y = axis.getY() * s;
        z = axis.getZ() * s;
        w = Math.cos(angle * 0.5);
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
     * Sets the value of this quaternion to the conjugate of quaternion q1.
     * @param q1 the source vector
     */
    public final void conjugate(Quat4d q1) {
        this.x = -q1.x;
        this.y = -q1.y;
        this.z = -q1.z;
        this.w = q1.w;
    }

    /**
     * Negate the value of of each of this quaternion's x,y,z coordinates in place.
     */
    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    /**
     * @param v the vector to multiply with
     */
    public void mul(Vector3f v) {
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
    public final void mul(Quat4d q1) {
        double nw = this.w * q1.w - this.x * q1.x - this.y * q1.y - this.z * q1.z;
        double nx = this.w * q1.x + q1.w * this.x + this.y * q1.z - this.z * q1.y;
        double ny = this.w * q1.y + q1.w * this.y - this.x * q1.z + this.z * q1.x;
        this.z = this.w * q1.z + q1.w * this.z + this.x * q1.y - this.y * q1.x;
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
    public final void mulInverse(Quat4d q1) {
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
     * Normalizes the value of this quaternion in place.
     */
    public final void normalize() {
        double norm = (this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);

        if (norm > 0.0) {
            norm = 1.0 / Math.sqrt(norm);
            this.x *= norm;
            this.y *= norm;
            this.z *= norm;
            this.w *= norm;
        } else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.w = 0.0;
        }
    }

}
