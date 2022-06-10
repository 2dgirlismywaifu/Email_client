/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class ExplainCC {
    public static void NotifyMesseage() {
        //Thông báo về các tài khoản xác thực hai bước
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            ImageIcon icon = new ImageIcon(TwoFANotify.class.getResource("/icon/icons8-2fa-64.png"));
            
            
            String text = "CC là từ viết tắt Carbon Coppy có nghĩa là tạ ra các bản sao khi bạn chọn CC email sẽ gởi thêm một bản sao email nữa cho người khác. "
                    + "\nKhi bạn dùng CC gửi email đến nhiều người dùng lúc, những người này có thể xem danh sách người các người nhận email. "
                    + "\nLựa chọn này có thể bỏ qua.";
                    
            JOptionPane.showMessageDialog(null, text, "Thông báo", JOptionPane.INFORMATION_MESSAGE, icon);
        });
    }
}
