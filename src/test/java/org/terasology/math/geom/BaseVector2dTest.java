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
 */
public abstract class BaseVector2dTest {

    protected static final double EPSILON = 0.0000001;

    /**
     * Used to generate tuples of the type to test
     * @param x
     * @param y
     * @return A new tuple.
     */
    protected abstract BaseVector2d createBaseVector2d(double x, double y);

    @Test
    public void getX() {
        BaseVector2d a = createBaseVector2d(42, 1);
        assertEquals(42, a.getX(), EPSILON);
    }

    @Test
    public void getY() {
        BaseVector2d a = createBaseVector2d(42, 17);
        assertEquals(17, a.getY(), EPSILON);
    }

    @Test
    public void lerpOfZero() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(a, BaseVector2d.lerp(a, b, 0), EPSILON);
    }

    @Test
    public void lerpOfOne() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(b, BaseVector2d.lerp(a, b, 1), EPSILON);
    }

    @Test
    public void lerpInbetween() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(createBaseVector2d(0.7, 0.7 * 5.3), BaseVector2d.lerp(a, b, 0.7), EPSILON);
    }

    @Test
    public void lerpInbetweenTwoNonZeroTuples() {
        BaseVector2d a = createBaseVector2d(-1, 4.3);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(createBaseVector2d(0.4, 5.0), BaseVector2d.lerp(a, b, 0.7), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lerpLessThanZero() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(createBaseVector2d(0.7, 0.7 * 5.3), BaseVector2d.lerp(a, b, -0.7), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lerpGreaterThanOne() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 5.3);
        assertBaseVector2dEquals(createBaseVector2d(0.7, 0.7 * 5.3), BaseVector2d.lerp(a, b, 1.2), EPSILON);
    }

    @Test
    public void lengthZero() {
        assertEquals(0, createBaseVector2d(0, 0).length(), EPSILON);
    }

    @Test
    public void lengthOne() {
        assertEquals(Math.sqrt(2), createBaseVector2d(1, 1).length(), EPSILON);
    }

    @Test
    public void lengthSquared() {
        assertEquals(2, createBaseVector2d(1, 1).lengthSquared(), EPSILON);
    }

    @Test
    public void lengthWithNegativeDimensions() {
        assertEquals(Math.sqrt(2), createBaseVector2d(-1, 1).length(), EPSILON);
    }

    @Test
    public void distanceFromZero() {
        BaseVector2d a = createBaseVector2d(0, 0);
        BaseVector2d b = createBaseVector2d(1, 2);
        assertEquals(Math.sqrt(5), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(5), b.distance(a), EPSILON);
    }

    @Test
    public void distanceFromArbitrary() {
        BaseVector2d a = createBaseVector2d(-4, 3);
        BaseVector2d b = createBaseVector2d(1, 2);
        assertEquals(Math.sqrt(26), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(26), b.distance(a), EPSILON);
    }

    @Test
    public void staticDistance() {
        BaseVector2d a = createBaseVector2d(-4, 3);
        BaseVector2d b = createBaseVector2d(1, 2);
        assertEquals(Math.sqrt(26), BaseVector2d.distance(a, b), EPSILON);
        assertEquals(Math.sqrt(26), BaseVector2d.distance(b, a), EPSILON);
    }

    @Test
    public void distanceSquared() {
        BaseVector2d a = createBaseVector2d(-4, 3);
        BaseVector2d b = createBaseVector2d(1, 2);
        assertEquals(26, a.distanceSquared(b), EPSILON);
        assertEquals(26, b.distanceSquared(a), EPSILON);
    }

    @Test
    public void project() {
        BaseVector2d a = createBaseVector2d(-4, 3);
        BaseVector2d b = createBaseVector2d(1, 2);

        // a.lengthSquared() == 25.0
        // a.dot(b) == 2
        BaseVector2d projected = createBaseVector2d(-4 * 2 / 25.0, 3 * 2 / 25.0);

        assertBaseVector2dEquals(projected, b.project(a), EPSILON);
    }

    @Test
    public void projectAlongAxes() {
        BaseVector2d a = createBaseVector2d(-4, 3);

        BaseVector2d alongX = createBaseVector2d(1011, 0);
        assertBaseVector2dEquals(createBaseVector2d(a.getX(), 0), a.project(alongX), EPSILON);

        BaseVector2d alongY = createBaseVector2d(0, 333.333);
        assertBaseVector2dEquals(createBaseVector2d(0, a.getY()), a.project(alongY), EPSILON);
    }

    @Test
    public void projectPerpendicular() {
        BaseVector2d a = createBaseVector2d(-4, 3);
        BaseVector2d b = createBaseVector2d(3, 4);

        // Just to confirm that they are actually perpendicular
        assertEquals(0.0, a.dot(b), EPSILON);

        assertBaseVector2dEquals(BaseVector2d.ZERO, b.project(a), EPSILON);
    }

    public static void assertBaseVector2dEquals(BaseVector2d a, BaseVector2d b, double epsilon) {
        assertEquals(a.getX(), b.getX(), epsilon);
        assertEquals(a.getY(), b.getY(), epsilon);
    }
}
