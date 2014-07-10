package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TitleController implements Initializable {

    @FXML ImageView mainLogo;
    @FXML GridPane  logoCase;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainLogo.fitHeightProperty().bind(logoCase.widthProperty().divide(550).multiply(112));
        mainLogo.fitWidthProperty().bind(logoCase.widthProperty());
    }
    
    public void start() {
        StaticStage.loadScreen("ChooseDevice");
    }
    
    public void credits() {
        StaticStage.loadScreen("ChooseDevice");
    }
    
}
