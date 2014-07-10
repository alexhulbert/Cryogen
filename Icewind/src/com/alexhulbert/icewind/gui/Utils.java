package com.alexhulbert.icewind.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;
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
    
    private static List<Node> recurse(List<Node> children) {
        List<Node> output = new ArrayList<Node>();
        for (Node obj : children) {
            if (obj instanceof Pane) {
                output.addAll(recurse(((Pane)obj).getChildren()));
            } else {
                output.add(obj);
            }
        }
        return output;
    }
    public static void fitFont(ObservableList<Node> children, Pane pane) {
        for (Node obj : recurse(children)) {
            if (obj instanceof Labeled && !obj.getStyleClass().contains("noresize")){
                Labeled element = (Labeled) obj;
                double s = element.getFont().getSize();
                DoubleBinding fontSize = pane.widthProperty().multiply(0.75).add(pane.heightProperty()).divide(1200).multiply(s);
                obj.styleProperty().bind(Bindings.concat("-fx-font-size: ").concat(fontSize.asString()).concat(";"));
            } else {
                //:I
            }
        }
    }
}
