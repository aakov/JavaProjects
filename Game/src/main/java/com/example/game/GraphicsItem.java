package com.example.game;

import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicsItem {
    public static double canvasWidth;
    public static double canvasHeight;
    protected  double x,y,width, height;
    public static void setDimensions(double canvasWidth, double canvasHeight) {
        GraphicsItem.canvasHeight = canvasHeight;
        GraphicsItem.canvasWidth = canvasWidth;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

   public abstract void draw(GraphicsContext context);

    public static void setCanvasSize(double canvasWidth, double canvasHeight) {
        GraphicsItem.canvasWidth = canvasWidth;
        GraphicsItem.canvasHeight = canvasHeight;
    }
}
