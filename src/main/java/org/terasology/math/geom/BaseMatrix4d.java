/*
 * Copyright 2018 MovingBlocks
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

import java.util.Locale;

/**
 * Defines a 4x4 double matrix 
 * @author auto-generated
 */
public abstract class BaseMatrix4d extends org.joml.Matrix4d {

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
      * @param other the matrix with which the comparison is made
      * @return  true or false
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
      * @param m1  the matrix to be compared to this matrix
      * @param epsilon  the threshold value
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

    /**
     * Computes the determinant of this matrix.
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

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public abstract double get(int row, int column);


    /**
     * Retrieves the translational components of this matrix.
     * @return a new vector that will receive the translational component
     */
    public final Vector3d getTranslation() {
        Vector3d trans = new Vector3d(getM03(), getM13(), getM23());
        return trans;
    }

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     * @param row  the matrix row
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
     * @param row  the matrix row
     * @param v    the array into which the matrix row values will be copied
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
     * @param column  the matrix column
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
     * @param column the matrix column
     * @param v the array into which the matrix row values will be copied
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
