/*
 * Copyright 2013 MovingBlocks
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

import java.util.Objects;

/**
 * @author Immortius
 * @author Martin Steiger
 */
public final class Rect2d implements Shape {

    public static final Rect2d EMPTY = new Rect2d();

    // position
    private double posX;
    private double posY;

    // size
    private double w;
    private double h;

    private Rect2d() {
    }

    private Rect2d(double x, double y, double w, double h) {
        this.posX = x;
        this.posY = y;

        this.w = w;
        this.h = h;
    }

    public static Rect2d createFromMinAndSize(double x, double y, double width, double height) {
        if (width <= 0 || height <= 0) {
            return EMPTY;
        }
        return new Rect2d(x, y, width, height);
    }

    public static Rect2d createFromMinAndSize(BaseVector2d min, BaseVector2d size) {
        return createFromMinAndSize(min.getX(), min.getY(), size.getX(), size.getY());
    }

    public static Rect2d createFromMinAndMax(double minX, double minY, double maxX, double maxY) {
        if (maxX <= minX || maxY <= minY) {
            return EMPTY;
        }
        return new Rect2d(minX, minY, maxX - minX, maxY - minY);
    }

    public static Rect2d createFromMinAndMax(BaseVector2d min, BaseVector2d max) {
        return createFromMinAndMax(min.getX(), min.getY(), max.getX(), max.getY());
    }

    public static Rect2d createEncompassing(BaseVector2d a, BaseVector2d b) {
        return createEncompassing(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public static Rect2d createEncompassing(double ax, double ay, double bx, double by) {
        return createFromMinAndMax(Math.min(ax, bx), Math.min(ay, by), Math.max(ax, bx), Math.max(ay, by));
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    /**
     * @return The smallest vector in the region
     */
    public Vector2d min() {
        return new Vector2d(posX, posY);
    }

    /**
     * @return The size of the region
     */
    public Vector2d size() {
        return new Vector2d(w, h);
    }

    public double maxX() {
        return posX + w;
    }

    public double minX() {
        return posX;
    }

    public double maxY() {
        return posY + h;
    }

    public double minY() {
        return posY;
    }

    public double width() {
        return w;
    }

    public double height() {
        return h;
    }

    /**
     * @return The area of the Rect2d - width * height
     */
    public double area() {
        return w * h;
    }

    /**
     * @param other
     * @return The Rect2d that is encompassed by both this and other. If they
     *         do not overlap then the Rect2i.EMPTY is returned
     */
    public Rect2d intersect(Rect2d other) {
        double minX = Math.max(posX, other.posX);
        double maxX = Math.min(maxX(), other.maxX());
        double minY = Math.max(posY, other.posY);
        double maxY = Math.min(maxY(), other.maxY());
        return createFromMinAndMax(minX, minY, maxX, maxY);
    }

    /**
     * @param pos
     * @return Whether this Rect2i includes pos
     */
    @Override
    public boolean contains(BaseVector2d pos) {
        return contains(pos.getX(), pos.getY());
    }

    public boolean contains(double x, double y) {
        return !isEmpty() && (x >= posX) && (y >= posY) && (x <= posX + w) && (y <= posY + h);
    }

    public boolean encompasses(Rect2d other) {
        return !isEmpty() && !other.isEmpty() && other.posX >= posX && other.posY >= posY && other.posX + other.w <= posX + w && other.posY + w <= posY + w;
    }

    public boolean overlaps(Rect2d other) {
        return !isEmpty() && !other.isEmpty() && other.posX < posX + w && other.posX + other.w > posX && other.posY < posY + h && other.posY + other.h > posY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rect2d) {
            Rect2d other = (Rect2d) obj;
            return other.posX == posX && other.posY == posY && other.w == w && other.h == h;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY, w, h);
    }

    @Override
    public String toString() {
        return String.format("(x=%f y=%f w=%f h=%f)", posX, posY, w, h);
    }
}
