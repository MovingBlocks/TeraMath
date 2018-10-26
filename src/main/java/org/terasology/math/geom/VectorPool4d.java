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
 * Represents a pool of Vector4ds, where Vector4ds can be freed into or drawn from to reduce
 * the amount of objects that have to be garbage collected.
 *
 * @author auto-generated
 */
public class VectorPool4d implements VectorPool<Vector4d> {
    public static class Helper{
        private static final VectorPool4d vectorPool = new VectorPool4d();

        /**
         * Marks vector for reuse.
         *
         * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
         * longer be used in the original place.
         *
         * @param v Vector4d to free
         */
        public static void free(Vector4d v) {
            vectorPool.free(v);
        }

        /**
         * Returns vector positioned at origin.
         *
         * @return New Vector4d with all dimensions set to 0.
         */
        public static Vector4d getVector() {
            return vectorPool.getVector();
        }

        /**
         * Returns copy of the passed-in vector.
         *
         * @param other Vector4d to make coy of
         * @return The copied vector
         */
        public static Vector4d getVector(Vector4d other) {
            return vectorPool.getVector(other);
        }

        public static Vector4d getVector(double x, double y, double z, double w) {
            return vectorPool.getVector(x, y, z, w);
        }
    }

    private final ArrayList<Vector4d> pool = new ArrayList<Vector4d>();

    /**
    * Returns a Vector4d to the pool.
    *
    * @param other The vector to return
    **/
    @Override
    public void free(Vector4d other) {
        synchronizedOperation(true, other);
    }

    /**
    * Retrieves a Vector4d from the pool of available Vector4ds and sets all the fields to 0.
    * A new Vector4d is created if the pool is empty.
    **/
    @Override
    public Vector4d getVector() {
        return getVector(0, 0, 0, 0);
    }

    /**
    * Retrieves a Vector4d from the pool and sets its value based on the value of other.
    * A new Vector4d is created if the pool is empty.
    *
    * @param other The vector to base retrieved vector of
    **/
    @Override
    public Vector4d getVector(Vector4d other) {
        return getVector(other.getX(), other.getY(), other.getZ(), other.getW());
    }

   /**
     * Retrieves a Vector4d from the pool and sets its value to given coordinates.
     * A new Vector4d is created if the pool is empty.
     *
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @param w the w component
     * @return The created/drawn vector.
     */
    public Vector4d getVector(double x, double y, double z, double w) {

        Vector4d v = synchronizedOperation(false, null);
        v.x = x;
        v.y = y;
        v.z = z;
        v.w = w;
        return v;
    }


    /**
     * Needs to be threadsafe, this is the easiest way.
     *
     * When {@code free} is true, {@code v} is freed and {@code null} is returned. When false, {@code v}
     * is ignored and vector is drawn and returned.
     */
    private synchronized Vector4d synchronizedOperation (boolean free, Vector4d v) {
        if (free) {
            pool.add(v);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new Vector4d();
    }
}
