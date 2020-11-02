package archimedes.test.reporting;

import java.util.function.Function;

public abstract class Report {
    abstract void generate(ReportRequest reportRequest, Function<ReportRequest, ReportData> reportGenerator);
}
