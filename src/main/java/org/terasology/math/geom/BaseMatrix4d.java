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

import org.joml.AxisAngle4d;
import org.joml.AxisAngle4f;
import org.joml.Matrix3d;
import org.joml.Matrix3x2dc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3d;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.Planed;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2dc;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4dc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.util.Locale;

/**
 * Defines a 4x4 double matrix 
 */
public abstract class BaseMatrix4d  implements Matrix4dc {

    /**
     * The immutable identity matrix
     */
    public static final ImmutableMatrix4d IDENTITY = new ImmutableMatrix4d(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

    /**
     * @return the matrix element at row 0, column 0
     */
    public double getM00() {
        return get(0, 0);
    }

    /**
     * @return the matrix element at row 0, column 1
     */
    public double getM01() {
        return get(0, 1);
    }

    /**
     * @return the matrix element at row 0, column 2
     */
    public double getM02() {
        return get(0, 2);
    }

    /**
     * @return the matrix element at row 0, column 3
     */
    public double getM03() {
        return get(0, 3);
    }

    /**
     * @return the matrix element at row 1, column 0
     */
    public double getM10() {
        return get(1, 0);
    }

    /**
     * @return the matrix element at row 1, column 1
     */
    public double getM11() {
        return get(1, 1);
    }

    /**
     * @return the matrix element at row 1, column 2
     */
    public double getM12() {
        return get(1, 2);
    }

    /**
     * @return the matrix element at row 1, column 3
     */
    public double getM13() {
        return get(1, 3);
    }

    /**
     * @return the matrix element at row 2, column 0
     */
    public double getM20() {
        return get(2, 0);
    }

    /**
     * @return the matrix element at row 2, column 1
     */
    public double getM21() {
        return get(2, 1);
    }

    /**
     * @return the matrix element at row 2, column 2
     */
    public double getM22() {
        return get(2, 2);
    }

    /**
     * @return the matrix element at row 2, column 3
     */
    public double getM23() {
        return get(2, 3);
    }

    /**
     * @return the matrix element at row 3, column 0
     */
    public double getM30() {
        return get(3, 0);
    }

    /**
     * @return the matrix element at row 3, column 1
     */
    public double getM31() {
        return get(3, 1);
    }

    /**
     * @return the matrix element at row 3, column 2
     */
    public double getM32() {
        return get(3, 2);
    }

    /**
     * @return the matrix element at row 3, column 3
     */
    public double getM33() {
        return get(3, 3);
    }


    /**
     * Returns a hash code value based on the data values in this
     * object.  Two different Matrix3d objects with identical data values
     * (i.e., Matrix3d.equals returns true) will return the same hash
     * code value.  Two objects with different data members may return the
     * same hash value, although this is not likely.
     *
     * @return the integer hash code value
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(getM00());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM01());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM02());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM03());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM10());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM11());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM12());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM13());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM20());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM21());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM22());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM23());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM30());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM31());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM32());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM33());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    /**
     * This version correctly deals with NaN and signed zero values
     *
     * @param obj the object to compare with
     * @return true if equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (obj instanceof BaseMatrix4d) {
            BaseMatrix4d other = (BaseMatrix4d) obj;
            return equals(other);
        }

        return false;
    }

    /**
     * Returns true if all of the data members of Matrix3d m1 are
     * equal to the corresponding data members in this Matrix3d.
     * VecMath also uses explicit checks for -0 == 0
     *
     * @param other the matrix with which the comparison is made
     * @return true or false
     */
    public final boolean equals(BaseMatrix4d other) {
        return
                Double.doubleToLongBits(getM00()) == Double.doubleToLongBits(other.getM00())
                        && Double.doubleToLongBits(getM01()) == Double.doubleToLongBits(other.getM01())
                        && Double.doubleToLongBits(getM02()) == Double.doubleToLongBits(other.getM02())
                        && Double.doubleToLongBits(getM03()) == Double.doubleToLongBits(other.getM03())
                        && Double.doubleToLongBits(getM10()) == Double.doubleToLongBits(other.getM10())
                        && Double.doubleToLongBits(getM11()) == Double.doubleToLongBits(other.getM11())
                        && Double.doubleToLongBits(getM12()) == Double.doubleToLongBits(other.getM12())
                        && Double.doubleToLongBits(getM13()) == Double.doubleToLongBits(other.getM13())
                        && Double.doubleToLongBits(getM20()) == Double.doubleToLongBits(other.getM20())
                        && Double.doubleToLongBits(getM21()) == Double.doubleToLongBits(other.getM21())
                        && Double.doubleToLongBits(getM22()) == Double.doubleToLongBits(other.getM22())
                        && Double.doubleToLongBits(getM23()) == Double.doubleToLongBits(other.getM23())
                        && Double.doubleToLongBits(getM30()) == Double.doubleToLongBits(other.getM30())
                        && Double.doubleToLongBits(getM31()) == Double.doubleToLongBits(other.getM31())
                        && Double.doubleToLongBits(getM32()) == Double.doubleToLongBits(other.getM32())
                        && Double.doubleToLongBits(getM33()) == Double.doubleToLongBits(other.getM33());
    }

    /**
     * Returns true if the L-infinite distance between this matrix
     * and matrix m1 is less than or equal to the epsilon parameter,
     * otherwise returns false.  The L-infinite
     * distance is equal to
     * MAX[i=0,1,2 ; j=0,1,2 ; abs(this.m(i,j) - m1.m(i,j)]
     *
     * @param m1      the matrix to be compared to this matrix
     * @param epsilon the threshold value
     * @return true if equals up to epsilon
     */
    public final boolean epsilonEquals(BaseMatrix4d m1, double epsilon) {
        double diff;

        diff = getM00() - m1.getM00();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM01() - m1.getM01();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM02() - m1.getM02();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM03() - m1.getM03();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM10() - m1.getM10();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM11() - m1.getM11();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM12() - m1.getM12();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM13() - m1.getM13();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM20() - m1.getM20();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM21() - m1.getM21();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM22() - m1.getM22();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM23() - m1.getM23();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM30() - m1.getM30();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM31() - m1.getM31();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM32() - m1.getM32();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM33() - m1.getM33();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        return true;
    }

    @Override
    public int properties() {
        return new org.joml.Matrix4d(this).determineProperties().properties();
    }

    @Override
    public double m00() {
        return getM00();
    }

    @Override
    public double m01() {
        return getM01();
    }

    @Override
    public double m02() {
        return getM02();
    }

    @Override
    public double m03() {
        return getM03();
    }

    @Override
    public double m10() {
        return getM10();
    }

    @Override
    public double m11() {
        return getM11();
    }

    @Override
    public double m12() {
        return getM12();
    }

    @Override
    public double m13() {
        return getM13();
    }

    @Override
    public double m20() {
        return getM20();
    }

    @Override
    public double m21() {
        return getM21();
    }

    @Override
    public double m22() {
        return getM22();
    }

    @Override
    public double m23() {
        return getM23();
    }

    @Override
    public double m30() {
        return getM30();
    }

    @Override
    public double m31() {
        return getM31();
    }

    @Override
    public double m32() {
        return getM32();
    }

    @Override
    public double m33() {
        return getM33();
    }

    @Override
    public Matrix4d mul(Matrix4dc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mulLocal(Matrix4dc left, Matrix4d dest) {
        return new Matrix4d(this).mulLocal(left, dest);
    }

    @Override
    public Matrix4d mulLocalAffine(Matrix4dc left, Matrix4d dest) {
        return new Matrix4d(this).mulLocalAffine(left, dest);
    }

    @Override
    public Matrix4d mul(Matrix3x2dc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mul(Matrix3x2fc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mul(Matrix4x3dc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mul(Matrix4x3fc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mul(Matrix4fc right, Matrix4d dest) {
        return new Matrix4d(this).mul(right, dest);
    }

    @Override
    public Matrix4d mulPerspectiveAffine(Matrix4dc view, Matrix4d dest) {
        return new Matrix4d(this).mulPerspectiveAffine(view, dest);
    }

    @Override
    public Matrix4d mulAffineR(Matrix4dc right, Matrix4d dest) {
        return new Matrix4d(this).mulAffineR(right, dest);
    }

    @Override
    public Matrix4d mulAffine(Matrix4dc right, Matrix4d dest) {
        return new Matrix4d(this).mulAffine(right, dest);
    }

    @Override
    public Matrix4d mulTranslationAffine(Matrix4dc right, Matrix4d dest) {
        return new Matrix4d(this).mulTranslationAffine(right, dest);
    }

    @Override
    public Matrix4d mulOrthoAffine(Matrix4dc view, Matrix4d dest) {
        return new Matrix4d(this).mulOrthoAffine(view, dest);
    }

    @Override
    public Matrix4d fma4x3(Matrix4dc other, double otherFactor, Matrix4d dest) {
        return new Matrix4d(this).fma4x3(other, otherFactor, dest);
    }

    @Override
    public Matrix4d add(Matrix4dc other, Matrix4d dest) {
        return new Matrix4d(this).add(other, dest);
    }

    @Override
    public Matrix4d sub(Matrix4dc subtrahend, Matrix4d dest) {
        return new Matrix4d(this).sub(subtrahend, dest);
    }

    @Override
    public Matrix4d mulComponentWise(Matrix4dc other, Matrix4d dest) {
        return new Matrix4d(this).mulComponentWise(other, dest);
    }

    @Override
    public Matrix4d add4x3(Matrix4dc other, Matrix4d dest) {
        return new Matrix4d(this).add4x3(other, dest);
    }

    @Override
    public Matrix4d add4x3(Matrix4fc other, Matrix4d dest) {
        return new Matrix4d(this).add4x3(other, dest);
    }

    @Override
    public Matrix4d sub4x3(Matrix4dc subtrahend, Matrix4d dest) {
        return new Matrix4d(this).sub4x3(subtrahend, dest);
    }

    @Override
    public Matrix4d mul4x3ComponentWise(Matrix4dc other, Matrix4d dest) {
        return new Matrix4d(this).mul4x3ComponentWise(other, dest);
    }

    /**
     * Computes the determinant of this matrix.
     *
     * @return the determinant of the matrix
     */
    public final double determinant() {
        double det;

        det = getM00() * (getM11() * getM22() * getM33() + getM12() * getM23() * getM31() + getM13() * getM21() * getM32()
                - getM13() * getM22() * getM31() - getM11() * getM23() * getM32() - getM12() * getM21() * getM33());
        det -= getM01() * (getM10() * getM22() * getM33() + getM12() * getM23() * getM30() + getM13() * getM20() * getM32()
                - getM13() * getM22() * getM30() - getM10() * getM23() * getM32() - getM12() * getM20() * getM33());
        det += getM02() * (getM10() * getM21() * getM33() + getM11() * getM23() * getM30() + getM13() * getM20() * getM31()
                - getM13() * getM21() * getM30() - getM10() * getM23() * getM31() - getM11() * getM20() * getM33());
        det -= getM03() * (getM10() * getM21() * getM32() + getM11() * getM22() * getM30() + getM12() * getM20() * getM31()
                - getM12() * getM21() * getM30() - getM10() * getM22() * getM31() - getM11() * getM20() * getM32());

        return det;
    }

    @Override
    public double determinant3x3() {
        return this.determinant();
    }

    @Override
    public double determinantAffine() {
        return new Matrix4d(this).determinantAffine();
    }

    @Override
    public Matrix4d invert(Matrix4d dest) {
        return new Matrix4d(this).invert(dest);
    }

    @Override
    public Matrix4d invertPerspective(Matrix4d dest) {
        return new Matrix4d(this).invertPerspective(dest);
    }

    @Override
    public Matrix4d invertFrustum(Matrix4d dest) {
        return new Matrix4d(this).invertFrustum(dest);
    }

    @Override
    public Matrix4d invertOrtho(Matrix4d dest) {
        return new Matrix4d(this).invertOrtho(dest);
    }

    @Override
    public Matrix4d invertPerspectiveView(Matrix4dc view, Matrix4d dest) {
        return new Matrix4d(this).invertPerspectiveView(view, dest);
    }

    @Override
    public Matrix4d invertPerspectiveView(Matrix4x3dc view, Matrix4d dest) {
        return new Matrix4d(this).invertPerspectiveView(view, dest);
    }

    @Override
    public Matrix4d invertAffine(Matrix4d dest) {
        return new Matrix4d(this).invertAffine(dest);
    }

    @Override
    public Matrix4d transpose(Matrix4d dest) {
        return new Matrix4d(this).transpose(dest);
    }

    @Override
    public Matrix4d transpose3x3(Matrix4d dest) {
        return new Matrix4d(this).transpose3x3(dest);
    }

    @Override
    public Matrix3d transpose3x3(Matrix3d dest) {
        return new Matrix4d(this).transpose3x3(dest);
    }

    @Override
    public org.joml.Vector3d getTranslation(org.joml.Vector3d dest) {
        return new Matrix4d(this).getTranslation(dest);
    }

    @Override
    public org.joml.Vector3d getScale(org.joml.Vector3d dest) {
        return new Matrix4d(this).getScale(dest);
    }

    @Override
    public Matrix4d get(Matrix4d dest) {
        return new Matrix4d(this).get(dest);
    }

    @Override
    public Matrix4x3d get4x3(Matrix4x3d dest) {
        return new Matrix4d(this).get4x3(dest);
    }

    @Override
    public Matrix3d get3x3(Matrix3d dest) {
        return new Matrix4d(this).get3x3(dest);
    }

    @Override
    public Quaternionf getUnnormalizedRotation(Quaternionf dest) {
        return new Matrix4d(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaternionf getNormalizedRotation(Quaternionf dest) {
        return new Matrix4d(this).getNormalizedRotation(dest);
    }

    @Override
    public Quaterniond getUnnormalizedRotation(Quaterniond dest) {
        return new Matrix4d(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaterniond getNormalizedRotation(Quaterniond dest) {
        return new Matrix4d(this).getNormalizedRotation(dest);
    }

    @Override
    public DoubleBuffer get(DoubleBuffer buffer) {
        return new Matrix4d(this).get(buffer);
    }

    @Override
    public DoubleBuffer get(int index, DoubleBuffer buffer) {
        return new Matrix4d(this).get(index, buffer);
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return new Matrix4d(this).get(buffer);
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return new Matrix4d(this).get(index, buffer);
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new Matrix4d(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new Matrix4d(this).get(index, buffer);
    }

    @Override
    public Matrix4dc getToAddress(long address) {
        return new Matrix4d(this).getToAddress(address);
    }

    @Override
    public ByteBuffer getFloats(ByteBuffer buffer) {
        return new Matrix4d(this).getFloats(buffer);
    }

    @Override
    public ByteBuffer getFloats(int index, ByteBuffer buffer) {
        return new Matrix4d(this).getFloats(index, buffer);
    }

    @Override
    public double[] get(double[] arr, int offset) {
        return new Matrix4d(this).get(arr, offset);
    }

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     *
     * @param row    the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public abstract double get(int row, int column);


    /**
     * Retrieves the translational components of this matrix.
     *
     * @return a new vector that will receive the translational component
     */
    public final Vector3d getTranslation() {
        Vector3d trans = new Vector3d(getM03(), getM13(), getM23());
        return trans;
    }

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     *
     * @param row the matrix row
     * @return the vector into that contains the matrix row values
     */
    public final Vector4d getRow(int row) {
        if (row == 0) {
            return new Vector4d(getM00(), getM01(), getM02(), getM03());
        } else if (row == 1) {
            return new Vector4d(getM10(), getM11(), getM12(), getM13());
        } else if (row == 2) {
            return new Vector4d(getM20(), getM21(), getM22(), getM23());
        } else if (row == 3) {
            return new Vector4d(getM30(), getM31(), getM32(), getM33());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Copies the matrix values in the specified row into the array parameter.
     *
     * @param row the matrix row
     * @param v   the array into which the matrix row values will be copied
     */
    public final void getRow(int row, double[] v) {
        if (row == 0) {
            v[0] = getM00();
            v[1] = getM01();
            v[2] = getM02();
            v[3] = getM03();
        } else if (row == 1) {
            v[0] = getM10();
            v[1] = getM11();
            v[2] = getM12();
            v[3] = getM13();
        } else if (row == 2) {
            v[0] = getM20();
            v[1] = getM21();
            v[2] = getM22();
            v[3] = getM23();
        } else if (row == 3) {
            v[0] = getM30();
            v[1] = getM31();
            v[2] = getM32();
            v[3] = getM33();
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the vector
     * parameter.
     *
     * @param column the matrix column
     * @return the vector that contains the matrix row values
     */
    public final Vector4d getColumn(int column) {
        if (column == 0) {
            return new Vector4d(getM00(), getM10(), getM20(), getM30());
        } else if (column == 1) {
            return new Vector4d(getM01(), getM11(), getM21(), getM31());
        } else if (column == 2) {
            return new Vector4d(getM02(), getM12(), getM22(), getM32());
        } else if (column == 3) {
            return new Vector4d(getM03(), getM13(), getM23(), getM33());
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the array
     * parameter.
     *
     * @param column the matrix column
     * @param v      the array into which the matrix row values will be copied
     */
    public final void getColumn(int column, double[] v) {
        if (column == 0) {
            v[0] = getM00();
            v[1] = getM10();
            v[2] = getM20();
            v[3] = getM30();
        } else if (column == 1) {
            v[0] = getM01();
            v[1] = getM11();
            v[2] = getM21();
            v[3] = getM31();
        } else if (column == 2) {
            v[0] = getM02();
            v[1] = getM12();
            v[2] = getM22();
            v[3] = getM32();
        } else if (column == 3) {
            v[0] = getM03();
            v[1] = getM13();
            v[2] = getM23();
            v[3] = getM33();
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }

    }

    /**
     * Copies the matrix values into the array parameter.
     *
     * @param v the array into which the matrix values will be copied
     */
    public final double[] get(double[] v) {
        v[0] = getM00();
        v[1] = getM01();
        v[2] = getM02();
        v[3] = getM03();
        v[4] = getM10();
        v[5] = getM11();
        v[6] = getM12();
        v[7] = getM13();
        v[8] = getM20();
        v[9] = getM21();
        v[10] = getM22();
        v[11] = getM23();
        v[12] = getM30();
        v[13] = getM31();
        v[14] = getM32();
        v[15] = getM33();
        return v;
    }

    @Override
    public float[] get(float[] arr, int offset) {
        return new Matrix4d(this).get(arr, offset);
    }

    @Override
    public float[] get(float[] arr) {
        return new Matrix4d(this).get(arr);
    }

    @Override
    public DoubleBuffer getTransposed(DoubleBuffer buffer) {
        return new Matrix4d(this).getTransposed(buffer);
    }

    @Override
    public DoubleBuffer getTransposed(int index, DoubleBuffer buffer) {
        return new Matrix4d(this).getTransposed(index, buffer);
    }

    @Override
    public ByteBuffer getTransposed(ByteBuffer buffer) {
        return new Matrix4d(this).getTransposed(buffer);
    }

    @Override
    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        return new Matrix4d(this).getTransposed(index, buffer);
    }

    @Override
    public DoubleBuffer get4x3Transposed(DoubleBuffer buffer) {
        return new Matrix4d(this).get4x3Transposed(buffer);
    }

    @Override
    public DoubleBuffer get4x3Transposed(int index, DoubleBuffer buffer) {
        return new Matrix4d(this).get4x3Transposed(index, buffer);
    }

    @Override
    public ByteBuffer get4x3Transposed(ByteBuffer buffer) {
        return new Matrix4d(this).get4x3Transposed(buffer);
    }

    @Override
    public ByteBuffer get4x3Transposed(int index, ByteBuffer buffer) {
        return new Matrix4d(this).get4x3Transposed(index, buffer);
    }

    @Override
    public org.joml.Vector4d transform(org.joml.Vector4d v) {
        return new Matrix4d(this).transform(v);
    }

    @Override
    public org.joml.Vector4d transform(Vector4dc v, org.joml.Vector4d dest) {
        return new Matrix4d(this).transform(v, dest);
    }

    @Override
    public org.joml.Vector4d transform(double x, double y, double z, double w, org.joml.Vector4d dest) {
        return new Matrix4d(this).transform(x, y, z, w, dest);
    }

    @Override
    public org.joml.Vector4d transformProject(org.joml.Vector4d v) {
        return new Matrix4d(this).transformProject(v);
    }

    @Override
    public org.joml.Vector4d transformProject(Vector4dc v, org.joml.Vector4d dest) {
        return new Matrix4d(this).transformProject(v, dest);
    }

    @Override
    public org.joml.Vector4d transformProject(double x, double y, double z, double w, org.joml.Vector4d dest) {
        return new Matrix4d(this).transformProject(x, y, z, w, dest);
    }

    @Override
    public org.joml.Vector3d transformProject(org.joml.Vector3d v) {
        return new Matrix4d(this).transformProject(v);
    }


    @Override
    public org.joml.Vector3d transformProject(Vector3dc v, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformProject(v, dest);
    }

    @Override
    public org.joml.Vector3d transformProject(double x, double y, double z, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformProject(x, y, z, dest);
    }

    @Override
    public org.joml.Vector3d transformPosition(org.joml.Vector3d v) {
        return new Matrix4d(this).transformPosition(v);
    }


    @Override
    public org.joml.Vector3d transformPosition(Vector3dc v, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformPosition(v, dest);
    }

    @Override
    public org.joml.Vector3d transformPosition(double x, double y, double z, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformPosition(x, y, z, dest);
    }

    @Override
    public org.joml.Vector3d transformDirection(org.joml.Vector3d v) {
        return new Matrix4d(this).transformDirection(v);
    }

    @Override
    public org.joml.Vector3d transformDirection(Vector3dc v, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformDirection(v, dest);
    }

    @Override
    public Vector3f transformDirection(Vector3f v) {
        return new Matrix4d(this).transformDirection(v);
    }

    @Override
    public Vector3f transformDirection(Vector3fc v, Vector3f dest) {
        return new Matrix4d(this).transformDirection(v, dest);
    }

    @Override
    public org.joml.Vector3d transformDirection(double x, double y, double z, org.joml.Vector3d dest) {
        return new Matrix4d(this).transformDirection(x, y, z, dest);
    }

    @Override
    public org.joml.Vector4d transformAffine(org.joml.Vector4d v) {
        return new Matrix4d(this).transformAffine(v);
    }

    @Override
    public org.joml.Vector4d transformAffine(Vector4dc v, org.joml.Vector4d dest) {
        return new Matrix4d(this).transformAffine(v, dest);
    }

    @Override
    public org.joml.Vector4d transformAffine(double x, double y, double z, double w, org.joml.Vector4d dest) {
        return new Matrix4d(this).transformAffine(x, y, z, w, dest);
    }

    @Override
    public Matrix4d scale(Vector3dc xyz, Matrix4d dest) {
        return new Matrix4d(this).scale(xyz, dest);
    }

    @Override
    public Matrix4d scale(double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).scale(x, y, z, dest);
    }

    @Override
    public Matrix4d scale(double xyz, Matrix4d dest) {
        return new Matrix4d(this).scale(xyz, dest);
    }

    @Override
    public Matrix4d scaleAround(double sx, double sy, double sz, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).scaleAround(sx, sy, sz, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d scaleAround(double factor, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).scaleAround(factor, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d scaleLocal(double xyz, Matrix4d dest) {
        return new Matrix4d(this).scaleLocal(xyz, dest);
    }

    @Override
    public Matrix4d scaleLocal(double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).scaleLocal(x, y, z, dest);
    }

    @Override
    public Matrix4d scaleAroundLocal(double sx, double sy, double sz, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).scaleAroundLocal(sx, sy, sz, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d scaleAroundLocal(double factor, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).scaleAroundLocal(factor, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d rotate(double ang, double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).rotate(ang, x, y, z, dest);
    }

    @Override
    public Matrix4d rotateTranslation(double ang, double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).rotateTranslation(ang, x, y, z, dest);
    }

    @Override
    public Matrix4d rotateAffine(double ang, double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).rotateAffine(ang, x, y, z, dest);
    }

    @Override
    public Matrix4d rotateAround(Quaterniondc quat, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).rotateAround(quat, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d rotateLocal(double ang, double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).rotateLocal(ang, x, y, z, dest);
    }

    @Override
    public Matrix4d rotateLocalX(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateLocalX(ang, dest);
    }

    @Override
    public Matrix4d rotateLocalY(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateLocalY(ang, dest);
    }

    @Override
    public Matrix4d rotateLocalZ(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateLocalZ(ang, dest);
    }

    @Override
    public Matrix4d rotateAroundLocal(Quaterniondc quat, double ox, double oy, double oz, Matrix4d dest) {
        return new Matrix4d(this).rotateAroundLocal(quat, ox, oy, oz, dest);
    }

    @Override
    public Matrix4d translate(Vector3dc offset, Matrix4d dest) {
        return new Matrix4d(this).translate(offset, dest);
    }

    @Override
    public Matrix4d translate(Vector3fc offset, Matrix4d dest) {
        return new Matrix4d(this).translate(offset, dest);
    }

    @Override
    public Matrix4d translate(double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).translate(x, y, z, dest);
    }

    @Override
    public Matrix4d translateLocal(Vector3fc offset, Matrix4d dest) {
        return new Matrix4d(this).translateLocal(offset, dest);
    }

    @Override
    public Matrix4d translateLocal(Vector3dc offset, Matrix4d dest) {
        return new Matrix4d(this).translateLocal(offset, dest);
    }

    @Override
    public Matrix4d translateLocal(double x, double y, double z, Matrix4d dest) {
        return new Matrix4d(this).translateLocal(x, y, z, dest);
    }

    @Override
    public Matrix4d rotateX(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateX(ang, dest);
    }

    @Override
    public Matrix4d rotateY(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateY(ang, dest);
    }

    @Override
    public Matrix4d rotateZ(double ang, Matrix4d dest) {
        return new Matrix4d(this).rotateZ(ang, dest);
    }

    @Override
    public Matrix4d rotateTowardsXY(double dirX, double dirY, Matrix4d dest) {
        return new Matrix4d(this).rotateTowardsXY(dirX, dirY, dest);
    }

    @Override
    public Matrix4d rotateXYZ(double angleX, double angleY, double angleZ, Matrix4d dest) {
        return new Matrix4d(this).rotateXYZ(angleX, angleY, angleZ, dest);
    }

    @Override
    public Matrix4d rotateAffineXYZ(double angleX, double angleY, double angleZ, Matrix4d dest) {
        return new Matrix4d(this).rotateAffineXYZ(angleX, angleY, angleZ, dest);
    }

    @Override
    public Matrix4d rotateZYX(double angleZ, double angleY, double angleX, Matrix4d dest) {
        return new Matrix4d(this).rotateZYX(angleZ, angleY, angleX, dest);
    }

    @Override
    public Matrix4d rotateAffineZYX(double angleZ, double angleY, double angleX, Matrix4d dest) {
        return new Matrix4d(this).rotateAffineZYX(angleZ, angleY, angleX, dest);
    }

    @Override
    public Matrix4d rotateYXZ(double angleY, double angleX, double angleZ, Matrix4d dest) {
        return new Matrix4d(this).rotateYXZ(angleY, angleX, angleZ, dest);
    }

    @Override
    public Matrix4d rotateAffineYXZ(double angleY, double angleX, double angleZ, Matrix4d dest) {
        return new Matrix4d(this).rotateAffineYXZ(angleY, angleX, angleZ, dest);
    }

    @Override
    public Matrix4d rotate(Quaterniondc quat, Matrix4d dest) {
        return new Matrix4d(this).rotate(quat, dest);
    }

    @Override
    public Matrix4d rotate(Quaternionfc quat, Matrix4d dest) {
        return new Matrix4d(this).rotate(quat, dest);
    }

    @Override
    public Matrix4d rotateAffine(Quaterniondc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateAffine(quat, dest);
    }

    @Override
    public Matrix4d rotateTranslation(Quaterniondc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateTranslation(quat, dest);
    }

    @Override
    public Matrix4d rotateTranslation(Quaternionfc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateTranslation(quat, dest);
    }

    @Override
    public Matrix4d rotateLocal(Quaterniondc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateLocal(quat, dest);
    }

    @Override
    public Matrix4d rotateAffine(Quaternionfc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateAffine(quat, dest);
    }

    @Override
    public Matrix4d rotateLocal(Quaternionfc quat, Matrix4d dest) {
        return new Matrix4d(this).rotateLocal(quat, dest);
    }

    @Override
    public Matrix4d rotate(AxisAngle4f axisAngle, Matrix4d dest) {
        return new Matrix4d(this).rotate(axisAngle, dest);
    }

    @Override
    public Matrix4d rotate(AxisAngle4d axisAngle, Matrix4d dest) {
        return new Matrix4d(this).rotate(axisAngle, dest);
    }

    @Override
    public Matrix4d rotate(double angle, Vector3dc axis, Matrix4d dest) {
        return new Matrix4d(this).rotate(angle, axis, dest);
    }

    @Override
    public Matrix4d rotate(double angle, Vector3fc axis, Matrix4d dest) {
        return new Matrix4d(this).rotate(angle, axis, dest);
    }

    @Override
    public org.joml.Vector4d getRow(int row, org.joml.Vector4d dest) throws IndexOutOfBoundsException {
        return new Matrix4d(this).getRow(row, dest);
    }

    @Override
    public org.joml.Vector3d getRow(int row, org.joml.Vector3d dest) throws IndexOutOfBoundsException {
        return new Matrix4d(this).getRow(row, dest);
    }

    @Override
    public org.joml.Vector4d getColumn(int column, org.joml.Vector4d dest) throws IndexOutOfBoundsException {
        return new Matrix4d(this).getColumn(column, dest);
    }

    @Override
    public org.joml.Vector3d getColumn(int column, org.joml.Vector3d dest) throws IndexOutOfBoundsException {
        return new Matrix4d(this).getRow(column, dest);
    }

    @Override
    public Matrix4d normal(Matrix4d dest) {
        return new Matrix4d(this).normal(dest);
    }

    @Override
    public Matrix3d normal(Matrix3d dest) {
        return new Matrix4d(this).normal(dest);
    }

    @Override
    public Matrix4d normalize3x3(Matrix4d dest) {
        return new Matrix4d(this).normalize3x3(dest);
    }

    @Override
    public Matrix3d normalize3x3(Matrix3d dest) {
        return new Matrix4d(this).normalize3x3(dest);
    }

    @Override
    public org.joml.Vector4d unproject(double winX, double winY, double winZ, int[] viewport, org.joml.Vector4d dest) {
        return new Matrix4d(this).unproject(winX, winY, winZ, viewport, dest);
    }

    @Override
    public org.joml.Vector3d unproject(double winX, double winY, double winZ, int[] viewport, org.joml.Vector3d dest) {
        return new Matrix4d(this).unproject(winX, winY, winZ, viewport, dest);
    }

    @Override
    public org.joml.Vector4d unproject(Vector3dc winCoords, int[] viewport, org.joml.Vector4d dest) {
        return new Matrix4d(this).unproject(winCoords, viewport, dest);
    }

    @Override
    public org.joml.Vector3d unproject(Vector3dc winCoords, int[] viewport, org.joml.Vector3d dest) {
        return new Matrix4d(this).unproject(winCoords, viewport, dest);
    }

    @Override
    public Matrix4d unprojectRay(double winX, double winY, int[] viewport, org.joml.Vector3d originDest, org.joml.Vector3d dirDest){
        return new Matrix4d(this).unprojectRay(winX,winY,viewport,originDest,dirDest);
    }
    @Override
    public Matrix4d unprojectRay(Vector2dc winCoords, int[] viewport, org.joml.Vector3d originDest, org.joml.Vector3d dirDest){
        return new Matrix4d(this).unprojectRay(winCoords,viewport,originDest,dirDest);
    }

    @Override
    public org.joml.Vector4d unprojectInv(Vector3dc winCoords, int[] viewport, org.joml.Vector4d dest) {
        return new Matrix4d(this).unprojectInv(winCoords, viewport, dest);
    }

    @Override
    public org.joml.Vector4d unprojectInv(double winX, double winY, double winZ, int[] viewport, org.joml.Vector4d dest) {
        return new Matrix4d(this).unprojectInv(winX, winY, winZ, viewport, dest);
    }

    @Override
    public org.joml.Vector3d unprojectInv(Vector3dc winCoords, int[] viewport, org.joml.Vector3d dest) {
        return new Matrix4d(this).unprojectInv(winCoords, viewport, dest);
    }

    @Override
    public org.joml.Vector3d unprojectInv(double winX, double winY, double winZ, int[] viewport, org.joml.Vector3d dest) {
        return new Matrix4d(this).unprojectInv(winX, winY, winZ, viewport, dest);
    }

    @Override
    public Matrix4d unprojectInvRay(Vector2dc winCoords, int[] viewport, org.joml.Vector3d originDest, org.joml.Vector3d dirDest) {
        return new Matrix4d(this).unprojectInvRay(winCoords, viewport, originDest, dirDest);
    }

    @Override
    public Matrix4d unprojectInvRay(double winX, double winY, int[] viewport, org.joml.Vector3d originDest, org.joml.Vector3d dirDest) {
        return new Matrix4d(this).unprojectInvRay(winX, winY, viewport, originDest, dirDest);
    }

    @Override
    public org.joml.Vector4d project(double x, double y, double z, int[] viewport, org.joml.Vector4d winCoordsDest) {
        return new Matrix4d(this).project(x, y, z, viewport, winCoordsDest);
    }

    @Override
    public org.joml.Vector3d project(double x, double y, double z, int[] viewport, org.joml.Vector3d winCoordsDest) {
        return new Matrix4d(this).project(x, y, z, viewport, winCoordsDest);
    }

    @Override
    public org.joml.Vector4d project(Vector3dc position, int[] viewport, org.joml.Vector4d winCoordsDest) {
        return new Matrix4d(this).project(position, viewport, winCoordsDest);
    }

    @Override
    public org.joml.Vector3d project(Vector3dc position, int[] viewport, org.joml.Vector3d winCoordsDest) {
        return new Matrix4d(this).project(position, viewport, winCoordsDest);
    }

    @Override
    public Matrix4d reflect(double a, double b, double c, double d, Matrix4d dest) {
        return new Matrix4d(this).reflect(a, b, c, d, dest);
    }

    @Override
    public Matrix4d reflect(double nx, double ny, double nz, double px, double py, double pz, Matrix4d dest) {
        return new Matrix4d(this).reflect(nx, ny, nz, px, py, pz, dest);
    }

    @Override
    public Matrix4d reflect(Quaterniondc orientation, Vector3dc point, Matrix4d dest) {
        return new Matrix4d(this).reflect(orientation, point, dest);
    }

    @Override
    public Matrix4d reflect(Vector3dc normal, Vector3dc point, Matrix4d dest) {
        return new Matrix4d(this).reflect(normal, point, dest);
    }

    @Override
    public Matrix4d ortho(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).ortho(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d ortho(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).ortho(left, right, bottom, top, zNear, zFar, dest);
    }

    @Override
    public Matrix4d orthoLH(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).orthoLH(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d orthoLH(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).orthoLH(left, right, bottom, top, zNear, zFar, dest);
    }

    @Override
    public Matrix4d orthoSymmetric(double width, double height, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).orthoSymmetric(width, height, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d orthoSymmetric(double width, double height, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).orthoSymmetric(width, height, zNear, zFar, dest);
    }

    @Override
    public Matrix4d orthoSymmetricLH(double width, double height, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).orthoSymmetricLH(width, height, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d orthoSymmetricLH(double width, double height, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).orthoSymmetricLH(width, height, zNear, zFar, dest);
    }

    @Override
    public Matrix4d ortho2D(double left, double right, double bottom, double top, Matrix4d dest) {
        return new Matrix4d(this).ortho2D(left, right, bottom, top, dest);
    }

    @Override
    public Matrix4d ortho2DLH(double left, double right, double bottom, double top, Matrix4d dest) {
        return new Matrix4d(this).ortho2DLH(left, right, bottom, top, dest);
    }

    @Override
    public Matrix4d lookAlong(Vector3dc dir, Vector3dc up, Matrix4d dest) {
        return new Matrix4d(this).lookAlong(dir, up, dest);
    }

    @Override
    public Matrix4d lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).lookAlong(dirX, dirY, dirZ, upX, upY, upZ, dest);
    }

    @Override
    public Matrix4d lookAt(Vector3dc eye, Vector3dc center, Vector3dc up, Matrix4d dest) {
        return new Matrix4d(this).lookAt(eye, center, up, dest);
    }

    @Override
    public Matrix4d lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    @Override
    public Matrix4d lookAtPerspective(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).lookAtPerspective(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    @Override
    public Matrix4d lookAtLH(Vector3dc eye, Vector3dc center, Vector3dc up, Matrix4d dest) {
        return new Matrix4d(this).lookAtLH(eye, center, up, dest);
    }

    @Override
    public Matrix4d lookAtLH(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).lookAtLH(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    @Override
    public Matrix4d lookAtPerspectiveLH(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).lookAtPerspectiveLH(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, dest);
    }

    @Override
    public Matrix4d perspective(double fovy, double aspect, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).perspective(fovy, aspect, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d perspective(double fovy, double aspect, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).perspective(fovy, aspect, zNear, zFar, dest);
    }

    @Override
    public Matrix4d perspectiveLH(double fovy, double aspect, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).perspectiveLH(fovy, aspect, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d perspectiveLH(double fovy, double aspect, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).perspectiveLH(fovy, aspect, zNear, zFar, dest);
    }

    @Override
    public Matrix4d frustum(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).frustum(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d frustum(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).frustum(left, right, bottom, top, zNear, zFar, dest);
    }

    @Override
    public Matrix4d frustumLH(double left, double right, double bottom, double top, double zNear, double zFar, boolean zZeroToOne, Matrix4d dest) {
        return new Matrix4d(this).frustumLH(left, right, bottom, top, zNear, zFar, zZeroToOne, dest);
    }

    @Override
    public Matrix4d frustumLH(double left, double right, double bottom, double top, double zNear, double zFar, Matrix4d dest) {
        return new Matrix4d(this).frustumLH(left, right, bottom, top, zNear, zFar, dest);
    }

    @Override
    public org.joml.Vector4d frustumPlane(int plane, org.joml.Vector4d planeEquation) {
        return new Matrix4d(this).frustumPlane(plane, planeEquation);
    }

    @Override
    public Planed frustumPlane(int plane, Planed planeEquation) {
        return new Matrix4d(this).frustumPlane(plane, planeEquation);
    }

    @Override
    public org.joml.Vector3d frustumCorner(int corner, org.joml.Vector3d point) {
        return new Matrix4d(this).frustumCorner(corner, point);
    }

    @Override
    public org.joml.Vector3d perspectiveOrigin(org.joml.Vector3d origin) {
        return new Matrix4d(this).perspectiveOrigin(origin);
    }

    @Override
    public double perspectiveFov() {
        return new Matrix4d(this).perspectiveFov();
    }

    @Override
    public double perspectiveNear() {
        return new Matrix4d(this).perspectiveNear();
    }

    @Override
    public double perspectiveFar() {
        return new Matrix4d(this).perspectiveFar();
    }

    @Override
    public org.joml.Vector3d frustumRayDir(double x, double y, org.joml.Vector3d dir) {
        return new Matrix4d(this).frustumRayDir(x, y, dir);
    }

    @Override
    public org.joml.Vector3d positiveZ(org.joml.Vector3d dir) {
        return new Matrix4d(this).positiveZ(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveZ(org.joml.Vector3d dir) {
        return new Matrix4d(this).normalizedPositiveZ(dir);
    }

    @Override
    public org.joml.Vector3d positiveX(org.joml.Vector3d dir) {
        return new Matrix4d(this).positiveX(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveX(org.joml.Vector3d dir) {
        return new Matrix4d(this).normalizedPositiveX(dir);
    }

    @Override
    public org.joml.Vector3d positiveY(org.joml.Vector3d dir) {
        return new Matrix4d(this).positiveY(dir);
    }

    @Override
    public org.joml.Vector3d normalizedPositiveY(org.joml.Vector3d dir) {
        return new Matrix4d(this).normalizedPositiveY(dir);
    }

    @Override
    public org.joml.Vector3d originAffine(org.joml.Vector3d origin) {
        return new Matrix4d(this).originAffine(origin);
    }

    @Override
    public org.joml.Vector3d origin(org.joml.Vector3d origin) {
        return new Matrix4d(this).origin(origin);
    }

    @Override
    public Matrix4d shadow(Vector4dc light, double a, double b, double c, double d, Matrix4d dest) {
        return new Matrix4d(this).shadow(light, a, b, c, d, dest);
    }

    @Override
    public Matrix4d shadow(double lightX, double lightY, double lightZ, double lightW, double a, double b, double c, double d, Matrix4d dest) {
        return new Matrix4d(this).shadow(lightX, lightY, lightZ, lightW, a, b, c, d, dest);
    }

    @Override
    public Matrix4d shadow(Vector4dc light, Matrix4dc planeTransform, Matrix4d dest) {
        return new Matrix4d(this).shadow(light, planeTransform, dest);
    }

    @Override
    public Matrix4d shadow(double lightX, double lightY, double lightZ, double lightW, Matrix4dc planeTransform, Matrix4d dest) {
        return new Matrix4d(this).shadow(lightX, lightY, lightZ, lightW, planeTransform, dest);
    }

    @Override
    public Matrix4d pick(double x, double y, double width, double height, int[] viewport, Matrix4d dest) {
        return new Matrix4d(this).pick(x, y, width, height, viewport, dest);
    }

    @Override
    public boolean isAffine() {
        return new Matrix4d(this).isAffine();
    }

    @Override
    public Matrix4d arcball(double radius, double centerX, double centerY, double centerZ, double angleX, double angleY, Matrix4d dest) {
        return new Matrix4d(this).arcball(radius, centerX, centerY, centerZ, angleX, angleY, dest);
    }

    @Override
    public Matrix4d arcball(double radius, Vector3dc center, double angleX, double angleY, Matrix4d dest) {
        return new Matrix4d(this).arcball(radius, center, angleX, angleY, dest);
    }

    @Override
    public Matrix4d projectedGridRange(Matrix4dc projector, double sLower, double sUpper, Matrix4d dest) {
        return new Matrix4d(this).projectedGridRange(projector, sLower, sUpper, dest);
    }

    @Override
    public Matrix4d perspectiveFrustumSlice(double near, double far, Matrix4d dest) {
        return new Matrix4d(this).perspectiveFrustumSlice(near, far, dest);
    }

    @Override
    public Matrix4d orthoCrop(Matrix4dc view, Matrix4d dest) {
        return new Matrix4d(this).orthoCrop(view, dest);
    }

    @Override
    public Matrix4d transformAab(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, org.joml.Vector3d outMin, org.joml.Vector3d outMax) {
        return new Matrix4d(this).transformAab(minX, minY, minZ, maxX, maxY, maxZ, outMin, outMax);
    }

    @Override
    public Matrix4d transformAab(Vector3dc min, Vector3dc max, org.joml.Vector3d outMin, org.joml.Vector3d outMax) {
        return new Matrix4d(this).transformAab(min, max, outMin, outMax);
    }

    @Override
    public Matrix4d lerp(Matrix4dc other, double t, Matrix4d dest) {
        return new Matrix4d(this).lerp(other, t, dest);
    }

    @Override
    public Matrix4d rotateTowards(Vector3dc direction, Vector3dc up, Matrix4d dest) {
        return new Matrix4d(this).rotateTowards(direction, up, dest);
    }

    @Override
    public Matrix4d rotateTowards(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix4d dest) {
        return new Matrix4d(this).rotateTowards(dirX, dirY, dirZ, upX, upY, upZ, dest);
    }

    @Override
    public org.joml.Vector3d getEulerAnglesZYX(org.joml.Vector3d dest) {
        return new Matrix4d(this).getEulerAnglesZYX(dest);
    }

    @Override
    public boolean testPoint(double x, double y, double z) {
        return new Matrix4d(this).testPoint(x, y, z);
    }

    @Override
    public boolean testSphere(double x, double y, double z, double r) {
        return new Matrix4d(this).testSphere(x, y, z, r);
    }

    @Override
    public boolean testAab(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return new Matrix4d(this).testAab(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public Matrix4d obliqueZ(double a, double b, Matrix4d dest) {
        return new Matrix4d(this).obliqueZ(a, b, dest);
    }

    @Override
    public boolean equals(Matrix4dc m, double delta) {
        return new Matrix4d(this).equals(m, delta);
    }

    /**
     * Returns a string that contains the values of this Matrix3d.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.ROOT;
        String fmt = "%6.2f";
        String colSep = ", ";
        String rowStart = "[";
        String rowEnd = "]";
        String newLine = "\n";

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM00()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM01()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM02()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM03()));
        sb.append(rowEnd);
        sb.append(newLine);

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM10()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM11()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM12()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM13()));
        sb.append(rowEnd);
        sb.append(newLine);

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM20()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM21()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM22()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM23()));
        sb.append(rowEnd);
        sb.append(newLine);

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM30()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM31()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM32()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM33()));
        sb.append(rowEnd);

        return sb.toString();
    }
}
