package math.integration;

import math.MathFunc;
import math.unit.trigonometry.Csc;
import math.unit.trigonometry.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CscIntTest {
    private static final double ACCURACY = 0.00001;

    private Sin sinSpy;
    private Csc csc;

    @BeforeEach
    void setUp() {
        this.sinSpy = spy(new Sin(ACCURACY));
        csc = new Csc(ACCURACY, sinSpy);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/csc.csv"
    )
    void testWithPointFromTable(double value, double result) {
        assertEquals(result, csc.compute(value), ACCURACY);
        verify(sinSpy, times(1)).compute(value);
    }
}
