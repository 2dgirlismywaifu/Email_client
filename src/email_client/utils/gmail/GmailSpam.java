/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.utils.gmail;

import email_client.global.PropertiesAPI;
import email_client.global.folderMailName;
import email_client.utils.MailListModel;
import java.util.Properties;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;


/**
 *
 * @author notmiyouji
 */
public class GmailSpam {
    PropertiesAPI propsAPI = new PropertiesAPI();
    folderMailName foldername = new folderMailName();
    MailListModel mailListModel = new MailListModel();
      
    public MailListModel startFetch(String imap, String storeType, String user, String password ) throws NoSuchProviderException, MessagingException {
              
              // create properties field
              Properties properties = new Properties();
              properties.put(propsAPI.getHost(), imap);
              properties.put(propsAPI.getTrustSSL(), imap);
              properties.put(propsAPI.getPort(), "993");
              properties.put(propsAPI.getStartTLS(), "true");
             
              // Setup authentication, get session
              Session emailSession = Session.getInstance(properties,
                 new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(user, password);
                    }
                 });
                
            Store store =  emailSession.getStore(storeType);
            store.connect();
            Folder emailFolder = store.getFolder(foldername.getSpamGmail());
            emailFolder.open(Folder.READ_WRITE);
             
            
            Message[] messages = emailFolder.getMessages();
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(FetchProfile.Item.ENVELOPE);
            emailFolder.fetch(messages, fetchProfile);
            mailListModel.setMessages(messages); 
            store.close();
          return mailListModel;
    }
    
}
