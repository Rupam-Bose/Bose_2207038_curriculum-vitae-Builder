package com.example.cv;

import com.example.cv.DB.DatabaseInitializer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseInitializer.initialize();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
        Scene scene = new Scene(root, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setResizable(false);
        primaryStage.show();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        PauseTransition stay = new PauseTransition(Duration.seconds(3));

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(event -> {
            try {
                Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
                Scene scene2 = new Scene(root2);

                primaryStage.setScene(scene2);

                // Fade in welcome2.fxml
                FadeTransition fadeIn2 = new FadeTransition(Duration.seconds(1), root2);
                fadeIn2.setFromValue(0);
                fadeIn2.setToValue(1);
                fadeIn2.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        fadeIn.play();
        fadeIn.setOnFinished(e -> stay.play());
        stay.setOnFinished(e -> fadeOut.play());
    }
    public static void main(String[] args) {
        launch(args);
    }
}
