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
 * Tests the {@link BaseMatrix4d} class
 * @author Martin Steiger
 */
public class Matrix4dTest {

    protected static final double EPSILON = 0.0000001;

    @Test
    public void testEquals() {
        assertEquals(new Matrix4d(plainInts()), new Matrix4d(plainInts()));
    }

    @Test
    public void testEqualsAgainstImmutable() {
        assertEquals(new ImmutableMatrix4d(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), new Matrix4d(plainInts()));
    }
    
    @Test
    public void testEqualsEmpty() {
        assertEquals(new Matrix4d(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), new Matrix4d());
    }

    /**
     * Here: 0 != -0 (different longBits)
     */
    @Test
    public void testEqualsNegZero() {
        assertNotEquals(new Matrix4d(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), new Matrix4d(0, 0, 0, 0, 0, -0d, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    /**
     * Here: NaN == NaN (same longBits)
     */
    @Test
    public void testEqualsNaN() {
        assertEquals(new Matrix4d(0, 0, 0, 0, 0, 0, 0, 0, Double.NaN, 0, 0, 0, 0, 0, 0, 0), new Matrix4d(0, 0, 0, 0, 0, 0, 0, 0, Double.NaN, 0, 0, 0, 0, 0, 0, 0));
    }
    
    
    /**
     * det(M) == -65
     */
    @Test
    public void testDeterminant() {
        Matrix4d m = new Matrix4d(3, 7, 3, 0, 0, 2, -1, 1, 5, 4, 3, 2, 6, 6, 4, -1);
        assertEquals("det(M) should be -105", 105, m.determinant(), EPSILON);
    }
    
    
    /**
     * M * M^-1 == 1
     */
    @Test
    public void testInversion() {
        Random r = new Random(1234);
        
        Matrix4d m = createRandomly(r);
        Matrix4d m2 = new Matrix4d(m);
        m.invert();
        m.mul(m2);
        
        assertTrue("M * M^-1 should be I", m.epsilonEquals(BaseMatrix4d.IDENTITY, EPSILON));
    }
    
    /**
     * M * 2 == M + M
     */
    @Test
    public void testAddMul() {
        Random r = new Random(123984);
        
        Matrix4d m = createRandomly(r);
        Matrix4d m3 = new Matrix4d(m);
        Matrix4d m2 = new Matrix4d(m);
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
        
        Matrix4d m = createRandomly(r);
        Matrix4d m3 = new Matrix4d(m);
        Matrix4d m2 = new Matrix4d(m);
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
        
        Matrix4d m = createRandomly(r);
        Matrix4d m2 = new Matrix4d(m);
        m2.transpose();
        m2.transpose();
        
        assertTrue("M^T^T should be M", m.epsilonEquals(m2, EPSILON));
    }
    
    /**
     * M^I == M^T for rotations
     */
    @Test
    public void testInverseTranspose() {
        Quat4d q = new Quat4d(0.3, 0.4, 0.5);
        
        Matrix4d m = new Matrix4d(q, Vector3d.ZERO, 1.0);
        Matrix4d mt = new Matrix4d(m);
        Matrix4d mi = new Matrix4d(m);
        mt.transpose();
        mi.invert();
        
        assertTrue("M^T should be M^I", mt.epsilonEquals(mi, EPSILON));
    }
    
    @Test
    public void testRowArrayGetters() {
        Matrix4d m = new Matrix4d(plainInts());
        double[] v = new double[4];

        m.getRow(0, v);
        assertArrayEquals(new double[]{1, 2, 3, 4}, v, EPSILON);

        m.getRow(1, v);
        assertArrayEquals(new double[]{5, 6, 7, 8}, v, EPSILON);

        m.getRow(2, v);
        assertArrayEquals(new double[]{9, 10, 11, 12}, v, EPSILON);
        
        m.getRow(3, v);
        assertArrayEquals(new double[]{13, 14, 15, 16}, v, EPSILON);
    }

    @Test
    public void testRowVectorGetters() {
        Matrix4d m = new Matrix4d(plainInts());

        Vector4d v;
        v = m.getRow(0);
        assertEquals(new Vector4d(1, 2, 3, 4), v);

        v = m.getRow(1);
        assertEquals(new Vector4d(5, 6, 7, 8), v);

        v = m.getRow(2);
        assertEquals(new Vector4d(9, 10, 11, 12), v);

        v = m.getRow(3);
        assertEquals(new Vector4d(13, 14, 15, 16), v);
    }

    @Test
    public void testColumnVectorGetters() {
        Matrix4d m = new Matrix4d(plainInts());

        Vector4d v;
        v = m.getColumn(0);
        assertEquals(new Vector4d(1, 5, 9, 13), v);

        v = m.getColumn(1);
        assertEquals(new Vector4d(2, 6, 10, 14), v);

        v = m.getColumn(2);
        assertEquals(new Vector4d(3, 7, 11, 15), v);

        v = m.getColumn(3);
        assertEquals(new Vector4d(4, 8, 12, 16), v);
    }

    @Test
    public void testColArrayGetters() {
        Matrix4d m = new Matrix4d(plainInts());
        double[] v = new double[4];

        m.getColumn(0, v);
        assertArrayEquals(new double[]{1, 5, 9, 13}, v, EPSILON);

        m.getColumn(1, v);
        assertArrayEquals(new double[]{2, 6, 10, 14}, v, EPSILON);

        m.getColumn(2, v);
        assertArrayEquals(new double[]{3, 7, 11, 15}, v, EPSILON);

        m.getColumn(3, v);
        assertArrayEquals(new double[]{4, 8, 12, 16}, v, EPSILON);
    }

    @Test
    public void testGetters() {
        Matrix4d m = new Matrix4d(plainInts());
        assertEquals(1, m.get(0, 0), EPSILON);
        assertEquals(2, m.get(0, 1), EPSILON);
        assertEquals(3, m.get(0, 2), EPSILON);
        assertEquals(4, m.get(0, 3), EPSILON);
        assertEquals(5, m.get(1, 0), EPSILON);
        assertEquals(6, m.get(1, 1), EPSILON);
        assertEquals(7, m.get(1, 2), EPSILON);
        assertEquals(8, m.get(1, 3), EPSILON);
        assertEquals(9, m.get(2, 0), EPSILON);
        assertEquals(10, m.get(2, 1), EPSILON);
        assertEquals(11, m.get(2, 2), EPSILON);
        assertEquals(12, m.get(2, 3), EPSILON);
        assertEquals(13, m.get(3, 0), EPSILON);
        assertEquals(14, m.get(3, 1), EPSILON);
        assertEquals(15, m.get(3, 2), EPSILON);
        assertEquals(16, m.get(3, 3), EPSILON);
    }

    @Test
    public void testSet() {
        Matrix4d m = createRandomly(new Random(12345));

        double[] data = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        m.set(data);
        double[] data2 = new double[16];
        m.get(data2);
        assertArrayEquals(data, data2, EPSILON);
    }

    private double[] plainInts() {
        return new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    }
    
    private Matrix4d createRandomly(Random r) {
        double[] data = new double[16];
        for (int k = 0; k < data.length; k++) {
            data[k] = 32 + r.nextDouble() * 32;
        }
        Matrix4d m = new Matrix4d(data);
        return m;

    }
}
