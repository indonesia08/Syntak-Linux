/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author musa
 */

public class koneksi {
    private static Connection connection;
    
    public static Connection getConnection(){
        //pengecekan koneksi database
        if (connection==null){
            try{
                
                String host = "";
                String username = "";
                String password = "";
                String db = "";
                
                String url = "jdbc:mysql://"+host+":3306/"+db;
                
                MysqlDataSource source = new MysqlDataSource();
                source.setUser(username);
                source.setPassword(password);
                source.setURL(url);
                connection = source.getConnection();
            } catch (SQLException ex){
                System.out.println("Error koneksi database");
                JOptionPane.showMessageDialog(null, "Error koneksi database");
            }
        }
        return connection;
    }
}
