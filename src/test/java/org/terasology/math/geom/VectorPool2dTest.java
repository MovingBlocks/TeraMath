/*
 * Copyright 2018 MovingBlocks
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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class VectorPool2dTest extends VectorPoolBaseTest<VectorPool2d,Vector2d> {
    @Override
    public VectorPool2d getVectorPool() {
        return new VectorPool2d();
    }

    @Test
    public void emptyVectorTest() {
        Vector2d v = new Vector2d(10.5, 10.0);
        VectorPool2d pool2d = getVectorPool();
        pool2d.free(v);

        Vector2d res = pool2d.getVector();
        assertEquals(new Vector2d(0, 0), v);
        assertEquals(v, res);
    }

    @Test
    public void setVectorTest() {
        Vector2d v = new Vector2d(10.5, 10.0);
        VectorPool2d pool2d = getVectorPool();
        pool2d.free(v);

        Vector2d res = pool2d.getVector(4, 4);
        assertEquals(new Vector2d(4, 4), v);
        assertSame(v, res);
    }

    @Test
    public void getVectorTest() {
        Vector2d v = new Vector2d(10.5, 10.0);
        Vector2d v2 = new Vector2d(100.5, 183.2);

        VectorPool2d pool2d = getVectorPool();
        pool2d.free(v);

        Vector2d res = pool2d.getVector(v2);
        assertEquals(new Vector2d(100.5, 183.2), v);
        assertEquals(v, res);
        assertNotSame(v2, v);
    }

}
