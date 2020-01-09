package sample.data;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import org.apache.commons.math3.complex.Complex;
import sample.Controller;

public class Initialize {
    private static int iterationsAmount = 0;
    private static boolean stop;

    public static void computationInit(){
        int currentIterations = 0;
        while (iterationsAmount > currentIterations && !stop)
        {
            DataGeneration data = new DataGeneration(currentIterations);
            Complex z = new Complex(DataGeneration.getterReal(), data.getterImag());
            DataToChart object = new DataToChart();
            ZetaValue value = new ZetaValue(z, currentIterations);
            System.out.println(currentIterations + ". For input z = " + z + " value of Zeta is: " + value.getter() + "with absolute value equals to: " + value.absoluteValueGetter());
            object.addData(value, data);
            //Controller.computationProgress(iterationsAmount, currentIterations);
            //ComputationProgress object = new ComputationProgress();
            //object.comp(iterationsAmount, currentIterations);
            ++currentIterations;
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
