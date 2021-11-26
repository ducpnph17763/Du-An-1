/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.HoaDonDAO;
import Helper.JDBCHelper;
import Helper.MsgBox;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class HoaDon extends javax.swing.JInternalFrame {

    /**
     * Creates new form HoaDon
     */
     HoaDonDAO hddao=new HoaDonDAO();
     List<Model.DichVu>list=new ArrayList<>();
    public HoaDon() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        init();
    }

     void init(){
        LayDuLieuHoaDon();
    }
    
     void timKiemHoaDon(String id){
        System.out.println("id"+id);
         String sql = "select HoaDon.Id,KhachHang.id,HoaDon.Id_TC,NhanVien.HoTen,NgayHen,ThanhToan,DanhGia \n"
                + "from HoaDon\n"
                + "join KhachHang on KhachHang.Id=HoaDon.Id_KH\n"
                + "Join NhanVien on NhanVien.Id=HoaDon.Id_TC\n"
                + "where NhanVien.Id=HoaDon.Id_TC and HoaDon.TrangThai=N'Đã xử lý' and HoaDon.TrangThaiTT=N'Đã thanh toán' and HoaDon.id="+id;
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel model=(DefaultTableModel)tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[] item=new Object[7];
                item[0]=rs.getString("Id");
                item[1]=rs.getString("Id");
                item[2]=rs.getString("Id_TC");
                item[3]=rs.getString("HoTen");
                item[4]=rs.getString("NgayHen");
                item[5]=rs.getString("ThanhToan");
                item[6]=rs.getString("DanhGia");
                model.addRow(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    void LayDuLieuHoaDon(){
        String sql = "select HoaDon.Id,KhachHang.id,HoaDon.Id_TC,NhanVien.HoTen,NgayHen,ThanhToan,DanhGia \n"
                + "from HoaDon\n"
                + "join KhachHang on KhachHang.Id=HoaDon.Id_KH\n"
                + "Join NhanVien on NhanVien.Id=HoaDon.Id_TC\n"
                + "where NhanVien.Id=HoaDon.Id_TC and HoaDon.TrangThai=N'Đã xử lý' and HoaDon.TrangThaiTT=N'Đã thanh toán' ";
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel model=(DefaultTableModel)tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[] item=new Object[7];
                item[0]=rs.getString("Id");
                item[1]=rs.getString("Id");
                item[2]=rs.getString("Id_TC");
                item[3]=rs.getString("HoTen");
                item[4]=rs.getString("NgayHen");
                item[5]=rs.getString("ThanhToan");
                item[6]=rs.getString("DanhGia");
                model.addRow(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    void LayDuLieuHoaDonChiTiet(){
        int row=tblHoaDon.getSelectedRow();
        String mahd=tblHoaDon.getValueAt(row, 0).toString();
        String sql = "select DichVu.Id,TenDV,DichVu.GiaTien from DichVu join HoaDonChiTiet on DichVu.Id=HoaDonChiTiet.Id_DV\n"
                + "  where HoaDonChiTiet.Id_HD=" + mahd;
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel mol=(DefaultTableModel)tblHDCT.getModel();
        mol.setRowCount(0);
        try {
            while (rs.next()) {
                Object[] item = new Object[3];
                item[0] = rs.getString("Id");
                item[1] = rs.getString("TenDV");
                item[2] = rs.getInt("GiaTien");
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
        tblHDCT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã KH", "Mã TC", "Tên TC", "Ngày đặt ", "Thanh Toán", "Đánh Giá"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

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

        btnReset.setText("Reset");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addComponent(jScrollPane1))
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained

    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.setSize(1340, 810);
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String tk=txtTimKiem.getText();
        String rxgS="\\d+";
        if(tk.equals("")){
            MsgBox.alert(this, "Vui lòng nhập mã hoá đơn tìm kiếm!");
            txtTimKiem.requestFocus();
            return;
        }if(tk.matches(rxgS)==false){
            MsgBox.alert(this, "Mã hoá đơn không đúng định dạng!");
            txtTimKiem.requestFocus();
            return;
        }else{
           timKiemHoaDon(tk);
           DefaultTableModel mol=(DefaultTableModel)tblHDCT.getModel();
           mol.setRowCount(0);
           MsgBox.alert(this, "Đã tìm thấy hoá đơn!");
        }
        
      
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        LayDuLieuHoaDonChiTiet();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtTimKiem.setText("");
        LayDuLieuHoaDon();
    }//GEN-LAST:event_btnResetActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTim;
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
}
