/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import email_client.anotherAboutTeam;
import email_client.global.LookandFeel;
import email_client.global.macOS.subForm;

/**
 *
 * @author notmiyouji
 */
public class frameAboutTeam {
//    public static void callframe() {
//        LookandFeel.setTheme();
//        subForm.isMacOS();
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            aboutTeam frame = new aboutTeam();
//            subForm.isMacFullWindowContentSupported(frame);
//            frame.setVisible(true);
//            frame.setTitle("Thông tin nhóm");
//            frame.setResizable(false);
//        });
//    }
    
    public static void anotherframe() {
        LookandFeel.setTheme();
        subForm.isMacOS();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            anotherAboutTeam frame = new anotherAboutTeam();
            subForm.isMacFullWindowContentSupported(frame);
            frame.setVisible(true);
            frame.setTitle("Thông tin nhóm");
            frame.setResizable(false);
        });
    }
    
}
