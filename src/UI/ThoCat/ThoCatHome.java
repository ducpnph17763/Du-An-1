/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.ThoCat;

import Avarta.CriBoder;
import UI.ChucNang.*;
import Avarta.TestRoundLabel;
import Dao.NhanVienDAO;
import Helper.XAuth;
import UI.KhachHang1.KhachHangHome;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class ThoCatHome extends javax.swing.JFrame {
    CriBoder cri = new CriBoder();
    NhanVienDAO nvdao = new NhanVienDAO();
    /**
     * Creates new form ThoCat
     */
    public ThoCatHome() {
        this.setLocationRelativeTo(null);
        initComponents();
        this.init();
    }
    public void init() {
        this.lblHinh.setBorder(cri);
        this.lblHinh.setForeground(new Color(17, 16, 99));
        this.lblHinh.setOpaque(true);
        this.lblHinh.setBackground(new Color(17, 16, 99));
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
        lblDangXuat = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDSLD = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PNchinh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDangXuat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng Xuất");
        lblDangXuat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseExited(evt);
            }
        });
        jPanel1.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 40));

        lblTaiKhoan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/account.png"))); // NOI18N
        lblTaiKhoan.setText("Tài khoản");
        lblTaiKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseExited(evt);
            }
        });
        jPanel1.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 50));

        lblDichVu.setBackground(new java.awt.Color(255, 0, 51));
        lblDichVu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        lblDichVu.setText("Dịch vụ");
        lblDichVu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDichVuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDichVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDichVuMouseExited(evt);
            }
        });
        jPanel1.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 50));

        lblName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Họ tên");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thợ cắt:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        lblHinh.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoGo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 190, -1));

        lblDSLD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDSLD.setForeground(new java.awt.Color(255, 255, 255));
        lblDSLD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDSLD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        lblDSLD.setText("DS lịch đặt");
        lblDSLD.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblDSLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDSLDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDSLDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDSLDMouseExited(evt);
            }
        });
        jPanel1.add(lblDSLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 200, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 560));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 800));

        jDesktopPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 800));

        PNchinh.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PNchinhLayout = new javax.swing.GroupLayout(PNchinh);
        PNchinh.setLayout(PNchinhLayout);
        PNchinhLayout.setHorizontalGroup(
            PNchinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1580, Short.MAX_VALUE)
        );
        PNchinhLayout.setVerticalGroup(
            PNchinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        jDesktopPane1.add(PNchinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1580, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabel2.setBackground(new java.awt.Color(17, 16, 99));
        jLabel2.setOpaque(true);
        PNchinh.removeAll();
        DichVuInter main = new DichVuInter();
        PNchinh.add(main);
        main.show();
        Model.TaiKhoan tk = XAuth.user;
        if (tk == null) {
            this.setHinh("178831-200.png");
        } else {
            Model.NhanVien nv = nvdao.SelectByTenTK(tk.getTenTK());
            this.lblName.setText(nv.getHoTen());
            if (tk.getHinh() == null) {
                this.setHinh("178831-200.png");
            }
            this.setHinh(tk.getHinh());

        }
    }//GEN-LAST:event_formWindowOpened

    private void lblDichVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDichVuMouseExited
        this.lblDichVu.setBackground(new java.awt.Color(17, 16, 99));
        this.lblDichVu.setOpaque(true);
        this.lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        this.lblDichVu.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblDichVuMouseExited

    private void lblDichVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDichVuMouseEntered
        this.lblDichVu.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblDichVu.setForeground(Color.red);
        this.lblDichVu.setBackground(Color.WHITE);
        this.lblDichVu.setOpaque(true);
    }//GEN-LAST:event_lblDichVuMouseEntered

    private void lblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDichVuMouseClicked
        PNchinh.removeAll();
        QLDichVu dv = new QLDichVu();
        PNchinh.add(dv);
        dv.show();
    }//GEN-LAST:event_lblDichVuMouseClicked

    private void lblTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseExited
        this.lblTaiKhoan.setBackground(new java.awt.Color(17, 16, 99));
        this.lblTaiKhoan.setOpaque(true);
        this.lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        this.lblTaiKhoan.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblTaiKhoanMouseExited

    private void lblTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseEntered
        this.lblTaiKhoan.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblTaiKhoan.setForeground(Color.red);
        this.lblTaiKhoan.setBackground(Color.WHITE);
        this.lblTaiKhoan.setOpaque(true);
    }//GEN-LAST:event_lblTaiKhoanMouseEntered

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        PNchinh.removeAll();
        TaiKhoan main = new TaiKhoan();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    private void lblDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseExited
        this.lblDangXuat.setBackground(new java.awt.Color(17, 16, 99));
        this.lblDangXuat.setOpaque(true);
        this.lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        this.lblDangXuat.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblDangXuatMouseExited

    private void lblDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseEntered
        this.lblDangXuat.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblDangXuat.setForeground(Color.red);
        this.lblDangXuat.setBackground(Color.WHITE);
        this.lblDangXuat.setOpaque(true);
    }//GEN-LAST:event_lblDangXuatMouseEntered

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        this.dispose();
        KhachHangHome main = new KhachHangHome();
        main.setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDSLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSLDMouseClicked
        PNchinh.removeAll();
        DSLichThoCat main = new DSLichThoCat();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblDSLDMouseClicked

    private void lblDSLDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSLDMouseEntered
        this.lblDSLD.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblDSLD.setForeground(Color.red);
        this.lblDSLD.setBackground(Color.WHITE);
        this.lblDSLD.setOpaque(true);
    }//GEN-LAST:event_lblDSLDMouseEntered

    private void lblDSLDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSLDMouseExited
        this.lblDSLD.setBackground(new java.awt.Color(17, 16, 99));
        this.lblDSLD.setOpaque(true);
        this.lblDSLD.setForeground(new java.awt.Color(255, 255, 255));
        this.lblDSLD.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblDSLDMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThoCatHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThoCatHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThoCatHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThoCatHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThoCatHome().setVisible(true);
            }
        });
    }
    
    public void setHinh(String fileName) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("src\\Image\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image scaledImage = bufferedImage.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        lblHinh.setIcon(image);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNchinh;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDSLD;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
