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
@Deprecated
public abstract class BaseQuat4d extends org.joml.Quaterniond{

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
    public static final Quat4d interpolate(BaseQuat4d q1, BaseQuat4d q2, double alpha) {
        // From "Advanced Animation and Rendering Techniques"
        // by Watt and Watt pg. 364, function as implemented appeared to be
        // incorrect.  Fails to choose the same quaternion for the double
        // covering. Resulting in change of direction for rotations.

        double dot = q2.getX() * q1.getX() + q2.getY() * q1.getY() + q2.getZ() * q1.getZ() + q2.getW() * q1.getW();

        double q1x;
        double q1Y;
        double q1Z;
        double q1W;

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

        double w = s1 * q1W + s2 * q2.getW();
        double x = s1 * q1x + s2 * q2.getX();
        double y = s1 * q1Y + s2 * q2.getY();
        double z = s1 * q1Z + s2 * q2.getZ();

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
}

