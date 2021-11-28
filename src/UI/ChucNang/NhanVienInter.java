/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.NhanVienDAO;
import Dao.TaiKhoanDAO;
import Helper.MsgBox;
import Helper.XAuth;
import Model.NhanVien;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import Model.TaiKhoan;

/**
 *
 * @XAuthor dell
 */
public class NhanVienInter extends javax.swing.JInternalFrame {

    private int index;
    private TaiKhoanDAO tkDAO;
    private NhanVienDAO nvDAO;
    private DefaultTableModel model;
    private List<NhanVien> list;
    private List<Model.TaiKhoan> listTK;

    /**
     * Creates new form NhanVienInternalFrame
     */
    public NhanVienInter() {
        initComponents();
        setSize(1340, 810);
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        this.model = (DefaultTableModel) this.tblNV.getModel();
        this.tkDAO = new TaiKhoanDAO();
        this.nvDAO = new NhanVienDAO();
        list = nvDAO.selectAll();

        fillCbbVaiTro();
        fillNhanVienHienTai();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        btnNewForm = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhongHoatDong = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        cbbVaiTro = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        btnNhanVienCu = new javax.swing.JButton();
        btnNhanVienHienTai = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(800, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Họ Tên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel4.setText("Số điện thoại:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel5.setText("Tài khoản:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 20));

        jLabel6.setText("Địa chỉ:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        txtUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 490, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 420, -1));

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 420, -1));

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "SDT", "Email", "Vai trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNV);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 1310, 350));

