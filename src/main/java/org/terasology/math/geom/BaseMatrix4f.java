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
import org.joml.Matrix3f;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3f;
import org.joml.Matrix4x3fc;
import org.joml.Planef;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2fc;
import org.joml.Vector3fc;
import org.joml.Vector4fc;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Locale;

/**
 * Defines a 4x4 float matrix 
 * @author auto-generated
 */
public abstract class BaseMatrix4f  implements Matrix4fc{

    /**
     * The immutable identity matrix
     */
    public static final ImmutableMatrix4f IDENTITY = new ImmutableMatrix4f(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

    /**
     * @return the matrix element at row 0, column 0
     */
    public float getM00() {
        return get(0, 0);
    }

    /**
     * @return the matrix element at row 0, column 1
     */
    public float getM01() {
        return get(0, 1);
    }

    /**
     * @return the matrix element at row 0, column 2
     */
    public float getM02() {
        return get(0, 2);
    }

    /**
     * @return the matrix element at row 0, column 3
     */
    public float getM03() {
        return get(0, 3);
    }

    /**
     * @return the matrix element at row 1, column 0
     */
    public float getM10() {
        return get(1, 0);
    }

    /**
     * @return the matrix element at row 1, column 1
     */
    public float getM11() {
        return get(1, 1);
    }

    /**
     * @return the matrix element at row 1, column 2
     */
    public float getM12() {
        return get(1, 2);
    }

    /**
     * @return the matrix element at row 1, column 3
     */
    public float getM13() {
        return get(1, 3);
    }

    /**
     * @return the matrix element at row 2, column 0
     */
    public float getM20() {
        return get(2, 0);
    }

    /**
     * @return the matrix element at row 2, column 1
     */
    public float getM21() {
        return get(2, 1);
    }

    /**
     * @return the matrix element at row 2, column 2
     */
    public float getM22() {
        return get(2, 2);
    }

    /**
     * @return the matrix element at row 2, column 3
     */
    public float getM23() {
        return get(2, 3);
    }

    /**
     * @return the matrix element at row 3, column 0
     */
    public float getM30() {
        return get(3, 0);
    }

    /**
     * @return the matrix element at row 3, column 1
     */
    public float getM31() {
        return get(3, 1);
    }

    /**
     * @return the matrix element at row 3, column 2
     */
    public float getM32() {
        return get(3, 2);
    }

    /**
     * @return the matrix element at row 3, column 3
     */
    public float getM33() {
        return get(3, 3);
    }


    /**
     * Returns a hash code value based on the data values in this
     * object.  Two different Matrix3d objects with identical data values
     * (i.e., Matrix3d.equals returns true) will return the same hash
     * code value.  Two objects with different data members may return the
     * same hash value, although this is not likely.
     * @return the integer hash code value
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Float.floatToIntBits(getM00());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM01());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM02());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM03());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM10());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM11());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM12());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM13());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM20());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM21());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM22());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM23());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM30());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM31());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM32());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM33());
        result = prime * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    /**
     * This version correctly deals with NaN and signed zero values
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

        if (obj instanceof BaseMatrix4f) {
            BaseMatrix4f other = (BaseMatrix4f) obj;
            return equals(other);
        }

        return false;
    }

    /**
      * Returns true if all of the data members of Matrix3d m1 are
      * equal to the corresponding data members in this Matrix3d.
      * VecMath also uses explicit checks for -0 == 0
      * @param other the matrix with which the comparison is made
      * @return  true or false
      */
    public final boolean equals(Matrix4fc other) {
        return 
            Float.floatToIntBits(getM00()) == Float.floatToIntBits(other.m00())
            && Float.floatToIntBits(getM01()) == Float.floatToIntBits(other.m01())
            && Float.floatToIntBits(getM02()) == Float.floatToIntBits(other.m02())
            && Float.floatToIntBits(getM03()) == Float.floatToIntBits(other.m03())
            && Float.floatToIntBits(getM10()) == Float.floatToIntBits(other.m10())
            && Float.floatToIntBits(getM11()) == Float.floatToIntBits(other.m11())
            && Float.floatToIntBits(getM12()) == Float.floatToIntBits(other.m12())
            && Float.floatToIntBits(getM13()) == Float.floatToIntBits(other.m13())
            && Float.floatToIntBits(getM20()) == Float.floatToIntBits(other.m20())
            && Float.floatToIntBits(getM21()) == Float.floatToIntBits(other.m21())
            && Float.floatToIntBits(getM22()) == Float.floatToIntBits(other.m22())
            && Float.floatToIntBits(getM23()) == Float.floatToIntBits(other.m23())
            && Float.floatToIntBits(getM30()) == Float.floatToIntBits(other.m30())
            && Float.floatToIntBits(getM31()) == Float.floatToIntBits(other.m31())
            && Float.floatToIntBits(getM32()) == Float.floatToIntBits(other.m32())
            && Float.floatToIntBits(getM33()) == Float.floatToIntBits(other.m33());
    }

    /**
      * Returns true if the L-infinite distance between this matrix
      * and matrix m1 is less than or equal to the epsilon parameter,
      * otherwise returns false.  The L-infinite
      * distance is equal to
      * MAX[i=0,1,2 ; j=0,1,2 ; abs(this.m(i,j) - m1.m(i,j)]
      * @param m1  the matrix to be compared to this matrix
      * @param epsilon  the threshold value
     * @return true if equals up to epsilon
      */
    public final boolean epsilonEquals(Matrix4fc m1, double epsilon) {
        float diff;

        diff = getM00() - m1.m00();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM01() - m1.m01();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM02() - m1.m02();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM03() - m1.m03();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM10() - m1.m10();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM11() - m1.m11();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM12() - m1.m12();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM13() - m1.m13();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM20() - m1.m20();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM21() - m1.m21();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM22() - m1.m22();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM23() - m1.m23();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM30() - m1.m30();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM31() - m1.m31();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM32() - m1.m32();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        diff = getM33() - m1.m33();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        }

        return true;
    }

