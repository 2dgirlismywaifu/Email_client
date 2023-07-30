package com.notelysia.emailclient.global;

import com.notelysia.emailclient.function.DeleteMail;
import com.notelysia.emailclient.sqlitehelper.SQLiteHelper;
import com.notelysia.emailclient.utils.FetchContentMail;
import com.notelysia.emailclient.utils.FetchContentPlainText;
import com.notelysia.emailclient.utils.FetchInbox;
import com.notelysia.emailclient.utils.SearchMail;
import com.notelysia.emailclient.utils.gmail.GmailSent;
import com.notelysia.emailclient.utils.gmail.GmailSpam;
import com.notelysia.emailclient.utils.gmail.GmailTrash;
import com.notelysia.emailclient.utils.outlook.OutlookSent;
import com.notelysia.emailclient.utils.outlook.OutlookSpam;
import com.notelysia.emailclient.utils.outlook.OutlookTrash;
import com.notelysia.emailclient.utils.yahoo.YahooSent;
import com.notelysia.emailclient.utils.yahoo.YahooSpam;
import com.notelysia.emailclient.utils.yahoo.YahooTrash;
import java.io.IOException;
import java.sql.*;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//Void cho các Thread inbox, sent, trash và spam ở HomePage.java
public class GlobalVoid {

    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection connection = SQLiteHelper.getConnection();
    FolderMailName foldername = new FolderMailName();
    PreparedStatement ps;
    ResultSet rs;
    ////////////////////////////////////////////
    public String imap;
    public String storeType;
    public String user;
    public String password;
    public String server;
    
    public String getImap() {
        return imap;
    }
    public void setImap(String imap) {
        this.imap = imap;
    }
    public String getStoreType() {
        return storeType;
    }
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }
    
