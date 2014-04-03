package com.alexhulbert.icewind.gui;

import com.alexhulbert.jmobiledevice.Lockdown;
import insidefx.undecorator.Undecorator;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class StaticStage {
    public static Stage mainStage;
    public static double w = 800;
    public static double h = 600;
    
    public static List<Lockdown> devices = new ArrayList<Lockdown>();
    
    private static Scene loadPane(String FXMLName, double width, double height) {
        try {
            Region root = FXMLLoader.load(Main.class.getResource(FXMLName + ".fxml"));
            Undecorator ud = new Undecorator(mainStage, root);
            ud.getStylesheets().add("skin/undecorator.css");
            Scene s = new Scene(ud, width, height);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void loadScreen(String name) {
        w = mainStage.getWidth();
        h = mainStage.getHeight(); 
        mainStage.setScene(loadPane(name, w, h));
        mainStage.show();
        //Refresh Drop Shadow
        mainStage.setIconified(true);
        mainStage.setIconified(false);
        mainStage.getScene().setFill(Color.TRANSPARENT);
    }
}
