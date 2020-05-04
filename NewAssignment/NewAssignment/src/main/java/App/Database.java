/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oscar
 */
public class Database {

    public static Connection conn;
    
public static void Connect() throws SQLException {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 

    public static void AdminRelationCreation() throws SQLException {
            try {
                Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS Admin "
                        + "(admin_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "admin_email TEXT NOT NULL UNIQUE, "
                        + "admin_username TEXT NOT NULL UNIQUE, "
                        + "admin_password TEXT NOT NULL);";

                st.execute(createStatement);

                String insertQuery  =  "INSERT INTO Admin (admin_id, admin_email, "
                  + "admin_username, admin_password) "
                  + "VALUES (1, 'admin@e2g.com', 'admin1', 'password')";
                st.execute(insertQuery);
                
                String insertQuery2  =  "INSERT INTO Admin (admin_id, admin_email, admin_username, admin_password) "
                  + "VALUES (2, 'admin2@e2g.com', 'admin2', 'password')";
                st.execute(insertQuery2);
                
                st.close();
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    public static void GuestRelationCreation() {
   
            try {
              Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS Guest "
                        + "(guest_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "guest_email TEXT NOT NULL UNIQUE, "
                        + "access_code TEXT NOT NULL UNIQUE, "
                        + "f_name TEXT, "
                        + "l_name TEXT, "
                        + "phone_num INTEGER UNIQUE);";

                st.execute(createStatement);

                String insertQuery  =  "INSERT INTO Guest (guest_id, guest_email, "
                  + "access_code, f_name, l_name, phone_num) "
                  + "VALUES (1, 'msimp@gmail.com', 'MattSimpson1', 'Matt', 'Simpson', 0443657848)";
                
                st.execute(insertQuery);
                
                String insertQuery2  =  "INSERT INTO Guest (guest_id, guest_email, access_code, f_name, l_name, phone_num)"
                  + " VALUES (2, 'kylielee@gmail.com', 'KylieLee2', 'Kylie', 'Lee', 0457473468)";
                
                st.execute(insertQuery2);
                
                st.close();
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    public static void InvitationRelationCreation() {
            try {
                Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS Invitation "
                        + "(inv_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "admin_id INTEGER NOT NULL, "
                        + "guest_id INTEGER NOT NULL, "
                        + "event_id INTEGER NOT NULL, "
                        + "FOREIGN KEY (admin_id) REFERENCES Admin(admin_id), "
                        + "FOREIGN KEY (guest_id) REFERENCES Guest(guest_id), "
                        + "FOREIGN KEY (event_id) REFERENCES Event(event_id));";

                st.execute(createStatement);

                String insertQuery  =  "INSERT INTO Invitation (inv_id, admin_id, "
                  + "guest_id, event_id) "
                  + "VALUES (1, 1, 1, 1);";
                
                st.execute(insertQuery);
                
                String insertQuery2  =  "INSERT INTO Invitation (inv_id, admin_id, "
                  + "guest_id, event_id) "
                  + "VALUES (2, 2, 2, 2);";
                
                st.execute(insertQuery2);
                
                 String insertQuery3  =  "INSERT INTO Invitation (inv_id, admin_id, "
                  + "guest_id, event_id) "
                  + "VALUES (3, 2, 1, 3);";
                
                st.execute(insertQuery3);
                
                String insertQuery4  =  "INSERT INTO Invitation (inv_id, admin_id, "
                  + "guest_id, event_id) "
                  + "VALUES (4, 1, 2, 4);";
                
                st.execute(insertQuery4);
                
                st.close();
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    public static void EventRelationCreation() {
      
            try {
                Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS Event "
                        + "(event_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "event_name TEXT NOT NULL, "
                        + "address TEXT NOT NULL, "
                        + "description TEXT, "
                        + "length INTEGER, "
                        + "start_time DATETIME);";

                st.execute(createStatement);

                String insertQuery  =  "INSERT INTO Event "
                  + "(event_id, event_name, address, description, length, start_time) "
                  + "VALUES (1, 'A Wedding', 'Bondi Icebergs', 'Celebrating Michelle and Mark', 4, '2020-01-01 10:00:00')";
                
                st.execute(insertQuery);
                
                String insertQuery2  =  "INSERT INTO Event "
                  + "(event_id, event_name, address, description, length, start_time) "
                  + "VALUES (2, 'Movie Night', 'Petes House', 'We are watching Lion', 2, '2020-01-02 20:00:00')";
                
                st.execute(insertQuery2);
                
                 String insertQuery3  =  "INSERT INTO Event "
                  + "(event_id, event_name, address, description, length, start_time) "
                  + "VALUES (3, '40th Birthday', '23 Melrose Pl', 'Liams Party BYO drinks', 3, '2020-02-08 15:00:00')";
                
                st.execute(insertQuery3);
                
                String insertQuery4  =  "INSERT INTO Event "
                  + "(event_id, event_name, address, description, length, start_time) "
                  + "VALUES (4, 'BYOT Seminar', 'St Johns College', 'Learn what devices to use', 1, '2020-02-04 9:00:00')";
                
                st.execute(insertQuery4);
                
                st.close();
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    public static void RsvpRelationCreation() {
        
            try {
                Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS RSVP "
                        + "(RSVP_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "inv_id INTEGER NOT NULL, "
                        + "RSVP_datetime DATETIME DEFAULT (datetime('now','localtime')), "
                        + "requests TEXT, "
                        + "decision TEXT DEFAULT 'Pending' NOT NULL, "
                        + "FOREIGN KEY (inv_id) REFERENCES Invitation(inv_id));";

                st.execute(createStatement);


                String insertQuery  =  "INSERT INTO RSVP (RSVP_id, inv_ID, "
                  + "RSVP_datetime, requests, decision) "
                  + "VALUES (1, 1, '2020-01-01 09:00:00', 'None', 'Accepted');";
                
                st.execute(insertQuery);
                
                String insertQuery2  =  "INSERT INTO RSVP (RSVP_id, inv_ID, "
                  + "RSVP_datetime, requests, decision) "
                  + "VALUES (2, 3, '2020-01-01 10:00:00', 'None', 'Pending');";
                
                st.execute(insertQuery2);

                st.close();
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

public static void UserRelationCreation(){
            try {
                Connect();
                Statement st = conn.createStatement();
                String createStatement = "CREATE TABLE IF NOT EXISTS User "
                  + "(current_user TEXT, "
                  + "user_id INTRGER);";
                
                st.execute(createStatement);

                st.close();
                conn.close();
            } catch (SQLException ex) {
               // ex.printStackTrace();
            }
        }

               
    

    public static void RuntimeRelationCreation() {
//        if (conn == null) {
//            try {
//                conn = DriverManager.getConnection("jdbc:sqlite:Events2Go.db");
//                Statement st = conn.createStatement();
//                String createStatement = "CREATE TABLE IF NOT EXISTS Runtime "
//                        + "(run_id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                        + "event_id INTEGER NOT NULL, "
//                        + "description TEXT, "
//                        + "time DATETIME DEFAULT (datetime('now','localtime'), "
//                        + "FOREIGN KEY (event_id) REFERENCES Event(event_id));";
//
//                st.execute(createStatement);
//
////                String insertQuery  =  "INSERT INTO Runtime (run_id, event_id, "
////                  + "description, time) "
////                  + "VALUES (1, 1, 'Event starts', '2020-01-01 10:00:00');";
////                
////                st.execute(insertQuery);
//                st.close();
//                conn.close();
//                conn = null;
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }

    }
}
