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

import java.util.ArrayList;
import org.terasology.math.vectors.VectorPool;

/**
 * Represents a pool of $vectorpool/baseType()$s, where $vectorpool/baseType()$s can be freed into or drawn from to reduce
 * the amount of objects that have to be garbage collected.
 *
 * @author auto-generated
 */
public class $vectorpool/mutableType()$ implements VectorPool<$vectorpool/baseType()$> {

    private final ArrayList<$vectorpool/baseType()$> pool = new ArrayList<$vectorpool/baseType()$>();

    /**
    * Returns a $vectorpool/baseType()$ to the pool.
    *
    * @param other The vector to return
    **/
    @Override
    public void free($vectorpool/baseType()$ other) {
        synchronizedOperation(true, other);
    }

    /**
    * Retrieves a $vectorpool/baseType()$ from the pool of available $vectorpool/baseType()$s and sets all the fields to 0.
    * A new $vectorpool/baseType()$ is created if the pool is empty.
    **/
    @Override
    public $vectorpool/baseType()$ getVector() {
        return getVector($components:{x| 0}; separator = ", "$);
    }

    /**
    * Retrieves a $vectorpool/baseType()$ from the pool and sets its value based on the value of other.
    * A new $vectorpool/baseType()$ is created if the pool is empty.
    *
    * @param other The vector to base retrieved vector of
    **/
    @Override
    public $vectorpool/baseType()$ getVector($vectorpool/baseType()$ other) {
        return getVector($components:{x| other.get$x.proper$()}; separator = ", "$);
    }

   /**
     * Retrieves a $vectorpool/baseType()$ from the pool and sets its value to given coordinates.
     * A new $vectorpool/baseType()$ is created if the pool is empty.
     *
     $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     * @return The created/drawn vector.
     */
    public $vectorpool/baseType()$ getVector($components:{x| $componentType$ $x$}; separator = ", "$) {

        $vectorpool/baseType()$ v = synchronizedOperation(false, null);
        $components:{x| v.$x$ = $x$;}; separator = "\n"$
        return v;
    }


    /**
     * Needs to be threadsafe, this is the easiest way.
     *
     * When {@code free} is true, {@code v} is freed and {@code null} is returned. When false, {@code v}
     * is ignored and vector is drawn and returned.
     */
    private synchronized $vectorpool/baseType()$ synchronizedOperation (boolean free, $vectorpool/baseType()$ v) {
        if (free) {
            pool.add(v);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new $vectorpool/baseType()$();
    }
}