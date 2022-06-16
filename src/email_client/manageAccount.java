/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package email_client;

import email_client.callFrame.frameAddAccount;
import email_client.dialogMess.AccountFailed;
import email_client.dialogMess.CheckAccountMesseage;
import email_client.global.CheckAccount;
import email_client.global.PortServices;
import email_client.global.IconImageUtilities;
import email_client.global.LookandFeel;
import email_client.sqlitehelper.sqlitehelper;
import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author notmiyouji
 */
public class manageAccount extends javax.swing.JFrame {
    Connection connection = sqlitehelper.getConnection();
    CheckAccount checkAcc = new CheckAccount();
    PortServices getServices = new PortServices();
    CheckAccountMesseage dialogChecking = new CheckAccountMesseage(this, true);
    DefaultTableModel tableModel;
    PreparedStatement ps; 
    ResultSet rs;
    String id, service, type, smtp, imap, email, pass, name, portTLS, portSSL, portIMAP;
    //portTLS, portSSL: outgoing messeage = STMP Server
    //portIMAP: incoming messeage = IMAP
    
    
    /** Creates new form addAccount */
    public manageAccount() {
        initComponents();
        //icon mặc định của phần mềm
        IconImageUtilities.setIconImage(this);
        loadTable();
        
    }
    
    private void loadTable() {
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
            Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void reEnableInput() {
        emailAccount.setEnabled(true);
        username.setEnabled(true);
        Server.setEnabled(true);
        imapServer.setEnabled(true);
        smtpServer.setEnabled(true);
        ConfirmBtn.setEnabled(true);
    }
    
    private void disableInput() {
        emailAccount.setEnabled(false);
        username.setEnabled(false);
        Server.setEnabled(false);
        imapServer.setEnabled(false);
        smtpServer.setEnabled(false);
        ConfirmBtn.setEnabled(false);
    }
    
    private void updateData(String id, String type, String service,  String smtp, String imap, String email, String password, String name, String portTLS, String portSSL, String portIMAP) throws SQLException {
        
            ps = connection.prepareStatement("UPDATE email SET name = ?, email = ?, password = ?, type = ?, "
                    + "server = ?, smtp = ?, imap = ? , portTLS = ?, portSSL = ?, portIMAP = ? WHERE  ID = ? ");
            //vì tên cho tài khoản email là không bắt buộc
            if (name.equals("")) {
                ps.setString(1, "NOT Available");
            }
            else {
            ps.setString(1, name);
            }
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, type);
            ps.setString(5, service);
            ps.setString(6, smtp);
            ps.setString(7, imap);
            ps.setString(8, portTLS);
            ps.setString(9, portSSL);
            ps.setString(10, portIMAP);
            ps.setString(11, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Cập nhật tài khoản thành công","Thêm tài khoản",JOptionPane.INFORMATION_MESSAGE);
                             
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        imapServer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Server = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        emailAccount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        smtpServer = new javax.swing.JComboBox<>();
        ConfirmBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAccount = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        addAccount = new javax.swing.JButton();
        deleteAccount = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        idEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passEmail = new javax.swing.JPasswordField();
        editPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Service");

        imapServer.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        imapServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "imap.gmail.com", "outlook.office365.com", "imap.mail.yahoo.com" }));
        imapServer.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("IMAP Server");

        Server.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        Server.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gmail", "outlook", "yahoo" }));
        Server.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Email");

        emailAccount.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        emailAccount.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tên tài khoản");

        username.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        username.setEnabled(false);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel7.setText("(Tùy chọn)");

        jLabel9.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("SMTP Server");

        smtpServer.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        smtpServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "smtp.gmail.com", "smtp.office365.com", "smtp.mail.yahoo.com" }));
        smtpServer.setEnabled(false);

        ConfirmBtn.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        ConfirmBtn.setText("Cập nhật thông tin");
        ConfirmBtn.setEnabled(false);
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });

        tableAccount.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        tableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAccountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAccount);

        jLabel8.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-64.png"))); // NOI18N
        jLabel8.setText("THÔNG TIN TÀI KHOẢN");

        addAccount.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        addAccount.setText("+");
        addAccount.setToolTipText("");
        addAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountActionPerformed(evt);
            }
        });

        deleteAccount.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        deleteAccount.setText("-");
        deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ID");

        idEmail.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        idEmail.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mật khẩu");

        passEmail.setEditable(false);
        passEmail.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        editPass.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        editPass.setText("Sửa mật khẩu");
        editPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        editPass.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        editPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addAccount)
                        .addGap(18, 18, 18)
                        .addComponent(deleteAccount))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(imapServer, javax.swing.GroupLayout.Alignment.LEADING, 0, 190, Short.MAX_VALUE)
                                        .addComponent(Server, javax.swing.GroupLayout.Alignment.LEADING, 0, 190, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editPass)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(smtpServer, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(passEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editPass))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imapServer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(smtpServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAccount)
                    .addComponent(deleteAccount))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
        // TODO add your handling code here:
        //imapServernhật thông tin tài khoản
        id = idEmail.getText();
        imap = imapServer.getSelectedItem().toString();
        service = Server.getSelectedItem().toString();
        type = "imaps";
        smtp = smtpServer.getSelectedItem().toString();
        email = emailAccount.getText(); //có thể bỏ qua, không cần nhập
        char[] getpassword = passEmail.getPassword();
        pass = new String (getpassword);
        name = username.getText();
        
        //Lấy các port
        portTLS = getServices.getPortTLS();
        portSSL = getServices.getPortSSL();
        portIMAP = getServices.getPortIMAP();
        
        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ trường thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        else {
            dialogChecking.setModalityType(Dialog.ModalityType.MODELESS);
            dialogChecking.setVisible(true);
            disableInput();
            Thread updateAccount = new Thread () { //thread cập nhật tài khoản
               @Override
               public void run() {
                   try {            
                    checkAcc.checkLogin(imap, type, email, pass);              
                    dialogChecking.setVisible(false);
                    updateData(id, type, service, smtp, imap, email, pass, name, portTLS, portSSL, portIMAP);
                    loadTable();                 
                    reEnableInput();
                    } catch (MessagingException | SQLException ex  ) {
                        Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
                        AccountFailed.NotifyMesseage();
                        dialogChecking.setVisible(false);
                        //kích hoạt lại input
                        reEnableInput();
                    }
               } 
            };
            updateAccount.start();
        }
        
    }//GEN-LAST:event_ConfirmBtnActionPerformed

    private void addAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountActionPerformed
        // TODO add your handling code here:
        //Thêm tài khoản
        this.dispose();
        frameAddAccount.callframe();
    }//GEN-LAST:event_addAccountActionPerformed

    private void tableAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAccountMouseClicked
        // TODO add your handling code here:
        //kích hoạt lại tất cả các input
        reEnableInput();
        //từ dữ liệu đang có trả lại về input
        tableModel = (DefaultTableModel)tableAccount.getModel();
        int selectIndex = tableAccount.getSelectedRow();        
        emailAccount.setText(tableModel.getValueAt(selectIndex, 0).toString());
        username.setText(tableModel.getValueAt(selectIndex, 1).toString());
        //lấy thông tin loại dịch vụ, loại (pop3 hay imap) và smtp server
        email = emailAccount.getText();
        name = username.getText();
        
        try {
            ps = connection.prepareStatement("SELECT id, imap, server, password, smtp FROM email WHERE email = ? and name = ?");
            ps.setString(1, email);
            ps.setString(2, name);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                idEmail.setText(rs.getString("id"));
                imapServer.setSelectedItem(rs.getString("imap"));
                Server.setSelectedItem(rs.getString("server"));
                passEmail.setText(rs.getString("password"));
                smtpServer.setSelectedItem(rs.getString("smtp"));             
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tableAccountMouseClicked

    private void deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountActionPerformed
        // TODO add your handling code here:
        //xóa tài khoản khỏi lưu trữ cục bộ       
        email = emailAccount.getText(); //có thể bỏ qua, không cần nhập     
        name = username.getText();
        
        try {
            ps = connection.prepareStatement("DELETE FROM email where email = ? and name = ?");
            ps.setString(1, email);
            ps.setString(2, name);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Đã xóa tài khoản","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            emailAccount.setText("");
            username.setText("");
            disableInput();
            //load lại bảng
            loadTable();
            
        } catch (SQLException ex) {
            Logger.getLogger(manageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteAccountActionPerformed

    private void editPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPassActionPerformed
        // TODO add your handling code here:
        if (editPass.isSelected()){
            passEmail.setEditable(true);
        } else {
            passEmail.setEditable(false);
        }
    }//GEN-LAST:event_editPassActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LookandFeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new manageAccount().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JComboBox<String> Server;
    private javax.swing.JButton addAccount;
    private javax.swing.JButton deleteAccount;
    private javax.swing.JCheckBox editPass;
    private javax.swing.JTextField emailAccount;
    private javax.swing.JTextField idEmail;
    private javax.swing.JComboBox<String> imapServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passEmail;
    private javax.swing.JComboBox<String> smtpServer;
    private javax.swing.JTable tableAccount;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
