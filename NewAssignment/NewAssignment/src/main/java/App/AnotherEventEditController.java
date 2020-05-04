package App;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AnotherEventEditController implements Initializable {

    // not selected
    private static ObservableList<String> addOblt = FXCollections.observableArrayList();
    // selected
    private static ObservableList<String> addedOblt = FXCollections.observableArrayList();

    @FXML
    private Button event_menu_button;

    @FXML
    private Button book_button;

    @FXML
    private Button account_button;

    @FXML
    private Button help_button;
    
    @FXML
    private Button clear_button;
    
    @FXML
    private Button nextEventButton;

    @FXML
    private ListView<String> guestAddLv;

    @FXML
    void gotoGuestBook(ActionEvent event) throws IOException {
        App.setRoot("/fxml/GuestList_Book");
    }

    @FXML
    void gotoHelp(ActionEvent event) throws IOException {
        App.setRoot("/fxml/help");
    }
    
    @FXML
    void gotoadminlanding(ActionEvent event) throws IOException {
        App.setRoot("/fxml/admin_Landing");
    }
    

    @FXML
     TextField evAddress;

    @FXML
     TextField evDetails;

    @FXML
    private TextField evSchedule;

    @FXML
    private DatePicker evDate;

    @FXML
    private TextField evName;

    @FXML
    private Button evSave;

    @FXML
    private Label status;

    @FXML
    private ListView<String> guestAddedLv;

    @FXML
    private Label tip;

 
    
    @FXML
    void evAddressInput(ActionEvent event) {

    }

    @FXML
    void evDetailsInput(ActionEvent event) {

    }

    @FXML
    void evNameInput(ActionEvent event) {

    }

    //add new event
    @FXML
    void evSaveInput(ActionEvent event) throws SQLException {
        tip.setText("");
        status.setText("");
        if (addedOblt.size() == 0) {
            tip.setText("You must have one guest!");
        } else {
            String name = evName.getText();
            String address = evAddress.getText();
            String detail = evDetails.getText();
            String schedule = evSchedule.getText();
            String startTime = evDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            // create a connection to database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
            // connect to the database and insert data
            // create an event and insert it into database
            String insertSql = "INSERT INTO Event (event_name, "
                    + "address, description, length,start_time) "
                    + "VALUES (? ,? ,? ,?,?);";
            PreparedStatement stmt = conn.prepareStatement(insertSql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, detail);
            stmt.setString(4, schedule);
            stmt.setString(5, startTime);
            stmt.execute();

            // cerate a invitation and insert it to database
            String eventIdSelectSql = "SELECT event_id FROM Event WHERE event_name=? AND address=? "
                    + "AND description=? AND length=?;";
            PreparedStatement stmtForEId = conn.prepareStatement(eventIdSelectSql);
            stmtForEId.setString(1, name);
            stmtForEId.setString(2, address);
            stmtForEId.setString(3, detail);
            stmtForEId.setString(4, schedule);
            ResultSet rs = stmtForEId.executeQuery();
            rs.next();
            int eventId = rs.getInt(1);
            
            int adminId = Integer.parseInt(LoginScreenController.UserList.get(0));
            for (int i = 0; i<addedOblt.size();i++) {
                int guestId =Integer.parseInt(addedOblt.get(i).split(" ")[0]) ;
                String invitationInsertSql = "INSERT INTO Invitation (admin_id, "
                    + "guest_id, event_id) "
                    + "VALUES (? ,? ,?);";
                PreparedStatement stmtForInv = conn.prepareStatement(invitationInsertSql);
                stmtForInv.setInt(1, adminId);
                stmtForInv.setInt(2, guestId);
                stmtForInv.setInt(3, eventId);
                stmtForInv.execute();
            }
            conn.close();

            // if success
            status.setText("event added");
            evName.setText("");
            evAddress.setText("");
            evDetails.setText("");
            evSchedule.setText("");
        }
    }

    @FXML
    void evScheduleInput(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            EventsLoad();
                    } catch (SQLException ex) {
            Logger.getLogger(AnotherEventEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
            String selectSql = "SELECT * FROM Guest;";
            PreparedStatement stmt = conn.prepareStatement(selectSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String display = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6);
                addOblt.add(display);
            }
            guestAddLv.setItems(addOblt);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnotherEventEditController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       int i = 0;

    @FXML
    public void addGuest() {
        String selectGuest = guestAddLv.getSelectionModel().getSelectedItem();
        if (selectGuest != null) {
            addedOblt.add(selectGuest);
            addOblt.remove(selectGuest);
            guestAddLv.setItems(addOblt);
            guestAddedLv.setItems(addedOblt);
        }
    }

    @FXML
    public void removeGuest() {
        String selectGuest = guestAddedLv.getSelectionModel().getSelectedItem();
        if (selectGuest != null) {
            addOblt.add(selectGuest);
            addedOblt.remove(selectGuest);
            guestAddLv.setItems(addOblt);
            guestAddedLv.setItems(addedOblt);
        }
    }
    
                public void EventsLoad() throws SQLException {
        try {
           Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
           PreparedStatement st = conn.prepareStatement("SELECT event.event_name, event.start_time, event.address, event.description, event.length FROM event JOIN invitation ON event.event_id = invitation.event_id WHERE invitation.admin_id = ? ");
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
           // String result6 = rs.getString(6);
           // resultList.add(result6);
            size = resultList.size();
            }
            
           
            
                evName.setText(resultList.get(i));
                //evDate.setText(resultList.get(i+1));
                evAddress.setText(resultList.get(i+2));
                evDetails.setText(resultList.get(i+3));
                evSchedule.setText(resultList.get(i+4));
               // invitedBy.setText(resultList.get(i+5));
            
                i+=5;
                System.out.println("i equals"  + i);

	st.close();
	conn.close();
                    
        }catch (SQLException ex) {
            Logger.getLogger(landing_Page_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @FXML        
       public void clearForm(){
           evName.setText("");
           //evDate.setText(resultList.get(i+1));
           evAddress.setText("");
           evDetails.setText("");
           evSchedule.setText("");
       }
       
       @FXML
             public void nextEventsLoad() throws SQLException{
                 EventsLoad();
             }
}
               
