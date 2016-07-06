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

import org.junit.Test;

public class Rect2fTest {

    @Test
    public void testContainsPoint() {
        Rect2f a = Rect2f.createFromMinAndMax(1, 2, 3, 4);
        assertTrue(a.contains(1, 2));
        assertTrue(a.contains(2, 3));
        assertFalse(a.contains(2, 4));
        assertFalse(a.contains(4, 3));
        assertFalse(a.contains(2, 5));
        assertFalse(a.contains(3, 3));
        assertFalse(a.contains(3, 5));
    }

    @Test
    public void testContainsSelf() {
        Rect2f a = Rect2f.createFromMinAndMax(1, 2, 10, 20);
        assertTrue(a.contains(a));

        // same goes for AWT
        java.awt.geom.Rectangle2D.Float awtRc = new java.awt.geom.Rectangle2D.Float(1,  2, 10, 20);
        assertTrue(awtRc.contains(awtRc));
    }

    @Test
    public void testTouchesSmall() {
        Rect2f a = Rect2f.createFromMinAndMax(1, 2, 10, 20);
        float eps = 0.001f;

        assertTrue(a.touches(1, 2, eps));
        assertTrue(a.touches(10, 20, eps));
        assertTrue(a.touches(1, 5, eps));
        assertTrue(a.touches(5, 2, eps));
        assertTrue(a.touches(10, 5, eps));
        assertTrue(a.touches(5, 20, eps));
        assertFalse(a.touches(4, 3, eps));
        assertFalse(a.touches(1, 1, eps));
        assertFalse(a.contains(11, 20));
        assertFalse(a.contains(10, 21));
    }

    @Test
    public void testTouchesLarge() {
        Rect2f a = Rect2f.createFromMinAndMax(1, 2, 10, 20);
        float eps = 0.5f;

        assertTrue(a.touches(1.3f, 2.3f, eps));
        assertTrue(a.touches(0.7f, 1.7f, eps));
        assertTrue(a.touches(10.3f, 20.3f, eps));
        assertTrue(a.touches(9.7f, 19.7f, eps));
        assertTrue(a.touches(9.7f, 1.7f, eps));
        assertTrue(a.touches(9.7f, 2.3f, eps));
        assertTrue(a.touches(0.7f, 19.7f, eps));
        assertTrue(a.touches(1.3f, 19.7f, eps));
        assertTrue(a.touches(1.3f, 20.3f, eps));
        assertTrue(a.touches(0.7f, 20.3f, eps));
        assertFalse(a.touches(0.4f, 20.3f, eps));
        assertFalse(a.touches(1.4f, 20.6f, eps));
        assertFalse(a.touches(1.6f, 2.6f, eps));
        assertFalse(a.touches(10.6f, 20.6f, eps));
        assertFalse(a.touches(9.4f, 19.4f, eps));
    }

    @Test
    public void testDistancePoint() {
        Rect2f rc = Rect2f.createFromMinAndMax(2, 1, 10, 20);
        float e = 0.001f;

        // corners
        assertEquals(0, rc.distanceSquared(2, 1), e);
        assertEquals(0, rc.distanceSquared(10, 20), e);

        // inside
        assertEquals(0, rc.distanceSquared(4, 3), e);
        assertEquals(0, rc.distanceSquared(8, 19), e);

        // edges
        assertEquals(0, rc.distanceSquared(7, 1), e);
        assertEquals(0, rc.distanceSquared(10, 11), e);

        // outside
        assertEquals(1, rc.distanceSquared(1, 1), e);
        assertEquals(1, rc.distanceSquared(11, 1), e);
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(11, 22), e);
        assertEquals(4 * 4 + 0 * 0, rc.distanceSquared(14, 13), e);
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(12, 21), e);
        assertEquals(2 * 2 + 1 * 1, rc.distanceSquared(11, 22), e);
    }

    @Test
    public void textExpand() {
        float e = 0.001f;
        Rect2f rc = Rect2f.createFromMinAndMax(2, 1, 10, 20);
        rc = rc.expand(3, 4);
        assertEquals(-1, rc.minX(), e);
        assertEquals(-3, rc.minY(), e);
        assertEquals(13, rc.maxX(), e);
        assertEquals(24, rc.maxY(), e);
    }

}
