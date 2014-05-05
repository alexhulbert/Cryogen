package com.alexhulbert.icewind.gui;
import com.alexhulbert.icewind.iCloudTest;
import javafx.application.Application;
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
        //Pymobiledevice.init();
        //iCloudTest.dryRun("Your AppleID", "Encode your password in Base64");
        Font.loadFont(Main.class.getResource("binResc/Roboto-Thin.ttf").toExternalForm(), 24);
        StaticStage.mainStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Icew1nd");
        StaticStage.loadScreen(Lite.splash() ? "Splash" : "Title");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
    }
}