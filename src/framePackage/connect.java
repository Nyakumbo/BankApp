
package framePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelvin Kamau
 */
public class connect {
    Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        PreparedStatement pst = null;
    
    public void connector(){
        
    
     
            try {
            String dbname = "bankapp";
            String pass = "";
            String username = "root";
            String Url = "jdbc:mysql://localhost:3306/";
            String Drivers = "com.mysql.jdbc.Driver";

            Class.forName(Drivers);
            con = DriverManager.getConnection(Url + dbname, username, pass);
            //JOptionPane.showMessageDialog(null,"sucess");
         

         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());

        }
    }
    
}
