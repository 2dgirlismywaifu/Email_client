package com.notelysia.emailclient.global;

import javax.swing.JOptionPane;

public class MailboxEmpty {
    public void callNotify() {
        JOptionPane.showMessageDialog(null, "Hộp thư trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }   
}
