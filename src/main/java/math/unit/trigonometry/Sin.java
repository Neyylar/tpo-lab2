package math.unit.trigonometry;

import math.MathFunc;

public class Sin extends MathFunc {

    private static final int COUNT_ITERATION = 1000000;
    public Sin(double accuracy) {
        super(accuracy);
    }

    @Override
    public double compute(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        if (Double.isNaN(getAccuracy())) {
            throw new IllegalArgumentException("Accuracy is NaN");
        }
        x = x % (2 * Math.PI);

        double delta, result = 0.0;
        int step = 1, sign = 1;
        do {
            delta = 1;
            for (int n = 1; n <= step; n++) {
                delta *= x / n;
            }
            step += 2;
            result += sign * delta;
            sign *= -1;
        } while (2*Math.abs(delta) > Math.abs(getAccuracy()) && step/2 < COUNT_ITERATION);

        return result;
    }
}