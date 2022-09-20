package math;

import math.unit.logarithm.Ln;
import math.unit.trigonometry.Csc;
import math.unit.trigonometry.Sin;

public class Main {
    public static void main(String[] args) {

        MathFunc sin = new Sin(0.1);
        System.out.println("Sin");
        System.out.println(sin.compute(Math.PI));
        System.out.println(Math.sin(Math.PI));

        MathFunc csc = new Csc(0.2);
        System.out.println("Csc");
        System.out.println(csc.compute(Math.PI));
        System.out.println(csc.compute(Math.PI/4));
        System.out.println(1/Math.sin(Math.PI/4));

        MathFunc ln = new Ln(0.00000001);
        System.out.println("ln");
        System.out.println(ln.compute(Math.PI));
        System.out.println(Math.log(Math.PI));

        MathFunc task = new TaskFunc(0.001);
        System.out.println("TaskFunc");
        System.out.println(task.compute(-10));

    }
}
