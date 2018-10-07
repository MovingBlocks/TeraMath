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

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class VectorPool4dTest extends VectorPoolBaseTest<VectorPool4d,Vector4d> {
    @Override
    public VectorPool4d getVectorPool() {
        return new VectorPool4d();
    }

    @Test
    public void emptyVectorTest() {
        Vector4d v = new Vector4d(10.5, 10.0, 512.5, 151.5);
        VectorPool4d pool3d = getVectorPool();
        pool3d.free(v);

        Vector4d res = pool3d.getVector();
        assertEquals(new Vector4d(0, 0, 0, 0), v);
        assertEquals(v, res);
    }

    @Test
    public void setVectorTest() {
        Vector4d v = new Vector4d(10.5, 10.0, 23.5, 121.5);
        VectorPool4d pool3d = getVectorPool();
        pool3d.free(v);

        Vector4d res = pool3d.getVector(4, 4, 512.5, 151.5);
        assertEquals(new Vector4d(4, 4, 512.5, 151.5), v);
        assertSame(v, res);
    }

    @Test
    public void getVectorTest() {
        Vector4d v = new Vector4d(10.5, 10.0, 123.5, 151.5);
        Vector4d v2 = new Vector4d(100.5, 183.2, 512.5, 13.5);

        VectorPool4d pool3d = getVectorPool();
        pool3d.free(v);

        Vector4d res = pool3d.getVector(v2);
        assertEquals(new Vector4d(100.5, 183.2, 512.5, 13.5), v);
        assertEquals(v, res);
        assertNotSame(v2, v);
    }
}
