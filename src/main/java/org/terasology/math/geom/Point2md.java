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



/**
 * A mutable point in 2D space
 * @author Martin Steiger
 */
public class Point2md extends Point2d {

    private double x;
    private double y;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point2md(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The other point
     */
    public Point2md(Point2d other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    /**
     * Default constructor for (0 / 0)
     */
    public Point2md() {
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
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @param y the y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @param pt the point to set
     */
    public void set(Point2d pt) {
        this.x = pt.getX();
        this.y = pt.getY();
    }

    /**
     * @param nx the new x
     * @param ny the new y
     */
    public void set(double nx, double ny) {
        this.x = nx;
        this.x = ny;
    }

    /**
     * Adds to the x value
     * @param ax the added x value
     */
    public void addX(double ax) {
        this.x += x;
    }

    /**
     * Adds to the y value
     * @param ay the added y value
     */
    public void addY(double ay) {
        this.y += y;
    }

    /**
     * Subtracts from the x value
     * @param sx the subtracted x value
     */
    public void subX(double sx) {
        this.x -= sx;
    }

    /**
     * Subtracts from the y value
     * @param sy the subtracted y value
     */
    public void subY(double sy) {
        this.y -= sy;
    }

    /**
     * Multiplies the x value
     * @param s the scale value
     */
    public void mulX(double s) {
        this.x *= s;
    }

    /**
     * Multiplies the y value
     * @param s the scale value
     */
    public void mulY(double s) {
        this.y *= s;
    }

    /**
     * Adds a point to this point
     * @param ax the added x value
     * @param ay the added y value
     */
    public void add(double ax, double ay) {
        this.x += ax;
        this.y += ay;
    }

    /**
     * Adds a point to this point
     * @param other the point
     */
    public void add(Point2d other) {
        this.x += other.getX();
        this.y += other.getY();
    }

    /**
     * Subtracts a point from this point
     * @param sx the subtracted x value
     * @param sy the subtracted y value
     *
    public void sub(double sx, double sy) {
        x -= sx;
        y -= sy;
    }

    /**
     * Subtracts a point from this point
     * @param other the point
     */
    public void sub(Point2d other) {
        x -= other.getX();
        y -= other.getY();
    }

    /**
     * Multiplies this with a scalar value
     * @param val a scalar value
     */
    public void mul(double val) {
        x *= val;
        y *= val;
    }

    /**
     * Sets the point coords. to (-x, -y)
     */
    public void invert() {
        x = -x;
        y = -y;
    }

    /**
     * set the length to one
     */
    public void normalize() {
        double ooLength = 1.0 / length();
        x *= ooLength;
        y *= ooLength;
    }

}
