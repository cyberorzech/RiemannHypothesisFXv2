package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.data.DataGeneration;
import sample.data.DataValidation;
import sample.data.Initialize;

public class Controller {

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


    private double variable;

    //    event handler dla przyciskow i checkboxa
    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(RealPartChangeButton)){
//            pobiera wartosc z pola
            variable = Double.parseDouble(RealPartTextField.getText());
            DataGeneration.setterReal(variable);
            System.out.println("RealPart Change Button chosen");
        }
        else if (e.getSource().equals(ImgStartChangeButton)){
            variable = Double.parseDouble(ImgStartTextField.getText());
            DataGeneration.setterImagStart(variable);
            System.out.println("Img Start Change Button chosen");
        }
        else if (e.getSource().equals(ImgStepChangeButton)){
            variable = Double.parseDouble(ImgStepTextField.getText());
            DataGeneration.setterImagStep(variable);
            System.out.println("Img Step Change Button chosen");
        }
        else if (e.getSource().equals(IterNoChangeButton)){
            variable = Integer.parseInt(IterNoTextField.getText());
            Initialize.setterIterationsAmount((int) variable);
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
            }
            System.out.println("Checkbox chosen");
        }


        else if (e.getSource().equals(ComputeButton)){
            System.out.println("Compute button has been pressed");
            DataValidation object = new DataValidation();
            if (object.getter()){
                Initialize.setStop(false);
                Initialize.computationInit();
            }
        }
        else if (e.getSource().equals(StopButton)){
            Initialize.setStop(true);
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
    }
}
