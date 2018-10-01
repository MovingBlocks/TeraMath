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

import java.util.Iterator;
import gnu.trove.list.TFloatList;

/**
 * Describes an axis-aligned bounded space in 3D integer.
 */
public class $region/mutableType()$ extends $region/baseType()$ {

$if(!componentType.discrete)$
    public static final float DEFAULT_MARGIN = 0.01f;
    public static final float HALVING_FACTOR = 0.5f;
$endif$

    private $region/vector3Type()$ min = new $region/vector3Type()$();
    private $region/vector3Type()$ size = new $region/vector3Type()$();

    public $region/mutableType()$(){
    }

    public $region/mutableType()$($region/baseType()$ other){
        min.set(other.min());
        size.set(other.size());
    }

    @Override
    public $componentType$ sizeX(){
        return size.x();
    }

    @Override
    public $componentType$ sizeY(){
        return size.y();
    }

    @Override
    public $componentType$ sizeZ(){
        return size.z();
    }

    @Override
    public $region/vector3BaseType()$ size(){
        return size;
    }

    @Override
    public $componentType$ minX(){
        return min.x();
    }

    @Override
    public $componentType$ minY(){
        return min.y();
    }

    @Override
    public $componentType$ minZ(){
        return min.z();
    }

    @Override
    public $region/vector3BaseType()$ min(){
        return min;
    }

    public static $region/mutableType()$ createCenterExtent($region/vector3BaseType()$ center, $region/vector3BaseType()$ extent) {
        $region/vector3Type()$ min = new $region/vector3Type()$(center);
        min.sub(extent);
        $region/vector3Type()$ size = new $region/vector3Type()$(center);
        size.add(extent);
        size.sub(min);
        return new $region/mutableType()$().setMinSize(min, size);
    }

    public static $region/mutableType()$ createFromCenterExtents($region/vector3BaseType()$ center, $componentType$ extent) {
        $region/vector3Type()$ min = new  $region/vector3Type()$(center.x() - extent, center.y() - extent, center.z() - extent);
        $region/vector3Type()$ max = new  $region/vector3Type()$(center.x() + extent, center.y() + extent, center.z() + extent);
        return new $region/mutableType()$().setMinMax(min, max);
    }

    /**
     * Create a region by two point
     * @param a vertex a
     * @param b the diagonal vertex of a
     * @return a new region base on vertex a and b
     */
    public static $region/mutableType()$ createBounded($region/vector3BaseType()$ a, $region/vector3BaseType()$ b) {
        $region/vector3Type()$ min = new  $region/vector3Type()$(a);
        min.min(b);
        $region/vector3Type()$ max = new  $region/vector3Type()$(a);
        max.max(b);
        return new $region/mutableType()$().setMinMax(min, max);
    }

    public static $region/mutableType()$ createEncompassing(Iterable<$region/mutableType()$> others) {
        $region/vector3Type()$ min;
        $region/vector3Type()$ max;

        Iterator<$region/mutableType()$> i = others.iterator();
        if(i.hasNext()){
            $region/mutableType()$ next = i.next();
            min = new $region/vector3Type()$(next.min());
            max = new $region/vector3Type()$(next.max());
        } else{
            return new $region/mutableType()$(EMPTY);
        }
        while(i.hasNext()){
            $region/mutableType()$ next = i.next();
            min.min(next.min());
            max.max(next.max());
        }
        return new $region/mutableType()$().setMinMax(min, max);
    }

    public static $region/mutableType()$ createEncompassing($region/mutableType()$ a, $region/mutableType()$ b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        $region/vector3Type()$ min = new $region/vector3Type()$(a.min());
        min.min(b.min());
        $region/vector3Type()$ max = new $region/vector3Type()$(a.max());
        max.max(b.max());
        return new $region/mutableType()$().setMinMax(min, max);
    }

    /**
    * @param offset
    * @return A copy of the region offset by the given value
    */
    public $region/mutableType()$ move($region/vector3BaseType()$ offset) {
        min.add(offset);
        return this;
    }


    public  $region/mutableType()$ setMinSize($region/vector3BaseType()$ min, $region/vector3BaseType()$ size){
$if(componentType.discrete)$
        size.add(1);
$endif$
        if (size.x() <= 0 || size.y() <= 0 || size.z() <= 0) {
            return this;
        }
        this.min.set(min);
        this.size.set(size);
        return this;
    }

