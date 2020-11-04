package archimedes.test;

import archimedes.test.reporting.ReportProducer;
import archimedes.test.reporting.ReportRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;
import java.util.stream.Stream;

@Configuration
@ComponentScan
@PropertySource("classpath:${env:dev}.properties")
public class App {

    private final String reportProducer;

    public App(@Value("${app.reportProducer}") String reportProducer) {
        this.reportProducer = reportProducer;
    }

    public static void main(String[] args) {
        var request = ReportRequest.builder().parameters(Map.ofEntries(
                Map.entry("calls", getArg("calls", args)),
                Map.entry("operators", getArg("operators", args)),
                Map.entry("destination", getArg("destination", args))
        )).build();

        var context = new AnnotationConfigApplicationContext(App.class);
        var app = context.getBean(App.class);
        // leaving space for different implementations of report producer
        var producer = context.getBean(app.reportProducer, ReportProducer.class);
        producer.makeReport(request);
    }

    private static String getArg(String key, String[] args){
        var value = Stream.of(args)
                .filter(arg -> arg.startsWith(key))
                .map(arg -> arg.split("=")[1])
                .findAny();
        if(value.isPresent()) return value.get();
        else throw new IllegalArgumentException(key + " is missing");
    }
}
