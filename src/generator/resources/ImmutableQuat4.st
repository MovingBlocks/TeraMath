/*
 * Copyright $year$ MovingBlocks
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
 * An immutable implementation of {@link $quat/baseType()$}
 * @author auto-generated
 */
public final class $quat/immutableType()$ extends $quat/baseType()$ {

    private final $componentType$ x;
    private final $componentType$ y;
    private final $componentType$ z;
    private final $componentType$ w;
    
    /**
     * Constructs an instance from the specified xyzw coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w scalar component
     */
    public $quat/immutableType()$($componentType$ x, $componentType$ y, $componentType$ z, $componentType$ w) {
        $componentType$ mag = $comp/const("1.0")$ / $comp/cast("Math.sqrt(x * x + y * y + z * z + w * w)")$;
        this.x = x * mag;
        this.y = y * mag;
        this.z = z * mag;
        this.w = w * mag;
    }

    @Override
    public $componentType$ getX() {
        return x;
    }

    @Override
    public $componentType$ getY() {
        return y;
    }

    @Override
    public $componentType$ getZ() {
        return z;
    }

    @Override
    public $componentType$ getW() {
        return w;
    }

}
