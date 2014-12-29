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

import org.terasology.math.geom.BaseVector2d;

import com.google.common.base.Preconditions;

/**
 * An implementation of {@link BaseVector2d}, based on a double array
 * @author Martin Steiger
 */
public class ArrayBasedVector2d extends BaseVector2d {

    private final double[] array;
    private int ind;

    /**
     * @param array the backing double array
     * @param ind the index in the array (in vectors)
     */
    public ArrayBasedVector2d(double[] array, int ind) {
        Preconditions.checkArgument(ind * 2 + 1 < array.length, "Array too small");
        
        this.array = array;
        this.ind = ind;
    }
    
    /**
     * Set a new index
     * @param index the new index in the array
     */
    public void setIndex(int index) {
        ind = index;
    }

    @Override
    public double getX() {
        return array[ind * 2 + 0];
    }

    @Override
    public double getY() {
        return array[ind * 2 + 1];
    }

    @Override
    public double x() {
        return getX();
    }

    @Override
    public double y() {
        return getY();
    }


}
