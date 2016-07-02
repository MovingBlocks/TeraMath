/*
 * Copyright 2016 MovingBlocks
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
 * Tests the {@link Rect2fTransformer} class.
 */
public class Rect2fTransformerTest {

    @Test
    public void testTranslate() {
        Rect2f source = Rect2f.createFromMinAndSize(1, 2, 10, 20);
        Rect2f target = Rect2f.createFromMinAndSize(7, 4, 10, 20);
        Rect2fTransformer t = new Rect2fTransformer(source, target);
        assertEquals(new Vector2f(10, 10), t.apply(4, 8));
    }

    @Test
    public void testScale() {
        Rect2f source = Rect2f.createFromMinAndSize(1, 2, 1, 2);
        Rect2f target = Rect2f.createFromMinAndSize(1, 2, 10, 200);
        Rect2fTransformer t = new Rect2fTransformer(source, target);
        assertEquals(new Vector2f(31, 602), t.apply(4, 8));
    }
}
