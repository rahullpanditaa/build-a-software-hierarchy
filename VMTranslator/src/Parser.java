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




}
