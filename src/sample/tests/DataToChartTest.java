package sample.tests;

import javafx.scene.chart.XYChart;
import org.testng.Assert;
import sample.data.DataToChart;

class DataToChartTest extends Test {

    @org.testng.annotations.Test
    void addData() {
        DataToChart.series.getData().add(new XYChart.Data<>(randomNumber(), randomNumber()));
        Assert.assertNotNull(DataToChart.series);
        DataToChart.eraseData();
        Assert.assertNull(DataToChart.series);
    }

    double randomNumber() {
        return Math.random();
    }
}