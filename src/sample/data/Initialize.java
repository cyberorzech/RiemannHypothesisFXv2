package sample.data;

import org.apache.commons.math3.complex.Complex;

public class Initialize {
    private static int iterationsAmount = 1;
    private static int currentIterations = 0;
    public static double progress = (double) currentIterations / iterationsAmount;

    /**
     * Starting computation method repeated iterationsAmount times (as requested by user).
     * Creates objects with input arguments and the results then passes to DataToChart class.
     */
    public static void computationInit() {
        while (iterationsAmount > currentIterations) {
            DataGeneration data = new DataGeneration(currentIterations);
            Complex z = new Complex(DataGeneration.getterReal(), data.getterImag());
            ZetaValue value = new ZetaValue(z);
            System.out.println(currentIterations + ". For input z = " + z + " value of Zeta is: " + value.getter() + " with absolute value equals to: " + value.absoluteValueGetter());
            DataToChart.addData(value, data);
            ++currentIterations;
        }
        currentIterations = 0;
    }


    /**
     * Method accessed by Controller
     */
    public static void setterIterationsAmount(int iterationsNoTextField) {
        iterationsAmount = iterationsNoTextField;
    }
}
