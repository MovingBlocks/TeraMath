package org.terasology.math.geom;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Immortius
 */
public abstract class BaseTuple2dTest {

    protected static double EPSILON = 0.0000001;

    /**
     * Used to generate tuples of the type to test
     * @param x
     * @param y
     * @return A new tuple.
     */
    protected abstract Tuple2d createTuple2d(double x, double y);

    @Test
    public void getX() {
        Tuple2d a = createTuple2d(42, 1);
        assertEquals(42, a.getX(), EPSILON);
    }

    @Test
    public void getY() {
        Tuple2d a = createTuple2d(42, 17);
        assertEquals(17, a.getY(), EPSILON);
    }

    @Test
    public void lerpOfZero() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(a, Tuple2d.lerp(a, b, 0), EPSILON);
    }

    @Test
    public void lerpOfOne() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(b, Tuple2d.lerp(a, b, 1), EPSILON);
    }

    @Test
    public void lerpInbetween() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(createTuple2d(0.7, 0.7 * 5.3), Tuple2d.lerp(a, b, 0.7), EPSILON);
    }

    @Test
    public void lerpInbetweenTwoNonZeroTuples() {
        Tuple2d a = createTuple2d(-1, 4.3);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(createTuple2d(0.4, 5.0), Tuple2d.lerp(a, b, 0.7), EPSILON);
    }

    @Test(expected=IllegalArgumentException.class)
    public void lerpLessThanZero() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(createTuple2d(0.7, 0.7 * 5.3), Tuple2d.lerp(a, b, -0.7), EPSILON);
    }

    @Test(expected=IllegalArgumentException.class)
    public void lerpGreaterThanOne() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 5.3);
        assertTuple2dEquals(createTuple2d(0.7, 0.7 * 5.3), Tuple2d.lerp(a, b, 1.2), EPSILON);
    }

    @Test
    public void lengthZero() {
        assertEquals(0, createTuple2d(0, 0).length(), EPSILON);
    }

    @Test
    public void lengthOne() {
        assertEquals(Math.sqrt(2), createTuple2d(1, 1).length(), EPSILON);
    }

    @Test
    public void lengthSquared() {
        assertEquals(2, createTuple2d(1, 1).lengthSquared(), EPSILON);
    }

    @Test
    public void lengthWithNegativeDimensions() {
        assertEquals(Math.sqrt(2), createTuple2d(-1, 1).length(), EPSILON);
    }

    @Test
    public void distanceFromZero() {
        Tuple2d a = createTuple2d(0, 0);
        Tuple2d b = createTuple2d(1, 2);
        assertEquals(Math.sqrt(5), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(5), b.distance(a), EPSILON);
    }

    @Test
    public void distanceFromArbitrary() {
        Tuple2d a = createTuple2d(-4, 3);
        Tuple2d b = createTuple2d(1, 2);
        assertEquals(Math.sqrt(26), a.distance(b), EPSILON);
        assertEquals(Math.sqrt(26), b.distance(a), EPSILON);
    }

    @Test
    public void staticDistance() {
        Tuple2d a = createTuple2d(-4, 3);
        Tuple2d b = createTuple2d(1, 2);
        assertEquals(Math.sqrt(26), Tuple2d.distance(a, b), EPSILON);
        assertEquals(Math.sqrt(26), Tuple2d.distance(b, a), EPSILON);
    }

    @Test
    public void distanceSquared() {
        Tuple2d a = createTuple2d(-4, 3);
        Tuple2d b = createTuple2d(1, 2);
        assertEquals(26, a.distanceSquared(b), EPSILON);
        assertEquals(26, b.distanceSquared(a), EPSILON);
    }

    public static void assertTuple2dEquals(Tuple2d a, Tuple2d b, double epsilon) {
        assertEquals(a.getX(), b.getX(), epsilon);
        assertEquals(a.getY(), b.getY(), epsilon);
    }
}
