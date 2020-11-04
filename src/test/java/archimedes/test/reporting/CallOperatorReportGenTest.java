package archimedes.test.reporting;

import archimedes.test.data.model.CallAttribute;
import archimedes.test.data.model.CallData;
import archimedes.test.data.repo.FileDataRepository;
import archimedes.test.reporting.generators.CallOperatorReportGen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static archimedes.test.reporting.generators.CallOperatorReportGen.NO_NUMBER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CallOperatorReportGenTest {
    private CallOperatorReportGen testable;
    private FileDataRepository repository;
    private CallData callData;

    @BeforeEach void setup(){
        repository = mock(FileDataRepository.class);
        testable = new CallOperatorReportGen(repository);
        callData = new CallData();
    }

    @Test void dataNotNull(){
        assertNotNull(testable.apply(ReportRequest.builder().build()), "data must not be null");
    }

    @DisplayName("call to number tests")
    @Nested
    class CallToNumberTests {
        private CallAttribute attribute;

        @BeforeEach void setup(){
            attribute = new CallAttribute();
            callData.setAttributes(attribute);
        }

        @Test void existingNumberTest() throws Exception {
            var number = "+443642728615";
            attribute.setNumber(number);
            assertEquals(number, testable.callToNumber.apply(callData));
        }

        @Test void nullNumberTest() throws Exception {
            assertEquals(NO_NUMBER, testable.callToNumber.apply(callData));
        }
    }

    @DisplayName("call to risk score tests")
    @Nested
    class CallToRiskScoreTests {
        private CallAttribute attribute;

        @BeforeEach void setup(){
            attribute = new CallAttribute();
            attribute.setRiskScore(0.25246658);
            callData.setAttributes(attribute);
        }

        @Test void redAndGreenListShouldReturn0() {
            attribute.setGreenList(true);
            attribute.setRedList(true);
            assertEquals("0.0", testable.callToRisk.apply(callData));
        }

        @Test void redListShouldReturn1() {
            attribute.setGreenList(false);
            attribute.setRedList(true);
            assertEquals("1.0", testable.callToRisk.apply(callData));
        }

        @Test void greenListShouldReturn0() {
            attribute.setGreenList(true);
            attribute.setRedList(false);
            assertEquals("0.0", testable.callToRisk.apply(callData));
        }

        @Test void noListShouldReturnScore() {
            attribute.setGreenList(false);
            attribute.setRedList(false);
            assertEquals("0.3", testable.callToRisk.apply(callData));
        }

        @Test void nullNumberTest() {
            assertEquals(NO_NUMBER, testable.callToNumber.apply(callData));
        }
    }
}
