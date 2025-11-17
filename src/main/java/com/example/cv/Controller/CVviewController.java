package com.example.cv.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
}
