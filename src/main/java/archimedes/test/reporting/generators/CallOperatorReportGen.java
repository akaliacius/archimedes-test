package archimedes.test.reporting.generators;

import archimedes.test.data.model.CallData;
import archimedes.test.data.model.OperatorData;
import archimedes.test.data.repo.FileDataRepository;
import archimedes.test.reporting.ReportData;
import archimedes.test.reporting.ReportRequest;
import archimedes.test.utils.CallUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
public class CallOperatorReportGen implements ReportGenerator {
    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String NUMBER = "number";
    public static final String OPERATOR = "operator";
    public static final String RISK_SCORE = "riskScore";
    public static final String NO_NUMBER = "Withheld";
    public static final String NO_OPERATOR = "Unknown";

    private final FileDataRepository repository;
    private final ReportData reportData;
    private List<OperatorData> operators;

    public CallOperatorReportGen(FileDataRepository repository) {
        this.repository = repository;
        this.reportData = ReportData.builder().build();
    }

    @Override
    public ReportData apply(ReportRequest reportRequest) {
        try {
            var calls = repository.getAllCalls("calls.json");
            operators = repository.getAllOperators("operators.json");
            calls.forEach(call -> {
                addData(call, reportData, ID, CallData::getId);
                addData(call, reportData, DATE, callToDate);
                addData(call, reportData, NUMBER, callToNumber);
                addData(call, reportData, OPERATOR, callToOperator);
                addData(call, reportData, RISK_SCORE, callToRisk);
            });
        } catch (IOException e) {
            // of course we should do something more sensible with this
            e.printStackTrace();
        }
        return reportData;
    }

    public Function<CallData, String> callToDate = call -> call.getAttributes().getDate().substring(0,10);

    public Function<CallData, String> callToNumber = call -> {
        var number = call.getAttributes().getNumber();
        return Objects.nonNull(number) ? number : NO_NUMBER;
    };

    public Function<CallData, String> callToOperator = call -> {
        var number = call.getAttributes().getNumber();
        if(Objects.isNull(number)) return NO_OPERATOR;
        var operator = operators.stream()
                .map(OperatorData::getAttributes)
                .filter(att -> CallUtil.isOperator(number, att.getPrefix()))
                .findAny();
        return operator.isPresent() ? operator.get().getOperator() : NO_OPERATOR;
    };

    public Function<CallData, String> callToRisk = call -> {
        var attributes = call.getAttributes();
        if(attributes.isGreenList() && attributes.isRedList()) return "0.0";
        else if (attributes.isGreenList()) return "0.0";
        else if (attributes.isRedList()) return "1.0";
        else {
            var formatter = new DecimalFormat("#.#");
            return formatter.format(attributes.getRiskScore());
        }
    };
}
