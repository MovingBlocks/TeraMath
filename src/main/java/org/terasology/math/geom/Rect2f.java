/*
 * Copyright 2015 MovingBlocks
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
 * @author Immortius
 */
public final class Rect2f extends BaseRect {
    public static final Rect2f EMPTY = new Rect2f();

    // position
    private float posX;
    private float posY;

    // size
    private float w;
    private float h;

    private Rect2f() {
    }

    private Rect2f(float x, float y, float w, float h) {
        this.posX = x;
        this.posY = y;

        this.w = w;
        this.h = h;
    }

    public static Rect2f createFromMinAndSize(float x, float y, float width, float height) {
        if (width <= 0 || height <= 0) {
            return EMPTY;
        }
        return new Rect2f(x, y, width, height);
    }

    public static Rect2f createFromMinAndSize(BaseVector2f min, BaseVector2f size) {
        return createFromMinAndSize(min.getX(), min.getY(), size.getX(), size.getY());
    }

    public static Rect2f createFromMinAndMax(float minX, float minY, float maxX, float maxY) {
        if (maxX <= minX || maxY <= minY) {
            return EMPTY;
        }
        return new Rect2f(minX, minY, maxX - minX, maxY - minY);
    }

    public static Rect2f createFromMinAndMax(BaseVector2f min, BaseVector2f max) {
        return createFromMinAndMax(min.getX(), min.getY(), max.getX(), max.getY());
    }

    public static Rect2f createEncompassing(BaseVector2f a, BaseVector2f b) {
        return createEncompassing(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public static Rect2f createEncompassing(float ax, float ay, float bx, float by) {
        return createFromMinAndMax(Math.min(ax, bx), Math.min(ay, by), Math.max(ax, bx), Math.max(ay, by));
    }

    public static Rect2f createFromCenterAndSize(BaseVector2f center, BaseVector2f size) {
        return createFromCenterAndSize(center.getX(), center.getY(), size.getX(), size.getY());
    }

    public static Rect2f createFromCenterAndSize(float centerX, float centerY, float width, float height) {
        return createFromMinAndSize(centerX - width * 0.5f, centerY - height * 0.5f, width, height);
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public Rect2f getBounds() {
        return this;
    }

    /**
     * @return The smallest vector in the region
     */
    public Vector2f min() {
        return new Vector2f(posX, posY);
    }

    /**
     * @return The size of the region
     */
    public Vector2f size() {
        return new Vector2f(w, h);
    }

    public float maxX() {
        return posX + w;
    }

    public float minX() {
        return posX;
    }


    public float maxY() {
        return posY + h;
    }

    public float minY() {
        return posY;
    }

    public float width() {
        return w;
    }

    public float height() {
        return h;
    }

    /**
     * @return The area - width * height
     */
    public float area() {
        return w * h;
    }

    /**
     * @param other the rectangle to compute the intersection with
     * @return The Rect2f that is encompassed by both this and other. If they
     *         do not overlap then the Rect2i.EMPTY is returned
     */
    public Rect2f intersection(Rect2f other) {
        float minX = Math.max(posX, other.posX);
        float maxX = Math.min(maxX(), other.maxX());
        float minY = Math.max(posY, other.posY);
        float maxY = Math.min(maxY(), other.maxY());
        return createFromMinAndMax(minX, minY, maxX, maxY);
    }

    /**
     * @return true if (left <= pos.x < right) and (top <= pos.y < bottom)
     */
    @Override
    public boolean contains(BaseVector2f pos) {
        return contains(pos.getX(), pos.getY());
    }

    /**
     * Only the top and left edge are inside, bottom and right edges are not.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if (left <= x < right) and (top <= y < bottom)
     */
    @Override
    public boolean contains(float x, float y) {
        return !isEmpty()
            && (x >= posX)
            && (y >= posY)
            && (x < posX + w)
            && (y < posY + h);
    }

    /**
     * A rectangle does encompass itself!
     * @param other the other rectangle
     * @return true if t
     */
    public boolean contains(Rect2f other) {
        return !isEmpty()
            && !other.isEmpty()
            && other.posX >= posX
            && other.posY >= posY
            && other.posX + other.w <= posX + w
            && other.posY + other.h <= posY + h;
    }

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @param eps the epsilon
     * @return true if the point is closer than eps to the border of the rectangle
     */
    public boolean touches(float x, float y, float eps) {
        if (isEmpty()) {
            return false;
        }

        return (Math.abs(x - posX)     < eps && y > posY - eps && y < posY + h + eps)
            || (Math.abs(x - posX - w) < eps && y > posY - eps && y < posY + h + eps)
            || (Math.abs(y - posY)     < eps && x > posX - eps && x < posX + h + eps)
            || (Math.abs(y - posY - h) < eps && x > posX - eps && x < posX + w + eps);
    }

    public boolean intersects(Rect2f other) {
        return !isEmpty()
            && !other.isEmpty()
            && other.posX < posX + w
            && other.posX + other.w > posX
            && other.posY < posY + h
            && other.posY + other.h > posY;
    }

    /**
     * Computes the distance to a given point
     * @param px the point x coordinate
     * @param py the point y coordinate
     * @return the squared distance between point and this rectangle
     */
    public float distance(float px, float py) {
        return (float) Math.sqrt(distanceSquared(px, py));
    }

    /**
     * Computes the distance to a given point
     * @param px the point x coordinate
     * @param py the point y coordinate
     * @return the squared distance between point and this rectangle
     */
    public float distanceSquared(float px, float py) {
      float cx2 = posX * 2 + w;
      float cy2 = posY * 2 + h;
      float dx = Math.max(Math.abs(2 * px - cx2) - w, 0) / 2;
      float dy = Math.max(Math.abs(2 * py - cy2) - h, 0) / 2;
      return dx * dx + dy * dy;
    }

    @Override
    public int outcode(float x, float y) {
        int out = 0;
        if (this.w <= 0) {
            out |= OUT_LEFT | OUT_RIGHT;
        } else if (x < this.posX) {
            out |= OUT_LEFT;
        } else if (x >= this.posX + this.w) {
            out |= OUT_RIGHT;
        }
        if (this.h <= 0) {
            out |= OUT_TOP | OUT_BOTTOM;
        } else if (y < this.posY) {
            out |= OUT_TOP;
        } else if (y >= this.posY + this.h) {
            out |= OUT_BOTTOM;
        }
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rect2f) {
            Rect2f other = (Rect2f) obj;
            return other.posX == posX && other.posY == posY && other.w == w && other.h == h;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(posX);
        result = prime * result + Float.floatToIntBits(posY);
        result = prime * result + Float.floatToIntBits(w);
        result = prime * result + Float.floatToIntBits(h);
        return result;
    }

    @Override
    public String toString() {
        return String.format("(x=%f y=%f w=%f h=%f)", posX, posY, w, h);
    }
}
