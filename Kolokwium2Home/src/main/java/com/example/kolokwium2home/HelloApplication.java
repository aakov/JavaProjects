package com.example.kolokwium2home;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
        HelloController controller = fxmlLoader.<HelloController>getController();
        ServerThread serverThread = new ServerThread("127.0.0.1", 5000);
        serverThread.setController(controller);
        serverThread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void step(HelloController controller,String w)
    {
        controller.setWordCountLabel(w);
    }

    public static void main(String[] args) {
        launch();

    }
}