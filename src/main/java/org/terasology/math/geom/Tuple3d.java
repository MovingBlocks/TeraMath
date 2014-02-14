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


import com.google.common.base.Preconditions;

/**
 * Tuple3d is the base for 3-dimensional points or vectors, with components of type double.
 * Tuple3d only describes the methods that cause no changes to the Tuple3d's internal representation - getters
 * and calculations returning new values. It is intended for use as:
 * <ul>
 *     <li>The parameter of methods that will not alter the parameter</li>
 *     <li>The return type of methods that expose an internal field of a class,
 *     but which do not want it to be changed</li>
 * </ul>
 * For a mutable implementation, see Vector3d.
 * For an immutable implementation suitable for constants, see ImmutableVector3d.
 * @author Martin Steiger
 */
public abstract class Tuple3d {

    /**
     * Tuple3d with components all 0.
     */
    public static final ImmutableVector3d ZERO = new ImmutableVector3d(0, 0, 0);
    /**
     * Tuple3d with components all 1.
     */
    public static final ImmutableVector3d ONE = new ImmutableVector3d(1, 1, 1);

    /**
     * @return x The x component of the Tuple3d
     */
    public abstract double getX();

    /**
     * @return y The y component of the Tuple3d
     */
    public abstract double getY();

    /**
     * @return z The z component of the Tuple3d
     */
    public abstract double getZ();
    /**
     * Calculates the linear interpolation between two Tuple3ds.
     * @param a the starting value
     * @param b the ending value
     * @param t the ratio of b to a, in the range [0..1]
     * @return the interpolated result
     */
    public static Vector3d lerp(Tuple3d a, Tuple3d b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1.0 - t) + b.getX() * t;
        double y = a.getY() * (1.0 - t) + b.getY() * t;
        double z = a.getZ() * (1.0 - t) + b.getZ() * t;
        return new Vector3d(x, y, z);
    }

    /**
     * The squared length of the Tuple3d - this is equivalent to the squared distance of this Tuple3d from the origin.
     * lengthSquared() is less expensive than length(), and should be used where
     * possible. A typical use case is finding the shortest Tuple3d.
     * @return The squared length (squared distance from origin)
     */
    public double lengthSquared() {
        double x = getX();
        double y = getY();
        double z = getZ();
        return x * x + y * y + z * z;
    }
    
    /**
     * The length of the Tuple3d - this is equivalent to the distance of this Tuple3d from the origin.
     * @return the length (distance from origin)
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the squared distance between this and other
     */
    public double distanceSquared(Tuple3d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();
        double dz = other.getZ() - this.getZ();

        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * @param other the other point
     * @return the distance between this and other
     */
    public double distance(Tuple3d other) {
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between points
     */
    public static double distance(Tuple3d p1, Tuple3d p2) {
        return p1.distance(p2);
    }

    /**
     * All Tuple3d implementations with the same coordinates are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tuple3d) {
            Tuple3d other = (Tuple3d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY())
                && Double.doubleToLongBits(getZ()) == Double.doubleToLongBits(other.getZ());
        }
        return false;
    }

    /**
     * All Tuple3d implementations with the same coordinate have the same hashCode
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
        return result;
    }
    
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
}
