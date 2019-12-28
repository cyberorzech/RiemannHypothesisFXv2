package sample.data;

public class DataGeneration {
    private static double real;
    private double imag = 0.01;
    private static final double divisionConstant = 100.0;

    public DataGeneration(int n){
        if (n == 0)
            real = Math.random();
        imag += n/divisionConstant;
    }
    public double getterReal()
    {
        return real;
    }
    public double getterImag()
    {
        return imag;
    }
}
