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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class GuestList_BookController implements Initializable {
    
    private static ObservableList<GuestDetail> guestsOblt = FXCollections.observableArrayList();

    @FXML
    private Button GL_addnewguest;
    @FXML
    private Button GL_save;
    @FXML
    private Button GL_addmodifyguest;
    @FXML
    private Button GL_events;
    @FXML
    private Button GL_guestbook;
    @FXML
    private Button GL_username;
    @FXML
    private Button GL_help;
    @FXML
    private Button GL_back;
    @FXML
    private Text GL_title;
    @FXML
    private TextField inputFN;
    @FXML
    private TextField inputLN;
    @FXML
    private TextField inputEmail;
    @FXML
    private Label insertTip;
    @FXML
    private TableView<GuestDetail> guestDetail;
    @FXML
    private TableColumn<GuestDetail,String> email;
    @FXML
    private TableColumn<GuestDetail,String> code;
    

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // get all guests and put them into tableview
        try {
            email.setCellValueFactory(new PropertyValueFactory<>("guestEmail"));
            code.setCellValueFactory(new PropertyValueFactory<>("guestCode"));
            // get all guests
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
            String selectSql = "SELECT * FROM Guest;";
            PreparedStatement stmt = conn.prepareStatement(selectSql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String inputCode = rs.getString(3);
                String inputEmail = rs.getString(2);
                GuestDetail guest1 = new GuestDetail(inputCode,inputEmail);
                guestsOblt.add(guest1);
            }
            guestDetail.setItems(guestsOblt);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuestList_BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void goBackBt() throws IOException {
        App.setRoot("/fxml/admin_Landing");
    }
    @FXML
    public void gotoEvents() throws IOException {
        App.setRoot("/fxml/admin_Landing");
    }

    @FXML
    public void gotoHelp() throws IOException {
        App.setRoot("/fxml/help");
    }

    // add new guest
    @FXML
    public void addNewGuest() throws SQLException {
        // get input data
        String fn = inputFN.getText();
        String ln = inputLN.getText();
        String ie = inputEmail.getText();

        // create a connection to database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");

        // create an access_code
        // get a random number
        String accessCode = "";
        while (true) {
            int number = (int) (getRandomNumber() * 10000);
            accessCode = fn + ln + number;
            // check access Code
            String selectSql = "Select * From Guest Where access_code = ?;";
            PreparedStatement stmt = conn.prepareStatement(selectSql);
            stmt.setString(1, accessCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == false) {
                break;
            }
            stmt.close();
        }
        conn.close();

        conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
        // connect to the database and insert data
        String insertSql = "INSERT INTO Guest (guest_email, "
                + "access_code, f_name, l_name) "
                + "VALUES (? ,? ,? ,?);";
        PreparedStatement stmt = conn.prepareStatement(insertSql);
        stmt.setString(1, ie);
        stmt.setString(2, accessCode);
        stmt.setString(3, fn);
        stmt.setString(4, ln);
        stmt.execute();
        conn.close();

        guestsOblt.add(new GuestDetail(accessCode,ie));
        guestDetail.setItems(guestsOblt);
        
        // if success
        insertTip.setText("User login code is " + accessCode);
        inputFN.setText("");
        inputLN.setText("");
        inputEmail.setText("");

    }

    // get a random number [0.1,1)
    public static double getRandomNumber() {
        while (true) {
            double number = Math.random();
            if (number > 0.1) {
                return number;
            }
        }
    }

}
