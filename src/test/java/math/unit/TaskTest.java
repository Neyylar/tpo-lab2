package math.unit;

import math.TaskFunc;
import math.unit.logarithm.Ln;
import math.unit.logarithm.Log;
import math.unit.trigonometry.Csc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskTest {
    private static final double ACCURACY = 0.01;
    private static Csc csc;
    private static Ln ln;
    private static Log log2, log3, log5, log10;
    private static TaskFunc taskFunc;
    private static Log createLogMock(double base) {
        Log logToMock = mock(Log.class);
        when(logToMock.compute(anyDouble())).thenAnswer(i -> Math.log(i.getArgument(0))/Math.log(base));
        return logToMock;
    }

    @BeforeAll
    public static void init() {
        csc = mock(Csc.class);
        when(csc.compute(anyDouble())).thenAnswer(i -> 1/Math.sin(i.getArgument(0)));
        when(csc.compute(doubleThat(arg -> (Math.abs(Math.sin(arg) % Math.PI) < 1.0e-10)))).thenReturn(Double.POSITIVE_INFINITY);
        ln = mock(Ln.class);
        when(ln.compute(anyDouble())).thenAnswer(i -> Math.log(i.getArgument(0)));
        log2 = createLogMock(2);
        log3 = createLogMock(3);
        log5 = createLogMock(5);
        log10 = createLogMock(10);
        taskFunc = new TaskFunc(ACCURACY, csc, ln, log2, log3, log5, log10);
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "src/test/resources/math/task.csv"
    )
    void testWithPointFromTable(double value, double result){
        assertEquals(result, taskFunc.compute(value), ACCURACY);
    }
}
