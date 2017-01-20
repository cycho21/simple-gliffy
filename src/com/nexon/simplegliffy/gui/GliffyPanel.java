package com.nexon.simplegliffy.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chan8 on 2017-01-20.
 */
public class GliffyPanel extends JPanel implements Runnable {
    private Image image;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
    
    public synchronized void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void run() {
        
    }
}
