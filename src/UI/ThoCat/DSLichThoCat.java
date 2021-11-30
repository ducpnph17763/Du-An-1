/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ThoCat;

import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class DSLichThoCat extends javax.swing.JInternalFrame {

    /**
     * Creates new form DSLichDat
     */

    public DSLichThoCat() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        init();
    }
    
    void init(){
        LayDuLieuHoaDon();
    }
    void LayDuLieuHoaDon(){
        String sql = "select HoaDon.Id,NgayHen,GioHen,KhachHang.HoTen \n"
                + "from HoaDon\n"
                + "join KhachHang on KhachHang.Id=HoaDon.Id_KH\n"
                + "Join NhanVien on NhanVien.Id=HoaDon.Id_TC\n"
                + "where NhanVien.Id=HoaDon.Id_TC and HoaDon.TrangThai=N'Đang xử lý' and HoaDon.TrangThaiTT=N'Đã đặt cọc(đã xác nhận)' and ";
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel model=(DefaultTableModel)tblLichDat.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[] item=new Object[4];
                item[0]=rs.getString("Id");
                item[1]=rs.getString("NgayHen");
                item[2]=rs.getString("GioHen");
                item[3]=rs.getString("HoTen");
                model.addRow(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    void LayDuLieuHoaDonChiTiet(){
        int row=tblLichDat.getSelectedRow();
        String mahd=tblLichDat.getValueAt(row, 0).toString();
        String sql = "select DichVu.Id,TenDV,DichVu.GiaTien from DichVu join HoaDonChiTiet on DichVu.Id=HoaDonChiTiet.Id_DV\n"
                + "  where HoaDonChiTiet.Id_HD=" + mahd;
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel mol=(DefaultTableModel)tblCTLichDat.getModel();
        mol.setRowCount(0);
        int c=0;
        try {
            while (rs.next()) {
                Object[] item = new Object[4];
                c++;
                item[0] = c;
                item[1] = rs.getString("Id");
                item[2] = rs.getString("TenDV");
                item[3] = rs.getInt("GiaTien");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 590));

        tblCTLichDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Giá tiền"
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã lịch Đặt", "Ngày hẹn", "Giờ hẹn", "Khách Hàng"
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

        jLabel1.setText("Bảng lịch đặt");

        jLabel2.setText("Bảng chi tiết lịch đặt:");

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLichDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichDatMousePressed
        // TODO add your handling code here:   
    }//GEN-LAST:event_tblLichDatMousePressed

    private void tblLichDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichDatMouseClicked
        // TODO add your handling code here:  
        LayDuLieuHoaDonChiTiet();
    }//GEN-LAST:event_tblLichDatMouseClicked

    private void tblCTLichDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTLichDatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCTLichDatMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTLichDat;
    private javax.swing.JTable tblLichDat;
    // End of variables declaration//GEN-END:variables
}
