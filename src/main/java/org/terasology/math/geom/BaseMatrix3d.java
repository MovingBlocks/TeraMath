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
import org.joml.Matrix3dc;
import org.joml.Matrix3fc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.util.Locale;

/**
 * Defines a 3x3 double matrix 
 * @author auto-generated
 */
public abstract class BaseMatrix3d implements Matrix3dc{

    /**
     * The immutable identity matrix
     */
    public static final ImmutableMatrix3d IDENTITY = new ImmutableMatrix3d(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1);

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
        temp = Double.doubleToLongBits(getM00());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM01());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM02());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM10());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM11());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM12());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM20());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM21());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getM22());
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

        if (obj instanceof BaseMatrix3d) {
            BaseMatrix3d other = (BaseMatrix3d) obj;
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
    public final boolean equals(BaseMatrix3d other) {
        return 
            Double.doubleToLongBits(getM00()) == Double.doubleToLongBits(other.getM00())
            && Double.doubleToLongBits(getM01()) == Double.doubleToLongBits(other.getM01())
            && Double.doubleToLongBits(getM02()) == Double.doubleToLongBits(other.getM02())
            && Double.doubleToLongBits(getM10()) == Double.doubleToLongBits(other.getM10())
            && Double.doubleToLongBits(getM11()) == Double.doubleToLongBits(other.getM11())
            && Double.doubleToLongBits(getM12()) == Double.doubleToLongBits(other.getM12())
            && Double.doubleToLongBits(getM20()) == Double.doubleToLongBits(other.getM20())
            && Double.doubleToLongBits(getM21()) == Double.doubleToLongBits(other.getM21())
            && Double.doubleToLongBits(getM22()) == Double.doubleToLongBits(other.getM22());
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
    public final boolean epsilonEquals(BaseMatrix3d m1, double epsilon) {
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
    public double m00() {
        return 0;
    }

    @Override
    public double m01() {
        return 0;
    }

    @Override
    public double m02() {
        return 0;
    }

    @Override
    public double m10() {
        return 0;
    }

    @Override
    public double m11() {
        return 0;
    }

    @Override
    public double m12() {
        return 0;
    }

    @Override
    public double m20() {
        return 0;
    }

    @Override
    public double m21() {
        return 0;
    }

    @Override
    public double m22() {
        return 0;
    }

    @Override
    public Matrix3d mul(Matrix3dc right, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d mulLocal(Matrix3dc left, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d mul(Matrix3fc right, Matrix3d dest) {
        return null;
    }

    /**
     * Computes the determinant of this matrix.
     * @return the determinant of the matrix
     */
    public final double determinant() {
        return  this.getM00() * (this.getM11() * this.getM22() - this.getM12() * this.getM21())
              + this.getM01() * (this.getM12() * this.getM20() - this.getM10() * this.getM22())
              + this.getM02() * (this.getM10() * this.getM21() - this.getM11() * this.getM20());
    }

    @Override
    public Matrix3d invert(Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d transpose(Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d get(Matrix3d dest) {
        return null;
    }

    @Override
    public AxisAngle4f getRotation(AxisAngle4f dest) {
        return null;
    }

    @Override
    public Quaternionf getUnnormalizedRotation(Quaternionf dest) {
        return null;
    }

    @Override
    public Quaternionf getNormalizedRotation(Quaternionf dest) {
        return null;
    }

    @Override
    public Quaterniond getUnnormalizedRotation(Quaterniond dest) {
        return null;
    }

    @Override
    public Quaterniond getNormalizedRotation(Quaterniond dest) {
        return null;
    }

    @Override
    public DoubleBuffer get(DoubleBuffer buffer) {
        return null;
    }

    @Override
    public DoubleBuffer get(int index, DoubleBuffer buffer) {
        return null;
    }

    @Override
    public FloatBuffer get(FloatBuffer buffer) {
        return null;
    }

    @Override
    public FloatBuffer get(int index, FloatBuffer buffer) {
        return null;
    }

    @Override
    public ByteBuffer get(ByteBuffer buffer) {
        return null;
    }

    @Override
    public ByteBuffer get(int index, ByteBuffer buffer) {
        return null;
    }

    @Override
    public ByteBuffer getFloats(ByteBuffer buffer) {
        return null;
    }

    @Override
    public ByteBuffer getFloats(int index, ByteBuffer buffer) {
        return null;
    }

    @Override
    public Matrix3dc getToAddress(long address) {
        return null;
    }

    @Override
    public double[] get(double[] arr, int offset) {
        return new double[0];
    }

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public abstract double get(int row, int column);

    @Override
    public Matrix3d normal(Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d lookAlong(Vector3dc dir, Vector3dc up, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d getScale(org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d positiveZ(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public org.joml.Vector3d normalizedPositiveZ(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public org.joml.Vector3d positiveX(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public org.joml.Vector3d normalizedPositiveX(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public org.joml.Vector3d positiveY(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public org.joml.Vector3d normalizedPositiveY(org.joml.Vector3d dir) {
        return null;
    }

    @Override
    public Matrix3d add(Matrix3dc other, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d sub(Matrix3dc subtrahend, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d mulComponentWise(Matrix3dc other, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d lerp(Matrix3dc other, double t, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateTowards(Vector3dc direction, Vector3dc up, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateTowards(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, Matrix3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d getEulerAnglesZYX(org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public Matrix3d obliqueZ(double a, double b, Matrix3d dest) {
        return null;
    }

    @Override
    public boolean equals(Matrix3dc m, double delta) {
        return false;
    }

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     * @param row  the matrix row
     * @return the vector into that contains the matrix row values 
     */
    public final Vector3d getRow(int row) {
        if (row == 0) {
            return new Vector3d(getM00(), getM01(), getM02());
        } else if (row == 1) {
            return new Vector3d(getM10(), getM11(), getM12());
        } else if (row == 2) {
            return new Vector3d(getM20(), getM21(), getM22());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
        }
    }

    /**
     * Copies the matrix values in the specified row into the array parameter.
     * @param row  the matrix row
     * @param v    the array into which the matrix row values will be copied
     */
    public final void getRow(int row, double[] v) {
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
     * @param column  the matrix column
     * @return the vector that contains the matrix row values
     */
    public final Vector3d getColumn(int column) {
        if (column == 0) {
            return new Vector3d(getM00(), getM10(), getM20());
        } else if (column == 1) {
            return new Vector3d(getM01(), getM11(), getM21());
        } else if (column == 2) {
            return new Vector3d(getM02(), getM12(), getM22());
        } else {
            throw new ArrayIndexOutOfBoundsException("col not in [0..2]");
        }

    }

    /**
     * Copies the matrix values in the specified column into the array
     * parameter.
     * @param column the matrix column
     * @param v the array into which the matrix row values will be copied
     */
    public final void getColumn(int column, double[] v) {
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
     * @param v the array into which the matrix values will be copied
     */
    public final double[] get(double[] v) {
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
    public float[] get(float[] arr, int offset) {
        return new float[0];
    }

    public org.joml.Matrix3d toJomlMatrix(){
        return  new Matrix3d(m00(),m01(),m02(),m10(),m11(),m12(),m20(),m21(),m22());
    }

    @Override
    public float[] get(float[] v) {
        v[0] = (float) getM00();
        v[1] = (float)getM01();
        v[2] = (float)getM02();
        v[3] = (float)getM10();
        v[4] = (float)getM11();
        v[5] = (float)getM12();
        v[6] = (float)getM20();
        v[7] = (float)getM21();
        v[8] = (float)getM22();
        return v;
    }

    @Override
    public Matrix3d scale(Vector3dc xyz, Matrix3d dest) {

        return toJomlMatrix().scale(xyz,dest);
    }

    @Override
    public Matrix3d scale(double x, double y, double z, Matrix3d dest) {
        return toJomlMatrix().scale(x,y,z,dest);
    }

    @Override
    public Matrix3d scale(double xyz, Matrix3d dest) {
        return toJomlMatrix().scale(xyz,dest);
    }

    @Override
    public Matrix3d scaleLocal(double x, double y, double z, Matrix3d dest) {
        return toJomlMatrix().scaleLocal(x,y,z,dest);
    }

    @Override
    public org.joml.Vector3d transform(org.joml.Vector3d v) {
        return null;
    }

    @Override
    public org.joml.Vector3d transform(Vector3dc v, org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public Vector3f transform(Vector3f v) {
        return null;
    }

    @Override
    public Vector3f transform(Vector3fc v, Vector3f dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d transform(double x, double y, double z, org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d transformTranspose(org.joml.Vector3d v) {
        return null;
    }

    @Override
    public org.joml.Vector3d transformTranspose(Vector3dc v, org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d transformTranspose(double x, double y, double z, org.joml.Vector3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateX(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateY(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateZ(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateXYZ(double angleX, double angleY, double angleZ, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateZYX(double angleZ, double angleY, double angleX, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateYXZ(double angleY, double angleX, double angleZ, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(double ang, double x, double y, double z, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocal(double ang, double x, double y, double z, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocalX(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocalY(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocalZ(double ang, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocal(Quaterniondc quat, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotateLocal(Quaternionfc quat, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(Quaterniondc quat, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(Quaternionfc quat, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(AxisAngle4f axisAngle, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(AxisAngle4d axisAngle, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(double angle, Vector3dc axis, Matrix3d dest) {
        return null;
    }

    @Override
    public Matrix3d rotate(double angle, Vector3fc axis, Matrix3d dest) {
        return null;
    }

    @Override
    public org.joml.Vector3d getRow(int row, org.joml.Vector3d dest) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public org.joml.Vector3d getColumn(int column, org.joml.Vector3d dest) throws IndexOutOfBoundsException {
        return null;
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
