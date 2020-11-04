package archimedes.test.reporting;

import java.util.*;
import java.util.stream.Collectors;

public class ReportData {
    private String name;
    private Map<String, List<String>> reportData;

    private ReportData() {
        reportData = new LinkedHashMap<>();
    }

    public void addReportEntry(String key, String value){
        var list = reportData.get(key);
        if(Objects.isNull(list)) {
            list = new ArrayList<>(Arrays.asList(value));
            reportData.put(key, list);
        } else {
            list.add(value);
        }
    }

    public List<String> getColumnValues(String columnName){
        return reportData.get(columnName);
    }

    public List<String> getHeaders(){
        return reportData.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public boolean isEmpty(){
        return reportData.isEmpty();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private final ReportData data;

        private Builder() {
            this.data = new ReportData();
        }

        public Builder name(String name){
            data.name = name;
            return this;
        }

        public ReportData build(){
            return data;
        }
    }
}
