/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import com.formdev.flatlaf.util.SystemInfo;
import email_client.aboutSoftware;
import email_client.global.LookandFeel;

/**
 *
 * @author notmiyouji
 */
public class frameAboutSoftware {
    public static void callframe() {
        LookandFeel.setTheme();
        /* Create and display the form */
        //macOS support ONLY
        if( SystemInfo.isMacOS ) {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" ); //menubar lên Screen Menu Bar
            //System.setProperty( "apple.awt.application.name", "Thông tin phần mềm" ); //tên phần mềm lên Screen Menu Bar               
        }
        java.awt.EventQueue.invokeLater(() -> {
            aboutSoftware frame = new aboutSoftware();
            if( SystemInfo.isMacFullWindowContentSupported ) { //macOS ONLY
                frame.getRootPane().putClientProperty( "apple.awt.transparentTitleBar", true ); //transparent titlebar
                //frame.getRootPane().putClientProperty( "apple.awt.fullscreenable", true ); //fullscreen mode
            }
            frame.setVisible(true);
            frame.setTitle("Thông tin phần mềm");
            frame.setResizable(false);
        });
    }
    
}
