package com.nexon.simplegliffy;

import com.nexon.simplegliffy.gui.GuiManager;

/**
 * Created by chan8 on 2017-01-20.
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.initialize();
    }

    private void initialize() {
        GuiManager guiManager = new GuiManager();
        guiManager.initialize();
    }

}
