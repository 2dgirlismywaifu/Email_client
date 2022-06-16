package email_client.function;

import email_client.global.PropertiesAPI;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class globalAction {
    
    PropertiesAPI propertiesAPI = new PropertiesAPI();
    
    public Session Login(String username, String pass, String smtp, String portSSL) {
        Properties props = new Properties();
        props.put(propertiesAPI.getSmtpAuth(), "true");
        props.put(propertiesAPI.getSmtpHost(), smtp);
        props.put(propertiesAPI.getSmtpSocketPort(), portSSL);
        props.put(propertiesAPI.getSmtpSocketClass(), "javax.net.ssl.SSLSocketFactory");
        props.put(propertiesAPI.getSmtpPort(), portSSL);
        props.put(propertiesAPI.getSmtpTLS(), "true"); //enable STARTTLS
        props.put(propertiesAPI.getDebug(), "true");
        PasswordAuthentication Auth = new PasswordAuthentication(username, pass);
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return Auth;
            }
        });
        return session;
    }

    private String[] getListEmail(String str) {
        if (str.equals("")) {
            return null;
        } else if (!str.contains(",")) {
            String[] strArr = {str};
            return strArr;
        }
        return str.split(",");
    }

    public void SendAction(String username, String pass, String smtp, String portSSL, 
            String touser, String subject, String cc, String bcc, String attachment,String mailField) {        
        String[] listTo = getListEmail(touser.trim());
        String[] listCc = getListEmail(cc.trim());
        String[] listBcc = getListEmail(bcc.trim());                     
        Session sess = Login(username, pass, smtp, portSSL);
        SendMail sender = new SendMail(sess);
        System.out.println(attachment);
        sender.sendEmail(listTo, listCc, listBcc, mailField, attachment, subject);
    }    
}
