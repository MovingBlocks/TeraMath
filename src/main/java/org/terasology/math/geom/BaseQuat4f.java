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
public abstract class BaseQuat4f extends org.joml.Quaternionf{

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
}

