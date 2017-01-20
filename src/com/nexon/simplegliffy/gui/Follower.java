package com.nexon.simplegliffy.gui;

import com.nexon.simplegliffy.shape.CustomShape;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by chan8 on 2017-01-20.
 */
public class Follower implements Runnable {
    private final int OVAL = 1;
    private final int RECTANGLE = 2;
    private GliffyPanel gliffyPanel;
    private boolean isShutDown = false;
    private ArrayList<CustomShape> shapes;
    
    @Override
    public void run() {
        System.out.println(isShutDown);
        while (!isShutDown) {
            System.out.println("??");
            BufferedImage image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1280, 800);

            for (CustomShape s : shapes)
                switch (s.getType()) {
                    case OVAL:
                        g.setColor(Color.BLACK);
                        g.fillOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
                        break;
                    case RECTANGLE:
                        g.setColor(Color.BLACK);
                        g.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
                        break;
                }
            gliffyPanel.setImage(image);
        }
    }

    public GliffyPanel getGliffyPanel() {
        return gliffyPanel;
    }

    public void setGliffyPanel(GliffyPanel gliffyPanel) {
        this.gliffyPanel = gliffyPanel;
    }

    public boolean isShutDown() {
        return isShutDown;
    }

    public void setShutDown(boolean shutDown) {
        isShutDown = shutDown;
    }
    
}
