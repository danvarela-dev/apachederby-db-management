package GUIMethods;

import GUI.NewConnectionWindow;
import GUI.AddTableWindow;
import GUI.AuthWindows.AddTableAuthenticationWindow;
import GUI.MainWindow;
import GUI.AuthWindows.ViewTableAuthenticationWindow;
import GUI.ViewIndexWindow;
import GUI.AuthWindows.CreateIndexAuthenticationWindow;
import GUI.AuthWindows.ProceduresAuthenticationWindow;
import GUI.AuthWindows.ViewIndexAuthenticationWindow;
import GUI.CreateIndexWindow;
import GUI.ProceduresWindow;
import GUI.TableModificationWindow;
import GUI.TriggersWindow;
import GUI.AuthWindows.TriggersAuthenticationWindow;
import GUI.UsersAdminWindow;
import GUI.AuthWindows.UsersAuthWindow;
import GUI.ViewWindow;
import GUI.AuthWindows.ViewAuthenticationsWindow;

import java.sql.Connection;


import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MethodsWins {

    public MethodsWins() {
    }

    private String ConnStr;

    public String getConnStr() {
        return ConnStr;
    }

    public void setConnStr(String ConnStr) {
        this.ConnStr = ConnStr;
    }

    public void openNewConnectionWindow() {
        NewConnectionWindow newConnectionWindow = new NewConnectionWindow();
        try {
            newConnectionWindow.setTitle("New Connection");
            newConnectionWindow.setVisible(true);
            newConnectionWindow.setLocationRelativeTo(null);
            newConnectionWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public void openNewTableWindow(Connection conn) {
        AddTableWindow tablewindow = new AddTableWindow(conn);
        try {
            tablewindow.setTitle("Add New Table");
            tablewindow.setVisible(true);
            tablewindow.setLocationRelativeTo(null);
            tablewindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openAddTableAuthenticationWindow(String db_name) {
        AddTableAuthenticationWindow addTableAuthWindow = new AddTableAuthenticationWindow(db_name);
        try {
            addTableAuthWindow.setTitle("User Authentication");
            addTableAuthWindow.setVisible(true);
            addTableAuthWindow.setLocationRelativeTo(null);
            addTableAuthWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openViewTableAuthenticationWindow(String db_name, MainWindow window_) {
        ViewTableAuthenticationWindow viewTableAuthWindow = new ViewTableAuthenticationWindow(db_name, window_);
        try {
            viewTableAuthWindow.setTitle("User Authentication");
            viewTableAuthWindow.setVisible(true);
            viewTableAuthWindow.setLocationRelativeTo(null);
            viewTableAuthWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openTableModificationWindow(String tableName, Connection conn) {
        TableModificationWindow tableMod = new TableModificationWindow(tableName, conn);
        try {
            tableMod.setTitle("Table Modification");
            tableMod.setVisible(true);
            tableMod.setLocationRelativeTo(null);
            tableMod.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openCreateIndexAuthWindow(String db_name) {
        CreateIndexAuthenticationWindow window = new CreateIndexAuthenticationWindow(db_name);
        try {
            window.setTitle("User Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openCreateIndexWindow(Connection conn_) {
        CreateIndexWindow window = new CreateIndexWindow(conn_);
        try {
            window.setTitle("Create Index");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void openViewIndexAuthWindow(String db_name) {
        ViewIndexAuthenticationWindow window = new ViewIndexAuthenticationWindow(db_name);

        try {
            window.setTitle("User Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void openViewIndexWindow(Connection conn_) {
        ViewIndexWindow window = new ViewIndexWindow(conn_);
        try {
            window.setTitle("View Index");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void openProceduresAuthWindow(String db_name) {
        ProceduresAuthenticationWindow window = new ProceduresAuthenticationWindow(db_name);
        try {
            window.setTitle("User Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void openProceduresWindow(Connection conn_) {
        ProceduresWindow window = new ProceduresWindow(conn_);
        try {
            window.setTitle("Procedures");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void openTriggersAuthWindow(String db_name) {
        TriggersAuthenticationWindow window = new TriggersAuthenticationWindow(db_name);

        try {
            window.setTitle("User Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
    
    public void openTriggersWindow(Connection conn) {
        TriggersWindow window = new TriggersWindow(conn);

        try {
            window.setTitle("Triggers");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
    
    public void openUsersAuthWindow(String db_name){
        UsersAuthWindow window = new UsersAuthWindow(db_name);
    try {
            window.setTitle("Users Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    
    public void openUsersWindow(Connection conn){
        UsersAdminWindow window = new UsersAdminWindow(conn);
     try {
            window.setTitle("Users Administration");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
 
    
    public void openViewAuthWindow(String dbname){
    ViewAuthenticationsWindow window = new ViewAuthenticationsWindow(dbname);
       try {
            window.setTitle("Users Authentication");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    
    }
    
    public void openViewWindow(Connection conn_){
    ViewWindow window = new ViewWindow(conn_);
       try {
            window.setTitle("Views");
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    
    }

}
