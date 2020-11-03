package archimedes.test.reporting;

import archimedes.test.data.repo.FileDataRepository;
import archimedes.test.reporting.generators.CallOperatorReportGen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class CallOperatorReportGenTest {
    private CallOperatorReportGen testable;
    private FileDataRepository repository;

    @BeforeEach void setup(){
        repository = mock(FileDataRepository.class);
        testable = new CallOperatorReportGen(repository);
    }

    @Test void dataNotNull(){
        assertNotNull(testable.apply(ReportRequest.builder().build()), "data must not be null");
    }
}
