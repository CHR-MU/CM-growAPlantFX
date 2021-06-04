/*This program if it gets finalized is more or less simulated plant as Tamagotchi
* because this is allot to implement for a Java Foundation Final Project, the project
* will be submitted on an earlier phase
* The submission should fulfill the required tasks, but the program is in a very early phase*/

package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public static Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {

        ImageHandler myImages = new ImageHandler();
        primaryStage.setTitle("Grow a Plant - The easy as cake version");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
