package archimedes.test.repo;

import archimedes.test.data.repo.FileDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileDataRepositoryTest {
    private FileDataRepository testable;
    private String callsFile;
    private String operatorsFile;

    @BeforeEach void setup(){
        testable = new FileDataRepository();
        ClassLoader classLoader = getClass().getClassLoader();
        callsFile = new File(classLoader.getResource("calls.json").getFile()).getAbsolutePath();
        operatorsFile = new File(classLoader.getResource("operators.json").getFile()).getAbsolutePath();
    }

    @Test void testCalls() throws Exception {
        var calls = testable.getAllCalls(callsFile);
        assertNotNull(calls);
        assertEquals(50, calls.stream().count());
    }

    @Test void testOperators() throws Exception {
        var ops = testable.getAllOperators(operatorsFile);
        assertNotNull(ops);
        assertEquals(8, ops.stream().count());
    }
}
