package math.trigonometry;

import math.MathFunc;

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
