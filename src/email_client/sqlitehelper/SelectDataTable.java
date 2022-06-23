/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package email_client.sqlitehelper;

import email_client.manageAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SelectDataTable {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection connection = SQLiteHelper.getConnection();     
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    public void selectAccount(String email, String name, JTextField idEmail, JComboBox imapServer, 
            JComboBox Server, JPasswordField passEmail, JComboBox smtpServer) {
        try {
            ps = connection.prepareStatement("SELECT id, imap, server, password, smtp FROM email WHERE email = ? and name = ?");
            ps.setString(1, email);
            ps.setString(2, name);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                idEmail.setText(rs.getString("id"));
                imapServer.setSelectedItem(rs.getString("imap"));
                Server.setSelectedItem(rs.getString("server"));
                passEmail.setText(rs.getString("password"));
                smtpServer.setSelectedItem(rs.getString("smtp"));             
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
