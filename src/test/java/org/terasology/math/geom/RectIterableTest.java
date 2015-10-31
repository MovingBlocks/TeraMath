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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link RectIterable} class.
 */
public final class RectIterableTest {

    private Rect2i rc = Rect2i.createFromMinAndSize(1, 2, 5, 4);

    private final List<Vector2i> expected = Arrays.asList(
            new Vector2i(1, 2), new Vector2i(2, 2), new Vector2i(3, 2), new Vector2i(4, 2), new Vector2i(5, 2),
            new Vector2i(5, 3), new Vector2i(5, 4), new Vector2i(5, 5),
            new Vector2i(4, 5), new Vector2i(3, 5), new Vector2i(2, 5), new Vector2i(1, 5), new Vector2i(1, 4),
            new Vector2i(1, 3)
            );

    @Test(expected = IllegalArgumentException.class)
    public void testInside() {
        new RectIterable(rc, false, new Vector2i(2, 3)).iterator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutside() {
        new RectIterable(rc, false, new Vector2i(0, 0)).iterator();
    }

    @Test
    public void testReverseMinMin() {
        RectIterable iter = new RectIterable(rc, false, rc.min());
        testIterator(0, iter.iterator(), true);
    }

    @Test
    public void testMinMin() {
        RectIterable iter = new RectIterable(rc, true, rc.min());
        testIterator(0, iter.iterator());
    }

    @Test
    public void testMin() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.minX() + 2, rc.minY()));
        testIterator(2, iter.iterator());
    }

    @Test
    public void testMaxMin() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.maxX(), rc.minY()));
        testIterator(rc.width() - 1, iter.iterator());
    }

    @Test
    public void testMax() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.maxX(), rc.minY() + 2));
        testIterator(rc.width() - 1 + 2, iter.iterator());
    }

    @Test
    public void testMaxMax() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.maxX(), rc.maxY()));
        testIterator(rc.width() - 1 + rc.height() - 1, iter.iterator());
    }

    @Test
    public void testMinMax() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.maxX() - 2, rc.maxY()));
        testIterator(rc.width() - 1 + rc.height() - 1 + 2, iter.iterator());
    }

    @Test
    public void testLast() {
        RectIterable iter = new RectIterable(rc, true, new Vector2i(rc.minX(), rc.maxY() - 2));
        testIterator(2 * rc.width() - 2 + rc.height() - 1 + 2, iter.iterator());
    }

    @Test
    public void testLength() {
        RectIterable iter = new RectIterable(rc, true, rc.min());
        Iterator<BaseVector2i> it = iter.iterator();
        for (int i = 0; i < iter.length(); i++) {
            it.next();
        }
        testIterator(0, it);
    }

    private void testIterator(int offset, Iterator<BaseVector2i> iterator) {
        testIterator(offset, iterator, false);
    }

    private void testIterator(int offset, Iterator<BaseVector2i> iterator, boolean reverse) {
        int cnt = 0;
        List<Vector2i> copy = new ArrayList<Vector2i>(expected);
        Collections.rotate(copy, -offset);
        if (reverse) {
            Collections.reverse(copy);
            Collections.rotate(copy, 1); // the start element remains the first element
        }
        for (Vector2i pt : copy) {
            Assert.assertEquals("Element " + cnt + " is wrong", pt, iterator.next());
            cnt++;
        }
    }
}
