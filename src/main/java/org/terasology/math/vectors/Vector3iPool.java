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

package org.terasology.math.vectors;

import org.terasology.math.geom.Vector3i;

import java.util.ArrayList;

public class Vector3iPool implements VectorPool<Vector3i> {
    private final ArrayList<Vector3i> pool = new ArrayList<Vector3i>();
    @Override
    public void free(Vector3i vector3i) {
        synchronizedOperation(true, vector3i);
    }

    @Override
    public Vector3i getVector() {
        return getVector(0, 0, 0);
    }

    @Override
    public Vector3i getVector(Vector3i other) {
        return getVector(other.x, other.y, other.z);
    }

    /**
     * Returns vector set to the specified values.
     *
     * @param x X value of the vector
     * @param y Y value of the vector
     * @param z Z value of the vector
     * @return The created/drawn vector.
     */
    public Vector3i getVector(int x, int y, int z) {
        Vector3i v = synchronizedOperation(false, null);
        v.x = x;
        v.y = y;
        v.z = z;
        return v;
    }

    /**
     * Needs to be threadsafe, this is the easiest way.
     *
     * When {@code free} is true, {@code vector3i} is freed and {@code null} is returned. When false, {@code vector3i}
     * is ignored and vector is drawn and returned.
     */
    private synchronized Vector3i synchronizedOperation (boolean free, Vector3i vector3i) {
        if (free) {
            pool.add(vector3i);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new Vector3i();
    }
}
