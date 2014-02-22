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

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STRawGroupDir;
import org.stringtemplate.v4.misc.ErrorManager;

import com.google.common.collect.Lists;

/**
 * @author Immortius
 */
public class MathGenerator {

    private final STRawGroupDir templateDir;
    private final File outputDir;
    
    private ComponentType doubleType = new ComponentType("double", "d", false, "Double.doubleToLongBits");
    private ComponentType floatType = new ComponentType("float", "f", false, "Float.floatToIntBits");
    private ComponentType intType = new ComponentType("int", "i", true, null);
    private List<Component> components2D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"));
    private List<Component> components3D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"));
    private List<Component> components4D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"), new Component("w", "W"));

    public MathGenerator() {
        templateDir = new STRawGroupDir("src/generator/resources");
        templateDir.delimiterStartChar = '$';
        templateDir.delimiterStopChar = '$';
        templateDir.importTemplates(new STGroupDir("src/generator/resources/groups"));

        outputDir = new File("src/generated/java/org/terasology/math/geom");
        outputDir.mkdirs();
    }
    
    public void createVector() throws IOException {
        generateTuple(components2D, floatType);
        generateTuple(components2D, doubleType);
        generateTuple(components3D, floatType);
        generateTuple(components3D, doubleType);
        generateTuple(components4D, floatType);
        generateTuple(components4D, doubleType);
        
        generateTuple(components2D, intType);
        generateTuple(components3D, intType);
    }
    
    public void createQuat() throws IOException {
        generateQuat(floatType);
        generateQuat(doubleType);
    }
    
    public void createMatrix(int dims) throws IOException {
        List<Entry> components = Lists.newArrayList();
        for (int i = 0; i < dims; i++) {
            for (int j = 0; j < dims; j++) {
                Entry comp = new Entry("m", "M", i, j);
                components.add(comp);       
            }
        }
        
        generateMatrix(components, dims, floatType);
        generateMatrix(components, dims, doubleType);
    }

    private void generateMatrix(List<Entry> entries, int dims, ComponentType type) throws IOException {
        generateMatrix("BaseMatrix", dims, entries, type);
        generateMatrix("ImmutableMatrix", dims, entries, type);
        generateMatrix("Matrix", dims, entries, type);
    }

    private void generateMatrix(String template, int dims, List<Entry> entries, ComponentType type) throws IOException {
        ST st = templateDir.getInstanceOf(template + dims);
        st.add("componentType", type);
        st.add("dimensions", dims);
        st.add("components", entries);  // using the "components" name allows us to use the same template groups

        String fname = template + dims + type.getAbbrev() + ".java";
        st.write(new File(outputDir, fname), ErrorManager.DEFAULT_ERROR_LISTENER);
        System.out.println("Created file " + fname);
    }

    private void generateQuat(ComponentType type) throws IOException {
        generateQuat("BaseQuat4", type);
        generateQuat("ImmutableQuat4", type);
        generateQuat("Quat4", type);
    }

    private void generateQuat(String template, ComponentType type) throws IOException {
        ST st = templateDir.getInstanceOf(template);
        st.add("componentType", type);
        
        String fname = template + type.getAbbrev() + ".java";
        st.write(new File(outputDir, fname), ErrorManager.DEFAULT_ERROR_LISTENER);
        System.out.println("Created file " + fname);
    }

    private void generateTuple(List<Component> components, ComponentType type) throws IOException {
        generateTuple("BaseVector", components, type);
        generateTuple("ImmutableVector", components, type);
        generateTuple("Vector", components, type);
    }

    private void generateTuple(String template, List<Component> components, ComponentType type) throws IOException {
        ST st = templateDir.getInstanceOf(template);
        st.add("componentType", type);
        st.add("dimensions", components.size());
        st.add("components", components);

        String fname = template + components.size() + type.getAbbrev() + ".java";
        st.write(new File(outputDir, fname), ErrorManager.DEFAULT_ERROR_LISTENER);
        System.out.println("Created file " + fname);
    }

}
