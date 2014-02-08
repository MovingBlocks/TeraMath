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

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.terasology.math.geom.ArrayBasedVector2d;
import org.terasology.math.geom.Tuple2d;
import org.terasology.math.geom.ConstVector2d;
import org.terasology.math.geom.Vector2d;

/**
 * Some Point2D related tests
 * @author Martin Steiger
 */
public class Vector2dTest {

    @Test
    public void testUsability() {
        double [] data = { 1, 2, 3, 4 };
        Tuple2d zero = ConstVector2d.ZERO;
        Tuple2d p1 = new ArrayBasedVector2d(data, 1);
        Vector2d l = Tuple2d.lerp(zero, p1, 0.5);
        Vector2d v = l.add(p1).addX(0.5).mulY(2.0).invert();
        System.out.println(v);
    }
    
    @Test
    public void testEquals() {
        assertTrue(new ConstVector2d(2, 2).equals(new ConstVector2d(2, 2)));
        
        // TODO: this is actually up for discussion
        assertTrue(new ConstVector2d(2, 2).equals(new Vector2d(2, 2)));
    }
}
