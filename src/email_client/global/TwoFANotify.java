/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package email_client.global;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author notmiyouji
 */
public class TwoFANotify {

    public static void NotifyMesseage() {
        //Thông báo về các tài khoản xác thực hai bước
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            ImageIcon icon = new ImageIcon(TwoFANotify.class.getResource("/icon/icons8-2fa-64.png"));
            
            
            String text = "Với các tài khoản xác thực hai bước, bạn cần tạo mật khẩu ứng dụng."
                    + "\nCác trang sau sẽ hỗ trợ bạn tạo mật khẩu với loại tài khoản "
                    + "\n1. Google: https://support.google.com/accounts/answer/185833"
                    + "\n2. Outlook: https://bom.so/Z2mG1r"
                    + "\n3. Yahoo Mail: https://vn.trogiup.yahoo.com/kb/SLN15241.html"
                    + "\nChú ý: Vui lòng không chia sẻ mật khẩu một lần cho bất kỳ ai!";
                    
            JOptionPane.showMessageDialog(null, text, "Thông báo", JOptionPane.INFORMATION_MESSAGE, icon);
        });
    }
}
