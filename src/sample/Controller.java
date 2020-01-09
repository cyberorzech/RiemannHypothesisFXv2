package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sample.data.DataGeneration;
import sample.data.DataToChart;
import sample.data.DataValidation;
import sample.data.Initialize;

public class Controller {

    @FXML
    private Pane Pejn;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart<Number, Number> zetaChart;
    @FXML
    private Button realPartChangeButton;
    @FXML
    private Button imgStartChangeButton;
    @FXML
    private Button imgStepChangeButton;
    @FXML
    private Button iterNoChangeButton;
    @FXML
    private Button computeButton;
    @FXML
    private Button stopButton;
    @FXML
    private CheckBox realPartCheckbox;
    @FXML
    private TextField realPartTextField;
    @FXML
    private TextField imgStartTextField;
    @FXML
    private TextField imgStepTextField;
    @FXML
    private TextField iterNoTextField;
    @FXML
    private ProgressBar ProgBar;


    //    event handler dla przyciskow i checkboxa
    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(realPartChangeButton)){
            if (DataValidation.realPartCheck(Double.parseDouble(realPartTextField.getText()))){
                realPartTextField.setStyle("-fx-text-inner-color: green;");
                DataGeneration.setterReal(Double.parseDouble(realPartTextField.getText()));
            }
            else {
                realPartTextField.setText("Invalid data.");
            }
            System.out.println("RealPart Change Button chosen");
        }
        else if (e.getSource().equals(imgStartChangeButton)){
            DataGeneration.setterImagStart(Double.parseDouble(imgStartTextField.getText()));
            System.out.println("Img Start Change Button chosen");
        }
        else if (e.getSource().equals(imgStepChangeButton)){
            if (DataValidation.imgStepCheck(Double.parseDouble(imgStepTextField.getText()))){
                imgStepTextField.setStyle("-fx-text-inner-color: green;");
                DataGeneration.setterImagStep(Double.parseDouble(imgStepTextField.getText()));
            }
            else
                imgStepTextField.setText("Invalid data.");
            System.out.println("Img Step Change Button chosen");
        }
        else if (e.getSource().equals(iterNoChangeButton)){
            if (DataValidation.iterNoCheck(Double.parseDouble(iterNoTextField.getText()))){
                Initialize.setterIterationsAmount(Integer.parseInt(iterNoTextField.getText()));
                iterNoTextField.setStyle("-fx-text-inner-color: green;");
            }
            else
                iterNoTextField.setText("Invalid data.");
            System.out.println("Iter No Change Button Chosen");
        }
        else if(e.getSource().equals(realPartCheckbox)){
            if (!realPartCheckbox.isSelected()){
                realPartChangeButton.setDisable(false);
                realPartTextField.setOpacity(1.0);
                realPartTextField.setEditable(true);
            }
            else{
                realPartChangeButton.setDisable(true);
                DataGeneration.randomReal();
                realPartTextField.setText(Double.toString(DataGeneration.getterReal()));
                realPartTextField.setOpacity(0.5);
                realPartTextField.setEditable(false);
                realPartTextField.setStyle("-fx-text-inner-color: green;");
            }
            System.out.println("Checkbox chosen");
        }


        else if (e.getSource().equals(computeButton)){
            System.out.println("Compute button has been pressed");
            Initialize.computationInit();
            //DataToChart.addData();
            zetaChart.getData().add(DataToChart.series);
        }
        else if (e.getSource().equals(stopButton)){
            Initialize.setStop(true);
        }
    }

    //event handler dla wciskanych klawiszy
    @FXML
    public void onKeyPressed(KeyEvent e){
        if (e.getSource().equals(realPartTextField)){
            switch (e.getCode()){
                case BACK_SPACE:
                    realPartTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(imgStepTextField)){
            System.out.println("Wcisnales imgstep");
            switch (e.getCode()){
                case BACK_SPACE:
                    imgStepTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(iterNoTextField)){
            switch (e.getCode()){
                case BACK_SPACE:
                    iterNoTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void initialize(){
        realPartChangeButton.setDisable(true);
        DataGeneration.randomReal();
        realPartTextField.setText(Double.toString(DataGeneration.getterReal()));
        realPartTextField.setEditable(false);
        realPartTextField.setOpacity(0.5);
        DataGeneration.setterImagStart(Double.parseDouble(imgStartTextField.getText()));
        DataGeneration.setterImagStep(Double.parseDouble(imgStepTextField.getText()));
        Initialize.setterIterationsAmount(Integer.parseInt(iterNoTextField.getText()));

        realPartTextField.setStyle("-fx-text-inner-color: green;");
        imgStartTextField.setStyle("-fx-text-inner-color: green;");
        imgStepTextField.setStyle("-fx-text-inner-color: green;");
        iterNoTextField.setStyle("-fx-text-inner-color: green;");
        //ProgBar.setProgress(0.0);
    }

    /*@FXML
    public static void computationProgress(int iterationsAmount, int currentIterations){
        double progress = (double)(currentIterations/iterationsAmount);
        ProgBar.setProgress(progress);
    }*/
}