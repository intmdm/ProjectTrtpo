package Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setScene(new Scene(root1, 300, 300));
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 550, 300);

        GridPane gridpane = new GridPane();

        Window window = new Window(scene, primaryStage, gridpane);

        window.addStopWatch(gridpane, "+", 0,0);
        //window.addParagraph(25);
        window.addTextField(1,0, 1, 1);

        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
