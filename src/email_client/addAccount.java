package email_client;

import email_client.callFrame.frameManageAccount;
import email_client.dialogMess.*;
import email_client.global.*;
import email_client.sqlitehelper.InsertData;
import java.awt.Dialog;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.*;

public class addAccount extends javax.swing.JFrame {
    //<editor-fold defaultstate="collapsed" desc="Global Function">
    //log4j2
    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(addAccount.class);
    CheckAccountMesseage dialogChecking = new CheckAccountMesseage(this, true);
    CheckAccount checkAcc  =  new CheckAccount();
    PortServices getServices = new PortServices();
    InsertData insertData = new InsertData();
    EnableFunction enableFunction = new EnableFunction();
    DisableFunction disableFunction = new DisableFunction();
    //Khai báo mặc định các biến dùng chung
    String type, service, smtp, imap, email, pass, name, portTLS, portSSL, portIMAP;
    //portTLS, portSSL: outgoing messeage = STMP Server
    //portIMAP: incoming messeage = IMAP
    //</editor-fold>
    /** Creates new form addAccount */
    public addAccount() {
        initComponents();
        //icon mặc định của phần mềm
        IconImageUtilities.setIconImage(this);       
        hideProblem();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Services = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        emailAccount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        showPasswordCheck = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TwoFAHelper = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        smtpServer = new javax.swing.JComboBox<>();
        ConfirmBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        passwordEmail = new javax.swing.JPasswordField();
        passProblem = new javax.swing.JLabel();
        emailProblem = new javax.swing.JLabel();
        smtpProblem = new javax.swing.JLabel();
        servicesProblem = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        imapServer = new javax.swing.JComboBox<>();
        imapProblem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm tài khoản");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-64.png"))); // NOI18N
        jLabel1.setText("Thêm tài khoản");

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Dịch vụ");

        Services.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        Services.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gmail", "outlook", "yahoo" }));

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Email");

        emailAccount.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mật khẩu");

        showPasswordCheck.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        showPasswordCheck.setText("Hiện mật khẩu");
        showPasswordCheck.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showPasswordCheck.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        showPasswordCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tên Email");

        username.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel7.setText("(Tùy chọn)");

        TwoFAHelper.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        TwoFAHelper.setForeground(new java.awt.Color(51, 51, 255));
        TwoFAHelper.setText("Bắt buộc chế độ xác thực hai bước");
        TwoFAHelper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TwoFAHelperMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("SMTP");

        smtpServer.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        smtpServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "smtp.gmail.com", "smtp.office365.com", "smtp.mail.yahoo.com" }));

        ConfirmBtn.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        ConfirmBtn.setText("OK");
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });

        CancelBtn.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        CancelBtn.setText("Hủy Bỏ");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        passwordEmail.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        passProblem.setFont(new java.awt.Font("SF Pro Display", 0, 20)); // NOI18N
        passProblem.setForeground(new java.awt.Color(255, 0, 0));
        passProblem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passProblem.setText("*");
        passProblem.setToolTipText("");
        passProblem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        emailProblem.setFont(new java.awt.Font("SF Pro Display", 0, 20)); // NOI18N
        emailProblem.setForeground(new java.awt.Color(255, 0, 0));
        emailProblem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailProblem.setText("*");
        emailProblem.setToolTipText("");
        emailProblem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        smtpProblem.setFont(new java.awt.Font("SF Pro Display", 0, 20)); // NOI18N
        smtpProblem.setForeground(new java.awt.Color(255, 0, 0));
        smtpProblem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        smtpProblem.setText("*");
        smtpProblem.setToolTipText("");
        smtpProblem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servicesProblem.setFont(new java.awt.Font("SF Pro Display", 0, 20)); // NOI18N
        servicesProblem.setForeground(new java.awt.Color(255, 0, 0));
        servicesProblem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servicesProblem.setText("*");
        servicesProblem.setToolTipText("");
        servicesProblem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("IMAP");

        imapServer.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        imapServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "imap.gmail.com", "outlook.office365.com", "imap.mail.yahoo.com" }));

        imapProblem.setFont(new java.awt.Font("SF Pro Display", 0, 20)); // NOI18N
        imapProblem.setForeground(new java.awt.Color(255, 0, 0));
        imapProblem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imapProblem.setText("*");
        imapProblem.setToolTipText("");
        imapProblem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(servicesProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Services, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(smtpServer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TwoFAHelper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imapServer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(smtpProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(passProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67)
                                                .addComponent(showPasswordCheck))
                                            .addComponent(imapProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Services, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesProblem))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailProblem))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(showPasswordCheck)
                    .addComponent(passwordEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passProblem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TwoFAHelper)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(smtpServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smtpProblem))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(imapServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imapProblem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmBtn)
                    .addComponent(CancelBtn))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   ////////////////////Đây là lỗi đầu vào/////////////////////////////
    private void hideProblem() {
        emailProblem.setVisible(false);
        passProblem.setVisible(false);
        smtpProblem.setVisible(false);
        servicesProblem.setVisible(false);
        imapProblem.setVisible(false);
    }
    
    private void showProblem() {
        emailProblem.setVisible(true);
        passProblem.setVisible(true);
        smtpProblem.setVisible(true);
        servicesProblem.setVisible(true);
        imapProblem.setVisible(true);
    }
    ///////////////////////////////////////////////////////////
    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
        // TODO add your handling code here:
        //passworldfield luôn ở dạng array
        char[] getpassword = passwordEmail.getPassword();
        //thêm dữ liệu tài khoản vào CSDL
        type = "imaps";
        service = Services.getSelectedItem().toString();
        smtp = smtpServer.getSelectedItem().toString();
        imap = imapServer.getSelectedItem().toString();
        email = emailAccount.getText(); //có thể bỏ qua, không cần nhập
        pass = new String (getpassword);
        name = username.getText();
        
         //Lấy các port
        portTLS = getServices.getPortTLS();
        portSSL = getServices.getPortSSL();
        portIMAP = getServices.getPortIMAP();
        
        //kiểm tra thông tin có nhập thiếu không
        if (email.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ trường thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
                emailProblem.setVisible(true);
                passProblem.setVisible(true);
                emailProblem.setToolTipText("Vui lòng điền tài khoản email");
                passProblem.setToolTipText("Vui lòng điền mật khẩu");
         }      
        //kiểm tra email có đúng mẫu: example@domain.com
        else if (RegexEmail.validation(email) == true) 
        {       
            dialogChecking.setModalityType(Dialog.ModalityType.MODELESS);
            dialogChecking.setVisible(true);
            hideProblem();
            disableFunction.disableAddAccountFunction(Services, emailAccount, username, passwordEmail, smtpServer, imapServer, ConfirmBtn, CancelBtn);
            Thread addAccount = new Thread() { //thread thêm tài khoản
                @Override
                public void run() {
                    try {                    
                        checkAcc.checkLogin(imap, type, email, pass);
                        dialogChecking.setVisible(false);
                        insertData.insertAccount(type, service, smtp, imap, email, pass, name, portTLS, portSSL, portIMAP);
                        dispose();
                        frameManageAccount.callframe();
                        } catch (MessagingException ex) {
                            logger.error("Exceptions happen: " + ex, ex);
                            dialogChecking.setVisible(false);
                            AccountFailed.NotifyMesseage();                      
                            enableFunction.enableAddAccountFunction(Services, emailAccount, username, passwordEmail, smtpServer, imapServer, ConfirmBtn, CancelBtn);
                            showProblem();
                            emailProblem.setToolTipText("Vui lòng kiểm tài khoản email");
                            passProblem.setToolTipText("Mật khẩu sai hoặc tài khoản dùng xác thực hai bước");
                            smtpProblem.setToolTipText("Kiểm tra SMTP của tài khoản");
                            servicesProblem.setToolTipText("Kiểm tra dịch vụ email của bạn");
                            imapServer.setToolTipText("Kiểm tra IMAP của tài khoản");
                    }
                } 
            };
            addAccount.start();             
        }  
        else
            {
                JOptionPane.showMessageDialog(this, "Email không đúng mẫu: example@domain.com", "Thông báo", JOptionPane.ERROR_MESSAGE);
                emailProblem.setVisible(true);            
                emailProblem.setToolTipText("Kiểm tra lại email của bạn");
            }
    }//GEN-LAST:event_ConfirmBtnActionPerformed

    private void TwoFAHelperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwoFAHelperMouseClicked
        // TODO add your handling code here:
        //Chú ý: Với các tài khoản có xác thực hai bước đã bật
        TwoFANotify.NotifyMesseage();
    }//GEN-LAST:event_TwoFAHelperMouseClicked

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frameManageAccount.callframe();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void showPasswordCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckActionPerformed
        // TODO add your handling code here:
        //hiện hoặc ẩn mật khẩu
        if (showPasswordCheck.isSelected()){
            passwordEmail.setEchoChar((char)0);
        } else {
            passwordEmail.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordCheckActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:     
        frameManageAccount.callframe();
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LookandFeel.setTheme();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new addAccount().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JComboBox<String> Services;
    private javax.swing.JLabel TwoFAHelper;
    private javax.swing.JTextField emailAccount;
    private javax.swing.JLabel emailProblem;
    private javax.swing.JLabel imapProblem;
    private javax.swing.JComboBox<String> imapServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel passProblem;
    private javax.swing.JPasswordField passwordEmail;
    private javax.swing.JLabel servicesProblem;
    private javax.swing.JCheckBox showPasswordCheck;
    private javax.swing.JLabel smtpProblem;
    private javax.swing.JComboBox<String> smtpServer;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
