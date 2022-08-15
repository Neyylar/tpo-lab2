package functions.trigonometry;

import functions.MathFunc;

public class Sin extends MathFunc {
    private final Csc cscFunction;

    public Sin(double accuracy, Csc cosFunction) {
        super(accuracy);
        this.cscFunction = cosFunction;
    }

    @Override
    public double compute(double x) {
        int period = (int) (x / (Math.PI * 2));
        x -= period * Math.PI *2;

        int sign;

        if((x > Math.PI && x < Math.PI * 2) || (x < 0.0 && x > -Math.PI)) {
            sign = -1;
        } else {
            sign = 1;
        }

        return sign * Math.sqrt(1 - Math.pow(cscFunction.compute(x), 2));
    }
}