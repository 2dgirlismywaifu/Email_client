/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import com.formdev.flatlaf.util.SystemInfo;
import email_client.SendEmail;
import email_client.global.LookandFeel;


/**
 *
 * @author notmiyouji
 */
public class frameSendEmail {
    public void callframe(String email) {
        LookandFeel.setTheme();
        /* Create and display the form */
        if( SystemInfo.isMacOS ) {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" ); //menubar lên Screen Menu Bar
            System.setProperty( "apple.awt.application.name", "Soạn thư" ); //tên phần mềm lên Screen Menu Bar               
        }
        java.awt.EventQueue.invokeLater(() -> {           
            SendEmail frame = new SendEmail();
            if( SystemInfo.isMacFullWindowContentSupported ) { //macOS ONLY                              
                frame.getRootPane().putClientProperty( "apple.awt.transparentTitleBar", true ); //transparent titlebar
                frame.getRootPane().putClientProperty( "apple.awt.fullWindowContent", true );        
            }
            frame.getRootPane().putClientProperty( "apple.awt.windowTitleVisible", false ); //ẩn tên phần mềm trên titlebar
            frame.getRootPane().putClientProperty( "apple.awt.fullscreenable", true ); //fullscreen mode
            frame.setVisible(true);
            frame.setTitle("Soạn thư");
            frame.emailFrom.setText(email);
        });
    }
}
