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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Immortius
 * @author Martin Steiger
 */
public abstract class BaseVector3dTest {

    protected static final double EPSILON = 0.0000001;

    /**
     * Used to generate tuples of the type to test
     * @param x
     * @param y
     * @return A new tuple.
     */
    protected abstract BaseVector3d createBaseVector3d(double x, double y, double z);

    @Test
    public void getX() {
        BaseVector3d a = createBaseVector3d(42, 17, 83);
        assertEquals(42, a.getX(), EPSILON);
    }

    @Test
    public void getY() {
        BaseVector3d a = createBaseVector3d(42, 17, 83);
        assertEquals(17, a.getY(), EPSILON);
    }

    @Test
    public void getZ() {
        BaseVector3d a = createBaseVector3d(42, 17, 83);
        assertEquals(83, a.getZ(), EPSILON);
    }

    @Test
    public void lerpOfZero() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 5.3, 7.9);
        assertBaseVector3dEquals(a, BaseVector3d.lerp(a, b, 0), EPSILON);
    }

    @Test
    public void lerpOfOne() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 5.3, 7.9);
        assertBaseVector3dEquals(b, BaseVector3d.lerp(a, b, 1), EPSILON);
    }

    @Test
    public void lerpInbetween() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 5.3, 7.9);
        assertBaseVector3dEquals(createBaseVector3d(0.7, 0.7 * 5.3, 0.7 * 7.9), BaseVector3d.lerp(a, b, 0.7), EPSILON);
    }

    @Test
    public void lerpInbetweenTwoNonZeroTuples() {
        BaseVector3d a = createBaseVector3d(-1, 4.3, 10);
        BaseVector3d b = createBaseVector3d(1, 5.3, 20);
        assertBaseVector3dEquals(createBaseVector3d(0.4, 5.0, 17.0), BaseVector3d.lerp(a, b, 0.7), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lerpLessThanZero() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 5.3, 7.9);
        assertBaseVector3dEquals(createBaseVector3d(0.7, 0.7 * 5.3, 0.7 * 7.9), BaseVector3d.lerp(a, b, -0.7), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lerpGreaterThanOne() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 5.3, 7.9);
        assertBaseVector3dEquals(createBaseVector3d(0.7, 0.7 * 5.3, 0.7 * 7.9), BaseVector3d.lerp(a, b, 1.2), EPSILON);
    }

    @Test
    public void lengthZero() {
        assertEquals(0, createBaseVector3d(0, 0, 0).length(), EPSILON);
    }

    @Test
    public void lengthOne() {
        assertEquals(Math.sqrt(3), createBaseVector3d(1, 1, 1).length(), EPSILON);
    }

    @Test
    public void lengthSquared() {
        assertEquals(3, createBaseVector3d(1, 1, 1).lengthSquared(), EPSILON);
    }

    @Test
    public void lengthWithNegativeDimensions() {
        assertEquals(Math.sqrt(3), createBaseVector3d(-1, 1, -1).length(), EPSILON);
    }

    @Test
    public void distanceFromZero() {
        BaseVector3d a = createBaseVector3d(0, 0, 0);
        BaseVector3d b = createBaseVector3d(1, 2, 3);
        assertEquals(Math.sqrt(14), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(14), b.distance(a), EPSILON);
    }

    @Test
    public void distanceFromArbitrary() {
        BaseVector3d a = createBaseVector3d(-4, 3, 10);
        BaseVector3d b = createBaseVector3d(1, 2, 12);
        assertEquals(Math.sqrt(30), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(30), b.distance(a), EPSILON);
    }

    @Test
    public void staticDistance() {
        BaseVector3d a = createBaseVector3d(-4, 3, 10);
        BaseVector3d b = createBaseVector3d(1, 2, 12);
        assertEquals(Math.sqrt(30), BaseVector3d.distance(a, b), EPSILON);
        assertEquals(Math.sqrt(30), BaseVector3d.distance(b, a), EPSILON);
    }

    @Test
    public void distanceSquared() {
        BaseVector3d a = createBaseVector3d(-4, 3, 10);
        BaseVector3d b = createBaseVector3d(1, 2, 12);
        assertEquals(30, a.distanceSquared(b), EPSILON);
        assertEquals(30, b.distanceSquared(a), EPSILON);
    }

    public static void assertBaseVector3dEquals(BaseVector3d a, BaseVector3d b, double epsilon) {
        assertEquals(a.getX(), b.getX(), epsilon);
        assertEquals(a.getY(), b.getY(), epsilon);
        assertEquals(a.getZ(), b.getZ(), epsilon);
    }
}
