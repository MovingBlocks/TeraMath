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
 * A vector/point in 2D space
 * @author Martin Steiger
 */
public abstract class Tuple2d {
    /**
     * @param a the first point
     * @param b the second point
     * @param ipol the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Vector2d lerp(Tuple2d a, Tuple2d b, double ipol) {
        Preconditions.checkArgument(ipol >= 0 && ipol <= 1, "ipol must be in [0..1]");

        double x = a.getX() * (1.0 - ipol) + b.getX() * ipol;
        double y = a.getY() * (1.0 - ipol) + b.getY() * ipol;
        return new Vector2d(x, y);
    }

    /**
     * @param a the tuple
     * @return a constant version
     */
    public static ConstVector2d constant(Tuple2d a) {
        return new ConstVector2d(a);
    }

    /**
     * @param array the backing double array
     * @param index the index in the array (in vectors)
     * @return a vector backed by the array
     */
    public static ArrayBasedVector2d fromArray(double[] array, int index) {
        return new ArrayBasedVector2d(array, index);
    }

    /**
     * @return x the x coordinate
     */
    public abstract double getX();

    /**
     * @return y the y coordinate
     */
    public abstract double getY();

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double dist(Tuple2d other) {
        return Math.sqrt(distSq(other));
    }
    
    /**
     * @param other the other point
     * @return the distance in between
     */
    public double distSq(Tuple2d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double dist(Tuple2d p1, Tuple2d p2) {
        return p1.dist(p2);
    }

    /**
     * @return the distance to the origin
     */
    public double lengthSq() {
        return getX() * getX() + getY() * getY();
    }
    
    /**
     * @return the distance to the origin
     */
    public double length() {
        return Math.sqrt(lengthSq());
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

    /**
     * All point implementations with the same coordinate are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Tuple2d)) {
            return false;
        }
        
        Tuple2d other = (Tuple2d) obj;
        
        if (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        }
        
        if (Double.doubleToLongBits(getY()) != Double.doubleToLongBits(other.getY())) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "Point2d(" + getX() + "," + getY() + ")";
    }
}
