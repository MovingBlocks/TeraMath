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
 * Defines an immutable $dimensions$x$dimensions$ $componentType$ matrix
 * @author auto-generated
 */
public class $matrix/immutableType()$ extends $matrix/baseType()$ {

    $components:{x |
/**
 * Entry at row $x.row$, column $x.col$
 */
private final $componentType$ $x$;
};separator = "\n"$

    /**
     * Constructs and initializes a Matrix3d from the specified values.
     $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     */
    public $matrix/immutableType()$($comp/params()$) {
        $components:{x| this.$x$ = $x$;}; separator = "\n"$
    }

    /**
     *  Constructs a new matrix with the same values as the
     *  Matrix3d parameter.
     *  @param m1  the source matrix
     */
    public $matrix/immutableType()$($matrix/baseType()$ m1) {
        $components:{x| this.$x$ = m1.get$x.proper$();}; separator = "\n"$
    }

$components:{x|
    @Override
    public final $componentType$ get$x.proper$() {
        return $x$;
    \}
}; separator = "\n"$

    /**
     * Retrieves the value at the specified row and column of the specified
     * matrix.
     * @param row the row number to be retrieved (zero indexed)
     * @param column the column number to be retrieved (zero indexed)
     * @return the value at the indexed element.
     */
    @Override
    public final $componentType$ get(int row, int column) {
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

        throw new ArrayIndexOutOfBoundsException("row/col not in [0..3]");
    }
}
