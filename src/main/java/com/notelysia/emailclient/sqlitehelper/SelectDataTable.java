/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.notelysia.emailclient.sqlitehelper;

import com.notelysia.emailclient.ManageAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.logging.log4j.LogManager;


public class SelectDataTable {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(SelectDataTable.class);
    Connection con;     
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    public void selectAccount(String email, String name, JTextField idEmail, JComboBox imapServer, 
            JComboBox Server, JPasswordField passEmail, JComboBox smtpServer) {
        con = SQLiteHelper.getConnection();
        try {
            ps = con.prepareStatement("SELECT id, imap, server, password, smtp FROM email WHERE email = ? and name = ?");
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
            con.close();
        } catch (SQLException ex) {
            logger.error("Exceptions happen: " + ex, ex);
        }
    }
}