///////////////////////////////////////////
    FetchInbox fetchInbox = new FetchInbox();
    FetchContentMail getContent = new FetchContentMail();
    FetchContentPlainText contentPlainText = new FetchContentPlainText();
    DeleteMail delete = new DeleteMail();
    SearchMail searchMail = new SearchMail();
    //Tài khoản Gmail   
    GmailSent sentGmail = new GmailSent();
    GmailSpam spamGmail = new GmailSpam();
    GmailTrash trashGmail = new GmailTrash();
    //Tài khoản Outlook, Office 365   
    OutlookSent sentOutlook = new OutlookSent();
    OutlookSpam spamOutlook = new OutlookSpam();
    OutlookTrash trashOutlook = new OutlookTrash();
    //Tài khoản Yahoo Mail   
    YahooSent sentYahoo = new YahooSent();
    YahooSpam spamYahoo = new YahooSpam();
    YahooTrash trashYahoo = new YahooTrash();
    //</editor-fold>

    public GlobalVoid(String imap, String storeType, String user, String password, String server) {
        this.imap = imap;
        this.storeType = storeType;
        this.user = user;
        this.password = password;
        this.server = server;
    }
  
    public GlobalVoid getInformation(JComboBox emailList)
            throws SQLException, MessagingException {
        ps = connection.prepareStatement("SELECT email, password, imap, type, server FROM email WHERE email = ?");
        ps.setString(1, emailList.getSelectedItem().toString());
        rs = ps.executeQuery();

        this.imap = rs.getString("imap");
        this.storeType = rs.getString("type");
        this.user = rs.getString("email");
        this.password = rs.getString("password");
        this.server = rs.getString("server");

        return new GlobalVoid(imap, storeType, user, password, server);
    }

    public void getInbox(JComboBox emailList, DefaultTableModel model, JTable mailList)
            throws SQLException, MessagingException {
        GlobalVoid info = getInformation(emailList);
        model = fetchInbox.startFetch(info.imap, info.storeType, info.user, info.password);
        mailList.setModel(model);
        model.setRowCount(0);
    }

    public void getSent(JComboBox emailList, DefaultTableModel model, JTable mailList, JLabel folderMailName)
            throws SQLException, MessagingException {
        GlobalVoid info = getInformation(emailList);
        switch (info.server) {
            case "gmail" -> {
                model = sentGmail.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getSentGmail());
                break;
            }
            case "outlook" -> {
                model = sentOutlook.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getSentOutlook());
                break;
            }
            case "yahoo" -> {
                model = sentYahoo.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getSentYahoo());
                break;
            }
            default -> {
                break;
            }
        }
    }

    public void getSpam(JComboBox emailList, DefaultTableModel model, JTable mailList, JLabel folderMailName)
            throws SQLException, MessagingException {
        GlobalVoid info = getInformation(emailList);
        switch (info.server) {
            case "gmail" -> {
                model = spamGmail.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getSpamGmail());
                break;
            }
            case "outlook" -> {
                model = spamOutlook.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getSpamOutlook());
                break;
            }
            case "yahoo" -> {
                spamYahoo.notifyMesseage();
            }
            default -> {
                break;
            }
        }
    }

    public void getTrash(JComboBox emailList, DefaultTableModel model, JTable mailList, JLabel folderMailName)
            throws SQLException, MessagingException {
        GlobalVoid info = getInformation(emailList);
        switch (info.server) {
            case "gmail" -> {
                model = trashGmail.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getTrashGmail());
                break;
            }
            case "outlook" -> {
                model = trashOutlook.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getTrashOutlook());
                break;
            }
            case "yahoo" -> {
                model = trashYahoo.startFetch(info.imap, info.storeType, info.user, info.password);
                mailList.setModel(model);
                model.setRowCount(0);
                folderMailName.setText(foldername.getTrashYahoo());
                break;
            }
            default -> {
                break;
            }
        }
    }

    public void loadContentMail(String storeType, JComboBox emailList, JLabel folderMailName, 
            int rowSelected, JEditorPane mailMessage)
            throws SQLException, MessagingException, NoSuchProviderException, IOException {
        GlobalVoid info = getInformation(emailList);
        getContent.readEmail(rowSelected, info.imap, storeType, info.user, info.password, mailMessage);
    }

    public void loadPlainText(String storeType, JComboBox emailList, DefaultTableModel model, 
            JTable mailList, JLabel folderMailName, int rowSelected, JEditorPane mailMessage)
            throws SQLException, MessagingException, IOException, Exception {
        GlobalVoid info = getInformation(emailList);
        contentPlainText.plainTextShow(rowSelected, info.imap, storeType, info.user, info.password, mailMessage);
    }

    public void loadSearchContent(JComboBox emailList, String mailsearchInput, String typeSearch, 
            String foldermailname, int rowSelected, JEditorPane mailMessage)
            throws SQLException, MessagingException, IOException {
        GlobalVoid info = getInformation(emailList);
        searchMail.fetchResultContent(info.imap, info.storeType, info.user, info.password,
                mailsearchInput, typeSearch, foldermailname, rowSelected, mailMessage);
    }

    public void deleteMail(String storeType, JComboBox emailList, int rowSelected, JEditorPane mailMessage)
            throws SQLException, MessagingException, IOException {
        GlobalVoid info = getInformation(emailList);
        delete.deleteEmail(rowSelected, info.imap, storeType, info.user, info.password, mailMessage);
    }

    public void searchMail(JComboBox emailList, DefaultTableModel model, String mailsearchInput, String typeSearch,
            String mailfolder, JTable mailList, JLabel searchStatus) throws SQLException, MessagingException {
        GlobalVoid info = getInformation(emailList);
        mailList.setEnabled(true);
        model = searchMail.startFetch(info.imap, info.storeType, info.user, info.password, mailsearchInput, typeSearch, mailfolder);
        mailList.setModel(model);
        model.setRowCount(0);
        searchStatus.setText("Hoàn thành...");
    }
}
