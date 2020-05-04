/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndiefyLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    public static Connection conn;

    public static void openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:Indiefy.db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /* Note that this method is called from the LoginScreen Controller */
    public boolean tryLogin(String username, String password) {
        
        // Assume that the user will enter incorrect credentials
        boolean loginSuccessful = false;
        
        try {
            // Open the connection
          
            // Use a Prepared Statement to query the database to check entered credentials
            
            // Check the Result Set to see if the query returned a tuple, what should happen then?
            
            // Close the Result Set
               
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return loginSuccessful;
    }
    
    public static void createLoginTable() {
        
        // Initialise your Prepared Statement to create the LOGIN table
        
        //Initialise your Prepared Statement to add data to the LOGIN table
        
        // Initialise your Result Set
        
        // Open the connection
        try {
            System.out.println("Checking LOGIN table ");
            // Check if the Login Table exists
 /*--------------------------------------------------------HERE  //--------------------------------------------------------HERE           
            if (!rs.next()) {
                
                // Use the connection to create the Prepared Statement that will create the LOGIN table, and then and execute it
                
                // Use the connection to create the Prepared Statement that will add data to the table, and then and execute it
                
            } else {
                System.out.println("LOGIN table exists");
            }
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
