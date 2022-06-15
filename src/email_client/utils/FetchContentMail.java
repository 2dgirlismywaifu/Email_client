/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.utils;

import com.sun.mail.util.BASE64DecoderStream;
import email_client.global.PropertiesAPI;
import java.awt.Cursor;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.swing.JEditorPane;

/**
 *
 * @author notmiyouji
 */
public class FetchContentMail {   
    
    PropertiesAPI propertiesAPI = new PropertiesAPI();    
    public void readMail(int rowSelected, String imap, String email, String password,String folder, JEditorPane mailMessage) throws IOException {
        Properties props = new Properties();
        props.setProperty(propertiesAPI.getMailProtocol(), "imaps");
        try {
            
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(imap, email, password);
            Folder folderInbox = store.getFolder(folder);
            folderInbox.open(Folder.READ_WRITE);
            Message[] messages = folderInbox.getMessages();
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
            } catch (IOException | MessagingException ex) {
                messageContent = "[Không thể tải nội dung]";
                ex.printStackTrace();
            }
        }                                       
        mailMessage.setContentType("text/html");
        mailMessage.setText(messageContent);
        folderInbox.close(false);
        store.close();
        } catch (NoSuchProviderException ex) {			
                ex.printStackTrace();
        } catch (MessagingException ex) {			
                ex.printStackTrace();
        }        
    }   
    
    public void showSelectedMessage(JEditorPane mailMesseage, Message selectedMessage) {
        
        try {
            mailMesseage.setText(
                    getMessageContent(selectedMessage));
            mailMesseage.setCaretPosition(0);
        } catch (Exception e) {
            //showError("Unabled to load message.", false);
        } 
    }
    
    public static String getMessageContent(Message message)
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
