package org.terasology.math.geom;
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



import com.google.common.base.Preconditions;

/**
 * A point in 2D space
 * @author Martin Steiger
 */
public abstract class Point2d {
    /**
     * @param a the first point
     * @param b the second point
     * @param ipol the interpolation value in the range [0..1]
     * @return the interpolated point
     */
    public static Point2md ipol(Point2d a, Point2d b, double ipol) {
        Preconditions.checkArgument(ipol >= 0 && ipol <= 1, "ipol must be in [0..1]");

        double x = a.getX() * (1.0 - ipol) + b.getX() * ipol;
        double y = a.getY() * (1.0 - ipol) + b.getY() * ipol;
        return new Point2md(x, y);
    }

    /**
     * @return x
     */
    public abstract double getX();

    /**
     * @return y
     */
    public abstract double getY();

    /**
     * @param other the other point
     * @return the distance in between
     */
    public double dist(Point2d other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Computes the distance between two points
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double dist(Point2d p1, Point2d p2) {
        return p1.dist(p2);
    }

    /**
     * @return the distance to the origin
     */
    public double length() {
        return Math.sqrt(getX() * getX() + getY() * getY());
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
        
        if (!(obj instanceof Point2d)) {
            return false;
        }
        
        Point2d other = (Point2d) obj;
        
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
