package sample.data;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DataToChart {
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    public static double iks;
    public static XYChart.Series<Number, Number> series = new XYChart.Series<>();

    public static void addData(ZetaValue value, DataGeneration data){
        series.setName("x = img part y = absolute value");
        //populating the series with data
        series.getData().add(new XYChart.Data<>(data.getterImag(), value.absoluteValueGetter()));
    }
    public static void eraseData(){
        series.getData().clear();
    }
    public static void showData(){
        double x = series.getData().get(2).getXValue().doubleValue(); //pobiera wspolrzedna jako double
        System.out.println("Wspolrzedna x pobrana: " + x);
        //iks = x;
        //double[] tablica = new double[3];
        //double displayPosition = yAxis.getDisplayPosition(x);
        //System.out.println(displayPosition);




    }
}
