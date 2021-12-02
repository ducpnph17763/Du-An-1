/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.NguoiDung;

import Dao.DichVuDAO;
import Dao.HoaDonDAO;
import Dao.NhanVienDAO;
import Dao.TaiKhoanDAO;
import Helper.MsgBox;
import Helper.XAuth;
import Model.HoaDon;
import Model.NhanVien;
import Model.TaiKhoan;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class HoaDonNguoiDung extends javax.swing.JInternalFrame {

    HoaDonDAO hddao = new HoaDonDAO();
    TaiKhoanDAO tkdao = new TaiKhoanDAO();
    NhanVienDAO nvdao = new NhanVienDAO();
    DichVuDAO dvdao = new DichVuDAO();

    /**
     * Creates new form HoaDonNguoiDung
     */
    public HoaDonNguoiDung() {
        initComponents();
        this.init();
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
    }

    public void init() {
        this.FillTableHoaDon();
        this.SetTextTimKiem();
    }

    public void addPlacehodelStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(font.PLAIN);
        textField.setFont(font);

    }

    public void removePlacehodelStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(font.PLAIN);
        textField.setFont(font);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnDanhGia = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên TC", "Ngày đặt ", "Thanh Toán", "Đánh Giá", "Phản Hồi"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã DV", "Tên DV", "Giá Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblHDCT);

        jLabel1.setText("Bảng hóa đơn:");

        jLabel2.setText("Bảng chi tiết hóa đơn:");

        jLabel3.setText("Tìm kiếm:");

        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnDanhGia.setText("Đánh giá");
        btnDanhGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhGiaActionPerformed(evt);
            }
        });

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(1013, 1013, 1013)
                                .addComponent(btnDanhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDanhGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 1360, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            int index = tblHoaDon.getSelectedRow();
            int id = (int) tblHoaDon.getValueAt(index, 0);
            this.FillTableHDCT(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equals("Nhập mã hóa đơn")) {
            txtTimKiem.setText(null);
            txtTimKiem.requestFocus();
            removePlacehodelStyle(txtTimKiem);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        this.SetTextTimKiem();
    }//GEN-LAST:event_txtTimKiemFocusLost


    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if (txtTimKiem.getText().equals("Nhập mã hóa đơn")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào mã hóa đơn!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            this.TimKiemHoaDon();
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnDanhGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhGiaActionPerformed
        int index = -1;

        try {
            index = tblHoaDon.getSelectedRow();
            String mahd = tblHoaDon.getValueAt(index, 0).toString();
            if (index >= 0) {
                DanhGia dmk = new DanhGia(mahd);
                jDesktopPane1.add(dmk);
                dmk.setLocation((jDesktopPane1.getWidth() - dmk.getWidth()) / 2, (jDesktopPane1.getHeight() - dmk.getHeight()) / 2);
                dmk.show();

            }

        } catch (Exception e) {
            MsgBox.alert(this, "bạn chưa chọn hoá đơn để đánh giá!");

        }
        this.FillTableHoaDon();
    }//GEN-LAST:event_btnDanhGiaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.FillTableHoaDon();
        this.txtTimKiem.setText("");
        this.SetTextTimKiem();

    }
   // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhGia;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTim;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void FillTableHoaDon() {
        TaiKhoan tk = XAuth.user;
        try {
            List<Model.HoaDon> ls = hddao.SelectHoaDonNguoiDung(tk.getTenTK());
            DefaultTableModel mol = (DefaultTableModel) tblHoaDon.getModel();
            mol.setRowCount(0);
            for (HoaDon l : ls) {
                NhanVien nv = nvdao.selectById(l.getId_TC());
                mol.addRow(new Object[]{l.getId(), nv.getHoTen(), l.getNgayHen(), l.getThanhToan(),
                    l.getDanhGia().equals("0") ? "Hài lòng" : l.getDanhGia().equals("1") ? "Rất hài lòng" : "Không hài lòng", l.getPhanHoi()});
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy hoá đơn nào!");
        }

    }

    private void FillTableHDCT(int id) {
        List<Model.DichVu> ls = dvdao.SelectHoaDon(String.valueOf(id));
        DefaultTableModel mol = (DefaultTableModel) tblHDCT.getModel();
        mol.setRowCount(0);
        for (Model.DichVu l : ls) {
            mol.addRow(new Object[]{l.getId(), l.getTenDV(), l.getGiaTien()});
        }
    }

    private void SetTextTimKiem() {
        if (txtTimKiem.getText().length() == 0) {
            addPlacehodelStyle(txtTimKiem);
            txtTimKiem.setText("Nhập mã hóa đơn");
        }
    }

    public void TimKiemHoaDon() {
        String id = txtTimKiem.getText();
        TaiKhoan tk = XAuth.user;
        DefaultTableModel mol = (DefaultTableModel) tblHoaDon.getModel();
        Model.HoaDon l = hddao.TimKiemHoaDonNguoiDung(tk.getTenTK(), id);
        mol.setRowCount(0);
        if (l == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn", "", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            NhanVien nv = nvdao.selectById(l.getId_TC());
            mol.addRow(new Object[]{l.getId(), nv.getHoTen(), l.getNgayHen(), l.getThanhToan(), l.getDanhGia()});
        }

    }

}
