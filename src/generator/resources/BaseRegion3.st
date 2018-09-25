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


/**
 * A 4-element quaternion represented by $componentType$ precision floating
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public abstract class $region/baseType()$ {

    /**
     * @return the x component
     */
    public abstract $region/baseType()$ min();

    public abstract $componentType$ minX();

    public abstract $componentType$ minY();

    public abstract $componentType$ minZ();

    public abstract $region/baseType()$ max();

    public $componentType$ maxX(){
    $if(isDiscrete)$
        return minX() + sizeX() - 1;
    $else$
        return minX() + sizeX();
    $endif$
    }

    public $componentType$ maxY(){
    $if(isDiscrete)$
      return minY() + sizeY() - 1;
    $else$
      return minY() + sizeY();
    $endif$
    }

    public $componentType$ maxZ(){
    $if(isDiscrete)$
        return minZ() + sizeZ() - 1;
    $else$
        return minZ() + sizeZ();
    $endif$
    }

    public abstract $region/baseType()$ size();

    public abstract $componentType$ sizeX();

    public abstract $componentType$ sizeY();

    public abstract $componentType$ sizeZ();


    /**
     * @param other
     * @return The region that is encompassed by both this and other. If they
     * do not overlap then the empty region is returned
     */
   /** public $region/mutableType()$ intersect($region/mutableType()$ other) {
        $region/vector3Type()$ intersectMin = min();
        intersectMin.max(other.min());
        $region/vector3Type()$ intersectMax = max();
        intersectMax.min(other.max());

        return createFromMinMax(intersectMin, intersectMax);
    }**/


}