    @Override
    public int properties() {
        return new Matrix4f(this).determineProperties().properties();
    }

    @Override
    public float m00() {
        return getM00();
    }

    @Override
    public float m01() {
        return getM01();
    }

    @Override
    public float m02() {
        return getM02();
    }

    @Override
    public float m03() {
        return getM03();
    }

    @Override
    public float m10() {
        return getM10();
    }

    @Override
    public float m11() {
        return getM11();
    }

    @Override
    public float m12() {
        return getM12();
    }

    @Override
    public float m13() {
        return getM13();
    }

    @Override
    public float m20() {
        return getM20();
    }

    @Override
    public float m21() {
        return getM21();
    }

    @Override
    public float m22() {
        return getM22();
    }

    @Override
    public float m23() {
        return getM23();
    }

    @Override
    public float m30() {
        return getM30();
    }

    @Override
    public float m31() {
        return getM31();
    }

    @Override
    public float m32() {
        return getM32();
    }

    @Override
    public float m33() {
        return getM33();
    }

    @Override
    public Matrix4f mul(Matrix4fc right, Matrix4f dest) {
        return new Matrix4f(this).mul(right,dest);
    }

    @Override
    public Matrix4f mulLocal(Matrix4fc left, Matrix4f dest) {
        return new Matrix4f(this).mulLocal(left,dest);
    }

    @Override
    public Matrix4f mulLocalAffine(Matrix4fc left, Matrix4f dest) {
        return new Matrix4f(this).mulLocal(left,dest);
    }

    @Override
    public Matrix4f mul(Matrix3x2fc right, Matrix4f dest) {
        return new Matrix4f(this).mul(right,dest);
    }

    @Override
    public Matrix4f mul(Matrix4x3fc right, Matrix4f dest) {
        return new Matrix4f(this).mul(right,dest);
    }

    @Override
    public Matrix4f mulPerspectiveAffine(Matrix4fc view, Matrix4f dest) {
        return new Matrix4f(this).mulPerspectiveAffine(view,dest);
    }

    @Override
    public Matrix4f mulPerspectiveAffine(Matrix4x3fc view, Matrix4f dest) {
        return new Matrix4f(this).mulPerspectiveAffine(view,dest);
    }

    @Override
    public Matrix4f mulAffineR(Matrix4fc right, Matrix4f dest) {
        return new Matrix4f(this).mulAffineR(right,dest);
    }

    @Override
    public Matrix4f mulAffine(Matrix4fc right, Matrix4f dest) {
        return new Matrix4f(this).mulAffine(right,dest);
    }

    @Override
    public Matrix4f mulTranslationAffine(Matrix4fc right, Matrix4f dest) {
        return new Matrix4f(this).mulTranslationAffine(right,dest);
    }

    @Override
    public Matrix4f mulOrthoAffine(Matrix4fc view, Matrix4f dest) {
        return new Matrix4f(this).mulOrthoAffine(view,dest);
    }

    @Override
    public Matrix4f fma4x3(Matrix4fc other, float otherFactor, Matrix4f dest) {
        return new Matrix4f(this).fma4x3(other,otherFactor,dest);
    }

    @Override
    public Matrix4f add(Matrix4fc other, Matrix4f dest) {
        return new Matrix4f(this).add(other,dest);
    }

    @Override
    public Matrix4f sub(Matrix4fc subtrahend, Matrix4f dest) {
        return new Matrix4f(this).sub(subtrahend,dest);
    }

    @Override
    public Matrix4f mulComponentWise(Matrix4fc other, Matrix4f dest) {
        return new Matrix4f(this).mulComponentWise(other,dest);
    }

    @Override
    public Matrix4f add4x3(Matrix4fc other, Matrix4f dest) {
        return new Matrix4f(this).add4x3(other,dest);
    }

    @Override
    public Matrix4f sub4x3(Matrix4fc subtrahend, Matrix4f dest) {
        return new Matrix4f(this).sub4x3(subtrahend,dest);
    }

    @Override
    public Matrix4f mul4x3ComponentWise(Matrix4fc other, Matrix4f dest) {
        return new Matrix4f(this).mul4x3ComponentWise(other,dest);
    }

