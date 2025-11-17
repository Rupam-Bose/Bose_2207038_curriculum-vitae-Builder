package com.example.cv.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.lang.model.element.Name;
import java.io.File;

public class CVcontroller {
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    TextField address;
    @FXML
    TextField education;
    @FXML
    TextField skills;
    @FXML
    TextField worksExperience;
    @FXML
    TextField projects;
    @FXML
    ImageView previewImage;

    private Image uploadedImage; // store selected image

    // ------------------------ UPLOAD IMAGE BUTTON ------------------------
    @FXML
    private void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Your Photo");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            uploadedImage = new Image(file.toURI().toString());

            // show preview in UI (optional)
            if (previewImage != null) {
                previewImage.setImage(uploadedImage);
            }
        }
    }
    @FXML
    private void GenerateCV(ActionEvent event) throws Exception {

        String Name = name.getText();
       String Email = email.getText();
        String Phone = phone.getText();
        String Address = address.getText();
        String Education = education.getText();
        String Skills = skills.getText();
        String WorksExperience = worksExperience.getText();
        String Projects = projects.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CVview.fxml"));
        Parent root = loader.load();

        // Pass data to second controller
        CVviewController controller = loader.getController();
        controller.setData(Name,Phone,Email,Address,Education,Skills,WorksExperience,Projects,uploadedImage);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();

    }
}
