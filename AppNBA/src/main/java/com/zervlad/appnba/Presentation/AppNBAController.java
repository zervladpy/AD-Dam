package com.zervlad.appnba.Presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppNBAController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}