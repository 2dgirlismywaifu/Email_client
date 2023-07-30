package com.notelysia.emailclient.global;

import javax.swing.*;

public class DisableFunction {
    //HomePage
    public void HomePageFunction(JButton composeMail, JButton inboxMail, JButton sentMail, 
            JButton spamMail, JButton trashMail, JButton deleteMail, JButton replyMail, 
            JButton forwardMail, JButton plainTextBtn, JButton mailMessage) {
        composeMail.setEnabled(false);
        inboxMail.setEnabled(false);
        sentMail.setEnabled(false);
        spamMail.setEnabled(false);
        trashMail.setEnabled(false);
        deleteMail.setEnabled(false);
        replyMail.setEnabled(false);
        forwardMail.setEnabled(false);
        plainTextBtn.setEnabled(false);
        mailMessage.setEnabled(false);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    //adAccount
    public void disableAddAccountFunction(JComboBox Services, JTextField emailAccount, JTextField username, 
            JPasswordField passwordEmail, JComboBox smtpServer, JComboBox imapServer, 
            JButton ConfirmBtn, JButton CancelBtn) {    
        Services.setEnabled(false);
        emailAccount.setEnabled(false);
        username.setEnabled(false);
        passwordEmail.setEnabled(false);
        smtpServer.setEnabled(false);
        imapServer.setEnabled(false);
        ConfirmBtn.setEnabled(false);
        CancelBtn.setEnabled(false);
    }
    //manageAccount
     public void disableManageAccount(JTextField emailAccount, JTextField username, JComboBox Server, 
             JComboBox imapServer, JComboBox smtpServer, JButton ConfirmBtn) {
        emailAccount.setEnabled(false);
        username.setEnabled(false);
        Server.setEnabled(false);
        imapServer.setEnabled(false);
        smtpServer.setEnabled(false);
        ConfirmBtn.setEnabled(false);
    }
    //senEmail
    public void DisableSendMail(JButton sendBtn, JTextField toField, JTextField ccField, JTextField BccField,
            JTextField subjectField, JButton attachmentBtn) {
        sendBtn.setEnabled(false);
        toField.setEnabled(false);
        ccField.setEnabled(false);
        BccField.setEnabled(false);
        subjectField.setEnabled(false);
        attachmentBtn.setEnabled(false);
    }
}
