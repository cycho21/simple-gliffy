package com.nexon.simplegliffy.shape;

/**
 * Created by chan8 on 2017-01-20.
 */
public class CustomShape implements Shapable {
    private int x;
    private int y;
    private int width;
    private int height;
    private int type;

    public CustomShape(int x, int y, int width, int height, int type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    @Override
    public void moveTo(int x, int y) {
        
    }

    @Override
    public void resize(int newWidth, int newHeight) {
        
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
