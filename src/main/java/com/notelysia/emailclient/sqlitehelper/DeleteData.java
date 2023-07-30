/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.notelysia.emailclient.sqlitehelper;

import com.notelysia.emailclient.ManageAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class DeleteData {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection con;
    LoadListData loadListData = new LoadListData();
    PreparedStatement ps;    
    //</editor-fold>
    public void DeleteAccount(String email, String name, JTextField emailAccount, JTextField username, JTable tableAccount) {
        con = SQLiteHelper.getConnection();
        try {
            ps = con.prepareStatement("DELETE FROM email where email = ? and name = ?");
            ps.setString(1, email);
            ps.setString(2, name);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Đã xóa tài khoản","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            emailAccount.setText("");
            username.setText("");
            
            //load lại bảng
            loadListData.manageAccountTable(tableAccount);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
