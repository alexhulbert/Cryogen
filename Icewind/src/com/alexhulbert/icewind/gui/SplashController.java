package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class SplashController implements Initializable {

    @FXML Button donate;
    @FXML Button skip;
    
    @FXML StackPane donateCase;
    @FXML StackPane skipCase;
    
    @FXML Label leftLabel;
    @FXML Label rightLabel;
    @FXML Label centerLabel;
    
    Timeline timeline;
    
    public void tad(WritableValue p, long time, Object value) {
        KeyValue kv = new KeyValue(p, value);
        KeyFrame kf = new KeyFrame(Duration.millis(time), kv);
        timeline.getKeyFrames().add(kf);
    }
    
    public void chaching() { //hehe :)
        //TODO: Implement donate button
    }
    
    public void next() {
        StaticStage.loadScreen("Title");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        donate.prefWidthProperty().bind(donateCase.widthProperty().multiply(0.7));
        donate.prefHeightProperty().bind(donateCase.heightProperty().multiply(0.7));
        
        skip.prefWidthProperty().bind(skipCase.widthProperty().multiply(0.75));
        skip.prefHeightProperty().bind(skipCase.heightProperty().multiply(0.75));
        
        centerLabel.setText("Taconut");
        
        timeline = new Timeline();
        timeline.setCycleCount(1);
        
        tad(centerLabel.opacityProperty(), 0000, 0);
        tad(centerLabel.opacityProperty(), 2000, 0);
        tad(centerLabel.opacityProperty(), 2750, 1);
        tad(centerLabel.opacityProperty(), 3250, 1);
        tad(centerLabel.opacityProperty(), 4000, 0);
        
        tad(  leftLabel.   textProperty(), 4000, "Pythech:\nPython Code");
        tad( rightLabel.   textProperty(), 4000, "Jurriaan:\niCloud Stuff"); //TODO: Replace "Stuff" with a better word
        tad(  leftLabel.opacityProperty(), 4000, 0);
        tad( rightLabel.opacityProperty(), 4000, 0);
        tad(  leftLabel.opacityProperty(), 4250, 0);
        tad( rightLabel.opacityProperty(), 4250, 0);
        tad(  leftLabel.opacityProperty(), 5000, 1);
        tad( rightLabel.opacityProperty(), 5000, 1);
        tad(  leftLabel.opacityProperty(), 5500, 1);
        tad( rightLabel.opacityProperty(), 5500, 1);
        tad(  leftLabel.opacityProperty(), 6250, 0);
        tad( rightLabel.opacityProperty(), 6250, 0);
        
        
        tad(centerLabel.         fontProperty(), 6250, Font.font("Roboto Thin", 24));
        tad(centerLabel.    alignmentProperty(), 6250, Pos.TOP_LEFT);
        tad(centerLabel.textAlignmentProperty(), 6250, TextAlignment.LEFT);
        tad(centerLabel.         textProperty(), 6250, "ADISAI: Logo\nIH8SN0W: Inspiration\nLOREM: Ipsum\nBLAH: blahblah\nTHIS: is a test");
        tad(centerLabel.      opacityProperty(), 6250, 0);
        tad(centerLabel.      opacityProperty(), 6500, 0);
        tad(centerLabel.      opacityProperty(), 7250, 1);
        tad(centerLabel.      opacityProperty(), 7750, 1);
        tad(centerLabel.      opacityProperty(), 8250, 0);
        
        tad(centerLabel.         fontProperty(), 8250, Font.font("Roboto Thin", 64));
        tad(centerLabel.    alignmentProperty(), 8250, Pos.CENTER);
        tad(centerLabel.textAlignmentProperty(), 8250, TextAlignment.CENTER);
        tad(centerLabel.         textProperty(), 8250, "Welcome");
        tad(centerLabel.      opacityProperty(), 8250, 0);
        tad(centerLabel.      opacityProperty(), 8500, 0);
        tad(centerLabel.      opacityProperty(), 9250, 1);
        
        tad(centerLabel.      opacityProperty(),10000, 1);
        tad(       skip.      opacityProperty(),10000, 1);
        tad(     donate.      opacityProperty(),10000, 1);
        tad(centerLabel.      opacityProperty(),10250, 0);
        tad(       skip.      opacityProperty(),10250, 0);
        tad(     donate.      opacityProperty(),10250, 0);
        
        timeline.play();
        timeline.setOnFinished(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    StaticStage.loadScreen("Title");
                }
            }
        );
    }
}
