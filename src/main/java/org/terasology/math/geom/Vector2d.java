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
 * Vector2d is the mutable implementation of Tuple2d, for representing points or vectors in 2 dimensional space of type
 * double.
 *
 * @author Martin Steiger
 */
public class Vector2d extends Tuple2d {

    private double x;
    private double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    Vector2d(double x, double y) {
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

    /**
     * @param x the new x coordinate
     * @return This vector2d
     */
    public Vector2d setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * @param y the y coordinate
     * @return this
     */
    public Vector2d setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * @param other the point to set
     * @return this
     */
    public Vector2d set(Tuple2d other) {
        this.x = other.getX();
        this.y = other.getY();
        return this;
    }

    /**
     * @param newX the new x
     * @param newY the new y
     * @return this
     */
    public Vector2d set(double newX, double newY) {
        this.x = newX;
        this.y = newY;
        return this;
    }

    /**
     * Adds to the x value
     *
     * @param value the added x value
     * @return this
     */
    public Vector2d addX(double value) {
        this.x += value;
        return this;
    }

    /**
     * Adds to the y value
     *
     * @param value the added y value
     * @return this
     */
    public Vector2d addY(double value) {
        this.y += value;
        return this;
    }

    /**
     * Subtracts from the x value
     *
     * @param value the subtracted x value
     * @return this
     */
    public Vector2d subX(double value) {
        this.x -= value;
        return this;
    }

    /**
     * Subtracts from the y value
     *
     * @param value the subtracted y value
     * @return this
     */
    public Vector2d subY(double value) {
        this.y -= value;
        return this;
    }

    /**
     * Multiplies the x value
     *
     * @param value the scale value
     * @return this
     */
    public Vector2d mulX(double value) {
        this.x *= value;
        return this;
    }

    /**
     * Multiplies the y value
     *
     * @param value the scale value
     * @return this
     */
    public Vector2d mulY(double value) {
        this.y *= value;
        return this;
    }

    public Vector2d divX(double value) {
        this.x /= value;
        return this;
    }

    public Vector2d divY(double value) {
        this.y /= value;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param valueX the added x value
     * @param valueY the added y value
     * @return this
     */
    public Vector2d add(double valueX, double valueY) {
        this.x += valueX;
        this.y += valueY;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public Vector2d add(Tuple2d other) {
        this.x += other.getX();
        this.y += other.getY();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the subtracted x value
     * @param valueY the subtracted y value
     * @return this
     */
    public Vector2d sub(double valueX, double valueY) {
        x -= valueX;
        y -= valueY;
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public Vector2d sub(Tuple2d other) {
        x -= other.getX();
        y -= other.getY();
        return this;
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return this
     */
    public Vector2d scale(double value) {
        x *= value;
        y *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector2d invert() {
        x = -x;
        y = -y;
        return this;
    }

    /**
     * set the length to one
     *
     * @return this
     */
    public Vector2d normalize() {
        double ooLength = 1.0 / length();
        x *= ooLength;
        y *= ooLength;
        return this;
    }

}
