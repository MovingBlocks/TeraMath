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

    @Test
    public void project() {
        BaseVector3d a = createBaseVector3d(-4, 3, 2);
        BaseVector3d b = createBaseVector3d(1, 2, 1);

        // a.lengthSquared == 29.0;
        // a.dot(b) == 4.0;
        BaseVector3d projected = createBaseVector3d(-4 * 4.0 / 29.0, 3 * 4.0 / 29.0, 2 * 4.0 / 29.0);

        assertBaseVector3dEquals(projected, b.project(a), EPSILON);
    }

    @Test
    public void projectAlongAxes() {
        BaseVector3d a = createBaseVector3d(-4, 3, 2);

        BaseVector3d alongX = createBaseVector3d(1011, 0, 0);
        assertBaseVector3dEquals(createBaseVector3d(a.getX(), 0, 0), a.project(alongX), EPSILON);

        BaseVector3d alongY = createBaseVector3d(0, 333.333, 0);
        assertBaseVector3dEquals(createBaseVector3d(0, a.getY(), 0), a.project(alongY), EPSILON);

        BaseVector3d alongZ = createBaseVector3d(0, 0, 1337.1337);
        assertBaseVector3dEquals(createBaseVector3d(0, 0, a.getZ()), a.project(alongZ), EPSILON);
    }

    @Test
    public void projectPerpendicular() {
        BaseVector3d a = createBaseVector3d(-4, 2, -1);
        BaseVector3d b = createBaseVector3d(3, 9, 6);

        // Just to confirm that they are actually perpendicular
        assertEquals(0.0, a.dot(b), EPSILON);

        assertBaseVector3dEquals(BaseVector3d.ZERO, b.project(a), EPSILON);
    }


    public static void assertBaseVector3dEquals(BaseVector3d a, BaseVector3d b, double epsilon) {
        assertEquals(a.getX(), b.getX(), epsilon);
        assertEquals(a.getY(), b.getY(), epsilon);
        assertEquals(a.getZ(), b.getZ(), epsilon);
    }
}
