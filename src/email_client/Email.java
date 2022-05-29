/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email_client;

/**
 *
 * @author Administrator
 */
public class Email {
    private final String userName;
    private final String pass;
    private final String[] to;
    private final String[] cc;
    private final String[] bcc;
    private final String subject;
    private final String text;
    private final String filePath;

    public Email(String userName, String pass, String[] to, String[] cc, String[] bcc, String subject, String text, String filePath) {
        this.userName = userName;
        this.pass = pass;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.text = text;
        this.filePath = filePath;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String[] getTo() {
        return to;
    }

    public String[] getCc() {
        return cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getFilePath() {
        return filePath;
    }
    
    
}
