package com.example.circle_home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider radiusSlider;

    public Slider getRadiusSlider() {
        return radiusSlider;
    }

    public void setRadiusSlider(int value) {
        this.radiusSlider.setValue(value);
    }

    public void onStartServerClicked(ActionEvent actionEvent) {
    }

    public void onConnectClicked(ActionEvent actionEvent) {
    }

    public void onMouseClicked(MouseEvent event) {
        //draw();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(colorPicker.getValue());
        // gc.setLineWidth(5);
        //event.getX();
        gc.strokeOval(event.getX(), event.getY(), radiusSlider.getValue(), radiusSlider.getValue());

    }


    @FXML
    private Canvas canvas;

    @FXML
    public void draw()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
       // gc.setLineWidth(5);
        gc.strokeOval(10, 60, radiusSlider.getValue(), radiusSlider.getValue());
        canvas.getOnMouseClicked();
    }

}