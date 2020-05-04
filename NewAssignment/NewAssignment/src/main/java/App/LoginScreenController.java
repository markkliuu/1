package App;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static App.Database.Connect;
import static App.Database.conn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 *
 * @author aiden
 */
public class LoginScreenController {

//    static String getUserLoggedIn() {
//        UserList.get(0);
//    }
    
    Database d = new Database();
    public static ArrayList<String> UserList = new ArrayList<String>();
    
    @FXML
    private TextField GuestAccessCode;
    
    @FXML
    private TextField AdminUsername;

    @FXML
    private PasswordField AdminPassword;

    @FXML
    private Button AdminLoginbutton;

    @FXML
    private Button GuestLoginbutton;
   
    @FXML
    private Button ResetPasswordbutton;
    
    @FXML
    private Button HelpButton;
    
    @FXML
    private Button next_Button;
    
    @FXML
    private Label ErrorLable;
    
    
    @FXML
    private void AdminLoginbuttonAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        
        Connection conn = null;
        PreparedStatement admin_login = null;
        ResultSet rs = null;
        
        Class.forName("org.sqlite.JDBC");
        conn =  DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
        admin_login  =  conn.prepareStatement("SELECT * from Admin WHERE admin_username = ? and admin_password = ?");
        
        admin_login.setString(1, AdminUsername.getText());
        admin_login.setString(2, AdminPassword.getText());
       // d.insertCurrentUser(AdminUsername.getText());
        rs  =  admin_login.executeQuery();
        
        
          
       
//       PreparedStatement statement = conn.prepareStatement("INSERT INTO User (current_user) VALUES (?)");
//       statement.setString(1, AdminUsername.getText());
//       statement.execute(); 
        
       if(rs.next()){
         String current_user = rs.getString(1); 
         UserList.add(current_user);
        
         ErrorLable.setText("Correct"); 
         App.setRoot("/fxml/admin_Landing");
         
               
       }else{
           ErrorLable.setText("Incorrect password and/or username");
       }
      
       conn.close();
    }
       
   
    
    @FXML
    private void GuestAccessCodeAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
              
        Connection login_connection = null;
        PreparedStatement guest_login = null;
        ResultSet rs = null;
        
        Class.forName("org.sqlite.JDBC");
        login_connection =  DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
        guest_login  =  login_connection.prepareStatement("SELECT * from Guest WHERE access_code = ?");
        
        guest_login.setString(1, GuestAccessCode.getText());
       // d.insertCurrentUser(AdminUsername.getText());
        rs  =  guest_login.executeQuery();
        
       if(rs.next()){
            String current_user = rs.getString(1); 
            UserList.add(current_user);
            ErrorLable.setText("Correct."); 
            App.setRoot("/fxml/guest_Landing");
           
           
       }else{
           ErrorLable.setText("Incorrect password and/or username");
       }
       
       login_connection.close();
    }

    
    @FXML
    private void nextPage(ActionEvent event) throws IOException {
       Parent admin_Parent = FXMLLoader.load(getClass().getResource("/fxml/admin_Landing.fxml"));
       Scene admin_Scene = new Scene(admin_Parent);     
       Stage admin_Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       admin_Stage.hide();
       admin_Stage.setScene(admin_Scene);
       admin_Stage.setResizable(false);
       admin_Stage.show();
    }
   
@FXML
    public void initialize() throws SQLException, ClassNotFoundException {
       next_Button.setVisible(false);
  
    }
    
//   public void insertCurrentUser(String current_user) throws SQLException{
//         Database.Connect();
//         PreparedStatement statement = conn.prepareStatement("INSERT INTO User (current_user) VALUES (?)");
//         statement.setString(1, current_user);
//         statement.executeQuery();
//         conn.close();       
//     }
    
   //public void getCurrent 

//        public void UserList() throws SQLException {
//        conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
//         PreparedStatement statement = conn.prepareStatement("INSERT INTO User (current_user) VALUES (?)");
//         statement.setString(1, UserList.get(0));
//         statement.execute();
//         conn.close();
//            
//        }
    }