    /**
     * Computes the determinant of this matrix.
     * @return the determinant of the matrix
     */
    public final float determinant() {
        float det;

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
    public float determinant3x3() {
        return this.determinant();
    }

    @Override
    public float determinantAffine() {
        return new Matrix4f(this).determinantAffine();
    }

    @Override
    public Matrix4f invert(Matrix4f dest) {
        return new Matrix4f(this).invert(dest);
    }

    @Override
    public Matrix4f invertPerspective(Matrix4f dest) {
        return new Matrix4f(this).invertPerspective(dest);
    }

    @Override
    public Matrix4f invertFrustum(Matrix4f dest) {
        return new Matrix4f(this).invertFrustum(dest);
    }

    @Override
    public Matrix4f invertOrtho(Matrix4f dest) {
        return new Matrix4f(this).invertOrtho(dest);
    }

    @Override
    public Matrix4f invertPerspectiveView(Matrix4fc view, Matrix4f dest) {
        return new Matrix4f(this).invertPerspectiveView(view,dest);
    }

    @Override
    public Matrix4f invertPerspectiveView(Matrix4x3fc view, Matrix4f dest) {
        return new Matrix4f(this).invertPerspectiveView(view,dest);
    }

    @Override
    public Matrix4f invertAffine(Matrix4f dest) {
        return new Matrix4f(this).invertAffine(dest);
    }

    @Override
    public Matrix4f transpose(Matrix4f dest) {
        return new Matrix4f(this).transpose(dest);
    }

    @Override
    public Matrix4f transpose3x3(Matrix4f dest) {
        return new Matrix4f(this).transpose3x3(dest);
    }

    @Override
    public Matrix3f transpose3x3(Matrix3f dest) {
        return new Matrix4f(this).transpose3x3(dest);
    }

    @Override
    public org.joml.Vector3f getTranslation(org.joml.Vector3f dest) {
        return new Matrix4f(this).getTranslation(dest);
    }

    @Override
    public org.joml.Vector3f getScale(org.joml.Vector3f dest) {
        return new Matrix4f(this).getScale(dest);
    }

    @Override
    public Matrix4f get(Matrix4f dest) {
        return new Matrix4f(this).get(dest);
    }

    @Override
    public Matrix4x3f get4x3(Matrix4x3f dest) {
        return new Matrix4f(this).get4x3(dest);
    }

    @Override
    public Matrix4d get(Matrix4d dest) {
        return new Matrix4f(this).get(dest);
    }

    @Override
    public Matrix3f get3x3(Matrix3f dest) {
        return new Matrix4f(this).get3x3(dest);
    }

    @Override
    public Matrix3d get3x3(Matrix3d dest) {
        return new Matrix4f(this).get3x3(dest);
    }

    @Override
    public AxisAngle4f getRotation(AxisAngle4f dest) {
        return new Matrix4f(this).getRotation(dest);
    }

    @Override
    public AxisAngle4d getRotation(AxisAngle4d dest) {
        return new Matrix4f(this).getRotation(dest);
    }

    @Override
    public Quaternionf getUnnormalizedRotation(Quaternionf dest) {
        return new Matrix4f(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaternionf getNormalizedRotation(Quaternionf dest) {
        return new Matrix4f(this).getNormalizedRotation(dest);
    }

    @Override
    public Quaterniond getUnnormalizedRotation(Quaterniond dest) {
        return new Matrix4f(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaterniond getNormalizedRotation(Quaterniond dest) {
        return new Matrix4f(this).getNormalizedRotation(dest);
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return new Matrix4f(this).get(buffer);
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return new Matrix4f(this).get(index,buffer);
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new Matrix4f(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new Matrix4f(this).get(index,buffer);
    }

    @Override
    public FloatBuffer getTransposed(FloatBuffer buffer) {
        return new Matrix4f(this).getTransposed(buffer);
    }

    @Override
    public FloatBuffer getTransposed(int index, FloatBuffer buffer) {
        return new Matrix4f(this).getTransposed(index,buffer);
    }

    @Override
    public ByteBuffer getTransposed(ByteBuffer buffer) {
        return new Matrix4f(this).getTransposed(buffer);
    }

    @Override
    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        return new Matrix4f(this).getTransposed(index,buffer);
    }

    @Override
    public FloatBuffer get4x3Transposed(FloatBuffer buffer) {
        return new Matrix4f(this).get4x3Transposed(buffer);
    }

    @Override
    public FloatBuffer get4x3Transposed(int index, FloatBuffer buffer) {
        return new Matrix4f(this).get4x3Transposed(index,buffer);
    }

    @Override
    public ByteBuffer get4x3Transposed(ByteBuffer buffer) {
        return new Matrix4f(this).get4x3Transposed(buffer);
    }

    @Override
    public ByteBuffer get4x3Transposed(int index, ByteBuffer buffer) {
        return new Matrix4f(this).get4x3Transposed(index,buffer);
    }

    @Override
    public Matrix4fc getToAddress(long address) {
        return new Matrix4f(this).getToAddress(address);
    }

    @Override
    public float[] get(float[] arr, int offset) {
        return new Matrix4f(this).get(arr,offset);
    }

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public abstract float get(int row, int column);


    /**
     * Retrieves the translational components of this matrix.
     * @return a new vector that will receive the translational component
     */
    public final Vector3f getTranslation() {
        return new Vector3f(getM03(), getM13(), getM23());
    }

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     * @param row  the matrix row
     * @return the vector into that contains the matrix row values 
     */
    public final Vector4f getRow(int row) {
        if (row == 0) {
            return new Vector4f(getM00(), getM01(), getM02(), getM03());
        } else if (row == 1) {
            return new Vector4f(getM10(), getM11(), getM12(), getM13());
        } else if (row == 2) {
            return new Vector4f(getM20(), getM21(), getM22(), getM23());
        } else if (row == 3) {
            return new Vector4f(getM30(), getM31(), getM32(), getM33());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Copies the matrix values in the specified row into the array parameter.
     * @param row  the matrix row
     * @param v    the array into which the matrix row values will be copied
     */
    public final void getRow(int row, float[] v) {
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
     * @param column  the matrix column
     * @return the vector that contains the matrix row values
     */
    public final Vector4f getColumn(int column) {
        if (column == 0) {
            return new Vector4f(getM00(), getM10(), getM20(), getM30());
        } else if (column == 1) {
            return new Vector4f(getM01(), getM11(), getM21(), getM31());
        } else if (column == 2) {
            return new Vector4f(getM02(), getM12(), getM22(), getM32());
        } else if (column == 3) {
            return new Vector4f(getM03(), getM13(), getM23(), getM33());
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..3]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the array
     * parameter.
     * @param column the matrix column
     * @param v the array into which the matrix row values will be copied
     */
    public final void getColumn(int column, float[] v) {
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
     * @param v the array into which the matrix values will be copied
     */
    public final float[] get(float[] v) {
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
    public org.joml.Vector4f transform(org.joml.Vector4f v) {
        return new Matrix4f(this).transform(v);
    }

    @Override
    public org.joml.Vector4f transform(Vector4fc v, org.joml.Vector4f dest) {
        return new Matrix4f(this).transform(v,dest);
    }

    @Override
    public org.joml.Vector4f transform(float x, float y, float z, float w, org.joml.Vector4f dest) {
        return new Matrix4f(this).transform(x,y,z,w,dest);
    }

    @Override
    public org.joml.Vector4f transformProject(org.joml.Vector4f v) {
        return new Matrix4f(this).transformProject(v);
    }

    @Override
    public org.joml.Vector4f transformProject(Vector4fc v, org.joml.Vector4f dest) {
        return new Matrix4f(this).transformProject(v,dest);
    }

    @Override
    public org.joml.Vector4f transformProject(float x, float y, float z, float w, org.joml.Vector4f dest) {
        return new Matrix4f(this).transformProject(x,y,z,w,dest);
    }

    @Override
    public org.joml.Vector3f transformProject(org.joml.Vector3f v) {
        return new Matrix4f(this).transformProject(v);
    }

    @Override
    public org.joml.Vector3f transformProject(Vector3fc v, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformProject(v,dest);
    }

    @Override
    public org.joml.Vector3f transformProject(float x, float y, float z, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformProject(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3f transformPosition(org.joml.Vector3f v) {
        return new Matrix4f(this).transformPosition(v);
    }

    @Override
    public org.joml.Vector3f transformPosition(Vector3fc v, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformPosition(v,dest);
    }

    @Override
    public org.joml.Vector3f transformPosition(float x, float y, float z, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformPosition(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3f transformDirection(org.joml.Vector3f v) {
        return new Matrix4f(this).transformDirection(v);
    }

    @Override
    public org.joml.Vector3f transformDirection(Vector3fc v, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformDirection(v,dest);
    }

    @Override
    public org.joml.Vector3f transformDirection(float x, float y, float z, org.joml.Vector3f dest) {
        return new Matrix4f(this).transformDirection(x,y,z,dest);
    }

    @Override
    public org.joml.Vector4f transformAffine(org.joml.Vector4f v) {
        return new Matrix4f(this).transformAffine(v);
    }

    @Override
    public org.joml.Vector4f transformAffine(Vector4fc v, org.joml.Vector4f dest) {
        return new Matrix4f(this).transformAffine(v,dest);
    }

    @Override
    public org.joml.Vector4f transformAffine(float x, float y, float z, float w, org.joml.Vector4f dest) {
        return new Matrix4f(this).transformAffine(x,y,z,w,dest);
    }

    @Override
    public Matrix4f scale(Vector3fc xyz, Matrix4f dest) {
        return new Matrix4f(this).scale(xyz,dest);
    }

    @Override
    public Matrix4f scale(float xyz, Matrix4f dest) {
        return new Matrix4f(this).scale(xyz,dest);
    }

    @Override
    public Matrix4f scale(float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).scale(x,y,z,dest);
    }

    @Override
    public Matrix4f scaleAround(float sx, float sy, float sz, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).scaleAround(sx,sy,sz,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f scaleAround(float factor, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).scaleAround(factor,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f scaleLocal(float xyz, Matrix4f dest) {
        return new Matrix4f(this).scaleLocal(xyz,dest);
    }

    @Override
    public Matrix4f scaleLocal(float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).scaleLocal(x,y,z,dest);
    }

    @Override
    public Matrix4f scaleAroundLocal(float sx, float sy, float sz, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).scaleAroundLocal(sx,sy,sz,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f scaleAroundLocal(float factor, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).scaleAroundLocal(factor,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f rotateX(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateX(ang,dest);
    }

    @Override
    public Matrix4f rotateY(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateY(ang,dest);
    }

    @Override
    public Matrix4f rotateZ(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateZ(ang,dest);
    }

    @Override
    public Matrix4f rotateTowardsXY(float dirX, float dirY, Matrix4f dest) {
        return new Matrix4f(this).rotateTowardsXY(dirX,dirY,dest);
    }

    @Override
    public Matrix4f rotateXYZ(float angleX, float angleY, float angleZ, Matrix4f dest) {
        return new Matrix4f(this).rotateXYZ(angleX,angleY,angleZ,dest);
    }

    @Override
    public Matrix4f rotateAffineXYZ(float angleX, float angleY, float angleZ, Matrix4f dest) {
        return new Matrix4f(this).rotateAffineXYZ(angleX,angleY,angleZ,dest);
    }

    @Override
    public Matrix4f rotateZYX(float angleZ, float angleY, float angleX, Matrix4f dest) {
        return new Matrix4f(this).rotateZYX(angleZ,angleY,angleX,dest);
    }

    @Override
    public Matrix4f rotateAffineZYX(float angleZ, float angleY, float angleX, Matrix4f dest) {
        return new Matrix4f(this).rotateAffineZYX(angleZ,angleY,angleX,dest);
    }

    @Override
    public Matrix4f rotateYXZ(float angleY, float angleX, float angleZ, Matrix4f dest) {
        return new Matrix4f(this).rotateYXZ(angleY,angleX,angleZ,dest);
    }

    @Override
    public Matrix4f rotateAffineYXZ(float angleY, float angleX, float angleZ, Matrix4f dest) {
        return new Matrix4f(this).rotateAffineYXZ(angleY,angleX,angleZ,dest);
    }

    @Override
    public Matrix4f rotate(float ang, float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).rotate(ang,x,y,z,dest);
    }

    @Override
    public Matrix4f rotateTranslation(float ang, float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).rotateTranslation(ang,x,y,z,dest);
    }

    @Override
    public Matrix4f rotateAffine(float ang, float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).rotateAffine(ang,x,y,z,dest);
    }

    @Override
    public Matrix4f rotateLocal(float ang, float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).rotateLocal(ang,x,y,z,dest);
    }

    @Override
    public Matrix4f rotateLocalX(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateLocalX(ang,dest);
    }

    @Override
    public Matrix4f rotateLocalY(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateLocalY(ang,dest);
    }

    @Override
    public Matrix4f rotateLocalZ(float ang, Matrix4f dest) {
        return new Matrix4f(this).rotateLocalZ(ang,dest);
    }

    @Override
    public Matrix4f translate(Vector3fc offset, Matrix4f dest) {
        return new Matrix4f(this).translate(offset,dest);
    }

    @Override
    public Matrix4f translate(float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).translate(x,y,z,dest);
    }

    @Override
    public Matrix4f translateLocal(Vector3fc offset, Matrix4f dest) {
        return new Matrix4f(this).translateLocal(offset,dest);
    }

    @Override
    public Matrix4f translateLocal(float x, float y, float z, Matrix4f dest) {
        return new Matrix4f(this).translateLocal(x,y,z,dest);
    }

    @Override
    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).ortho(left,right,bottom,top,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f ortho(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).ortho(left,right,bottom,top,zNear,zFar,dest);
    }

    @Override
    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).orthoLH(left,right,bottom,top,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f orthoLH(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).orthoLH(left,right,bottom,top,zNear,zFar,dest);
    }

    @Override
    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).orthoSymmetric(width,height,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f orthoSymmetric(float width, float height, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).orthoSymmetric(width,height,zNear,zFar,dest);
    }

    @Override
    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).orthoSymmetricLH(width,height,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f orthoSymmetricLH(float width, float height, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).orthoSymmetricLH(width,height,zNear,zFar,dest);
    }

    @Override
    public Matrix4f ortho2D(float left, float right, float bottom, float top, Matrix4f dest) {
        return new Matrix4f(this).ortho2D(left,right,bottom,top,dest);
    }

    @Override
    public Matrix4f ortho2DLH(float left, float right, float bottom, float top, Matrix4f dest) {
        return new Matrix4f(this).ortho2DLH(left,right,bottom,top,dest);
    }

    @Override
    public Matrix4f lookAlong(Vector3fc dir, Vector3fc up, Matrix4f dest) {
        return new Matrix4f(this).lookAlong(dir,up,dest);
    }

    @Override
    public Matrix4f lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).lookAlong(dirX,dirY,dirZ,upX,upY,upZ,dest);
    }

    @Override
    public Matrix4f lookAt(Vector3fc eye, Vector3fc center, Vector3fc up, Matrix4f dest) {
        return new Matrix4f(this).lookAt(eye,center,up,dest);
    }

    @Override
    public Matrix4f lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).lookAt(eyeX,eyeY,eyeZ,centerX,centerY,centerZ,upX,upY,upZ,dest);
    }

    @Override
    public Matrix4f lookAtPerspective(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).lookAtPerspective(eyeX,eyeY,eyeZ,centerX,centerY,centerZ,upX,upY,upZ,dest);
    }

    @Override
    public Matrix4f lookAtLH(Vector3fc eye, Vector3fc center, Vector3fc up, Matrix4f dest) {
        return new Matrix4f(this).lookAtLH(eye,center,up,dest);
    }

    @Override
    public Matrix4f lookAtLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).lookAtLH(eyeX,eyeY,eyeZ,centerX,centerY,centerZ,upX,upY,upZ,dest);
    }

    @Override
    public Matrix4f lookAtPerspectiveLH(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).lookAtPerspectiveLH(eyeX,eyeY,eyeZ,centerX,centerY,centerZ,upX,upY,upZ,dest);
    }

