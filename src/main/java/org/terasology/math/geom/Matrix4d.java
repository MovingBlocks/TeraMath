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

import java.nio.DoubleBuffer;

/**
 * A double precision floating point 4x4 double matrix.
 * @author auto-generated
 */
public class Matrix4d extends BaseMatrix4d {
    /**
     * Constructs and initializes a Matrix4d from the specified values.
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
    public Matrix4d(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double m30, double m31, double m32, double m33) {
        this._m00(m00;
        this._m01(m01);
        this._m02(m02);
        this._m03(m03);
        this._m10(m10);
        this._m11(m11);
        this._m12(m12);
        this._m13(m13);
        this._m20(m20);
        this._m21(m21);
        this._m22(m22);
        this._m23(m23);
        this._m30(m30);
        this._m31(m31);
        this._m32(m32);
        this._m33(m33);
    }

    /**
     *  Constructs a new matrix with the same values as the
     *  Matrix3d parameter.
     *  @param m1  the source matrix
     */
    public Matrix4d(BaseMatrix4d m1) {
        this._m00 = m1.getM00();
        this._m01 = m1.getM01();
        this._m02 = m1.getM02();
        this._m03 = m1.getM03();
        this._m10 = m1.getM10();
        this._m11 = m1.getM11();
        this._m12 = m1.getM12();
        this._m13 = m1.getM13();
        this._m20 = m1.getM20();
        this._m21 = m1.getM21();
        this._m22 = m1.getM22();
        this._m23 = m1.getM23();
        this._m30 = m1.getM30();
        this._m31(m1.getM31();
        this._m32(m1.getM32();
        this._m33(m1.getM33();
    }

    /**
     * Constructs and initializes a Matrix4d from the specified nine-
     * element array.
     * @param v the array of length 16 containing in order
     */
    public Matrix4d(double[] v) {
        this.m00 = v[ 0];
        this.m01 = v[ 1];
        this.m02 = v[ 2];
        this.m03 = v[ 3];

        this.m10 = v[ 4];
        this.m11 = v[ 5];
        this.m12 = v[ 6];
        this.m13 = v[ 7];

        this.m20 = v[ 8];
        this.m21 = v[ 9];
        this.m22 = v[10];
        this.m23 = v[11];

        this.m30 = v[12];
        this.m31 = v[13];
        this.m32 = v[14];
        this.m33 = v[15];
    }

    /**
     * Constructs and initializes a Matrix3d to all zeros.
     */
    public Matrix4d() {
        // no-op
    }

   /**
     * Constructs and initializes a Matrix4d from the quaternion,
     * translation, and scale values; the scale is applied only to the
     * rotational components of the matrix (upper 3x3) and not to the
     * translational components.
     * @param q1  the quaternion value representing the rotational component
     * @param t1  the translational component of the matrix
     * @param s   the scale value applied to the rotational components
     */
    public Matrix4d(BaseQuat4d q1, BaseVector3d t1, double s) {  
        m00 = s * (1.0 - 2.0 * q1.getY() * q1.getY() - 2.0 * q1.getZ() * q1.getZ());
        m10 = s * (2.0 * (q1.getX() * q1.getY() + q1.getW() * q1.getZ()));
        m20 = s * (2.0 * (q1.getX() * q1.getZ() - q1.getW() * q1.getY()));

        m01 = s * (2.0 * (q1.getX() * q1.getY() - q1.getW() * q1.getZ()));
        m11 = s * (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getZ() * q1.getZ());
        m21 = s * (2.0 * (q1.getY() * q1.getZ() + q1.getW() * q1.getX()));

        m02 = s * (2.0 * (q1.getX() * q1.getZ() + q1.getW() * q1.getY()));
        m12 = s * (2.0 * (q1.getY() * q1.getZ() - q1.getW() * q1.getX()));
        m22 = s * (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getY() * q1.getY());

        m03 = t1.getX();
        m13 = t1.getY();
        m23 = t1.getZ();

        m30 = 0;
        m31 = 0;
        m32 = 0;
        m33 = 1;

    }

    /**
     * Sets this Matrix3d to identity.
     */
    public final void setIdentity() {
        this.m00 = 1;
        this.m01 = 0;
        this.m02 = 0;
        this.m03 = 0;

        this.m10 = 0;
        this.m11 = 1;
        this.m12 = 0;
        this.m13 = 0;

        this.m20 = 0;
        this.m21 = 0;
        this.m22 = 1;
        this.m23 = 0;

        this.m30 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = 1;
    }

    /**
     * Modifies the translational components of this matrix to the values
     * of the Vector3f argument; the other values of this matrix are not
     * modified.
     * @param trans  the translational component
     */
    public final void setTranslation(BaseVector3d trans) {
       this.m03 = trans.getX();
       this.m13 = trans.getY();
       this.m23 = trans.getZ();
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

        throw new ArrayIndexOutOfBoundsException("row/col not in [0..2]");
    }

    /**
     * Sets the specified element of this matrix3f to the value provided.
     * @param row the row number to be modified (zero indexed)
     * @param column the column number to be modified (zero indexed)
     * @param value the new value
     */
    public final void set(int row, int column, double value) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0:
                        this.m00 = value;
                        break;
                    case 1:
                        this.m01 = value;
                        break;
                    case 2:
                        this.m02 = value;
                        break;
                    case 3:
                        this.m03 = value;
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 1:
                switch (column) {
                    case 0:
                        this.m10 = value;
                        break;
                    case 1:
                        this.m11 = value;
                        break;
                    case 2:
                        this.m12 = value;
                        break;
                    case 3:
                        this.m13 = value;
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 2:
                switch (column) {
                    case 0:
                        this.m20 = value;
                        break;
                    case 1:
                        this.m21 = value;
                        break;
                    case 2:
                        this.m22 = value;
                        break;
                    case 3:
                        this.m23 = value;
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 3:
                switch (column) {
                    case 0:
                        this.m30 = value;
                        break;
                    case 1:
                        this.m31 = value;
                        break;
                    case 2:
                        this.m32 = value;
                        break;
                    case 3:
                        this.m33 = value;
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the 4 values provided.
     * @param row the row number to be modified (zero indexed)
     * @param x the first column element
     * @param y the second column element
     * @param z the third column element
     * @param w the fourth column element
     */
    public final void setRow(int row, double x, double y, double z, double w) {
        switch (row) {
            case 0:
                this.m00 = x;
                this.m01 = y;
                this.m02 = z;
                this.m03 = w;
                break;

            case 1:
                this.m10 = x;
                this.m11 = y;
                this.m12 = z;
                this.m13 = w;
                break;

            case 2:
                this.m20 = x;
                this.m21 = y;
                this.m22 = z;
                this.m23 = w;
                break;

            case 3:
                this.m30 = x;
                this.m31 = y;
                this.m32 = z;
                this.m33 = w;
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the Vector provided.
     * @param row the row number to be modified (zero indexed)
     * @param v the replacement row
     */
    public final void setRow(int row, Vector4d v) {
        switch (row) {
            case 0:
                this.m00 = v.getX();
                this.m01 = v.getY();
                this.m02 = v.getZ();
                this.m03 = v.getW();
                break;

            case 1:
                this.m10 = v.getX();
                this.m11 = v.getY();
                this.m12 = v.getZ();
                this.m13 = v.getW();
                break;

            case 2:
                this.m20 = v.getX();
                this.m21 = v.getY();
                this.m22 = v.getZ();
                this.m23 = v.getW();
                break;

            case 3:
                this.m30 = v.getX();
                this.m31 = v.getY();
                this.m32 = v.getZ();
                this.m33 = v.getW();
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the three values provided.
     * @param row the row number to be modified (zero indexed)
     * @param v the replacement row
     */
    public final void setRow(int row, double[] v) {
        switch (row) {
            case 0:
                this.m00 = v[0];
                this.m01 = v[1];
                this.m02 = v[2];
                this.m03 = v[3];
                break;

            case 1:
                this.m10 = v[0];
                this.m11 = v[1];
                this.m12 = v[2];
                this.m13 = v[3];
                break;

            case 2:
                this.m20 = v[0];
                this.m21 = v[1];
                this.m22 = v[2];
                this.m23 = v[3];
                break;

            case 3:
                this.m30 = v[0];
                this.m31 = v[1];
                this.m32 = v[2];
                this.m33 = v[3];
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Sets the specified column of this matrix3d to the three values provided.
     * @param column the column number to be modified (zero indexed)
     * @param x the first row element
     * @param y the second row element
     * @param z the third row element
     * @param w the fourth row element
     */
    public final void setColumn(int column, double x, double y, double z, double w) {
        switch (column) {
            case 0:
                this.m00 = x;
                this.m10 = y;
                this.m20 = z;
                this.m30 = w;
                break;

            case 1:
                this.m01 = x;
                this.m11 = y;
                this.m21 = z;
                this.m31 = w;
                break;

            case 2:
                this.m02 = x;
                this.m12 = y;
                this.m22 = z;
                this.m32 = w;
                break;

            case 3:
                this.m03 = x;
                this.m13 = y;
                this.m23 = z;
                this.m33 = w;
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }
    }

    /**
     * Sets the specified column of this matrix3d to the vector provided.
     * @param column the column number to be modified (zero indexed)
     * @param v the replacement column
     */
    public final void setColumn(int column, BaseVector4d v) {
        switch (column) {
            case 0:
                this.m00 = v.getX();
                this.m10 = v.getY();
                this.m20 = v.getZ();
                this.m30 = v.getW();
                break;

            case 1:
                this.m01 = v.getX();
                this.m11 = v.getY();
                this.m21 = v.getZ();
                this.m31 = v.getW();
                break;

            case 2:
                this.m02 = v.getX();
                this.m12 = v.getY();
                this.m22 = v.getZ();
                this.m32 = v.getW();
                break;

            case 3:
                this.m03 = v.getX();
                this.m13 = v.getY();
                this.m23 = v.getZ();
                this.m33 = v.getW();
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }
    }

    /**
     * Sets the specified column of this matrix3d to the three values provided.
     * @param column the column number to be modified (zero indexed)
     * @param v the replacement column
     */
    public final void setColumn(int column, double[] v) {
        switch (column) {
            case 0:
                this.m00 = v[0];
                this.m10 = v[1];
                this.m20 = v[2];
                this.m30 = v[3];
                break;

            case 1:
                this.m01 = v[0];
                this.m11 = v[1];
                this.m21 = v[2];
                this.m31 = v[3];
                break;

            case 2:
                this.m02 = v[0];
                this.m12 = v[1];
                this.m22 = v[2];
                this.m32 = v[3];
                break;

            case 3:
                this.m03 = v[0];
                this.m13 = v[1];
                this.m23 = v[2];
                this.m33 = v[3];
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }
    }

    /**
     * Adds a scalar to each component of this matrix.
     * @param scalar  the scalar adder
     */
    public final void add(double scalar) {
        m00 += scalar;
        m01 += scalar;
        m02 += scalar;
        m03 += scalar;

        m10 += scalar;
        m11 += scalar;
        m12 += scalar;
        m13 += scalar;

        m20 += scalar;
        m21 += scalar;
        m22 += scalar;
        m23 += scalar;

        m30 += scalar;
        m31 += scalar;
        m32 += scalar;
        m33 += scalar;
    }

    /**
     * Sets the value of this matrix to the sum of itself and matrix m1.
     * @param m1 the other matrix
     */
    public final void add(BaseMatrix4d m1) {
        this.m00 += m1.get(0, 0);
        this.m01 += m1.get(0, 1);
        this.m02 += m1.get(0, 2);
        this.m03 += m1.get(0, 3);

        this.m10 += m1.get(1, 0);
        this.m11 += m1.get(1, 1);
        this.m12 += m1.get(1, 2);
        this.m13 += m1.get(1, 3);

        this.m20 += m1.get(2, 0);
        this.m21 += m1.get(2, 1);
        this.m22 += m1.get(2, 2);
        this.m23 += m1.get(2, 3);

        this.m30 += m1.get(3, 0);
        this.m31 += m1.get(3, 1);
        this.m32 += m1.get(3, 2);
        this.m33 += m1.get(3, 3);
    }

    /**
     * Sets the value of this matrix to the matrix difference of itself and
     * matrix m1 (this = this - m1).
     * @param m1 the other matrix
     */
    public final void sub(BaseMatrix4d m1) {
        this.m00 -= m1.get(0, 0);
        this.m01 -= m1.get(0, 1);
        this.m02 -= m1.get(0, 2);
        this.m03 -= m1.get(0, 3);

        this.m10 -= m1.get(1, 0);
        this.m11 -= m1.get(1, 1);
        this.m12 -= m1.get(1, 2);
        this.m13 -= m1.get(1, 3);

        this.m20 -= m1.get(2, 0);
        this.m21 -= m1.get(2, 1);
        this.m22 -= m1.get(2, 2);
        this.m23 -= m1.get(2, 3);

        this.m30 -= m1.get(3, 0);
        this.m31 -= m1.get(3, 1);
        this.m32 -= m1.get(3, 2);
        this.m33 -= m1.get(3, 3);
    }


    /**
     * Sets the value of this matrix to the transpose of the argument matrix.
     * @param m1 the matrix to be transposed
     */
    public final void transpose(BaseMatrix4d m1) {
        this.m00 = m1.get(0, 0);
        this.m01 = m1.get(1, 0);
        this.m02 = m1.get(2, 0);
        this.m03 = m1.get(3, 0);

        this.m10 = m1.get(0, 1);
        this.m11 = m1.get(1, 1);
        this.m12 = m1.get(2, 1);
        this.m13 = m1.get(3, 1);

        this.m20 = m1.get(0, 2);
        this.m21 = m1.get(1, 2);
        this.m22 = m1.get(2, 2);
        this.m23 = m1.get(3, 2);

        this.m30 = m1.get(0, 3);
        this.m31 = m1.get(1, 3);
        this.m32 = m1.get(2, 3);
        this.m33 = m1.get(3, 3);
    }


    /**
     * Sets the value of this matrix to the matrix conversion of the
     * double precision quaternion argument.
     * @param q1 the quaternion to be converted
     */
    public final void set(Quat4d q1) {
        this.m00 = 1.0 - 2.0 * q1.getY() * q1.getY() - 2.0 * q1.getZ() * q1.getZ();
        this.m10 = 2.0 * (q1.getX() * q1.getY() + q1.getW() * q1.getZ());
        this.m20 = 2.0 * (q1.getX() * q1.getZ() - q1.getW() * q1.getY());

        this.m01 = 2.0 * (q1.getX() * q1.getY() - q1.getW() * q1.getZ());
        this.m11 = 1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getZ() * q1.getZ();
        this.m21 = 2.0 * (q1.getY() * q1.getZ() + q1.getW() * q1.getX());

        this.m02 = 2.0 * (q1.getX() * q1.getZ() + q1.getW() * q1.getY());
        this.m12 = 2.0 * (q1.getY() * q1.getZ() - q1.getW() * q1.getX());
        this.m22 = 1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getY() * q1.getY();

        this.m03 = 0;
        this.m13 = 0;
        this.m23 = 0;

        this.m30 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = 1;
    }

    /**
     * Sets the value of this matrix to the value of the argument.
     * @param m1 the source
     */
    public final void set(BaseMatrix4d m1) {
        this.m00 = m1.get(0, 0);
        this.m01 = m1.get(0, 1);
        this.m02 = m1.get(0, 2);
        this.m03 = m1.get(0, 3);

        this.m10 = m1.get(1, 0);
        this.m11 = m1.get(1, 1);
        this.m12 = m1.get(1, 2);
        this.m13 = m1.get(1, 3);

        this.m20 = m1.get(2, 0);
        this.m21 = m1.get(2, 1);
        this.m22 = m1.get(2, 2);
        this.m23 = m1.get(2, 3);

        this.m30 = m1.get(3, 0);
        this.m31 = m1.get(3, 1);
        this.m32 = m1.get(3, 2);
        this.m33 = m1.get(3, 3);
    }

    /**
     * Sets the value of this matrix to a scale matrix with
     * the passed scale amount.
     * @param scale the scale factor for the matrix
     */
    public final void set(double scale) {
        this.m00 = scale;
        this.m01 = 0;
        this.m02 = 0;
        this.m03 = 0;

        this.m10 = 0;
        this.m11 = scale;
        this.m12 = 0;
        this.m13 = 0;

        this.m20 = 0;
        this.m21 = 0;
        this.m22 = scale;
        this.m23 = 0;

        this.m30 = 0;
        this.m31 = 0;
        this.m32 = 0;
        this.m33 = scale;
    }

    /**
      * Multiplies each element of this matrix by a scalar.
      * @param scalar  The scalar multiplier.
      */
    public final void mul(double scalar) {
        m00 *= scalar;
        m01 *= scalar;
        m02 *= scalar;
        m03 *= scalar;

        m10 *= scalar;
        m11 *= scalar;
        m12 *= scalar;
        m13 *= scalar;

        m20 *= scalar;
        m21 *= scalar;
        m22 *= scalar;
        m23 *= scalar;

        m30 *= scalar;
        m31 *= scalar;
        m32 *= scalar;
        m33 *= scalar;
    }

    /**
     * Sets the value of this matrix to the result of multiplying
     * the two argument matrices together.
     * @param m1 the first matrix
     * @param m2 the second matrix
     */
    public final void mul(BaseMatrix4d m1, BaseMatrix4d m2) {
        set(m1);
        mul(m2);
    }

    /**
      * Sets the value of this matrix to the result of multiplying itself
      * with matrix m1.
      * @param m1 the other matrix
      */
    public final void mul(BaseMatrix4d m1) {
        double lm00;
        double lm01;
        double lm02;
        double lm03;
        double lm10;
        double lm11;
        double lm12;
        double lm13;
        double lm20;
        double lm21;
        double lm22;
        double lm23;
        double lm30;
        double lm31;
        double lm32;
        double lm33;  // vars for temp result matrix 

        lm00 = m00 * m1.getM00() + m01 * m1.getM10()
             + m02 * m1.getM20() + m03 * m1.getM30();
        lm01 = m00 * m1.getM01() + m01 * m1.getM11()
             + m02 * m1.getM21() + m03 * m1.getM31();
        lm02 = m00 * m1.getM02() + m01 * m1.getM12()
             + m02 * m1.getM22() + m03 * m1.getM32();
        lm03 = m00 * m1.getM03() + m01 * m1.getM13()
             + m02 * m1.getM23() + m03 * m1.getM33();

        lm10 = m10 * m1.getM00() + m11 * m1.getM10()
             + m12 * m1.getM20() + m13 * m1.getM30();
        lm11 = m10 * m1.getM01() + m11 * m1.getM11()
             + m12 * m1.getM21() + m13 * m1.getM31();
        lm12 = m10 * m1.getM02() + m11 * m1.getM12()
             + m12 * m1.getM22() + m13 * m1.getM32();
        lm13 = m10 * m1.getM03() + m11 * m1.getM13()
             + m12 * m1.getM23() + m13 * m1.getM33();

        lm20 = m20 * m1.getM00() + m21 * m1.getM10()
             + m22 * m1.getM20() + m23 * m1.getM30();
        lm21 = m20 * m1.getM01() + m21 * m1.getM11()
             + m22 * m1.getM21() + m23 * m1.getM31();
        lm22 = m20 * m1.getM02() + m21 * m1.getM12()
             + m22 * m1.getM22() + m23 * m1.getM32();
        lm23 = m20 * m1.getM03() + m21 * m1.getM13()
             + m22 * m1.getM23() + m23 * m1.getM33();

        lm30 = m30 * m1.getM00() + m31 * m1.getM10()
             + m32 * m1.getM20() + m33 * m1.getM30();
        lm31 = m30 * m1.getM01() + m31 * m1.getM11()
             + m32 * m1.getM21() + m33 * m1.getM31();
        lm32 = m30 * m1.getM02() + m31 * m1.getM12()
             + m32 * m1.getM22() + m33 * m1.getM32();
        lm33 = m30 * m1.getM03() + m31 * m1.getM13()
             + m32 * m1.getM23() + m33 * m1.getM33();

        m00 = lm00;
        m01 = lm01;
        m02 = lm02;
        m03 = lm03;
        m10 = lm10;
        m11 = lm11;
        m12 = lm12;
        m13 = lm13;
        m20 = lm20;
        m21 = lm21;
        m22 = lm22;
        m23 = lm23;
        m30 = lm30;
        m31 = lm31;
        m32 = lm32;
        m33 = lm33;
    }

    /**
     * Sets this matrix to all zeros.
     */
    public final void setZero() {
        m00 = 0;
        m01 = 0;
        m02 = 0;
        m03 = 0;

        m10 = 0;
        m11 = 0;
        m12 = 0;
        m13 = 0;

        m20 = 0;
        m21 = 0;
        m22 = 0;
        m23 = 0;

        m30 = 0;
        m31 = 0;
        m32 = 0;
        m33 = 0;
    }

    /**
     * Negates the value of this matrix: this = -this.
     */
    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m03 = -this.m03;

        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m13 = -this.m13;

        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        this.m23 = -this.m23;

        this.m30 = -this.m30;
        this.m31 = -this.m31;
        this.m32 = -this.m32;
        this.m33 = -this.m33;
    }

    /**
     * Multiply this matrix by the tuple t and place the result
     * back into the tuple (t = this*t).
     * @param vec the tuple to be multiplied by this matrix and then replaced
     */
    public final void transform(Vector4d vec) {

        double x = (m00 * vec.getX() + m01 * vec.getY()
                + m02 * vec.getZ() + m03 * vec.getW());
        double y = (m10 * vec.getX() + m11 * vec.getY()
                + m12 * vec.getZ() + m13 * vec.getW());
        double z = (m20 * vec.getX() + m21 * vec.getY()
                + m22 * vec.getZ() + m23 * vec.getW());
        double w = (m30 * vec.getX() + m31 * vec.getY()
                + m32 * vec.getZ() + m33 * vec.getW());

        vec.set(x, y, z, w);
    }

  /**
   * Transforms the point parameter with this Matrix4f and
   * places the result back into point.  The fourth element of the
   * point input paramter is assumed to be one.
   * @param point  the input point to be transformed.
   */
    public final void transformPoint(Vector3d point) {
        double x;
        double y;

        x = m00 * point.x() + m01 * point.y() + m02 * point.z() + m03;
        y = m10 * point.x() + m11 * point.y() + m12 * point.z() + m13;
        point.setZ(m20 * point.x() + m21 * point.y() + m22 * point.z() + m23);
        point.setX(x);
        point.setY(y);
    }

  /**
   * Transforms the normal parameter by this transform and places the value
   * back into normal.  The fourth element of the normal is assumed to be zero.
   * @param normal   the input normal to be transformed.
   */
    public final void transformVector(Vector3d normal) {
        double x;
        double y;

        x = m00 * normal.x() + m01 * normal.y() + m02 * normal.z();
        y = m10 * normal.x() + m11 * normal.y() + m12 * normal.z();
        normal.setZ(m20 * normal.x() + m21 * normal.y() + m22 * normal.z());
        normal.setX(x);
        normal.setY(y);
    }


    /**
     * Sets the value of this matrix to the matrix inverse
     * of the passed (user declared) matrix m1.
     * @param m1 the matrix to be inverted
     */
    public final void invert(Matrix4d m1) {
        set(m1);
        invert();
    }

    /**
    * takes the contents of the matrix and appends the results to a buffer
    * @param fb to append results to
    */
    public void appendToBuffer(DoubleBuffer fb){
      fb.put(m00);
      fb.put(m01);
      fb.put(m02);
      fb.put(m03);
      fb.put(m10);
      fb.put(m11);
      fb.put(m12);
      fb.put(m13);
      fb.put(m20);
      fb.put(m21);
      fb.put(m22);
      fb.put(m23);
      fb.put(m30);
      fb.put(m31);
      fb.put(m32);
      fb.put(m33);
      fb.flip();
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
    public final double getM03() {
        return m03;
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
    public final double getM13() {
        return m13;
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

    @Override
    public final double getM23() {
        return m23;
    }

    @Override
    public final double getM30() {
        return m30;
    }

    @Override
    public final double getM31() {
        return m31;
    }

    @Override
    public final double getM32() {
        return m32;
    }

    @Override
    public final double getM33() {
        return m33;
    }


    /**
     * Entry at row 0, column 0
     *
     * @param m00 the value for row 0, column 0
     */
    public final void setM00(double m00) {
        this.m00 = m00;
    }

    /**
     * Entry at row 0, column 1
     *
     * @param m01 the value for row 0, column 1
     */
    public final void setM01(double m01) {
        this.m01 = m01;
    }

    /**
     * Entry at row 0, column 2
     *
     * @param m02 the value for row 0, column 2
     */
    public final void setM02(double m02) {
        this.m02 = m02;
    }

    /**
     * Entry at row 0, column 3
     *
     * @param m03 the value for row 0, column 3
     */
    public final void setM03(double m03) {
        this.m03 = m03;
    }

    /**
     * Entry at row 1, column 0
     *
     * @param m10 the value for row 1, column 0
     */
    public final void setM10(double m10) {
        this.m10 = m10;
    }

    /**
     * Entry at row 1, column 1
     *
     * @param m11 the value for row 1, column 1
     */
    public final void setM11(double m11) {
        this.m11 = m11;
    }

    /**
     * Entry at row 1, column 2
     *
     * @param m12 the value for row 1, column 2
     */
    public final void setM12(double m12) {
        this.m12 = m12;
    }

    /**
     * Entry at row 1, column 3
     *
     * @param m13 the value for row 1, column 3
     */
    public final void setM13(double m13) {
        this.m13 = m13;
    }

    /**
     * Entry at row 2, column 0
     *
     * @param m20 the value for row 2, column 0
     */
    public final void setM20(double m20) {
        this.m20 = m20;
    }

    /**
     * Entry at row 2, column 1
     *
     * @param m21 the value for row 2, column 1
     */
    public final void setM21(double m21) {
        this.m21 = m21;
    }

    /**
     * Entry at row 2, column 2
     *
     * @param m22 the value for row 2, column 2
     */
    public final void setM22(double m22) {
        this.m22 = m22;
    }

    /**
     * Entry at row 2, column 3
     *
     * @param m23 the value for row 2, column 3
     */
    public final void setM23(double m23) {
        this.m23 = m23;
    }

    /**
     * Entry at row 3, column 0
     *
     * @param m30 the value for row 3, column 0
     */
    public final void setM30(double m30) {
        this.m30 = m30;
    }

    /**
     * Entry at row 3, column 1
     *
     * @param m31 the value for row 3, column 1
     */
    public final void setM31(double m31) {
        this.m31 = m31;
    }

    /**
     * Entry at row 3, column 2
     *
     * @param m32 the value for row 3, column 2
     */
    public final void setM32(double m32) {
        this.m32 = m32;
    }

    /**
     * Entry at row 3, column 3
     *
     * @param m33 the value for row 3, column 3
     */
    public final void setM33(double m33) {
        this.m33 = m33;
    }


}
