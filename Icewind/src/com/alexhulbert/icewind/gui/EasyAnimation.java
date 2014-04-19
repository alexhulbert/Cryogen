package com.alexhulbert.icewind.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class EasyAnimation {
    private Timeline timeline;
    
    public EasyAnimation() {
        timeline = new Timeline();
        timeline.setCycleCount(1);
    }
    
    public Timeline get() {
        return timeline;
    }
    
    public void play() {
        timeline.play();
    }
    
    public void finishWith(EventHandler<ActionEvent> e) {
        timeline.setOnFinished(e);
    }
    
    public void push(WritableValue p, long time, Object value) {
        KeyValue kv = new KeyValue(p, value);
        KeyFrame kf = new KeyFrame(Duration.millis(time), kv);
        timeline.getKeyFrames().add(kf);
    }
    
    public KeyFrame pop() {
        int len = timeline.getKeyFrames().size();
        KeyFrame kf = timeline.getKeyFrames().get(len - 1);
        timeline.getKeyFrames().remove(len);
        return kf;
    }
}
