/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package email_client.dialogMess;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author notmiyouji
 */
public class AccountFailed {

    public static void NotifyMesseage() {
        //Thông báo về các tài khoản xác thực hai bước
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            ImageIcon icon = new ImageIcon(AccountFailed.class.getResource("/icon/icons8-2fa-64.png"));
            
            
            String text = "Kiểm tra thất bại. "
                    + "\n1. Tài khoản email của bạn có tồn tại không?"
                    + "\nBạn có kích hoạt xác thực hai bước cho tài khoản không?";
                    
            JOptionPane.showMessageDialog(null, text, "Thông báo", JOptionPane.INFORMATION_MESSAGE, icon);
        });
    }
}
