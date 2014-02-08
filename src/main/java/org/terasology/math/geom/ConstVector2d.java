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
public final class ConstVector2d extends Tuple2d {

    /**
     * Point(0, 0)
     */
    public static final ConstVector2d ZERO = new ConstVector2d(0, 0);

    private final double x;
    private final double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public ConstVector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The other point
     */
    public ConstVector2d(Tuple2d other) {
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

//    /**
//     * @return the point at (-x, -y)
//     */
//    public ConstVector2d invert() {
//        return new ConstVector2d(-getX(), -getY());
//    }
//
//    /**
//     * @return a normalized point (length == 1)
//     */
//    public ConstVector2d normalize() {
//        return mul(1.0 / length());
//    }
//
//    /**
//     * @param dx the x offset
//     * @param dy the y offset
//     * @return this + offset
//     */
//    public ConstVector2d add(double dx, double dy) {
//        return new ConstVector2d(getX() + dx, getY() + dy);
//    }
//
//    /**
//     * @param other the other point
//     * @return this + other
//     */
//    public final ConstVector2d add(BaseVector2d other) {
//        return add(other.getX(), other.getY());
//    }
//
//    /**
//     * @param dx the x offset
//     * @param dy the y offset
//     * @return this - offset
//     */
//    public ConstVector2d sub(double dx, double dy) {
//        return new ConstVector2d(getX() - dx, getY() - dy);
//    }
//
//    /**
//     * @param other the point to subtract
//     * @return this - other
//     */
//    public final ConstVector2d sub(BaseVector2d other) {
//        return sub(other.getX(), other.getY());
//    }
//
//    /**
//     * @param val the scale factor
//     * @return this * val
//     */
//    public ConstVector2d mul(double val) {
//        return new ConstVector2d(this.getX() * val, this.getY() * val);
//    }

}
