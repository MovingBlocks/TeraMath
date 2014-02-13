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
 * A vector/point in $dimensions$D space
 * @author Martin Steiger
 */
public abstract class $names/tupleType()$ {

    public static final $names/immutableType()$ ZERO = new $names/immutableType()$(0, 0);
    public static final $names/immutableType()$ ONE = new $names/immutableType()$(1, 1);

    /**
     * @return x the x coordinate
     */
    public abstract $componentType$ getX();

    /**
     * @return y the y coordinate
     */
    public abstract $componentType$ getY();

    /**
     * @param a the first point
     * @param b the second point
     * @param t the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static $names/vectorType()$ lerp($names/tupleType()$ a, $names/tupleType()$ b, $componentType$ t) {
        Preconditions.checkArgument(t >= 0 && t <= 1, "t must be in range [0..1]");

        $componentType$ x = a.getX() * (1.0 - t) + b.getX() * t;
        $componentType$ y = a.getY() * (1.0 - t) + b.getY() * t;
        return new $names/vectorType()$(x, y);
    }

    /**
     * @return the distance to the origin
     */
    public $componentType$ lengthSquared() {
        return getX() * getX() + getY() * getY();
    }
    
    /**
     * @return the distance to the origin
     */
    public $componentType$ length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distanceSquared(Tuple2d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distance(Tuple2d other) {
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double distance(Tuple2d p1, Tuple2d p2) {
        return p1.distance(p2);
    }

    /**
     * All point implementations with the same coordinate are equal
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
     * All point implementations with the same coordinate have the same hashcode
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
        return "Point2d(" + getX() + "," + getY() + ")";
    }
}
