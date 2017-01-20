package com.nexon.simplegliffy.gui;

import com.nexon.simplegliffy.shape.CustomPoint;
import com.nexon.simplegliffy.shape.CustomShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by chan8 on 2017-01-20.
 */
public class GuiController implements ActionListener, MouseListener {

    private final int INITIALIZED = 0;
    private final int OVAL = 1;
    private final int RECTANGLE = 2;
    private CustomPoint pressedPoint;
    private CustomPoint releasedPoint;
    private GliffyPanel mainPanel;
    private GliffyFrame mainFrame;
    private ArrayList<CustomShape> shapes;

    private int status = INITIALIZED;
    private Follower follower;

    public GuiController() {
        shapes = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "RECTANGLE":
                status = RECTANGLE;
                break;
            case "OVAL":
                status = OVAL;
                break;
            default:
                break;
        }
        adjustStatus();
    }

    private void adjustStatus() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressedPoint = new CustomPoint(e.getX(), e.getY());
        follower.setShutDown(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        follower.setShutDown(true);
        releasedPoint = new CustomPoint(e.getX(), e.getY());
        addShape();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void addShape() {
        int width = 0;
        int height = 0;

        switch (status) {

            case OVAL:
                width = releasedPoint.getX() - pressedPoint.getX();
                height = releasedPoint.getY() - pressedPoint.getY();
                addOvalToList(width, height);
                drawImage();
                break;
            case RECTANGLE:
                width = releasedPoint.getX() - pressedPoint.getX();
                height = releasedPoint.getY() - pressedPoint.getY();
                addRectangleToList(width, height);
                drawImage();
                break;
            case INITIALIZED:
                break;
            default:
                break;
        }
    }

    private void drawImage() {
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
        mainPanel.setImage(image);
    }

    private void addRectangleToList(int width, int height) {
        if (width > 0 && height > 0)
            shapes.add(new CustomShape(pressedPoint.getX(), pressedPoint.getY(), Math.abs(width), Math.abs(height), RECTANGLE));

        if (width > 0 && height < 0)
            shapes.add(new CustomShape(pressedPoint.getX(), releasedPoint.getY(), Math.abs(width), Math.abs(height), RECTANGLE));

        if (width < 0 && height > 0)
            shapes.add(new CustomShape(releasedPoint.getX(), pressedPoint.getY(), Math.abs(width), Math.abs(height), RECTANGLE));

        if (width < 0 && height < 0)
            shapes.add(new CustomShape(releasedPoint.getX(), releasedPoint.getY(), Math.abs(width), Math.abs(height), RECTANGLE));
    }

    private void addOvalToList(int width, int height) {
        if (width > 0 && height > 0)
            shapes.add(new CustomShape(pressedPoint.getX(), pressedPoint.getY(), Math.abs(width), Math.abs(height), OVAL));

        if (width > 0 && height < 0)
            shapes.add(new CustomShape(pressedPoint.getX(), releasedPoint.getY(), Math.abs(width), Math.abs(height), OVAL));

        if (width < 0 && height > 0)
            shapes.add(new CustomShape(releasedPoint.getX(), pressedPoint.getY(), Math.abs(width), Math.abs(height), OVAL));

        if (width < 0 && height < 0)
            shapes.add(new CustomShape(releasedPoint.getX(), releasedPoint.getY(), Math.abs(width), Math.abs(height), OVAL));
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(GliffyFrame mainFrame) {
        this.mainFrame = mainFrame;
        
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(GliffyPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void makeFollwer() {
        follower = new Follower();
        follower.setGliffyPanel(mainPanel);
        follower.setShutDown(true);
        Thread thread = new Thread(follower);
        thread.start();
    }
}
