package functions.trigonometry;

import functions.MathFunc;

public class Sin extends MathFunc {

    public Sin(double accuracy) {
        super(accuracy);
    }

    @Override
    public double compute(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        if (Double.isNaN(getAccuracy()) || Math.abs(getAccuracy()) < 1E-6) {
            throw new IllegalArgumentException("Accuracy is too small or NaN");
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
        } while (Math.abs(delta) > Math.abs(getAccuracy()));

        return result;
    }
}