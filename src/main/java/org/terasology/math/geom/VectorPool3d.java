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

import java.util.ArrayList;

/**
 * Represents a pool of Vector3ds, where Vector3ds can be freed into or drawn from to reduce
 * the amount of objects that have to be garbage collected.
 *
 * @author auto-generated
 */
public class VectorPool3d implements VectorPool<Vector3d> {
    public static class Helper{
        private static final VectorPool3d vectorPool = new VectorPool3d();

        /**
         * Marks vector for reuse.
         *
         * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
         * longer be used in the original place.
         *
         * @param v Vector3d to free
         */
        public static void free(Vector3d v) {
            vectorPool.free(v);
        }

        /**
         * Returns vector positioned at origin.
         *
         * @return New Vector3d with all dimensions set to 0.
         */
        public static Vector3d getVector() {
            return vectorPool.getVector();
        }

        /**
         * Returns copy of the passed-in vector.
         *
         * @param other Vector3d to make coy of
         * @return The copied vector
         */
        public static Vector3d getVector(Vector3d other) {
            return vectorPool.getVector(other);
        }

        public static Vector3d getVector(double x, double y, double z) {
            return vectorPool.getVector(x, y, z);
        }
    }

    private final ArrayList<Vector3d> pool = new ArrayList<Vector3d>();

    /**
    * Returns a Vector3d to the pool.
    *
    * @param other The vector to return
    **/
    @Override
    public void free(Vector3d other) {
        synchronizedOperation(true, other);
    }

    /**
    * Retrieves a Vector3d from the pool of available Vector3ds and sets all the fields to 0.
    * A new Vector3d is created if the pool is empty.
    **/
    @Override
    public Vector3d getVector() {
        return getVector(0, 0, 0);
    }

    /**
    * Retrieves a Vector3d from the pool and sets its value based on the value of other.
    * A new Vector3d is created if the pool is empty.
    *
    * @param other The vector to base retrieved vector of
    **/
    @Override
    public Vector3d getVector(Vector3d other) {
        return getVector(other.getX(), other.getY(), other.getZ());
    }

   /**
     * Retrieves a Vector3d from the pool and sets its value to given coordinates.
     * A new Vector3d is created if the pool is empty.
     *
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @return The created/drawn vector.
     */
    public Vector3d getVector(double x, double y, double z) {

        Vector3d v = synchronizedOperation(false, null);
        v.x = x;
        v.y = y;
        v.z = z;
        return v;
    }


    /**
     * Needs to be threadsafe, this is the easiest way.
     *
     * When {@code free} is true, {@code v} is freed and {@code null} is returned. When false, {@code v}
     * is ignored and vector is drawn and returned.
     */
    private synchronized Vector3d synchronizedOperation (boolean free, Vector3d v) {
        if (free) {
            pool.add(v);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new Vector3d();
    }
}
