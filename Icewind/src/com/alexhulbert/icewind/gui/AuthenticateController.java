package com.alexhulbert.icewind.gui;

import com.alexhulbert.icewind.iCloud;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class AuthenticateController implements Initializable {

    @FXML private GridPane AuthCase;
    @FXML private Rectangle AuthBubble;
    @FXML private GridPane pane;
    @FXML private TextField Email;
    @FXML private PasswordField Pass;
    @FXML private Button AuthBtn;
    @FXML private Label Incorrect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DoubleBinding fontSize = pane.widthProperty().multiply(pane.heightProperty()).divide(20000);
        Email.styleProperty().bind(Bindings.concat("-fx-font-size: ").concat(fontSize.asString()).concat(";"));
        Pass.styleProperty().bind(Email.styleProperty());
        Incorrect.styleProperty().bind(Email.styleProperty());
        AuthBubble.widthProperty().bind(pane.widthProperty().multiply(0.7).subtract(5));
        AuthBubble.heightProperty().bind(pane.heightProperty().multiply(0.575).subtract(5));
    }
    
    public void signIn() {
        String authResponse = null;
        if (!Email.getText().equals("") && !Pass.getText().equals("")) {
            authResponse = iCloud.authenticate(Email.getText(), Pass.getText());
        }
        if (authResponse != null) {
            StaticStage.dsid = iCloud.getDsPrsID(authResponse);
            StaticStage.mmsAuth = iCloud.getMmeAuthToken(authResponse);
            //StaticStage.loadScreen("ChooseRemoteDevice");
        } else {
            AuthBtn.setDefaultButton(false);
            if (!Email.getStyleClass().contains("red-line")) {
                Email.getStyleClass().add("red-line");
            }
            if (!Pass.getStyleClass().contains("red-line")) {
                Pass.getStyleClass().add("red-line");
            }
            Utils.fadeIn(Incorrect, 250);
        }
    }
    
    public void back() {
        StaticStage.loadScreen("ChooseDevice");
    }
}
