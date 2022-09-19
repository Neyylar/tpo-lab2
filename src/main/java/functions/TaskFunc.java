package functions;

import functions.logarithm.Ln;
import functions.logarithm.Log;
import functions.trigonometry.Csc;

public class TaskFunc extends MathFunc {
    private final MathFunc csc, ln, log2, log3, log5, log10;

    public TaskFunc(double accuracy) {
        super(accuracy);
        this.csc = new Csc(accuracy);
        this.ln = new Ln(accuracy);
        this.log2 = new Log(accuracy, 2);
        this.log3 = new Log(accuracy, 3);
        this.log5 = new Log(accuracy, 5);
        this.log10 = new Log(accuracy, 10);
    }

    public TaskFunc(double accuracy, Csc csc, Ln ln, Log log2, Log log3, Log log5, Log log10) {
        super(accuracy);
        this.csc = csc;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public double compute(double x) {
        if (x <= 0) {
            return csc.compute(x);
        } else {
            return (((log5.compute(x) - log2.compute(x) - log10.compute(x))
                    * (log3.compute(x) + log2.compute(x)))
                    + log3.compute(x) * ln.compute(x));
        }
    }
}
