package sample.data;

import javafx.scene.chart.XYChart;

public class DataToChart {
    public static XYChart.Series<Number, Number> series = new XYChart.Series<>();

    /**
     * Populating series with data
     *
     * @param value object containing complex number - the result
     * @param data  object containing argument
     */
    public static void addData(ZetaValue value, DataGeneration data) {
        series.setName("x = img part y = absolute value");
        series.getData().add(new XYChart.Data<>(data.getterImag(), value.absoluteValueGetter()));
    }

    public static void eraseData() {
        series.getData().clear();
    }
}
