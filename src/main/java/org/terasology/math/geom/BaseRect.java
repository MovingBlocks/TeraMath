/*
 * Copyright 2018 MovingBlocks
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

/**
 * TODO Type description
 */
public abstract class BaseRect implements Shape {

    /**
     * The bitmask that indicates that a point lies to the left.
     */
    public static final int OUT_LEFT = 1;

    /**
     * The bitmask that indicates that a point lies above.
     */
    public static final int OUT_TOP = 2;

    /**
     * The bitmask that indicates that a point lies to the right.
     */
    public static final int OUT_RIGHT = 4;

    /**
     * The bitmask that indicates that a point lies below.
     */
    public static final int OUT_BOTTOM = 8;

    @Override
    public boolean contains(BaseVector2f v) {
        return contains(v.getX(), v.getY());
    }

    @Override
    public boolean contains(BaseVector2i v) {
        return contains(v.getX(), v.getY());
    }

    /**
     * Determines where the specified coordinates lie.
     * This method computes a binary OR of the appropriate mask values indicating, for each side,
     * whether or not the specified coordinates are on the same side of the edge.
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @return the combination of the appropriate out codes.
     */
    public abstract int outcode(float x, float y);
}
