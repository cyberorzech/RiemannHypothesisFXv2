package sample.data;

import org.apache.commons.math3.complex.Complex;

public class Initialize {
    private final int iterationsAmount = 1000;

    public Initialize(){
        int currentIterations = 0;
        while (this.iterationsAmount > currentIterations)
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
    }
}
