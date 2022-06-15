
package email_client.utils;

import email_client.global.PropertiesAPI;
import email_client.global.folderMailName;
import java.util.HashSet;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FetchInbox{
    PropertiesAPI propsAPI = new PropertiesAPI();
    public final DefaultTableModel tableModel = new DefaultTableModel();
    folderMailName mailName = new folderMailName();
    MailListModel mailListModel;
    List<MailList> Data = new  LinkedList<>();
    
    public MailListModel startFetch(String imap, String storeType, String user, String password ) throws NoSuchProviderException, MessagingException {
            Data.clear(); //clear old linked list
            // create properties field
            Properties properties = new Properties();
            properties.put(propsAPI.getHost(), imap);
            properties.put(propsAPI.getPort(), "993");
            properties.put(propsAPI.getStartTLS(), "true");
            properties.put(propsAPI.getDebug(), "true");
            properties.put("mail.imaps.partialfetch", "false");
            properties.put("mail.imaps.fetchsize", "2000000");
            
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
            Folder emailFolder = store.getFolder(mailName.getInboxFolder());
            emailFolder.open(Folder.READ_WRITE);
            Message[] messages = emailFolder.getMessages();
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(FetchProfile.Item.ENVELOPE);
            emailFolder.fetch(messages, fetchProfile);
             
             if (messages.length == 0)
            {
                JOptionPane.showMessageDialog(null, "Hộp thư trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE); 
            }
            else {
             for(int i = 0, n = messages.length; i < n; i++) 
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
                 mailListModel.setRowCount(0);
                                
                }
            }
            
            emailFolder.close();
            store.close();
          return mailListModel;
    }
}
