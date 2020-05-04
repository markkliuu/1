/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class GuestEventInfoPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button notGoingButton;
    @FXML
    private Button goingButton;
    @FXML
    private Button downladPDF;
     @FXML
    private Button guestEvnentInfoHelp;
    @FXML
    private TextArea inputNotes;
    @FXML
    private Text eventName;
    @FXML
    private Text eventDate;
    @FXML
    private Text invitedBy;
    @FXML
    private Label addressLable;
    @FXML
    private Button account_button;
    @FXML
    private Label runtimeLable;
    @FXML
    private Label detailsLable;
    @FXML
    private Button EN_events;
    @FXML
    private Button nextButton;
   
    
     @FXML
    public void gotoHelp() throws IOException {
        App.setRoot("/fxml/help");
    } 
     @FXML
    public void gotToEventLanding() throws IOException {
        App.setRoot("/fxml/guest_Landing");
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        account_button.setText("Guest ID: " + LoginScreenController.UserList.get(0));
         try {
             guestinfoEventsLoad();
         } catch (SQLException ex) {
             Logger.getLogger(GuestEventInfoPageController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    int i = 0;
    


    public void addNotes() throws SQLException {
        // get input data
        
        String NT = inputNotes.getText();
        
        // create a connection to database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
      
        
        conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
        // connect to the database and insert data
        String insertSql = "INSERT INTO EVENT (NOTES"
                  + "VALUES (? );";
        PreparedStatement stmt = conn.prepareStatement(insertSql);
        stmt.setString(1,NT);
        conn.close();
       
    }
    
            public void guestinfoEventsLoad() throws SQLException {
        try {
           Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
           PreparedStatement st = conn.prepareStatement("SELECT event.event_name, event.start_time, event.address, event.description, event.length, invitation.admin_id FROM event JOIN invitation ON event.event_id = invitation.event_id WHERE invitation.guest_id = ? ");
           st.setString(1, LoginScreenController.UserList.get(0)); 
           ResultSet rs = st.executeQuery();
//        Text event = null;
//            LoginScreenController.UserList.get(0)
            ArrayList<String> resultList = new ArrayList<String>();
            int size = resultList.size();
            //System.out.println("i equals"  + i);
            
            while (rs.next()) {
            
             
            String result = rs.getString(1); 
            resultList.add(result);
            //System.out.println("result is: " + resultList.get(0));
            String result2 = rs.getString(2);
            resultList.add(result2);
            String result3 = rs.getString(3);
            resultList.add(result3);
            String result4 = rs.getString(4);
            resultList.add(result4);
            String result5 = rs.getString(5);
            resultList.add(result5);
            String result6 = rs.getString(6);
            resultList.add(result6);
            size = resultList.size();
            }
            
           
            
                eventName.setText(resultList.get(i));
                eventDate.setText(resultList.get(i+1));
                addressLable.setText(resultList.get(i+2));
                detailsLable.setText(resultList.get(i+3));
                runtimeLable.setText(resultList.get(i+4));
                invitedBy.setText(resultList.get(i+5));
            
                i+=6;
                System.out.println("i equals"  + i);
//            if(size >= 3){
//                g_event2_name.setText(resultList.get(2));
//                g_date2.setText(resultList.get(3));
//            } 
//            
//            if(size >= 5) {
//                g_event3_name.setText(resultList.get(4));
//                g_date3.setText(resultList.get(5));
//            }
//           
//            if(size >= 7){
//                g_event4_name.setText(resultList.get(6));
//                g_date4.setText(resultList.get(7));
//            }    
//            
//            if(size >= 9){
//                g_event5_name.setText(resultList.get(8));
//                g_date5.setText(resultList.get(9));
//            }
//            
//            if(size >= 11){
//                g_event6_name.setText(resultList.get(10));
//                g_date6.setText(resultList.get(11));
//            }
	st.close();
	conn.close();
                    
        }catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
            @FXML
             public void nextguestinfoEventsLoad() throws SQLException{
                 guestinfoEventsLoad();
             }
    
}


