package archimedes.test.reporting;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BasicReportProducer implements ReportProducer {
    private final ApplicationContext context;

    public BasicReportProducer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void makeReport(){
        var request = ReportRequest.builder().build();
        var report = context.getBean(CsvReport.class);
        report.generate(request, context.getBean(CallOperatorReportGen.class));
    }
}
