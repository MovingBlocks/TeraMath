package org.terasology.math.generator;

import com.google.common.collect.Lists;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STRawGroupDir;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Immortius
 */
public class MathGenerator {

    private STRawGroupDir templateDir;
    private File outputDir;
    private ComponentType doubleType = new ComponentType("double", "d", false, "Double.doubleToLongBits");
    private ComponentType floatType = new ComponentType("float", "f", false, "Float.floatToIntBits");
    private ComponentType intType = new ComponentType("int", "i", true, null);
    private List<Component> components2D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"));
    private List<Component> components3D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"));
    private List<Component> components4D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"), new Component("w", "W"));

    public static void main(String[] args) throws IOException {
        new MathGenerator().run();
    }

    public void run() throws IOException {
        setupTemplateDir();

        generateTuple(components2D, floatType);
        generateTuple(components2D, doubleType);
        generateTuple(components3D, floatType);
        generateTuple(components3D, doubleType);
        generateTuple(components4D, floatType);
        generateTuple(components4D, doubleType);
        
        generateTuple(components2D, intType);
        generateTuple(components3D, intType);
    }

    private void setupTemplateDir() {
        templateDir = new STRawGroupDir("src/generator/resources");
        templateDir.delimiterStartChar = '$';
        templateDir.delimiterStopChar = '$';
        templateDir.importTemplates(new STGroupDir("src/generator/resources/tupleSupport"));

        outputDir = new File("src/generated/java/org/terasology/math/geom");
        outputDir.mkdirs();
    }

    private void generateTuple(List<Component> components, ComponentType type) throws IOException {
        generate("Tuple", components, type);
        generate("ImmutableVector", components, type);
        generate("Vector", components, type);
    }

    private void generate(String template, List<Component> components, ComponentType type) throws IOException {
        ST st = templateDir.getInstanceOf(template);
        st.add("componentType", type);
        st.add("dimensions", components.size());
        st.add("components", components);

        st.write(new File(outputDir, template + components.size() + type.getAbbrev() + ".java"), new STErrorListener() {

            @Override
            public void compileTimeError(STMessage msg) {
                System.err.println(msg);
            }

            @Override
            public void runTimeError(STMessage msg) {
                System.err.println(msg);
            }

            @Override
            public void IOError(STMessage msg) {
                System.err.println(msg);
            }

            @Override
            public void internalError(STMessage msg) {
                System.err.println(msg);
            }
        });
    }

}
