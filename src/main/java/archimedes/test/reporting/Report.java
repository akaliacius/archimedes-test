package archimedes.test.reporting;

import archimedes.test.reporting.generators.ReportGenerator;

public abstract class Report {
    abstract void generate(ReportRequest reportRequest, ReportGenerator reportGenerator);
}
