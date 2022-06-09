/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.dialogMess;

import email_client.global.NetworkUtils;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author notmiyouji
 */
public class NetworkNotify {
    public static void NotifyMesseage() {
        //Thông báo về các tài khoản xác thực hai bước
        EventQueue.invokeLater(() -> {           
            ImageIcon connected = new ImageIcon(TwoFANotify.class.getResource("/icon/icons8-signal-64.png"));
            ImageIcon failed = new ImageIcon(TwoFANotify.class.getResource("/icon/icons8-no-connection-64.png"));
            
            NetworkUtils network = new NetworkUtils();
            if (network.CheckConnection() == 1) {
                JOptionPane.showMessageDialog(null, "Bạn đã kết nối tới Internet!", "Thông báo", JOptionPane.INFORMATION_MESSAGE, connected);
            }
            else {
                JOptionPane.showMessageDialog(null, "Mất kết nối tới Internet! \nHãy kiểm tra lại Internet nếu bạn không muốn về nguyên thủy ;) ", "Thông báo", 
                        JOptionPane.INFORMATION_MESSAGE, failed);
            }
                      
        });
    }
    
}
