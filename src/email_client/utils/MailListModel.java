package email_client.utils;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MailListModel extends  AbstractTableModel{
    
    private  String[] hearders = {"Người Gửi", "Tiêu Đề",  "Thời Gian"};
    private List<MailList> Data = new  LinkedList<>();

    public   MailListModel(String[] hearders,List<MailList> Data)
    {
        this.hearders   =hearders;
        this.Data  = Data;
    }
    @Override
    public int getRowCount() {
        if(Data!=null)
        {
            return  Data.size();
        }
        return  0;
    }
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
        switch(columnIndex)
                {
            case  0:
                return row.getFrom();
            case 1:
                return  row.getSubject();
            case 2:
                return  row.getDate();
            default:
                return "";
        }
    }
    
}
