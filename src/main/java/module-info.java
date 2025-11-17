module com.example.cv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;

    opens com.example.cv.Controller to javafx.fxml;

    opens com.example.cv to javafx.fxml;
    exports com.example.cv;
}