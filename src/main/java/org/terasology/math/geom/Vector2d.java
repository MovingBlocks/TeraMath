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
 * A mutable point in 2D space
 * @author Martin Steiger
 */
public class Vector2d extends Tuple2d {

    private double x;
    private double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The other point
     */
    public Vector2d(Tuple2d other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    /**
     * Default constructor for (0 / 0)
     */
    public Vector2d() {
        this(0.0, 0.0);
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
     * @param x the x coordinate
     * @return this
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
     * @param pt the point to set
     * @return this
     */
    public Vector2d set(Tuple2d pt) {
        this.x = pt.getX();
        this.y = pt.getY();
        return this;
    }

    /**
     * @param nx the new x
     * @param ny the new y
     * @return this
     */
    public Vector2d set(double nx, double ny) {
        this.x = nx;
        this.y = ny;
        return this;
    }

    /**
     * Adds to the x value
     * @param ax the added x value
     * @return this
     */
    public Vector2d addX(double ax) {
        this.x += x;
        return this;
    }

    /**
     * Adds to the y value
     * @param ay the added y value
     * @return this
     */
    public Vector2d addY(double ay) {
        this.y += y;
        return this;
    }

    /**
     * Subtracts from the x value
     * @param sx the subtracted x value
     * @return this
     */
    public Vector2d subX(double sx) {
        this.x -= sx;
        return this;
    }

    /**
     * Subtracts from the y value
     * @param sy the subtracted y value
     * @return this
     */
    public Vector2d subY(double sy) {
        this.y -= sy;
        return this;
    }

    /**
     * Multiplies the x value
     * @param s the scale value
     * @return this
     */
    public Vector2d mulX(double s) {
        this.x *= s;
        return this;
    }

    /**
     * Multiplies the y value
     * @param s the scale value
     * @return this
     */
    public Vector2d mulY(double s) {
        this.y *= s;
        return this;
    }

    /**
     * Adds a point to this point
     * @param ax the added x value
     * @param ay the added y value
     * @return this
     */
    public Vector2d add(double ax, double ay) {
        this.x += ax;
        this.y += ay;
        return this;
    }

    /**
     * Adds a point to this point
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
     * @param sx the subtracted x value
     * @param sy the subtracted y value
     * @return this
     */
    public Vector2d sub(double sx, double sy) {
        x -= sx;
        y -= sy;
        return this;
    }

    /**
     * Subtracts a point from this point
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
     * @param val a scalar value
     * @return this
     */
    public Vector2d mul(double val) {
        x *= val;
        y *= val;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     * @return this
     */
    public Vector2d invert() {
        x = -x;
        y = -y;
        return this;
    }

    /**
     * set the length to one
     * @return this
     */
    public Vector2d normalize() {
        double ooLength = 1.0 / length();
        x *= ooLength;
        y *= ooLength;
        return this;
    }

}
