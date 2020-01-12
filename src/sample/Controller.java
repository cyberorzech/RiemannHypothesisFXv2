package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.data.DataGeneration;
import sample.data.DataToChart;
import sample.data.DataValidation;
import sample.data.Initialize;
import sample.view.View;

public class Controller {
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
    private CheckBox realPartCheckbox;
    @FXML
    private TextField realPartTextField;
    @FXML
    private TextField imgStartTextField;
    @FXML
    private TextField imgStepTextField;
    @FXML
    private TextField iterNoTextField;

    /**
     * Method handling events (for buttons)
     *
     * @param e event representing button clicked
     */
    @FXML
    public void onButtonClicked(ActionEvent e) {
        View view = new View();
        if (e.getSource().equals(realPartChangeButton)) {
            if (DataValidation.realPartCheck(Double.parseDouble(realPartTextField.getText()))) {
                view.setGreen(realPartTextField);
                DataGeneration.setterReal(Double.parseDouble(realPartTextField.getText()));
            } else {
                view.setText(realPartTextField, "Invalid data.");
                view.setRed(realPartTextField);
            }
            System.out.println("RealPart Change Button chosen");
        } else if (e.getSource().equals(imgStartChangeButton)) {
            DataGeneration.setterImagStart(Double.parseDouble(imgStartTextField.getText()));
            System.out.println("Img Start Change Button chosen");
        } else if (e.getSource().equals(imgStepChangeButton)) {
            if (DataValidation.imgStepCheck(Double.parseDouble(imgStepTextField.getText()))) {
                view.setGreen(imgStepTextField);
                DataGeneration.setterImagStep(Double.parseDouble(imgStepTextField.getText()));
            } else
                view.setText(imgStepTextField, "Invalid data.");
            System.out.println("Img Step Change Button chosen");
        } else if (e.getSource().equals(iterNoChangeButton)) {
            if (DataValidation.iterNoCheck(Double.parseDouble(iterNoTextField.getText()))) {
                Initialize.setterIterationsAmount(Integer.parseInt(iterNoTextField.getText()));
                view.setGreen(iterNoTextField);
            } else
                view.setText(iterNoTextField, "Invalid data.");
            System.out.println("Iter No Change Button Chosen");
        } else if (e.getSource().equals(realPartCheckbox)) {
            if (!view.isSelected(realPartCheckbox)) {
                view.setDisable(realPartChangeButton, false);
                view.setOpacity(realPartTextField, 1.0);
                view.setEditable(realPartTextField, true);
            } else {
                view.setDisable(realPartChangeButton, true);
                DataGeneration.randomReal();
                view.setText(realPartTextField, Double.toString(DataGeneration.getterReal()));
                view.setOpacity(realPartTextField, 0.5);
                view.setEditable(realPartTextField, false);
                view.setGreen(realPartTextField);
            }
            System.out.println("Checkbox chosen");
        } else if (e.getSource().equals(computeButton)) {
            System.out.println("Compute button has been pressed");
            DataToChart.eraseData();
            Initialize.computationInit();
            try {
                view.addDataToChart(zetaChart);
            } catch (IllegalArgumentException ex) {
                System.out.println("ex");
            }
        }
    }

    /**
     * Method handling pressing key events
     *
     * @param e button clicked event
     */
    @FXML
    public void onKeyPressed(KeyEvent e) {
        View view = new View();
        if (e.getSource().equals(realPartTextField)) {
            switch (e.getCode()) {
                case BACK_SPACE:
                    view.setRed(realPartTextField);
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(imgStepTextField)) {
            switch (e.getCode()) {
                case BACK_SPACE:
                    view.setRed(imgStepTextField);
                    break;
                default:
                    break;
            }
        }

        if (e.getSource().equals(iterNoTextField)) {
            switch (e.getCode()) {
                case BACK_SPACE:
                    view.setRed(iterNoTextField);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void initialize() {
        View view = new View();
        view.setDisable(realPartChangeButton, true);
        DataGeneration.randomReal();
        view.setText(realPartTextField, Double.toString(DataGeneration.getterReal()));
        view.setEditable(realPartTextField, false);
        view.setOpacity(realPartTextField, 0.5);
        DataGeneration.setterImagStart(Double.parseDouble(imgStartTextField.getText()));
        DataGeneration.setterImagStep(Double.parseDouble(imgStepTextField.getText()));
        Initialize.setterIterationsAmount(Integer.parseInt(iterNoTextField.getText()));
        view.setGreen(realPartTextField);
        view.setGreen(imgStartTextField);
        view.setGreen(imgStepTextField);
        view.setGreen(iterNoTextField);
    }

    @FXML
    public void onMouseClicked(MouseEvent e){               //Method, although not used, is necessary. Otherwise Java throws an exception

    }
}