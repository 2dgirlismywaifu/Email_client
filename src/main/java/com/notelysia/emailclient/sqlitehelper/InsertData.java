package com.notelysia.emailclient.sqlitehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InsertData {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection con;
    PreparedStatement ps;    
    //</editor-fold>
    public void insertAccount(String type, String service,  String smtp, String imap, String email, 
            String pass, String name, String portTLS, String portSSL, String portIMAP) {
        con = SQLiteHelper.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO email(name, email, password, type, server, smtp, imap, portTLS, portSSL, portIMAP) values(?,?,?,?,?,?,?,?,?,?) ");
            //vì tên cho tài khoản email là không bắt buộc
            if (name.equals("")) {
                ps.setString(1, "NOT Available");
            }
            else {
            ps.setString(1, name);
            }
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, type);
            ps.setString(5, service);
            ps.setString(6, smtp);
            ps.setString(7, imap);
            ps.setString(8, portTLS);
            ps.setString(9, portSSL);
            ps.setString(10, portIMAP);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Thêm tài khoản thành công","Thêm tài khoản",JOptionPane.INFORMATION_MESSAGE);
            
            con.close();                                  
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
