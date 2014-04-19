package com.alexhulbert.icewind.gui;

import com.alexhulbert.jmobiledevice.Lockdown;
import insidefx.undecorator.Undecorator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class StaticStage {
    public static Stage mainStage;
    public static double w = 800;
    public static double h = 600;
    
    public static List<Lockdown> devices = new ArrayList<Lockdown>();
    public static String[] bigImages = new String[3];
    
    public static Lockdown dLockdown;
    public static Image dImg = null;
    public static String dName = "";
    
    private static Scene loadPane(String FXMLName, double width, double height) {
        try {
            Region root = FXMLLoader.load(Main.class.getResource(FXMLName + ".fxml"));
            mainStage.setMinHeight(600);
            mainStage.setMinWidth(800);
            Undecorator ud = new Undecorator(mainStage, root);
            ud.getStylesheets().add("skin/undecorator.css");
            Scene s = new Scene(ud, width, height);
            return ud.getScene();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static Undecorator loadPane(Region root) {
        try {
            mainStage.setMinHeight(600);
            mainStage.setMinWidth(800);
            Undecorator ud = new Undecorator(mainStage, root);
            ud.getStylesheets().add("skin/undecorator.css");
            return ud;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void loadScreen(String name) {
        Pane f = null;
        try {
            f = (Pane) FXMLLoader.load(Main.class.getResource(name + ".fxml"));
        } catch (IOException e) {
            
        }
        //Frosty frost = new Frosty(mainStage, f);
        w = mainStage.getWidth();
        h = mainStage.getHeight();
        Undecorator u = loadPane(f);
        Scene s = new Scene(u, w, h);
        mainStage.setScene(u.getScene());
        mainStage.show();
        mainStage.setWidth(w);
        mainStage.setHeight(h);
        //Refresh Drop Shadow
        mainStage.setIconified(true);
        mainStage.setIconified(false);
        mainStage.getScene().setFill(Color.TRANSPARENT);
    }
}
