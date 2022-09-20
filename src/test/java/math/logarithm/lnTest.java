package math.logarithm;

import math.MathFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class lnTest {
    private static final double ACCURACY = 0.0001;

    private MathFunc ln;

    @BeforeEach
    void setUp() {
        this.ln = new Ln(ACCURACY);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/ln.csv"
    )
    void testWithPointFromTable(double x, double result) {
        assertEquals(result, ln.compute(x), ACCURACY);
    }
}
