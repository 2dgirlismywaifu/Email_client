/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CheckFolderEmail;

import javax.mail.MessagingException;

/**
 *
 * @author notmiyouji
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws javax.mail.MessagingException
     */
    public static void main(String[] args) throws MessagingException {
        // TODO code application logic here
       System.out.println("Outlook account");
        outlook.main();
        System.out.println("Gmail account");
        gmail.main();
        System.out.println("Gmail account");
        yahoo.main();
    }
    
}
