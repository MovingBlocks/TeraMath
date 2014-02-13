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
 * An immutable Tuple2d, which is a point or vector in 2D space with double components.
 * This type is intended for use for constants, or any time you want a Tuple2d that is guaranteed immutable.
 *
 * @author Martin Steiger
 */
public final class ImmutableVector2d extends Tuple2d {

    private final double x;
    private final double y;

    /**
     * @param x the x component
     * @param y the y component
     */
    ImmutableVector2d(double x, double y) {
        this.x = x;
        this.y = y;
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
//    public ImmutableVector2d invert() {
//        return new ImmutableVector2d(-getX(), -getY());
//    }
//
//    /**
//     * @return a normalized point (length == 1)
//     */
//    public ImmutableVector2d normalize() {
//        return scale(1.0 / length());
//    }
//
//    /**
//     * @param dx the x offset
//     * @param dy the y offset
//     * @return this + offset
//     */
//    public ImmutableVector2d add(double dx, double dy) {
//        return new ImmutableVector2d(getX() + dx, getY() + dy);
//    }
//
//    /**
//     * @param other the other point
//     * @return this + other
//     */
//    public final ImmutableVector2d add(BaseVector2d other) {
//        return add(other.getX(), other.getY());
//    }
//
//    /**
//     * @param dx the x offset
//     * @param dy the y offset
//     * @return this - offset
//     */
//    public ImmutableVector2d sub(double dx, double dy) {
//        return new ImmutableVector2d(getX() - dx, getY() - dy);
//    }
//
//    /**
//     * @param other the point to subtract
//     * @return this - other
//     */
//    public final ImmutableVector2d sub(BaseVector2d other) {
//        return sub(other.getX(), other.getY());
//    }
//
//    /**
//     * @param val the scale factor
//     * @return this * val
//     */
//    public ImmutableVector2d scale(double val) {
//        return new ImmutableVector2d(this.getX() * val, this.getY() * val);
//    }

}
