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

import org.joml.Quaterniond;
import org.joml.Quaternionf;

import java.nio.FloatBuffer;

/**
 * A float precision floating point 4x4 float matrix.
 * @author auto-generated
 */
@Deprecated
public class Matrix4f extends BaseMatrix4f {


    /**
     * Constructs and initializes a Matrix4f from the specified values.
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
    public Matrix4f(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        this._m00(m00);
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
        determineProperties();
    }

    /**
     *  Constructs a new matrix with the same values as the
     *  Matrix3d parameter.
     *  @param m1  the source matrix
     */
    public Matrix4f(BaseMatrix4f m1) {
        this._m00(m1.getM00());
        this._m01(m1.getM01());
        this._m02(m1.getM02());
        this._m03(m1.getM03());
        this._m10(m1.getM10());
        this._m11(m1.getM11());
        this._m12(m1.getM12());
        this._m13(m1.getM13());
        this._m20(m1.getM20());
        this._m21(m1.getM21());
        this._m22(m1.getM22());
        this._m23(m1.getM23());
        this._m30(m1.getM30());
        this._m31(m1.getM31());
        this._m32(m1.getM32());
        this._m33(m1.getM33());

        determineProperties();
    }

    /**
     * Constructs and initializes a Matrix4f from the specified nine-
     * element array.
     * @param v the array of length 16 containing in order
     */
    public Matrix4f(float[] v) {
        this._m00(v[0]);
        this._m01(v[1]);
        this._m02(v[2]);
        this._m03(v[3]);

        this._m10(v[4]);
        this._m11(v[5]);
        this._m12(v[6]);
        this._m13(v[7]);

        this._m20(v[8]);
        this._m21(v[9]);
        this._m22(v[10]);
        this._m23(v[11]);

        this._m30(v[12]);
        this._m31(v[13]);
        this._m32(v[14]);
        this._m33(v[15]);

        determineProperties();
    }