    public  $region/mutableType()$ setMinMax($region/vector3BaseType()$ min, $region/vector3BaseType()$ max){
        $region/vector3BaseType()$ size = new $region/vector3Type()$(max.x() - min.x(), max.y() - min.y() , max.z() - min.z());
        this.setMinSize(min,size);
        return this;
    }

    /**
    * @param other
    * @return The region that is encompassed by both this and other. If they
    * do not overlap then the empty region is returned
    */
    public $region/mutableType()$ intersect($region/mutableType()$ other) {
        $region/vector3Type()$ intersectMin = new $region/vector3Type()$(min());
        intersectMin.max(other.min());
        $region/vector3Type()$ intersectMax = new $region/vector3Type()$(max());
        intersectMax.min(other.max());
        return new $region/mutableType()$().setMinMax(intersectMin, intersectMax);
    }


    public static $region/mutableType()$ createEncompasing(TFloatList vertices) {
        $region/vector3Type()$ min = new $region/vector3Type()$(vertices.get(0), vertices.get(1), vertices.get(2));
        $region/vector3Type()$ max = new $region/vector3Type()$(vertices.get(0), vertices.get(1), vertices.get(2));
        int vertexCount = vertices.size() / 3;
        if (vertexCount == 0) {
            return new $region/mutableType()$();
        }

        for (int index = 1; index < vertexCount; ++index) {
            min.x = ($componentType$)Math.min(min.x, vertices.get(3 * index));
            max.x = ($componentType$)Math.max(max.x, vertices.get(3 * index));
            min.y = ($componentType$)Math.min(min.y, vertices.get(3 * index + 1));
            max.y = ($componentType$)Math.max(max.y, vertices.get(3 * index + 1));
            min.z = ($componentType$)Math.min(min.z, vertices.get(3 * index + 2));
            max.z = ($componentType$)Math.max(max.z, vertices.get(3 * index + 2));
        }
        $if(componentType.discrete)$
        max.add(1);
        $endif$
        return new $region/mutableType()$().setMinMax(min, max);
    }

$if(!componentType.discrete)$

    public $region/mutableType()$ transform(Quat4f rotation, Vector3f offset, float scale) {
        Transform transform = new Transform(offset, rotation, scale);
        return transform(transform);
    }

    public $region/mutableType()$ transform(Transform transform) {
        return transform(transform, DEFAULT_MARGIN);
    }

    public $region/mutableType()$ transform(Transform transform, float margin) {
        // Adaptation of method AabbUtil2.transformAabb from the TeraBullet library.
        $region/vector3Type()$ localHalfExtents = new $region/vector3Type()$();
        localHalfExtents.sub(max(), min());
        localHalfExtents.mul(HALVING_FACTOR);

        localHalfExtents.x += margin;
        localHalfExtents.y += margin;
        localHalfExtents.z += margin;

        Vector3f localCenter = new Vector3f(max());
        localCenter.add(min());
        localCenter.mul(HALVING_FACTOR);

        Matrix3f absBasis = transform.getBasis();

        absBasis.m00 = Math.abs(absBasis.m00);
        absBasis.m01 = Math.abs(absBasis.m01);
        absBasis.m02 = Math.abs(absBasis.m02);
        absBasis.m10 = Math.abs(absBasis.m10);
        absBasis.m11 = Math.abs(absBasis.m11);
        absBasis.m12 = Math.abs(absBasis.m12);
        absBasis.m20 = Math.abs(absBasis.m20);
        absBasis.m21 = Math.abs(absBasis.m21);
        absBasis.m22 = Math.abs(absBasis.m22);

        $region/vector3Type()$ center = new $region/vector3Type()$(localCenter);
        absBasis.transform(center);
        center.add(transform.origin);

        $region/vector3Type()$ extent = new $region/vector3Type()$();

        extent.x = absBasis.getRow(0).dot(localHalfExtents);
        extent.y = absBasis.getRow(1).dot(localHalfExtents);
        extent.z = absBasis.getRow(2).dot(localHalfExtents);

        Vector3f worldMin = new Vector3f();
        worldMin.sub(center, extent);

        Vector3f worldMax = new Vector3f(center).add(extent);

        return this.setMinSize(worldMin, worldMax);
    }

$endif$

}