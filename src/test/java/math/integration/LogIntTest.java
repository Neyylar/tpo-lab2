package math.integration;

import math.unit.logarithm.Ln;
import math.unit.logarithm.Log;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogIntTest {
    private static final double ACCURACY = 0.001;

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log2.csv"
    )
    void testWithPointFromTableLog2(double value, double result) {
        Ln lnSpy = spy(new Ln(ACCURACY));
        int base = 2;
        Log log = new Log(ACCURACY, base, lnSpy);
        assertEquals(result, log.compute(value), ACCURACY);
        if (Double.isNaN(value) || value < 0.0 || value == Double.POSITIVE_INFINITY) {
            verifyNoInteractions(lnSpy);
        } else {
            verify(lnSpy, times(1)).compute(value);
            verify(lnSpy, times(1)).compute(base);
        }
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log3.csv"
    )
    void testWithPointFromTableLog3(double value, double result) {
        Ln lnSpy = spy(new Ln(ACCURACY));
        int base = 3;
        Log log = new Log(ACCURACY, base, lnSpy);
        assertEquals(result, log.compute(value), ACCURACY);
        if (Double.isNaN(value) || value < 0.0 || value == Double.POSITIVE_INFINITY) {
            verifyNoInteractions(lnSpy);
        } else {
            verify(lnSpy, times(1)).compute(value);
            verify(lnSpy, times(1)).compute(base);
        }
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log5.csv"
    )
    void testWithPointFromTableLog5(double value, double result) {
        Ln lnSpy = spy(new Ln(ACCURACY));
        int base = 5;
        Log log = new Log(ACCURACY, base, lnSpy);
        assertEquals(result, log.compute(value), ACCURACY);
        if (Double.isNaN(value) || value < 0.0 || value == Double.POSITIVE_INFINITY) {
            verifyNoInteractions(lnSpy);
        } else {
            verify(lnSpy, times(1)).compute(value);
            verify(lnSpy, times(1)).compute(base);
        }
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log10.csv"
    )
    void testWithPointFromTableLog10(double value, double result) {
        Ln lnSpy = spy(new Ln(ACCURACY));
        int base = 10;
        Log log = new Log(ACCURACY, base, lnSpy);
        assertEquals(result, log.compute(value), ACCURACY);
        if (Double.isNaN(value) || value < 0.0 || value == Double.POSITIVE_INFINITY) {
            verifyNoInteractions(lnSpy);
        } else {
            verify(lnSpy, times(1)).compute(value);
            verify(lnSpy, times(1)).compute(base);
        }
    }
}
