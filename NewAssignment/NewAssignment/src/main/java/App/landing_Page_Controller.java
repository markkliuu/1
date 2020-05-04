/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import static App.Database.Connect;
import static App.Database.conn;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class landing_Page_Controller implements Initializable {

    @FXML
    private Button event_menu_button;
    @FXML
    private Button book_button;
    @FXML
    private Button account_button;
    @FXML
    private Button help_button;
    @FXML
    private Button event1_button;
    @FXML
    private Button create_button;
    @FXML
    private Text event4;
    @FXML
    private Text event3;
    @FXML
    private Text event1;
    @FXML
    private Text event5;
    @FXML
    private Text event2;
    @FXML
    private Text date4;
    @FXML
    private Text date1;
    @FXML
    private Text date5;
    @FXML
    private Text date2;
    @FXML
    private Text date3;
    @FXML
    private Text name_Field;
    @FXML
    private Button logout_btn;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            eventsLoad();
            account_button.setText("Admin ID: " + LoginScreenController.UserList.get(0));
        } catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    @FXML
    public void gotoGuestBook() throws IOException {
        App.setRoot("/fxml/GuestList_Book");
    }
    
    @FXML
    public void moreEventInfo() throws IOException{
        App.setRoot("/fxml/AnotherEventEdit");
    }

    @FXML
    public void gotoHelp() throws IOException {
        App.setRoot("/fxml/help");
    }
    @FXML
    public void createNew() throws IOException {
        App.setRoot("/fxml/AnotherEventEdit");
       
    }
    @FXML
    public void gotologinpage() throws IOException {
        App.setRoot("/fxml/LoginScreen");
    }
    @FXML
    private void editPageSwitcher(ActionEvent event) throws IOException {
        App.setRoot("/fxml/EventEdit.fxml");
        }

    public void eventsLoad() throws SQLException{
    try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
            PreparedStatement st = conn.prepareStatement("SELECT event.event_name, event.start_time FROM event INNER JOIN invitation ON event.event_id = invitation.event_id WHERE invitation.admin_id = ?");
            st.setString(1, LoginScreenController.UserList.get(0)); 
            ResultSet rs = st.executeQuery();
//        Text event = null;
//        
//         PreparedStatement statement = conn.prepareStatement("INSERT INTO User (current_user) VALUES (?)");
//         statement.setString(1, UserList.get(0));
//         statement.execute();
//         conn.close();
            ArrayList<String> resultList = new ArrayList<String>();
            int size = resultList.size();
            
            while (rs.next()) {
             
            String result = rs.getString(1); 
            resultList.add(result);
            String result2 = rs.getString(2);
            resultList.add(result2);
            size = resultList.size();
            }
            
           
            if(size >= 0){
                event1.setText(resultList.get(0));
                date1.setText(resultList.get(1));
            }
            
            if(size >= 3){
                event2.setText(resultList.get(2));
                date2.setText(resultList.get(3));
            } 
            
            if(size >= 5) {
                event3.setText(resultList.get(4));
                date3.setText(resultList.get(5));
            }
           
            if(size >= 7){
                event4.setText(resultList.get(6));
                date4.setText(resultList.get(7));
            }    
            
            if(size >= 9){
                event5.setText(resultList.get(8));
                date5.setText(resultList.get(9));
            }
            
	st.close();
	conn.close();
                    
        }catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}