package com.alexhulbert.icewind.gui;
import com.alexhulbert.jmobiledevice.Pymobiledevice;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        Pymobiledevice.init();
        Font.loadFont(Main.class.getResource("binResc/Roboto-Thin.ttf").toExternalForm(), 24);
        StaticStage.mainStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Icew1nd");
        StaticStage.loadScreen(Lite.splash() ? "Splash" : "Title");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800); 
    }
}