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

/**
 * @author Immortius
 */
public class ComponentType {

    private String type;
    private String typeEqualsFunction;
    private String abbreviation;
    private boolean discrete;
    private boolean floatType;

    public ComponentType(String type, String abbreviation, boolean discrete, String typeEqualsFunction) {
        this.type = type;
        this.typeEqualsFunction = typeEqualsFunction;
        this.abbreviation = abbreviation;
        this.discrete = discrete;
        this.floatType = (type.equals("float"));
    }

    public String getToIntegralFunc() {
        return typeEqualsFunction;
    }

    public String getAbbrev() {
        return abbreviation;
    }

    public boolean isDiscrete() {
        return discrete;
    }

    public boolean isFloatType() {
        return floatType;
    }

    @Override
    public String toString() {
        return type;
    }
}
