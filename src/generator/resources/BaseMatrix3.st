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

package javax.vecmath;

import java.util.Locale;

/**
 * Defines a $dimensions$x$dimensions$ $componentType$ matrix 
 * @author auto-generated
 */
public abstract class $matrix/baseType()$ {

    /**
     * The immutable identity matrix
     */
    public static final $matrix/immutableType()$ IDENTITY = new $matrix/immutableType()$(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1);
            
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
    public abstract $componentType$ get(int row, int column);

    /**
     * Copies the matrix values in the specified row into the vector parameter.
     * @param row  the matrix row
     * @return the vector into that contains the matrix row values 
     */
    public final $matrix/vector3Type()$ getRow(int row) {
        if (row == 0) {
            return new $matrix/vector3Type()$(getM00(), getM01(), getM02());
        } else if (row == 1) {
            return new $matrix/vector3Type()$(getM10(), getM11(), getM12());
        } else if (row == 2) {
            return new $matrix/vector3Type()$(getM20(), getM21(), getM22());
        } else {
            throw new ArrayIndexOutOfBoundsException("row not in [0..2]");
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
    public final $matrix/vector3Type()$ getColumn(int column) {
        if (column == 0) {
            return new $matrix/vector3Type()$(getM00(), getM10(), getM20());
        } else if (column == 1) {
            return new $matrix/vector3Type()$(getM01(), getM11(), getM21());
        } else if (column == 2) {
            return new $matrix/vector3Type()$(getM02(), getM12(), getM22());
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
    public final void getColumn(int column, $componentType$[] v) {
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
    public final void get($componentType$[] v) {
        v[0] = getM00();
        v[1] = getM01();
        v[2] = getM02();
        v[3] = getM10();
        v[4] = getM11();
        v[5] = getM12();
        v[6] = getM20();
        v[7] = getM21();
        v[8] = getM22();
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
