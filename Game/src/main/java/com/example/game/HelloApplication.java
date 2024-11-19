package com.example.game;

import com.example.game.GameCanvas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GameCanvas gameCanvas = new GameCanvas();
        GridPane gridPane = new GridPane();
        gridPane.add(gameCanvas, 0,0);
        Scene scene = new Scene(gridPane, gameCanvas.getWidth(), gameCanvas.getHeight());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        gameCanvas.initialize();
        gameCanvas.draw();
        stage.show();
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
    }

}