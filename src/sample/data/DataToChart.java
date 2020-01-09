package sample.data;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class DataToChart {
    public static XYChart.Series<Number, Number> series = new XYChart.Series<>();

    public static void addData(ZetaValue value, DataGeneration data){
        //populating the series with data
        series.getData().add(new XYChart.Data<>(data.getterImag(), value.absoluteValueGetter()));
    }
}
