package archimedes.test.reporting.generators;

import archimedes.test.data.repo.FileDataRepository;
import archimedes.test.reporting.ReportData;
import archimedes.test.reporting.ReportRequest;
import org.springframework.stereotype.Component;

@Component
public class CallOperatorReportGen implements ReportGenerator {
    private final FileDataRepository repository;

    public CallOperatorReportGen(FileDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReportData apply(ReportRequest reportRequest) {

        return null;
    }
}
