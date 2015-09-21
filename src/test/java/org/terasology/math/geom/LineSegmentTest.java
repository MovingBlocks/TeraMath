/*
 * Copyright 2015 MovingBlocks
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

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the LineSegment class.
 */
public class LineSegmentTest {

    @Test
    public void testDistancePoint() {
        ImmutableVector2f p0 = new ImmutableVector2f(250, 70);
        ImmutableVector2f p1 = new ImmutableVector2f(160, 210);

        Assert.assertEquals(50, LineSegment.distanceToPoint(p0, p1, new Vector2f(300, 70)), 0.01);
        Assert.assertEquals(50, LineSegment.distanceToPoint(p0, p1, new Vector2f(110, 210)), 0.01);

        Assert.assertEquals(50, LineSegment.distanceToPoint(p0, p1, new Vector2f(250, 20)), 0.01);
        Assert.assertEquals(50, LineSegment.distanceToPoint(p0, p1, new Vector2f(160, 260)), 0.01);

        Assert.assertEquals(0, LineSegment.distanceToPoint(p0, p1, p0), 0.01);
        Assert.assertEquals(0, LineSegment.distanceToPoint(p0, p1, p1), 0.01);

        // interpolating along the line should result in a distance of zero
        for (float a = 0; a < 1; a += 0.01f) {
            BaseVector2f ipol = BaseVector2f.lerp(p0, p1, a);
            Assert.assertEquals(0, LineSegment.distanceToPoint(p0, p1, ipol), 0.01);
        }
    }

    @Test
    public void equalsTest() {
        LineSegment seg1 = new LineSegment(0, 1, 5, 5);
        LineSegment seg2 = new LineSegment(0, 1, 5, 5);
        LineSegment seg3 = new LineSegment(0, 1, 5, 4);
        Assert.assertEquals(seg1, seg2);
        Assert.assertNotEquals(seg1, seg3);
        Assert.assertNotEquals(seg2, seg3);
    }

    @Test
    public void intersectionTest() {
        Rect2i rc = Rect2i.createFromMinAndMax(1, 2, 10, 20);
        assertSegEquals(new LineSegment(5, 6, 10, 12), new LineSegment(5, 6, 10, 12).getClipped(rc));
        assertSegEquals(new LineSegment(1, 2, 5, 6), new LineSegment(0, 1, 5, 6).getClipped(rc));
        assertSegEquals(new LineSegment(3, 4, 8, 9), new LineSegment(3, 4, 8, 9).getClipped(rc));
        assertSegEquals(new LineSegment(1, 5, 10, 5), new LineSegment(0, 5, 15, 5).getClipped(rc));
        assertSegEquals(new LineSegment(2, 2, 2, 20), new LineSegment(2, 0, 2, 25).getClipped(rc));
        assertSegEquals(new LineSegment(1, 2, 10, 2), new LineSegment(0, 2, 30, 2).getClipped(rc));
        assertSegEquals(new LineSegment(10, 20, 10, 20), new LineSegment(8, 23, 12, 19).getClipped(rc));
    }

    private void assertSegEquals(LineSegment l1, LineSegment l2) {
        Assert.assertEquals(new Vector2i(l1.getStart()), new Vector2i(l2.getStart()));
        Assert.assertEquals(new Vector2i(l1.getEnd()), new Vector2i(l2.getEnd()));
    }

    @Test
    public void randomCuts() {
        Rect2i rc = Rect2i.createFromMinAndSize(3, 3, 5, 5);
        Vector2f p0 = new Vector2f();
        Vector2f p1 = new Vector2f();

        Random rng = new Random(123234);
        for (int i = 0; i < 10000; i++) {
            float sx = rng.nextFloat() * 10f;
            float sy = rng.nextFloat() * 10f;
            float dx = rng.nextFloat() * 10f;
            float dy = rng.nextFloat() * 10f;
            LineSegment seg = new LineSegment(sx, sy, dx, dy);
            if (seg.intersects(rc)) {
                seg.getClipped(rc, p0, p1);
                Assert.assertTrue(rc.contains(p0.x, p0.y) && rc.contains(p1.x, p1.y));
            }
        }
    }
}
