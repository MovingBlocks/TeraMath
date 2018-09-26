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
 * Describes an axis-aligned bounded space in 3D integer.
 */
public class $region/immutableType()$ extends $region/baseType()$ {

    private final $region/vector3ImmutableType()$ min;
    private final $region/vector3ImmutableType()$ size;

    public  $region/immutableType()$($region/baseType()$ other){
        min = new $region/vector3ImmutableType()$(other.min());
        size = new $region/vector3ImmutableType()$(other.size());
    }

    @Override
    public $componentType$ minX(){
        return min.getX();
    }

    @Override
    public $componentType$ minY(){
        return min.getY();
    }

    @Override
    public $componentType$ minZ(){
        return min.getZ();
    }

    @Override
    public $region/vector3BaseType()$ min(){
        return min;
    }

    @Override
    public $componentType$ sizeX(){
        return size.getX();

    }
    @Override
    public $componentType$ sizeY(){
        return size.getY();
    }
    @Override
    public $componentType$ sizeZ(){
        return size.getZ();
    }

   @Override
    public $region/vector3BaseType()$ size(){
        return size;
    }

}