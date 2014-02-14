package org.terasology.math.generator;

import com.google.common.collect.Lists;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STRawGroupDir;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Immortius
 */
public class TestGenerator {

    public static void main(String[] args) throws IOException {
        new TestGenerator().run();
    }

    public void run() throws IOException {
        STRawGroupDir rawGroupDir = new STRawGroupDir("src/main/template");
        rawGroupDir.delimiterStartChar = '$';
        rawGroupDir.delimiterStopChar = '$';
        rawGroupDir.importTemplates(new STGroupDir("src/main/template/tupleSupport"));
        ST st = rawGroupDir.getInstanceOf("Tuple");
        st.add("componentType", new ComponentType("double", "d", "Double.doubleToLongBits"));
        st.add("dimensions", 2);
        st.add("components", Lists.newArrayList(new Component("x", "X"), new Component("y", "Y")));
        st.add("discrete", false);
        String result = st.render();
        System.out.println(result);

        ST st2 = rawGroupDir.getInstanceOf("Tuple");
        st2.add("componentType", new ComponentType("float", "f", "Float.floatToIntBits"));
        st2.add("dimensions", 3);
        st2.add("components", Lists.newArrayList(new Component("x", "X"), new Component("y", "Y"), new Component("z", "Z")));
        st2.add("discrete", false);
        String result2 = st2.render();
        System.out.println(result2);
    }

    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
