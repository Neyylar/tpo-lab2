package math.integration;

import math.TaskFunc;
import math.unit.logarithm.Ln;
import math.unit.logarithm.Log;
import math.unit.trigonometry.Csc;
import math.unit.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaskIntTest {
    private static final double ACCURACY = 0.01;
    private static Sin sin;
    private static Csc csc;
    private static Ln ln;
    private static Log log2, log3, log5, log10;
    private static TaskFunc taskFunc;

    @BeforeAll
    public static void init() {
        csc = spy(new Csc(ACCURACY));
        ln = spy(new Ln(ACCURACY));
        log2 = spy(new Log(ACCURACY, 2));
        log3 = spy(new Log(ACCURACY, 3));
        log5 = spy(new Log(ACCURACY, 5));
        log10 = spy(new Log(ACCURACY, 10));
        taskFunc = new TaskFunc(ACCURACY, csc, ln, log2, log3, log5, log10);
    }
    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/task.csv"
    )
    void testWithPointFromTable(double value, double result) {
        assertEquals(result, taskFunc.compute(value), ACCURACY);

        if (value <= 0) {
            verify(csc, times(1)).compute(value);
            verifyNoInteractions(ln, log2, log3, log5, log10);
        } else {
            verify(log2, times(2)).compute(value);
            verify(log3, times(2)).compute(value);
            verify(log5, times(1)).compute(value);
            verify(log10, times(1)).compute(value);
            verify(ln, times(1)).compute(value);
        }
    }
}
