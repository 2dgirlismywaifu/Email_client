package email_client.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.mail.Message;
import javax.swing.table.AbstractTableModel;

public class MailListModel extends  AbstractTableModel{
    
    private  String[] hearders = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
    private List<MailList> Data = new  LinkedList<>();

    public MailListModel(String[] hearders,List<MailList> Data)
    {
        this.hearders = hearders;
        this.Data = Data;
    }
    
    private ArrayList messageList = new ArrayList();

   
     

    public void setMessages(Message[] messages) {
        for (int i = messages.length - 1; i >= 0; i--) {
            messageList.add(messages[i]);
        }
         
     
        fireTableDataChanged();
    }
     
    
    public Message getMessage(int row) {
        return (Message) messageList.get(row);
    }
    
    @Override
    public int getRowCount() {
        if(Data!=null)
        {
            return  Data.size();
        }
        return  0;
    }
    @Override
    public String getColumnName(int columnIndex)
    {
        if(columnIndex<getColumnCount())
        {
            return hearders[columnIndex];
        }
        return "";
    }
    @Override
    public int getColumnCount() {
         if(hearders!=null)
        {
            return  hearders.length;
        }
        return  0;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex> getRowCount()||columnIndex>getColumnCount())
        {
            return "";
        }
        MailList row = Data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> row.getFrom();
            case 1 -> row.getSubject();
            case 2 -> row.getDate();
            default -> "";
        };
    }
    
}
