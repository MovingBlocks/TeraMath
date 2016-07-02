/*
 * Copyright 2013 MovingBlocks
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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class Rect2iTest {

    @Test
    public void testSubtraction0() {
        Rect2i a = Rect2i.createFromMinAndSize(1, 2, 3, 3);
        Rect2i b = Rect2i.createFromMinAndSize(0, 4, 3, 3);

        List<Rect2i> sub = Rect2i.difference(a, b);

        assertEquals(2, sub.size());

        int area = 0;
        for (Rect2i r : sub) {
            area += r.area();
        }

        assertEquals(7, area);

        assertTrue(sub.contains(Rect2i.createFromMinAndSize(1, 2, 3, 2)));
        assertTrue(sub.contains(Rect2i.createFromMinAndSize(3, 4, 1, 1)));
    }

    @Test
    public void testSubtraction1() {
        Rect2i a = Rect2i.createFromMinAndSize(1, 2, 3, 3);
        Rect2i b = Rect2i.createFromMinAndSize(3, 2, 3, 3);

        List<Rect2i> sub = Rect2i.difference(a, b);

        assertEquals(1, sub.size());
        assertEquals(Rect2i.createFromMinAndSize(1, 2, 2, 3), sub.get(0));
    }

    @Test
    public void overlap() {
        assertTrue(Rect2i.createFromMinAndSize(5, 5, 472, 17).overlaps(Rect2i.createFromMinAndSize(5, 5, 1, 16)));
    }

    @Test
    public void testEncompass() {
        // encompass self
        assertTrue(Rect2i.createFromMinAndSize(5, 5, 47, 57).contains(Rect2i.createFromMinAndSize(5, 5, 47, 57)));

        assertTrue(Rect2i.createFromMinAndSize(5, 5, 47, 57).contains(Rect2i.createFromMinAndSize(45, 35, 5, 20)));
        assertTrue(Rect2i.createFromMinAndSize(5, 5, 47, 57).contains(Rect2i.createFromMinAndSize(50, 60, 2, 2)));

        assertFalse(Rect2i.createFromMinAndSize(5, 5, 47, 57).contains(Rect2i.createFromMinAndSize(50, 60, 3, 2)));
        assertFalse(Rect2i.createFromMinAndSize(5, 5, 47, 57).contains(Rect2i.createFromMinAndSize(50, 60, 2, 3)));
    }

    @Test
    public void testContainsEmpty() {
        Rect2i a = Rect2i.createFromMinAndMax(0, 0, 0, 0);
        assertTrue(a.contains(0, 0));

        assertFalse(a.contains(1, 0));
        assertFalse(a.contains(0, 1));
        assertFalse(a.contains(1, 1));
        assertFalse(a.contains(-1, 0));
        assertFalse(a.contains(0, -1));
        assertFalse(a.contains(-1, 1));
        assertFalse(a.contains(1, -1));
        assertFalse(a.contains(-1, -1));
    }

    @Test
    public void testContainsPoint() {
        Rect2i a = Rect2i.createFromMinAndMax(1, 2, 3, 4);
        assertTrue(a.contains(1, 2));
        assertTrue(a.contains(2, 3));
        assertTrue(a.contains(2, 4));
        assertFalse(a.contains(4, 3));
        assertFalse(a.contains(2, 5));
        assertFalse(a.contains(3, 5));
    }

    @Test
    public void testContainsSelf() {
        Rect2i a = Rect2i.createFromMinAndMax(1, 2, 10, 20);
        assertTrue(a.contains(a));

        // same behavior as AWT
        java.awt.Rectangle awtRc = new java.awt.Rectangle(1,  2, 10, 20);
        assertTrue(awtRc.contains(awtRc));
    }

    @Test
    public void testContainsRect() {
        Rect2i a = Rect2i.createFromMinAndMax(1, 2, 10, 20);

        assertTrue(a.contains(Rect2i.createFromMinAndMax(5, 5, 5, 5)));
        assertFalse(a.contains(Rect2i.createFromMinAndMax(11, 5, 35, 5)));
        assertFalse(a.contains(Rect2i.createFromMinAndMax(1, 21, 5, 95)));

        assertTrue(a.contains(Rect2i.createFromMinAndMax(1, 2, 3, 3)));
        assertTrue(a.contains(Rect2i.createFromMinAndMax(4, 2, 8, 8)));
        assertTrue(a.contains(Rect2i.createFromMinAndMax(1, 4, 8, 8)));
        assertTrue(a.contains(Rect2i.createFromMinAndMax(5, 12, 9, 19)));
        assertTrue(a.contains(Rect2i.createFromMinAndMax(5, 12, 10, 20)));
        assertFalse(a.contains(Rect2i.createFromMinAndMax(5, 12, 10, 21)));
        assertFalse(a.contains(Rect2i.createFromMinAndMax(5, 12, 11, 20)));
    }

    @Test
    public void testDistancePoint() {
        Rect2i rc = Rect2i.createFromMinAndMax(2, 1, 10, 20);

        // corners
        assertEquals(0, rc.distanceSquared(2, 1));
        assertEquals(0, rc.distanceSquared(10, 20));

        // inside
        assertEquals(0, rc.distanceSquared(4, 3));
        assertEquals(0, rc.distanceSquared(8, 19));

        // edges
        assertEquals(0, rc.distanceSquared(7, 1));
        assertEquals(0, rc.distanceSquared(10, 11));

        // outside
        assertEquals(1, rc.distanceSquared(1, 1));
        assertEquals(1, rc.distanceSquared(11, 1));
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(11, 22));
        assertEquals(4 * 4 + 0 * 0, rc.distanceSquared(14, 13));
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(12, 21));
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(11, 22));
    }

    @Test
    public void testIterator() {
        Rect2i a = Rect2i.createFromMinAndMax(2, 3, 4, 5);

        List<BaseVector2i> expected = Lists.<BaseVector2i>newArrayList(
                new Vector2i(2, 3), new Vector2i(3, 3), new Vector2i(4, 3),
                new Vector2i(2, 4), new Vector2i(3, 4), new Vector2i(4, 4),
                new Vector2i(2, 5), new Vector2i(3, 5), new Vector2i(4, 5));

        // we cannot compare the entire Iterable at once, because
        // the BaseVector2i is reused for all elements
        Iterator<BaseVector2i> iterator = expected.iterator();
        for (BaseVector2i v : a.contents()) {
            assertEquals(iterator.next(), v);
        }
    }

    @Test
    public void testIteratorOverflow() {
        Rect2i a = Rect2i.createFromMinAndMax(2, 3, 4, 5);
        Iterator<BaseVector2i> it = a.contents().iterator();
        for (int i = 0; i < 9; i++) {
            it.next();
        }

        try {
            it.next();  // check for exception only in this call
            Assert.fail("The method should throw NoSuchElementException now");
        } catch (NoSuchElementException e) {
            // this is supposed to happen
            return;
        }
    }

    @Test
    public void textExpand() {
        Rect2i rc = Rect2i.createFromMinAndMax(2, 1, 10, 20);
        rc = rc.expand(3, 4);
        assertEquals(-1, rc.minX());
        assertEquals(-3, rc.minY());
        assertEquals(13, rc.maxX());
        assertEquals(24, rc.maxY());
    }
}
