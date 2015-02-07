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

    private final ImmutableVector2f start;
    private final ImmutableVector2f end;

    /**
     * @param p0 the first point
     * @param p1 the second point
     */
    public LineSegment(BaseVector2f start, BaseVector2f end) {
        this.start = new ImmutableVector2f(start);
        this.end = new ImmutableVector2f(end);
    }

    /**
     * @return the starting point
     */
    public ImmutableVector2f getStart() {
        return start;
    }

    /**
     * @return the end point
     */
    public ImmutableVector2f getEnd() {
        return end;
    }

    /**
     * @return the direction (not normalized)
     */
    public ImmutableVector2f getDir() {
        return end.sub(start);
    }
}
