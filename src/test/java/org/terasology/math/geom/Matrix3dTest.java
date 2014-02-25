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

import static org.junit.Assert.*;

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
     * det(M) == -65
     */
    @Test
    public void testDeterminant() {
        Matrix3d m = new Matrix3d(1, 3, 5, -1, 2, 0, 4, 2, -3);
        assertEquals("det(M) should be -65", -65, m.determinant(), EPSILON);
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
     * M * 0.5 == M - M * 0.5
     */
    @Test
    public void testSubMul() {
        Random r = new Random(123984);
        
        Matrix3d m = createRandomly(r);
        Matrix3d m3 = new Matrix3d(m);
        Matrix3d m2 = new Matrix3d(m);
        m2.mul(0.5);
        m3.sub(m2);
        
        assertTrue("M * 0.5 should be M - M * 0.5", m2.epsilonEquals(m3, EPSILON));
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

    @Test
    public void testRowArrayGetters() {
        Matrix3d m = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        double[] v = new double[3];

        m.getRow(0, v);
        assertArrayEquals(new double[]{1, 2, 3}, v, EPSILON);

        m.getRow(1, v);
        assertArrayEquals(new double[]{4, 5, 6}, v, EPSILON);

        m.getRow(2, v);
        assertArrayEquals(new double[]{7, 8, 9}, v, EPSILON);
    }

    @Test
    public void testRowVectorGetters() {
        Matrix3d m = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Vector3d v;
        v = m.getRow(0);
        assertEquals(new Vector3d(1, 2, 3), v);

        v = m.getRow(1);
        assertEquals(new Vector3d(4, 5, 6), v);

        v = m.getRow(2);
        assertEquals(new Vector3d(7, 8, 9), v);
    }

    @Test
    public void testColumnVectorGetters() {
        Matrix3d m = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Vector3d v;
        v = m.getColumn(0);
        assertEquals(new Vector3d(1, 4, 7), v);

        v = m.getColumn(1);
        assertEquals(new Vector3d(2, 5, 8), v);

        v = m.getColumn(2);
        assertEquals(new Vector3d(3, 6, 9), v);
    }

    @Test
    public void testColArrayGetters() {
        Matrix3d m = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        double[] v = new double[3];

        m.getColumn(0, v);
        assertArrayEquals(new double[]{1, 4, 7}, v, EPSILON);

        m.getColumn(1, v);
        assertArrayEquals(new double[]{2, 5, 8}, v, EPSILON);

        m.getColumn(2, v);
        assertArrayEquals(new double[]{3, 6, 9}, v, EPSILON);
    }

    @Test
    public void testGetters() {
        Matrix3d m = new Matrix3d(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(1, m.get(0, 0), EPSILON);
        assertEquals(2, m.get(0, 1), EPSILON);
        assertEquals(3, m.get(0, 2), EPSILON);
        assertEquals(4, m.get(1, 0), EPSILON);
        assertEquals(5, m.get(1, 1), EPSILON);
        assertEquals(6, m.get(1, 2), EPSILON);
        assertEquals(7, m.get(2, 0), EPSILON);
        assertEquals(8, m.get(2, 1), EPSILON);
        assertEquals(9, m.get(2, 2), EPSILON);
    }

    @Test
    public void testSet() {
        Matrix3d m = createRandomly(new Random(12345));

        double[] data = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        m.set(data);
        double[] data2 = new double[9];
        m.get(data2);
        assertArrayEquals(data, data2, EPSILON);
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
