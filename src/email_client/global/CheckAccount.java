/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.global;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author notmiyouji
 */
public class CheckAccount {
    public static void checkLogin(String host, String storeType, String user,
      String password) throws NoSuchProviderException, MessagingException 
   {
      
      // create properties field
      Properties properties = new Properties();

      properties.put("mail.pop3s.host", host);
      properties.put("mail.pop3s.port", "995");
      properties.put("mail.pop3s.starttls.enable", "true");
      

      // Setup authentication, get session
      Session emailSession = Session.getInstance(properties,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(user, password);
            }
         });
      

      
      Store store = emailSession.getStore("pop3s");
      store.connect();

      // close the store      
      store.close();

    }
    
}
