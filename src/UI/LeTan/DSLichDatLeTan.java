/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.LeTan;

import Dao.DichVuDAO;
import Dao.HoaDonDAO;
import Helper.JDBCHelper;
import Helper.MsgBox;
import Helper.XAuth;
import Model.HoaDon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class DSLichDatLeTan extends javax.swing.JInternalFrame {

    /**
     * Creates new form DSLichDat
     */
    int index = 0;
    HoaDonDAO hddao = new HoaDonDAO();
    DichVuDAO dvdao = new DichVuDAO();
    int maTK = XAuth.user.getId();

    public DSLichDatLeTan() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        init();
    }

    void init() {
        layThongTinLichDat();
    }

    void layThongTinLichDat() {
        String sql = "select HoaDon.Id,HoaDon.NgayHen,KhachHang.HoTen,HoaDon.Id_TC,HoaDon.DatCoc,\n"
                + "     HoaDon.ThanhToan,HoaDon.TrangThaiTT,HoaDon.TrangThai\n"
                + "     from HoaDon join KhachHang on HoaDon.Id_KH=KhachHang.Id\n"
                + "     join NhanVien on HoaDon.Id_TC=NhanVien.Id		\n"
                + "     join TaiKhoan on TaiKhoan.Id=KhachHang.Id_TK\n"
                + "     where HoaDon.Id_KH=KhachHang.Id and NhanVien.Id=HoaDon.Id_TC \n" + " \n"
                + "     and (HoaDon.TrangThai LIKE N'Chưa thanh toán' or HoaDon.TrangThai LIKE N'Đã huỷ lịch')";
        ResultSet rs = JDBCHelper.query(sql);
        Object[] row = new Object[]{
            "Mã lịch đặt", "Ngày hẹn", "Khách hàng", "Id Thợ cắt", "Đặt cọc", "Tổng tiền", "Trạng thái TT", "Trạng thái hoá đơn"
        };
        DefaultTableModel mol = new DefaultTableModel(row, 0);
        tblLichDat.setModel(mol);
        try {
            while (rs.next()) {
                Object[] item = new Object[8];
                item[0] = rs.getInt("Id");
                item[1] = rs.getString("NgayHen");
                item[2] = rs.getString("HoTen");
                item[3] = rs.getString("Id_TC");
                item[4] = rs.getInt("DatCoc");
                item[5] = rs.getString("ThanhToan");
                item[6] = rs.getString("TrangThaiTT");
                item[7] = rs.getString("TrangThai");
                mol.addRow(item);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void LayTTBangCTLichDat() {
        String mahd = tblCTLichDat.getValueAt(this.index, 2).toString();
        String sql = "select HoaDonChiTiet.Id,HoaDonChiTiet.Id_HD,HoaDonChiTiet.Id_DV,DichVu.TenDV,DichVu.GiaTien from HoaDonChiTiet join DichVu\n"
                + "on HoaDonChiTiet.Id_DV=DichVu.Id where HoaDonChiTiet.Id_HD=" + mahd;
        ResultSet rs = JDBCHelper.query(sql);
        Object[] row = new Object[]{
            "STT", "mã hoá đơn chi tiết", "mã hoá đơn", "mã dịch vụ", "Tên dịch vụ", "Giá tiền"
        };
        DefaultTableModel mol = new DefaultTableModel(row, 0);
        tblCTLichDat.setModel(mol);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                item[0] = c;
                item[1] = rs.getString("Id");
                item[2] = rs.getString("Id_HD");
                item[3] = rs.getString("Id_DV");
                item[4] = rs.getString("TenDV");
                item[5] = rs.getString("GiaTien");
                mol.addRow(item);

            }
        } catch (Exception e) {
        }
    }

    void LayTTBangCTLichDat1() {
        int row1 = tblLichDat.getSelectedRow();
        String mahd = tblLichDat.getValueAt(row1, 0).toString();
        String sql = "select HoaDonChiTiet.Id,HoaDonChiTiet.Id_HD,HoaDonChiTiet.Id_DV,DichVu.TenDV,DichVu.GiaTien from HoaDonChiTiet join DichVu\n"
                + "on HoaDonChiTiet.Id_DV=DichVu.Id where HoaDonChiTiet.Id_HD=" + mahd;
        ResultSet rs = JDBCHelper.query(sql);
        Object[] row = new Object[]{
            "STT", "mã hoá đơn chi tiết", "Mã hoá đơn", "mã dịch vụ", "Tên dịch vụ", "Giá tiền"
        };
        DefaultTableModel mol = new DefaultTableModel(row, 0);
        tblCTLichDat.setModel(mol);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[6];
                item[0] = c;
                item[1] = rs.getString("Id");
                item[2] = rs.getString("Id_HD");
                item[3] = rs.getString("Id_DV");
                item[4] = rs.getString("TenDV");
                item[5] = rs.getInt("GiaTien");
                mol.addRow(item);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTLichDat = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLichDat = new javax.swing.JTable();
        btnHuyLich = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHuyDV = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 590));

        tblCTLichDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTHD", "Mã HD", "Mã DV", "Tên DV", "Giá Tiền"
            }
        ));
        tblCTLichDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTLichDatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTLichDat);

        tblLichDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Lịch Đặt", "Ngày hẹn", "Mã Thợ cắt", "Tổng tiền", "Đặt cọc", "Trạng thái thanh toán", "Trạng thái hóa đơn"
            }
        ));
        tblLichDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichDatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblLichDatMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblLichDat);

        btnHuyLich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        btnHuyLich.setText("Hủy lịch");
        btnHuyLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLichActionPerformed(evt);
            }
        });

        jLabel1.setText("Bảng lịch đặt");

        jLabel2.setText("Bảng chi tiết lịch đặt:");

        btnHuyDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert.png"))); // NOI18N
        btnHuyDV.setText("Hủy Dich Vụ");
        btnHuyDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDVActionPerformed(evt);
            }
        });

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/receipt.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHuyLich, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(btnHuyDV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyLich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuyDV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnHuyLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLichActionPerformed
        // TODO add your handling code here:              
        try {
            index = tblLichDat.getSelectedRow();
            String mahd = tblLichDat.getValueAt(this.index, 0).toString();
            String trangThai = tblLichDat.getValueAt(this.index, 7).toString();
            String trangThaiTT = tblLichDat.getValueAt(this.index, 6).toString();
            if (this.index >= 0) {
                boolean kt1 = MsgBox.confirm(this, "Bạn có chắc chắn huỷ lịch không?");
                if (kt1 == true) {
                    if (trangThai.equalsIgnoreCase("Đã huỷ lịch")) {
                        MsgBox.alert(this, "Lịch đặt này đã bị huỷ trước đó!");
                        return;
                    } else if (trangThai.equals("Đã thanh toán")) {
                        MsgBox.alert(this, "Lịch đặt này đã thanh toán!");
                        return;
                    } else if (trangThai.equals("Chưa thanh toán")) {
                        String cautruyvan1 = "delete from HoaDonChiTiet where Id_HD=" + mahd;
                        JDBCHelper.update(cautruyvan1);
                        String sql = "update HoaDon set ThanhToan=0,TrangThai=N'Đã huỷ lịch' where Id=" + mahd;
                        JDBCHelper.update(sql);
                        layThongTinLichDat();
                        DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                        mol.setRowCount(0);
                        MsgBox.alert(this, "Hủy lịch thành công!");

                    }

                }

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn chưa chọn lịch đặt để huỷ!");
        }


    }//GEN-LAST:event_btnHuyLichActionPerformed

    void TinhTienCoc() {
        int index = tblCTLichDat.getSelectedRow();
        String mahd = tblCTLichDat.getValueAt(index, 2).toString();
        String sql = "select (sum(HoaDonChiTiet.GiaTien)/100)*20 as TongTienDatCoc from HoaDon\n"
                + "   join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.Id_HD\n"
                + "   where HoaDon.Id=" + mahd;
        ResultSet rs = JDBCHelper.query(sql);
        try {
            if (rs.next()) {
                String tongTien;
                tongTien = rs.getString("TongTienDatCoc");
                if (tongTien == null) {
                    String update = "update HoaDon set DatCoc=0,TrangThai=N'Đã huỷ lịch' where Id=" + mahd;
                    JDBCHelper.update(update);
                    layThongTinLichDat();
                    DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                    mol.setRowCount(0);
                    MsgBox.alert(this, "Lịch này đã bị huỷ!");
                    LayTTBangCTLichDat();
                } else {
                    String update = "update HoaDon set DatCoc=" + tongTien + " where Id=" + mahd;
                    JDBCHelper.update(update);
                    layThongTinLichDat();
                }
            }
        } catch (Exception e) {
        }
    }

    private void btnHuyDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDVActionPerformed
        // TODO add your handling code here:         
        int index = -1;
        int row = tblLichDat.getSelectedRow();
        if (row == -1 && index == -1) {
            MsgBox.alert(this, "Bạn chưa chọn lịch đặt!");
            System.out.println("index:" + row);
        }
        String TrangThaiHD = tblLichDat.getValueAt(row, 7).toString();
        if (row >= 0) {
            if (TrangThaiHD.equals("Đã huỷ lịch")) {
                MsgBox.alert(this, "Lịch đã bị huỷ trước đó");
                return;
            }
        }
        try {
            index = tblCTLichDat.getSelectedRow();
            String mahdct = tblCTLichDat.getValueAt(index, 1).toString();
            String mahd = tblCTLichDat.getValueAt(index, 2).toString();
            String TrangThaiTT = tblLichDat.getValueAt(row, 6).toString();
            if (index >= 0) {
                if (TrangThaiTT.equals("Đã đặt cọc(chờ xác nhận)")) {
                    try {
                        boolean kt = MsgBox.confirm(this, "Bạn có muốn huỷ dịch vụ không?\nHuỷ dịch vụ bạn sẽ mất cọc!");
                        if (kt == true) {
                            String sql = "delete from HoaDonChiTiet where Id=" + mahdct;
                            JDBCHelper.update(sql);
                            TinhTongTien();
                            DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                            mol.setRowCount(0);
                            MsgBox.alert(this, "Huỷ dịch vụ thành công!");

                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                } else {
                    try {
                        boolean kt = MsgBox.confirm(this, "Bạn có muốn huỷ dịch vụ không?\nHuỷ dịch vụ bạn sẽ mất cọc!");
                        if (kt == true) {
                            String sql = "delete from HoaDonChiTiet where Id=" + mahdct;
                            JDBCHelper.update(sql);
                            TinhTongTien();
                            TinhTienCoc();
                            DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                            mol.setRowCount(0);
                            MsgBox.alert(this, "Huỷ dịch vụ thành công!");
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("row:" + row);
            System.out.println("index:" + index);
            MsgBox.alert(this, "bạn chưa chọn chi tiết lịch đặt!");
        }

    }//GEN-LAST:event_btnHuyDVActionPerformed

    void TinhTongTien() {
        int index = tblCTLichDat.getSelectedRow();
        String mahd = tblCTLichDat.getValueAt(index, 2).toString();
        System.out.println("mã hoá đơn:" + mahd);
        String sql = "select sum(HoaDonChiTiet.GiaTien) as TongTienHienTai from HoaDon\n"
                + "join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.Id_HD\n"
                + "where HoaDon.Id=" + mahd;
        ResultSet rs = JDBCHelper.query(sql);
        System.out.println("ResultSet:" + rs);
        try {
            if (rs.next()) {
                String tongTien;
                tongTien = rs.getString("TongTienHienTai");
                if (tongTien == null) {
                    String update = "update HoaDon set ThanhToan=0,TrangThai=N'Đã huỷ lịch' where Id=" + mahd;
                    JDBCHelper.update(update);
                    layThongTinLichDat();
                    DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                    mol.setRowCount(0);
                    MsgBox.alert(this, "Lịch này đã bị huỷ!");
                }
                String update = "update HoaDon set ThanhToan=" + tongTien + " where Id=" + mahd;
                JDBCHelper.update(update);
                layThongTinLichDat();
            }
        } catch (SQLException e) {

        }

    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here: 

        System.out.println("mã nhân viên:" + maTK);
        int row = -1;
        try {
            row = tblLichDat.getSelectedRow();
            String mahd = tblLichDat.getValueAt(row, 0).toString();
            String TrangThaiTT = tblLichDat.getValueAt(row, 6).toString();
            String TrangThai = tblLichDat.getValueAt(row, 7).toString();
            System.out.println("trạng thái thanh toán:" + TrangThaiTT);
            System.out.println("trạng thái:" + TrangThai);

            if (TrangThai.equals("Chưa thanh toán")) {
                System.out.println("row:" + row);
                if (row >= 0) {
                    String sql1 = "select nhanVien.Id from NhanVien join TaiKhoan on NhanVien.Id_TK=TaiKhoan.Id where TaiKhoan.Id=" + maTK;
                    ResultSet rs = JDBCHelper.query(sql1);
                    try {
                        while (rs.next()) {
                            Object[] item = new Object[1];
                            item[0] = rs.getString("id");
                            String sql = "update HoaDon set Id_NV=" + item[0] + ",TrangThaiTT=N'Đã đặt cọc', TrangThai=N'Đã thanh toán' where HoaDon.Id=" + mahd;
                            JDBCHelper.update(sql);
                        }
                    } catch (Exception e) {
                    }
                    layThongTinLichDat();
                    DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                    mol.setRowCount(0);
                    MsgBox.alert(this, "Thanh toán thành công!");
                }
            } else if (TrangThai.equals("Đã thanh toán")) {
                MsgBox.alert(this, "Lịch đặt này đã thanh toán rồi!");
                return;
            } else if (TrangThai.equals("Đã huỷ lịch")) {
                MsgBox.alert(this, "Lịch đã bị huỷ trước đó");
                return;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn chưa chọn hoá đơn thanh toán!");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblLichDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichDatMousePressed
        // TODO add your handling code here:   
    }//GEN-LAST:event_tblLichDatMousePressed

    private void tblLichDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichDatMouseClicked
        // TODO add your handling code here:  
        LayTTBangCTLichDat1();
    }//GEN-LAST:event_tblLichDatMouseClicked

    private void tblCTLichDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTLichDatMouseClicked
        // TODO add your handling code here: 

    }//GEN-LAST:event_tblCTLichDatMouseClicked

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        DefaultTableModel mol = (DefaultTableModel) tblLichDat.getModel();
        index = tblLichDat.getSelectedRow();
        String ma = tblLichDat.getValueAt(index, 0) + "";
        HoaDon hd = hddao.selectById(ma);
        hd.setTrangThaiTT("Đã đặt cọc (Đã xác nhận)");
        hddao.update(hd);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyDV;
    private javax.swing.JButton btnHuyLich;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTLichDat;
    private javax.swing.JTable tblLichDat;
    // End of variables declaration//GEN-END:variables
}
