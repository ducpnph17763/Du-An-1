/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.KhachHangDAO;
import Dao.TaiKhoanDAO;
import Helper.MsgBox;
import Model.TaiKhoan;
import UI.NguoiDung.NguoiDungHome;
import Model.KhachHang;
import Model.ThongTinKhachHang;
import java.util.List;

/**
 *
 * @author Huong
 */
public class KichHoatTK extends javax.swing.JFrame {

    List<TaiKhoan> listTK;
    List<KhachHang> listKH;
    KhachHangDAO khDAO = new KhachHangDAO();
    int randomCode;
    String tentk, mk,hoten, email, sdt;
    TaiKhoan tk = new TaiKhoan();
    KhachHang kh = new KhachHang();
    ThongTinKhachHang tt = new ThongTinKhachHang();
    TaiKhoanDAO tkd = new TaiKhoanDAO();

    public KichHoatTK(int code, String tenTK, String MK, String hoten, String email, String sdt) {
        initComponents();
        this.tk = tk;
        this.randomCode = code;
        this.tt = tt;
        this.tentk = tenTK;
        this.mk = MK;
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;

    }

    public KichHoatTK() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaCode = new javax.swing.JTextField();
        btnKichHoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Kích hoạt tài khoản");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã xác nhận đã gửi đến email của bạn!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vui lòng kiểm tra và nhập mật mã xác nhận:");

        txtMaCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnKichHoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKichHoat.setText("KÍCH HOẠT");
        btnKichHoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichHoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaCode))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnKichHoat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnKichHoat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnKichHoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichHoatActionPerformed
        // TODO add your handling code here:
        try {
            int maCode = Integer.parseInt(txtMaCode.getText().trim());
            if (txtMaCode.getText().length() == 0) {
                MsgBox.alert(this, "Vui lòng nhập code");
                this.txtMaCode.requestFocus();
                return;
            } else if (this.txtMaCode.getText().length() > 6) {
                MsgBox.alert(this, "Mã code chỉ có 6 số");
                this.txtMaCode.requestFocus();
                return;
            }
            else {
                xacNhan();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Mã code phải là số");
            this.txtMaCode.requestFocus();
            return;
        }
    }//GEN-LAST:event_btnKichHoatActionPerformed

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
            java.util.logging.Logger.getLogger(KichHoatTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KichHoatTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KichHoatTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KichHoatTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KichHoatTK().setVisible(true);
            }
        });
    }

    public void xacNhan() {
        try {
            if (Integer.valueOf(txtMaCode.getText()) == randomCode) {
                TaiKhoan tk2 = getForm();
                tkd.insert(tk2);
                
                KhachHang kh2 = getFormKH();
                khDAO.insert(kh2);
                
                ThongTinKhachHang tt2 = getFormTT();
                tkd.insertTTKH(tt2);
                
                MsgBox.alert(this, "Đăng ký tài khoản thành công!");
                this.dispose();
                NguoiDungHome ngdung = new NguoiDungHome();
                ngdung.setVisible(true);
            } else {
                MsgBox.alert(this, "Mã code sai");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public TaiKhoan getForm() {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenTK(tentk);
        tk.setMatKhau(mk);
        tk.setVaiTro(3);
        tk.setTrangThai("Hoạt động");
        return tk;
    }

    public KhachHang getFormKH() {
        KhachHang kh = new KhachHang();
        kh.setId_tk(getMaTK());
        kh.setHoTen(hoten);
        kh.setTrangThai("Hoạt động");
        return kh;
    }

    public ThongTinKhachHang getFormTT() {
        ThongTinKhachHang tt = new ThongTinKhachHang();
        tt.setIdKH(getMaKH());
        tt.setEmail(email);
        tt.setSdt(sdt);
        return tt;
    }

    int getMaTK() {
        listTK = tkd.selectByVaiTro(3, tentk);

        for (Model.TaiKhoan taiKhoan : listTK) {
            return taiKhoan.getId();
        }
        return 0;
    }
    
    int getMaKH() {
        listKH = khDAO.selectAll();

        for (KhachHang kh: listKH) {
            if(kh.getId_tk()==getMaTK()){
                return kh.getId();
            }
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnKichHoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMaCode;
    // End of variables declaration//GEN-END:variables
}
