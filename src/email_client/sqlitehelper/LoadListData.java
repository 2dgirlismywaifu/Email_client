package email_client.sqlitehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoadListData {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    Connection connection = SQLiteHelper.getConnection(); 
    DefaultTableModel tableModel;
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    
    public void manageAccountTable(JTable tableAccount) {
        int countColumn;
            
        try {
            ps = connection.prepareStatement("SELECT * FROM email");
            rs = ps.executeQuery();
            
            ResultSetMetaData rad = rs.getMetaData();
            countColumn = rad.getColumnCount();
            
            tableModel = (DefaultTableModel)tableAccount.getModel();
            tableModel.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= countColumn; i++) {
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("name"));                                                    
                }
                tableModel.addRow(v2);
            }
             tableModel.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(LoadListData.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void loadEmailList(JComboBox emailList) {                
        try {
            ps = connection.prepareStatement("SELECT email FROM email");
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                emailList.addItem(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadListData.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
