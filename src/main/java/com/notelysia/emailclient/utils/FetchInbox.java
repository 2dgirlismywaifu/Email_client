package com.notelysia.emailclient.utils;

import com.notelysia.emailclient.global.FolderMailName;
import com.notelysia.emailclient.global.GetSessionIMAPS;
import com.notelysia.emailclient.global.MailboxEmpty;
import java.util.LinkedList;
import java.util.List;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.swing.table.DefaultTableModel;


public class FetchInbox{
    MailboxEmpty empty = new MailboxEmpty();
    GetSessionIMAPS getSession = new GetSessionIMAPS();
    public final DefaultTableModel tableModel = new DefaultTableModel();
    FolderMailName mailName = new FolderMailName();
    MailListModel mailListModel;
    List<MailList> Data = new  LinkedList<>();
    
    public MailListModel startFetch(String imap, String storeType, String user, String password ) throws NoSuchProviderException, MessagingException {
        Data.clear(); //clear old linked list
        Session emailSession = getSession.getSession(imap, storeType, user, password);               
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
            String[] headers = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
            Data.add(new MailList("Hộp thư trống", "Hộp thư trống", "Hộp thư trống"));               
            mailListModel = new MailListModel(headers, Data);
            empty.callNotify();
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
