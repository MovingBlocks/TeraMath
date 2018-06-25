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

public class VectorPool3dTest extends VectorPoolBaseTest<VectorPool3d,Vector3d> {
    @Override
    public VectorPool3d getVectorPool() {
        return new VectorPool3d();
    }

    @Test
    public void emptyVectorTest() {
        Vector3d v = new Vector3d(10.5, 10.0, 512.5);
        VectorPool3d pool3d = getVectorPool();
        pool3d.free(v);

        Vector3d res = pool3d.getVector();
        assertEquals(new Vector3d(0, 0, 0), v);
        assertEquals(v, res);
    }

    @Test
    public void setVectorTest() {
        Vector3d v = new Vector3d(10.5, 10.0, 23.5);
        VectorPool3d pool3d = getVectorPool();
        pool3d.free(v);

        Vector3d res = pool3d.getVector(4, 4, 512.5);
        assertEquals(new Vector3d(4, 4, 512.5), v);
        assertSame(v, res);
    }

    @Test
    public void getVectorTest() {
        Vector3d v = new Vector3d(10.5, 10.0, 123.5);
        Vector3d v2 = new Vector3d(100.5, 183.2, 512.5);

        VectorPool3d pool3d = getVectorPool();
        pool3d.free(v);

        Vector3d res = pool3d.getVector(v2);
        assertEquals(new Vector3d(100.5, 183.2, 512.5), v);
        assertEquals(v, res);
        assertNotSame(v2, v);
    }
}
