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

import java.io.IOException;
import java.util.*;

public class Window extends GridPane {

    FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
    Scene scene;
    Stage primaryStage;
    GridPane gridpane;
    TextField textField = new TextField("Введите название задачи");
    int count = 0, flag = 0;
    String time;

    StopWatch[] stopWatchSet = new StopWatch[10];

    public Window(Scene _scene, Stage _primaryStage, GridPane _gridpane) {
        super();

        scene = _scene;
        primaryStage = _primaryStage;
        gridpane = _gridpane;

        root.setPadding(new Insets(10));

        primaryStage.setTitle("Time Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addButton(GridPane gridpane, String nameButton, int posX, int posY) throws IOException {
        Button Button = new Button(nameButton);
        gridpane.add(Button, posX, posY, 1, 1);

        StopWatch stopWatch = new StopWatch(nameButton);
        stopWatchSet[count] = stopWatch;
        if (count > 2) {
            stopWatchSet[count - 1].save();
        }

        Button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                System.out.println("Кнопка");
                if (flag == 0) {
                    time = stopWatch.Start();
                    flag = 1;
                    addLabel(gridpane, time, posX + 1, posY);
                    System.out.println("Старт");
                } else {
                    String nameLabel = stopWatch.Stop();

                    int mas[] = new int[9];

                    mas[3] = (nameLabel.charAt(11) - '0') * 10 + (nameLabel.charAt(12) - '0');
                    mas[4] = (nameLabel.charAt(14) - '0') * 10 + (nameLabel.charAt(15) - '0');
                    mas[5] = (nameLabel.charAt(17) - '0') * 10 + (nameLabel.charAt(18) - '0');

                    mas[0] = (time.charAt(11) - '0') * 10 + (time.charAt(12) - '0');
                    mas[1] = (time.charAt(14) - '0') * 10 + (time.charAt(15) - '0');
                    mas[2] = (time.charAt(17) - '0') * 10 + (time.charAt(18) - '0');

                    if (mas[5] < mas[2]) {
                        mas[5] += 60;
                        mas[4] -= 1;
                    }
                    mas[8] = mas[5] - mas[2];

                    if (mas[4] < mas[1]) {
                        mas[4] += 60;
                        mas[3] -= 1;
                    }
                    mas[7] = mas[4] - mas[1];
                    mas[6] = mas[3] - mas[0];

                    String temp = new String("");

                    System.out.println("Стоп");

                    temp += mas[6];
                    temp += ":";
                    temp += mas[7];
                    temp += ":";
                    temp += mas[8];

                    stopWatch.sec += mas[8];
                    stopWatch.min += mas[7];
                    stopWatch.hours += mas[6];

                    if (stopWatch.sec >= 60) {
                        stopWatch.sec -= 60;
                        stopWatch.min += 1;
                    }

                    if (stopWatch.min >= 60) {
                        stopWatch.min -= 60;
                        stopWatch.hours += 1;
                    }

                    temp = "";
                    temp += stopWatch.hours;
                    temp += ":";
                    temp += stopWatch.min;
                    temp += ":";
                    temp += stopWatch.sec;

                    addLabel(gridpane, temp, posX + 30 * stopWatch.n, posY);
                    stopWatch.n += 1;

                    flag = 0;
                }
            }
        });
    }

    public void addStopWatch(GridPane gridpane, String nameButton, int posX, int posY) {
        Button Button1 = new Button(nameButton);
        gridpane.add(Button1, posX, posY, 1, 1);

        Button1.setOnAction(new EventHandler<ActionEvent>() { //
            public void handle(ActionEvent e) {
                //int count = Integer.parseInt(textField.getText());
                count += 1;
                try {
                    addButton(gridpane, textField.getText(), posX + 1,posY + count);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public void addButton(GridPane gridpane, String nameButton, String nameLabel, int posX, int posY, int posL) {
        Button Button = new Button(nameButton);
        gridpane.add(Button, posX, posY, 1, 1);

        Button.setOnAction(new EventHandler<ActionEvent>() { //
            public void handle(ActionEvent e) {
                addLabel(gridpane, nameLabel, posX, posY + 1 + posL);
            }
        });
    }
    public Button addButtonM(GridPane gridpane, String nameButton, String nameLabel, int posX, int posY) {

        Button Button = new Button(nameButton);
        gridpane.add(Button, posX, posY, 1, 1);

        addLabel(gridpane, nameLabel, posX, posY + 1);

        return Button;
    }

    public void addButtonD(GridPane gridpane, String nameButton, String nameLabel, int posX, int posY) {
        Button Button = new Button(nameButton);
        gridpane.add(Button, posX, posY, 1, 1);

        Button.setOnAction(new EventHandler<ActionEvent>() { //
            public void handle(ActionEvent e) {
                Label label = addLabel(gridpane, nameLabel, posX, posY + 1);

                gridpane.getChildren().remove(Button);
            }
        });
    }

    public Label addLabel(GridPane gridpane, String name, int i1, int i2) {
        gridpane.add(new Label(), i1, i2);
        Label label = new Label("  " + name);
        GridPane.setConstraints(label, i1, i2);

        gridpane.getChildren().addAll(label);

        return label;
    }


    public void addTextField(int i, int i1, int x, int y) {

        textField.setPrefHeight(i1);
        textField.setPrefWidth(i);

        gridpane.add(textField, i, i1, x, y);
        //gridpane.getChildren().addAll(textField);

    }
    public void addParagraph(int n) {
        for (int i = 0; i < n; i++) {
            Text text = new Text("\n");

            root.getChildren().add(text);
        }
    }

//    public void Update() {
//
//        gridpane.getChildren().removeAll();
//
//        //addStopWatch(gridpane, "+", 0,0);
//        //addTextField(1,0, 1, 1);
//
//        int temp = count + 1;
//
//        while (temp < count) {
//            addButton(gridpane, textField.getText(), temp + 1,temp + count);
//            temp += 1;
//        }
//
//    }
}
