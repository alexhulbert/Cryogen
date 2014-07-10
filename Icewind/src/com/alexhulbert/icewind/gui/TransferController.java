package com.alexhulbert.icewind.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Taconut
 */
public class TransferController implements Initializable {
    
    @FXML private Button BtnBack;
    @FXML private Button BtnBackup;
    @FXML private Button BtnRestore;
    
    @FXML private GridPane ImgCase;
    @FXML private GridPane BackCase;
    
    @FXML private Label TxtBackup;
    @FXML private Label TxtName;
    @FXML private Label TxtRestore;
    
    @FXML private Label TxtHeader;
    @FXML private Label TxtContent;
    
    @FXML private ImageView ImgDevice;
    
    private static final String bakpStr = "Lorem Ipsem BACKUP";
    private static final String rstrStr = "Lorem Ipsen RESTORE";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TxtName.setText(StaticStage.dName);
        ImgDevice.fitHeightProperty().bind(ImgCase.heightProperty().multiply(1));
        ImgDevice.setImage(StaticStage.dImg);
        BtnBack.prefHeightProperty().bind(BackCase.heightProperty().multiply(9).divide(13));
    }
    
    public void back() {
        StaticStage.loadScreen("ChooseDevice");
    }
    
    /**
     * Hides info panel
     */
    public void noInfo() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(TxtHeader .textProperty(), 000, TxtHeader .getText());
        ea.push(TxtContent.textProperty(), 000, TxtContent.getText());
        
        ea.push(TxtHeader .textProperty(), 250, "");
        ea.push(TxtContent.textProperty(), 250, "");
        ea.play();
    }
    
    /**
     * Display a little info about backing up
     */
    public void backupInfo() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(TxtHeader .textProperty(), 000, TxtHeader .getText());
        ea.push(TxtContent.textProperty(), 000, TxtContent.getText());
        
        ea.push(TxtHeader .textProperty(), 250, "Backup");
        ea.push(TxtContent.textProperty(), 250, bakpStr);
        ea.play();
    }
    
    /**
     * Display some info on restoring
     */
    public void restoreInfo() {
        EasyAnimation ea = new EasyAnimation();
        ea.push(TxtHeader .textProperty(), 000, TxtHeader .getText());
        ea.push(TxtContent.textProperty(), 000, TxtContent.getText());
        
        ea.push(TxtHeader .textProperty(), 250, "Restore");
        ea.push(TxtContent.textProperty(), 250, rstrStr);
        ea.play();
    }
}