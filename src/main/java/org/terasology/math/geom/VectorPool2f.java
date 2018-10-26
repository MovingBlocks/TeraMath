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
 * Represents a pool of Vector2fs, where Vector2fs can be freed into or drawn from to reduce
 * the amount of objects that have to be garbage collected.
 *
 * @author auto-generated
 */
public class VectorPool2f implements VectorPool<Vector2f> {
    public static class Helper{
        private static final VectorPool2f vectorPool = new VectorPool2f();

        /**
         * Marks vector for reuse.
         *
         * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
         * longer be used in the original place.
         *
         * @param v Vector2f to free
         */
        public static void free(Vector2f v) {
            vectorPool.free(v);
        }

        /**
         * Returns vector positioned at origin.
         *
         * @return New Vector2f with all dimensions set to 0.
         */
        public static Vector2f getVector() {
            return vectorPool.getVector();
        }

        /**
         * Returns copy of the passed-in vector.
         *
         * @param other Vector2f to make coy of
         * @return The copied vector
         */
        public static Vector2f getVector(Vector2f other) {
            return vectorPool.getVector(other);
        }

        public static Vector2f getVector(float x, float y) {
            return vectorPool.getVector(x, y);
        }
    }

    private final ArrayList<Vector2f> pool = new ArrayList<Vector2f>();

    /**
    * Returns a Vector2f to the pool.
    *
    * @param other The vector to return
    **/
    @Override
    public void free(Vector2f other) {
        synchronizedOperation(true, other);
    }

    /**
    * Retrieves a Vector2f from the pool of available Vector2fs and sets all the fields to 0.
    * A new Vector2f is created if the pool is empty.
    **/
    @Override
    public Vector2f getVector() {
        return getVector(0, 0);
    }

    /**
    * Retrieves a Vector2f from the pool and sets its value based on the value of other.
    * A new Vector2f is created if the pool is empty.
    *
    * @param other The vector to base retrieved vector of
    **/
    @Override
    public Vector2f getVector(Vector2f other) {
        return getVector(other.getX(), other.getY());
    }

   /**
     * Retrieves a Vector2f from the pool and sets its value to given coordinates.
     * A new Vector2f is created if the pool is empty.
     *
     * @param x the x component
     * @param y the y component
     * @return The created/drawn vector.
     */
    public Vector2f getVector(float x, float y) {

        Vector2f v = synchronizedOperation(false, null);
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
    private synchronized Vector2f synchronizedOperation (boolean free, Vector2f v) {
        if (free) {
            pool.add(v);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new Vector2f();
    }
}