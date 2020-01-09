package sample.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class View {

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


}
