import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connector {
    private static Connection c;
    private static String URL = "jdbc:mysql://localhost:3306/appstoon";
    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static Connection openConnection() {
        if (c == null) {
            try {
                Class.forName(DRIVERNAME);
                try {                    
                    c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                }catch  (SQLException sqle) {
                    JOptionPane.showMessageDialog(null, "Cannot connect to database!\n" + sqle);
                }
            }catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "No Driver found\n" + ex); 
            }
        }
        return c;
    }
}