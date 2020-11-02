package archimedes.test.reporting;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CsvReport extends Report {
    @Override
    void generate(ReportRequest reportRequest, Function<ReportRequest, ReportData> reportGenerator) {
        var reportData = reportGenerator.apply(reportRequest);
        throw new UnsupportedOperationException("map data to CSV file and safe file");
    }
}
