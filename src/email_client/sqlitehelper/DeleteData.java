/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package email_client.sqlitehelper;

import email_client.manageAccount;
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
    Connection connection = SQLiteHelper.getConnection();
    LoadListData loadListData = new LoadListData();
    PreparedStatement ps;    
    //</editor-fold>
    public void DeleteAccount(String email, String name, JTextField emailAccount, JTextField username, JTable tableAccount) {
        try {
            ps = connection.prepareStatement("DELETE FROM email where email = ? and name = ?");
            ps.setString(1, email);
            ps.setString(2, name);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Đã xóa tài khoản","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            emailAccount.setText("");
            username.setText("");
            
            //load lại bảng
            loadListData.manageAccountTable(tableAccount);
            
        } catch (SQLException ex) {
            Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
