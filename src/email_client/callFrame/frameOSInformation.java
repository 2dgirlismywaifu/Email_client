/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.addAccount;
import email_client.global.LookandFeel;
import email_client.global.macOS.subForm;
import email_client.osInformation;

/**
 *
 * @author notmiyouji
 */
public class frameOSInformation {
    public static void callframe() {
        LookandFeel.setTheme();
        subForm.isMacOS();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            osInformation frame = new osInformation();           
            subForm.isMacFullWindowContentSupported(frame);
            frame.setVisible(true);
            frame.setTitle("Thêm tài khoản");
            frame.setResizable(false);
        });
    }
    
}
