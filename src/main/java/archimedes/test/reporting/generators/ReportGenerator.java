package archimedes.test.reporting.generators;

import archimedes.test.data.model.CallData;
import archimedes.test.reporting.ReportData;
import archimedes.test.reporting.ReportRequest;

import java.util.function.Function;

public interface ReportGenerator extends Function<ReportRequest, ReportData> {
    default void addData(CallData call, ReportData data, String key, Function<CallData, String> function){
        data.addReportEntry(key, function.apply(call));
    }
}
