package functions.logarithm;

import functions.MathFunc;

import java.text.DecimalFormat;

public class Log extends MathFunc {
    private final Ln lnFunc;
    private final int basis;

    public Log(double accuracy, int basis) {
        super(accuracy);
        this.lnFunc = new Ln(accuracy);
        this.basis = basis;
    }

    @Override
    public double compute(double x) {
        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return lnFunc.compute(x) / lnFunc.compute(basis);
    }
}