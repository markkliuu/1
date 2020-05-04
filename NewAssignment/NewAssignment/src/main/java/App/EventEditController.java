package App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author csr13 
 */
public class EventEditController{

    @FXML
    private Button eventBack;

    @FXML
    private TextField eventName;

    @FXML
    private DatePicker eventDate;

    @FXML
    private TextField eventAddress;

    @FXML
    private TextField eventDetails;

    @FXML
    private TextField eventSchedule;

    @FXML
    private Rectangle eventAddGuest;

    @FXML
    private PieChart eventPie;

    @FXML
    private Rectangle eventDelete;

    @FXML
    private Button eventSave;
    
    PageSwitchHelper p = new PageSwitchHelper(); 
    
    
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
//        // Get the user's input from the GUI
//        if (username.getText().equals("Prententious") && password.getText().equals("Hipster")) {
//            label.setText("Correct.");
//             button1.setVisible(true);
//            // What should the user see when the login is successful?
//        } else {
//            label.setText("Incorrect password and/or username");
//            // What should the user see when the login is unsuccessful?
//        }
    }
// the above method is just an sample, no use 
// the below are page switches 
    
    @FXML
    private void handleGoToEvent(ActionEvent event) throws IOException {
        p.switcher(event,"guestEventInfoPage.fxml");
    }
    
    @FXML
    private void handleGoToGuestBook(ActionEvent event) throws IOException {
        p.switcher(event,"GuestList_Book.fxml");
    }
    
    @FXML
    private void handleGoToAdminLanding(ActionEvent event) throws IOException {
        p.switcher(event,"admin_Landing.fxml");
    }
    
    
    public void initialize() {
        // TODO
    }    
    
}
