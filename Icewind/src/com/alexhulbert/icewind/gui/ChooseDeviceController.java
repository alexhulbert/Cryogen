package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ChooseDeviceController implements Initializable {

    @FXML GridPane pane;
    @FXML GridPane SlotA;
    @FXML GridPane SlotB;
    @FXML GridPane SlotC;
    @FXML ImageView ImgA;
    @FXML ImageView ImgB;
    @FXML ImageView ImgC;
    @FXML Label NameA;
    @FXML Label NameB;
    @FXML Label NameC;
    @FXML ProgressIndicator ProgA;
    @FXML ProgressIndicator ProgB;
    @FXML ProgressIndicator ProgC;
    @FXML Button BackBtn;
    @FXML StackPane BackCase;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImgA.fitHeightProperty().bind(SlotA.heightProperty());
        ImgB.fitHeightProperty().bind(SlotB.heightProperty());
        ImgC.fitHeightProperty().bind(SlotC.heightProperty());
        BackBtn.prefHeightProperty().bind(BackCase.heightProperty().multiply(9).divide(13));
        refresh();
    }
    public void debug() {
        int i = 0;
    }
    
    public void refresh() {
        RefreshThread rtInstance = new RefreshThread(
                ImgA,
                ImgB,
                ImgC,
                NameA,
                NameB,
                NameC,
                ProgA,
                ProgB,
                ProgC
        );
        new Thread(rtInstance).start();
    }
    
    public void back() {
        StaticStage.loadScreen("Title");
    }
    
    public void imgA_hover() {
        if (ImgA.getOpacity() == 1) {
            EasyAnimation ea = new EasyAnimation();
            ea.push(NameA.textFillProperty(), 000, NameA.getTextFill());
            ea.push(NameA.textFillProperty(), 100, new Color(2.0/3, 2.0/3, 2.0/3, 1));
            ea.play();
        }
    }
    
    public void imgA_unhover() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(NameA.textFillProperty(), 000, NameA.getTextFill());
        ea.push(NameA.textFillProperty(), 100, new Color(0, 0, 0, 1));
        ea.play();
    }
    
    public void imgA_select() {
        if (ImgA.getOpacity() == 1) {
            StaticStage.dLockdown = StaticStage.devices.get(0);
            StaticStage.dImg = new Image(StaticStage.bigImages[0]);
            StaticStage.dName = NameA.getText();
            StaticStage.loadScreen("Transfer");
        }
    }
    
    public void imgB_hover() {
        if (ImgB.getOpacity() == 1) {
            EasyAnimation ea = new EasyAnimation();
            ea.push(NameB.textFillProperty(), 000, NameB.getTextFill());
            ea.push(NameB.textFillProperty(), 100, new Color(2.0/3, 2.0/3, 2.0/3, 1));
            ea.play();
        }
    }
    
    public void imgB_unhover() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(NameB.textFillProperty(), 000, NameB.getTextFill());
        ea.push(NameB.textFillProperty(), 100, new Color(0, 0, 0, 1));
        ea.play();
    }
    
    public void imgB_select() {
        if (ImgB.getOpacity() == 1) {
            StaticStage.dLockdown = StaticStage.devices.get(1);
            StaticStage.dImg = new Image(StaticStage.bigImages[1]);
            StaticStage.dName = NameB.getText();
            StaticStage.loadScreen("Transfer");
        }
    }
    
    public void imgC_hover() {
        if (ImgC.getOpacity() == 1) {
            EasyAnimation ea = new EasyAnimation();
            ea.push(NameC.textFillProperty(), 000, NameC.getTextFill());
            ea.push(NameC.textFillProperty(), 100, new Color(2.0/3, 2.0/3, 2.0/3, 1));
            ea.play();
        }
    }
    
    public void imgC_unhover() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(NameC.textFillProperty(), 000, NameC.getTextFill());
        ea.push(NameC.textFillProperty(), 100, new Color(0, 0, 0, 1));
        ea.play();
    }
    
    public void imgC_select() {
        if (ImgC.getOpacity() == 1) {
            StaticStage.dLockdown = StaticStage.devices.get(2);
            StaticStage.dImg = new Image(StaticStage.bigImages[2]);
            StaticStage.dName = NameC.getText();
            StaticStage.loadScreen("Transfer");
        }
    }
}
