
package email_client.utils;

import com.sun.mail.util.BASE64DecoderStream;
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
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.swing.JEditorPane;


public class FetchContentMail {   
        
    PropertiesAPI propsAPI = new PropertiesAPI();
    folderMailName foldername = new folderMailName();   
    MailListModel mailListModel = new MailListModel();
     
    public void readEmail(int rowSelected,String imap, String foldername, String user, String password, JEditorPane messagePane ) 
            throws NoSuchProviderException, MessagingException, IOException {
             
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
            String contentType = msg.getContentType();
            String messageContent = "";
             if (contentType.contains("multipart")) {
                Multipart multiPart = (Multipart) msg.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    messageContent = part.getContent().toString();
                }
            }
            else if (contentType.contains("multipart")|| contentType.contains("text/html")) {
                try {
                    BASE64DecoderStream content =(BASE64DecoderStream) msg.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                } catch (Exception ex) {
                    messageContent = "[Không thể tải nội dung]";
                    ex.printStackTrace();
                }
            }                                     
            messagePane.setContentType("text/html");
            messagePane.setText(messageContent);
            emailFolder.close(false);
            store.close();
            
       }      
 }


