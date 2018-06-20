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

package org.terasology.math.vectors;

import org.terasology.math.geom.Vector3i;

public class VectorPoolHelper {
    private static final Vector3iPool I3 = new Vector3iPool();

    private VectorPoolHelper() { }

    /**
     * Marks vector for reuse.
     *
     * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
     * longer be used in the original place.
     *
     * @param v Vector to free
     */
    public static void free(Vector3i v) {
        I3.free(v);
    }

    /**
     * Returns vector positioned at origin.
     *
     * @return New vector with all dimensions set to 0.
     */
    public static Vector3i getVector() {
        return I3.getVector();
    }

    /**
     * Returns copy of the passed-in vector.
     *
     * @param other Vector to make coy of
     * @return The copied vector
     */
    public static Vector3i getVector(Vector3i other) {
        return I3.getVector(other);
    }

    public static Vector3i getVector(int x, int y, int z) {
        return I3.getVector(x, y, z);
    }
}
