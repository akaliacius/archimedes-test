package archimedes.test.reporting;

import archimedes.test.data.DataService;
import archimedes.test.data.model.CallData;
import archimedes.test.data.model.OperatorData;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CallOperatorReportGen implements Function<ReportRequest, ReportData> {
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
