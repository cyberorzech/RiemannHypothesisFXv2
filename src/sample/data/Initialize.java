package sample.data;

import org.apache.commons.math3.complex.Complex;

public class Initialize {
    private static int iterationsAmount;
    private static boolean stop;

    public Initialize(){
        iterationsAmount = 0;
        System.out.println("Data model has been initialized successfully.");
    }

    public static void computationInit(){
        int currentIterations = 0;
        while (iterationsAmount > currentIterations && !stop)
        {
            DataGeneration data = new DataGeneration(currentIterations);
            Complex z = new Complex(data.getterReal(), data.getterImag());
            ZetaValue value = new ZetaValue(z, currentIterations);
            System.out.println(currentIterations + ". For input z = " + z + " value of Zeta is: " + value.getter());

            //generowanie danych
            //obliczenia
            //zapisanie danych w pliku

            //popraw wyswietlanie iteracji z najmniejsza wartoscia bezwzgledna
            ++currentIterations;

            //System.out.print(ZetaValue.leastAbsValue);
            //System.out.print(" " + ZetaValue.whichIterationLeastAbsValueHappened);
        }
        stop = false;
    }


//    metody do obslugi zdarzen
    public static void setterIterationsAmount(int iterationsNoTextField){
        iterationsAmount = iterationsNoTextField;
    }
    public static int iterationsAmountGetter(){
        return iterationsAmount;
    }
    public static void setStop(boolean value){
        stop = value;
    }
}
