package com.example.cv.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CVviewController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label ageLabel;

    // Method to receive data
    public void setData(String name, String age) {
        nameLabel.setText(name);
        ageLabel.setText(age);
    }
}
