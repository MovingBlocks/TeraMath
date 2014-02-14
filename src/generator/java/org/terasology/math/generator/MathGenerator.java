package org.terasology.math.generator;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STRawGroupDir;
import org.stringtemplate.v4.misc.STMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author Immortius
 */
public class MathGenerator {

    private STRawGroupDir templateDir;
    private File outputDir;
    private ComponentType doubleType = new ComponentType("double", "d", false, "Double.doubleToLongBits");
    private ComponentType floatType = new ComponentType("float", "f", false, "Float.floatToIntBits");
    private List<Component> components2D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"));
    private List<Component> components3D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"));
    private List<Component> components4D = Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z"), new Component("w", "W"));

    public static void main(String[] args) throws IOException {
        new MathGenerator().run();
    }

    public void run() throws IOException {
        setupTemplateDir();

        generate("Tuple", components2D, floatType);
        generate("Tuple", components2D, doubleType);
        generate("Tuple", components3D, floatType);
        generate("Tuple", components3D, doubleType);
        generate("Tuple", components4D, floatType);
        generate("Tuple", components4D, doubleType);
    }

    private void setupTemplateDir() {
        templateDir = new STRawGroupDir("src/generator/resources");
        templateDir.delimiterStartChar = '$';
        templateDir.delimiterStopChar = '$';
        templateDir.importTemplates(new STGroupDir("src/generator/resources/tupleSupport"));

        outputDir = new File("src/generated/java/org/terasology/math/geom");
        outputDir.mkdirs();

    }

    private void generate(String template, List<Component> components, ComponentType type) throws IOException {
        ST st = templateDir.getInstanceOf("Tuple");
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
