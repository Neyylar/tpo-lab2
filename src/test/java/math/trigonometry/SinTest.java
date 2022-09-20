package math.trigonometry;

import math.MathFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    private static final double ACCURACY = 0.00001;

    private MathFunc sin;

    @BeforeEach
    void setUp() {
        this.sin = new Sin(ACCURACY);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/sin.csv"
    )
    void testWithPointFromTable(double value, double result) {
        assertEquals(result, sin.compute(value), ACCURACY);
    }
}
