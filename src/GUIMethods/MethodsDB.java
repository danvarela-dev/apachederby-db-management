/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMethods;

import GUI.MainWindow;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public class MethodsDB {

    private static String base_url;
    private static Connection conn;

    private static Statement statement;

    private static String SQLExceptinMsg;

    public MethodsDB() {
        base_url = "jdbc:derby:C:\\Users\\Danie\\Documents\\NetBeansProjects\\DBM\\Connections\\";
        conn = null;
        statement = null;
        SQLExceptinMsg = "";
    }

    public static Connection getConn() {
        return conn;
    }

    public void setSQLExceptionMsg(String msg) {
        SQLExceptinMsg = msg;
    }

    public String getSQLExceptionMsg() {
        return SQLExceptinMsg;
    }

    //Create new Connection
    public Connection create_NewConnection(String db_name, String username, String password) {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String connURL = base_url + db_name + ";create=true;user=" + username;

        //Load Embedded Driver
        try {
            Class.forName(driver);
            System.out.println(driver + " loaded...");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
            System.out.println("Make sure your CLASSPATH variable "
                    + "contains %DERBY_HOME%\\lib\\derby.jar (${DERBY_HOME}/lib/derby.jar). \n");
        }

        //Start the database and set up user,then restart
        try {
            System.out.println("Connecting to " + connURL + "...");
            conn = DriverManager.getConnection(connURL);
            System.out.println("Connected to database " + connURL);
            setUpUser(conn, username, password);
            conn.close();
            System.out.println("Closed connection");

            //Confirm that connection has been succesfully shutdown, if it throws XJ015  it means it has been closed.
            boolean wasShutdownSucessful = false;
            try {
                DriverManager.getConnection("jdbc:derby:;shutdown=true");
            } catch (SQLException e) {
                if (e.getSQLState().equals("XJ015")) {
                    wasShutdownSucessful = true;
                }
            }

            if (wasShutdownSucessful) {
                System.out.println("Database closed normally...");
            } else {
                System.out.println("Database did not close normally...");
            }

            //force unload of Driver in order to restart later
            System.gc();

        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
        return conn;
    }

    public Connection connect2ExistingConnection(String db_name, String username, String password) {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
            System.out.println(driver + " loaded...");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
            System.out.println("Make sure your CLASSPATH variable "
                    + "contains %DERBY_HOME%\\lib\\derby.jar (${DERBY_HOME}/lib/derby.jar). \n");
        } catch (Throwable ee) {
            System.out.println(ee.getLocalizedMessage());
        }

        String db_url = base_url + db_name + ";user=" + username + ";password=" + password;
        Properties prop = new Properties();
        prop.put("user", username);
        prop.put("password", password);

        try {
            System.out.println("Connecting to" + db_url);
            conn = DriverManager.getConnection(db_url);
            System.out.println("Connected to database " + db_name);

        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
        return conn;
    }

    //function to create users and provide permissions
    public static void setUpUser(Connection conn, String username, String password) throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_CREATE_USER('" + username + "','" + password + "')");
//         
//        //set up authentication 
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.connection.requireAuthentication','true')");
//        ResultSet res = s.executeQuery("VALUES SYSCS_UTIL.SYSCS_GET_DATABASE_PROPERTY("
//                + "'derby.connection.requireAuthentication')");
//        res.next();
//        System.out.println("Value of requireAuthentication is" + res.getString(1));
//        //set up cheme used to auth
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
//                + "'derby.authentication.provider', 'BUILTIN')");
////        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
////                + "'derby.user.admin ',' admin ') ");
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
//                + "'derby.user." + username + " ',' " + password + " ')");
//
//        //default mode wont grant access to db
//        //user auth
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
//                + "'derby.database.defaultConnectionMode', 'noAccess' )");
//
//        //confirming it has been set properly
//        res = s.executeQuery(
//                "VALUES SYSCS_UTIL.SYSCS_GET_DATABASE_PROPERTY("
//                + "'derby.database.defaultConnectionMode')");
//        res.next();
//        System.out.println("Value of defaultConnectionMode is "
//                + res.getString(1));
//
//        //set up full access to db to the given username
//        String fullAccessUsers = "'" + username + "'";
//
//
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
//                + "'derby.database.fullAccessUsers', " + fullAccessUsers + ")");
//
//        //confirming it has been granted full access
//        res = s.executeQuery(
//                "VALUES SYSCS_UTIL.SYSCS_GET_DATABASE_PROPERTY("
//                + "'derby.database.fullAccessUsers')");
//        res.next();
//        System.out.println("Value of fullAccessUsers is " + res.getString(1));
//
//        s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY("
//                + "'derby.database.propertiesOnly', 'true')");

        s.close();

    }

    public boolean deleteConnectionFolderNonRecursive(MainWindow window, File db_path) {
        int opt = JOptionPane.showConfirmDialog(window, "Are you sure you want to delete database? ", "Confirm", JOptionPane.YES_NO_OPTION);

        if (opt == 0) {
            deleteConnectionFolder(db_path);
        }

        return true;
    }

    public boolean deleteConnectionFolder(File db_path) {
        //Algoritmo recursivo
        File[] content = db_path.listFiles();

        if (content != null) {
            for (File file : content) {
                deleteConnectionFolder(file);
            }
        }
        return db_path.delete();
    }

}
