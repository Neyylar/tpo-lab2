package math.unit.trigonometry;

import math.MathFunc;

public class Csc extends MathFunc {
    private final Sin sinFunc;
    public Csc(double accuracy) {
        super(accuracy);
        this.sinFunc = new Sin(accuracy);
    }

    public Csc(double accuracy, Sin sin) {
        super(accuracy);
        this.sinFunc = sin;
    }

    @Override
    public double compute(double x) {
        return 1 / sinFunc.compute(x);
    }
}
