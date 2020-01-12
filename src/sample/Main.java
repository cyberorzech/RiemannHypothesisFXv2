package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.tests.Test;

import java.io.PrintStream;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PrintStream fileOut = new PrintStream("./out.txt");
        System.setOut(fileOut);
        Test.run();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Zeta Function Plotter");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
