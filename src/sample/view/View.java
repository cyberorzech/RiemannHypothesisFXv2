package sample.view;

import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.data.DataToChart;

public class View {
    public void setGreen(TextField field) {
        field.setStyle("-fx-text-inner-color: green;");
    }

    public void setRed(TextField field) {
        field.setStyle("-fx-text-inner-color: red;");
    }

    public void setText(TextField field, String s) {
        field.setText(s);
    }

    public boolean isSelected(CheckBox checkBox) {
        return checkBox.isSelected();
    }

    public void setDisable(Button button, boolean arg) {
        button.setDisable(arg);
    }

    public void setOpacity(TextField field, double opacityLevel) {
        field.setOpacity(opacityLevel);
    }

    public void setEditable(TextField field, boolean arg) {
        field.setEditable(arg);
    }

    public void addDataToChart(LineChart<Number, Number> chart) {
        chart.getData().add(DataToChart.series);
    }
}
