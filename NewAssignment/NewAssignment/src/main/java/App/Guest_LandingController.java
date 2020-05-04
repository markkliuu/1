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
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class Guest_LandingController implements Initializable {


    @FXML
    private Button g_events_button;
    @FXML
    private Button g_account_button;
    @FXML
    private Button g_help_button;
    @FXML
    private Button g_event1_button;
    @FXML
    private Button g_event5_button;
    @FXML
    private Button g_event3_button;
    @FXML
    private Button g_event4_button;
    @FXML
    private Button g_event2_button;
    @FXML
    private Text g_event1_name;
    @FXML
    private Text g_event4_name;
    @FXML
    private Text g_event3_name;
    @FXML
    private Text g_event2_name;
    @FXML
    private Text g_event6_name;
    @FXML
     Text g_event5_name;
    @FXML
    private Text g_date1;
    @FXML
    private Text g_date4;
    @FXML
    private Text g_date2;
    @FXML
    private Text g_date3;
    @FXML
    private Text g_date6;
    @FXML
    private Text g_date5;
    @FXML
    private Text status1;
    @FXML
    private Text status6;
    @FXML
    private Text status3;
    @FXML
    private Text status2;
    @FXML
    private Text status5;
    @FXML
    private Text status4;
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
         
    
    PageSwitchHelper p = new PageSwitchHelper(); 
    int i = 0;
    
 @FXML
    public void gotoHelp() throws IOException {
        App.setRoot("/fxml/help");
    }    
    
  @FXML
    private void goToEvent1Info(ActionEvent event) throws IOException {
  
       
       Parent parent = FXMLLoader.load(getClass().getResource("/fxml/guestEventInfoPage.fxml"));
       Scene scene = new Scene(parent);     
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.hide();
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
     
             
       
        
    }
    // @FXML
   // private void goToEvent1Info(ActionEvent event) throws IOException{
    //    App.setRoot("/fxml/guestEventInfoPage");
   // }
    
    //@FXML
   // public void goToEventInfo() throws IOException {
    //    //p.switcher(event,"guestEventInfoPage.fxml"); 
     //   App.setRoot("/fxml/guestEventInfoPage");
   // }

    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            guestAcceptedEventsLoad();
            guestStatusEventsLoad();
            //guestPendingEventsLoad();
            g_account_button.setText("Guest ID: " + LoginScreenController.UserList.get(0));
        } catch (SQLException ex) {
            Logger.getLogger(Guest_LandingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void guestAcceptedEventsLoad() throws SQLException {
        try {
           Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
           PreparedStatement st = conn.prepareStatement("SELECT event.event_name, event.start_time FROM event JOIN invitation ON event.event_id = invitation.event_id WHERE invitation.guest_id = ?");
           st.setString(1, LoginScreenController.UserList.get(0)); 
           ResultSet rs = st.executeQuery();
//        Text event = null;
//            LoginScreenController.UserList.get(0)
            ArrayList<String> resultList = new ArrayList<String>();
            int size = resultList.size();
            
            while (rs.next()) {
             
            String result = rs.getString(1); 
            resultList.add(result);
            //System.out.println("result is: " + resultList.get(0));
            String result2 = rs.getString(2);
            resultList.add(result2);
            size = resultList.size();
            }
            
           
            if(size >= 0){
                g_event1_name.setText(resultList.get(0));
                g_date1.setText(resultList.get(1));
            }
            
            if(size >= 3){
                g_event2_name.setText(resultList.get(2));
                g_date2.setText(resultList.get(3));
            } 
            
            if(size >= 5) {
                g_event3_name.setText(resultList.get(4));
                g_date3.setText(resultList.get(5));
            }
           
            if(size >= 7){
                g_event4_name.setText(resultList.get(6));
                g_date4.setText(resultList.get(7));
            }    
            
            if(size >= 9){
                g_event5_name.setText(resultList.get(8));
                g_date5.setText(resultList.get(9));
            }
            
            if(size >= 11){
                g_event6_name.setText(resultList.get(10));
                g_date6.setText(resultList.get(11));
            }
	st.close();
	conn.close();
                    
        }catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void guestStatusEventsLoad() throws SQLException {
        try {
           Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
           PreparedStatement st = conn.prepareStatement("SELECT decision FROM RSVP JOIN invitation ON rsvp.inv_id = invitation.inv_id WHERE invitation.guest_id = ?");
           st.setString(1, LoginScreenController.UserList.get(0)); 
           ResultSet rs = st.executeQuery();
//        Text event = null;
//            LoginScreenController.UserList.get(0)
            ArrayList<String> statusResultList = new ArrayList<String>();
            int statusSize = statusResultList.size();
            
            while (rs.next()) {
             
            String statusResult = rs.getString(1); 
            statusResultList.add(statusResult);
            System.out.println("result is: " + statusResultList.get(0));
            statusSize = statusResultList.size();
            System.out.println("result is: " + statusResultList.size());
            }
            
           
            if(statusSize > 0){
                status1.setText(statusResultList.get(0));
            }
            
            if(statusSize > 1){
                status2.setText(statusResultList.get(1));
            } 
            
            if(statusSize > 2) {
                status3.setText(statusResultList.get(2));
            }
           
            if(statusSize > 3){
               status4.setText(statusResultList.get(3));
            }    
            
            if(statusSize > 4){
                status5.setText(statusResultList.get(4));
            }
            
            if(statusSize > 5){
                status6.setText(statusResultList.get(5));
            }
	st.close();
	conn.close();
                    
        }catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void guestPendingEventsLoad() throws SQLException {
//        try {
//           Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
//           PreparedStatement st = conn.prepareStatement("SELECT event.event_name, event.start_time FROM event JOIN invitation ON event.event_id = invitation.event_id LEFT JOIN RSVP ON Invitation.inv_id = RSVP.inv_id WHERE invitation.guest_id = ? AND RSVP.decision = 'Pending'");
//           // LEFT JOIN RSVP ON Invitation.inv_id = RSVP.inv_id AND RSVP.decision = 'Pending'
//           st.setString(1, LoginScreenController.UserList.get(0)); 
//           ResultSet rs = st.executeQuery();
////        Text event = null;
////            LoginScreenController.UserList.get(0)
//            ArrayList<String> penResultList = new ArrayList<String>();
//            int size2 = penResultList.size();
//            
//            while (rs.next()) {
//             
//            String result = rs.getString(1); 
//            penResultList.add(result);
//            String result2 = rs.getString(2);
//            penResultList.add(result2);
//            size2 = penResultList.size();
//            //System.out.println("Array size is: " + penResultList.size());
//            }
//            
//           
//            if(size2 >= 0){
//                g_event5_name.setText(penResultList.get(0));
//                g_date5.setText(penResultList.get(1));
//            }
//            
//            if(size2 >= 3){
//                g_event6_name.setText(penResultList.get(2));
//                g_date6.setText(penResultList.get(3));
//            } 
//            
//            if(size2 >= 5) {
//                g_event7_name.setText(penResultList.get(4));
//                g_date7.setText(penResultList.get(5));
//            }
//            
//	st.close();
//	conn.close();
//                    
//        }catch (SQLException ex) {
//            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
 //   }    
    
} 