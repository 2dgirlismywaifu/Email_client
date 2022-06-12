/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.callFrame;
import email_client.dialogMess.CheckAccountMesseage;
import email_client.global.LookandFeel;

/**
 *
 * @author notmiyouji
 */
public class frameCheckAccountMesseage {
    CheckAccountMesseage frame = new CheckAccountMesseage() ;
    public void callframe() {
            LookandFeel.setTheme();
            /* Create and display the form */
            frame.setVisible(true);
            frame.setTitle("Thông báo");
            frame.setResizable(false);
        
    }
    
    public void closeNotify() {
        frame.dispose();
    }   
}
