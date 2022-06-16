/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.SendEmail;
import email_client.global.LookandFeel;
import email_client.global.macOS.mainForm;


/**
 *
 * @author notmiyouji
 */
public class frameSendEmail {
    public void callframe(String email) {
        LookandFeel.setTheme();
        /* Create and display the form */
        mainForm.isMacOS();
        java.awt.EventQueue.invokeLater(() -> {           
            SendEmail frame = new SendEmail();
            mainForm.isMacFullWindowContentSupported(frame);
            frame.setVisible(true);
            frame.setTitle("Soạn thư");
            frame.emailFrom.setText(email);
        });
    }
}
