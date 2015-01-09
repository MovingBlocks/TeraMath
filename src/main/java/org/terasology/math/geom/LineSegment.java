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
 * Defines a line segment
 * @author Martin Steiger
 */
public final class LineSegment {

    private final ImmutableVector2d p0;
    private final ImmutableVector2d p1;

    /**
     * @param p0 the first point
     * @param p1 the second point
     */
    public LineSegment(BaseVector2d p0, BaseVector2d p1) {
        this.p0 = new ImmutableVector2d(p0);
        this.p1 = new ImmutableVector2d(p1);
    }

    /**
     * @return the first point
     */
    public ImmutableVector2d getP0() {
        return p0;
    }

    /**
     * @return the second point
     */
    public ImmutableVector2d getP1() {
        return p1;
    }

    /**
     * @return the direction (not normalized)
     */
    public ImmutableVector2d getDir() {
        return p1.sub(p0);
    }
}
