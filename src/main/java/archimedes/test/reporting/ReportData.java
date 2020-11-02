package archimedes.test.reporting;

public class ReportData {
    private String name;

    private ReportData() {
    }

    public static Builder builder(){
        return new Builder();
    }

    static class Builder {
        private ReportData data;

        public Builder() {
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
