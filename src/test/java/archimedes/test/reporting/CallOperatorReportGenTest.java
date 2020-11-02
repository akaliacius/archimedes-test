package archimedes.test.reporting;

import archimedes.test.data.DataService;
import archimedes.test.data.model.CallData;
import archimedes.test.data.model.OperatorData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class CallOperatorReportGenTest {
    private CallOperatorReportGen testable;

    private DataService<CallData> callServiceMock;
    private DataService<OperatorData> operatorServiceMock;

    @BeforeEach void setup(){
        callServiceMock = (DataService<CallData>) mock(DataService.class);
        operatorServiceMock = (DataService<OperatorData>) mock(DataService.class);
        testable = new CallOperatorReportGen(callServiceMock, operatorServiceMock);
    }

    @Test void dataNotNull(){
        assertNotNull(testable.apply(new ReportRequest()), "data must not be null");
    }
}
