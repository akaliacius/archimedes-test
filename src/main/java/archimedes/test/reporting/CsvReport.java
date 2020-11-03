package archimedes.test.reporting;

import archimedes.test.reporting.generators.ReportGenerator;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CsvReport extends Report {
    @Override
    void generate(ReportRequest reportRequest, ReportGenerator reportGenerator) {
        var reportData = reportGenerator.apply(reportRequest);
        throw new UnsupportedOperationException("map data to CSV file and safe file");
    }
}