    /**
     * Constructs and initializes a Matrix3d to all zeros.
     */
    public Matrix4f() {
        // no-op

        determineProperties();
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
    public Matrix4f(BaseQuat4f q1, org.joml.Vector3f t1, float s) {
        _m00(s * (1.0f - 2.0f * q1.y() * q1.y() - 2.0f * q1.z() * q1.z()));
        _m10(s * (2.0f * (q1.x() * q1.y() + q1.w() * q1.z())));
        _m20(s * (2.0f * (q1.x() * q1.z() - q1.w() * q1.y())));

        _m01(s * (2.0f * (q1.x() * q1.y() - q1.w() * q1.z())));
        _m11(s * (1.0f - 2.0f * q1.x() * q1.x() - 2.0f * q1.z() * q1.z()));
        _m21(s * (2.0f * (q1.y() * q1.z() + q1.w() * q1.x())));

        _m02(s * (2.0f * (q1.x() * q1.z() + q1.w() * q1.y())));
        _m12(s * (2.0f * (q1.x() * q1.z() - q1.w() * q1.x())));
        _m22(s * (1.0f - 2.0f * q1.x() * q1.x() - 2.0f * q1.y() * q1.y()));

        _m03(t1.x());
        _m13(t1.y());
        _m23(t1.z());

        _m30(0);
        _m31(0);
        _m32(0);
        _m33(1);

    }

    /**
     * Sets this Matrix3d to identity.
     */
    public final void setIdentity() {
        this.identity();
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
                        this._m00(value);
                        break;
                    case 1:
                        this._m01(value);
                        break;
                    case 2:
                        this._m02(value);
                        break;
                    case 3:
                        this._m03(value);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 1:
                switch (column) {
                    case 0:
                        this.m10(value);
                        break;
                    case 1:
                        this.m11(value);
                        break;
                    case 2:
                        this.m12(value);
                        break;
                    case 3:
                        this.m13(value);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 2:
                switch (column) {
                    case 0:
                        this.m20(value);
                        break;
                    case 1:
                        this.m21(value);
                        break;
                    case 2:
                        this.m22(value);
                        break;
                    case 3:
                        this.m23(value);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
                }
                break;

            case 3:
                switch (column) {
                    case 0:
                        this.m30(value);
                        break;
                    case 1:
                        this.m31(value);
                        break;
                    case 2:
                        this.m32(value);
                        break;
                    case 3:
                        this.m33(value);
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
     * Adds a scalar to each component of this matrix.
     * @param scalar  the scalar adder
     */
    public final void add(float scalar) {
        _m00(m00()+scalar);
        _m01(m01()+scalar);
        _m02(m02()+scalar);
        _m03(m03()+scalar);

        _m10(m10()+scalar);
        _m11(m11()+scalar);
        _m12(m12()+scalar);
        _m13(m13()+scalar);

        _m20(m20()+scalar);
        _m21(m21()+scalar);
        _m22(m22()+scalar);
        _m23(m23()+scalar);

        _m30(m30()+scalar);
        _m31(m31()+scalar);
        _m32(m32()+scalar);
        _m33(m33()+scalar);
    }



    /**
     * Sets the value of this matrix to the transpose of the argument matrix.
     * @param m1 the matrix to be transposed
     */
    public final void transpose(BaseMatrix4f m1) {
        this.set(m1);
        this.transpose();
    }


    /**
     * Sets the value of this matrix to the matrix conversion of the
     * float precision quaternion argument.
     * @param q1 the quaternion to be converted
     */
    public final void set(Quaternionf q1) {
        this._m00(1.0f - 2.0f * q1.y() * q1.y() - 2.0f * q1.z() * q1.z());
        this._m10(2.0f * (q1.x() * q1.y() + q1.w() * q1.z()));
        this._m20(2.0f * (q1.x() * q1.z() - q1.w() * q1.y()));

        this._m01(2.0f * (q1.x() * q1.y() - q1.w() * q1.z()));
        this._m11((float) (1.0f - 2.0 * q1.x() * q1.x() - 2.0f * q1.z() * q1.z()));
        this._m21(2.0f * (q1.y() * q1.z() + q1.w() * q1.x()));

        this._m02(2.0f * (q1.x() * q1.z() + q1.w() * q1.y()));
        this._m12(2.0f * (q1.y() * q1.z() - q1.w() * q1.x()));
        this._m22((float) (1.0f - 2.0 * q1.x() * q1.x() - 2.0f * q1.y() * q1.y()));

        this._m03(0);
        this._m13(0);
        this._m23(0);

        this._m30(0);
        this._m31(0);
        this._m32(0);
        this._m33(1);
    }


    /**
     * Sets the value of this matrix to a scale matrix with
     * the passed scale amount.
     * @param scale the scale factor for the matrix
     */
    public final void set(float scale) {
        this.zero();
        this._m00(scale);
        this._m11(scale);
        this._m22(scale);
        this._m33(scale);
    }

    /**
      * Multiplies each element of this matrix by a scalar.
      * @param scalar  The scalar multiplier.
      */
    public final void mul(float scalar) {
        _m00(m00()*scalar);
        _m01(m01()*scalar);
        _m02(m02()*scalar);
        _m03(m03()*scalar);

        _m10(m10()*scalar);
        _m11(m11()*scalar);
        _m12(m12()*scalar);
        _m13(m13()*scalar);

        _m20(m20()*scalar);
        _m21(m21()*scalar);
        _m22(m22()*scalar);
        _m23(m23()*scalar);

        _m30(m30()*scalar);
        _m31(m31()*scalar);
        _m32(m32()*scalar);
        _m33(m33()*scalar);
    }

    /**
     * Sets the value of this matrix to the result of multiplying
     * the two argument matrices together.
     * @param m1 the first matrix
     * @param m2 the second matrix
     */
    public final void mul(BaseMatrix4f m1, BaseMatrix4f m2) {
        set(m1);
        mul(m2);
    }



    /**
     * Sets this matrix to all zeros.
     */
    public final void setZero() {
        zero();
    }

    /**
     * Negates the value of this matrix: this = -this.
     */
    public final void negate() {
        this._m00(-this.m00());
        this._m01(-this.m01());
        this._m02(-this.m02());
        this._m03(-this.m03());

        this._m10(-this.m10());
        this._m11(-this.m11());
        this._m12(-this.m12());
        this._m13(-this.m13());

        this._m20(-this.m20());
        this._m21(-this.m21());
        this._m22(-this.m22());
        this._m23(-this.m23());

        this._m30(-this.m30());
        this._m31(-this.m31());
        this._m32(-this.m32());
        this._m33(-this.m33());
    }

    /**
     * Multiply this matrix by the tuple t and place the result
     * back into the tuple (t = this*t).
     * @param vec the tuple to be multiplied by this matrix and then replaced
     */
    public final void transform(Vector4f vec) {


        float x = (m00() * vec.x() + m01() * vec.y()
                + m02() * vec.z() + m03() * vec.w());
        float y = (m10() * vec.x() + m11() * vec.y()
                + m12() * vec.z() + m13() * vec.w());
        float z = (m20() * vec.x() + m21() * vec.y()
                + m22() * vec.z() + m23() * vec.w());
        float w = (m30() * vec.x() + m31() * vec.y()
                + m32() * vec.z() + m33() * vec.w());

        vec.set(x, y, z, w);
    }

  /**
   * Transforms the point parameter with this Matrix4f and
   * places the result back into point.  The fourth element of the
   * point input paramter is assumed to be one.
   * @param point  the input point to be transformed.
   */
    public final void transformPoint(Vector3f point) {
        float x;
        float y;

        x = m00() * point.x() + m01() * point.y() + m02() * point.z() + m03();
        y = m10() * point.x() + m11() * point.y() + m12() * point.z() + m13();
        point.z = (m20() * point.x() + m21() * point.y() + m22() * point.z() + m23());
        point.x = (x);
        point.y = (y);
    }

  /**
   * Transforms the normal parameter by this transform and places the value
   * back into normal.  The fourth element of the normal is assumed to be zero.
   * @param normal   the input normal to be transformed.
   */
    public final void transformVector(Vector3f normal) {
        float x;
        float y;

        x = m00() * normal.x() + m01() * normal.y() + m02() * normal.z();
        y = m10() * normal.x() + m11() * normal.y() + m12() * normal.z();
        normal.z = (m20() * normal.x() + m21() * normal.y() + m22() * normal.z());
        normal.x = x;
        normal.y = y;
    }


    /**
     * Sets the value of this matrix to the matrix inverse
     * of the passed (user declared) matrix m1.
     * @param m1 the matrix to be inverted
     */
    public final void invert(Matrix4f m1) {
        set(m1);
        invert();
    }

    /**
    * takes the contents of the matrix and appends the results to a buffer
    * @param fb to append results to
    */
    public void appendToBuffer(FloatBuffer fb){
        get(fb);
    }

    @Override
    public final float getM00() {
        return m00();
    }

    @Override
    public final float getM01() {
        return m01();
    }

    @Override
    public final float getM02() {
        return m02();
    }

    @Override
    public final float getM03() {
        return m03();
    }

    @Override
    public final float getM10() {
        return m10();
    }

    @Override
    public final float getM11() {
        return m11();
    }

    @Override
    public final float getM12() {
        return m12();
    }

    @Override
    public final float getM13() {
        return m13();
    }

    @Override
    public final float getM20() {
        return m20();
    }

    @Override
    public final float getM21() {
        return m21();
    }

    @Override
    public final float getM22() {
        return m22();
    }

    @Override
    public final float getM23() {
        return m23();
    }

    @Override
    public final float getM30() {
        return m30();
    }

    @Override
    public final float getM31() {
        return m31();
    }

    @Override
    public final float getM32() {
        return m32();
    }

    @Override
    public final float getM33() {
        return m33();
    }


    /**
     * Entry at row 0, column 0
     *
     * @param m00 the value for row 0, column 0
     */
    public final void setM00(float m00) {
        this._m00(m00);
    }

    /**
     * Entry at row 0, column 1
     *
     * @param m01 the value for row 0, column 1
     */
    public final void setM01(float m01) {
        this._m01(m01);
    }

    /**
     * Entry at row 0, column 2
     *
     * @param m02 the value for row 0, column 2
     */
    public final void setM02(float m02) {
        this._m02(m02);
    }

    /**
     * Entry at row 0, column 3
     *
     * @param m03 the value for row 0, column 3
     */
    public final void setM03(float m03) {
        this._m03(m03);
    }

    /**
     * Entry at row 1, column 0
     *
     * @param m10 the value for row 1, column 0
     */
    public final void setM10(float m10) {
        this._m10(m10);
    }

    /**
     * Entry at row 1, column 1
     *
     * @param m11 the value for row 1, column 1
     */
    public final void setM11(float m11) {
        this._m11(m11);
    }

    /**
     * Entry at row 1, column 2
     *
     * @param m12 the value for row 1, column 2
     */
    public final void setM12(float m12) {
        this._m12(m12);
    }

    /**
     * Entry at row 1, column 3
     *
     * @param m13 the value for row 1, column 3
     */
    public final void setM13(float m13) {
        this._m13(m13);
    }

    /**
     * Entry at row 2, column 0
     *
     * @param m20 the value for row 2, column 0
     */
    public final void setM20(float m20) {
        this._m20(m20);
    }

    /**
     * Entry at row 2, column 1
     *
     * @param m21 the value for row 2, column 1
     */
    public final void setM21(float m21) {
        this._m21(m21);
    }

    /**
     * Entry at row 2, column 2
     *
     * @param m22 the value for row 2, column 2
     */
    public final void setM22(float m22) {
        this._m22(m22);
    }

    /**
     * Entry at row 2, column 3
     *
     * @param m23 the value for row 2, column 3
     */
    public final void setM23(float m23) {
        this._m23(m23);
    }

    /**
     * Entry at row 3, column 0
     *
     * @param m30 the value for row 3, column 0
     */
    public final void setM30(float m30) {
        this._m30(m30);
    }

    /**
     * Entry at row 3, column 1
     *
     * @param m31 the value for row 3, column 1
     */
    public final void setM31(float m31) {
        this._m31(m31);
    }

    /**
     * Entry at row 3, column 2
     *
     * @param m32 the value for row 3, column 2
     */
    public final void setM32(float m32) {
        this._m32(m32);
    }

    /**
     * Entry at row 3, column 3
     *
     * @param m33 the value for row 3, column 3
     */
    public final void setM33(float m33) {
        this._m33(m33);
    }


}
