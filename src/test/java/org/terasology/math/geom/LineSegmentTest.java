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
}
