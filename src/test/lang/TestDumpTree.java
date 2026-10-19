package lang;

import java.io.File;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.Program;
import lang.ast.DumpTreeResult;

/**
 * Tests for AST printing (dumpTree).
 * This is a parameterized test: one test case is generated for each input
 * file found in TEST_DIRECTORY. Input files should have the ".in" extension.
 * @author Jesper Öqvist <jesper.oqvist@cs.lth.se>
 */
@RunWith(Parameterized.class)
public class TestDumpTree {
    /** Directory where the test input files are stored. */
    private static final File TEST_DIRECTORY = new File("testfiles/ast");

    private final String filename;
    public TestDumpTree(String testFile) {
        filename = testFile;
    }

    @Test public void runTest() throws Exception {
        Program program = (Program) Util.parse(new File(TEST_DIRECTORY, filename));

        DumpTreeResult res = program.dumpTree();
        Util.compareOutput(res.tree,
            new File(TEST_DIRECTORY, Util.changeExtension(filename, ".out")),
            new File(TEST_DIRECTORY, Util.changeExtension(filename, ".expected")));
        assertFalse("The AST is not correctly constructed. See ERROR in out file", res.hasErrors);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> getTests() {
        return Util.getTestParameters(TEST_DIRECTORY, ".in");
    }
}
