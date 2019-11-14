package Code;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends GridPane {

    FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
    Scene scene = new Scene(root, 300, 300);
    Stage primaryStage = new Stage();

    public Window() {
        super();

        root.setPadding(new Insets(10));

        primaryStage.setTitle("Time Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addAddBatton(String name, int i, int i1) {  //Добавляет кнопку добавления и вызывает addTaskButton

        Button Button = new Button(name);
        root.getChildren().add(Button);

        Button.setOnAction(new EventHandler<ActionEvent>() { //
            public void handle(ActionEvent e) {

            }
        });
    }

    public void addTaskBatton(String name, int i, int i1) {  //Добавляет кнопку секундомера и запускает останавливает таймер(вызывает startStopWatch/stop)

    }

        public void addLabel(String name, int i, int i1) {

        Label label = new Label("  " + name);
        setConstraints(label, i, i1);

        root.getChildren().add(label);
    }

    public void addTextField(String name, int i, int i1) {

        TextField textField = new TextField(name);
        textField.setPrefHeight(i1);
        textField.setPrefWidth(i);

        root.getChildren().add(textField);

    }
    public void addParagraph(int n) {
        for (int i = 0; i < n; i++) {
            Text text = new Text("\n");

            root.getChildren().add(text);
        }
    }
}
