package com.example.poprawka;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    List<Double> list = new ArrayList<Double>();
    @FXML
    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    double X1a;
    double X2a;
    double Y1a;
    double Y2a;

    boolean firstClicked;

    @FXML
    public void onMouseClicked(MouseEvent event)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        System.out.println(event.getX());
        System.out.println(event.getY());

        if(!firstClicked){
            X1a = event.getX();
            Y1a = event.getY();
            firstClicked = true;
        }
        else{
            X2a = event.getX();
            Y2a = event.getY();
            Platform.runLater (()->gc.strokeLine(X1a, Y1a, X2a, Y2a));
            firstClicked = false;
        }

       // gc.setFill(Color.RED);
        // gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        Platform.runLater (()-> list.add(event.getX()));
        Platform.runLater (()-> list.add(event.getY()));
        if (list.size() % 4 == 0 && list.size() > 2)
        {
            double X1 = list.get(list.size() - 4);
            double Y1 = list.get(list.size() - 3);
            double X2 = list.get(list.size() - 2);
            double Y2 = list.get(list.size() - 1);
            Platform.runLater (()->gc.strokeLine(list.get(0), list.get(1), list.get(2), list.get(3)));
             Platform.runLater (()->gc.strokeLine(X1, Y1, X2, Y2));
        }
    }

    @FXML
    public void draw()
    {
        canvas.getOnMouseClicked();
    }

}