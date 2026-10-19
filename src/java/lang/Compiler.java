package lang;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;

/**
 * Dumps the parsed Abstract Syntax Tree of a Calc program.
 */
public class Compiler {
    /**
     * Entry point
     * @param args
     */
    
    public static Object CodeProber_parse(String[] args) throws Throwable {
        return parse(args);
    }

    public static Program parse(String[] args) throws IOException, beaver.Parser.Exception {
        String filename = args[args.length - 1]; // Assumes filename is the last argument
        LangScanner scanner = new LangScanner(new FileReader(filename));
        LangParser parser = new LangParser();
        Program program = (Program) parser.parse(scanner);
        return program;
    }

    
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.err.println(
                        "You must specify a source file on the command line!");
//                printUsage();
                System.exit(1);
                return;
            }

            Program program = parse(args);
            if (!program.errors().isEmpty()) {
                System.err.println();
                System.err.println("Errors: ");
                for (lang.ast.ErrorMessage err : program.errors()) {
                    System.err.println("- " + err);
                } System.exit(1);
            }
            // Execute program
            // program.eval();
            program.genCode(System.out);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Unexpected I/O exception. Perhaps permission problems?");
            e.printStackTrace(System.err);
            System.exit(1);
        } catch (beaver.Parser.Exception e) {
            System.out.println("Parsing failed!");
            e.printStackTrace();
            System.exit(1);
        }
    }

}

