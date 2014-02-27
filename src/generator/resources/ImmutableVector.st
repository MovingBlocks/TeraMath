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
 * An immutable implementation of $vector/baseType()$, which is a point or vector in $dimensions$D space with $componentType$ components.
 * This type is intended for use for constants, or any time you want a $vector/baseType()$ that is guaranteed immutable.
 *
 * @author auto-generated
 */
public final class $vector/immutableType()$ extends $vector/baseType()$ {

    $components:{x|private final $componentType$ $x$;}; separator = "\n"$

    /**
    $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     */
    public $vector/immutableType()$($comp/params()$) {
        $components:{x| this.$x$ = $x$;}; separator = "\n"$
    }

    /**
     * Copy constructor
     * @param other The $vector/baseType()$ to copy.
     */
    public $vector/immutableType()$($vector/baseType()$ other) {
        this($components:{x| other.get$x.proper$()}; separator = ", "$);
    }

$components:{x|
    @Override
    public $componentType$ get$x.proper$() {
        return $x$;
    \}
}; separator = "\n"$
$components:{x|
    @Override
    public $componentType$ $x$() {
        return $x$;
    \}
}; separator = "\n"$
}
