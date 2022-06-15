package email_client.utils;

import java.util.ArrayList;
import java.util.Date;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.table.AbstractTableModel;

public class MailListModel extends  AbstractTableModel {
    
    private static final String[] columnNames = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
      
    
    private ArrayList messageList = new ArrayList();
     

    public void setMessages(Message[] messages) {
        for (int i = messages.length - 1; i >= 0; i--) {
            messageList.add(messages[i]);
        }
              
        fireTableDataChanged();
    }
     
    public void setModel() {
        
    }
    
    public Message getMessage(int row) {
        return (Message) messageList.get(row);
    }
     
    
    public void deleteMessage(int row) {
        messageList.remove(row);
         
       
        fireTableRowsDeleted(row, row);
    }
     
   
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
     

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
     
  
    @Override
    public int getRowCount() {
        return messageList.size();
    }
     
    
    @Override
    public Object getValueAt(int row, int col) {
        try {
            Message message = (Message) messageList.get(row);
            switch (col) {
                case 0 -> { 
                    Address[] senders = message.getFrom();
                    if (senders != null || senders.length > 0) {
                        return senders[0].toString();
                    } else {
                        return "[none]";
                    }
                }
                case 1 -> {
                    // Subject
                    String subject = message.getSubject();
                    if (subject != null && subject.length() > 0) {
                        return subject;
                    } else {
                        return "[none]";
                    }
                }
                case 2 -> {
                    // Date
                    Date date = message.getSentDate();
                    if (date != null) {
                        return date.toString();
                    } else {
                        return "[none]";
                    }
                }
            }
        } catch (MessagingException e) {
           
            return "";
        }
         
        return "";
    }
    
}
