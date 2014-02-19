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
 * Defines a 3x3 double matrix 
 * @author Martin Steiger
 */
public abstract class BaseMatrix3d {
    
    /**
     * @return The first matrix element in the first row.
     */
    public abstract double getM00();

    /**
     * @return The first matrix element in the second row.
     */
    public abstract double getM10();

    /**
     * @return The first matrix element in the third row.
     */
    public abstract double getM20();

    /**
     * @return The second matrix element in the first row.
     */
    public abstract double getM01();

    /**
     * @return The second matrix element in the second row.
     */
    public abstract double getM11();

    /**
     * @return The second matrix element in the third row.
     */
    public abstract double getM21();

    /**
     * @return The third matrix element in the first row.
     */
    public abstract double getM02();

    /**
     * @return The third matrix element in the second row.
     */
    public abstract double getM12();

    /**
     * @return The third matrix element in the third row.
     */
    public abstract double getM22();

    /**
     * Returns a hash code value based on the data values in this
     * object.  Two different Matrix3d objects with identical data values
     * (i.e., Matrix3d.equals returns true) will return the same hash
     * code value.  Two objects with different data members may return the
     * same hash value, although this is not likely.
     * @return the integer hash code value
     */
    @Override
    public int hashCode() {
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

    //  /**
    //  * Returns true if the Object t1 is of type Matrix3d and all of the
    //  * data members of t1 are equal to the corresponding data members in
    //  * this Matrix3d.
    //  * @param t1  the matrix with which the comparison is made
    //  * @return  true or false
    //  */
    // @Override
    // public boolean equals(Object t1)
    // {
    //     try {
    //        Matrix3d m2 = (Matrix3d) t1;
    //        return(this.getM00() == m2.getM00() && this.getM01() == m2.getM01() && this.getM02() == m2.getM02()
    //          && this.getM10() == m2.getM10() && this.getM11() == m2.getM11() && this.getM12() == m2.getM12()
    //          && this.getM20() == m2.getM20() && this.getM21() == m2.getM21() && this.getM22() == m2.getM22());
    //     }
    //     catch (ClassCastException   e1) { return false; }
    //     catch (NullPointerException e2) { return false; }
    //
    // }

    /**
     * This version correctly deals with NaN and signed zero values
     * @param obj the object to compare with
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (obj instanceof BaseQuat4d) {
            BaseMatrix3d other = (BaseMatrix3d) obj;
            return equals(other);
        }

        return false;
    }

    /**
      * Returns true if all of the data members of Matrix3d m1 are
      * equal to the corresponding data members in this Matrix3d.
      * TODO: find out how much performance penalty this brings compared to == comparisons
      * VecMath also uses explicit checks for -0 == 0
      * @param other the matrix with which the comparison is made
      * @return  true or false
      */
    public boolean equals(BaseMatrix3d other) {
        return (Double.doubleToLongBits(getM00()) == Double.doubleToLongBits(other.getM00()))
            && (Double.doubleToLongBits(getM01()) == Double.doubleToLongBits(other.getM01()))
            && (Double.doubleToLongBits(getM02()) == Double.doubleToLongBits(other.getM02()))
            && (Double.doubleToLongBits(getM11()) == Double.doubleToLongBits(other.getM11()))
            && (Double.doubleToLongBits(getM12()) == Double.doubleToLongBits(other.getM12()))
            && (Double.doubleToLongBits(getM20()) == Double.doubleToLongBits(other.getM20()))
            && (Double.doubleToLongBits(getM21()) == Double.doubleToLongBits(other.getM21()))
            && (Double.doubleToLongBits(getM22()) == Double.doubleToLongBits(other.getM22()));
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
    public boolean epsilonEquals(Matrix3d m1, double epsilon) {
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

    /**
     * Computes the determinant of this matrix.
     * @return the determinant of the matrix
     */
    public final double determinant() {
        return  this.getM00() * (this.getM11() * this.getM22() - this.getM12() * this.getM21())
              + this.getM01() * (this.getM12() * this.getM20() - this.getM10() * this.getM22())
              + this.getM02() * (this.getM10() * this.getM21() - this.getM11() * this.getM20());
    }

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    public final double getElement(int row, int column) {
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
      * Returns a string that contains the values of this Matrix3d.
      * @return the String representation
      */
    @Override
    public String toString() {
        return this.getM00() + ", " + this.getM01() + ", " + this.getM02() + "\n" +
               this.getM10() + ", " + this.getM11() + ", " + this.getM12() + "\n" +
               this.getM20() + ", " + this.getM21() + ", " + this.getM22() + "\n";
    }
}
