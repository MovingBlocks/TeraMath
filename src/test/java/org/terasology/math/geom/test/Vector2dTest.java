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

package org.terasology.math.geom.test;

import org.junit.Test;
import org.terasology.math.geom.ArrayBasedVector2d;
import org.terasology.math.geom.ImmutableVector2d;
import org.terasology.math.geom.Tuple2d;
import org.terasology.math.geom.Vector2d;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Some Point2D related tests
 *
 * @author Martin Steiger
 */
public class Vector2dTest extends BaseTuple2dTest {

    @Test
    public void testUsability() {
        double[] data = {1, 2, 3, 4};
        Tuple2d zero = Tuple2d.ZERO;
        Tuple2d p1 = new ArrayBasedVector2d(data, 1);
        Vector2d l = Tuple2d.lerp(zero, p1, 0.5);
        Vector2d v = l.add(p1).addX(0.5).mulY(2.0).invert();
        System.out.println(v);
    }

    @Test
    public void testEquals() {
        assertEquals(new ImmutableVector2d(2, 2), new ImmutableVector2d(2, 2));

        // TODO: this is actually up for discussion
        assertEquals(new ImmutableVector2d(2, 2), new Vector2d(2, 2));
    }

    @Override
    protected Tuple2d createTuple2d(double x, double y) {
        return new Vector2d(x, y);
    }
}
