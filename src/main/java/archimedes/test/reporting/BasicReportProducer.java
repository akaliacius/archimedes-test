package archimedes.test.reporting;

public class BasicReportProducer implements ReportProducer {
    @Override
    public void makeReport(){
        var request = new ReportRequest();
        var report = new CsvReport();

        report.generate(request, r -> ReportData.builder()
                .name("Super simple report")
                .build());
    }
}
