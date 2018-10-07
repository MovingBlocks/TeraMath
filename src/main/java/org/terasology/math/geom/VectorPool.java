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

/**
 * Pool of Vectors.
 *
 * VectorPool must be threadsafe!!
 *
 * @param <T> Type of object stored in pool
 */
public interface VectorPool<T> {
    /**
     * Marks vector for reuse.
     *
     * Freed vectors can be gotten by another thread or method right after the call to this, and freed vectors must no
     * longer be used in the original place.
     *
     * @param t Vector to free
     */
    void free(T t);

    /**
     * Returns vector positioned at origin.
     *
     * @return New vector with all dimensions set to 0.
     */
    T getVector();

    /**
     * Returns copy of the passed-in vector.
     *
     * @param other Vector to make coy of
     * @return The copied vector
     */
    T getVector(T other);
}
