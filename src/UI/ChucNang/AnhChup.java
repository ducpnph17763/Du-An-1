/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.ChucNang;

import Dao.AnhDAO;
import Helper.JDBCHelper;
import Helper.MsgBox;
import Helper.XImage;
import Model.Anh;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nhatd
 */
public class AnhChup extends javax.swing.JInternalFrame {

    /**
     * Creates new form AnhChup
     */ 
    AnhDAO adao =new AnhDAO();
    public AnhChup(String contructor) {
        initComponents();
        txtId_HD.setText(contructor);    
    }

    
    
    
    
    JFileChooser fileChoose=new JFileChooser();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnh = new javax.swing.JTable();
        txtId_HD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã hoá đơn: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 66, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 180, 80, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/muiTen.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, -1, -1));

        tblAnh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã ảnh", "Mã hoá đơn", "Tên ảnh"
            }
        ));
        tblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAnh);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 305, 540, 233));
        jPanel2.add(txtId_HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 63, 146, -1));

        jLabel2.setText("Mã ảnh:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 94, -1, -1));
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 94, 146, -1));

        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 221, -1, -1));

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 71, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 200, 190));

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
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

    public void setHinh(String fileName) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("logos\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image scaledImage = bufferedImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        lblAnh.setIcon(image);
    }
    

    
    
    Anh getForm(){
        Anh a=new Anh();
        a.setId(txtId.getText());
        a.setId_HD(Integer.valueOf(txtId_HD.getText()));
        if(a.getAnh()==null){
            a.setAnh("email.png");
        }else if(a.getAnh()!=null){
            a.setAnh(lblAnh.getToolTipText());
        }
        return a;
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {            
            Anh a =getForm();
            if(a.getAnh()==null){
             MsgBox.alert(this, "Chưa chọn ảnh chụp!");
            }else{
                adao.insert(a);
                HienThiThongTin();
                 MsgBox.alert(this, "Thêm ảnh thành công!");
            }          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }//GEN-LAST:event_btnThemActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    
    void setForm(Model.Anh dv) {
       
        txtId.setText(dv.getId()+"");
        txtId_HD.setText(dv.getId_HD()+"");
        if (dv.getAnh()!= null) {
            lblAnh.setToolTipText(dv.getAnh());
            lblAnh.setIcon(XImage.read(dv.getAnh()));
        }

    }
    
    void edit(){
        int index=tblAnh.getSelectedRow();
        String Id =tblAnh.getValueAt(index, 0).toString();
        System.out.println("mã ảnh chụp:"+Id);
        Anh dv=adao.selectById(Id);
        setForm(dv);   
       
    }
    private void tblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnhMouseClicked
        // TODO add your handling code here:
       
//        int  index =tblAnh.getSelectedRow();
//        txtId.setText(tblAnh.getValueAt(index, 0).toString());
        if(evt.getClickCount()==1){
             edit();
        }
       
       
    }//GEN-LAST:event_tblAnhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        Anh a=getForm();
        if(a.getAnh()==null){
            MsgBox.alert(this, "Chưa chọn ảnh chụp!");
        }else{
             adao.update(a);
             HienThiThongTin();
             MsgBox.alert(this, "Cập nhật thành công!");
      
        }
       
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        adao.delete(txtId.getText());
        HienThiThongTin();
        MsgBox.alert(this, "Xoá thành công!");
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        try {
            chonAnh();
        } catch (Exception e) {
        }
     
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
       txtId.setText("");
       setHinh("Trắng.png");
        
          
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        HienThiThongTin();
    }//GEN-LAST:event_formInternalFrameActivated

    public void HienThiThongTin() {
        // TODO add your handling code here:
        DefaultTableModel mol =(DefaultTableModel) tblAnh.getModel();
        mol.setRowCount(0);
        String sql ="select*from AnhChup where Id_HD="+txtId_HD.getText();
        try {
            ResultSet rs=JDBCHelper.query(sql);
            while (rs.next()) {
                Object[]item=new Object[3];
                item[0]=rs.getInt("Id");
                item[1]=rs.getInt("Id_HD");
                item[2]=rs.getString("Anh");
                mol.addRow(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblAnh;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId_HD;
    // End of variables declaration//GEN-END:variables
}
