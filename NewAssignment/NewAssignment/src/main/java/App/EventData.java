//package App;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author csr13
// * i am tired
// */
//public class EventData {
//
//
//
//    public static void connect() throws ClassNotFoundException, SQLException {
//        //below codes creates the table
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
//        Statement st = conn.createStatement();
//
//        String creatQuery = "CREATE TABLE events"
//                + "(Event_ID TEXT NOT NULL"
//                + ",Event_Name TEXT NOT NULL"
//                + ",Event_Length TEXT NOT NULL"
//                + ",Event_Start TEXT NOT NULL"
//                + ",Event_Description TEXT NOT NULL"
//                + ",Event_Address TEXT NOT NULL"
//                + ")";
//        st.execute(creatQuery);
//        st.close();
//    }
//
//    public static void insertEvents() throws SQLException {
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
//        Statement st = conn.createStatement();
////below codes needs modification
//        String insertQuery = "INSERT INTO pets (Fname,Ptype,Pcolor,Powner)"
//                + "VALUES ('Kitty', 'Cat', 'Grey', 'Andrew'),"
//                + "('Blair','Cat','White', 'Yenni'),"
//                + "('Mimi', 'Frog', 'Green', 'Hatherine'),"
//                + "('QuackyMooMoo', 'Dog', 'Brown', 'Phoebe');";
//
//        st.execute(insertQuery);
//        st.close();
//    }
//}
