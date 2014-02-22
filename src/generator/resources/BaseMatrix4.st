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
 * Defines a $dimensions$x$dimensions$ $componentType$ matrix 
 * @author auto-generated
 */
public abstract class $matrix/baseType()$ {

    /**
     * The immutable identity matrix
     */
    public static final $matrix/immutableType()$ IDENTITY = new $matrix/immutableType()$(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

$components:{x|
    /**
     * @return the matrix element at row $x.row$, column $x.col$
     */
    public $componentType$ get$x.proper$() {
        return get($x.row$, $x.col$);
    \}
}; separator = "\n"$

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
$components:{x |
        temp = $componentType.toIntegralFunc$(get$x.proper$());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        }$
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

        if (obj instanceof $matrix/baseType()$) {
            $matrix/baseType()$ other = ($matrix/baseType()$) obj;
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
    public final boolean equals($matrix/baseType()$ other) {
        return 
            $components:{x | $componentType.toIntegralFunc$(get$x.proper$()) == $componentType.toIntegralFunc$(other.get$x.proper$())}; separator = "\n&& "$;
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
    public final boolean epsilonEquals($matrix/baseType()$ m1, double epsilon) {
        $componentType$ diff;

$components:{x | 
        diff = get$x.proper$() - m1.get$x.proper$();
        if ((diff < 0 ? -diff : diff) > epsilon) {
            return false;
        \}
}; separator = "\n"$
        return true;
    }

    /**
     * Computes the determinant of this matrix.
     * @return the determinant of the matrix
     */
    public final $componentType$ determinant() {
        $componentType$ det;

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
    public abstract $componentType$ get(int row, int column);

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     * @param row  the matrix row
     * @return the vector into that contains the matrix row values 
     */
    public final $matrix/vector4Type()$ getRow(int row) {
        if (row == 0) {
            return new $matrix/vector4Type()$(getM00(), getM01(), getM02(), getM03());
        } else if (row == 1) {
            return new $matrix/vector4Type()$(getM10(), getM11(), getM12(), getM13());
        } else if (row == 2) {
            return new $matrix/vector4Type()$(getM20(), getM21(), getM22(), getM23());
        } else if (row == 3) {
            return new $matrix/vector4Type()$(getM30(), getM31(), getM32(), getM33());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..3]");
        }
    }

    /**
     * Copies the matrix values in the specified row into the array parameter.
     * @param row  the matrix row
     * @param v    the array into which the matrix row values will be copied
     */
    public final void getRow(int row, $componentType$[] v) {
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
    public final $matrix/vector4Type()$ getColumn(int column) {
        if (column == 0) {
            return new $matrix/vector4Type()$(getM00(), getM10(), getM20(), getM30());
        } else if (column == 1) {
            return new $matrix/vector4Type()$(getM01(), getM11(), getM21(), getM31());
        } else if (column == 2) {
            return new $matrix/vector4Type()$(getM02(), getM12(), getM22(), getM32());
        } else if (column == 3) {
            return new $matrix/vector4Type()$(getM03(), getM13(), getM23(), getM33());
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
    public final void getColumn(int column, $componentType$[] v) {
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
        return "(" + $components:{x | get$x.proper$()}; separator = " + \", \" + "$ + ")";
    }
}
