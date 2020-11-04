package archimedes.test.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CallUtilTest {
    @Test void numberInRange(){
        var number = "+442143999888";
        var prefix = "2000";
        assertTrue(CallUtil.isOperator(number, prefix));
    }

    @Test void numberOutOfRange(){
        var number = "+448423666777";
        var prefix = "2000";
        assertFalse(CallUtil.isOperator(number, prefix));
    }
}
