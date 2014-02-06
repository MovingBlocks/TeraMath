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

package org.terasology.math.geom.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.terasology.math.geom.Point2cd;
import org.terasology.math.geom.Point2md;

/**
 * Some Point2D related tests
 * @author Martin Steiger
 */
public class Point2dTest {
    
    @Test
    public void testEquals() {
        assertTrue(new Point2cd(2, 2).equals(new Point2cd(2, 2)));
        
        // TODO: this is actually up for discussion
        assertFalse(new Point2cd(2, 2).equals(new Point2md(2, 2)));
    }
}
