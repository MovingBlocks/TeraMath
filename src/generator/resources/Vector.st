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

$if(componentType.discrete)$
import java.math.RoundingMode;

import com.google.common.math.DoubleMath;
$endif$


$if(componentType.floatType)$
    import com.badlogic.gdx.math.$vector/gdxVector()$;
$endif$

/**
 * $vector/mutableType()$ is the mutable implementation of $vector/baseType()$, for representing points or vectors in $dimensions$ dimensional space of type
 * $componentType$.
 *
 * @author auto-generated
 */
public class $vector/mutableType()$ extends $vector/baseType()$ {

    $components:{x| public $componentType$ $x$;}; separator = "\n"$

    /**
     * Default constructor - all components are set to 0
     */
    public $vector/mutableType()$() {
    }

    /**
     $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     */
    public $vector/mutableType()$($comp/params()$) {
        $components:{x| this.$x$ = $x$;}; separator = "\n"$
    }

    /**
     * Copy constructor
     * @param other The $vector/baseType()$ to copy.
     */
    public $vector/mutableType()$($vector/baseType()$ other) {
        this($components:{x| other.get$x.proper$()}; separator = ", "$);
    }

$if(componentType.discrete)$
    /**
     $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     */
    public $vector/mutableType()$($components:{x|float $x$}; separator = ", "$) {
        this($components:{x|
            DoubleMath.roundToInt($x$, RoundingMode.FLOOR)};
            separator = ",\n"$);
    }

