/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.aboutSoftware;
import email_client.addAccount;
import email_client.global.LookandFeel;

/**
 *
 * @author notmiyouji
 */
public class frameAboutSoftware {
    public static void callframe() {
        LookandFeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            aboutSoftware frame = new aboutSoftware();
            frame.setVisible(true);
            frame.setTitle("Thông tin phần mềm");
            frame.setResizable(false);
        });
    }
    
}
