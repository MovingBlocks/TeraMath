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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

/**
 * Tests the {@link BaseMatrix3d} class
 * @author Martin Steiger
 */
public class Matrix3dTest {

    protected static final double EPSILON = 0.0000001;

    @Test
    public void testEquals() {
        assertEquals(new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9), new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testEqualsAgainstImmutable() {
        assertEquals(new ImmutableMatrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9), new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
    
    @Test
    public void testEqualsEmpty() {
        assertEquals(new Matrix3d(0, 0, 0, 0, 0, 0, 0, 0, 0), new Matrix3d());
    }

    /**
     * Here: 0 != -0 (different longBits)
     */
    @Test
    public void testEqualsNegZero() {
        assertNotEquals(new Matrix3d(0, 0, 0, 0, 0, 0, 0, 0, 0), new Matrix3d(0, 0, 0, 0, 0, -0d, 0, 0, 0));
    }

    /**
     * Here: NaN == NaN (same longBits)
     */
    @Test
    public void testEqualsNaN() {
        assertEquals(new Matrix3d(0, 0, 0, 0, 0, 0, 0, 0, Double.NaN), new Matrix3d(0, 0, 0, 0, 0, 0, 0, 0, Double.NaN));
    }
    
    
    /**
     * M * M^-1 == 1
     */
    @Test
    public void testInversion() {
        Random r = new Random(1234);
        
        Matrix3d m = createRandomly(r);
        Matrix3d m2 = new Matrix3d(m);
        m.invert();
        m.mul(m2);
        
        assertTrue("M * M^-1 should be I", m.epsilonEquals(BaseMatrix3d.IDENTITY, EPSILON));
    }
    
    /**
     * M * 2 == M + M
     */
    @Test
    public void testAddMul() {
        Random r = new Random(123984);
        
        Matrix3d m = createRandomly(r);
        Matrix3d m3 = new Matrix3d(m);
        Matrix3d m2 = new Matrix3d(m);
        m2.add(m);
        m3.mul(2.0);
        
        assertTrue("M * 2 should be M + M", m2.epsilonEquals(m3, EPSILON));
    }
    
    /**
     * M^T^T == M
     */
    @Test
    public void testTranspose() {
        Random r = new Random(12);
        
        Matrix3d m = createRandomly(r);
        Matrix3d m2 = new Matrix3d(m);
        m2.transpose();
        m2.transpose();

        assertTrue("M^T^T should be M", m.epsilonEquals(m2, EPSILON));
    }
    
    private Matrix3d createRandomly(Random r) {
        double[] data = new double[9];
        for (int k = 0; k < data.length; k++) {
            data[k] = r.nextDouble() * 1024;
        }
        Matrix3d m = new Matrix3d(data);
        return m;
        
    }
}
