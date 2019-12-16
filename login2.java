import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import config.db_config;
import java.awt.*;     
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

initComponents();
this.setLocationRelativeTo(null);

public void proses_login(){
        String username     =txt_username.getText();
        String password     =new String(txt_password.getPassword());
        try {
            Connection con = db_config.getConnection();
            Statement stmt = con.createStatement();
            
            sql = "SELECT * FROM tabel_operator WHERE nik='"+username+"' AND password='"+password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("nik"))){
                    Home call_home=new Home();
                    call_home.setExtendedState(Home.MAXIMIZED_BOTH);
                    call_home.setVisible(true);
                    this.dispose();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

                JFrame frame = new Login();
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
                frame.setIconImage(icon);
                frame.setVisible(true);
