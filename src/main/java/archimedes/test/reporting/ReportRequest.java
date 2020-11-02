package archimedes.test.reporting;

public class ReportRequest {
    private ReportRequest() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private final ReportRequest request;

        private Builder(){
            request = new ReportRequest();
        }

        public ReportRequest build(){
            return request;
        }
    }
}
