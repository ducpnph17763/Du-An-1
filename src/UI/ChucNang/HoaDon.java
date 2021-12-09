/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.HoaDonDAO;
import Helper.JDBCHelper;
import Helper.MsgBox;
import Helper.XAuth;
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
    int maTK = XAuth.user.getId();
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
         String sql = "select HoaDon.Id,KhachHang.id,HoaDon.Id_TC,NhanVien.HoTen,NgayHen,ThanhToan,DanhGia,HoaDon.TrangThaiTT,HoaDon.TrangThai \n"
                + "from HoaDon\n"
                + "join KhachHang on KhachHang.Id=HoaDon.Id_KH\n"
                + "Join NhanVien on NhanVien.Id=HoaDon.Id_TC\n"
                + "where NhanVien.Id=HoaDon.Id_TC and (HoaDon.TrangThai=N'Đã thanh toán' or HoaDon.TrangThai=N'Chờ thanh toán') and HoaDon.id="+id;
        ResultSet rs=JDBCHelper.query(sql);
        DefaultTableModel model=(DefaultTableModel)tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[] item=new Object[9];
                item[0]=rs.getString("Id");
                item[1]=rs.getString("Id");
                item[2]=rs.getString("Id_TC");
                item[3]=rs.getString("HoTen");
                item[4]=rs.getString("NgayHen");
                item[5]=rs.getString("ThanhToan");
                item[6]=rs.getString("DanhGia");
                item[7]=rs.getString("TrangThaiTT");
                item[8]=rs.getString("TrangThai");
                model.addRow(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     
    void layHoaDonKHNull(){
        String sql = "select HoaDon.Id,HoaDon.Id_TC,null HoTen,NhanVien.HoTen,NgayHen,ThanhToan,DanhGia\n"
                + "from HoaDon join NhanVien on NhanVien.Id=HoaDon.Id_TC\n"
                + "where NhanVien.Id=HoaDon.Id_TC and HoaDon.TrangThai=N'Đã thanh toán' and HoaDon.TrangThaiTT=N'Đã đặt cọc(đã xác nhận)' ";
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
                item[6]=rs.getString("DanhGia").equals("0")?"Hài lòng":rs.getString("DanhGia").equals("1")?"Rất hài lòng":"không hài lòng";                
                model.addRow(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    } 
    
    void LayDuLieuHoaDon() {
        String sql = "select HoaDon.Id,HoaDon.Id_KH,HoaDon.Id_TC,NhanVien.HoTen,HoaDon.NgayHen,HoaDon.ThanhToan,HoaDon.DanhGia,HoaDon.TrangThaiTT,HoaDon.TrangThai\n"
                + "         from HoaDon join NhanVien on HoaDon.Id_TC=NhanVien.Id		\n"
                + "         where  NhanVien.Id=HoaDon.Id_TC \n"
                + "         and HoaDon.TrangThai LIKE N'Đã thanh toán'  or HoaDon.TrangThai like N'Chờ thanh toán'";
        ResultSet rs = JDBCHelper.query(sql);
        DefaultTableModel model=(DefaultTableModel)tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            while(rs.next()){
                Object[] item=new Object[9];
                item[0]=rs.getString("Id");
                item[1]=rs.getString("Id_KH");
                item[2]=rs.getString("Id_TC");
                item[3]=rs.getString("HoTen");
                item[4]=rs.getString("NgayHen");
                item[5]=rs.getString("ThanhToan");
                item[6]=rs.getString("DanhGia").equals("0")?"Hài lòng":rs.getString("DanhGia").equals("1")?"Rất hài lòng":"không hài lòng";                
                item[7]=rs.getString("TrangThaiTT");
                item[8]=rs.getString("TrangThai");
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
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
        btnThanhToan = new javax.swing.JButton();
        btnChonAnh = new javax.swing.JButton();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã KH", "Mã TC", "Tên TC", "Ngày đặt ", "Thanh Toán", "Đánh Giá", "Trạng thái TT", "Trạng thái"
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

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnChonAnh.setText("Ảnh chup");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
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
                        .addComponent(btnReset)
                        .addGap(27, 27, 27)
                        .addComponent(btnThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(btnChonAnh))
                    .addComponent(jScrollPane1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnReset)
                    .addComponent(btnThanhToan)
                    .addComponent(btnChonAnh))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 11, 1340, 785));

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

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        System.out.println("mã nhân viên:" + maTK);
        int row = -1;
        try {
            row = tblHoaDon.getSelectedRow();
            String mahd = tblHoaDon.getValueAt(row, 0).toString();
            String TrangThaiTT = tblHoaDon.getValueAt(row, 7).toString();
            String TrangThai = tblHoaDon.getValueAt(row, 8).toString();
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
                    LayDuLieuHoaDon();
                   
                    DefaultTableModel mol = (DefaultTableModel) tblHDCT.getModel();
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

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        int index=tblHoaDon.getSelectedRow();
        String mahd =tblHoaDon.getValueAt(index, 0).toString();
        AnhChup a=new AnhChup(mahd);
        jDesktopPane1.add(a);
        a.setLocation(((jDesktopPane1.getWidth()-a.getWidth())/2),((jDesktopPane1.getHeight()-a.getHeight())/2));
        a.show();
    }//GEN-LAST:event_btnChonAnhActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThanhToan;
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
}
