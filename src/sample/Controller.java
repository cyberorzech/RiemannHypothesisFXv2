package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import sample.data.DataGeneration;
import sample.data.DataToChart;
import sample.data.DataValidation;
import sample.data.Initialize;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private Pane Pejn;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart<Number, Number> ZetaChart;
    @FXML
    private Button RealPartChangeButton;
    @FXML
    private Button ImgStartChangeButton;
    @FXML
    private Button ImgStepChangeButton;
    @FXML
    private Button IterNoChangeButton;
    @FXML
    private Button ComputeButton;
    @FXML
    private Button StopButton;
    @FXML
    private CheckBox RealPartCheckbox;
    @FXML
    private TextField RealPartTextField;
    @FXML
    private TextField ImgStartTextField;
    @FXML
    private TextField ImgStepTextField;
    @FXML
    private TextField IterNoTextField;
    @FXML
    private ProgressBar ProgBar;


    //    event handler dla przyciskow i checkboxa
    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(RealPartChangeButton)){
            if (DataValidation.realPartCheck(Double.parseDouble(RealPartTextField.getText()))){
                RealPartTextField.setStyle("-fx-text-inner-color: green;");
                DataGeneration.setterReal(Double.parseDouble(RealPartTextField.getText()));
            }
            else {
                RealPartTextField.setText("Invalid data.");
            }
            System.out.println("RealPart Change Button chosen");
        }
        else if (e.getSource().equals(ImgStartChangeButton)){
            DataGeneration.setterImagStart(Double.parseDouble(ImgStartTextField.getText()));
            System.out.println("Img Start Change Button chosen");
        }
        else if (e.getSource().equals(ImgStepChangeButton)){
            if (DataValidation.imgStepCheck(Double.parseDouble(ImgStepTextField.getText()))){
                ImgStepTextField.setStyle("-fx-text-inner-color: green;");
                DataGeneration.setterImagStep(Double.parseDouble(ImgStepTextField.getText()));
            }
            else
                ImgStepTextField.setText("Invalid data.");
            System.out.println("Img Step Change Button chosen");
        }
        else if (e.getSource().equals(IterNoChangeButton)){
            if (DataValidation.iterNoCheck(Double.parseDouble(IterNoTextField.getText()))){
                Initialize.setterIterationsAmount(Integer.parseInt(IterNoTextField.getText()));
                IterNoTextField.setStyle("-fx-text-inner-color: green;");
            }
            else
                IterNoTextField.setText("Invalid data.");
            System.out.println("Iter No Change Button Chosen");
        }
        else if(e.getSource().equals(RealPartCheckbox)){
            if (!RealPartCheckbox.isSelected()){
                RealPartChangeButton.setDisable(false);
                RealPartTextField.setOpacity(1.0);
                RealPartTextField.setEditable(true);
            }
            else{
                RealPartChangeButton.setDisable(true);
                DataGeneration.randomReal();
                RealPartTextField.setText(Double.toString(DataGeneration.getterReal()));
                RealPartTextField.setOpacity(0.5);
                RealPartTextField.setEditable(false);
                RealPartTextField.setStyle("-fx-text-inner-color: green;");
            }
            System.out.println("Checkbox chosen");
        }


        else if (e.getSource().equals(ComputeButton)){
            System.out.println("Compute button has been pressed");
            Initialize.computationInit();
            DataToChart.addData();
            ZetaChart.getData().add(DataToChart.series);
        }
        else if (e.getSource().equals(StopButton)){
            Initialize.setStop(true);
        }
    }

    //event handler dla wciskanych klawiszy
    @FXML
    public void onKeyPressed(KeyEvent e){
        if (e.getSource().equals(RealPartTextField)){
            switch (e.getCode()){
                case BACK_SPACE:
                    RealPartTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(ImgStepTextField)){
            System.out.println("Wcisnales imgstep");
            switch (e.getCode()){
                case BACK_SPACE:
                    ImgStepTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(IterNoTextField)){
            switch (e.getCode()){
                case BACK_SPACE:
                    IterNoTextField.setStyle("-fx-text-inner-color: red;");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void initialize(){
        RealPartChangeButton.setDisable(true);
        DataGeneration.randomReal();
        RealPartTextField.setText(Double.toString(DataGeneration.getterReal()));
        RealPartTextField.setEditable(false);
        RealPartTextField.setOpacity(0.5);
        DataGeneration.setterImagStart(Double.parseDouble(ImgStartTextField.getText()));
        DataGeneration.setterImagStep(Double.parseDouble(ImgStepTextField.getText()));
        Initialize.setterIterationsAmount(Integer.parseInt(IterNoTextField.getText()));

        RealPartTextField.setStyle("-fx-text-inner-color: green;");
        ImgStartTextField.setStyle("-fx-text-inner-color: green;");
        ImgStepTextField.setStyle("-fx-text-inner-color: green;");
        IterNoTextField.setStyle("-fx-text-inner-color: green;");
    }
}