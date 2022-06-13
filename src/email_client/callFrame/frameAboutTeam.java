/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.aboutTeam;
import email_client.global.LookandFeel;

/**
 *
 * @author notmiyouji
 */
public class frameAboutTeam {
    public static void callframe() {
        LookandFeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            aboutTeam frame = new aboutTeam();
            frame.setVisible(true);
            frame.setTitle("Thông tin nhóm");
            frame.setResizable(false);
        });
    }
    
}
