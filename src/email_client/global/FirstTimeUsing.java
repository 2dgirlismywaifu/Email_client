/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package email_client.global;

import email_client.HomePage;
import email_client.callFrame.frameAddAccount;
import email_client.sqlitehelper.SQLiteHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FirstTimeUsing {
    Connection connection = SQLiteHelper.getConnection();
    PreparedStatement ps;
    ResultSet rs; 
    //<editor-fold defaultstate="collapsed" desc="Danh cho nguoi dung lan dau">
    public void firstTime() { //người dùng mới
        Thread newuser = new Thread() {
            @Override
            public void run() {
                try {          
                    ps = connection.prepareStatement("SELECT COUNT(*) AS AMOUNT FROM email");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int amount = Integer.parseInt(rs.getString("AMOUNT"));
                        if (amount == 0) {
                            int reply = JOptionPane.showConfirmDialog(null, "Xin chào người dùng mới!\n"
                            + "Có vẻ đây là lần đầu sử dụng của bạn, bạn có muốn thêm tài khoản không", "Thông báo", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION ) {
                                frameAddAccount.callframe();
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        newuser.start();
        
    }
    //</editor-fold>
}
