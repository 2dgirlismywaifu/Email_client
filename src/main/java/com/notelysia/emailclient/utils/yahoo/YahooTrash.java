package com.notelysia.emailclient.utils.yahoo;

import com.notelysia.emailclient.global.FolderMailName;
import com.notelysia.emailclient.global.GetSessionIMAPS;
import com.notelysia.emailclient.global.MailboxEmpty;
import com.notelysia.emailclient.utils.MailList;
import com.notelysia.emailclient.utils.MailListModel;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.swing.table.DefaultTableModel;

public class YahooTrash {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    MailboxEmpty empty = new MailboxEmpty();
    GetSessionIMAPS getSession = new GetSessionIMAPS();
    FolderMailName foldername = new FolderMailName();
    public final DefaultTableModel tableModel = new DefaultTableModel();
    MailListModel mailListModel;
    List<MailList> Data = new  LinkedList<>();
    //</editor-fold>
    public MailListModel startFetch(String imap, String storeType, String user, String password) 
            throws NoSuchProviderException, MessagingException {
        Data.clear(); //clear old linked list
        Session emailSession = getSession.getSession(imap, storeType, user, password);               
        try (Store store = emailSession.getStore(storeType)) {
            store.connect();
            Folder emailFolder = store.getFolder(foldername.getTrashYahoo());
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
                }
            }
        }
        return mailListModel;
    }
    
}
