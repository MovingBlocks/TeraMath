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
 * Defines an immutable 3x3 double matrix
 */
public class ImmutableMatrix3d extends BaseMatrix3d {

    /**
     * Entry at row 0, column 0
     */
    private final double m00;

    /**
     * Entry at row 0, column 1
     */
    private final double m01;

    /**
     * Entry at row 0, column 2
     */
    private final double m02;

    /**
     * Entry at row 1, column 0
     */
    private final double m10;

    /**
     * Entry at row 1, column 1
     */
    private final double m11;

    /**
     * Entry at row 1, column 2
     */
    private final double m12;

    /**
     * Entry at row 2, column 0
     */
    private final double m20;

    /**
     * Entry at row 2, column 1
     */
    private final double m21;

    /**
     * Entry at row 2, column 2
     */
    private final double m22;


    /**
     * Constructs and initializes a Matrix3d from the specified values.
     * @param m00 the m00 component
     * @param m01 the m01 component
     * @param m02 the m02 component
     * @param m10 the m10 component
     * @param m11 the m11 component
     * @param m12 the m12 component
     * @param m20 the m20 component
     * @param m21 the m21 component
     * @param m22 the m22 component
     */
    public ImmutableMatrix3d(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    /**
     *  Constructs a new matrix with the same values as the
     *  Matrix3d parameter.
     *  @param m1  the source matrix
     */
    public ImmutableMatrix3d(BaseMatrix3d m1) {
        this.m00 = m1.getM00();
        this.m01 = m1.getM01();
        this.m02 = m1.getM02();
        this.m10 = m1.getM10();
        this.m11 = m1.getM11();
        this.m12 = m1.getM12();
        this.m20 = m1.getM20();
        this.m21 = m1.getM21();
        this.m22 = m1.getM22();
    }

    @Override
    public final double getM00() {
        return m00;
    }

    @Override
    public final double getM01() {
        return m01;
    }

    @Override
    public final double getM02() {
        return m02;
    }

    @Override
    public final double getM10() {
        return m10;
    }

    @Override
    public final double getM11() {
        return m11;
    }

    @Override
    public final double getM12() {
        return m12;
    }

    @Override
    public final double getM20() {
        return m20;
    }

    @Override
    public final double getM21() {
        return m21;
    }

    @Override
    public final double getM22() {
        return m22;
    }


    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    @Override
    public final double get(int row, int column) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0:
                        return (this.getM00());
                    case 1:
                        return (this.getM01());
                    case 2:
                        return (this.getM02());
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
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        throw new ArrayIndexOutOfBoundsException("row/col not in [0..2]");
    }
}
