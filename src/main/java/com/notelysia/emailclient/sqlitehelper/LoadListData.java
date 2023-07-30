package com.notelysia.emailclient.sqlitehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;

public class LoadListData {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoadListData.class);
    Connection con; 
    DefaultTableModel tableModel;
    PreparedStatement ps; 
    ResultSet rs;  
    //</editor-fold>
    
    public void manageAccountTable(JTable tableAccount) {
        int countColumn;
        con = SQLiteHelper.getConnection();    
        try {
            ps = con.prepareStatement("SELECT * FROM email");
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
            con.close();
        } catch (SQLException ex) {
            logger.error("Exceptions happen: " + ex, ex);
        } 
    }
    public void loadEmailList(JComboBox emailList) {
        con = SQLiteHelper.getConnection();
        try {
            ps = con.prepareStatement("SELECT email FROM email");
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                emailList.addItem(email);
            }
            con.close();
        } catch (SQLException ex) {
            logger.error("Exceptions happen: " + ex, ex);
        }        
    }
}
