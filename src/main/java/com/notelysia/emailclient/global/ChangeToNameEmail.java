package com.notelysia.emailclient.global;

import com.notelysia.emailclient.sqlitehelper.SQLiteHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class ChangeToNameEmail {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection connection = SQLiteHelper.getConnection();     
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    public void nameEmail(JLabel username, String emailSelected) {
        try {
            //trước tiên chúng ta sẽ đổi Email Client thành tên của tk email
            ps = connection.prepareStatement("SELECT name FROM email WHERE email = ?");
            ps.setString(1, emailSelected);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                username.setText(rs.getString("name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChangeToNameEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
