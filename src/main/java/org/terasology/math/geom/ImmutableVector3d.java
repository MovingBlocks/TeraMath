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
 * An immutable Tuple3d, which is a point or vector in 3d space with double components.
 * This type is intended for use for constants, or any time you want a Tuple3d that is guaranteed immutable.
 *
 * @author Martin Steiger
 */
public final class ImmutableVector3d extends Tuple3d {

    private final double x;
    private final double y;
    private final double z;

    /**
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public ImmutableVector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor
     * @param other The Tuple3d to copy.
     */
    public ImmutableVector3d(Tuple3d other) {
        this(other.getX(), other.getY(), other.getZ());
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

}
