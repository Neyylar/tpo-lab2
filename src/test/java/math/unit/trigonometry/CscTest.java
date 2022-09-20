package math.unit.trigonometry;

import math.MathFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.CsvMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class CscTest {
    private static final double ACCURACY = 0.00001;
    private MathFunc csc;
    CsvMock csvMock = new CsvMock("src/test/resources/math/sin.csv");
    Sin sinMock = mock(Sin.class);

    @BeforeEach
    void setUp() {
        this.csc = new Csc(ACCURACY, sinMock);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/csc.csv"
    )
    void testWithPointFromTable(double value, double result) {
        when(sinMock.compute(anyDouble())).thenAnswer(i -> csvMock.getFuncMock(i.getArgument(0), ACCURACY));
        assertEquals(result, csc.compute(value), ACCURACY);
    }
}
