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
 * A double precision floating point 3 by 3 matrix.
 * @author Martin Steiger
 */
public class Matrix3d extends BaseMatrix3d {

    private double m00;
    private double m01;
    private double m02;
    private double m10;
    private double m11;
    private double m12;
    private double m20;
    private double m21;
    private double m22;

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
    public Matrix3d(double m00, double m01, double m02,
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
     * Constructs and initializes a Matrix3d from the specified nine-
     * element array.
     * @param v the array of length 9 containing in order
     */
    public Matrix3d(double[] v) {
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
      *  Constructs a new matrix with the same values as the
      *  Matrix3d parameter.
      *  @param m1  the source matrix
      */
    public Matrix3d(Matrix3d m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;

        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;

        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
    }

    /**
     * Constructs and initializes a Matrix3d to all zeros.
     */
    public Matrix3d() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;

        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;

        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
    }

    /**
     * Sets this Matrix3d to identity.
     */
    public final void setIdentity() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;

        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;

        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
    }

    /**
     * Sets the specified element of this matrix3f to the value provided.
     * @param row the row number to be modified (zero indexed)
     * @param column the column number to be modified (zero indexed)
     * @param value the new value
     */
    public final void setElement(int row, int column, double value) {
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
    public final void setRow(int row, double x, double y, double z) {
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
    public final void setRow(int row, Vector3d v) {
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
    public final void setRow(int row, double[] v) {
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
    public final void setColumn(int column, double x, double y, double z) {
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
    public final void setColumn(int column, Vector3d v) {
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
    public final void setColumn(int column, double[] v) {
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
    public final void add(double scalar) {
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
    public final void add(Matrix3d m1) {
        this.m00 += m1.m00;
        this.m01 += m1.m01;
        this.m02 += m1.m02;

        this.m10 += m1.m10;
        this.m11 += m1.m11;
        this.m12 += m1.m12;

        this.m20 += m1.m20;
        this.m21 += m1.m21;
        this.m22 += m1.m22;
    }

    /**
     * Sets the value of this matrix to the matrix difference of itself and
     * matrix m1 (this = this - m1).
     * @param m1 the other matrix
     */
    public final void sub(Matrix3d m1) {
        this.m00 -= m1.m00;
        this.m01 -= m1.m01;
        this.m02 -= m1.m02;

        this.m10 -= m1.m10;
        this.m11 -= m1.m11;
        this.m12 -= m1.m12;

        this.m20 -= m1.m20;
        this.m21 -= m1.m21;
        this.m22 -= m1.m22;
    }

    /**
     * Sets the value of this matrix to its transpose.
     */
    public final void transpose() {
        double temp;

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
    public final void transpose(Matrix3d m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m10;
        this.m02 = m1.m20;

        this.m10 = m1.m01;
        this.m11 = m1.m11;
        this.m12 = m1.m21;

        this.m20 = m1.m02;
        this.m21 = m1.m12;
        this.m22 = m1.m22;
    }

    /**
     * Sets the value of this matrix to the matrix conversion of the
     * double precision quaternion argument.
     * @param q1 the quaternion to be converted
     */
    public final void set(Quat4d q1) {
        this.m00 = (1.0 - 2.0 * q1.getY() * q1.getY() - 2.0 * q1.getZ() * q1.getZ());
        this.m10 = (2.0 * (q1.getX() * q1.getY() + q1.getW() * q1.getZ()));
        this.m20 = (2.0 * (q1.getX() * q1.getZ() - q1.getW() * q1.getY()));

        this.m01 = (2.0 * (q1.getX() * q1.getY() - q1.getW() * q1.getZ()));
        this.m11 = (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getZ() * q1.getZ());
        this.m21 = (2.0 * (q1.getY() * q1.getZ() + q1.getW() * q1.getX()));

        this.m02 = (2.0 * (q1.getX() * q1.getZ() + q1.getW() * q1.getY()));
        this.m12 = (2.0 * (q1.getY() * q1.getZ() - q1.getW() * q1.getX()));
        this.m22 = (1.0 - 2.0 * q1.getX() * q1.getX() - 2.0 * q1.getY() * q1.getY());
    }

    /**
     * Sets the value of this matrix to the value of the Matrix3d
     * argument.
     * @param m1 the source matrix3d
     */
    public final void set(Matrix3d m1) {
        this.m00 = m1.m00;
        this.m01 = m1.m01;
        this.m02 = m1.m02;

        this.m10 = m1.m10;
        this.m11 = m1.m11;
        this.m12 = m1.m12;

        this.m20 = m1.m20;
        this.m21 = m1.m21;
        this.m22 = m1.m22;
    }

    /**
     *  Sets the values in this Matrix3d equal to the row-major
     *  array parameter (ie, the first three elements of the
     *  array will be copied into the first row of this matrix, etc.).
     *  @param m  the double precision array of length 9
     */
    public final void set(double[] m) {
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
    public final void set(double scale) {
        this.m00 = scale;
        this.m01 = 0.0;
        this.m02 = 0.0;

        this.m10 = 0.0;
        this.m11 = scale;
        this.m12 = 0.0;

        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = scale;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the x axis.
     * @param angle the angle to rotate about the X axis in radians
     */
    public final void setRotX(double angle) {
        double sinAngle;
        double cosAngle;

        sinAngle = Math.sin(angle);
        cosAngle = Math.cos(angle);

        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;

        this.m10 = 0.0;
        this.m11 = cosAngle;
        this.m12 = -sinAngle;

        this.m20 = 0.0;
        this.m21 = sinAngle;
        this.m22 = cosAngle;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the y axis.
     * @param angle the angle to rotate about the Y axis in radians
     */
    public final void setRotY(double angle) {
        double sinAngle;
        double cosAngle;

        sinAngle = Math.sin(angle);
        cosAngle = Math.cos(angle);

        this.m00 = cosAngle;
        this.m01 = 0.0;
        this.m02 = sinAngle;

        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;

        this.m20 = -sinAngle;
        this.m21 = 0.0;
        this.m22 = cosAngle;
    }

    /**
     * Sets the value of this matrix to a counter clockwise rotation
     * about the z axis.
     * @param angle the angle to rotate about the Z axis in radians
     */
    public final void rotZ(double angle) {
        double sinAngle;
        double cosAngle;

        sinAngle = Math.sin(angle);
        cosAngle = Math.cos(angle);

        this.m00 = cosAngle;
        this.m01 = -sinAngle;
        this.m02 = 0.0;

        this.m10 = sinAngle;
        this.m11 = cosAngle;
        this.m12 = 0.0;

        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
    }

    /**
      * Multiplies each element of this matrix by a scalar.
      * @param scalar  The scalar multiplier.
      */
    public final void mul(double scalar) {
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
    public final void mul(Matrix3d m1) {
        double lm00;
        double lm01;
        double lm02;
        double lm10;
        double lm11;
        double lm12;
        double lm20;
        double lm21;
        double lm22;

        lm00 = this.m00 * m1.m00 + this.m01 * m1.m10 + this.m02 * m1.m20;
        lm01 = this.m00 * m1.m01 + this.m01 * m1.m11 + this.m02 * m1.m21;
        lm02 = this.m00 * m1.m02 + this.m01 * m1.m12 + this.m02 * m1.m22;

        lm10 = this.m10 * m1.m00 + this.m11 * m1.m10 + this.m12 * m1.m20;
        lm11 = this.m10 * m1.m01 + this.m11 * m1.m11 + this.m12 * m1.m21;
        lm12 = this.m10 * m1.m02 + this.m11 * m1.m12 + this.m12 * m1.m22;

        lm20 = this.m20 * m1.m00 + this.m21 * m1.m10 + this.m22 * m1.m20;
        lm21 = this.m20 * m1.m01 + this.m21 * m1.m11 + this.m22 * m1.m21;
        lm22 = this.m20 * m1.m02 + this.m21 * m1.m12 + this.m22 * m1.m22;

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
        m00 = 0.0;
        m01 = 0.0;
        m02 = 0.0;

        m10 = 0.0;
        m11 = 0.0;
        m12 = 0.0;

        m20 = 0.0;
        m21 = 0.0;
        m22 = 0.0;

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
     * Invert this matrix
     * @return this if successful, null otherwise
     */
    public Matrix3d invert() {
        return invert(this);
    }

    /**
     * Invert the source matrix and put the result into the destination matrix
     * @param destOrg The destination matrix, or null if a new one is to be created
     * @return The inverted matrix if successful, null otherwise
     */
    public Matrix3d invert(Matrix3d destOrg) {
        double determinant = this.determinant();

        if (determinant != 0) {
            Matrix3d dest = destOrg;
            if (dest == null) {
                dest = new Matrix3d();
            }

            /* do it the ordinary way
             *
             * inv(A) = 1/det(A) * adj(T), where adj(T) = transpose(Conjugate Matrix)
             *
             * m00 m01 m02
             * m10 m11 m12
             * m20 m21 m22
             */
            double determinantInv = 1f / determinant;

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

            dest.m00 = t00 * determinantInv;
            dest.m11 = t11 * determinantInv;
            dest.m22 = t22 * determinantInv;
            dest.m01 = t10 * determinantInv;
            dest.m10 = t01 * determinantInv;
            dest.m20 = t02 * determinantInv;
            dest.m02 = t20 * determinantInv;
            dest.m12 = t21 * determinantInv;
            dest.m21 = t12 * determinantInv;
            return dest;
        } else {
            throw new IllegalStateException("matrix is not invertible");
        }
    }
    
    /**
     * Multiply this matrix by the tuple t and place the result
     * back into the tuple (t = this*t).
     * @param t  the tuple to be multiplied by this matrix and then replaced
     */
    public final void transformed(Vector3d t) {
        double x;
        double y;
        double z;
        x = m00 * t.getX() + m01 * t.getY() + m02 * t.getZ();
        y = m10 * t.getX() + m11 * t.getY() + m12 * t.getZ();
        z = m20 * t.getX() + m21 * t.getY() + m22 * t.getZ();
        t.set(x, y, z);
    }

    /**
     * Multiply this matrix by the tuple t and and place the result
     * into the tuple "result" (result = this*t).
     * @param t  the tuple to be multiplied by this matrix
     * @return the tuple into which the product is placed
     */
    public final Vector3d createTransformed(BaseVector3d t) {
        double x;
        double y;
        x = m00 * t.getX() + m01 * t.getY() + m02 * t.getZ();
        y = m10 * t.getX() + m11 * t.getY() + m12 * t.getZ();
        return new Vector3d(x, y, m20 * t.getX() + m21 * t.getY() + m22 * t.getZ());
    }

    @Override
    public final double getM00() {
        return m00;
    }

    /**
     * Set the first matrix element in the first row.
     *
     * @param m00 The m00 to set.
     */
    public final void setM00(double m00) {
        this.m00 = m00;
    }

    @Override
    public final double getM01() {
        return m01;
    }

    /**
     * Set the second matrix element in the first row.
     *
     * @param m01 The m01 to set.
     */
    public final void setM01(double m01) {
        this.m01 = m01;
    }

    @Override
    public final double getM02() {
        return m02;
    }

    /**
     * Set the third matrix element in the first row.
     *
     * @param m02 The m02 to set.
     */
    public final void setM02(double m02) {
        this.m02 = m02;
    }

    @Override
    public final double getM10() {
        return m10;
    }

    /**
     * Set first matrix element in the second row.
     *
     * @param m10 The m10 to set.
     */
    public final void setM10(double m10) {
        this.m10 = m10;
    }

    @Override
    public final double getM11() {
        return m11;
    }

    /**
     * Set the second matrix element in the second row.
     *
     * @param m11 The m11 to set.
     */
    public final void setM11(double m11) {
        this.m11 = m11;
    }

    @Override
    public final double getM12() {
        return m12;
    }

    /**
     * Set the third matrix element in the second row.
     *
     * @param m12 The m12 to set.
     */
    public final void setM12(double m12) {
        this.m12 = m12;
    }

    @Override
    public final double getM20() {
        return m20;
    }

    /**
     * Set the first matrix element in the third row.
     *
     * @param m20 The m20 to set.
     */
    public final void setM20(double m20) {
        this.m20 = m20;
    }

    @Override
    public final double getM21() {
        return m21;
    }

    /**
     * Set the second matrix element in the third row.
     *
     * @param m21 The m21 to set.
     */
    public final void setM21(double m21) {
        this.m21 = m21;
    }

    @Override
    public final double getM22() {
        return m22;
    }

    /**
     * Set the third matrix element in the third row.
     *
     * @param m22 The m22 to set.
     */
    public final void setM22(double m22) {
        this.m22 = m22;
    }

}
