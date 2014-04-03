package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

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
}
