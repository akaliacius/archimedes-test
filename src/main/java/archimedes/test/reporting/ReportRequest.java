package archimedes.test.reporting;

import java.util.Map;

public class ReportRequest {
    private Map<String, String> parameters;

    private ReportRequest() {
    }

    public String getParameter(String key){
        return parameters.get(key);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private final ReportRequest request;

        private Builder(){
            request = new ReportRequest();
        }

        public Builder parameters(Map<String, String> parameters){
            this.request.parameters = parameters;
            return this;
        }

        public ReportRequest build(){
            return request;
        }
    }
}
