package archimedes.test.reporting;

import java.util.function.Function;

public class CsvReport extends Report {
    @Override
    void generate(ReportRequest reportRequest, Function<ReportRequest, ReportData> reportGenerator) {
        var reportData = reportGenerator.apply(reportRequest);
        throw new UnsupportedOperationException("map data to CSV file and safe file");
    }
}
