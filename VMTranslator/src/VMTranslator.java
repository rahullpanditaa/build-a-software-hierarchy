public class VMTranslator {
    public static void main(String[] args) {
        // accepts a single argument
        // string Xxx.vm
        // construct a parser to handle the input file
        Parser parser = new Parser(args[0]);
    }
}
