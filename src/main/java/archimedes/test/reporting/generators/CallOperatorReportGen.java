package archimedes.test.reporting.generators;

import archimedes.test.data.DataService;
import archimedes.test.data.model.CallData;
import archimedes.test.data.model.OperatorData;
import archimedes.test.reporting.ReportData;
import archimedes.test.reporting.ReportRequest;
import org.springframework.stereotype.Component;

@Component
public class CallOperatorReportGen implements ReportGenerator {
    private final DataService<CallData> callService;
    private final DataService<OperatorData> dataService;

    public CallOperatorReportGen(DataService<CallData> callService, DataService<OperatorData> dataService) {
        this.callService = callService;
        this.dataService = dataService;
    }

    @Override
    public ReportData apply(ReportRequest reportRequest) {
        return null;
    }
}
