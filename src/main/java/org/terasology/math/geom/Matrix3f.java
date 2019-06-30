/*
 * Copyright 2019 MovingBlocks
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

import org.joml.Matrix3dc;
import org.joml.Matrix3fc;

import java.nio.FloatBuffer;

/**
 * A float precision floating point 3x3 float matrix.
 * @author auto-generated
 */
public class Matrix3f extends BaseMatrix3f {

    /**
     * Entry at row 0, column 0
     */
    public float m00;

    /**
     * Entry at row 0, column 1
     */
    public float m01;

    /**
     * Entry at row 0, column 2
     */
    public float m02;

    /**
     * Entry at row 1, column 0
     */
    public float m10;

    /**
     * Entry at row 1, column 1
     */
    public float m11;

    /**
     * Entry at row 1, column 2
     */
    public float m12;

    /**
     * Entry at row 2, column 0
     */
    public float m20;

    /**
     * Entry at row 2, column 1
     */
    public float m21;

    /**
     * Entry at row 2, column 2
     */
    public float m22;


    /**
     * Constructs and initializes a Matrix3f from the specified values.
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
    public Matrix3f(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
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
    public Matrix3f(Matrix3fc m1) {
        this.m00 = m1.m00();
        this.m01 = m1.m01();
        this.m02 = m1.m02();
        this.m10 = m1.m10();
        this.m11 = m1.m11();
        this.m12 = m1.m12();
        this.m20 = m1.m20();
        this.m21 = m1.m21();
        this.m22 = m1.m22();
    }

    /**
     * Constructs and initializes a Matrix3f from the specified nine-
     * element array.
     * @param v the array of length 9 containing in order
     */
    public Matrix3f(float[] v) {
        this.m00 = v[0];
        this.m01 = v[1];
        this.m02 = v[2];

        this.m10 = v[3];
        this.m11 = v[4];
        this.m12 = v[5];

        this.m20 = v[6];
        this.m21 = v[7];
        this.m22 = v[8];
    }

    /**
     * Constructs and initializes to all zeros.
     */
    public Matrix3f() {
        // no-op
    }

