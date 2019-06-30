/*
 * Copyright 2019 MovingBlocks
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
 * An immutable implementation of {@link BaseQuat4d}
 * @author auto-generated
 */
public final class ImmutableQuat4d extends BaseQuat4d {

    private final double x;
    private final double y;
    private final double z;
    private final double w;

    /**
     * Constructs an instance from the specified xyzw coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w scalar component
     */
    public ImmutableQuat4d(double x, double y, double z, double w) {
        double mag = 1.0d / Math.sqrt(x * x + y * y + z * z + w * w);
        this.x = x * mag;
        this.y = y * mag;
        this.z = z * mag;
        this.w = w * mag;
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

    @Override
    public double getW() {
        return w;
    }

}
