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
 * Tuple2d is the base for 2-dimensional points or vectors, with components of type double.
 * Tuple2d only describes the methods that cause no changes to the Tuple2d's internal representation - getters
 * and calculations returning new values. It is intended for use as:
 * <ul>
 *     <li>The parameter of methods that will not alter the parameter</li>
 *     <li>The return type of methods that expose an internal field of a class,
 *     but which do not want it to be changed</li>
 * </ul>
 * For a mutable implementation, see Vector2d.
 * For an immutable implementation suitable for constants, see ImmutableVector2d.
 * @author Martin Steiger
 */
public abstract class Tuple2d {

    /**
     * Tuple2d with components all 0.
     */
    public static final ImmutableVector2d ZERO = new ImmutableVector2d(0, 0);
    /**
     * Tuple2d with components all 1.
     */
    public static final ImmutableVector2d ONE = new ImmutableVector2d(1, 1);

    /**
     * @return x The x component of the Tuple2d
     */
    public abstract double getX();

    /**
     * @return y The y component of the Tuple2d
     */
    public abstract double getY();

    /**
     * @return a mutable vector (0, 0)
     */
    public static Vector2d create() {
        return new Vector2d(0, 0);
    }

    /**
     * @param x the x component
     * @param y the y component
     * @return a mutable vector (x, y)
     */
    public static Vector2d create(double x, double y) {
        return new Vector2d(x, y);
    }
    
    /**
     * @param t the original tuple
     * @return a mutable copy of t
     */
    public static Vector2d create(Tuple2d t) {
        return new Vector2d(t.getX(), t.getY());
    }
    
    /**
     * @param x the x component
     * @param y the y component
     * @return an immutable vector
     */
    public static ImmutableVector2d createImmutable(double x, double y) {
        return new ImmutableVector2d(x, y);
    }

    /**
     * @param t the tuple
     * @return an immutable vector (a copy of t)
     */
    public static ImmutableVector2d createImmutable(Tuple2d t) {
        return new ImmutableVector2d(t.getX(), t.getY());
    }

    /**
     * Calculates the linear interpolation between two Tuple2ds.
     * @param a the starting value
     * @param b the ending value
     * @param t the ratio of b to a, in the range [0..1]
     * @return the interpolated result
     */
    public static Vector2d lerp(Tuple2d a, Tuple2d b, double t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        double x = a.getX() * (1.0 - t) + b.getX() * t;
        double y = a.getY() * (1.0 - t) + b.getY() * t;
        return new Vector2d(x, y);
    }

    /**
     * The squared length of the Tuple2d - this is equivalent to the squared distance of this Tuple2d from the origin.
     * lengthSquared() is less expensive than length(), and should be used where
     * possible. A typical use case is finding the shortest Tuple2d.
     * @return The squared length (squared distance from origin)
     */
    public double lengthSquared() {
        return getX() * getX() + getY() * getY();
    }
    
    /**
     * The length of the Tuple2d - this is equivalent to the distance of this Tuple2d from the origin.
     * @return the length (distance from origin)
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the squared distance between this and other
     */
    public double distanceSquared(Tuple2d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @param other the other point
     * @return the distance between this and other
     */
    public double distance(Tuple2d other) {
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between points
     */
    public static double distance(Tuple2d p1, Tuple2d p2) {
        return p1.distance(p2);
    }

    /**
     * All Tuple2d implementations with the same coordinates are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tuple2d) {
            Tuple2d other = (Tuple2d) obj;
            return Double.doubleToLongBits(getX()) == Double.doubleToLongBits(other.getX())
                    && Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY());
        }
        return false;
    }

    /**
     * All Tuple2d implementations with the same coordinate have the same hashCode
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
        return result;
    }
    
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}
