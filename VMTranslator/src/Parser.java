import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    BufferedReader reader;

    public Parser(String fileName) {
        // opens fileName.vm
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasMoreCommands() {
        try {
            reader.mark(200);
            String firstLine = reader.readLine();  //stores the 1st line in this local variable
            reader.reset();  // resets the pointer to the start of the file
            return ((firstLine != null) && !(firstLine.startsWith("//")) && !(firstLine.trim().isEmpty()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // reads next command from input, makes it current command
    String currentCommand;
    public void advance() {
        if (this.hasMoreCommands()) {   // need to create a helper method to delete/ignore inline comments
            try {
                currentCommand = reader.readLine();  // 1st time -> reads the 1st command in vm file
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public CommandType commandType() {
        String[] arithmeticCommands = {"add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not"};
        for (String arithmeticCommand : arithmeticCommands) {
            if (currentCommand.startsWith(arithmeticCommand)) {
                return CommandType.C_ARITHMETIC;
            }
        }
        if (currentCommand.startsWith("push")) {
            return CommandType.C_PUSH;
        } else if (currentCommand.startsWith("pop")) {
            return CommandType.C_POP;
        } else {
            throw new RuntimeException("Invalid command. Current version of VM Translator only supports Arithmetic and Memory segment commands");
        }
    }

    public String arg1() {
        CommandType currentCommandType = commandType();
        if (currentCommandType == CommandType.C_ARITHMETIC) { return currentCommand; }
        else {
            String[] s = currentCommand.split(" ");
            return s[1];
    }



}
