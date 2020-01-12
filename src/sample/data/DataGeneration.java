package sample.data;

public class DataGeneration {
    private static double real;
    private static double imagStart;
    private static double imagStep;
    private double imag;

    /**
     * Constructor provides one of two arguments required to compute absolute of Zeta Value
     *
     * @param n - iterator
     */
    public DataGeneration(int n) {
        imag = imagStart + n * imagStep;
    }

    public static double getterReal() {
        return real;
    }

    public double getterImag() {
        return imag;
    }

    public static void randomReal() {
        real = Math.random();
    }

    /**
     * Methods for controller
     */
    public static void setterReal(double realFromTextField) {
        real = realFromTextField;
    }

    public static void setterImagStart(double imagFromTextField) {
        imagStart = imagFromTextField;
    }

    public static void setterImagStep(double imagFromTextField) {
        imagStep = imagFromTextField;
    }

}
