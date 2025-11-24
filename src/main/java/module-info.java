module com.example.cv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    //requires com.example.cv;

    opens com.example.cv.Controller to javafx.fxml;

    opens com.example.cv to javafx.fxml;
    exports com.example.cv;
}