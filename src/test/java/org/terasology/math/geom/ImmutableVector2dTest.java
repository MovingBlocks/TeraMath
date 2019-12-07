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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Immortius
 */
public class ImmutableVector2dTest extends BaseVector2dTest {

    @Test
    public void projectAgainstVector() {
        Vector2d v = new ImmutableVector2d(1, 2).project(new Vector2d(4, -3));
        assertEquals(-0.32, v.getX(), EPSILON);
        assertEquals(0.24, v.getY(), EPSILON);
    }

    @Override
    protected BaseVector2d createBaseVector2d(double x, double y) {
        return new ImmutableVector2d(x, y);
    }
}
