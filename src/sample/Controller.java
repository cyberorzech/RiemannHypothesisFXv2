package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.data.DataGeneration;
import sample.data.DataToChart;
import sample.data.DataValidation;
import sample.data.Initialize;

import java.io.FileNotFoundException;
import java.io.PrintStream;

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
    private ProgressBar bar;
    @FXML
    private ChoiceBox<String> choiceBox;


    //    event handler dla przyciskow i checkboxa

    /**
     * gygyjhjhhj
     * @param e
     */
    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(realPartChangeButton)){
            if (DataValidation.realPartCheck(Double.parseDouble(realPartTextField.getText()))){
                setGreen(realPartTextField);
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
                setGreen(imgStepTextField);
                DataGeneration.setterImagStep(Double.parseDouble(imgStepTextField.getText()));
            }
            else
                imgStepTextField.setText("Invalid data.");
            System.out.println("Img Step Change Button chosen");
        }
        else if (e.getSource().equals(iterNoChangeButton)){
            if (DataValidation.iterNoCheck(Double.parseDouble(iterNoTextField.getText()))){
                Initialize.setterIterationsAmount(Integer.parseInt(iterNoTextField.getText()));
                setGreen(iterNoTextField);
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
                setGreen(realPartTextField);
            }
            System.out.println("Checkbox chosen");
        }


        else if (e.getSource().equals(computeButton)){
            System.out.println("Compute button has been pressed");
            DataToChart.eraseData();
            //DataToChart.showData();                                       tu mozesz pokazac blad odczytu - dane sa czyszczone
            Initialize.computationInit();
            try{
                zetaChart.getData().add(DataToChart.series);
            }
            catch (IllegalArgumentException ex){
                System.out.println("ex");
            }
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
                    setRed(realPartTextField);
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(imgStepTextField)){
            System.out.println("imgStepTextField chosen");
            switch (e.getCode()){
                case BACK_SPACE:
                    setRed(imgStepTextField);
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(iterNoTextField)){
            switch (e.getCode()){
                case BACK_SPACE:
                    setRed(iterNoTextField);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void onMouseClicked(MouseEvent e) throws FileNotFoundException {
        PrintStream fileOut = new PrintStream("./out.txt");
        System.setOut(fileOut);
        System.out.println(" ");

//        System.out.println(e.getX());
//        DataToChart object = new DataToChart();
//        object.showData();
//        System.out.println(xAxis.getDisplayPosition(object.iks));
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

        setGreen(realPartTextField);
        setGreen(imgStartTextField);
        setGreen(imgStepTextField);
        setGreen(iterNoTextField);


    }

    /*@FXML
    public static void computationProgress(int iterationsAmount, int currentIterations){
        double progress = (double)(currentIterations/iterationsAmount);
        ProgBar.setProgress(progress);
    }*/
    private void setGreen(TextField field){
        field.setStyle("-fx-text-inner-color: green;");
    }
    private void setRed(TextField field){
        field.setStyle("-fx-text-inner-color: red;");
    }
    public void setBarProgress(ProgressBar b){
        b.setProgress(Initialize.progress);
    }
}