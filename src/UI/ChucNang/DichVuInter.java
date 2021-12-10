/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.ChucNang;

import Dao.DichVuDAO;
import Helper.XImage;
import Model.DichVu;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DichVuInter extends javax.swing.JInternalFrame {

    /**
     * Creates new form DichVuInter
     */
    int index = 0;
    DichVuDAO dvdao = new DichVuDAO();

    public DichVuInter() {
        initComponents();
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        init();
    }

    void init() {
        fillTable();
    }

    void fillTable() {
        DefaultTableModel mol = (DefaultTableModel) tblDichVu.getModel();
        mol.setRowCount(0);
        List<Model.DichVu> list = dvdao.selectAll();
        for (DichVu dichVu : list) {
            Object[] row = {
                dichVu.getId(), dichVu.getTenDV(), themPhay(dichVu.getGiaTien())
            };
            mol.addRow(row);
        }
    }

    void setForm(Model.DichVu dv) {

        lblTenDV.setText(dv.getTenDV());
        lblGiaTien.setText(dv.getGiaTien() + "");
        lblGioiThieu.setText(dv.getMoTa());
        if (dv.getHinh() != null) {
            lblAnhDichVu.setToolTipText(dv.getHinh());
            lblAnhDichVu.setIcon(XImage.read(dv.getHinh()));
        }

    }

    void edit() {
        String madv = (String) tblDichVu.getValueAt(index, 0);
        DichVu dv = dvdao.selectById(madv);
        setForm(dv);

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
        tblDichVu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblAnhDichVu = new javax.swing.JLabel();
        lblTenDV = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();
        lblGioiThieu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên Dịch Vụ", "Giá tiền"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        jLabel6.setText("Bảng dịch vụ");

        lblAnhDichVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTenDV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenDV.setText("Cắt tóc");

        lblGiaTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblGiaTien.setForeground(new java.awt.Color(204, 0, 51));
        lblGiaTien.setText("50000");

        lblGioiThieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGioiThieu.setText("Tạo kiểu cắt tóc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnhDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenDV)
                            .addComponent(lblGiaTien)
                            .addComponent(lblGioiThieu)))
                    .addComponent(jLabel6))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAnhDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenDV)
                        .addGap(18, 18, 18)
                        .addComponent(lblGiaTien)
                        .addGap(18, 18, 18)
                        .addComponent(lblGioiThieu)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            index = tblDichVu.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked
    public String themPhay(int tien) {
        double money = Double.valueOf(tien);
        return String.format("%,.0f", money);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnhDichVu;
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblGioiThieu;
    private javax.swing.JLabel lblTenDV;
    private javax.swing.JTable tblDichVu;
    // End of variables declaration//GEN-END:variables
}
