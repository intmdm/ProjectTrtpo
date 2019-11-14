package Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Window window = new Window();

        window.addAddBatton("Add task", 0, 0);
        window.addParagraph(5);
        window.addTextField("Введите название задачи", 280,0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
