package com.example.cv.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CVmodel {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty education = new SimpleStringProperty();
    private final StringProperty skills = new SimpleStringProperty();
    private final StringProperty workExperience = new SimpleStringProperty();
    private final StringProperty projects = new SimpleStringProperty();
    private final StringProperty imagePath = new SimpleStringProperty();

    public CVmodel() {
    }

    public CVmodel(int id,
                   String name,
                   String email,
                   String phone,
                   String address,
                   String education,
                   String skills,
                   String workExperience,
                   String projects,
                   String imagePath) {
        setId(id);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
        setEducation(education);
        setSkills(skills);
        setWorkExperience(workExperience);
        setProjects(projects);
        setImagePath(imagePath);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String value) {
        phone.set(value);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getEducation() {
        return education.get();
    }

    public void setEducation(String value) {
        education.set(value);
    }

    public StringProperty educationProperty() {
        return education;
    }

    public String getSkills() {
        return skills.get();
    }

    public void setSkills(String value) {
        skills.set(value);
    }

    public StringProperty skillsProperty() {
        return skills;
    }

    public String getWorkExperience() {
        return workExperience.get();
    }

    public void setWorkExperience(String value) {
        workExperience.set(value);
    }

    public StringProperty workExperienceProperty() {
        return workExperience;
    }

    public String getProjects() {
        return projects.get();
    }

    public void setProjects(String value) {
        projects.set(value);
    }

    public StringProperty projectsProperty() {
        return projects;
    }

    public String getImagePath() {
        return imagePath.get();
    }

    public void setImagePath(String value) {
        imagePath.set(value);
    }

    public StringProperty imagePathProperty() {
        return imagePath;
    }
}
