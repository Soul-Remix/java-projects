package com.example.buttonandtextfield;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label submitText;

    @FXML
    protected void onSubmitClicked() {
        submitText.setText("Submitted successfully");
    }
}