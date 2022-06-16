/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.aboutSoftware;
import email_client.global.LookandFeel;
import email_client.global.macOS.subForm;

/**
 *
 * @author notmiyouji
 */
public class frameAboutSoftware {
    public static void callframe() {
        LookandFeel.setTheme();
        /* Create and display the form */
        //macOS support ONLY
        subForm.isMacOS();
        java.awt.EventQueue.invokeLater(() -> {
            aboutSoftware frame = new aboutSoftware();
            subForm.isMacFullWindowContentSupported(frame);
            frame.setVisible(true);
            frame.setTitle("Thông tin phần mềm");
            frame.setResizable(false);
        });
    }
    
}
