/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndiefyLogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    /* What should happen when you first start the program? */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/LoginScreen.fxml"));
        
        Scene scene=new Scene(root);
        stage.setTitle("title");
        stage.setScene(scene);
        stage.show();
        
        
        //Initiate the database
        
        /* Add the four lines of code to load an FXML into a scene, attach it to a stage, 
        and show the stage */
    }

    public static void main(String[] args) {
        //What should go in here?
        launch(args);
    }

    private void loadDatabase() {
       //What method should we be calling from the Database class?
    }
    
}
