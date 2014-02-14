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
 * Vector3d is the mutable implementation of Tuple3d, for representing points or vectors in 3 dimensional space of type
 * double.
 *
 * @author Martin Steiger
 */
public class Vector3d extends Tuple3d {

    private double x;
    private double y;
    private double z;

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     *
     * @param other The Tuple3d to copy
     */
    public Vector3d(Tuple3d other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    /**
     * Default constructor, for a zero vector
     */
    public Vector3d() {
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }
    
    /**
     * @param x the new x coordinate
     * @return This vector3d
     */
    public Vector3d setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * @param y the y coordinate
     * @return this
     */
    public Vector3d setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * @param z the z coordinate
     * @return this
     */
    public Vector3d setZ(double z) {
        this.z = z;
        return this;
    }
    
    /**
     * @param other the point to set
     * @return this
     */
    public Vector3d set(Tuple3d other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        return this;
    }

    /**
     * @param newX the new x
     * @param newY the new y
     * @param newZ the new z
     * @return this
     */
    public Vector3d set(double newX, double newY, double newZ) {
        this.x = newX;
        this.y = newY;
        this.z = newZ;
        return this;
    }

    /**
     * Adds to the x value
     *
     * @param value the added x value
     * @return this
     */
    public Vector3d addX(double value) {
        this.x += value;
        return this;
    }

    /**
     * Adds to the y value
     *
     * @param value the added y value
     * @return this
     */
    public Vector3d addY(double value) {
        this.y += value;
        return this;
    }

    /**
     * Adds to the z value
     *
     * @param value the added z value
     * @return this
     */
    public Vector3d addZ(double value) {
        this.z += value;
        return this;
    }
    
    /**
     * Subtracts from the x value
     *
     * @param value the subtracted x value
     * @return this
     */
    public Vector3d subX(double value) {
        this.x -= value;
        return this;
    }

    /**
     * Subtracts from the y value
     *
     * @param value the subtracted y value
     * @return this
     */
    public Vector3d subY(double value) {
        this.y -= value;
        return this;
    }

    /**
     * Subtracts from the z value
     *
     * @param value the subtracted z value
     * @return this
     */
    public Vector3d subZ(double value) {
        this.z -= value;
        return this;
    }
    
    /**
     * Multiplies the x value
     *
     * @param value the scale value
     * @return this
     */
    public Vector3d mulX(double value) {
        this.x *= value;
        return this;
    }

    /**
     * Multiplies the y value
     *
     * @param value the scale value
     * @return this
     */
    public Vector3d mulY(double value) {
        this.y *= value;
        return this;
    }

    /**
     * Multiplies the z value
     *
     * @param value the scale value
     * @return this
     */
    public Vector3d mulZ(double value) {
        this.z *= value;
        return this;
    }
    
    /**
     * Divides the x value
     * 
     * @param value the denominator
     * @return this
     */
    public Vector3d divX(double value) {
        this.x /= value;
        return this;
    }

    /**
     * Divides the y value
     * 
     * @param value the denominator
     * @return this
     */
    public Vector3d divY(double value) {
        this.y /= value;
        return this;
    }

    /**
     * Divides the z value
     * 
     * @param value the denominator
     * @return this
     */
    public Vector3d divZ(double value) {
        this.z /= value;
        return this;
    }
    
    /**
     * Adds a point to this point
     *
     * @param valueX the added x value
     * @param valueY the added y value
     * @param valueZ the added z value
     * @return this
     */
    public Vector3d add(double valueX, double valueY, double valueZ) {
        this.x += valueX;
        this.y += valueY;
        this.z += valueZ;
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public Vector3d add(Tuple3d other) {
        this.x += other.getX();
        this.y += other.getY();
        this.z += other.getZ();
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param valueX the subtracted x value
     * @param valueY the subtracted y value
     * @param valueZ the subtracted z value
     * @return this
     */
    public Vector3d sub(double valueX, double valueY, double valueZ) {
        x -= valueX;
        y -= valueY;
        z -= valueZ;
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public Vector3d sub(Tuple3d other) {
        x -= other.getX();
        y -= other.getY();
        z -= other.getZ();
        return this;
    }

    /**
     * Multiplies this with a scalar value
     *
     * @param value a scalar value
     * @return this
     */
    public Vector3d scale(double value) {
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public Vector3d invert() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    /**
     * set the length to one
     *
     * @return this
     */
    public Vector3d normalize() {
        double ooLength = 1.0 / length();
        x *= ooLength;
        y *= ooLength;
        z *= ooLength;
        return this;
    }

}
