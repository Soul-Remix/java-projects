package com.example.multiple;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(new Label("First View!"));
        Button paneButton = new Button("Go to Second View");
        pane.setCenter(paneButton);
        Scene firstView = new Scene(pane);

        VBox vBox = new VBox();
        Button vBoxButton = new Button("Go to Third View");
        vBox.getChildren().add(vBoxButton);
        vBox.getChildren().add(new Label("Second View"));
        Scene secondView = new Scene(vBox);

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Third View"), 0, 0);
        Button gridButton = new Button("To the first view");
        gridPane.add(gridButton, 1, 1);
        Scene thirdView = new Scene(gridPane);

        paneButton.setOnAction(event -> {
            primaryStage.setScene(secondView);
        });

        vBoxButton.setOnAction(event -> {
            primaryStage.setScene(thirdView);
        });

        gridButton.setOnAction(event -> {
            primaryStage.setScene(firstView);
        });
        primaryStage.setTitle("Multiple views!");
        primaryStage.setScene(firstView);
        primaryStage.show();
    }
}
