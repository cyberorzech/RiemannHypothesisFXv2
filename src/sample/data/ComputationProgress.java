package sample.data;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class ComputationProgress {
    @FXML
    private ProgressBar ProgBar;

    public void comp(int iterationsAmount, int currentIterations){
        double x = currentIterations/iterationsAmount;
        System.out.println("Progress is " + x);
        ProgBar.setProgress(x);
    }
}
