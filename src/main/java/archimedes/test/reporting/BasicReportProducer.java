package archimedes.test.reporting;

import archimedes.test.reporting.generators.ReportGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BasicReportProducer implements ReportProducer {

    // we should be able to support multiple types of reports
    enum ReportType{
        CSV_REPORT("csvReport");
        public final String type;
        ReportType(String type){
            this.type = type;
        }
    }

    // also generate different reports in future
    enum ReportName {
        CALL_OPERATOR_REPORT("callOperatorReportGen");
        public final String reportName;
        ReportName(String reportName){
            this.reportName = reportName;
        }
    }

    private final ApplicationContext context;

    public BasicReportProducer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void makeReport(ReportRequest request){
        var report = context.getBean(ReportType.CSV_REPORT.type, Report.class);
        report.generate(request, context.getBean(ReportName.CALL_OPERATOR_REPORT.reportName,
                ReportGenerator.class));
    }
}
