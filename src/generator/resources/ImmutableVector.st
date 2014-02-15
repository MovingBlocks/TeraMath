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
 * An immutable implementation of $names/tupleType()$, which is a point or vector in $dimensions$D space with $componentType$ components.
 * This type is intended for use for constants, or any time you want a $names/tupleType()$ that is guaranteed immutable.
 *
 * @author Martin Steiger
 */
public final class $names/immutableVectorType()$ extends $names/tupleType()$ {

    $components:{x|private final $componentType$ $x$;}; separator = "\n"$

    /**
    $components:{x| * @param $x$ the $x$ component}; separator = "\n"$
     */
    public $names/immutableVectorType()$($params/componentParams()$) {
        $components:{x| this.$x$ = $x$;}; separator = "\n"$
    }

    /**
     * Copy constructor
     * @param other The $names/tupleType()$ to copy.
     */
    public $names/immutableVectorType()$($names/tupleType()$ other) {
        this($components:{x| other.get$x.proper$()}; separator = ", "$);
    }

$components:{x|
    @Override
    public $componentType$ get$x.proper$() {
        return $x$;
    \}
}; separator = "\n"$
}
