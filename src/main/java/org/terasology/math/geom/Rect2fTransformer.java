/*
 * Copyright 2016 MovingBlocks
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

import org.terasology.math.geom.BaseVector2i;
import org.terasology.math.geom.Rect2f;
import org.terasology.math.geom.Vector2i;

/**
 * Transforms coordinates from the source rectangle into relative coordinates
 * in the target rectangle.
 */
public class Rect2fTransformer {

    private Rect2f source;
    private Rect2f target;

    public Rect2fTransformer(Rect2f source, Rect2f target) {
        this.source = source;
        this.target = target;
    }

    public Vector2i apply(float wx, float wy) {
        return new Vector2i(applyX(wx), applyY(wy));
    }

    public Vector2i apply(BaseVector2i v) {
        return new Vector2i(applyX(v.getX()), applyY(v.getY()));
    }

    public float applyX(float wx) {
        return target.minX() + (wx - source.minX()) * target.width() / source.width();
    }

    public float applyY(float wy) {
        return target.minY() + (wy - source.minY()) * target.height() / source.height();
    }

    public Rect2f getSource() {
        return source;
    }

    public Rect2f getTarget() {
        return target;
    }

    /**
     * @return the x scale factor
     */
    public float getScaleX() {
        return target.width() / source.width();
    }

    /**
     * @return the y scale factor
     */
    public float getScaleY() {
        return target.height() / source.height();
    }
}
