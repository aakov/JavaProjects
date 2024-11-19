package com.example.circle_home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        stage.setTitle("Circle Drawer");
        stage.setScene(scene);
        stage.show();
        Controller controller = fxmlLoader.<Controller>getController();
        controller.setRadiusSlider(30);
//        controller.draw();

    }

    public static void main(String[] args) {
        launch();
    }
}