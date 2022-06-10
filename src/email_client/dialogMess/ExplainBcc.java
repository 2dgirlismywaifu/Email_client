/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.dialogMess;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author notmiyouji
 */
public class ExplainBcc {
    public static void NotifyMesseage() {
        //Thông báo về các tài khoản xác thực hai bước
        EventQueue.invokeLater(() -> {         
            ImageIcon icon = new ImageIcon(TwoFANotify.class.getResource("/icon/icons8-email-64.png"));
            
            
            String text = "BCC là từ viết tắt của Blind Carbon Coppy cũng có nghĩa là tạo ra những bản sao tạm thời."
                    + "\nNgười gởi sẽ gửi các bản sao email cho nhiều người dùng một lúc nhưng các người nhận sẽ không không được hiển thị. "
                    + "\nLựa chọn này có thể bỏ qua.";
                    
            JOptionPane.showMessageDialog(null, text, "Thông báo", JOptionPane.INFORMATION_MESSAGE, icon);
        });
    }
}
