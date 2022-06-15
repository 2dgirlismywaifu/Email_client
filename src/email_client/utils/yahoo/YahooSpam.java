/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.utils.yahoo;

import javax.swing.JOptionPane;


/**
 *
 * @author notmiyouji
 */
//Java Mail không tìm đc folder thư rác của yahoo mail
public class YahooSpam {
    public void notifyMesseage() {
        JOptionPane.showMessageDialog(null, "Spam email Yahoo chưa hỗ trợ\n"
                                    + "Vui lòng thử lại sau.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
