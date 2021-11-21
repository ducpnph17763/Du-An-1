/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.TaiKhoanDAO;
import Helper.XAuth;
import Model.TaiKhoan;
import UI.KhachHang1.KhachHangHome;
import UI.QuanLy.QuanLyHome;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class DoiMatKhau extends javax.swing.JInternalFrame {

    Model.TaiKhoan tk = XAuth.user;

    public DoiMatKhau() {
        initComponents();
        setVisible(true);
        txtTen.setText(XAuth.user.getTenTK());
        this.txtTen.setEditable(false);

    }

    void Clear() {
        txtTen.setText("");
        txtMkCu.setText("");
        txtMkMoi.setText("");
        txtXacNhanMK.setText("");
    }

    void DoiMatKhau() {
        String tenTK = XAuth.user.getTenTK();
        String mkCu = String.valueOf(txtMkCu.getPassword());
        if (mkCu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau cu");
            return;
        }
        if (!mkCu.equals(tk.getMatKhau())) {
            JOptionPane.showMessageDialog(this, "Sai mat khau cu");
            return;
        }
        String mkMoi = String.valueOf(txtMkMoi.getPassword());
        if (mkCu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau moi");
            return;
        }
        String mkMoi1 = String.valueOf(txtXacNhanMK.getPassword());
        if (mkMoi1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau xac nhan");
            return;
        }
        if (!mkMoi.equals(mkMoi1)) {
            JOptionPane.showMessageDialog(this, "Mat khau xac nhạn khong trung vơi mat khau moi");
            return;
        }
        if (mkCu.equals(tk.getMatKhau()) && mkMoi.equals(mkMoi1)) {
            TaiKhoan tk = this.getForm();
            TaiKhoanDAO tkdao = new TaiKhoanDAO();
            tkdao.update(tk);
            tk.setMatKhau(mkMoi);
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
            this.dispose();

        }
    }

    TaiKhoan getForm() {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenTK(XAuth.user.getTenTK());
        tk.setMatKhau(String.valueOf(txtMkMoi.getPassword()));
        tk.setId(XAuth.user.getId());
        tk.setTrangThai(XAuth.user.getTrangThai());
        tk.setVaiTro(XAuth.user.getVaiTro());

        return tk;

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
        txtMkCu = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtMkMoi = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtXacNhanMK = new javax.swing.JPasswordField();
        btnDoiMK = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ĐỔI MẬT KHẨU");

        jLabel2.setText("Mật khẩu cũ:");

        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setText("Xác nhận mật khẩu mới:");

        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        jLabel5.setText("Ten ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtMkCu, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtMkMoi)
                            .addComponent(txtXacNhanMK)
                            .addComponent(jLabel5)
                            .addComponent(txtTen)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtMkCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMkMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
        DoiMatKhau();
    }//GEN-LAST:event_btnDoiMKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMkCu;
    private javax.swing.JPasswordField txtMkMoi;
    private javax.swing.JTextField txtTen;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables

}
