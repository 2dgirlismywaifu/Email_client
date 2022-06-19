package email_client.callFrame;

import email_client.SendEmail;
import email_client.global.LookandFeel;
import email_client.global.macOS.mainForm;

//sendEmail, Forward Email, Reply Email
public class frameSendEmail {
    SendEmail frame = new SendEmail();
    String fullcontent;
    //Send Email Frame
    public void callSendframe(String email) {
        LookandFeel.setTheme();
        /* Create and display the form */
        mainForm.isMacOS();
        java.awt.EventQueue.invokeLater(() -> {                     
            mainForm.isMacFullWindowContentSupported(frame);
            frame.clearInput();
            frame.setVisible(true);
            frame.setTitle("Soạn thư");
            frame.emailFrom.setText(email);
        });
    }
    //Forward Email Frame
    public void callForwardframe(String email, String fromUser, String date, 
            String subject, String content, String foldername, int rowSelected) 
    {
        LookandFeel.setTheme();
        /* Create and display the form */
        mainForm.isMacOS();
        java.awt.EventQueue.invokeLater(() -> {                     
            mainForm.isMacFullWindowContentSupported(frame);         
            frame.toField.setText("");
            frame.setVisible(true);
            frame.setTitle("Chuyển tiếp thư");
            frame.emailFrom.setText(email);
            frame.subjectField.setText(subject);
            frame.subjectField.setEditable(false);
            fullcontent = "\n\n\n\n\n====================Chuyển tiếp thư gốc====================\n" +
                    "Người gửi:" + fromUser + "\n" +
                    "Người nhận: " + email + "\n" + 
                    "Ngày nhận: " + date + "\n" +
                    "Nội dung thư chuyển đi: " + "\n" + content;
            frame.mailField.setText(fullcontent);
        });
    }
    //Reply Email Frame
    public void callReplyframe(String email, String fromUser, String date, 
            String subject, String content, String foldername, int rowSelected) 
    {
        LookandFeel.setTheme();
        /* Create and display the form */
        mainForm.isMacOS();
        java.awt.EventQueue.invokeLater(() -> {                     
            mainForm.isMacFullWindowContentSupported(frame);          
            frame.setVisible(true);
            frame.setTitle("Trả lời thư");
            frame.emailFrom.setText(email);
            frame.toField.setText(fromUser);
            frame.subjectField.setText(subject);
            frame.subjectField.setEditable(false);
            fullcontent = "\n\n\n\n\n====================Trả lời thư gốc====================\n" +
                    "Người gửi:" + fromUser + "\n" +
                    "Người nhận: " + email + "\n" + 
                    "Ngày nhận: " + date + "\n" +
                    "Nội dung thư trả lời: " + "\n" + content;
            frame.mailField.setText(fullcontent);
        });
    }
}
