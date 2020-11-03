package archimedes.test.reporting.generators;

import archimedes.test.reporting.ReportData;
import archimedes.test.reporting.ReportRequest;

import java.util.function.Function;

public interface ReportGenerator extends Function<ReportRequest, ReportData> {
}
