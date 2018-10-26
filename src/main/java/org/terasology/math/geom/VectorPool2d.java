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
 * Represents a pool of Vector2ds, where Vector2ds can be freed into or drawn from to reduce
 * the amount of objects that have to be garbage collected.
 *
 * @author auto-generated
 */
public class VectorPool2d implements VectorPool<Vector2d> {
    public static class Helper{
        private static final VectorPool2d vectorPool = new VectorPool2d();

        /**
         * Marks vector for reuse.
         *
         * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
         * longer be used in the original place.
         *
         * @param v Vector2d to free
         */
        public static void free(Vector2d v) {
            vectorPool.free(v);
        }

        /**
         * Returns vector positioned at origin.
         *
         * @return New Vector2d with all dimensions set to 0.
         */
        public static Vector2d getVector() {
            return vectorPool.getVector();
        }

        /**
         * Returns copy of the passed-in vector.
         *
         * @param other Vector2d to make coy of
         * @return The copied vector
         */
        public static Vector2d getVector(Vector2d other) {
            return vectorPool.getVector(other);
        }

        public static Vector2d getVector(double x, double y) {
            return vectorPool.getVector(x, y);
        }
    }

    private final ArrayList<Vector2d> pool = new ArrayList<Vector2d>();

    /**
    * Returns a Vector2d to the pool.
    *
    * @param other The vector to return
    **/
    @Override
    public void free(Vector2d other) {
        synchronizedOperation(true, other);
    }

    /**
    * Retrieves a Vector2d from the pool of available Vector2ds and sets all the fields to 0.
    * A new Vector2d is created if the pool is empty.
    **/
    @Override
    public Vector2d getVector() {
        return getVector(0, 0);
    }

    /**
    * Retrieves a Vector2d from the pool and sets its value based on the value of other.
    * A new Vector2d is created if the pool is empty.
    *
    * @param other The vector to base retrieved vector of
    **/
    @Override
    public Vector2d getVector(Vector2d other) {
        return getVector(other.getX(), other.getY());
    }

   /**
     * Retrieves a Vector2d from the pool and sets its value to given coordinates.
     * A new Vector2d is created if the pool is empty.
     *
     * @param x the x component
     * @param y the y component
     * @return The created/drawn vector.
     */
    public Vector2d getVector(double x, double y) {

        Vector2d v = synchronizedOperation(false, null);
        v.x = x;
        v.y = y;
        return v;
    }


    /**
     * Needs to be threadsafe, this is the easiest way.
     *
     * When {@code free} is true, {@code v} is freed and {@code null} is returned. When false, {@code v}
     * is ignored and vector is drawn and returned.
     */
    private synchronized Vector2d synchronizedOperation (boolean free, Vector2d v) {
        if (free) {
            pool.add(v);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new Vector2d();
    }
}
