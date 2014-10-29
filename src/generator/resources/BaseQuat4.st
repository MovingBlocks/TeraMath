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
 * A 4-element quaternion represented by $componentType$ precision floating 
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public abstract class $quat/baseType()$ {
    
    /**
     * The immutable identity quaternion
     */
    public static final $quat/immutableType()$ IDENTITY = new $quat/immutableType()$(0, 0, 0, 1);

    private static final $componentType$ EPS = $comp/const("1.0e-12")$;
    
    /**
     * @return the x component
     */
    public abstract $componentType$ getX();
    
    /**
     * @return the y component
     */
    public abstract $componentType$ getY();
    
    /**
     * @return the z component
     */
    public abstract $componentType$ getZ();
    
    /**
     * @return the w component
     */
    public abstract $componentType$ getW();

    /**
     * @return the rotation angle
     */
    public double getAngle() {
        return $comp/cast("Math.acos(getW()) * 2.0")$;
    }
    
    /**
     * @return a copy of the axis components
     */
    public $quat/vector3Type()$ getAxis() {
        return new $quat/vector3Type()$(getX(), getY(), getZ());
    }
    
    /**
     * Performs a great circle interpolation between quaternion q1
     * and quaternion q2 and places the result into this quaternion.
     * @param q1  the first quaternion
     * @param q2  the second quaternion
     * @param alpha  the alpha interpolation parameter
     * @return the interpolated quaternion
     */
    public static final $quat/mutableType()$ interpolate($quat/baseType()$ q1, $quat/baseType()$ q2, $componentType$ alpha) {
        // From "Advanced Animation and Rendering Techniques"
        // by Watt and Watt pg. 364, function as implemented appeared to be
        // incorrect.  Fails to choose the same quaternion for the double
        // covering. Resulting in change of direction for rotations.

        $componentType$ dot = q2.getX() * q1.getX() + q2.getY() * q1.getY() + q2.getZ() * q1.getZ() + q2.getW() * q1.getW();

        $componentType$ q1x;
        $componentType$ q1Y;
        $componentType$ q1Z;
        $componentType$ q1W;
        
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

        $componentType$ s1;
        $componentType$ s2;

        if (($comp/const("1.0")$ - dot) > EPS) {
            double om = Math.acos(dot);
            double sinom = Math.sin(om);
            s1 = $comp/cast("Math.sin((1.0 - alpha) * om) / sinom")$;
            s2 = $comp/cast("Math.sin(alpha * om) / sinom")$;
        } else {
            s1 = $comp/const("1.0")$ - alpha;
            s2 = alpha;
        }
        
        $componentType$ w = s1 * q1W + s2 * q2.getW();
        $componentType$ x = s1 * q1x + s2 * q2.getX();
        $componentType$ y = s1 * q1Y + s2 * q2.getY();
        $componentType$ z = s1 * q1Z + s2 * q2.getZ();
        
        return new $quat/mutableType()$(x, y, z, w);
    }
    
    /**
     * All implementations with the same coordinates are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof $quat/baseType()$) {
            $quat/baseType()$ other = ($quat/baseType()$) obj;
            return $componentType.toIntegralFunc$(getX()) == $componentType.toIntegralFunc$(other.getX())
                && $componentType.toIntegralFunc$(getY()) == $componentType.toIntegralFunc$(other.getY())
                && $componentType.toIntegralFunc$(getZ()) == $componentType.toIntegralFunc$(other.getZ())
                && $componentType.toIntegralFunc$(getW()) == $componentType.toIntegralFunc$(other.getW());
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
        temp = $componentType.toIntegralFunc$(getX());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = $componentType.toIntegralFunc$(getY());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = $componentType.toIntegralFunc$(getZ());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = $componentType.toIntegralFunc$(getW());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ", " + getW() + ")";
    }
}

