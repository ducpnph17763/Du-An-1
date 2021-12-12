/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.ChucNang;

import Dao.DichVuDAO;
import Helper.MsgBox;
import Helper.ValidateHelper;
import Helper.XImage;
import Model.DichVu;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QLDichVu extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLDichVu
     */
    int index = -1;
    DichVuDAO dvdao = new DichVuDAO();
    List<Model.DichVu> list = new ArrayList<>();
    JFileChooser fileChoose = new JFileChooser();
    
    public QLDichVu() {
        initComponents();
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        init();
    }
    
    void init() {
        fillTable();
        index = -1;
        updateStatus();
    }
    
    void fillTable() {
        DefaultTableModel mol = (DefaultTableModel) tblDichVu.getModel();
        mol.setRowCount(0);
        List<Model.DichVu> list = dvdao.selectAll();
        for (DichVu dichVu : list) {
            Object[] row = {
                dichVu.getId(), dichVu.getTenDV(),dichVu.getThoiGian(), themPhay(dichVu.getGiaTien()), dichVu.getHinh(), dichVu.getMoTa()
            };
            mol.addRow(row);
        }
    }
    
    void chonAnh() {
        if (fileChoose.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChoose.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblAnh.setIcon(icon);
            lblAnh.setToolTipText(file.getName());
            String filename = file.getAbsolutePath();
            this.setHinh(filename);
        }
    }
    
    public void setHinh(String fileName){
        try {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new File("logos\\" + fileName));
            } catch (IOException e) {

            }
            Image scaledImage = bufferedImage.getScaledInstance(270, 330, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(scaledImage);
            lblAnh.setIcon(image);
        } catch (Exception e) {
        }

    }
    
   Model.DichVu getForm() {
        DichVu dv = new DichVu();
        index = 0;
        String id =  tblDichVu.getValueAt(index, 0).toString();
        System.out.println("id để sửa:" + id);
//        dv.setId(Integer.valueOf(lblID.getText()));
        System.out.println("id" + dv.getId());
        dv.setTenDV(txtTenDV.getText());
        dv.setGiaTien(Integer.parseInt(txtGiaTien.getText()));
        dv.setThoiGian(Integer.valueOf(txtThoiGian.getText()));
        dv.setMoTa(txtGioiThieu.getText());
        dv.setHinh(lblAnh.getToolTipText());
        return dv;
    }
    
    Model.DichVu getForm1() {
        DichVu dv = new DichVu();
        index = 0;
        String id =  tblDichVu.getValueAt(index, 0).toString();
        System.out.println("id để sửa:" + id);
        dv.setId(Integer.valueOf(lblID.getText()));
        System.out.println("id" + dv.getId());
        dv.setTenDV(txtTenDV.getText());
        dv.setGiaTien(Integer.parseInt(txtGiaTien.getText()));
        dv.setThoiGian(Integer.valueOf(txtThoiGian.getText()));
        dv.setMoTa(txtGioiThieu.getText());
        dv.setHinh(lblAnh.getToolTipText());
        return dv;
    }
    
    void setForm(Model.DichVu dv) {
        lblID.setText(dv.getId() + "");
        txtTenDV.setText(dv.getTenDV());
        txtGiaTien.setText(dv.getGiaTien() + "");
        System.out.println(dv.getGiaTien());
        txtGioiThieu.setText(dv.getMoTa());
        txtThoiGian.setText(dv.getThoiGian()+"");
        if (dv.getHinh() != null) {
            lblAnh.setToolTipText(dv.getHinh());
            lblAnh.setIcon(XImage.read(dv.getHinh()));
        }
    }
    
    void edit() {
        String madv = String.valueOf(tblDichVu.getValueAt(index, 0));
        DichVu dv = dvdao.selectById(madv);
        setForm(dv);
        updateStatus();
    }
    
    void insert() {
        DichVu dv = getForm();
        dvdao.insert(dv);
        fillTable();
    }
    
    void update() {
        DichVu dv = getForm1();
        dvdao.update(dv);
        fillTable();
    }
    
    void updateStatus() {
        boolean edit = (this.index >= 0);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }
    
    void clearForm() {
        DichVu dv = new DichVu();
        setForm(dv);
        index = -1;
        setHinh("Trắng.png");
        updateStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        txtGiaTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGioiThieu = new javax.swing.JTextPane();
        lblAnh = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChonAnh = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2), "Bảng dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setLayout(new java.awt.CardLayout());

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Thời gian", "Giá tiền", "Hình ảnh", "Giới thiệu"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        jPanel3.add(jScrollPane1, "card2");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Tên dịch vụ");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 52, -1, -1));

        jLabel8.setText("Giá tiền");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel9.setText("Hình ảnh");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel10.setText("Giới thiệu");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 244, -1, -1));

        txtTenDV.setName("Tên dịch vụ"); // NOI18N
        jPanel4.add(txtTenDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 49, 460, -1));

        txtGiaTien.setName("Giá tiền"); // NOI18N
        jPanel4.add(txtGiaTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 464, -1));

        txtGioiThieu.setName("Giới thiệu"); // NOI18N
        jScrollPane2.setViewportView(txtGioiThieu);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 244, 464, 125));

        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 39, 270, 330));

        btnLamMoi.setBackground(new java.awt.Color(57, 70, 138));
        btnLamMoi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/resets.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setBorder(null);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel4.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 138, 54));

        btnThem.setBackground(new java.awt.Color(57, 70, 138));
        btnThem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel4.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 102, 138, 54));

        btnSua.setBackground(new java.awt.Color(57, 70, 138));
        btnSua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel4.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 200, 138, 54));

        btnXoa.setBackground(new java.awt.Color(57, 70, 138));
        btnXoa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 315, 138, 54));

        btnChonAnh.setText("Chọn file");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        jPanel4.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 90, -1));

        lblID.setText("jLabel1");
        jPanel4.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 50, -1, -1));

        jLabel1.setText("Thời gian");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        jPanel4.add(txtThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 460, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1328, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.index = tblDichVu.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
       if (ValidateHelper.checkNullText(txtTenDV) && ValidateHelper.checkNullText(txtGiaTien) && ValidateHelper.checkNullGioiThieu(txtGioiThieu)) {
            if (ValidateHelper.checkTenDV(txtTenDV) && ValidateHelper.checkGiaTien(txtGiaTien) && ValidateHelper.checkGioiThieu(txtGioiThieu)) {
                insert();
                 MsgBox.alert(this, "Thêm dịch vụ thành công!");
                clearForm();     
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        try {
            chonAnh();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (ValidateHelper.checkNullText(txtTenDV) && ValidateHelper.checkNullText(txtGiaTien) && ValidateHelper.checkNullGioiThieu(txtGioiThieu)) {
            if (ValidateHelper.checkTenDV(txtTenDV) && ValidateHelper.checkGiaTien(txtGiaTien) && ValidateHelper.checkGioiThieu(txtGioiThieu)) {
                try {
                    update();
                    fillTable();
                    MsgBox.alert(this, "update thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int index1 =  tblDichVu.getSelectedRow();
        String index2=tblDichVu.getValueAt(index1, 0).toString();
        if (ValidateHelper.checkNullText(txtTenDV) && ValidateHelper.checkNullText(txtGiaTien) && ValidateHelper.checkNullGioiThieu(txtGioiThieu)) {
            if (ValidateHelper.checkTenDV(txtTenDV) && ValidateHelper.checkGiaTien(txtGiaTien) && ValidateHelper.checkGioiThieu(txtGioiThieu)) {
                try {
                    dvdao.delete(lblID.getText());
                    fillTable();
                    MsgBox.alert(this, "Xoá thành công!");
                    clearForm();              
                } catch (Exception e) {
                    MsgBox.alert(this, "Dịch vụ đã tồn tai trong hoá đơn chi tiết!");
                }
               
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    public String themPhay(int tien) {
        double money = Double.valueOf(tien);
        return String.format("%,.0f", money);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextPane txtGioiThieu;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtThoiGian;
    // End of variables declaration//GEN-END:variables
}
