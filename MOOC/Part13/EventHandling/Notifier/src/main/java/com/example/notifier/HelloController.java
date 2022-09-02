package com.example.notifier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class HelloController {
    public Label textLabel;
    public TextArea textArea;

    @FXML
    public void onUpdateClicked(ActionEvent actionEvent) {
        textLabel.setText(textArea.getText());
    }
}