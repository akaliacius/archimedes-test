package archimedes.test.reporting;

import archimedes.test.reporting.generators.ReportGenerator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Component
public class CsvReport extends Report {
    @Override
    void generate(ReportRequest reportRequest, ReportGenerator reportGenerator) {
        var reportData = reportGenerator.apply(reportRequest);
        reportData.getHeaders().forEach(System.out::println);
        if(Objects.nonNull(reportData) && !reportData.isEmpty()){
            var headers = reportData.getHeaders();
            try (CSVPrinter printer = new CSVPrinter(new FileWriter(reportRequest.getParameter("destination")), CSVFormat.EXCEL)) {
                printer.printRecord(headers);
                Map<Integer, List<String>> raws = new LinkedHashMap<>();
                int index = 0;
                int size = reportData.getColumnValues(headers.get(0)).size();
                while(index < size){
                    List<String> raw = new ArrayList<>();
                    for(String header : headers){
                        raw.add(reportData.getColumnValues(header).get(index));
                    }
                    raws.put(index, raw);
                    index++;
                }
                for(Map.Entry<Integer, List<String>> entry : raws.entrySet()){
                    printer.printRecord(entry.getValue());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
