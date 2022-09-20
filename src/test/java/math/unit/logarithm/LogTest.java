package math.unit.logarithm;

import math.MathFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.СsvMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogTest {
    private static final double ACCURACY = 0.00001;
    private MathFunc log2;
    private MathFunc log3;
    private MathFunc log5;
    private MathFunc log10;
    СsvMock csvMock = new СsvMock("src/test/resources/math/ln.csv");
    Ln lnMock = mock(Ln.class);

    @BeforeEach
    void setUp() {
        this.log2 = new Log(ACCURACY, 2, lnMock);
        this.log3 = new Log(ACCURACY, 3, lnMock);
        this.log5 = new Log(ACCURACY, 5, lnMock);
        this.log10 = new Log(ACCURACY, 10, lnMock);
    }
    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log2.csv"
    )
    void testWithPointFromTableLog2(double value, double result) {
        when(lnMock.compute(anyDouble())).thenAnswer(i -> csvMock.getFuncMock(i.getArgument(0), ACCURACY));
        assertEquals(result, log2.compute(value), ACCURACY);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log3.csv"
    )
    void testWithPointFromTableLog3(double value, double result) {
        when(lnMock.compute(anyDouble())).thenAnswer(i -> csvMock.getFuncMock(i.getArgument(0), ACCURACY));
        assertEquals(result, log3.compute(value), ACCURACY);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log5.csv"
    )
    void testWithPointFromTableLog5(double value, double result) {
        when(lnMock.compute(anyDouble())).thenAnswer(i -> csvMock.getFuncMock(i.getArgument(0), ACCURACY));
        assertEquals(result, log5.compute(value), ACCURACY);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/log10.csv"
    )
    void testWithPointFromTableLog10(double value, double result) {
        when(lnMock.compute(anyDouble())).thenAnswer(i -> csvMock.getFuncMock(i.getArgument(0), ACCURACY));
        assertEquals(result, log10.compute(value), ACCURACY);
    }

}
