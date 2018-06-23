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
 * $vector/mutableType()$ is the mutable implementation of $vector/baseType()$, for representing a pool of saved vectors in $dimensions$ dimensional space of type
 * $componentType$. This reduces the memory that has to be freed by the garbage collects by reusing an existing vector.
 *
 * @author auto-generated
 */
public class $vectorpool/mutableType()$ implements VectorPool<$vectorpool/baseType()$> {

    private final ArrayList<$vectorpool/baseType()$> pool = new ArrayList<$vectorpool/baseType()$>();

    /**
    * returns a $vectorpool/baseType()$ to the pool
    *
    * @param other the vector to return
    **/
    @Override
    public void free($vectorpool/baseType()$ other) {
        synchronizedOperation(true, other);
    }

    /**
    * retrieves a $vectorpool/baseType()$ from the pool of available $vectorpool/baseType()$ and sets all the fields to 0.
    * A new $vectorpool/baseType()$ is created if the pool is empty.
    *
    * @param other the vector to return
    **/
    @Override
    public $vectorpool/baseType()$ getVector() {
        return getVector($components:{x| 0}; separator = ", "$);
    }

    /**
    * retrieves a $vectorpool/baseType()$ from the pool and sets the fields based off of other.
    *
    * @param other the vector to return
    **/
    @Override
    public $vectorpool/baseType()$ getVector($vectorpool/baseType()$ other) {
        return getVector($components:{x| other.get$x.proper$()}; separator = ", "$);
    }

   /**
     * retrieves a $vectorpool/baseType()$ from the pool and sets the fields based off the given components
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
     * When {@code free} is true, {@code $vectorpool/baseType()$} is freed and {@code null} is returned. When false, {@code vector3i}
     * is ignored and vector is drawn and returned.
     */
    private synchronized $vectorpool/baseType()$ synchronizedOperation (boolean free, $vectorpool/baseType()$ other) {
        if (free) {
            pool.add(other);
            return null;
        }
        if (pool.size() > 0) {
            return pool.remove(pool.size() - 1);
        }
        return new $vectorpool/baseType()$();
    }
}