        btnNewForm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNewForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new.png"))); // NOI18N
        btnNewForm.setText("Làm mới");
        btnNewForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFormActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 110, 50));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 120, 50));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 210, 120, 50));

        jLabel7.setText("Giới tính:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 20));

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });
        jPanel1.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 420, -1));

        jLabel9.setText("Trạng thái:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, 20));

        rdoHoatDong.setBackground(new java.awt.Color(255, 255, 255));
        rdoHoatDong.setSelected(true);
        rdoHoatDong.setText("Hoạt động");
        jPanel1.add(rdoHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, -1, -1));

        rdoKhongHoatDong.setBackground(new java.awt.Color(255, 255, 255));
        rdoKhongHoatDong.setText("Không hoạt động");
        jPanel1.add(rdoKhongHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, -1, -1));

        jLabel10.setText("Vai trò:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

        cbbVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbbVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 420, 30));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 420, -1));

        jLabel11.setText("Mật khẩu:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("TÌM KIẾM");

        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Them.png"))); // NOI18N
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblTimKiem)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 1310, 40));

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel1.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 730, -1, 40));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel1.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 730, -1, 40));

        btnPrev.setText("Pre");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 730, -1, 40));

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 730, -1, 40));

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 210, 120, 50));

        txtPass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 490, 20));

        btnNhanVienCu.setText("Nhân viên cũ");
        btnNhanVienCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienCuActionPerformed(evt);
            }
        });
        jPanel1.add(btnNhanVienCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 740, -1, -1));

        btnNhanVienHienTai.setText("Nhân viên hiện tại");
        btnNhanVienHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienHienTaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnNhanVienHienTai, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnNewFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFormActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewFormActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (this.check() == true && this.checkT() == true) {
            this.insert();
            cbbVaiTro.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        // TODO add your handling code here:
        
        
        
        if (evt.getClickCount() == 2) {
            this.index = this.tblNV.getSelectedRow();
            this.edit();
            
        }
//        if (XAuth.isManager()) {
//            if (evt.getButton() == MouseEvent.BUTTON3) {
//                this.popupMenu.show(this, evt.getX(), evt.getY());
//            }
//        }
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
//        if (this.check() == true && this.checkT()==true) {
            this.update();
//        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNhanVienHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienHienTaiActionPerformed
        // TODO add your handling code here:
        fillNhanVienHienTai();
    }//GEN-LAST:event_btnNhanVienHienTaiActionPerformed

    private void btnNhanVienCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienCuActionPerformed
        // TODO add your handling code here:
        fillNhanVienCu();
    }//GEN-LAST:event_btnNhanVienCuActionPerformed

    private void fillCbbVaiTro() {
        cbbVaiTro.removeAllItems();
        cbbVaiTro.addItem("Quản lý");
        cbbVaiTro.addItem("Lễ tân");
        cbbVaiTro.addItem("Thợ cắt");
    }

    private void fillNhanVienHienTai() {
        list = nvDAO.selectAll();
        this.model.setRowCount(0); // xoá tất cả các hàng trên Table
        try {
            for (NhanVien nv : list) {
                // thêm một hàng vào table
                this.model.addRow(new Object[]{nv.getId(),
                    nv.getHoTen(), nv.getSdt(), nv.getEmail(), nv.getVaiTro()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void fillNhanVienCu() {
        this.model.setRowCount(0); // xoá tất cả các hàng trên Table
        try {
            this.list = nvDAO.selectKHD(); // đọc dữ liệu từ CSDL
            for (NhanVien nv : list) {
                // thêm một hàng vào table
                this.model.addRow(new Object[]{nv.getId(), nv.getHoTen(), nv.getSdt(), nv.getEmail()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void updateStatus() {
        boolean edit = (this.index >= 0);
        boolean first = (this.index == 0);
        boolean last = (this.index == tblNV.getRowCount() - 1);

        // Trạng thái form
        this.txtUser.setEditable(!edit);
        this.btnThem.setEnabled(!edit);
        this.btnDelete.setEnabled(edit);
        this.btnDelete.setEnabled(edit);

        // Trạng thái điều hướng
        this.btnFirst.setEnabled(edit && !first);
        this.btnPrev.setEnabled(edit && !first);
        this.btnNext.setEnabled(edit && !last);
        this.btnLast.setEnabled(edit && !last);

        // Trạng thái txt chỉnh sửa
        this.txtPass.setEditable(true);
        this.txtName.setEditable(true);
        this.txtEmail.setEditable(true);

    }

    private void edit() {
        int idNV = (int) this.tblNV.getValueAt(this.index, 0);
        NhanVien nv = this.nvDAO.selectById(idNV);
        int idtk = (int) this.tblNV.getValueAt(this.index, 0);
        TaiKhoan tk = (TaiKhoan) tkDAO.selectByIdNv(nv.getId()+"");
        this.setForm(nv);
        this.setFormTK(tk);
        this.updateStatus();
    }

    private NhanVien getForm() {
        try {
            NhanVien nv = new NhanVien();
            nv.setId_TK(getMaTK());
            nv.setHoTen(this.txtName.getText());
            nv.setSdt(this.txtPhone.getText());
            nv.setEmail(this.txtEmail.getText());
            nv.setGioiTinh(rdoNam.isSelected());
            nv.setDiaChi(this.txtDiaChi.getText());
            nv.setVaiTro((String) this.cbbVaiTro.getSelectedItem());
            
//            System.out.println(nv.getId());
//            System.out.println(nv.getId_TK());
//            System.out.println(nv.getHoTen());
//            System.out.println(nv.getGioiTinh());
//            System.out.println(nv.getDiaChi());
//            System.out.println(nv.getEmail());
//            System.out.println(nv.getSdt());
//            System.out.println(nv.getVaiTro());
//            System.out.println(nv.getTrangThai());
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setForm(NhanVien nv) {
        this.txtName.setText(nv.getHoTen());
        this.txtPhone.setText(nv.getSdt());
        this.txtEmail.setText(nv.getEmail());
        rdoNam.setSelected(nv.getGioiTinh());
        this.txtDiaChi.setText(nv.getDiaChi());
        this.cbbVaiTro.setSelectedItem(nv.getVaiTro());
    }
    
//    private void setFormTK(Model.TaiKhoan tk) {
//        this.txtPass.setText(tk.getMatKhau());
//        this.rdoHoatDong.setSelected(tk.getTrangThai());
//    }

    public Model.TaiKhoan getFormTK() {
        Model.TaiKhoan tk = new Model.TaiKhoan();

        tk.setTenTK(txtUser.getText());
        tk.setMatKhau(new String(txtPass.getPassword()));
//        tk.setVaiTro(cbbVaiTro.getItemCount());
        String vaitro = (String) cbbVaiTro.getSelectedItem();
        if (vaitro.equals("Quản lý")) {
            tk.setVaiTro(0);
        } else if (vaitro.equals("Lễ tân")) {
            tk.setVaiTro(1);
        } else {
            tk.setVaiTro(2);
        }

        tk.setTrangThai("Hoạt động");
        return tk;
    }

    int getMaTK() {
        String vaitro = (String) cbbVaiTro.getSelectedItem();
        if (cbbVaiTro.getSelectedIndex() == 0) {
            listTK = tkDAO.selectByVaiTro(0, txtUser.getText());
        } else if (cbbVaiTro.getSelectedIndex() == 1) {
            listTK = tkDAO.selectByVaiTro(1, txtUser.getText());
        } else if (cbbVaiTro.getSelectedIndex() == 2) {
            listTK = tkDAO.selectByVaiTro(2, txtUser.getText());
        }
        for (Model.TaiKhoan taiKhoan : listTK) {
            return taiKhoan.getId();
        }
        return 0;
    }

    public void setFormTK(Model.TaiKhoan tk) {
        this.txtUser.setText(tk.getTenTK());
        this.txtPass.setText(tk.getMatKhau());
    }

    private void clearForm() {
        NhanVien nv = new NhanVien();
        this.setForm(nv);
        this.txtPass.setText("");
        this.index = -1;
        this.updateStatus();

    }

    private void insert() {
        try {
            Model.TaiKhoan tk = this.getFormTK();

            try {
                this.tkDAO.insert(tk);
                NhanVien nv = this.getForm();
                this.nvDAO.insert(nv);

                this.fillNhanVienHienTai();

                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Thêm mới thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update() {
            try {
//                Model.TaiKhoan tk = this.getFormTK();
//                this.tkDAO. update(tk);
                
                NhanVien nv = this.getForm();
                this.nvDAO.update(nv);

                this.fillNhanVienHienTai();

                this.clearForm();
                MsgBox.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Cập nhật thất bại");
            }
    }

    private void delete() {
        if (XAuth.isManager()==false) {
            MsgBox.alert(this, "Bạn không có quyền xoá nhân viên !");
        } else {
            String tenTK = this.txtUser.getText();
            if (tenTK.equals(XAuth.user.getTenTK())) {
                MsgBox.alert(this, "Bạn không được xoá chính bạn !");
            } else if (MsgBox.confirm(this, "Bạn thực sự muốn xoá nhân viên này")) {
                try {
                    this.tkDAO.delete(tenTK);
                    this.nvDAO.delete(tenTK);
                    this.fillNhanVienHienTai();
                    this.clearForm();
                    MsgBox.alert(this, "Xoá thành công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xoá thất bại");
                }
            }
        }
    }

    private void first() {
        this.index = 0;
        this.edit();
    }

    private void prev() {
        if (this.index > 0) {
            this.index--;
            this.edit();
        }
    }

    private void next() {
        if (this.index < this.tblNV.getRowCount() - 1) {
            this.index++;
            this.edit();
        }
    }

    private void last() {
        this.index = tblNV.getRowCount() - 1;
        this.edit();
    }

    private void trangThai() throws SQLException {
        this.index = this.tblNV.getSelectedRow();
        if (this.index < 0) {
            MsgBox.alert(this, "Bạn chưa chọn dòng nào trên table");
        } else {
            if (this.tblNV.getValueAt(this.index, 5).equals("Đang hoạt động")) {
                NhanVien nv = new NhanVien();
                nv.setId((int) this.tblNV.getValueAt(this.index, 0));
                this.nvDAO.updateKHD(nv);
                this.fillNhanVienCu();
                MsgBox.alert(this, "Cập nhật trạng thái nhân viên thành công");
            } else if (this.tblNV.getValueAt(this.index, 5).equals("Không hoạt động")) {
                NhanVien nv = new NhanVien();
                nv.setId((int) this.tblNV.getValueAt(this.index, 0));
                this.nvDAO.updateHD(nv);
                this.fillNhanVienHienTai();
                MsgBox.alert(this, "Cập nhật trạng thái nhân viên thành công");
            }
        }

    }

    private boolean checkT() {
        if (this.tkDAO.select(this.txtUser.getText()) != null) {
            MsgBox.alert(this, "Tên tài khoản đã tồn tại");
            this.txtUser.requestFocus();
            return false;
        }
        return true;
    }

    private boolean check() {
        // Check tài khoản
        if (this.txtUser.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập tên tài khoản!");
            this.txtUser.requestFocus();
            return false;
        }

        // Check mật khẩu
        if (this.txtPass.getPassword().length == 0) {
            MsgBox.alert(this, "Vui lòng nhập mật khẩu!");
            this.txtPass.requestFocus();
            return false;
        } else if (this.txtPass.getPassword().length < 3) {
            MsgBox.alert(this, "Mật khẩu phải dài hơn 3 ký tự");
            this.txtPass.requestFocus();
            return false;
        }

        // Check họ tên
        if (this.txtName.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập họ và tên!");
            this.txtName.requestFocus();
            return false;
        }

        // Check email
        if (this.txtEmail.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập Email!");
            this.txtEmail.requestFocus();
            return false;
        } else if (!this.txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            MsgBox.alert(this, "Email không đúng định dạng");
            this.txtEmail.requestFocus();
            return false;
        } else if (this.nvDAO.selectByEmail(this.txtEmail.getText()) != null) {
            MsgBox.alert(this, "Email đã tồn tại");
            this.txtEmail.requestFocus();
            return false;
        }

        // Check sdt
        if (this.txtPhone.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập SĐT!");
            this.txtPhone.requestFocus();
            return false;
        } else if (!this.txtPhone.getText().matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
            MsgBox.alert(this, "SĐT không đúng định dạng");
            this.txtPhone.requestFocus();
            return false;
        }

        // Check địa chỉ
        if (this.txtDiaChi.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập địa chỉ!");
            this.txtDiaChi.requestFocus();
            return false;
        }

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewForm;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhanVienCu;
    private javax.swing.JButton btnNhanVienHienTai;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhongHoatDong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
