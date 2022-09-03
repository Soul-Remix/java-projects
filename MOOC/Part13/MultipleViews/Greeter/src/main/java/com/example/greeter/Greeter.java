package com.example.greeter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Greeter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(240, 240);

        VBox box = new VBox();
        box.setSpacing(10);
        Label text = new Label("Enter your name and start");
        TextField field = new TextField();
        Button startBtn = new Button("Start");
        box.getChildren().addAll(text, field, startBtn);

        layout.setCenter(box);
        Scene firstView = new Scene(layout);

        BorderPane layout2 = new BorderPane();
        layout2.setPrefSize(240, 240);
        layout2.setCenter(new Label("Welcome " + field.getText()));

        Scene secondView = new Scene(layout2);

        startBtn.setOnAction(event -> {
            primaryStage.setScene(secondView);
        });

        primaryStage.setTitle("Greeter");
        primaryStage.setScene(firstView);
        primaryStage.show();
    }
}
