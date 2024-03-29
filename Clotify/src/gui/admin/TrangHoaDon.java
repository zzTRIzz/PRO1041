/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

import Interface.HoaDonCTService;
import Interface.HoaDonService;
import Service.HoaDonCTImpl;
import Service.HoaDonImpl;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonCTAdmin;

/**
 *
 * @author ADMIN
 */
public class TrangHoaDon extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    HoaDonService svHD = new HoaDonImpl();
    HoaDonCTService svHDCT = new HoaDonCTImpl();

    /**
     * Creates new form Trang0
     */
    public TrangHoaDon() {
        initComponents();
        ui_custom.deleteTitle(this);
        model = (DefaultTableModel) tbHoaDon.getModel();
        loadDataHD();
    }

    void loadDataHD() {
        model.setRowCount(0);
        for (HoaDon hd : svHD.getAllHoaDonAdmin()) {
            Object[] row = new Object[]{
                hd.getIdHD(),
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getMaNV(),
                hd.getTrangThai()
            };
            model.addRow(row);
        }
    }

    void loadDataHDCT(int idHD) {
        DefaultTableModel modelCTHD = (DefaultTableModel) tbHDCT.getModel();
        modelCTHD.setRowCount(0);
        for (HoaDonCTAdmin hdctad : svHDCT.getHoaDonCTAllAdmin(idHD)) {
            modelCTHD.addRow(new Object[]{
                hdctad.getIdHoaDonCT(),
                hdctad.getMaHD(),
                hdctad.getMaNV(),
                hdctad.getNgayTao(),
                hdctad.getTenKH(),
                hdctad.getCtMaSP(),
                hdctad.getTenSP(),
                hdctad.getSoLuongMua(),
                hdctad.getTongTien()
            });

        }
    }

    void setForm(HoaDon hd) {
        String tt = hd.getTrangThai();
        if ("Đã thanh toán".equals(tt)) {
            rdDaThanhToan.setSelected(true);
        } else {
            rdChuaThanhToan.setSelected(true);
        }
    }

    HoaDon getForm() {
        HoaDon hd = new HoaDon();
        hd.setTrangThai(rdDaThanhToan.isSelected() ? "Đã thanh toán" : "Chưa thanh toán");
        return hd;
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        HoaDon = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbHDCT = new javax.swing.JTable();
        rdDaThanhToan = new javax.swing.JRadioButton();
        rdChuaThanhToan = new javax.swing.JRadioButton();
        btSearchMa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btSearchDays = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setResizable(true);
        setTitle("Trang 3");
        setMaximumSize(new java.awt.Dimension(1140, 700));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setPreferredSize(new java.awt.Dimension(1140, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 700));

        jLabel14.setText("Bắt đầu ");

        jLabel15.setText("Kết thúc");

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbHoaDon);

        tbHDCT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tbHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên NV", "Ngày tạo", "ID KH", "Mã SP", "Tên SP", "Tổng SL Mua", "Tổng tiền"
            }
        ));
        jScrollPane8.setViewportView(tbHDCT);

        buttonGroup1.add(rdDaThanhToan);
        rdDaThanhToan.setText("Đã thanh toán");
        rdDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdChuaThanhToan);
        rdChuaThanhToan.setText("Đã hủy");

        btSearchMa.setText("Search");
        btSearchMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchMaMouseClicked(evt);
            }
        });

        btSearchDays.setText("Search");
        btSearchDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchDaysMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSearchMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HoaDonLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btSearchDays)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdDaThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(rdChuaThanhToan))
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane9))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(btSearchMa)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdDaThanhToan)
                        .addComponent(rdChuaThanhToan)
                        .addComponent(btSearchDays)))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDaThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDaThanhToanActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();

        if (row >= 0) {
            setForm(svHD.getRowHD(row));
        }

        if (row > 0) {

            HoaDon hd = svHD.getRowHD(row);
            int idHD = hd.getIdHD();
            loadDataHDCT(idHD);
        }
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btSearchMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMaMouseClicked
        // TODO add your handling code here:
        String key = txtTimKiem.getText();
        DefaultTableModel modelsearch = (DefaultTableModel) tbHoaDon.getModel();
        modelsearch.setRowCount(0);
        for (HoaDon hoaDon : svHD.Search(key)) {
            modelsearch.addRow(new Object[]{
                hoaDon.getIdHD(),
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getMaNV(),
                hoaDon.getTrangThai()
            });
    }//GEN-LAST:event_btSearchMaMouseClicked
    }
    private void btSearchDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchDaysMouseClicked
        // TODO add your handling code here:
        Date batDau = txtNgayBatDau.getDate();
        Date ketThuc = txtNgayKetThuc.getDate();

        if (batDau == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (ketThuc == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày kết thúc ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ketThuc.before(batDau)) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc không thể trước ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel modelSearch = (DefaultTableModel) tbHoaDon.getModel();
        modelSearch.setRowCount(0);
        for (HoaDon hoaDon : svHD.SearchTime(batDau, ketThuc)) {
            modelSearch.addRow(new Object[]{
                hoaDon.getIdHD(),
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getMaNV(),
                hoaDon.getTrangThai()
            });
        }
    }//GEN-LAST:event_btSearchDaysMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoaDon;
    private javax.swing.JButton btSearchDays;
    private javax.swing.JButton btSearchMa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdChuaThanhToan;
    private javax.swing.JRadioButton rdDaThanhToan;
    private javax.swing.JTable tbHDCT;
    private javax.swing.JTable tbHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