    @Override
    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).perspective(fovy,aspect,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f perspective(float fovy, float aspect, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).perspective(fovy,aspect,zNear,zFar,dest);
    }

    @Override
    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).perspectiveLH(fovy,aspect,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f perspectiveLH(float fovy, float aspect, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).perspectiveLH(fovy,aspect,zNear,zFar,dest);
    }

    @Override
    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).frustum(left,right,bottom,top,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f frustum(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).frustum(left,right,bottom,top,zNear,zFar,dest);
    }

    @Override
    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar, boolean zZeroToOne, Matrix4f dest) {
        return new Matrix4f(this).frustumLH(left,right,bottom,top,zNear,zFar,zZeroToOne,dest);
    }

    @Override
    public Matrix4f frustumLH(float left, float right, float bottom, float top, float zNear, float zFar, Matrix4f dest) {
        return new Matrix4f(this).frustumLH(left,right,bottom,top,zNear,zFar,dest);
    }

    @Override
    public Matrix4f rotate(Quaternionfc quat, Matrix4f dest) {
        return new Matrix4f(this).rotate(quat,dest);
    }

    @Override
    public Matrix4f rotateAffine(Quaternionfc quat, Matrix4f dest) {
        return new Matrix4f(this).rotateAffine(quat,dest);
    }

    @Override
    public Matrix4f rotateTranslation(Quaternionfc quat, Matrix4f dest) {
        return new Matrix4f(this).rotateTranslation(quat,dest);
    }

    @Override
    public Matrix4f rotateAround(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).rotateAround(quat,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f rotateLocal(Quaternionfc quat, Matrix4f dest) {
        return new Matrix4f(this).rotateLocal(quat,dest);
    }

    @Override
    public Matrix4f rotateAroundLocal(Quaternionfc quat, float ox, float oy, float oz, Matrix4f dest) {
        return new Matrix4f(this).rotateAroundLocal(quat,ox,oy,oz,dest);
    }

    @Override
    public Matrix4f rotate(AxisAngle4f axisAngle, Matrix4f dest) {
        return new Matrix4f(this).rotate(axisAngle,dest);
    }

    @Override
    public Matrix4f rotate(float angle, Vector3fc axis, Matrix4f dest) {
        return new Matrix4f(this).rotate(angle,axis,dest);
    }

    @Override
    public org.joml.Vector4f unproject(float winX, float winY, float winZ, int[] viewport, org.joml.Vector4f dest) {
        return new Matrix4f(this).unproject(winX,winY,winZ,viewport,dest);
    }

    @Override
    public org.joml.Vector3f unproject(float winX, float winY, float winZ, int[] viewport, org.joml.Vector3f dest) {
        return new Matrix4f(this).unproject(winX,winY,winZ,viewport,dest);
    }

    @Override
    public org.joml.Vector4f unproject(Vector3fc winCoords, int[] viewport, org.joml.Vector4f dest) {
        return new Matrix4f(this).unproject(winCoords,viewport,dest);
    }

    @Override
    public org.joml.Vector3f unproject(Vector3fc winCoords, int[] viewport, org.joml.Vector3f dest) {
        return new Matrix4f(this).unproject(winCoords,viewport,dest);
    }

    @Override
    public Matrix4f unprojectRay(float winX, float winY, int[] viewport, org.joml.Vector3f originDest, org.joml.Vector3f dirDest) {
        return new Matrix4f(this).unprojectRay(winX,winY,viewport,originDest,dirDest);
    }

    @Override
    public Matrix4f unprojectRay(Vector2fc winCoords, int[] viewport, org.joml.Vector3f originDest, org.joml.Vector3f dirDest) {
        return new Matrix4f(this).unprojectRay(winCoords,viewport,originDest,dirDest);
    }

    @Override
    public org.joml.Vector4f unprojectInv(Vector3fc winCoords, int[] viewport, org.joml.Vector4f dest) {
        return new Matrix4f(this).unprojectInv(winCoords,viewport,dest);
    }

    @Override
    public org.joml.Vector4f unprojectInv(float winX, float winY, float winZ, int[] viewport, org.joml.Vector4f dest) {
        return new Matrix4f(this).unprojectInv(winX,winY,winZ,viewport,dest);
    }

    @Override
    public Matrix4f unprojectInvRay(Vector2fc winCoords, int[] viewport, org.joml.Vector3f originDest, org.joml.Vector3f dirDest) {
        return new Matrix4f(this).unprojectInvRay(winCoords,viewport,originDest,dirDest);
    }

    @Override
    public Matrix4f unprojectInvRay(float winX, float winY, int[] viewport, org.joml.Vector3f originDest, org.joml.Vector3f dirDest) {
        return new Matrix4f(this).unprojectInvRay(winX,winY,viewport,originDest,dirDest);
    }

    @Override
    public org.joml.Vector3f unprojectInv(Vector3fc winCoords, int[] viewport, org.joml.Vector3f dest) {
        return new Matrix4f(this).unprojectInv(winCoords,viewport,dest);
    }

    @Override
    public org.joml.Vector3f unprojectInv(float winX, float winY, float winZ, int[] viewport, org.joml.Vector3f dest) {
        return new Matrix4f(this).unprojectInv(winX,winY,winZ,viewport,dest);
    }

    @Override
    public org.joml.Vector4f project(float x, float y, float z, int[] viewport, org.joml.Vector4f winCoordsDest) {
        return new Matrix4f(this).project(x,y,z,viewport,winCoordsDest);
    }

    @Override
    public org.joml.Vector3f project(float x, float y, float z, int[] viewport, org.joml.Vector3f winCoordsDest) {
        return new Matrix4f(this).project(x,y,z,viewport,winCoordsDest);
    }

    @Override
    public org.joml.Vector4f project(Vector3fc position, int[] viewport, org.joml.Vector4f winCoordsDest) {
        return new Matrix4f(this).project(position,viewport,winCoordsDest);
    }

    @Override
    public org.joml.Vector3f project(Vector3fc position, int[] viewport, org.joml.Vector3f winCoordsDest) {
        return new Matrix4f(this).project(position,viewport,winCoordsDest);
    }

    @Override
    public Matrix4f reflect(float a, float b, float c, float d, Matrix4f dest) {
        return new Matrix4f(this).reflect(a,b,c,d,dest);
    }

    @Override
    public Matrix4f reflect(float nx, float ny, float nz, float px, float py, float pz, Matrix4f dest) {
        return new Matrix4f(this).reflect(nx,ny,nz,px,py,pz,dest);
    }

    @Override
    public Matrix4f reflect(Quaternionfc orientation, Vector3fc point, Matrix4f dest) {
        return new Matrix4f(this).reflect(orientation,point,dest);
    }

    @Override
    public Matrix4f reflect(Vector3fc normal, Vector3fc point, Matrix4f dest) {
        return new Matrix4f(this).reflect(normal,point,dest);
    }

    @Override
    public org.joml.Vector4f getRow(int row, org.joml.Vector4f dest) throws IndexOutOfBoundsException {
        return new Matrix4f(this).getRow(row,dest);
    }

    @Override
    public org.joml.Vector3f getRow(int row, org.joml.Vector3f dest) throws IndexOutOfBoundsException {
        return new Matrix4f(this).getRow(row,dest);
    }

    @Override
    public org.joml.Vector4f getColumn(int column, org.joml.Vector4f dest) throws IndexOutOfBoundsException {
        return new Matrix4f(this).getColumn(column,dest);
    }

    @Override
    public org.joml.Vector3f getColumn(int column, org.joml.Vector3f dest) throws IndexOutOfBoundsException {
        return new Matrix4f(this).getColumn(column,dest);
    }

    @Override
    public Matrix4f normal(Matrix4f dest) {
        return new Matrix4f(this).normal(dest);
    }

    @Override
    public Matrix3f normal(Matrix3f dest) {
        return new Matrix4f(this).normal(dest);
    }

    @Override
    public Matrix4f normalize3x3(Matrix4f dest) {
        return new Matrix4f(this).normalize3x3(dest);
    }

    @Override
    public Matrix3f normalize3x3(Matrix3f dest) {
        return new Matrix4f(this).normalize3x3(dest);
    }

    @Override
    public org.joml.Vector4f frustumPlane(int plane, org.joml.Vector4f planeEquation) {
        return new Matrix4f(this).frustumPlane(plane,planeEquation);
    }

    @Override
    public Planef frustumPlane(int which, Planef plane) {
        return new Matrix4f(this).frustumPlane(which,plane);
    }

    @Override
    public org.joml.Vector3f frustumCorner(int corner, org.joml.Vector3f point) {
        return new Matrix4f(this).frustumCorner(corner,point);
    }

    @Override
    public org.joml.Vector3f perspectiveOrigin(org.joml.Vector3f origin) {
        return new Matrix4f(this).perspectiveOrigin(origin);
    }

    @Override
    public float perspectiveFov() {
        return new Matrix4f(this).perspectiveFov();
    }

    @Override
    public float perspectiveNear() {
        return new Matrix4f(this).perspectiveNear();
    }

    @Override
    public float perspectiveFar() {
        return new Matrix4f(this).perspectiveFar();
    }

    @Override
    public org.joml.Vector3f frustumRayDir(float x, float y, org.joml.Vector3f dir) {
        return new Matrix4f(this).frustumRayDir(x,y,dir);
    }

    @Override
    public org.joml.Vector3f positiveZ(org.joml.Vector3f dir) {
        return new Matrix4f(this).positiveZ(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveZ(org.joml.Vector3f dir) {
        return new Matrix4f(this).normalizedPositiveZ(dir);
    }

    @Override
    public org.joml.Vector3f positiveX(org.joml.Vector3f dir) {
        return new Matrix4f(this).positiveX(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveX(org.joml.Vector3f dir) {
        return new Matrix4f(this).normalizedPositiveX(dir);
    }

    @Override
    public org.joml.Vector3f positiveY(org.joml.Vector3f dir) {
        return new Matrix4f(this).positiveY(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveY(org.joml.Vector3f dir) {
        return new Matrix4f(this).normalizedPositiveY(dir);
    }

    @Override
    public org.joml.Vector3f originAffine(org.joml.Vector3f origin) {
        return new Matrix4f(this).originAffine(origin);
    }

    @Override
    public org.joml.Vector3f origin(org.joml.Vector3f origin) {
        return new Matrix4f(this).origin(origin);
    }

    @Override
    public Matrix4f shadow(org.joml.Vector4f light, float a, float b, float c, float d, Matrix4f dest) {
        return new Matrix4f(this).shadow(light,a,b,c,d,dest);
    }

    @Override
    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, float a, float b, float c, float d, Matrix4f dest) {
        return new Matrix4f(this).shadow(lightX,lightY,lightZ,lightW,a,b,c,d,dest);
    }

    @Override
    public Matrix4f shadow(org.joml.Vector4f light, Matrix4fc planeTransform, Matrix4f dest) {
        return new Matrix4f(this).shadow(light,planeTransform,dest);
    }

    @Override
    public Matrix4f shadow(float lightX, float lightY, float lightZ, float lightW, Matrix4fc planeTransform, Matrix4f dest) {
        return new Matrix4f(this).shadow(lightX,lightY,lightZ,lightW,planeTransform,dest);
    }

    @Override
    public Matrix4f pick(float x, float y, float width, float height, int[] viewport, Matrix4f dest) {
        return new Matrix4f(this).pick(x,y,width,height,viewport,dest);
    }

    @Override
    public boolean isAffine() {
        return false;
    }

    @Override
    public Matrix4f arcball(float radius, float centerX, float centerY, float centerZ, float angleX, float angleY, Matrix4f dest) {
        return new Matrix4f(this).arcball(radius,centerX,centerY,centerZ,angleX,angleY,dest);
    }

    @Override
    public Matrix4f arcball(float radius, Vector3fc center, float angleX, float angleY, Matrix4f dest) {
        return new Matrix4f(this).arcball(radius,center,angleX,angleY,dest);
    }

    @Override
    public Matrix4f frustumAabb(org.joml.Vector3f min, org.joml.Vector3f max) {
        return new Matrix4f(this).frustumAabb(min,max);
    }

    @Override
    public Matrix4f projectedGridRange(Matrix4fc projector, float sLower, float sUpper, Matrix4f dest) {
        return new Matrix4f(this).projectedGridRange(projector,sLower,sUpper,dest);
    }

    @Override
    public Matrix4f perspectiveFrustumSlice(float near, float far, Matrix4f dest) {
        return new Matrix4f(this).perspectiveFrustumSlice(near,far,dest);
    }

    @Override
    public Matrix4f orthoCrop(Matrix4fc view, Matrix4f dest) {
        return new Matrix4f(this).orthoCrop(view,dest);
    }

    @Override
    public Matrix4f transformAab(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, org.joml.Vector3f outMin, org.joml.Vector3f outMax) {
        return new Matrix4f(this).transformAab(minX,minY,minZ,maxX,maxY,maxZ,outMin,outMax);
    }

    @Override
    public Matrix4f transformAab(Vector3fc min, Vector3fc max, org.joml.Vector3f outMin, org.joml.Vector3f outMax) {
        return new Matrix4f(this).transformAab(min,max,outMin,outMax);
    }

    @Override
    public Matrix4f lerp(Matrix4fc other, float t, Matrix4f dest) {
        return new Matrix4f(this).lerp(other,t,dest);
    }

    @Override
    public Matrix4f rotateTowards(Vector3fc dir, Vector3fc up, Matrix4f dest) {
        return new Matrix4f(this).rotateTowards(dir,up,dest);
    }

    @Override
    public Matrix4f rotateTowards(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix4f dest) {
        return new Matrix4f(this).rotateTowards(dirX,dirY,dirZ,upX,upY,upZ,dest);
    }

    @Override
    public org.joml.Vector3f getEulerAnglesZYX(org.joml.Vector3f dest) {
        return new Matrix4f(this).getEulerAnglesZYX(dest);
    }

    @Override
    public boolean testPoint(float x, float y, float z) {
        return new Matrix4f(this).testPoint(x,y,z);
    }

    @Override
    public boolean testSphere(float x, float y, float z, float r) {
        return new Matrix4f(this).testSphere(x,y,z,r);
    }

    @Override
    public boolean testAab(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return new Matrix4f(this).testAab(minX,minY,minZ,maxX,maxY,maxZ);
    }

    @Override
    public Matrix4f obliqueZ(float a, float b, Matrix4f dest) {
        return new Matrix4f(this).obliqueZ(a,b,dest);
    }

    @Override
    public boolean equals(Matrix4fc m, float delta) {
        return new Matrix4f(this).equals(m,delta);
    }

    /**
      * Returns a string that contains the values of this Matrix3d.
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
