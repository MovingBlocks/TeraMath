/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link SpiralIterable} class.
 * @author Martin Steiger
 */
public final class SpiralIterableTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLengthLast() {
        int rad = 23170;
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).maxRadius(rad).build();
        spiral.iterator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidScale() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).scale(0).build();
        spiral.iterator();
    }

    @Test(expected = NoSuchElementException.class)
    public void testInvalidNext() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).maxRadius(3).build();
        Iterator<BaseVector2i> it = spiral.iterator();
        while (it.hasNext()) {
            it.next();
        }
        it.next();
    }

    @Test
    public void testCw1() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).maxRadius(1).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(new Vector2i(3, 1));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }

    @Test
    public void testScale2() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).scale(2).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(
                new Vector2i(3, 1), new Vector2i(5, 1), new Vector2i(5, 3),
                new Vector2i(3, 3), new Vector2i(1, 3), new Vector2i(1, 1),
                new Vector2i(1, -1), new Vector2i(3, -1), new Vector2i(5, -1));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }

    @Test
    public void testLength() {
        for (int rad = 0; rad < 20; rad++) {
            int count = 0;
            SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).maxRadius(rad).build();
            for (@SuppressWarnings("unused") BaseVector2i pos : spiral) {
                count++;
            }
            Assert.assertEquals("rad: " + rad, (rad * 2 + 1) * (rad * 2 + 1), count);
        }
    }

    @Test
    public void testCcw1() {
        SpiralIterable spiral = SpiralIterable.counterClockwise(new Vector2i(3, 1)).maxRadius(1).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(new Vector2i(3, 1));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }

    @Test
    public void testCw2() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).maxRadius(2).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(
                new Vector2i(3, 1), new Vector2i(4, 1), new Vector2i(4, 2),
                new Vector2i(3, 2), new Vector2i(2, 2), new Vector2i(2, 1),
                new Vector2i(2, 0), new Vector2i(3, 0), new Vector2i(4, 0));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }

    @Test
    public void testInfiniteCw() {
        SpiralIterable spiral = SpiralIterable.clockwise(new Vector2i(3, 1)).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(
                new Vector2i(3, 1), new Vector2i(4, 1), new Vector2i(4, 2),
                new Vector2i(3, 2), new Vector2i(2, 2), new Vector2i(2, 1),
                new Vector2i(2, 0), new Vector2i(3, 0), new Vector2i(4, 0),
                new Vector2i(5, 0));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }

    @Test
    public void testInfiniteCounterCw() {
        SpiralIterable spiral = SpiralIterable.counterClockwise(new Vector2i(3, 1)).build();

        Iterator<BaseVector2i> iterator = spiral.iterator();

        List<Vector2i> expected = Arrays.asList(
                new Vector2i(3, 1), new Vector2i(4, 1), new Vector2i(4, 0),
                new Vector2i(3, 0), new Vector2i(2, 0), new Vector2i(2, 1),
                new Vector2i(2, 2), new Vector2i(3, 2), new Vector2i(4, 2),
                new Vector2i(5, 2));

        for (Vector2i pt : expected) {
            Assert.assertEquals(pt, iterator.next());
        }
    }
}
