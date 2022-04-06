package com.zombie_bird.game.gameobjects;


import com.badlogic.gdx.graphics.Color;

/**
 * Created by Clarence E Moore on 2022-03-24.
 * <p>
 * Description:
 */

public class MyRectangle {
    private int x, y, width, height;

    private Color color;

    public MyRectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }
}
