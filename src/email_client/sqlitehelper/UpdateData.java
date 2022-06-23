package email_client.sqlitehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UpdateData {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection connection = SQLiteHelper.getConnection();     
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    public void updateAccount(String id, String type, String service,  String smtp, 
            String imap, String email, String password, String name, String portTLS, 
            String portSSL, String portIMAP) throws SQLException {      
        ps = connection.prepareStatement("UPDATE email SET name = ?, email = ?, password = ?, type = ?, "
                + "server = ?, smtp = ?, imap = ? , portTLS = ?, portSSL = ?, portIMAP = ? WHERE  ID = ? ");
        //vì tên cho tài khoản email là không bắt buộc
        if (name.equals("")) {
            ps.setString(1, "NOT Available");
        }
        else {
        ps.setString(1, name);
        }
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, type);
        ps.setString(5, service);
        ps.setString(6, smtp);
        ps.setString(7, imap);
        ps.setString(8, portTLS);
        ps.setString(9, portSSL);
        ps.setString(10, portIMAP);
        ps.setString(11, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Cập nhật tài khoản thành công","Thêm tài khoản",JOptionPane.INFORMATION_MESSAGE);                            
    }
}
