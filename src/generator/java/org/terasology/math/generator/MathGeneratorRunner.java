/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.generator;

import java.io.IOException;

/**
 * @author Martin Steiger
 */
public final class MathGeneratorRunner {

    private MathGeneratorRunner() {
    }
    
    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        try {
            MathGenerator mg = new MathGenerator();
            mg.createVector();
            mg.createQuat();
            mg.createMatrix(3);
            mg.createMatrix(4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
