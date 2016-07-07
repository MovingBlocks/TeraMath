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

import java.util.Random;

import org.junit.Test;

/**
 * Tests the {@link BaseQuat4d} class
 * @author Martin Steiger
 */
public class Quat4dTest {

    protected static final double EPSILON = 0.0000001;

    @Test
    public void testEquals() {
        assertEquals(new Quat4d(2, 2, 2, 2), new Quat4d(2, 2, 2, 2));
    }

    @Test
    public void testEqualsAgainstImmutable() {
        assertEquals(new ImmutableQuat4d(2, 2, 2, 2), new Quat4d(2, 2, 2, 2));
    }

    /**
     * X * X^-1 == 1
     */
    @Test
    public void testInversion() {
        Random r = new Random(1234);

        for (int i = 0; i < 100; i++) {
            double x = r.nextDouble() * 100;
            double y = r.nextDouble() * 100;
            double z = r.nextDouble() * 100;
            double w = r.nextDouble() * 2d * Math.PI;

            Quat4d q1 = new Quat4d(x, y, z, w);
            Quat4d q2 = new Quat4d(q1);
            q2.inverse();
            q1.mul(q2);
            assertQuat4dEquals(BaseQuat4d.IDENTITY, q1, EPSILON);
        }
    }

    @Test
    public void testRandomYawPitchRoll() {
        Random rng = new Random(1423);
        for (int i = 0; i < 10000; i++) {
            double yaw = rng.nextDouble() * 6.3f - 3.15f;
            double pitch = rng.nextDouble() * 3.14f - 1.57f;  // pitch values > 90deg result in a flipped rotation
            double roll = rng.nextDouble() * 6.3f - 3.15f;
            Quat4d q = new Quat4d(yaw, pitch, roll);
            assertEqualAngle(yaw, q.getYaw(), 0.01);
            assertEqualAngle(pitch, q.getPitch(), 0.01);
            assertEqualAngle(roll, q.getRoll(), 0.01);
        }
    }

    @Test
    public void testYawPitchRoll() {
        double yaw = 0.3;
        double pitch = -Math.PI;
        double roll = 0.1;
        Quat4d q = new Quat4d(yaw, pitch, roll);
        assertEqualAngle(yaw, q.getYaw(), 0.01);
        assertEqualAngle(pitch, q.getPitch(), 0.01);
        assertEqualAngle(roll, q.getRoll(), 0.01);
    }

    private void assertEqualAngle(double expected, double actual, double eps) {
        double ne = expected;
        double pi2 = Math.PI / 2;
        while (ne >= pi2) {
            ne -= Math.PI;
        }
        while (ne < -pi2) {
            ne += Math.PI;
        }
        double na = actual;
        while (na >= pi2) {
            na -= Math.PI;
        }
        while (na < -pi2) {
            na += Math.PI;
        }
        assertEquals(ne, na, eps);
    }

    private static void assertQuat4dEquals(BaseQuat4d a, BaseQuat4d b, double epsilon) {
        assertEquals("x not equal", a.getX(), b.getX(), epsilon);
        assertEquals("y not equal", a.getY(), b.getY(), epsilon);
        assertEquals("z not equal", a.getZ(), b.getZ(), epsilon);
        assertEquals("w not equal", a.getW(), b.getW(), epsilon);
    }

}
