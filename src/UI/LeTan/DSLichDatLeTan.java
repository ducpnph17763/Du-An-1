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
import UI.ChucNang.DoiLich;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//        layLichDat();
    }

    void layThongTinLichDat() {

        String sql = "select HoaDon.Id,HoaDon.NgayHen,HoaDon.Id_KH,HoaDon.Id_TC,HoaDon.DatCoc,\n"
                + "           HoaDon.ThanhToan,HoaDon.TrangThaiTT,HoaDon.TrangThai\n"
                + "           from HoaDon \n"
                + "           join NhanVien on HoaDon.Id_TC=NhanVien.Id		\n"
                + "           where  NhanVien.Id=HoaDon.Id_TC \n"
                + "           and (HoaDon.TrangThai LIKE N'Chưa thanh toán' or HoaDon.TrangThai LIKE N'Đã huỷ lịch')";
        ResultSet rs = JDBCHelper.query(sql);
        Object[] row = new Object[]{
            "Mã lịch đặt", "Mã khách hàng ", "Ngày hẹn", "Id Thợ cắt", "Đặt cọc", "Tổng tiền", "Trạng thái TT", "Trạng thái hoá đơn"
        };
        DefaultTableModel mol = new DefaultTableModel(row, 0);
        tblLichDat.setModel(mol);
        try {
            while (rs.next()) {
                Object[] item = new Object[8];
                item[0] = rs.getInt("Id");
                item[1] = rs.getString("Id_KH");
                item[2] = rs.getString("NgayHen");
                item[3] = rs.getString("Id_TC");
                item[4] = themPhay(rs.getInt("DatCoc"));
                item[5] = themPhay(rs.getInt("ThanhToan"));
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
                item[5] = themPhay(rs.getInt("GiaTien"));
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
                item[5] = themPhay(rs.getInt("GiaTien"));
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
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
        btnDoiLich = new javax.swing.JButton();

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
        btnThanhToan.setText("Check in");
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

        btnDoiLich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btnDoiLich.setText("Đổi lịch");
        btnDoiLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiLichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHuyLich, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(btnDoiLich, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnHuyDV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuyDV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDoiLich, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuyLich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnHuyLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLichActionPerformed
        // TODO add your handling code here:              
        try {
            index = tblLichDat.getSelectedRow();
            String mahd = tblLichDat.getValueAt(this.index, 0).toString();
            String trangThai = tblLichDat.getValueAt(this.index, 7).toString();
            String trangThaiTT = tblLichDat.getValueAt(this.index, 6).toString();
            String datCoc = tblLichDat.getValueAt(this.index, 4).toString();
            String[] parts = datCoc.split(",");
            String chuoi1 = parts[0];
            String chuoi2=parts[1];
            String haichuoi =chuoi1+chuoi2;
            System.out.println("đặt cọc:"+haichuoi);
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
                        if (trangThaiTT.equals("Chưa đặt cọc")) {
                            String sql = "update HoaDon set DatCoc=0,ThanhToan=0,TrangThai=N'Đã huỷ lịch' where Id=" + mahd;
                            JDBCHelper.update(sql);
                            layThongTinLichDat();
                            DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                            mol.setRowCount(0);
                            MsgBox.alert(this, "Hủy lịch thành công!");
                        }
                        else if (trangThaiTT.equals("Đã đặt cọc(đã xác nhận)")) {
                            String sql = "update HoaDon set ThanhToan=" + haichuoi + ",TrangThai=N'Đã huỷ lịch' where Id=" + mahd;
                            JDBCHelper.update(sql);
                            layThongTinLichDat();
                            DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                            mol.setRowCount(0);
                            MsgBox.alert(this, "Hủy lịch thành công!");
                        } else if (trangThaiTT.equals("Đã đặt cọc(chờ xác nhận)")) {
                            TinhTien a = new TinhTien(mahd);
                            jDesktopPane1.add(a);
                            a.setLocation(((jDesktopPane1.getWidth() - a.getWidth()) / 2), ((jDesktopPane1.getHeight() - a.getHeight()) / 2));
                            a.show();
                        }

                    }

                }

            }
        } catch (Exception e) {
         e.printStackTrace();
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
                            String sql = "update HoaDon set Id_NV=" + item[0] + ", TrangThai=N'Chờ thanh toán' where HoaDon.Id=" + mahd;
                            JDBCHelper.update(sql);
                        }
                    } catch (Exception e) {
                    }
                    layThongTinLichDat();

                    DefaultTableModel mol = (DefaultTableModel) tblCTLichDat.getModel();
                    mol.setRowCount(0);
                    MsgBox.alert(this, "Check in thành công!");
                }
            } else if (TrangThai.equals("Đã thanh toán")) {
                MsgBox.alert(this, "Lịch đặt này đã thanh toán rồi!");
                return;
            } else if (TrangThai.equals("Đã huỷ lịch")) {
                MsgBox.alert(this, "Lịch đã bị huỷ trước đó");
                return;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn chưa chọn lịch đặt để check in!");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblLichDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichDatMousePressed
        // TODO add your handling code here: 
        if (evt.getClickCount() == 2) {
            int index = tblLichDat.getSelectedRow();
            try {
                String id_Hd = tblLichDat.getValueAt(index, 0).toString();
                String id_KH = tblLichDat.getValueAt(index, 1).toString();
                HienThiThongTin a = new HienThiThongTin(id_Hd, id_KH);
                jDesktopPane1.add(a);
                a.setLocation(((jDesktopPane1.getWidth() - a.getWidth()) / 2), ((jDesktopPane1.getHeight() - a.getHeight()) / 2));
                a.show();
            } catch (Exception e) {
            }

        }
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
        int index = -1;
        index = tblLichDat.getSelectedRow();
        if (index >= 0) {
            String ma = tblLichDat.getValueAt(index, 0) + "";
            HoaDon hd = hddao.selectById(ma);
            if (hd.getTrangThaiTT().equals("Đã đặt cọc(đã xác nhận)")) {
                MsgBox.alert(this, "Lịch đặt đã xác nhận rồi!");
                return;
            } else {

                String sql = "update HoaDon set TrangThaiTT=N'Đã đặt cọc(đã xác nhận)' where Id=" + ma;
                try {
                    JDBCHelper.update(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(DSLichDatLeTan.class.getName()).log(Level.SEVERE, null, ex);
                }
                MsgBox.alert(this, "Xác nhận thành công!");
                layThongTinLichDat();
            }
        } else {
            MsgBox.alert(this, "Bạn chưa chọn lịch đặt để xác nhận!");
            return;
        }

    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnDoiLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiLichActionPerformed
        // TODO add your handling code here:
        int index = tblLichDat.getSelectedRow();
        if (index >= 0) {
            String id = tblLichDat.getValueAt(index, 0).toString();
            DoiLich dllt = new DoiLich(id);
            jDesktopPane1.add(dllt);
            dllt.setLocation(((jDesktopPane1.getWidth() - dllt.getWidth()) / 2), ((jDesktopPane1.getHeight() - dllt.getHeight()) / 2));
            dllt.show();
        } else {
            MsgBox.alert(this, "Bạn chưa chọn lịch để đổi!");
        }

    }//GEN-LAST:event_btnDoiLichActionPerformed
    public String themPhay(int tien) {
        double money = Double.valueOf(tien);
        return String.format("%,.0f", money);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiLich;
    private javax.swing.JButton btnHuyDV;
    private javax.swing.JButton btnHuyLich;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTLichDat;
    private javax.swing.JTable tblLichDat;
    // End of variables declaration//GEN-END:variables
}
