/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckFolderEmail;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author notmiyouji
 */
//Đây là function kiểm tra folder của email
public class yahoo {
     
    public static void main( ) throws NoSuchProviderException, MessagingException {
             
              String user = "notmiyouji10933939@yahoo.com";
              String password = "waudsenceoioeptz";
              // create properties field
              Properties properties = new Properties();
               properties.put("mail.imaps.host","imap.mail.yahoo.com");
              properties.put("mail.imaps.port", "993");
              properties.put("mail.imaps.starttls.enable", "true");


              // Setup authentication, get session
              Session emailSession = Session.getInstance(properties,
                 new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(user, password);
                    }
                 });
                
            Store store =  emailSession.getStore("imaps");
            store.connect();
            Folder[] f = store.getDefaultFolder().list("*");
        for(Folder fd:f)
            System.out.println(">> "+fd.getName());
    }
}
