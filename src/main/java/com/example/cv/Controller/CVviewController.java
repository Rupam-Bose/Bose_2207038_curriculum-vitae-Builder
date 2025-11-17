package com.example.cv.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CVviewController {
    @FXML
    private Label CVname;

    @FXML
    private Label mail;

    @FXML
    private Label phnnmbr;
    @FXML
    private Label Name;
    @FXML
    private Label Email;
    @FXML
    private Label Phone;
    @FXML
    private Label Address;
    @FXML
    private Label Education;
    @FXML
    private Label Skills;
    @FXML
    private Label WorksExperience;
    @FXML
    private Label Projects;
    @FXML
    private ImageView profileImageView;
    @FXML
    public void setData(String name, String phone , String email, String address, String education, String skills, String worksExperience, String projects, Image image){
        CVname.setText("Curriculum Vitae of "+name);
        mail.setText("Email : "+email);
        phnnmbr.setText("Contact Number : "+phone);
        Name.setText("Name : "+name);
        Email.setText("Email Address : "+email);
        Phone.setText("Contact Number : "+phone);
        Address.setText("Address : "+address);
        Education.setText("Educational Qualifications : "+education);
        Skills.setText("Skills : "+skills);
        WorksExperience.setText("Works Experience : "+worksExperience);
        Projects.setText("Projects : "+projects);
        if (image != null) {
            profileImageView.setImage(image);
        }
    }
    @FXML
    private void CV(ActionEvent event) {
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
}
