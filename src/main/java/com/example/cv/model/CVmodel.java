package com.example.cv.model;

public class CVmodel {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String education;
    private String skills;
    private String workExperience;
    private String projects;
    private String imagePath;

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
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.skills = skills;
        this.workExperience = workExperience;
        this.projects = projects;
        this.imagePath = imagePath;
    }

    // Getters / setters (needed by TableView & DAO)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getWorkExperience() { return workExperience; }
    public void setWorkExperience(String workExperience) { this.workExperience = workExperience; }

    public String getProjects() { return projects; }
    public void setProjects(String projects) { this.projects = projects; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return "CVmodel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}