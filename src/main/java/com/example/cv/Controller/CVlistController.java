package com.example.cv.Controller;

import com.example.cv.dao.CVDao;
import com.example.cv.model.CVmodel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CVlistController {

    @FXML
    private TableView<CVmodel> cvTable;

    @FXML
    private TableColumn<CVmodel, Number> idColumn;

    @FXML
    private TableColumn<CVmodel, String> nameColumn;

    @FXML
    private TableColumn<CVmodel, String> emailColumn;

    @FXML
    private TableColumn<CVmodel, String> phoneColumn;

    private final CVDao cvDao = new CVDao();
    private ObservableList<CVmodel> cvList;

    @FXML
    public void initialize() {
        // bind columns to properties
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

       // cvTable.getSelectionModel().setCellSelectionEnabled(false);
        cvTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        loadData();
    }

    private void loadData() {
        List<CVmodel> all = cvDao.findAll();
        cvList = FXCollections.observableArrayList(all != null ? all : List.of());
        cvTable.setItems(cvList);
    }

    @FXML
    private void onViewClicked(ActionEvent event) {
        CVmodel selected = cvTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("No CV selected", "Please select a CV to view.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CVview.fxml"));
            Parent root = loader.load();

            Image image = null;
            String imagePath = selected.getImagePath();
            if (imagePath != null && !imagePath.isBlank()) {
                File imgFile = new File(imagePath);
                if (imgFile.exists()) {
                    image = new Image(imgFile.toURI().toString());
                }
            }

            CVviewController controller = loader.getController();
            controller.setData(
                    selected.getName(),
                    selected.getPhone(),
                    selected.getEmail(),
                    selected.getAddress(),
                    selected.getEducation(),
                    selected.getSkills(),
                    selected.getWorkExperience(),
                    selected.getProjects(),
                    image
            );

            Stage stage = (Stage) cvTable.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 800));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to open CV view.");
        }
    }

    @FXML
    private void onDeleteClicked(ActionEvent event) {
        CVmodel selected = cvTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("No CV selected", "Please select a CV to delete.");
            return;
        }

        cvDao.deleteById(selected.getId());
        loadData();
    }

    @FXML
    private void onBackClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CV.fxml"));
            Stage stage = (Stage) cvTable.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to go back to form.");
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
