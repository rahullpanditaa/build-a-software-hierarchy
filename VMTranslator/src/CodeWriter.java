import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CodeWriter {
    // base addresses for memory segments in RAM
    // LCL, ARG, THIS, THAT, POINTER are allocated segment dynamically
    private static final int TEMP_SEGMENT_BASE = 5;
    private static final int GENERAL_REGISTERS_BASE = 13;
    private static final int STATIC_VARIABLES_SEGMENT_BASE = 16;
    private static final int STACK_BASE = 256;
    private static int STACK_POINTER = 256;
    BufferedWriter writer;

    public CodeWriter(String asmFile) {
        try {
            writer = new BufferedWriter(new FileWriter(asmFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
