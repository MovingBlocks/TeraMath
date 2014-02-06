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
 * A constant point in 2D space
 * @author Martin Steiger
 */
public class Point2cd extends Point2d {

    /**
     * Point(0, 0)
     */
    public static final Point2cd ZERO = new Point2cd(0, 0);

    private final double x;
    private final double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point2cd(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The other point
     */
    public Point2cd(Point2d other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    /**
     * @return the point at (-x, -y)
     */
    public Point2cd invert() {
        return new Point2cd(-getX(), -getY());
    }

    /**
     * @return a normalized point (length == 1)
     */
    public Point2cd normalize() {
        return mul(1.0 / length());
    }

    /**
     * @param dx the x offset
     * @param dy the y offset
     * @return this + offset
     */
    public Point2cd add(double dx, double dy) {
        return new Point2cd(getX() + dx, getY() + dy);
    }

    /**
     * @param other the other point
     * @return this + other
     */
    public final Point2cd add(Point2d other) {
        return add(other.getX(), other.getY());
    }

    /**
     * @param dx the x offset
     * @param dy the y offset
     * @return this - offset
     */
    public Point2cd sub(double dx, double dy) {
        return new Point2cd(getX() - dx, getY() - dy);
    }

    /**
     * @param other the point to subtract
     * @return this - other
     */
    public final Point2cd sub(Point2d other) {
        return sub(other.getX(), other.getY());
    }

    /**
     * @param val the scale factor
     * @return this * val
     */
    public Point2cd mul(double val) {
        return new Point2cd(this.getX() * val, this.getY() * val);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Point2cd other = (Point2cd) obj;
        
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        
        return true;
    }

}
