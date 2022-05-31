/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.global.lookandfeel;
import email_client.manageAccount;

/**
 *
 * @author notmiyouji
 */
public class frameManageAccount {
    public static void callframe() {
        lookandfeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            manageAccount frame = new manageAccount();
            frame.setVisible(true);
            frame.setTitle("Quản lý tài khoản");
            frame.setResizable(false);
        });
    }
    
}
