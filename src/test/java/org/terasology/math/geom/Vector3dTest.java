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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Some vector related tests
 *
 * @author Martin Steiger
 */
public class Vector3dTest extends BaseVector3dTest {

    private Vector3d v = new Vector3d();

    @Test
    public void testEquals() {
        assertEquals(new Vector3d(2, 2, 2), new Vector3d(2, 2, 2));
    }

    @Test
    public void testEqualsAgainstImmutable() {
        assertEquals(new ImmutableVector3d(2, 2, 2), new Vector3d(2, 2, 2));
    }

    @Test
    public void emptyConstructorIsIdentityVector() {
        assertEquals(new Vector3d(0, 0, 0), new Vector3d());
    }

    @Test
    public void setVector() {
        Vector3d result = v.set(12, 34, 56);
        assertSame(v, result);
        assertEquals(new Vector3d(12, 34, 56), v);
    }

    @Test
    public void setVectorToTuple() {
        Vector3d result = v.set(new ImmutableVector3d(12, 34, 56));
        assertSame(v, result);
        assertEquals(new Vector3d(12, 34, 56), v);
    }

    @Test
    public void setXComponent() {
        Vector3d result = v.setX(12.43);
        assertSame(v, result);
        assertEquals(12.43, v.getX(), EPSILON);
    }

    @Test
    public void setYComponent() {
        Vector3d result = v.setY(12.43);
        assertSame(v, result);
        assertEquals(12.43, v.getY(), EPSILON);
    }

    @Test
    public void setZComponent() {
        Vector3d result = v.setZ(12.43);
        assertSame(v, result);
        assertEquals(12.43, v.getZ(), EPSILON);
    }
    
    @Test
    public void addToXComponent() {
        Vector3d result = v.setX(2.3).addX(1.4);
        assertSame(v, result);
        assertEquals(3.7, v.getX(), EPSILON);
    }

    @Test
    public void addToYComponent() {
        Vector3d result = v.setY(2.3).addY(1.4);
        assertSame(v, result);
        assertEquals(3.7, v.getY(), EPSILON);
    }

    @Test
    public void addToZComponent() {
        Vector3d result = v.setZ(2.3).addZ(1.4);
        assertSame(v, result);
        assertEquals(3.7, v.getZ(), EPSILON);
    }
    
    @Test
    public void subtractFromXComponent() {
        Vector3d result = v.setX(2.3).subX(1.4);
        assertSame(v, result);
        assertEquals(0.9, v.getX(), EPSILON);
    }

    @Test
    public void subtractFromYComponent() {
        Vector3d result = v.setY(2.3).subY(1.4);
        assertSame(v, result);
        assertEquals(0.9, v.getY(), EPSILON);
    }

    @Test
    public void subtractFromZComponent() {
        Vector3d result = v.setZ(2.3).subZ(1.4);
        assertSame(v, result);
        assertEquals(0.9, v.getZ(), EPSILON);
    }
    
    @Test
    public void multiplyXComponent() {
        Vector3d result = v.setX(1.2).mulX(2);
        assertSame(v, result);
        assertEquals(2.4, v.getX(), EPSILON);
    }

    @Test
    public void multiplyYComponent() {
        Vector3d result = v.setY(1.2).mulY(2);
        assertSame(v, result);
        assertEquals(2.4, v.getY(), EPSILON);
    }

    @Test
    public void multiplyZComponent() {
        Vector3d result = v.setZ(1.2).mulZ(2);
        assertSame(v, result);
        assertEquals(2.4, v.getZ(), EPSILON);
    }
    
    @Test
    public void divideXComponent() {
        Vector3d result = v.setX(1.2).divX(2);
        assertSame(v, result);
        assertEquals(0.6, v.getX(), EPSILON);
    }

    @Test
    public void divideYComponent() {
        Vector3d result = v.setY(1.2).divY(2);
        assertSame(v, result);
        assertEquals(0.6, v.getY(), EPSILON);
    }

    @Test
    public void divideZComponent() {
        Vector3d result = v.setZ(1.2).divZ(2);
        assertSame(v, result);
        assertEquals(0.6, v.getZ(), EPSILON);
    }
    
    @Override
    protected BaseVector3d createBaseVector3d(double x, double y, double z) {
        return new Vector3d(x, y, z);
    }


}
