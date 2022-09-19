package functions.trigonometry;

import functions.MathFunc;
import functions.logarithm.Ln;

public class Csc extends MathFunc {
    private final Sin sinFunc;
    public Csc(double accuracy) {
        super(accuracy);
        this.sinFunc = new Sin(accuracy);
    }

    @Override
    public double compute(double x) {
        return 1 / sinFunc.compute(x);
    }
}
