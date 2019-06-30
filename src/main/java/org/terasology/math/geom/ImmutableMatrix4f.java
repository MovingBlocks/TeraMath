/*
 * Copyright 2019 MovingBlocks
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

/**
 * Defines an immutable 4x4 float matrix
 * @author auto-generated
 */
public class ImmutableMatrix4f extends BaseMatrix4f {

    /**
     * Entry at row 0, column 0
     */
    private final float m00;

    /**
     * Entry at row 0, column 1
     */
    private final float m01;

    /**
     * Entry at row 0, column 2
     */
    private final float m02;

    /**
     * Entry at row 0, column 3
     */
    private final float m03;

    /**
     * Entry at row 1, column 0
     */
    private final float m10;

    /**
     * Entry at row 1, column 1
     */
    private final float m11;

    /**
     * Entry at row 1, column 2
     */
    private final float m12;

    /**
     * Entry at row 1, column 3
     */
    private final float m13;

    /**
     * Entry at row 2, column 0
     */
    private final float m20;

    /**
     * Entry at row 2, column 1
     */
    private final float m21;

    /**
     * Entry at row 2, column 2
     */
    private final float m22;

    /**
     * Entry at row 2, column 3
     */
    private final float m23;

    /**
     * Entry at row 3, column 0
     */
    private final float m30;

    /**
     * Entry at row 3, column 1
     */
    private final float m31;

    /**
     * Entry at row 3, column 2
     */
    private final float m32;

    /**
     * Entry at row 3, column 3
     */
    private final float m33;


    /**
     * Constructs and initializes a Matrix3d from the specified values.
     * @param m00 the m00 component
     * @param m01 the m01 component
     * @param m02 the m02 component
     * @param m03 the m03 component
     * @param m10 the m10 component
     * @param m11 the m11 component
     * @param m12 the m12 component
     * @param m13 the m13 component
     * @param m20 the m20 component
     * @param m21 the m21 component
     * @param m22 the m22 component
     * @param m23 the m23 component
     * @param m30 the m30 component
     * @param m31 the m31 component
     * @param m32 the m32 component
     * @param m33 the m33 component
     */
    public ImmutableMatrix4f(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    /**
     *  Constructs a new matrix with the same values as the
     *  Matrix3d parameter.
     *  @param m1  the source matrix
     */
    public ImmutableMatrix4f(BaseMatrix4f m1) {
        this.m00 = m1.getM00();
        this.m01 = m1.getM01();
        this.m02 = m1.getM02();
        this.m03 = m1.getM03();
        this.m10 = m1.getM10();
        this.m11 = m1.getM11();
        this.m12 = m1.getM12();
        this.m13 = m1.getM13();
        this.m20 = m1.getM20();
        this.m21 = m1.getM21();
        this.m22 = m1.getM22();
        this.m23 = m1.getM23();
        this.m30 = m1.getM30();
        this.m31 = m1.getM31();
        this.m32 = m1.getM32();
        this.m33 = m1.getM33();
    }

    @Override
    public final float getM00() {
        return m00;
    }

    @Override
    public final float getM01() {
        return m01;
    }

    @Override
    public final float getM02() {
        return m02;
    }

    @Override
    public final float getM03() {
        return m03;
    }

    @Override
    public final float getM10() {
        return m10;
    }

    @Override
    public final float getM11() {
        return m11;
    }

    @Override
    public final float getM12() {
        return m12;
    }

    @Override
    public final float getM13() {
        return m13;
    }

    @Override
    public final float getM20() {
        return m20;
    }

    @Override
    public final float getM21() {
        return m21;
    }

    @Override
    public final float getM22() {
        return m22;
    }

    @Override
    public final float getM23() {
        return m23;
    }

    @Override
    public final float getM30() {
        return m30;
    }

    @Override
    public final float getM31() {
        return m31;
    }

    @Override
    public final float getM32() {
        return m32;
    }

    @Override
    public final float getM33() {
        return m33;
    }


    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    @Override
    public final float get(int row, int column) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0:
                        return (this.getM00());
                    case 1:
                        return (this.getM01());
                    case 2:
                        return (this.getM02());
                    case 3:
                        return (this.getM03());
                    default:
                        break;
                }
                break;
            case 1:
                switch (column) {
                    case 0:
                        return (this.getM10());
                    case 1:
                        return (this.getM11());
                    case 2:
                        return (this.getM12());
                    case 3:
                        return (this.getM13());
                    default:
                        break;
                }
                break;

            case 2:
                switch (column) {
                    case 0:
                        return (this.getM20());
                    case 1:
                        return (this.getM21());
                    case 2:
                        return (this.getM22());
                    case 3:
                        return (this.getM23());
                    default:
                        break;
                }
                break;

            case 3:
                switch (column) {
                    case 0:
                        return (this.getM30());
                    case 1:
                        return (this.getM31());
                    case 2:
                        return (this.getM32());
                    case 3:
                        return (this.getM33());
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        throw new ArrayIndexOutOfBoundsException("row/col not in [0..3]");
    }
}
