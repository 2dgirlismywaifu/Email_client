/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.utils;

import email_client.global.PropertiesAPI;
import email_client.global.folderMailName;
import java.io.IOException;
import java.util.Properties;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JEditorPane;

/**
 *
 * @author notmiyouji
 */
public class FetchContentPlainText {
    PropertiesAPI propsAPI = new PropertiesAPI();
    folderMailName foldername = new folderMailName();     
     
    public void plainTextShow(int rowSelected,String imap, String foldername, String user, String password, JEditorPane messagePane ) 
            throws NoSuchProviderException, MessagingException, IOException, Exception {
             
            // create properties field
            Properties properties = new Properties();
            properties.put(propsAPI.getHost(), imap);
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
                
            Store store =  emailSession.getStore("imaps");
            store.connect();
            Folder emailFolder = store.getFolder(foldername);
            emailFolder.open(Folder.READ_WRITE);
             
            Message[] messages = emailFolder.getMessages();
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(FetchProfile.Item.ENVELOPE);
            emailFolder.fetch(messages, fetchProfile);
            Message msg = messages[rowSelected];
                    
            System.out.println("Nội dung: " + getMessageContent(msg));
            messagePane.setContentType("text/html");
            messagePane.setText(getMessageContent(msg));
            emailFolder.close(false);
            store.close();
            
       }
    public String getMessageContent(Message message)
    throws Exception {
        Object content = message.getContent();
        if (content instanceof Multipart) {
            StringBuilder messageContent = new StringBuilder();
            Multipart multipart = (Multipart) content;
            for (int i = 0; i < multipart.getCount(); i++) {
                Part part = (Part) multipart.getBodyPart(i);
                if (part.isMimeType("text/plain")) {
                    messageContent.append(part.getContent().toString());
                }
            }
            return messageContent.toString();
        } else {
            return content.toString();
        }
    }   

    
}
