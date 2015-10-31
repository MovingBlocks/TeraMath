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

/**
 * An {@link Iterable} that iterates along the outline of a rectangle.
 * <p>
 * The iterating vector is reused. <b>Do not attempt to store the instance</b> e.g. in a collection.
 */
public final class RectIterable implements Iterable<BaseVector2i> {

    private final ImmutableVector2i start;
    private final Direction startDir;
    private final boolean clockwise;
    private final Rect2i rect;

    /**
     * Starts the iteration at rect.min()
     * @param rect the rectangle to iterator on
     * @param clockwise true for clockwise iteration, false for counter-clockwise
     */
    public RectIterable(Rect2i rect, boolean clockwise) {
        this(rect, clockwise, rect.min());
    }

    public RectIterable(Rect2i rect, boolean clockwise, BaseVector2i start) {
        if (!rect.contains(start)) {
            throw new IllegalArgumentException("start must be on the border of the rectangle");
        }

        Direction dir = null;
        if (start.getX() == rect.maxX()) {
            dir = clockwise ? Direction.POS_Y : Direction.NEG_Y;
        }
        if (start.getY() == rect.maxY()) {
            dir = clockwise ? Direction.NEG_X : Direction.POS_X;
        }
        if (start.getX() == rect.minX()) {
            dir = clockwise ? Direction.NEG_Y : Direction.POS_Y;
        }
        if (start.getY() == rect.minY()) {
            if (clockwise && start.getX() < rect.maxX()) {
                dir = Direction.POS_X;
            }
            if (!clockwise && start.getX() > rect.minX()) {
                dir = Direction.NEG_X;
            }
        }
        if (dir == null) {
            throw new IllegalArgumentException("start must be on the border of the rectangle");
        }

        this.start = ImmutableVector2i.createOrUse(start);
        this.startDir = dir;
        this.rect = rect;
        this.clockwise = clockwise;
    }

    @Override
    public Iterator<BaseVector2i> iterator() {
        return new Iterator<BaseVector2i>() {
            private Vector2i pos = new Vector2i();
            private Direction dir = startDir;
            private int x = start.getX();
            private int y = start.getY();

            @Override
            public BaseVector2i next() {
                pos.set(x, y);

                switch (dir) {
                    case POS_X:
                        x++;
                        if (x == rect.maxX()) {
                            dir = clockwise ? Direction.POS_Y : Direction.NEG_Y;
                        }
                        break;
                    case POS_Y:
                        y++;
                        if (y == rect.maxY()) {
                            dir = clockwise ? Direction.NEG_X : Direction.POS_X;
                        }
                        break;
                    case NEG_X:
                        x--;
                        if (x == rect.minX()) {
                            dir = clockwise ? Direction.NEG_Y : Direction.POS_Y;
                        }
                        break;
                    case NEG_Y:
                        y--;
                        if (y == rect.minY()) {
                            dir = clockwise ? Direction.POS_X : Direction.NEG_X;
                        }
                        break;
                }

                return pos;
            }

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    private static enum Direction {
        POS_X,
        POS_Y,
        NEG_X,
        NEG_Y
    }

    /**
     * @return the length of one loop along the rectangle outline
     */
    public int length() {
        return 2 * rect.width() + 2 * rect.height() - 4; // -4 = 2*(-1) + 2*(-1) for maxX() and maxY()
    }
}
