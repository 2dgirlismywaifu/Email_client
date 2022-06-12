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
public class outlook {
     
    public static void main( ) throws NoSuchProviderException, MessagingException {
             
              String user = "ngothanhlong2014@outlook.com";
              String password = "jfcgszptnmuzrugv";
              // create properties field
              Properties properties = new Properties();
                properties.put("mail.imaps.host","outlook.office365.com");
              properties.put("mail.imaps.port", "993");
              properties.put("mail.imaps.starttls.enable", "true");
              properties.put("mail.debug", "true");


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
