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
 * Tests the {@link Rect2iTransformer} class.
 */
public class Rect2iTransformerTest {

    @Test
    public void testTranslate() {
        Rect2i source = Rect2i.createFromMinAndSize(1, 2, 10, 20);
        Rect2i target = Rect2i.createFromMinAndSize(7, 4, 10, 20);
        Rect2iTransformer t = new Rect2iTransformer(source, target);
        assertEquals(new Vector2i(10, 10), t.apply(4, 8));
    }

    @Test
    public void testScale() {
        Rect2i source = Rect2i.createFromMinAndSize(1, 2, 1, 2);
        Rect2i target = Rect2i.createFromMinAndSize(1, 2, 10, 200);
        Rect2iTransformer t = new Rect2iTransformer(source, target);
        assertEquals(new Vector2i(31, 602), t.apply(4, 8));
    }
}
