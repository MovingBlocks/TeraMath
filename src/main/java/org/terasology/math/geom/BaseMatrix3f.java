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

import org.joml.AxisAngle4f;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3fc;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Locale;

/**
 * Defines a 3x3 float matrix 
 * @author auto-generated
 */
public abstract class BaseMatrix3f implements Matrix3fc {

    /**
     * The immutable identity matrix
     */
    public static final ImmutableMatrix3f IDENTITY = new ImmutableMatrix3f(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1);

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
        temp = Float.floatToIntBits(getM00());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM01());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM02());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM10());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM11());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM12());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM20());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM21());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(getM22());
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

        if (obj instanceof BaseMatrix3f) {
            BaseMatrix3f other = (BaseMatrix3f) obj;
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
    public final boolean equals(BaseMatrix3f other) {
        return
                Float.floatToIntBits(getM00()) == Float.floatToIntBits(other.getM00())
                        && Float.floatToIntBits(getM01()) == Float.floatToIntBits(other.getM01())
                        && Float.floatToIntBits(getM02()) == Float.floatToIntBits(other.getM02())
                        && Float.floatToIntBits(getM10()) == Float.floatToIntBits(other.getM10())
                        && Float.floatToIntBits(getM11()) == Float.floatToIntBits(other.getM11())
                        && Float.floatToIntBits(getM12()) == Float.floatToIntBits(other.getM12())
                        && Float.floatToIntBits(getM20()) == Float.floatToIntBits(other.getM20())
                        && Float.floatToIntBits(getM21()) == Float.floatToIntBits(other.getM21())
                        && Float.floatToIntBits(getM22()) == Float.floatToIntBits(other.getM22());
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
    public final boolean epsilonEquals(BaseMatrix3f m1, double epsilon) {
        float diff;

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

        return true;
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
    public Matrix3f mul(Matrix3fc right, Matrix3f dest) {
        return new Matrix3f(this).mul(right,dest);
    }

    @Override
    public Matrix3f mulLocal(Matrix3fc left, Matrix3f dest) {
        return new Matrix3f(this).mulLocal(left,dest);
    }

    /**
     * Computes the determinant of this matrix.
     *
     * @return the determinant of the matrix
     */
    public final float determinant() {
        return this.getM00() * (this.getM11() * this.getM22() - this.getM12() * this.getM21())
                + this.getM01() * (this.getM12() * this.getM20() - this.getM10() * this.getM22())
                + this.getM02() * (this.getM10() * this.getM21() - this.getM11() * this.getM20());
    }

    @Override
    public Matrix3f invert(Matrix3f dest) {
        return new Matrix3f(this).invert(dest);
    }

    @Override
    public Matrix3f transpose(Matrix3f dest) {
        return new Matrix3f(this).transpose(dest);
    }

    @Override
    public Matrix3f get(Matrix3f dest) {
        return new Matrix3f(this).get(dest);
    }

    @Override
    public Matrix4f get(Matrix4f dest) {
        return new Matrix3f(this).get(dest);
    }

    @Override
    public AxisAngle4f getRotation(AxisAngle4f dest) {
        return new Matrix3f(this).getRotation(dest);
    }

    @Override
    public Quaternionf getUnnormalizedRotation(Quaternionf dest) {
        return new Matrix3f(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaternionf getNormalizedRotation(Quaternionf dest) {
        return new Matrix3f(this).getNormalizedRotation(dest);
    }

    @Override
    public Quaterniond getUnnormalizedRotation(Quaterniond dest) {
        return new Matrix3f(this).getUnnormalizedRotation(dest);
    }

    @Override
    public Quaterniond getNormalizedRotation(Quaterniond dest) {
        return new Matrix3f(this).getNormalizedRotation(dest);
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return new Matrix3f(this).get(buffer);
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return new Matrix3f(this).get(index,buffer);
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return new Matrix3f(this).get(buffer);
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return new Matrix3f(this).get(index,buffer);
    }

    @Override
    public FloatBuffer getTransposed(FloatBuffer buffer) {
        return new Matrix3f(this).getTransposed(buffer);
    }

    @Override
    public FloatBuffer getTransposed(int index, FloatBuffer buffer) {
        return new Matrix3f(this).getTransposed(index,buffer);
    }

    @Override
    public ByteBuffer getTransposed(ByteBuffer buffer) {
        return new Matrix3f(this).getTransposed(buffer);
    }

    @Override
    public ByteBuffer getTransposed(int index, ByteBuffer buffer) {
        return new Matrix3f(this).getTransposed(index,buffer);
    }

    @Override
    public Matrix3fc getToAddress(long address) {
        return new Matrix3f(this).getToAddress(address);
    }

    @Override
    public float[] get(float[] arr, int offset) {
        return new Matrix3f(this).get(arr,offset);
    }

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     *
     * @param row    the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public abstract float get(int row, int column);

    @Override
    public Matrix3f normal(Matrix3f dest) {
        return new Matrix3f(this).normal(dest);
    }

    @Override
    public org.joml.Vector3f getScale(org.joml.Vector3f dest) {
        return new Matrix3f(this).getScale(dest);
    }

    @Override
    public org.joml.Vector3f positiveZ(org.joml.Vector3f dir) {
        return new Matrix3f(this).positiveZ(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveZ(org.joml.Vector3f dir) {
        return new Matrix3f(this).normalizedPositiveZ(dir);
    }

    @Override
    public org.joml.Vector3f positiveX(org.joml.Vector3f dir) {
        return new Matrix3f(this).positiveX(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveX(org.joml.Vector3f dir) {
        return new Matrix3f(this).normalizedPositiveX(dir);
    }

    @Override
    public org.joml.Vector3f positiveY(org.joml.Vector3f dir) {
        return new Matrix3f(this).positiveY(dir);
    }

    @Override
    public org.joml.Vector3f normalizedPositiveY(org.joml.Vector3f dir) {
        return new Matrix3f(this).normalizedPositiveY(dir);
    }

    @Override
    public Matrix3f add(Matrix3fc other, Matrix3f dest) {
        return new Matrix3f(this).add(other,dest);
    }

    @Override
    public Matrix3f sub(Matrix3fc subtrahend, Matrix3f dest) {
        return new Matrix3f(this).sub(subtrahend,dest);
    }

    @Override
    public Matrix3f mulComponentWise(Matrix3fc other, Matrix3f dest) {
        return new Matrix3f(this).mulComponentWise(other,dest);
    }

    @Override
    public Matrix3f lerp(Matrix3fc other, float t, Matrix3f dest) {
        return new Matrix3f(this).lerp(other,t,dest);
    }

    @Override
    public Matrix3f rotateTowards(Vector3fc direction, Vector3fc up, Matrix3f dest) {
        return new Matrix3f(this).rotateTowards(direction,up,dest);
    }

    @Override
    public Matrix3f rotateTowards(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix3f dest) {
        return new Matrix3f(this).rotateTowards(dirX,dirY,dirZ,upX,upY,upZ,dest);
    }

    @Override
    public org.joml.Vector3f getEulerAnglesZYX(org.joml.Vector3f dest) {
        return new Matrix3f(this).getEulerAnglesZYX(dest);
    }

    @Override
    public Matrix3f obliqueZ(float a, float b, Matrix3f dest) {
        return new Matrix3f(this).obliqueZ(a,b,dest);
    }

    @Override
    public boolean equals(Matrix3fc m, float delta) {
        return new Matrix3f(this).equals(m,delta);
    }

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     *
     * @param row the matrix row
     * @return the vector into that contains the matrix row values
     */
    public final Vector3f getRow(int row) {
        if (row == 0) {
            return new Vector3f(getM00(), getM01(), getM02());
        } else if (row == 1) {
            return new Vector3f(getM10(), getM11(), getM12());
        } else if (row == 2) {
            return new Vector3f(getM20(), getM21(), getM22());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Copies the matrix values in the specified row into the array parameter.
     *
     * @param row the matrix row
     * @param v   the array into which the matrix row values will be copied
     */
    public final void getRow(int row, float[] v) {
        if (row == 0) {
            v[0] = getM00();
            v[1] = getM01();
            v[2] = getM02();
        } else if (row == 1) {
            v[0] = getM10();
            v[1] = getM11();
            v[2] = getM12();
        } else if (row == 2) {
            v[0] = getM20();
            v[1] = getM21();
            v[2] = getM22();
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the vector
     * parameter.
     *
     * @param column the matrix column
     * @return the vector that contains the matrix row values
     */
    public final Vector3f getColumn(int column) {
        if (column == 0) {
            return new Vector3f(getM00(), getM10(), getM20());
        } else if (column == 1) {
            return new Vector3f(getM01(), getM11(), getM21());
        } else if (column == 2) {
            return new Vector3f(getM02(), getM12(), getM22());
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the array
     * parameter.
     *
     * @param column the matrix column
     * @param v      the array into which the matrix row values will be copied
     */
    public final void getColumn(int column, float[] v) {
        if (column == 0) {
            v[0] = getM00();
            v[1] = getM10();
            v[2] = getM20();
        } else if (column == 1) {
            v[0] = getM01();
            v[1] = getM11();
            v[2] = getM21();
        } else if (column == 2) {
            v[0] = getM02();
            v[1] = getM12();
            v[2] = getM22();
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }

    }

    /**
     * Copies the matrix values into the array parameter.
     *
     * @param v the array into which the matrix values will be copied
     */
    public final float[] get(float[] v) {
        v[0] = getM00();
        v[1] = getM01();
        v[2] = getM02();
        v[3] = getM10();
        v[4] = getM11();
        v[5] = getM12();
        v[6] = getM20();
        v[7] = getM21();
        v[8] = getM22();
        return v;
    }

    @Override
    public Matrix3f scale(Vector3fc xyz, Matrix3f dest) {
        return new Matrix3f(this).scale(xyz, dest);
    }

    @Override
    public Matrix3f scale(float x, float y, float z, Matrix3f dest) {
        return new Matrix3f(this).scale(x, y, z, dest);
    }

    @Override
    public Matrix3f scale(float xyz, Matrix3f dest) {
        return new Matrix3f(this).scale(xyz, dest);
    }

    @Override
    public Matrix3f scaleLocal(float x, float y, float z, Matrix3f dest) {
        return new Matrix3f(this).scaleLocal(x, y, z, dest);
    }

    @Override
    public org.joml.Vector3f transform(org.joml.Vector3f v) {
        return new Matrix3f(this).transform(v);
    }

    @Override
    public org.joml.Vector3f transform(Vector3fc v, org.joml.Vector3f dest) {
        return new Matrix3f(this).transform(v, dest);
    }

    @Override
    public org.joml.Vector3f transform(float x, float y, float z, org.joml.Vector3f dest) {
        return new Matrix3f(this).transform(x, y, z, dest);
    }

    @Override
    public org.joml.Vector3f transformTranspose(org.joml.Vector3f v) {
        return new org.joml.Matrix3f(this).transformTranspose(v);
    }

    @Override
    public org.joml.Vector3f transformTranspose(Vector3fc v, org.joml.Vector3f dest) {
        return new Matrix3f(this).transformTranspose(v, dest);
    }

    @Override
    public org.joml.Vector3f transformTranspose(float x, float y, float z, org.joml.Vector3f dest) {
        return new Matrix3f(this).transformTranspose(x, y, z, dest);
    }

    @Override
    public Matrix3f rotateX(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateX(ang, dest);
    }

    @Override
    public Matrix3f rotateY(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateY(ang, dest);
    }

    @Override
    public Matrix3f rotateZ(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateZ(ang, dest);
    }

    @Override
    public Matrix3f rotateXYZ(float angleX, float angleY, float angleZ, Matrix3f dest) {
        return new Matrix3f(this).rotateXYZ(angleX, angleY, angleZ, dest);
    }

    @Override
    public Matrix3f rotateZYX(float angleZ, float angleY, float angleX, Matrix3f dest) {
        return new Matrix3f(this).rotateZYX(angleX, angleY, angleZ, dest);
    }

    @Override
    public Matrix3f rotateYXZ(float angleY, float angleX, float angleZ, Matrix3f dest) {
        return new Matrix3f(this).rotateYXZ(angleY, angleX, angleZ, dest);
    }

    @Override
    public Matrix3f rotate(float ang, float x, float y, float z, Matrix3f dest) {
        return new Matrix3f(this).rotate(ang, x, y, z, dest);
    }

    @Override
    public Matrix3f rotateLocal(float ang, float x, float y, float z, Matrix3f dest) {
        return new Matrix3f(this).rotateLocal(ang, x, y, z, dest);
    }

    @Override
    public Matrix3f rotateLocalX(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateLocalX(ang, dest);
    }

    @Override
    public Matrix3f rotateLocalY(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateLocalY(ang, dest);
    }

    @Override
    public Matrix3f rotateLocalZ(float ang, Matrix3f dest) {
        return new Matrix3f(this).rotateLocalZ(ang, dest);
    }

    @Override
    public Matrix3f rotate(Quaternionfc quat, Matrix3f dest) {
        return new Matrix3f(this).rotate(quat, dest);
    }

    @Override
    public Matrix3f rotateLocal(Quaternionfc quat, Matrix3f dest) {
        return new Matrix3f(this).rotateLocal(quat, dest);
    }

    @Override
    public Matrix3f rotate(AxisAngle4f axisAngle, Matrix3f dest) {
        return new Matrix3f(this).rotate(axisAngle, dest);
    }

    @Override
    public Matrix3f rotate(float angle, Vector3fc axis, Matrix3f dest) {
        return new Matrix3f(this).rotate(angle, axis, dest);
    }

    @Override
    public Matrix3f lookAlong(Vector3fc dir, Vector3fc up, Matrix3f dest) {
        return new Matrix3f(this).lookAlong(dir, up, dest);
    }

    @Override
    public Matrix3f lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, Matrix3f dest) {
        return new Matrix3f(this).lookAlong(dirX, dirY, dirZ, upX, upY, upZ, dest);
    }

    @Override
    public org.joml.Vector3f getRow(int row, org.joml.Vector3f dest) throws IndexOutOfBoundsException {
        return new Matrix3f(this).getRow(row, dest);
    }

    @Override
    public org.joml.Vector3f getColumn(int column, org.joml.Vector3f dest) throws IndexOutOfBoundsException {
        return new Matrix3f(this).getColumn(column, dest);
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
        sb.append(rowEnd);
        sb.append(newLine);

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM10()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM11()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM12()));
        sb.append(rowEnd);
        sb.append(newLine);

        sb.append(rowStart);
        sb.append(String.format(locale, fmt, getM20()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM21()));
        sb.append(colSep);
        sb.append(String.format(locale, fmt, getM22()));
        sb.append(rowEnd);

        return sb.toString();
    }
}
