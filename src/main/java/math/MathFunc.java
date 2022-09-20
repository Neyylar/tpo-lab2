package math;

public abstract class MathFunc {
    private final double accuracy;

    public MathFunc(double accuracy) {
        this.accuracy = accuracy;
    }

    public abstract double compute(double x);

    public double getAccuracy() {
        return accuracy;
    }
}
