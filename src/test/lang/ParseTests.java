package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
    /** Directory where the test input files are stored. */
    private static final File TEST_DIRECTORY = new File("testfiles/parser");

    @Test public void example() {
        Util.testValidSyntax(TEST_DIRECTORY, "example.in");
    }

    @Test
    public void error() {
        Util.testSyntaxError(TEST_DIRECTORY, "error.in");
    }

    @Test
    public void assign() {
        Util.testValidSyntax(TEST_DIRECTORY, "assign.in");
    }

    @Test
    public void gcd1() {
        Util.testValidSyntax(TEST_DIRECTORY, "gcd1.in");
    }

    @Test
    public void gcd2() {
        Util.testValidSyntax(TEST_DIRECTORY, "gcd2.in");
    }

    @Test
    public void if_stmt() {
        Util.testValidSyntax(TEST_DIRECTORY, "if_stmt.in");
    }

    @Test
    public void ret() {
        Util.testValidSyntax(TEST_DIRECTORY, "return.in");
    }

    @Test
    public void single_line() {
        Util.testValidSyntax(TEST_DIRECTORY, "single_line_comments.in");
    }

}