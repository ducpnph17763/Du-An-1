/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.QuanLy;

import Avarta.CriBoder;
import Dao.NhanVienDAO;
import Helper.XAuth;

import Avarta.TestRoundLabel;
import Avarta.CriBoder;

import Dao.NhanVienDAO;
import Helper.XAuth;
import UI.LeTan.DSLichDatLeTan;
import UI.ChucNang.HoaDon;
import UI.ChucNang.KhachHang;
import UI.ChucNang.NhanVienInter;
import UI.ChucNang.QLDichVu;
import UI.ChucNang.TaiKhoan;
import UI.ChucNang.ThongKe;
import java.awt.Color;
import UI.KhachHang1.*;
import UI.LeTan.DatLichLeTan;
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
public class QuanLyHome extends javax.swing.JFrame {

    NhanVienDAO nvdao = new NhanVienDAO();
    public QuanLyHome() {
        initComponents();
        this.init();
    }

    public void init() {
        this.SetAVT();
    }

    public void SetAVT() {
        CriBoder cri = new CriBoder();
        lblHinh.setBorder(cri);
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
        lblNhanVien = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblDSLD = new javax.swing.JLabel();
        lblDatLich = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PNchinh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

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
        jPanel1.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 200, 40));

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
        jPanel1.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 200, 50));

        lblNhanVien.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/technical-support.png"))); // NOI18N
        lblNhanVien.setText("Nhân viên ");
        lblNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
        });
        jPanel1.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 50));

        lblThongKe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thongKe.png"))); // NOI18N
        lblThongKe.setText("Thống kê");
        lblThongKe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongKeMouseExited(evt);
            }
        });
        jPanel1.add(lblThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 200, 50));

        lblKhachHang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/target.png"))); // NOI18N
        lblKhachHang.setText("Khách hàng");
        lblKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseExited(evt);
            }
        });
        jPanel1.add(lblKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 200, 50));

        lblHoaDon.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/receipt.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn");
        lblHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseExited(evt);
            }
        });
        jPanel1.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 50));

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

        lblDatLich.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDatLich.setForeground(new java.awt.Color(255, 255, 255));
        lblDatLich.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDatLich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar (1).png"))); // NOI18N
        lblDatLich.setText("Đặt lịch");
        lblDatLich.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblDatLich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatLichMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDatLichMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDatLichMouseExited(evt);
            }
        });
        jPanel1.add(lblDatLich, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 50));

        lblDichVu.setBackground(new java.awt.Color(255, 0, 51));
        lblDichVu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dichvu.png"))); // NOI18N
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
        jPanel1.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 50));

        lblHoTen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoTen.setText("Họ tên");
        jPanel1.add(lblHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quản lý: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        jPanel1.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoGo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 560));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 800));

        jDesktopPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 800));

        PNchinh.setBackground(new java.awt.Color(255, 255, 255));
        PNchinh.setPreferredSize(new java.awt.Dimension(650, 590));

        javax.swing.GroupLayout PNchinhLayout = new javax.swing.GroupLayout(PNchinh);
        PNchinh.setLayout(PNchinhLayout);
        PNchinhLayout.setHorizontalGroup(
            PNchinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1590, Short.MAX_VALUE)
        );
        PNchinhLayout.setVerticalGroup(
            PNchinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jDesktopPane1.add(PNchinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1590, 800));

        getContentPane().add(jDesktopPane1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void lblDatLichMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatLichMouseEntered
        this.lblDatLich.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblDatLich.setForeground(Color.red);
        this.lblDatLich.setBackground(Color.WHITE);
        this.lblDatLich.setOpaque(true);
    }//GEN-LAST:event_lblDatLichMouseEntered

    private void lblDatLichMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatLichMouseExited
        this.lblDatLich.setBackground(new java.awt.Color(17, 16, 99));
        this.lblDatLich.setOpaque(true);
        this.lblDatLich.setForeground(new java.awt.Color(255, 255, 255));
        this.lblDatLich.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblDatLichMouseExited

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

    private void lblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseEntered
        this.lblHoaDon.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblHoaDon.setForeground(Color.red);
        this.lblHoaDon.setBackground(Color.WHITE);
        this.lblHoaDon.setOpaque(true);
    }//GEN-LAST:event_lblHoaDonMouseEntered

    private void lblHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseExited
        this.lblHoaDon.setBackground(new java.awt.Color(17, 16, 99));
        this.lblHoaDon.setOpaque(true);
        this.lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        this.lblHoaDon.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblHoaDonMouseExited

    private void lblKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseEntered
        this.lblKhachHang.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblKhachHang.setForeground(Color.red);
        this.lblKhachHang.setBackground(Color.WHITE);
        this.lblKhachHang.setOpaque(true);
    }//GEN-LAST:event_lblKhachHangMouseEntered

    private void lblKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseExited
        this.lblKhachHang.setBackground(new java.awt.Color(17, 16, 99));
        this.lblKhachHang.setOpaque(true);
        this.lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        this.lblKhachHang.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblKhachHangMouseExited

    private void lblThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseEntered
        this.lblThongKe.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblThongKe.setForeground(Color.red);
        this.lblThongKe.setBackground(Color.WHITE);
        this.lblThongKe.setOpaque(true);
    }//GEN-LAST:event_lblThongKeMouseEntered

    private void lblThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseExited
        this.lblThongKe.setBackground(new java.awt.Color(17, 16, 99));
        this.lblThongKe.setOpaque(true);
        this.lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        this.lblThongKe.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblThongKeMouseExited

    private void lblTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseEntered
        this.lblTaiKhoan.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblTaiKhoan.setForeground(Color.red);
        this.lblTaiKhoan.setBackground(Color.WHITE);
        this.lblTaiKhoan.setOpaque(true);
    }//GEN-LAST:event_lblTaiKhoanMouseEntered

    private void lblTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseExited
        this.lblTaiKhoan.setBackground(new java.awt.Color(17, 16, 99));
        this.lblTaiKhoan.setOpaque(true);
        this.lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        this.lblTaiKhoan.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblTaiKhoanMouseExited

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        this.lblNhanVien.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblNhanVien.setForeground(Color.red);
        this.lblNhanVien.setBackground(Color.WHITE);
        this.lblNhanVien.setOpaque(true);
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        this.lblNhanVien.setBackground(new java.awt.Color(17, 16, 99));
        this.lblNhanVien.setOpaque(true);
        this.lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        this.lblNhanVien.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseEntered
        this.lblDangXuat.setFont(new java.awt.Font("Arial", 0, 16));
        this.lblDangXuat.setForeground(Color.red);
        this.lblDangXuat.setBackground(Color.WHITE);
        this.lblDangXuat.setOpaque(true);
    }//GEN-LAST:event_lblDangXuatMouseEntered

    private void lblDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseExited
        this.lblDangXuat.setBackground(new java.awt.Color(17, 16, 99));
        this.lblDangXuat.setOpaque(true);
        this.lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        this.lblDangXuat.setFont(new java.awt.Font("Arial", 0, 12));
    }//GEN-LAST:event_lblDangXuatMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabel2.setBackground(new java.awt.Color(17, 16, 99));
        jLabel2.setOpaque(true);
        QLDichVu dv = new QLDichVu();
        PNchinh.add(dv);
        dv.show();
        Model.TaiKhoan tk = XAuth.user;
        if (tk == null) {
            this.SetHinh("178831-200.png");
        } else {
            Model.NhanVien nv = nvdao.SelectByTenTK(tk.getTenTK());
            this.lblHoTen.setText(nv.getHoTen());
            if (tk.getHinh() == null) {
                this.SetHinh("178831-200.png");
            }
            this.SetHinh(tk.getHinh());
        }
    }//GEN-LAST:event_formWindowOpened

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        PNchinh.removeAll();
        ThongKe tk = new ThongKe();
        PNchinh.add(tk);
        tk.show();
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void lblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDichVuMouseClicked
        PNchinh.removeAll();
        QLDichVu dv = new QLDichVu();
        PNchinh.add(dv);
        dv.show();
    }//GEN-LAST:event_lblDichVuMouseClicked

    private void lblDSLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDSLDMouseClicked
        PNchinh.removeAll();
        DSLichDatLeTan main = new DSLichDatLeTan();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblDSLDMouseClicked

    private void lblDatLichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatLichMouseClicked
        PNchinh.removeAll();
        DatLichLeTan main = new DatLichLeTan();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblDatLichMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        PNchinh.removeAll();
        HoaDon main = new HoaDon();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        PNchinh.removeAll();
        KhachHang main = new KhachHang();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        PNchinh.removeAll();
        NhanVienInter main = new NhanVienInter();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        PNchinh.removeAll();
        TaiKhoan main = new TaiKhoan();
        PNchinh.add(main);
        main.show();
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        this.dispose();
        KhachHangHome main = new KhachHangHome();
        main.setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHome().setVisible(true);
            }
        });
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
    private javax.swing.JLabel lblDatLich;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongKe;
    // End of variables declaration//GEN-END:variables

    public void SetHinh(String fileName) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("src\\Image\\" + fileName));
        } catch (IOException e) {
            
        }
        Image scaledImage = bufferedImage.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        lblHinh.setIcon(image);
    }
}
