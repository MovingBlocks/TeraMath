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

package javax.vecmath;

/**
 * A 4-element quaternion represented by double precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public class $quat/mutableType()$ extends $quat/baseType()$ {

    // required in set(Matrix4 m)
    private final static double EPS2 = 1.0e-30;

    private $componentType$ x;
    private $componentType$ y;
    private $componentType$ z;
    private $componentType$ w;

    /**
     * Constructs and initializes a $quat/mutableType()$ with (0 / 0 / 0 / 0)
     */
    public $quat/mutableType()$() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    /**
     * Constructs and initializes a $quat/mutableType()$ from the specified $quat/baseType()$.
     * @param other the $quat/baseType()$ containing the initialization x y z w data
     */
    public $quat/mutableType()$($quat/baseType()$ other) {
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
    public $quat/mutableType()$($componentType$ x, $componentType$ y, $componentType$ z, $componentType$ w) {
        $componentType$ mag = $comp/const("1.0")$ / $comp/cast("Math.sqrt(x * x + y * y + z * z + w * w)")$;
        this.x = x * mag;
        this.y = y * mag;
        this.z = z * mag;
        this.w = w * mag;
    }

    /**
     * Constructs and initializes a Quat4d from the array of length 4. 
     * @param q the array of length 4 containing xyzw in order
     */
    public $quat/mutableType()$($componentType$[] q) {
        this(q[0], q[1], q[2], q[3]);
    }

    /** 
     * Constructs and initializes a Quat4d from the specified $quat/vector4Type()$.  
     * @param t the $quat/vector4Type()$ containing the initialization x y z w data 
     */
    public $quat/mutableType()$($quat/vector4Type()$ t) {
        this(t.getX(), t.getY(), t.getZ(), t.getW());
    }

    /**
     * @param axis the axis. Length must be != 0
     * @param angle the rotation angle in radians
     */
    public $quat/mutableType()$($quat/vector3Type()$ axis, double angle) {
        double d = axis.length();
        $componentType$ s = $comp/cast("Math.sin(angle * 0.5) / d")$;
        x = axis.getX() * s;
        y = axis.getY() * s;
        z = axis.getZ() * s;
        w = $comp/cast("Math.cos(angle * 0.5)")$;
    }

    /**
     * @param yaw the yaw angle (in radians)
     * @param pitch the pitch angle (in radians)
     * @param roll the roll angle (in radians)
     */
    public $quat/mutableType()$(double yaw, double pitch, double roll) {
        double halfYaw = yaw * 0.5f;
        double halfPitch = pitch * 0.5f;
        double halfRoll = roll * 0.5f;
        double cosYaw = Math.cos(halfYaw);
        double sinYaw = Math.sin(halfYaw);
        double cosPitch = Math.cos(halfPitch);
        double sinPitch = Math.sin(halfPitch);
        double cosRoll = Math.cos(halfRoll);
        double sinRoll = Math.sin(halfRoll);
        x = $comp/cast("cosRoll * sinPitch * cosYaw + sinRoll * cosPitch * sinYaw")$;
        y = $comp/cast("cosRoll * cosPitch * sinYaw - sinRoll * sinPitch * cosYaw")$;
        z = $comp/cast("sinRoll * cosPitch * cosYaw - cosRoll * sinPitch * sinYaw")$;
        w = $comp/cast("cosRoll * cosPitch * cosYaw + sinRoll * sinPitch * sinYaw")$;
    }

    @Override
    public $componentType$ getX() {
        return x;
    }

    @Override
    public $componentType$ getY() {
        return y;
    }

    @Override
    public $componentType$ getZ() {
        return z;
    }

    @Override
    public $componentType$ getW() {
        return w;
    }

    /**
     * Sets the value of this $quat/baseType()$ to the value of $quat/mutableType()$ t1.
     * @param t1 the $quat/mutableType()$ to be copied
     */
    public final void set($quat/baseType()$ other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
    }

    /**
     * Sets the value of this $quat/baseType()$ to the value of $quat/mutableType()$ t1.
     * @param t1 the $quat/mutableType()$ to be copied
     */
    public final void set($componentType$ x, $componentType$ y, $componentType$ z, $componentType$ w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Sets the value of this quaternion to the rotational component of
     * the passed matrix.
     * @param m1 the matrix
     */
    public final void set(BaseMatrix3$componentType.abbrev$ m1)
    {
        $componentType$ ww = 0.25$componentType.abbrev$ * (m1.getM00() + m1.getM11() + m1.getM22() + 1.0$componentType.abbrev$);

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = $comp/cast("Math.sqrt(ww)")$;
                ww = 0.25$componentType.abbrev$ / this.w;
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
        ww = -0.5$componentType.abbrev$ * (m1.getM11() + m1.getM22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = $comp/cast("Math.sqrt(ww)")$;
                ww = 0.5$componentType.abbrev$ / this.x;
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
        ww = 0.5$componentType.abbrev$ * (1.0$componentType.abbrev$ - m1.getM22());
        if (ww >= EPS2) {
            this.y = $comp/cast("Math.sqrt(ww)")$;
            this.z = m1.getM21() / (2.0$componentType.abbrev$ * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
    }


    /**
     * Sets the value of this quaternion to the rotational component of
     * the passed matrix.
     * @param m1 the matrix
     */
    public final void set(BaseMatrix4$componentType.abbrev$ m1)
    {
        $componentType$ ww = 0.25$componentType.abbrev$ * (m1.getM00() + m1.getM11() + m1.getM22() + m1.getM33());

        if (ww >= 0) {
            if (ww >= EPS2) {
                this.w = $comp/cast("Math.sqrt(ww)")$;
                ww = 0.25$componentType.abbrev$ / this.w;
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
        ww = -0.5$componentType.abbrev$ * (m1.getM11() + m1.getM22());
        if (ww >= 0) {
            if (ww >= EPS2) {
                this.x = $comp/cast("Math.sqrt(ww)")$;
                ww = 0.5$componentType.abbrev$ / this.x;
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
        ww = 0.5$componentType.abbrev$ * (1.0$componentType.abbrev$ - m1.getM22());
        if (ww >= EPS2) {
            this.y = $comp/cast("Math.sqrt(ww)")$;
            this.z = m1.getM21() / (2.0$componentType.abbrev$ * this.y);
            return;
        }

        this.y = 0;
        this.z = 1;
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
     * Sets the value of this quaternion to quaternion inverse of quaternion q1.
     * @param q1 the quaternion to be inverted
     */
    public final void inverse($quat/baseType()$ q1) {
        this.w =  q1.getW();
        this.x = -q1.getX();
        this.y = -q1.getY();
        this.z = -q1.getZ();
    }

    /**
     * @param v the vector to multiply with
     */
    public void mul($quat/vector3Type()$ v) {
        $componentType$ rx = w * v.getX() + y * v.getZ() - z * v.getY();
        $componentType$ ry = w * v.getY() + z * v.getX() - x * v.getZ();
        $componentType$ rz = w * v.getZ() + x * v.getY() - y * v.getX();
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
    public final void mul($quat/baseType()$ q1) {
        $componentType$ nw = this.w * q1.getW() - this.x * q1.getX() - this.y * q1.getY() - this.z * q1.getZ();
        $componentType$ nx = this.w * q1.getX() + q1.getW() * this.x + this.y * q1.getZ() - this.z * q1.getY();
        $componentType$ ny = this.w * q1.getY() + q1.getW() * this.y - this.x * q1.getZ() + this.z * q1.getX();
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
    public final void mul($quat/baseType()$ q1, $quat/baseType()$ q2) {
        $componentType$ nw = q1.getW() * q2.getW() - q1.getX() * q2.getX() - q1.getY() * q2.getY() - q1.getZ() * q2.getZ();
        $componentType$ nx = q1.getW() * q2.getX() + q2.getW() * q1.getX() + q1.getY() * q2.getZ() - q1.getZ() * q2.getY();
        $componentType$ ny = q1.getW() * q2.getY() + q2.getW() * q1.getY() - q1.getX() * q2.getZ() + q1.getZ() * q2.getX();
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
    public final void mulInverse($quat/baseType()$ q1) {
        $quat/mutableType()$ tempQuat = new $quat/mutableType()$(q1);

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
            this.x = 0;
            this.y = 0;
            this.z = 0;
            this.w = 0;
        }
    }

}
