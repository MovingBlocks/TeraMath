/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.common.base.Preconditions;

/**
 * An {@link Iterable} that iterates in
 * a square-shapes spiral around the central point (inclusive).
 * <br><br>
 * The iteration starts in positive x direction.
 * <br><br>
 * The iterating vector is reused. <b>Do not attempt to store the instance</b> e.g. in a collection.
 * @author Martin Steiger
 */
public final class SpiralIterable implements Iterable<BaseVector2i> {

    /**
     * (MAX_SIDELEN * 2 + 1) ^2 must be < Integer.MAX_VALUE
     */
    private static final int MAX_RADIUS = 23169;

    private final Vector2i center;
    private final boolean clockwise;
    private final int maxArea;

    /**
     * @param center the spiral center
     * @param maxRadius the maximum radius of the spiral [0..23169] (inclusive)
     * @param clockwise true for clockwise iteration, false for counter-clockwise
     */
    private SpiralIterable(Vector2i center, boolean clockwise, int maxRadius) {
        Preconditions.checkArgument(maxRadius >= 0, "maxRadius must be >= 0");
        Preconditions.checkArgument(maxRadius <= MAX_RADIUS, "maxRadius must be <= " + MAX_RADIUS);

        int sideLen = maxRadius * 2 + 1;

        this.center = center;
        this.maxArea = sideLen * sideLen;
        this.clockwise = clockwise;
    }

    /**
     * Iterates in clock-wise orientation around the given point.
     * The point will be the first iterated point.
     * @param center the spiral center
     */
    public static SpiralIterable clockwise(Vector2i center) {
        return new SpiralIterable(center, true, MAX_RADIUS);
    }

    /**
     * Iterates in clock-wise orientation around the given point.
     * The point will be the first iterated point.
     * @param maxRadius the maximum radius of the spiral [0..23169] (inclusive)
     * @param center the spiral center
     */
    public static SpiralIterable clockwise(Vector2i center, int maxRadius) {
        return new SpiralIterable(center, true, maxRadius);
    }

    /**
     * Iterates in clock-wise orientation around the given point.
     * The point will be the first iterated point.
     * @param center the spiral center
     */
    public static SpiralIterable counterClockwise(Vector2i center) {
        return new SpiralIterable(center, false, MAX_RADIUS);
    }

    /**
     * Iterates in clock-wise orientation around the given point.
     * The point will be the first iterated point.
     * @param maxRadius the maximum radius of the spiral [0..23169] (inclusive)
     * @param center the spiral center
     */
    public static SpiralIterable counterClockwise(Vector2i center, int maxRadius) {
        return new SpiralIterable(center, false, maxRadius);
    }

    @Override
    public Iterator<BaseVector2i> iterator() {

        return new Iterator<BaseVector2i>() {
            private int radius = 1;
            private int leg;
            private int x = -1;
            private int y;
            private int index;

            private Vector2i pos = new Vector2i();

            @Override
            public BaseVector2i next() {
                if (index >= maxArea) {
                    throw new NoSuchElementException("radius has been reached");
                }

                switch (leg) {
                    case 0:
                        ++x;
                        if (x == radius) {
                            ++leg;
                        }
                        break;
                    case 1:
                        ++y;
                        if (y == radius) {
                            ++leg;
                        }
                        break;
                    case 2:
                        --x;
                        if (-x == radius) {
                            ++leg;
                        }
                        break;
                    case 3:
                        --y;
                        if (-y == radius) {
                            leg = 0;
                            ++radius;
                        }
                        break;
                }

                pos.set(center.getX() + x, center.getY() + (clockwise ? y : -y));
                index++;
                return pos;
            }

            @Override
            public boolean hasNext() {
                return index < maxArea;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }
}
