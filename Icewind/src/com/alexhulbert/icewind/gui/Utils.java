package com.alexhulbert.icewind.gui;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Utils {
    public static void fadeOut(Node host, double duration) {
        FadeTransition ft = new FadeTransition(Duration.millis(duration), host);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
    }
    
    public static void fadeIn(Node host, double duration) {
        FadeTransition ft = new FadeTransition(Duration.millis(duration), host);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
