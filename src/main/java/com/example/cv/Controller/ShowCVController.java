package com.example.cv.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ShowCVController {

    @FXML
    private void openCV(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CV.fxml"));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 800);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void Show(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CVlist.fxml"));

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 800);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
