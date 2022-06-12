/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.utils.gmail;

import email_client.global.PropertiesAPI;
import email_client.utils.MailList;
import email_client.utils.MailListModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author notmiyouji
 */
public class GmailTrash {
    PropertiesAPI propsAPI = new PropertiesAPI();
    public final DefaultTableModel tableModel = new DefaultTableModel();
     MailListModel mailListModel;
     List<MailList> Data = new  LinkedList<>();
    
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
            Folder emailFolder = store.getFolder("[Gmail]/Thùng rác");
            emailFolder.open(Folder.READ_WRITE);
             
            
             Message[] messages = emailFolder.getMessages();
             FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(FetchProfile.Item.ENVELOPE);
            emailFolder.fetch(messages, fetchProfile);
             if (messages.length == 0)
            {
                  String[] headers = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
                 Data.add(new MailList("Hộp thư trống", "Hộp thư trống", "Hộp thư trống"));               
                 mailListModel = new MailListModel(headers, Data);  
            }
            else {
             for(int i = messages.length - 1; i >= 0; i--) 
             {     
                 Message message = messages[i];
                 String from = "";
                 InternetAddress[] addresses  =(InternetAddress[]) message.getFrom();
                          
                 for(InternetAddress address:addresses)
                 {
                     from+=address.getAddress();
                 }
                 String[] headers = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
                 Data.add(new MailList(from,message.getSubject(),message.getSentDate().toString()));               
                 mailListModel = new MailListModel(headers, Data);            
                                   
                }
            }
             
          return mailListModel;
    }
    
}
