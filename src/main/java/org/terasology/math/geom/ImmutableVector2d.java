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
    public ImmutableVector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * @param other The Tuple2d to copy.
     */
    public ImmutableVector2d(Tuple2d other) {
        this(other.getX(), other.getY());
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

}
