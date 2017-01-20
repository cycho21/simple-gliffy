package com.nexon.simplegliffy;

import com.nexon.simplegliffy.gui.GuiController;
import com.nexon.simplegliffy.gui.GuiManager;

/**
 * Created by chan8 on 2017-01-20.
 */
public class Controller {

    public Controller() {
    }
    
    public void initialize() {
        GuiManager guiManager = new GuiManager();
        guiManager.initialize();
    }
}
