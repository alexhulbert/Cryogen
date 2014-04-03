package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class TitleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void start() {
        StaticStage.loadScreen("ChooseDevice");
    }
    
    public void credits() {
        StaticStage.loadScreen("ChooseDevice");
    }
    
}
