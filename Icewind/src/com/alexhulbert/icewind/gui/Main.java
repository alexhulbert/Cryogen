package com.alexhulbert.icewind.gui;
import com.alexhulbert.icewind.iCloudTest;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.python.apache.xerces.impl.dv.util.Base64;

public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //iCloudTest.dryRun("email", "password");
        Font.loadFont(Main.class.getResource("binResc/Roboto-Thin.ttf").toExternalForm(), 24);
        StaticStage.mainStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Icew1nd");
        StaticStage.loadScreen(Lite.splash() ? "Splash" : "Title");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.getIcons().addAll(
                //This isn't working with my ultra-high DPI. :(
                new Image(Main.class.getResourceAsStream("binResc/icon.png"))
        );
    }
}