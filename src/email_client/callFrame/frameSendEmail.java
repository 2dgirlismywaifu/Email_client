/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.SendEmail;
import email_client.global.LookandFeel;


/**
 *
 * @author notmiyouji
 */
public class frameSendEmail {
    public static void callframe() {
        LookandFeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            SendEmail frame = new SendEmail();
            frame.setVisible(true);
            frame.setTitle("Soạn thư");
        });
    }
}
