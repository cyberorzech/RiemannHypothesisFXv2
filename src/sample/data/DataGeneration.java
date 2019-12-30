package sample.data;

public class DataGeneration {
    private static double real;
    private static double imagStart;
    private static double imagStep;
    private double imag = 0.0;

    public DataGeneration(int n){
        imag = imagStart + n*imagStep;
    }
    public static double getterReal()
    {
        return real;
    }
    public double getterImag()
    {
        return imag;
    }
    public static void randomReal(){
        real = Math.random();
    }

//    metody do obsługi zdarzeń
    public static void setterReal(double realFromTextField){
        real = realFromTextField;
    }
    public static void setterImagStart(double imagFromTextField){
        imagStart = imagFromTextField;
    }
    public static void setterImagStep(double imagFromTextField){
        imagStep = imagFromTextField;
    }
    public static double getterimagStart(){
        return imagStart;
    }
    public static double getterimagStep(){
        return imagStep;
    }

}
