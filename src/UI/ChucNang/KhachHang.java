/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChucNang;

import Dao.KhachHangDAO;
import Dao.QLTaiKhoanDAO;
import Dao.TTKhachHangDAO;
import Dao.TaiKhoanDAO;
import Helper.JDBCHelper;
import Helper.MsgBox;
import Helper.XImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class KhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form KhachHang
     */
     int index = 0;
    JFileChooser fileChoose = new JFileChooser();
    List<Model.TaiKhoan> listTK = new ArrayList<>();
    KhachHangDAO khdao = new KhachHangDAO();
    TTKhachHangDAO ttdao = new TTKhachHangDAO();
    TaiKhoanDAO tkdao = new TaiKhoanDAO();
    QLTaiKhoanDAO qldao = new QLTaiKhoanDAO();
    public KhachHang() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        init();
    }
    
    
     void init() {
        layTTKK();
        
    }

    void layTTKK() {
        String sql = "select KhachHang.Id,Hoten,Email,SoDienThoai from KhachHang join ThongTinKhachHang\n"
                + "on ThongTinKhachHang.Id_KH=KhachHang.Id\n"
                + "join TaiKhoan on TaiKhoan.Id=KhachHang.Id_TK";
        ResultSet rs = JDBCHelper.query(sql);
        DefaultTableModel mol = (DefaultTableModel) tblKhachHang.getModel();
        mol.setRowCount(0);
        try {
            while (rs.next()) {
                Object[] item = new Object[5];
                item[0] = rs.getString("id");
                item[1] = rs.getString("HoTen");
                item[2] = rs.getString("SoDienThoai");
                item[3] = rs.getString("Email");
                mol.addRow(item);

            }
        } catch (Exception e) {
        }
    }
       
    void layTaiKhoan() {
        String sdt = txtSdt.getText();
        String sql = "select  TaiKhoan.id,TenTK,MatKhau from TaiKhoan join KhachHang on KhachHang.Id_TK=TaiKhoan.Id \n"
                + "join ThongTinKhachHang on KhachHang.Id=ThongTinKhachHang.Id_KH where ThongTinKhachHang.SoDienThoai=N'" + sdt + "'";
        ResultSet rs = JDBCHelper.query(sql);
        try {
            while (rs.next()) {
               Object[] item = new Object[3];
                item[0] = rs.getString("Id");
                item[1] = rs.getString("TenTK");
                item[2] = rs.getString("MatKhau");
                String kh=String.valueOf(khdao.selectById(item[0]+"").getId());
                lblID.setText(kh+"");             
                txtTaiKhoan.setText(item[1] + "");
                txtMatKhau.setText(item[2] + "");
            }
        } catch (Exception e) {
        }
    }

    void fillTableKhachHang() {
        DefaultTableModel mol = (DefaultTableModel) tblKhachHang.getModel();
        mol.setRowCount(0);
        List<Model.KhachHang> list = khdao.selectAll();
        for (Model.KhachHang tk : list) {
            Object[] row = new Object[]{
                tk.getId(), tk.getHoTen()
            };
            mol.addRow(row);
        }

    }
    
    void clearForm(){
        txtEmail.setText("");
        txtHoTen.setText("");
        txtMatKhau.setText("");
        txtSdt.setText("");
        txtTaiKhoan.setText("");
        lblAnh.setText("");       
    }
    
    
     
     void chonAnh() throws IOException {
        if (fileChoose.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChoose.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblAnh.setIcon(icon);
            lblAnh.setToolTipText(file.getName());
            lblAnh.setText("");
            Image img = ImageIO.read(file);
            int width = lblAnh.getWidth();
            int height = lblAnh.getHeight();
            lblAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));

        }
    }
     
    Model.TaiKhoan getFormTK() {
        Model.TaiKhoan tk = new Model.TaiKhoan();
        tk.setTenTK(txtTaiKhoan.getText());
        tk.setMatKhau(txtMatKhau.getText());
        tk.setVaiTro(3);
        tk.setTrangThai("Hoạt động");
        return tk;
    }

    Model.KhachHang getFormKH() {
        Model.KhachHang kh = new Model.KhachHang();
        for (int i = listTK.size() - 1; i >= 0; i--) {
            Object[] row = new Object[]{
                listTK.get(i).getId(), listTK.get(i).getTenTK(), listTK.get(i).getMatKhau()
            };
            kh.setId_tk(listTK.get(listTK.size() - 1).getId());
        }
        kh.setHoTen(txtHoTen.getText());

        return kh;
    }

    Model.TTKhachHang getformTTKH() {
        Model.TTKhachHang ttkh = new Model.TTKhachHang();
        for (int i = listTK.size() - 1; i >= 0; i--) {
            Object[] row = new Object[]{
                listTK.get(i).getId(), listTK.get(i).getTenTK(), listTK.get(i).getMatKhau()
            };

        }
        String makh = String.valueOf(listTK.get(listTK.size() - 1).getId());
        System.out.println("mã khách hàng:" + makh);

        String idKH1 = khdao.selectById(makh).getId() + "";

        int Id_KH = Integer.parseInt(idKH1);
        String email = txtEmail.getText();
        String sdt = txtSdt.getText();

        return new Model.TTKhachHang(Id_KH, sdt, email);
    }

    Model.KhachHang getFormKH1() {
        Model.KhachHang kh = new Model.KhachHang();
        String TenTK = txtTaiKhoan.getText();
        String sql = "select Id from TaiKhoan where TenTK=N'" + TenTK + "'";
        ResultSet rs = JDBCHelper.query(sql);
        try {
            while (rs.next()) {
                Object[] item = new Object[1];
                item[0] = rs.getInt("Id");
                kh.setId_tk(Integer.parseInt(item[0].toString()));
                System.out.println("id lấy ra:");
            }
        } catch (Exception e) {
        }
        kh.setHoTen(txtHoTen.getText());
        return kh;
    }

    Model.TTKhachHang getformTTKH1() {
        Model.TTKhachHang ttkh = new Model.TTKhachHang();
        ttkh.setSdt(txtSdt.getText());
        ttkh.setId_KH(Integer.valueOf(lblID.getText()));
        ttkh.setEmail(txtEmail.getText());
        return ttkh;
    }
    
       boolean CheckDL() {
        // Check họ tên
        if (this.txtHoTen.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập họ và tên!");
            this.txtHoTen.requestFocus();
            return false;
        }
//        else if(!this.txtHoTen.getText().matches("[a-zA-Z]+\\\\.?")){
//            MsgBox.alert(this, "Họ Tên sai định dạng");
//            this.txtHoTen.requestFocus();
//            return false;
//        }

        // Check sdt
        if (this.txtSdt.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập SĐT!");
            this.txtSdt.requestFocus();
            return false;
        } else if (!this.txtSdt.getText().matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
            MsgBox.alert(this, "SĐT không đúng định dạng");
            this.txtSdt.requestFocus();
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
        } else if (this.ttdao.select_Email(this.txtEmail.getText()) != null) {
            MsgBox.alert(this, "Email đã tồn tại");
            this.txtEmail.requestFocus();
            return false;
        }

        // Check tài khoản
        if (this.txtTaiKhoan.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập tên tài khoản!");
            this.txtTaiKhoan.requestFocus();
            return false;
        }

        // Check mật khẩu
        if (this.txtMatKhau.getPassword().length == 0) {
            MsgBox.alert(this, "Vui lòng nhập mật khẩu!");
            this.txtMatKhau.requestFocus();
            return false;
        } else if (this.txtMatKhau.getPassword().length < 3) {
            MsgBox.alert(this, "Mật khẩu phải dài hơn 3 ký tự");
            this.txtMatKhau.requestFocus();
            return false;
        }

        return true;
    }

    boolean checTrung() {
        if (this.tkdao.select(this.txtTaiKhoan.getText()) != null) {
            MsgBox.alert(this, "Tên tài khoản đã tồn tại");
            this.txtTaiKhoan.requestFocus();
            return false;
        }
        return true;
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
        jLabel2 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Họ tên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 25, -1, -1));

        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        jPanel1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 73, 538, -1));

        jLabel3.setText("Số điện thoại:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 76, -1, -1));

        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 127, -1, -1));

        jLabel5.setText("Tài khoản:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 217, -1, -1));

        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 252, 538, -1));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MaKH", "TenKH", "SDT", "Email"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 362, 1310, 414));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 290, 134, 54));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/insert.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 290, 134, 54));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 134, 54));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 124, 538, -1));

        jLabel6.setText("Mật khẩu:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 255, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/man-icon-1 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 22, 270, 322));

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 22, 538, -1));

        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });
        jPanel1.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 214, 538, -1));

        lblID.setText("jLabel1");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 310, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         try {
            Model.KhachHang kh = getFormKH1();
            khdao.update(kh);
            Model.TTKhachHang ttkh = getformTTKH1();
            ttdao.update(ttkh);
            MsgBox.alert(this, "update thành công!");
            layTTKK();
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, " Update thất bại@@");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         if (this.CheckDL() == true && this.checTrung() == true) {
            try {
                Model.TaiKhoan tk = getFormTK();
                tkdao.insert(tk);
                listTK = tkdao.selectAll();
                for (int i = listTK.size() - 1; i >= 0; i--) {
                    Object[] row = new Object[]{
                        listTK.get(i).getId(), listTK.get(i).getTenTK(), listTK.get(i).getMatKhau()
                    };
                    txtTaiKhoan.setText(listTK.get(listTK.size() - 1).getTenTK());
                    txtMatKhau.setText(listTK.get(listTK.size() - 1).getMatKhau());
                }
                MsgBox.alert(this, "Thêm tài khoản thành công!");

                Model.KhachHang kh = getFormKH();

                khdao.insert(kh);
                Model.TTKhachHang ttkh = getformTTKH();
                ttdao.insert(ttkh);
                layTTKK();
                MsgBox.alert(this, "Thêm khách hàng thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, " Thêm thất bại @@");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
          int index;
        Model.KhachHang kh = new Model.KhachHang();
        index = tblKhachHang.getSelectedRow();
        txtHoTen.setText(tblKhachHang.getValueAt(index, 1).toString());

        txtSdt.setText(tblKhachHang.getValueAt(index, 2).toString());
        txtEmail.setText(tblKhachHang.getValueAt(index, 3).toString());

        layTaiKhoan();
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
