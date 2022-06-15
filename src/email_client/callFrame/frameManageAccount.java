/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;

import com.formdev.flatlaf.util.SystemInfo;
import email_client.global.LookandFeel;
import email_client.manageAccount;

/**
 *
 * @author notmiyouji
 */
public class frameManageAccount {
    public static void callframe() {
        LookandFeel.setTheme();
        if( SystemInfo.isMacOS ) {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" ); //menubar lên Screen Menu Bar
            //System.setProperty( "apple.awt.application.name", "Thông tin phần mềm" ); //tên phần mềm lên Screen Menu Bar               
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            manageAccount frame = new manageAccount();           
            frame.getRootPane().putClientProperty( "apple.awt.transparentTitleBar", true ); //transparent titlebar
            frame.setVisible(true);
            frame.setTitle("Quản lý tài khoản");
            frame.setResizable(false);
        });
    }
    
}
