package App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import static javafx.application.Application.launch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oscar
 */
public class App extends Application {

    private static Scene startup;
    private static Class<?> class1;

    @Override
    public void start(Stage stage) throws Exception {
        startupDatabase();
        FXMLLoader parent1 = new FXMLLoader(getClass().getResource("/fxml/LoginScreen.fxml"));
        class1 = getClass();
        startup = new Scene(parent1.load());
        stage.setTitle("Events2Go");
        stage.setScene(startup);
        stage.show();

    }

    public static void main(String[] args) throws SQLException {
         startupDatabase();
         launch();
    }

    private static void startupDatabase() throws SQLException {
        Database.AdminRelationCreation();
        Database.GuestRelationCreation();
        Database.InvitationRelationCreation();
        Database.EventRelationCreation();
        Database.RsvpRelationCreation();
        Database.RuntimeRelationCreation();
        Database.UserRelationCreation();
       
    }

    static void setRoot(String fxml) throws IOException {
        startup.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(class1.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
