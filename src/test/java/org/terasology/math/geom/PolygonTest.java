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

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link Polygon} class.
 */
public class PolygonTest {

    @Test
    public void testBoundingBox() {
        Polygon poly = Polygon.createCopy(Arrays.asList(
                new Vector2f(1, 0),
                new Vector2f(0, 1),
                new Vector2f(1, 2),
                new Vector2f(2, 1)));
        Assert.assertEquals(Rect2f.createFromMinAndMax(0, 0, 2, 2), poly.getBounds());
    }
}