    /**
     * Constructs the integer version of a floating-point vector by flooring it
     * @param vector The vector to copy.
     */
    public $vector/mutableType()$(BaseVector$dimensions$f vector) {
        this($components:{x|
            DoubleMath.roundToInt(vector.get$x.proper$(), RoundingMode.FLOOR)};
            separator = ",\n"$);
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param rm the rounding mode
     */
    public $vector/mutableType()$(BaseVector$dimensions$f vector, RoundingMode rm) {
        this($components:{x|
            DoubleMath.roundToInt(vector.get$x.proper$(), rm)};
            separator = ", "$);
    }

    /**
     * Constructs the integer version of a floating-point vector by rounding it
     * @param vector The vector to copy.
     * @param offset the offset to add to all components
     * @deprecated specify a rounding mode instead
     */
    @Deprecated
    public $vector/mutableType()$(BaseVector$dimensions$f vector, double offset) {
        this($components:{x|
            DoubleMath.roundToInt(vector.get$x.proper$() + offset, RoundingMode.FLOOR)};
            separator = ",\n"$);
    }
$endif$

    /**
     * A new vector with all entries explicitly set to zero
     */
    public static $vector/mutableType()$ zero() {
        return new $vector/mutableType()$($components:{x|0}; separator = ", "$);
    }

    /**
     * A new vector with all entries explicitly set to one
     */
    public static $vector/mutableType()$ one() {
        return new $vector/mutableType()$($components:{x|1}; separator = ", "$);
    }

$if(is3D)$
    public static $vector/mutableType()$ north() {
        return new $vector/mutableType()$(0, 0, 1);
    }

    public static $vector/mutableType()$ south() {
        return new $vector/mutableType()$(0, 0, -1);
    }

    public static $vector/mutableType()$ west() {
        return new $vector/mutableType()$(1, 0, 0);
    }

    public static $vector/mutableType()$ east() {
        return new $vector/mutableType()$(-1, 0, 0);
    }

    public static $vector/mutableType()$ up() {
        return new $vector/mutableType()$(0, 1, 0);
    }

    public static $vector/mutableType()$ down() {
        return new $vector/mutableType()$(0, -1, 0);
    }
$endif$

$components:{x|
    @Override
    public $componentType$ get$x.proper$() {
        return $x$;
    \}}; separator = "\n"$

$components:{x|
    @Override
    public $componentType$ $x$() {
        return $x$;
    \}}; separator = "\n"$

$components:{x|
    /**
     * @param new$x.proper$ the new x coordinate
     * @return this $vector/mutableType()$, to allow method chaining
     */
    public $vector/mutableType()$ set$x.proper$($componentType$ new$x.proper$) {
        this.$x$ = new$x.proper$;
        return this;
    \}}; separator = "\n"$

    /**
     * @param other the point to set
     * @return this
     */
    public $vector/mutableType()$ set($vector/baseType()$ other) {
        $components:{x| this.$x$ = other.get$x.proper$();}; separator = "\n"$
        return this;
    }

    /**
     $components:{x| * @param new$x.proper$ the $x$ component}; separator = "\n"$
     * @return this
     */
    public $vector/mutableType()$ set($comp/paramsPrefix("new")$) {
        $components:{x| this.$x$ = new$x.proper$;}; separator = "\n"$
        return this;
    }

$components:{x|
    /**
     * Adds to the $x$ component
     *
     * @param value the value to add to $x$
     * @return this
     */
    public $vector/mutableType()$ add$x.proper$($componentType$ value) {
        this.$x$ += value;
        return this;
    \}}; separator = "\n"$

$components:{x|
    /**
     * Subtracts from the $x$ component
     *
     * @param value the value to subtract from $x$
     * @return this
     */
    public $vector/mutableType()$ sub$x.proper$($componentType$ value) {
        this.$x$ -= value;
        return this;
    \}}; separator = "\n"$

$components:{x|
    /**
     * Multiplies the $x$ component
     *
     * @param value the value by which to multiply $x$
     * @return this
     */
    public $vector/mutableType()$ mul$x.proper$($componentType$ value) {
        this.$x$ *= value;
        return this;
    \}}; separator = "\n"$

    /**
     * Divides each component
     * @param value the value by which to divide
     */
    public $vector/mutableType()$ div($componentType$ value) {
        $components:{x| this.$x$ /= value;}; separator = "\n"$
        return this;
    }

$components:{x|
    /**
     * Divides the $x$ component
     *
     * @param value the value by which to divide $x$
     * @return this
     */
    public $vector/mutableType()$ div$x.proper$($componentType$ value) {
        this.$x$ /= value;
        return this;
    \}}; separator = "\n"$

    /**
     * Adds a point to this point
     *
     $components:{x| * @param value$x.proper$ the value to add to the $x$ component}; separator = "\n"$
     * @return this
     */
    public $vector/mutableType()$ add($comp/paramsPrefix("value")$) {
        $components:{x| this.$x$ += value$x.proper$;}; separator = "\n"$
        return this;
    }

    /**
     * Adds a point to this point
     *
     * @param other the point
     * @return this
     */
    public $vector/mutableType()$ add($vector/baseType()$ other) {
        $components:{x| this.$x$ += other.get$x.proper$();}; separator = "\n"$
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     $components:{x| * @param value$x.proper$ the value to subtract from the $x$ component}; separator = "\n"$
     * @return this
     */
    public $vector/mutableType()$ sub($comp/paramsPrefix("value")$) {
        $components:{x| this.$x$ -= value$x.proper$;}; separator = "\n"$
        return this;
    }

    /**
     * Subtracts a point from this point
     *
     * @param other the point
     * @return this
     */
    public $vector/mutableType()$ sub($vector/baseType()$ other) {
        $components:{x| this.$x$ -= other.get$x.proper$();}; separator = "\n"$
        return this;
    }

    /**
     *  Sets each component of this tuple to its absolute value.
     */
    public final void absolute() {
        $components:{x| this.$x$ = Math.abs($x$);}; separator = "\n"$
    }

    /**
     * Negate each component
     * @return this
     */
    public $vector/mutableType()$ negate() {
        $components:{x| this.$x$ = -this.$x$;}; separator = "\n"$
        return this;
    }

    /**
     * Sets the value of this vector to the vector difference
     * of vector t1 and t2 (this = t1 - t2).
     * @param t1 the first vector
     * @param t2 the second vector
     */
    public final void sub($vector/baseType()$ t1, $vector/baseType()$ t2) {
        $components:{x| this.$x$ = t1.get$x.proper$() - t2.get$x.proper$();}; separator = "\n"$
    }

    /**
     * Multiplies a point on a per-component basis.
     *
     $components:{x| * @param value$x.proper$ the value to multiply the $x$ component with}; separator = "\n"$
     * @return this
     */
    public $vector/mutableType()$ mul($comp/paramsPrefix("value")$) {
        $components:{x| this.$x$ *= value$x.proper$;}; separator = "\n"$
        return this;
    }

    /**
     * Multiplies this with a scalar value
     * This is equivalent to calling scale(value).
     * @param value a scalar value
     * @return this
     */
    public $vector/mutableType()$ mul($componentType$ value) {
        return scale(value);
    }

    /**
     * Multiplies this with a scalar value.
     * This is equivalent to calling mul(value).
     * @param value a scalar value
     * @return this
     */
    public $vector/mutableType()$ scale($componentType$ value) {
        $components:{x| this.$x$ *= value;}; separator = "\n"$
        return this;
    }

    /**
     * Sets the point coords. to (-x, -y)
     *
     * @return this
     */
    public $vector/mutableType()$ invert() {
        $components:{x| this.$x$ *= -1;}; separator = "\n"$
        return this;
    }

    /**
     * <code>min</code> sets each component to the min of this and <code>other</code>
     *
     * @param other
     */
    public void min($vector/baseType()$ other) {
        $components:{x| $x$ = Math.min($x$, other.get$x.proper$());}; separator = "\n"$
    }

    /**
     * <code>max</code> sets each component to the max of this and <code>other</code>
     *
     * @param other
     */
    public void max($vector/baseType()$ other) {
        $components:{x| $x$ = Math.max($x$, other.get$x.proper$());}; separator = "\n"$
    }

$if(is3D)$
    /**
     * Sets this vector to the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final void cross($vector/baseType()$ v1, $vector/baseType()$ v2) {
        this.x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        this.y = v2.getX() * v1.getZ() - v2.getZ() * v1.getX();
        this.z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
    }
$endif$

$if(componentType.floatType)$
    /**
     * Converts to libgdx vector
     */
    public $vector/gdxVector()$ as$vector/gdxVector()$()
    {
        return new $vector/gdxVector()$($components:{x| $x$}; separator = ","$);
    }

$endif$

$if(!componentType.discrete)$
    /**
     * Set the length of this vector to one
     *
     * @return this
     */
    public $vector/mutableType()$ normalize() {
        return scale(1 / length());
    }
$endif$

$if(componentType.discrete)$
    /**
     * @return The equivalent Vector$dimensions$f
     */
    public Vector$dimensions$f toVector$dimensions$f() {
        return new Vector$dimensions$f($components:{x|$x$}; separator = ", "$);
    }

    /**
     * @return The equivalent Vector$dimensions$d
     */
    public Vector$dimensions$d toVector$dimensions$d() {
        return new Vector$dimensions$d($components:{x|$x$}; separator = ", "$);
    }
$endif$

}
