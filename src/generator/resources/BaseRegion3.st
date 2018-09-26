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
/**
 * A 4-element quaternion represented by $componentType$ precision floating
 * point x,y,z,w coordinates.
 * @author Martin Steiger
 */
public abstract class $region/baseType()$ $if(componentType.discrete)$ implements Iterable<$region/vector3Type()$>  $endif${
    public static final $region/immutableType()$ EMPTY = new $region/immutableType()$(new $region/mutableType()$());

    public abstract $componentType$ minX();

    public abstract $componentType$ minY();

    public abstract $componentType$ minZ();

    public abstract $region/vector3BaseType()$ min();

    public $componentType$ maxX(){
        return minX() + sizeX();
    }

    public $componentType$ maxY(){
      return minY() + sizeY();
    }

    public $componentType$ maxZ(){
        return minZ() + sizeZ();
    }

    public $region/vector3BaseType()$ max(){
        return new $region/vector3Type()$(maxX(),maxY(),maxZ());
    }


    public abstract $componentType$ sizeX();

    public abstract $componentType$ sizeY();

    public abstract $componentType$ sizeZ();

    public abstract $region/vector3BaseType()$ size();

    /**
     * @param pos
     * @return The nearest position within the region to the given pos.
     */
    public $region/vector3Type()$ getNearestPointTo($region/vector3BaseType()$ pos) {
        $region/vector3Type()$ result = new $region/vector3Type()$(pos);
        result.min(max());
        result.max(min());
        return result;
    }

    /**
     * @param pos
     * @return Whether this region includes pos
     */
    public boolean contains($region/vector3BaseType()$ pos) {
        return contains(pos.getX(), pos.getY(), pos.getZ());
    }

    public boolean contains($componentType$ x, $componentType$ y, $componentType$ z) {
         return !(max().x() < x || min().x() >= x)
                        && !(max().y() < y || min().y() >= y)
                        && !(max().z() < z || min().z() >= z);
    }


    /**
     * Returns true if this region overlaps with another region.
     *
     * @param region The region to check for overlapping
     * @return True if overlapping
     */
    public boolean overlaps($region/baseType()$ region) {
        return !(max().x() < region.min().x() || min().x() > region.max().x())
                && !(max().y() < region.min().y() || min().y() > region.max().y())
                && !(max().z() < region.min().z() || min().z() > region.max().z());
    }


    public boolean isEmpty() {
        return sizeX() + sizeY() + sizeZ()  == 0;
    }

    /**
     * @return The position at the center of the region
     */
$if(componentType.discrete)$
    public Vector3f getExtents() {
        Vector3f result = size().toVector3f();
$else$
    public $region/vector3Type()$ getExtents() {
        $region/vector3Type()$ result = new $region/vector3Type()$(size());
$endif$
        result.scale(0.5f);
        return result;
    }


    /**
     * @return The position at the center of the region
     */
$if(componentType.discrete)$
    public Vector3f center() {
            Vector3f result = min().toVector3f();
            Vector3f halfSize = size().toVector3f();
$else$
    public $region/vector3Type()$ center() {
        $region/vector3Type()$ result = new $region/vector3Type()$(min());
        $region/vector3Type()$ halfSize = new $region/vector3Type()$(size());
$endif$
        halfSize.scale(0.5f);
        result.add(halfSize);
        return result;
    }

    /**
     * @return The position at the center of the region
     */
$if(componentType.discrete)$
    public Vector3f[] getVertices() {
      Vector3f[] vertices = new Vector3f[8];
$else$
    public $region/vector3Type()$[] getVertices() {
       $region/vector3Type()$[] vertices = new $region/vector3Type()$[8];
$endif$
        // Front
        vertices[0] = new Vector3f(minX(), minY(), maxZ());
        vertices[1] = new Vector3f(maxX(), minY(), maxZ());
        vertices[2] = new Vector3f(maxX(), maxY(), maxZ());
        vertices[3] = new Vector3f(minX(), maxY(), maxZ());
        // Back
        vertices[4] = new Vector3f(minX(), minY(), minZ());
        vertices[5] = new Vector3f(maxX(), minY(), minZ());
        vertices[6] = new Vector3f(maxX(), maxY(), minZ());
        vertices[7] = new Vector3f(minX(), maxY(), minZ());
        return vertices;
    }

$if(componentType.discrete)$
    public Vector3f centerPointForNormal(Direction dir) {
       Vector3f result = new Vector3f();
       Vector3f c = center();
$else$
    public $region/vector3Type()$ centerPointForNormal(Direction dir) {
         $region/vector3Type()$ result = new $region/vector3Type()$();
         $region/vector3Type()$ c = center();
$endif$
     switch (dir){
             case LEFT:
                result.set(maxX(), c.y(), c.z());
                break;
             case RIGHT:
                result.set(minX(), c.y(), c.z());
                break;
             case BACKWARD:
                result.set(c.x(), c.y(), maxZ());
                break;
             case UP:
                result.set(c.x(), c.y(), minZ());
                break;
             case DOWN:
                result.set(c.x(), maxY(), c.z());
                break;
             case FORWARD:
                result.set(c.x(), minY(), c.z());
                break;
         }

        return result;
    }

$if(componentType.discrete)$
        @Override
        public Iterator<$region/vector3Type()$> iterator() {
            return new RegionIterator();
        }

        /**
         * @param other
         * @return An iterator over the positions in this region that aren't in other
         */
        public Iterator<$region/vector3Type()$> subtract(Region3i other) {
            return new SubtractiveIterator(other);
        }



        private class RegionIterator implements Iterator<$region/vector3Type()$> {
                $region/vector3Type()$ pos;

                RegionIterator() {
                    this.pos = new $region/vector3Type()$();
                }

                @Override
                public boolean hasNext() {
                    return pos.x < size().x();
                }

                @Override
                public Vector3i next() {
                    Vector3i result = new Vector3i(pos.x + min().x(), pos.y + min().y(), pos.z + min().z());
                    pos.z++;
                    if (pos.z > size().z()) {
                        pos.z = 0;
                        pos.y++;
                        if (pos.y > size().y()) {
                            pos.y = 0;
                            pos.x++;
                        }
                    }
                    return result;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Not supported.");
                }
            }

            private class SubtractiveIterator implements Iterator<$region/vector3Type()$> {
                private Iterator<$region/vector3Type()$> innerIterator;
                private $region/vector3Type()$ next;
                private $region/mutableType()$ other;

                 SubtractiveIterator($region/mutableType()$ other) {
                    this.other = other;
                    innerIterator = iterator();
                    updateNext();
                }

                private void updateNext() {
                    while (innerIterator.hasNext()) {
                        next = innerIterator.next();
                        if (!other.contains(next)) {
                            return;
                        }
                    }
                    next = null;
                }

                @Override
                public boolean hasNext() {
                    return next != null;
                }

                @Override
                public $region/vector3Type()$ next() {
                    $region/vector3Type()$ result = new $region/vector3Type()$(next);
                    updateNext();
                    return result;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
$endif$

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof $region/baseType()$) {
            $region/baseType()$ other = ($region/baseType()$) obj;
            return min().equals(other.min()) && size().equals(other.size());
        }
        return false;
    }

    @Override
    public String toString() {
        return "(Min: " + min() + ", Size: " + size() + ")";
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash += 37 * hash + min().hashCode();
        hash += 37 * hash + size().hashCode();
        return hash;
    }

}