    /**
     * Sets this instance to identity.
     */
    public final void setIdentity() {
        this.m00 = 1;
        this.m01 = 0;
        this.m02 = 0;

        this.m10 = 0;
        this.m11 = 1;
        this.m12 = 0;

        this.m20 = 0;
        this.m21 = 0;
        this.m22 = 1;
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


    /**
     * Sets the specified element of this matrix3f to the value provided.
     * @param row the row number to be modified (zero indexed)
     * @param column the column number to be modified (zero indexed)
     * @param value the new value
     */
    public final void set(int row, int column, float value) {
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
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
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
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
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
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
                }
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the 4 values provided.
     * @param row the row number to be modified (zero indexed)
     * @param x the first column element
     * @param y the second column element
     * @param z the third column element
     */
    public final void setRow(int row, float x, float y, float z) {
        switch (row) {
            case 0:
                this.m00 = x;
                this.m01 = y;
                this.m02 = z;
                break;

            case 1:
                this.m10 = x;
                this.m11 = y;
                this.m12 = z;
                break;

            case 2:
                this.m20 = x;
                this.m21 = y;
                this.m22 = z;
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the Vector provided.
     * @param row the row number to be modified (zero indexed)
     * @param v the replacement row
     */
    public final void setRow(int row, BaseVector3f v) {
        switch (row) {
            case 0:
                this.m00 = v.getX();
                this.m01 = v.getY();
                this.m02 = v.getZ();
                break;

            case 1:
                this.m10 = v.getX();
                this.m11 = v.getY();
                this.m12 = v.getZ();
                break;

            case 2:
                this.m20 = v.getX();
                this.m21 = v.getY();
                this.m22 = v.getZ();
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Sets the specified row of this matrix3d to the three values provided.
     * @param row the row number to be modified (zero indexed)
     * @param v the replacement row
     */
    public final void setRow(int row, float[] v) {
        switch (row) {
            case 0:
                this.m00 = v[0];
                this.m01 = v[1];
                this.m02 = v[2];
                break;

            case 1:
                this.m10 = v[0];
                this.m11 = v[1];
                this.m12 = v[2];
                break;

            case 2:
                this.m20 = v[0];
                this.m21 = v[1];
                this.m22 = v[2];
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
     */
    public final void setColumn(int column, float x, float y, float z) {
        switch (column) {
            case 0:
                this.m00 = x;
                this.m10 = y;
                this.m20 = z;
                break;

            case 1:
                this.m01 = x;
                this.m11 = y;
                this.m21 = z;
                break;

            case 2:
                this.m02 = x;
                this.m12 = y;
                this.m22 = z;
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }
    }

    /**
     * Sets the specified column of this matrix3d to the vector provided.
     * @param column the column number to be modified (zero indexed)
     * @param v the replacement column
     */
    public final void setColumn(int column, Vector3f v) {
        switch (column) {
            case 0:
                this.m00 = v.getX();
                this.m10 = v.getY();
                this.m20 = v.getZ();
                break;

            case 1:
                this.m01 = v.getX();
                this.m11 = v.getY();
                this.m21 = v.getZ();
                break;

            case 2:
                this.m02 = v.getX();
                this.m12 = v.getY();
                this.m22 = v.getZ();
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }
    }

    /**
     * Sets the specified column of this matrix3d to the three values provided.
     * @param column the column number to be modified (zero indexed)
     * @param v the replacement column
     */
    public final void setColumn(int column, float[] v) {
        switch (column) {
            case 0:
                this.m00 = v[0];
                this.m10 = v[1];
                this.m20 = v[2];
                break;

            case 1:
                this.m01 = v[0];
                this.m11 = v[1];
                this.m21 = v[2];
                break;

            case 2:
                this.m02 = v[0];
                this.m12 = v[1];
                this.m22 = v[2];
                break;

            default:
                throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }
    }

    /**
     * Adds a scalar to each component of this matrix.
     * @param scalar  the scalar adder
     */
    public final void add(float scalar) {
        m00 += scalar;
        m01 += scalar;
        m02 += scalar;

        m10 += scalar;
        m11 += scalar;
        m12 += scalar;

        m20 += scalar;
        m21 += scalar;
        m22 += scalar;

    }

    /**
     * Sets the value of this matrix to the sum of itself and matrix m1.
     * @param m1 the other matrix
     */
    public final void add(BaseMatrix3f m1) {
        this.m00 += m1.get(0, 0);
        this.m01 += m1.get(0, 1);
        this.m02 += m1.get(0, 2);

        this.m10 += m1.get(1, 0);
        this.m11 += m1.get(1, 1);
        this.m12 += m1.get(1, 2);

        this.m20 += m1.get(2, 0);
        this.m21 += m1.get(2, 1);
        this.m22 += m1.get(2, 2);
    }

    /**
     * Sets the value of this matrix to the matrix difference of itself and
     * matrix m1 (this = this - m1).
     * @param m1 the other matrix
     */
    public final void sub(BaseMatrix3f m1) {
        this.m00 -= m1.get(0, 0);
        this.m01 -= m1.get(0, 1);
        this.m02 -= m1.get(0, 2);

        this.m10 -= m1.get(1, 0);
        this.m11 -= m1.get(1, 1);
        this.m12 -= m1.get(1, 2);

        this.m20 -= m1.get(2, 0);
        this.m21 -= m1.get(2, 1);
        this.m22 -= m1.get(2, 2);
    }

    /**
     * Sets the value of this matrix to its transpose.
     */
    public final void transpose() {
        float temp;

        temp = this.m10;
        this.m10 = this.m01;
        this.m01 = temp;

        temp = this.m20;
        this.m20 = this.m02;
        this.m02 = temp;

        temp = this.m21;
        this.m21 = this.m12;
        this.m12 = temp;
    }

    /**
     * Sets the value of this matrix to the transpose of the argument matrix.
     * @param m1 the matrix to be transposed
     */
    public final void transpose(BaseMatrix3f m1) {
        this.m00 = m1.get(0, 0);
        this.m01 = m1.get(1, 0);
        this.m02 = m1.get(2, 0);

        this.m10 = m1.get(0, 1);
        this.m11 = m1.get(1, 1);
        this.m12 = m1.get(2, 1);

        this.m20 = m1.get(0, 2);
        this.m21 = m1.get(1, 2);
        this.m22 = m1.get(2, 2);
    }


    /**
     * Sets the value of this matrix to the matrix conversion of the
     * float precision quaternion argument.
     * @param q1 the quaternion to be converted
     */
    public final void set(BaseQuat4f q1) {
        this.m00 = (float) (1.0 - 2.0 * q1.getY() * q1.getY() - 2.0 * q1.getZ() * q1.getZ());
        this.m10 = (float) (2.0 * (q1.getX() * q1.getY() + q1.getW() * q1.getZ()));
        this.m20 = (float) (2.0 * (q1.getX() * q1.getZ() - q1.getW() * q1.getY()));

        this.m01 = (float) (2.0 * (q1.getX() * q1.getY() - q1.getW() * q1.getZ()));
        this.m11 = (float) (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getZ() * q1.getZ());
        this.m21 = (float) (2.0 * (q1.getY() * q1.getZ() + q1.getW() * q1.getX()));

        this.m02 = (float) (2.0 * (q1.getX() * q1.getZ() + q1.getW() * q1.getY()));
        this.m12 = (float) (2.0 * (q1.getY() * q1.getZ() - q1.getW() * q1.getX()));
        this.m22 = (float) (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getY() * q1.getY());
    }

    /**
     * Sets the value of this matrix to the value of the Matrix3d
     * argument.
     * @param m1 the source matrix3d
     */
    public final void set(BaseMatrix3f m1) {
        this.m00 = m1.get(0, 0);
        this.m01 = m1.get(0, 1);
        this.m02 = m1.get(0, 2);

        this.m10 = m1.get(1, 0);
        this.m11 = m1.get(1, 1);
        this.m12 = m1.get(1, 2);

        this.m20 = m1.get(2, 0);
        this.m21 = m1.get(2, 1);
        this.m22 = m1.get(2, 2);
    }

    /**
     *  Sets the values in this Matrix3d equal to the row-major
     *  array parameter (ie, the first three elements of the
     *  array will be copied into the first row of this matrix, etc.).
     *  @param m  the float precision array of length 9
     */
    public final void set(float[] m) {
        m00 = m[0];
        m01 = m[1];
        m02 = m[2];

        m10 = m[3];
        m11 = m[4];
        m12 = m[5];

        m20 = m[6];
        m21 = m[7];
        m22 = m[8];

    }

    /**
     * Sets the value of this matrix to a scale matrix with
     * the passed scale amount.
     * @param scale the scale factor for the matrix
     */
    public final void set(float scale) {
        this.m00 = scale;
        this.m01 = 0;
        this.m02 = 0;

        this.m10 = 0;
        this.m11 = scale;
        this.m12 = 0;

        this.m20 = 0;
        this.m21 = 0;
        this.m22 = scale;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the x axis.
     * @param angle the angle to rotate about the X axis in radians
     */
    public final void setRotX(float angle) {
        float sinAngle;
        float cosAngle;

        sinAngle = (float) (Math.sin(angle));
        cosAngle = (float) (Math.cos(angle));

        this.m00 = 1;
        this.m01 = 0;
        this.m02 = 0;

        this.m10 = 0;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;

        this.m20 = 0;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the y axis.
     * @param angle the angle to rotate about the Y axis in radians
     */
    public final void setRotY(float angle) {
        float sinAngle;
        float cosAngle;

        sinAngle = (float) (Math.sin(angle));
        cosAngle = (float) (Math.cos(angle));

        this.m00 = cosAngle;
        this.m01 = 0;
        this.m02 = sinAngle;

        this.m10 = 0;
        this.m11 = 1;
        this.m12 = 0;

        this.m20 = -sinAngle;
        this.m21 = 0;
        this.m22 = cosAngle;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the z axis.
     * @param angle the angle to rotate about the Z axis in radians
     */
    public final void rotZ(float angle) {
        float sinAngle;
        float cosAngle;

        sinAngle = (float) (Math.sin(angle));
        cosAngle = (float) (Math.cos(angle));

        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = 0;

        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = 0;

        this.m20 = 0;
        this.m21 = 0;
        this.m22 = 1;
    }

    /**
      * Multiplies each element of this matrix by a scalar.
      * @param scalar  The scalar multiplier.
      */
    public final void mul(float scalar) {
        m00 *= scalar;
        m01 *= scalar;
        m02 *= scalar;

        m10 *= scalar;
        m11 *= scalar;
        m12 *= scalar;

        m20 *= scalar;
        m21 *= scalar;
        m22 *= scalar;

    }

    /**
      * Sets the value of this matrix to the result of multiplying itself
      * with matrix m1.
      * @param m1 the other matrix
      */
    public final void mul(BaseMatrix3f m1) {
        float lm00;
        float lm01;
        float lm02;
        float lm10;
        float lm11;
        float lm12;
        float lm20;
        float lm21;
        float lm22;

        lm00 = this.m00 * m1.get(0, 0) + this.m01 * m1.get(1, 0) + this.m02 * m1.get(2, 0);
        lm01 = this.m00 * m1.get(0, 1) + this.m01 * m1.get(1, 1) + this.m02 * m1.get(2, 1);
        lm02 = this.m00 * m1.get(0, 2) + this.m01 * m1.get(1, 2) + this.m02 * m1.get(2, 2);

        lm10 = this.m10 * m1.get(0, 0) + this.m11 * m1.get(1, 0) + this.m12 * m1.get(2, 0);
        lm11 = this.m10 * m1.get(0, 1) + this.m11 * m1.get(1, 1) + this.m12 * m1.get(2, 1);
        lm12 = this.m10 * m1.get(0, 2) + this.m11 * m1.get(1, 2) + this.m12 * m1.get(2, 2);

        lm20 = this.m20 * m1.get(0, 0) + this.m21 * m1.get(1, 0) + this.m22 * m1.get(2, 0);
        lm21 = this.m20 * m1.get(0, 1) + this.m21 * m1.get(1, 1) + this.m22 * m1.get(2, 1);
        lm22 = this.m20 * m1.get(0, 2) + this.m21 * m1.get(1, 2) + this.m22 * m1.get(2, 2);

        this.m00 = lm00;
        this.m01 = lm01;
        this.m02 = lm02;
        this.m10 = lm10;
        this.m11 = lm11;
        this.m12 = lm12;
        this.m20 = lm20;
        this.m21 = lm21;
        this.m22 = lm22;
    }

    /**
     * Sets this matrix to all zeros.
     */
    public final void setZero() {
        m00 = 0;
        m01 = 0;
        m02 = 0;

        m10 = 0;
        m11 = 0;
        m12 = 0;

        m20 = 0;
        m21 = 0;
        m22 = 0;

    }

    /**
     * Negates the value of this matrix: this = -this.
     */
    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;

        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;

        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
    }

    /**
     * Invert the matrix
     * @throws IllegalStateException if the matrix is not invertible
     */
    public void invert() {
        double determinant = this.determinant();

        if (determinant != 0) {
            /* do it the ordinary way
             *
             * inv(A) = 1/det(A) * adj(T), where adj(T) = transpose(Conjugate Matrix)
             *
             * m00 m01 m02
             * m10 m11 m12
             * m20 m21 m22
             */
            double determinantInv = 1 / determinant;

            // get the conjugate matrix
            double t00 = this.m11 * this.m22 - this.m12 * this.m21;
            double t01 = -this.m10 * this.m22 + this.m12 * this.m20;
            double t02 = this.m10 * this.m21 - this.m11 * this.m20;
            double t10 = -this.m01 * this.m22 + this.m02 * this.m21;
            double t11 = this.m00 * this.m22 - this.m02 * this.m20;
            double t12 = -this.m00 * this.m21 + this.m01 * this.m20;
            double t20 = this.m01 * this.m12 - this.m02 * this.m11;
            double t21 = -this.m00 * this.m12 + this.m02 * this.m10;
            double t22 = this.m00 * this.m11 - this.m01 * this.m10;

            m00 = (float) (t00 * determinantInv);
            m11 = (float) (t11 * determinantInv);
            m22 = (float) (t22 * determinantInv);
            m01 = (float) (t10 * determinantInv);
            m10 = (float) (t01 * determinantInv);
            m20 = (float) (t02 * determinantInv);
            m02 = (float) (t20 * determinantInv);
            m12 = (float) (t21 * determinantInv);
            m21 = (float) (t12 * determinantInv);
        } else {
            throw new IllegalStateException("matrix is not invertible");
        }
    }

    /**
    * takes the contents of the matrix and appends the results to a buffer
    * @param fb to append results to
    */
    public void appendToBuffer(FloatBuffer fb){
      fb.put(m00);
      fb.put(m01);
      fb.put(m02);
      fb.put(m10);
      fb.put(m11);
      fb.put(m12);
      fb.put(m20);
      fb.put(m21);
      fb.put(m22);
      fb.flip();
    }

    /**
     * Multiply this matrix by the tuple t and place the result
     * back into the tuple (t = this*t).
     * @param t  the tuple to be multiplied by this matrix and then replaced
     */
    public final void transform(Vector3f t) {
        float x;
        float y;
        float z;
        x = m00 * t.getX() + m01 * t.getY() + m02 * t.getZ();
        y = m10 * t.getX() + m11 * t.getY() + m12 * t.getZ();
        z = m20 * t.getX() + m21 * t.getY() + m22 * t.getZ();
        t.set(x, y, z);
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


    /**
     * Entry at row 0, column 0
     *
     * @param m00 the value for row 0, column 0
     */
    public final void setM00(float m00) {
        this.m00 = m00;
    }

    /**
     * Entry at row 0, column 1
     *
     * @param m01 the value for row 0, column 1
     */
    public final void setM01(float m01) {
        this.m01 = m01;
    }

    /**
     * Entry at row 0, column 2
     *
     * @param m02 the value for row 0, column 2
     */
    public final void setM02(float m02) {
        this.m02 = m02;
    }

    /**
     * Entry at row 1, column 0
     *
     * @param m10 the value for row 1, column 0
     */
    public final void setM10(float m10) {
        this.m10 = m10;
    }

    /**
     * Entry at row 1, column 1
     *
     * @param m11 the value for row 1, column 1
     */
    public final void setM11(float m11) {
        this.m11 = m11;
    }

    /**
     * Entry at row 1, column 2
     *
     * @param m12 the value for row 1, column 2
     */
    public final void setM12(float m12) {
        this.m12 = m12;
    }

    /**
     * Entry at row 2, column 0
     *
     * @param m20 the value for row 2, column 0
     */
    public final void setM20(float m20) {
        this.m20 = m20;
    }

    /**
     * Entry at row 2, column 1
     *
     * @param m21 the value for row 2, column 1
     */
    public final void setM21(float m21) {
        this.m21 = m21;
    }

    /**
     * Entry at row 2, column 2
     *
     * @param m22 the value for row 2, column 2
     */
    public final void setM22(float m22) {
        this.m22 = m22;
    }


}
