package math.unit.logarithm;

import math.MathFunc;

public class Ln extends MathFunc {
    private static final int COUNT_ITERATION = 1000000;
    public Ln(double accuracy) {
        super(accuracy);
    }

    @Override
    public double compute(double x) {
        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (Double.isNaN(getAccuracy())) {
            throw new IllegalArgumentException("Accuracy is NaN");
        }

        double currentValue = 0;
        double previousValue;
        int iteration = 1;

        if (Math.abs(x - 1) <= 1) {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(x - 1, iteration)) / iteration);
                iteration++;
            } while (getAccuracy() <= 1000*Math.abs(currentValue - previousValue) && iteration < COUNT_ITERATION);
        } else {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(x - 1, -iteration)) / iteration);
                iteration++;
            } while (getAccuracy() <= 1000*Math.abs(currentValue - previousValue) && iteration < COUNT_ITERATION);

            currentValue += compute(x - 1);
        }

        return currentValue;
    }
}
