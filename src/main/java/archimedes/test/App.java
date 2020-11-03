package archimedes.test;

import archimedes.test.reporting.ReportProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:${env:dev}.properties")
public class App {

    private final String reportProducer;

    public App(@Value("${app.reportProducer}") String reportProducer) {
        this.reportProducer = reportProducer;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(App.class);
        var app = context.getBean(App.class);
        // leaving space for different implementations of report producer
        var producer = context.getBean(app.reportProducer, ReportProducer.class);
        producer.makeReport();
    }
}
