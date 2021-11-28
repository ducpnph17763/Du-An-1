/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.ChucNang;

import Dao.TaiKhoanDAO;
import Helper.MsgBox;
import Model.TaiKhoan;
import UI.NguoiDung.NguoiDungHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;
import Model.KhachHang;
import Model.ThongTinKhachHang;

/**
 *
 * @author Admin
 */
public class DangKy extends javax.swing.JFrame {
    int randomCode;
    private int index;
    private TaiKhoanDAO dao;
    private DefaultTableModel model;
    private List<TaiKhoan> list = new ArrayList<>();
    /**
     * Creates new form DangKy
     */
    public DangKy() {
//        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.dao = new TaiKhoanDAO();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtFullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtRe_Pass = new javax.swing.JPasswordField();
        txtPass = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(84, 141, 251));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 28, 110, 28));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tài khoản");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator1.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 248, 10));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator2.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 248, 10));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Xác nhận mật khẩu");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, -1));

        jSeparator3.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator3.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 248, 10));

        txtFullName.setBackground(new java.awt.Color(84, 141, 251));
        txtFullName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFullName.setBorder(null);
        jPanel1.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 248, 29));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Họ Tên");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator4.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 248, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator5.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 248, 10));

        txtPhoneNumber.setBackground(new java.awt.Color(84, 141, 251));
        txtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        txtPhoneNumber.setBorder(null);
        jPanel1.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 248, 29));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số điện thoại");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(84, 141, 251));
        jSeparator6.setForeground(java.awt.Color.white);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 248, 10));

        btnRegister.setBackground(new java.awt.Color(255, 255, 255));
        btnRegister.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(9, 65, 174));
        btnRegister.setText("Đăng ký");
        btnRegister.setBorder(null);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 140, 30));

        btnBack.setBackground(new java.awt.Color(84, 141, 251));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        txtRe_Pass.setBackground(new java.awt.Color(84, 141, 251));
        txtRe_Pass.setBorder(null);
        txtRe_Pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRe_PassActionPerformed(evt);
            }
        });
        jPanel1.add(txtRe_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 30));

        txtPass.setBackground(new java.awt.Color(84, 141, 251));
        txtPass.setBorder(null);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 250, 30));

        txtEmail.setBackground(new java.awt.Color(84, 141, 251));
        txtEmail.setBorder(null);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 250, 30));

        txtTK.setBackground(new java.awt.Color(84, 141, 251));
        txtTK.setBorder(null);
        jPanel1.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
//    TaiKhoan tk = this.getForm();
//        System.out.println("TK: "+tk.getTenTK());
//        System.out.println("MK: "+tk.getMatKhau());
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtRe_PassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRe_PassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRe_PassActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        check();
//        insert();
    }//GEN-LAST:event_btnRegisterActionPerformed

    public void check() {
        if (txtTK.getText().trim().length() == 0) {
            MsgBox.alert(this, "Tài khoản không được để trống!");
            txtTK.requestFocus();
        } else if (txtTK.getText().trim().length() > 20) {
            MsgBox.alert(this, "Tài khoản không được quá 20 kí tự!");
            txtTK.requestFocus();
        } else if (txtPass.getText().trim().length() == 0) {
            MsgBox.alert(this, "Mật khẩu không được để trống!");
            txtPass.requestFocus();
        } else if (txtRe_Pass.getText().trim().length() == 0) {
            MsgBox.alert(this, "Xác nhận mật khẩu không được để trống!");
            txtRe_Pass.requestFocus();
        } else if (!txtRe_Pass.getText().matches(txtPass.getText())) {
            MsgBox.alert(this, "Xác nhận mật khẩu không trùng với mật khảu!");
            txtRe_Pass.requestFocus();
        } else if (txtPhoneNumber.getText().trim().length() == 0) {
            MsgBox.alert(this, "Số điện thoại không được để trống!");
            txtPhoneNumber.requestFocus();
        } else if (!txtPhoneNumber.getText().matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
            MsgBox.alert(this, "Số điện thoại không hợp lệ!");
            txtPhoneNumber.requestFocus();
        } else if (txtEmail.getText().trim().length() == 0) {
            MsgBox.alert(this, "Email không được để trống!");
            txtEmail.requestFocus();
        } else if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            MsgBox.alert(this, "Email không hợp lệ!");
            txtEmail.requestFocus();
        } else {
            guiMaCode();
            this.dispose();
//            TaiKhoan tk = getForm();
//            KhachHang kh = getFormKH();
//            ThongTinKhachHang tt = getFormTT();
            KichHoatTK kichhoat = new KichHoatTK(randomCode, txtTK.getText(),txtPass.getText(), txtFullName.getText(), txtEmail.getText(), txtPhoneNumber.getText());            
            kichhoat.setVisible(true);
        }
    }
    
    public void guiMaCode(){
        try {
                    Random rand = new Random();
                    randomCode = rand.nextInt(899999) + 100000;
                    String host = "smtp.gmail.com";
                    String user = "trantuyetnhi185@gmail.com";
                    String pass = "Maihuong123225";
                    String to = txtEmail.getText();
                    String subject = "Reseting Code";
                    String message = "Your reset code is " + randomCode;
                    boolean sessionDebug = false;
                    Properties props = System.getProperties();
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "host");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");
                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address = {new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    MsgBox.alert(this, "Code đã được gửi về email");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
//
//    public TaiKhoan getForm(){
//        TaiKhoan tk = new TaiKhoan();
//        tk.setTenTK(txtTK.getText());
//        tk.setMatKhau(new String(txtPass.getPassword()));
//        tk.setVaiTro(3);
//        tk.setTrangThai("Hoạt động");
//        return tk;
//    }
//    public void setForm(TaiKhoan tk){
//        this.txtTK.setText(tk.getTenTK());
//        this.txtPass.setText(tk.getMatKhau());
//    }
    
//    public KhachHang getFormKH(){
//        KhachHang kh = new KhachHang();
//        kh.setHoTen(txtFullName.getText());
//        kh.setHinh("");
//        kh.setTrangThai("Hoạt động");
//        return kh;
//    }
    
//    public void setFormKH(KhachHang kh){
//        this.txtFullName.setText(kh.getHoTen());
//    }
//    
//    public ThongTinKhachHang getFormTT(int idKH){
//        ThongTinKhachHang tt = new ThongTinKhachHang();
//        tt.setIdKH(idKH);
//        tt.setEmail(txtEmail.getText());
//        tt.setSdt(txtPhoneNumber.getText());
//        return tt;
//    }
    
//    public void setFormTT(ThongTinKhachHang tt){
//        this.txtEmail.setText(tt.getEmail());
//        this.txtPhoneNumber.setText(tt.getSdt());
//    }
    
    
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JPasswordField txtRe_Pass;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
