package com.example.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle extends  GraphicsItem{
    public Paddle() {
        height = canvasHeight * 0.02;
        width = canvasWidth * 0.2;
        x = canvasWidth/2 - width/2;
        y = canvasHeight * 0.9;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(Color.BLUE);
        context.fillRect(x, y, width, height);
    }
    private  static double clamp(double value, double minimum, double maximum)
    {
        return  Math.max(minimum,Math.min(value,maximum));
    }
    public  void setPosition(double x)
    {
        this.x = clamp(x-width/2,0,canvasWidth - width);

    }
    public double getPosition() {
        return x+width/2;
    }
}
