
package email_client.utils;

import email_client.global.PropertiesAPI;
import email_client.global.folderMailName;
import java.util.Properties;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.table.DefaultTableModel;


public class FetchInbox{
    PropertiesAPI propsAPI = new PropertiesAPI();
    folderMailName foldername = new folderMailName();
    public final DefaultTableModel tableModel = new DefaultTableModel();
    MailListModel mailListModel = new MailListModel();
    
    
    public MailListModel startFetch(String imap, String storeType, String user, String password ) throws NoSuchProviderException, MessagingException {
             
              // create properties field
            Properties properties = new Properties();
            properties.put(propsAPI.getHost(), imap);
            properties.put(propsAPI.getPort(), "993");
            properties.put(propsAPI.getStartTLS(), "true");
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
            Folder emailFolder = store.getFolder(foldername.getInboxFolder());
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
