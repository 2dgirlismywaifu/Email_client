package com.notelysia.emailclient.global;

import javax.swing.*;


public class EnableFunction {
    public void HomePageFunction(JButton composeMail, JButton inboxMail, JButton sentMail, 
            JButton spamMail, JButton trashMail, JButton deleteMail, JButton replyMail, 
            JButton forwardMail, JButton plainTextBtn, JButton mailMessage) {
        composeMail.setEnabled(true);
        inboxMail.setEnabled(true);    
        sentMail.setEnabled(true);
        spamMail.setEnabled(true);
        trashMail.setEnabled(true);
        deleteMail.setEnabled(true);
        replyMail.setEnabled(true);
        forwardMail.setEnabled(true);
        plainTextBtn.setEnabled(true);
        mailMessage.setEnabled(true);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    //adAccount
    public void enableAddAccountFunction(JComboBox Services, JTextField emailAccount, JTextField username, 
            JPasswordField passwordEmail, JComboBox smtpServer, JComboBox imapServer, 
            JButton ConfirmBtn, JButton CancelBtn) {    
        Services.setEnabled(true);
        emailAccount.setEnabled(true);
        username.setEnabled(true);
        passwordEmail.setEnabled(true);
        smtpServer.setEnabled(true);
        imapServer.setEnabled(true);
        ConfirmBtn.setEnabled(true);
        CancelBtn.setEnabled(true);
    }
    //manageAccount
    public void enableManageAccount(JTextField emailAccount, JTextField username, JComboBox Server, 
             JComboBox imapServer, JComboBox smtpServer, JButton ConfirmBtn) {
        emailAccount.setEnabled(true);
        username.setEnabled(true);
        Server.setEnabled(true);
        imapServer.setEnabled(true);
        smtpServer.setEnabled(true);
        ConfirmBtn.setEnabled(true);
    }
    //senEmail
    public void EnableSendMail(JButton sendBtn, JTextField toField, JTextField ccField, JTextField BccField,
            JTextField subjectField, JButton attachmentBtn) {
        sendBtn.setEnabled(true);
        toField.setEnabled(true);
        ccField.setEnabled(true);
        BccField.setEnabled(true);
        subjectField.setEnabled(true);
        attachmentBtn.setEnabled(true);
    }
}
