package com.nexon.simplegliffy.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chan8 on 2017-01-20.
 */
public class GuiManager {

    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT = 835;

    private GliffyFrame gliffyFrame;
    private GliffyPanel gliffyPanel;
    private JPanel buttonPanel;

    public GuiManager() {
    }

    public void initialize() {
        gliffyPanel = makePanel(FRAME_WIDTH, FRAME_HEIGHT, Color.WHITE);
        gliffyFrame = makeFrame();
        gliffyFrame.add(BorderLayout.CENTER, gliffyPanel);
        
        buttonPanel = makePanel(1280, 35, Color.PINK);
        
        GuiController buttonListener = new GuiController();
        JButton rectangleButton = new JButton("RECTANGLE");
        JButton ovalButton = new JButton("OVAL");
        gliffyPanel.addMouseListener(buttonListener);
        rectangleButton.addActionListener(buttonListener);
        ovalButton.addActionListener(buttonListener);
        buttonListener.setMainPanel(getGliffyPanel());
        buttonListener.setMainFrame(getGliffyFrame());
        buttonListener.makeFollwer();
        
        buttonPanel.add(BorderLayout.EAST, rectangleButton);
        buttonPanel.add(BorderLayout.WEST, ovalButton);
        
        gliffyFrame.add(BorderLayout.NORTH, buttonPanel);
        gliffyFrame.pack();
        gliffyFrame.setVisible(true);
    }

    private GliffyPanel makePanel(int width, int height, Color color) {
        GliffyPanel panel = new GliffyPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    private GliffyFrame makeFrame() {
        GliffyFrame frame = new GliffyFrame();
        frame.setBackground(Color.white);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    public int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }

    public GliffyFrame getGliffyFrame() {
        return gliffyFrame;
    }

    public void setGliffyFrame(GliffyFrame gliffyFrame) {
        this.gliffyFrame = gliffyFrame;
    }

    public GliffyPanel getGliffyPanel() {
        return gliffyPanel;
    }

    public void setGliffyPanel(GliffyPanel gliffyPanel) {
        this.gliffyPanel = gliffyPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
}
