/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.NguoiDung;

import Dao.DichVuDAO;
import Dao.HoaDonDAO;
import Dao.KhachHangDAO;
import Dao.NhanVienDAO;
import Helper.MsgBox;
import Helper.XAuth;
import Model.DichVu;
import Model.HoaDon;
import Model.NhanVien;
import UI.LeTan.DatLichLeTan;
import UI.LeTan.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class DatLichNguoiDung extends javax.swing.JInternalFrame {

    int index = -1;
    DichVuDAO dvdao = new DichVuDAO();
    NhanVienDAO nvdao = new NhanVienDAO();
    HoaDonDAO hddao = new HoaDonDAO();
    List<Model.DichVu> ls = new ArrayList<>();
    KhachHangDAO khdao = new KhachHangDAO();

    public DatLichNguoiDung() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        this.init();
    }

    private void init() {
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        this.setNgay();
        this.fillComboboxDichVu();
        this.fillComboThoCat();
        DefaultComboBoxModel mol = (DefaultComboBoxModel) cboThoiGian.getModel();
        mol.removeAllElements();
        this.fillComboThoiGian();
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
        cboNgayDat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboDichVu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboThoCat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboThoiGian = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        btnHuyDichVu = new javax.swing.JButton();
        btnDatLich = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Ngày đặt:");

        cboNgayDat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Dịch vụ:");

        cboDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Thợ cắt:");

        cboThoCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Thời gian:");

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã DV", "Tên DV", "Giá Tiền", "Mã TC", "Tên TC"
            }
        ));
        jScrollPane1.setViewportView(tblDichVu);

        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert.png"))); // NOI18N
        btnThemDichVu.setText("Thêm DV");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnHuyDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        btnHuyDichVu.setText("Hủy DV");
        btnHuyDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDichVuActionPerformed(evt);
            }
        });

        btnDatLich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        btnDatLich.setText("Đặt lịch");
        btnDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboThoiGian, javax.swing.GroupLayout.Alignment.LEADING, 0, 596, Short.MAX_VALUE)
                                    .addComponent(cboDichVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboNgayDat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboThoCat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(496, 496, 496)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHuyDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatLich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboThoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichActionPerformed


    }//GEN-LAST:event_btnDatLichActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        if (this.ValidateFrom() == true) {
            this.TaoHoaDon();
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        this.kiemTra();
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnHuyDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDichVuActionPerformed
        this.HuyDichVu();
    }//GEN-LAST:event_btnHuyDichVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLich;
    private javax.swing.JButton btnHuyDichVu;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JComboBox<String> cboDichVu;
    private javax.swing.JComboBox<String> cboNgayDat;
    private javax.swing.JComboBox<String> cboThoCat;
    private javax.swing.JComboBox<String> cboThoiGian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDichVu;
    // End of variables declaration//GEN-END:variables
    private void setNgay() {
        this.cboNgayDat.removeAllItems();
        this.cboNgayDat.addItem("Chọn ngày");
        SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM-yyyy");
        Date now = new Date();
        String date = sdf.format(now);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                cal.add(Calendar.DAY_OF_WEEK, +0);
                this.cboNgayDat.addItem(sdf.format(cal.getTime()));
            }
            cal.add(Calendar.DAY_OF_WEEK, +1);
            this.cboNgayDat.addItem(sdf.format(cal.getTime()));
        }
    }

    private void fillComboboxDichVu() {
        DefaultComboBoxModel mol = (DefaultComboBoxModel) cboDichVu.getModel();
        mol.removeAllElements();
        List<Model.DichVu> list = dvdao.selectAll();
        for (Model.DichVu dv : list) {
            mol.addElement(dv);
        }
    }

    private void fillComboThoCat() {
        DefaultComboBoxModel mol = (DefaultComboBoxModel) cboThoCat.getModel();
        mol.removeAllElements();
        List<NhanVien> list = nvdao.selectByThoCat();
        for (NhanVien nv : list) {
            mol.addElement(nv);
        }
    }

    private void fillComboThoiGian() {
        cboThoiGian.removeAllItems();
        Time tm = new Time(8, 0);
        cboThoiGian.addItem(tm.toString());
        for (int i = 0; true; i++) {
            tm.tangPhut();
            cboThoiGian.addItem(tm.toString());
            if (tm.toString().equals("18:00")) {
                return;
            }
        }
    }

    private void fillTable() {
        DefaultTableModel mol = (DefaultTableModel) tblDichVu.getModel();
        mol.setRowCount(0);
        try {
            Model.DichVu dichVu = (Model.DichVu) cboDichVu.getSelectedItem();

            ls.add(dichVu);
            for (Model.DichVu dv : ls) {
                Object[] row = {
                    dv.getId(), dv.getTenDV(), dv.getGiaTien()
                };
                mol.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    private void edit() {
        String id = (String) tblDichVu.getValueAt(this.index, 0);
        Model.DichVu dv = dvdao.selectById(id);
        this.setForm(dv);
    }

    private void setForm(DichVu dv) {
        DefaultComboBoxModel mol = (DefaultComboBoxModel) cboDichVu.getModel();
        mol.setSelectedItem(dv.getTenDV());
    }

    private HoaDon GetForm() throws ParseException {
        Model.HoaDon hd = new Model.HoaDon();
        int tongtien = 0;
        for (Model.DichVu l : ls) {
            tongtien += l.getGiaTien();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayTao = new Date();
        String ngay = sdf.format(ngayTao);
        String ngayhen = (String) cboNgayDat.getSelectedItem();
        String[] parts = ngayhen.split(",");
        String part = parts[1];
        Date NgayHen = sdf.parse(part);
        String gioHen = (String) cboThoiGian.getSelectedItem();
        DefaultComboBoxModel mol = (DefaultComboBoxModel) cboThoCat.getModel();
        NhanVien nv = (NhanVien) mol.getSelectedItem();
        Model.KhachHang kh = khdao.SelectByTenTK(XAuth.user.getTenTK());
        Integer makh;
        if (kh == null) {
            makh = null;
        } else {
            makh = kh.getId();
        }
        hd.setId(0);
        hd.setId_KH(makh);
        hd.setId_NV(null);
        hd.setId_TC(nv.getId());
        hd.setNgayHen(sdf.parse(part));
        hd.setNgayTao(sdf.parse(ngay));
        hd.setDatCoc(tongtien * 20 / 100);
        hd.setThanhToan(tongtien);
        hd.setTrangThaiTT("Chưa thanh toán");
        hd.setTrangThai("Chưa đặt cọc");
        hd.setDanhGia(null);
        hd.setPhanHoi("Phản hồi");
        hd.setGioHen(gioHen);
        return hd;
    }

    private void kiemTra() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboDichVu.getModel();
        Model.DichVu cbodv = (Model.DichVu) model.getSelectedItem();
        if (ls.size() == 0) {
            ls.add(cbodv);
            fillTable1();
        } else {
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).equals(cbodv)) {
                    JOptionPane.showMessageDialog(this, "Dịch vụ này đã được thêm vào rồi!");
                    return;
                }
            }
            ls.add(cbodv);
            fillTable1();

        }
    }

    private void fillTable1() {
        DefaultTableModel mol = (DefaultTableModel) tblDichVu.getModel();
        mol.setRowCount(0);
        try {
            Model.DichVu dichVu = (Model.DichVu) cboDichVu.getSelectedItem();
            for (Model.DichVu dv : ls) {
                Object[] row = {
                    dv.getId(), dv.getTenDV(), dv.getGiaTien()
                };
                mol.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    private boolean ValidateFrom() {
        if (cboNgayDat.getSelectedItem().equals("Chọn ngày")) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn ngày đặt", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ls.size() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dịch vụ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void TaoHoaDon() {
        try {
            HoaDon hd = this.GetForm();
            HoaDon hddb = hddao.SelectHoaDonByGioHen(hd);
            if (hddb == null) {
                this.hddao.insert(hd);
                Model.HoaDon hdcuoi = hddao.selectHD_CuoiCung();
                for (Model.DichVu l : ls) {
                    this.hddao.InsertHDCT(hdcuoi, l);
                }
                JOptionPane.showMessageDialog(this, "Bạn đã tạo lịch đặt thành công\nChọn nút đặt lịch để đặt cọc");
                return;
            }
            if (hd.getNgayHen().equals(hddb.getNgayHen()) && hd.getId_TC().equals(hddb.getId_TC()) && hd.getGioHen().equals(hddb.getGioHen())) {
                JOptionPane.showMessageDialog(this, "Lịch này đã có người đặt rồi!");
                return;
            }
        } catch (ParseException ex) {
            Logger.getLogger(DatLichLeTan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void HuyDichVu() {
        int index = tblDichVu.getSelectedRow();
        if (index >= 0) {
            for (int i = 0; i < ls.size(); i++) {
                if (index == i) {
                    ls.remove(index);
                    fillTable1();
                    MsgBox.alert(this, "Huỷ dịch vụ thành công!");
                }
            }
        } else {
            MsgBox.alert(this, "Bạn chưa chọn dịch vụ để huỷ!");
        }
    }

}
