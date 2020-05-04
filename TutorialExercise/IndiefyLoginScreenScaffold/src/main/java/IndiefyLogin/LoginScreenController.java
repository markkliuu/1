/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndiefyLogin;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class LoginScreenController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label label;

    @FXML
    private Button button1;

    @FXML
    private Button button;
    
    
  //PageSwitchHelper pgSwitcher = new PageSwitchHelper();
   // Database d = new Database();

    //Initiate JavaFX nodes (visual elements), how do we connect these variables to the FXML view?
    // Initiate the database class

    /* What should happen when you click the login button?
       How do we connect this function to the FXML view? */
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        // Get the user's input from the GUI
        if (username.getText().equals("Prententious") && password.getText().equals("Hipster")) {
            label.setText("Correct.");
             button1.setVisible(true);
            // What should the user see when the login is successful?
        } else {
            label.setText("Incorrect password and/or username");
            // What should the user see when the login is unsuccessful?
        }
    }

    @FXML
    private void handleSwitcher(ActionEvent event) throws IOException {
     //  System.out.println("Switching pages");
       
       Parent MLparent = FXMLLoader.load(getClass().getResource("/fxml/MusicList.fxml"));
       Scene MLscene = new Scene(MLparent);     
       Stage MLstage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       MLstage.hide();
       MLstage.setScene(MLscene);
       MLstage.setResizable(false);
       MLstage.show();
             
       
        //pgSwitcher.switcher(event, "MusicList.fxml");
        //Hopefully this is able to call the switcher method?
    }

//    
//    @FXML
//    private void handleSwitcher(MouseEvent event) throws IOException {
//     //  System.out.println("Switching pages");
//       
//       Parent music_list_parent = FXMLLoader.load(getClass().getResource("MusicList.fxml"));
//       Scene music_list_scene = new Scene(music_list_parent);     
//       Stage music_list_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//       music_list_stage.hide();
//       music_list_stage.setScene(music_list_scene);
//       music_list_stage.setResizable(false);
//       music_list_stage.show();
//       
//       
//        //pgSwitcher.switcher(event, "MusicList.fxml");
//        //Hopefully this is able to call the switcher method?
//    }
       
    @FXML
    public void initialize() {
       button1.setVisible(false);
        // What should the user see when the screen loads?
    }
}

