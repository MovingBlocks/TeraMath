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

/**
 * Defines an immutable 3x3 double matrix
 * @author Martin Steiger
 */
public class ImmutableMatrix3d extends BaseMatrix3d {
    /**
     * The first matrix element in the first row.
     */
    private final double m00;

    /**
     * The second matrix element in the first row.
     */
    private final double m01;

    /**
     * The third matrix element in the first row.
     */
    private final double m02;

    /**
     * The first matrix element in the second row.
     */
    private final double m10;

    /**
     * The second matrix element in the second row.
     */
    private final double m11;

    /**
     * The third matrix element in the second row.
     */
    private final double m12;

    /**
     * The first matrix element in the third row.
     */
    private final double m20;

    /**
     * The second matrix element in the third row.
     */
    private final double m21;

    /**
     * The third matrix element in the third row.
     */
    private final double m22;

    /**
     * Constructs and initializes a Matrix3d from the specified nine values.
     * @param m00 the [0][0] element
     * @param m01 the [0][1] element
     * @param m02 the [0][2] element
     * @param m10 the [1][0] element
     * @param m11 the [1][1] element
     * @param m12 the [1][2] element
     * @param m20 the [2][0] element
     * @param m21 the [2][1] element
     * @param m22 the [2][2] element
     */
    public ImmutableMatrix3d(double m00, double m01, double m02,
            double m10, double m11, double m12,
            double m20, double m21, double m22) {
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
    public double getM00() {
        return m00;
    }

    @Override
    public double getM01() {
        return m01;
    }

    @Override
    public double getM02() {
        return m02;
    }

    @Override
    public double getM10() {
        return m10;
    }

    @Override
    public double getM11() {
        return m11;
    }

    @Override
    public double getM12() {
        return m12;
    }

    @Override
    public double getM20() {
        return m20;
    }

    @Override
    public double getM21() {
        return m21;
    }

    @Override
    public double getM22() {
        return m22;
    }
    
    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
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
