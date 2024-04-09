/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.admin;

import Interface.SanPhamKMInterface;
import Service.SanPhamKMService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SanPhamKM;

/**
 *
 * @author Ngo Nhan
 */
public class SanPhamKMDialog extends javax.swing.JDialog {

    /**
     * Creates new form SanPhamKMDialog
     */
    DefaultTableModel defaultTableModel;
    
    private String checkmaKM;
    String trangThai;
    SanPhamKMInterface spkm = new SanPhamKMService();
    public void setSelectedIndex(String maKM) {
        System.out.println(maKM);
        checkmaKM = maKM;
        loadDataSPKM();
        loadDataSPKM2();
    }

    void loadDataSPKM() {
        defaultTableModel = (DefaultTableModel) tblSPKM.getModel();
        defaultTableModel.setRowCount(0);
        trangThai ="Hoạt động";
        for (SanPhamKM spct : spkm.getSPKM(checkmaKM,trangThai)) {
            defaultTableModel.addRow(new Object[]{
                spct.getIdSP(),
                spct.getMaSP(),
                spct.getLoaiSP(),
                spct.getTenSP(),
                spct.getThuongHieu(),
                spct.getSize(),
                spct.getChatLieu(),
                spct.getMauSac(),});
        }

    }
    void loadDataSPKM2() {
        defaultTableModel = (DefaultTableModel) tblSPHuy.getModel();
        defaultTableModel.setRowCount(0);
        trangThai="Không hoạt động";
        for (SanPhamKM spct : spkm.getSPKM(checkmaKM,trangThai)) {
            defaultTableModel.addRow(new Object[]{
                spct.getIdSP(),
                spct.getMaSP(),
                spct.getLoaiSP(),
                spct.getTenSP(),
                spct.getThuongHieu(),
                spct.getSize(),
                spct.getChatLieu(),
                spct.getMauSac(),});
        }

    }

    public SanPhamKMDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadDataSPKM();
        loadDataSPKM2();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSPKM = new javax.swing.JTable();
        btnHuy = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPHuy = new javax.swing.JTable();
        btnBoHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 360));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm khuyến mãi"));

        tblSPKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Loại SP", "Tên SP", "Thương hiệu", "Size ", "Chất liệu", "Màu sắc"
            }
        ));
        jScrollPane1.setViewportView(tblSPKM);

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 45, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sản phẩm áp dụng", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm hủy khuyến mãi"));

        tblSPHuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Loại SP", "Tên SP", "Thương hiệu", "Size ", "Chất liệu", "Màu sắc"
            }
        ));
        jScrollPane2.setViewportView(tblSPHuy);

        btnBoHuy.setText("Bỏ hủy");
        btnBoHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(btnBoHuy)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(btnBoHuy)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 45, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hủy áp dụng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int row =tblSPKM.getSelectedRow();
        trangThai ="Hoạt động";
        if (row>=0) {
            System.out.println("row"+row);
            
            SanPhamKM sp =spkm.getSPKM(checkmaKM, trangThai).get(row);
            int idSPKM =sp.getIdSPKM();
            
            trangThai="Không hoạt động";
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy sản phẩm khuyến mãi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn Yes
                if (option == JOptionPane.YES_OPTION) {
                    spkm.update(idSPKM, trangThai);                   
                    JOptionPane.showMessageDialog(this, "Hủy thành công");
                }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn 1 sản phẩm khuyến mãi để hủy");
        }
        loadDataSPKM();
        loadDataSPKM2();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnBoHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoHuyActionPerformed
        // TODO add your handling code here:
        int row =tblSPHuy.getSelectedRow();
        trangThai ="Không hoạt động";
        if (row>=0) {
            System.out.println("row"+row);
            
            SanPhamKM sp =spkm.getSPKM(checkmaKM, trangThai).get(row);
            int idSPKM =sp.getIdSPKM();
            
            trangThai="Hoạt động";
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn bỏ hủy sản phẩm khuyến mãi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn Yes
                if (option == JOptionPane.YES_OPTION) {
                    spkm.update(idSPKM, trangThai);                   
                    JOptionPane.showMessageDialog(this, "Bỏ hủy thành công");
                }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn 1 sản phẩm khuyến mãi để tiếp tục");
        }
        loadDataSPKM();
        loadDataSPKM2();
                   
    }//GEN-LAST:event_btnBoHuyActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamKMDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamKMDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamKMDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamKMDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SanPhamKMDialog dialog = new SanPhamKMDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoHuy;
    private javax.swing.JButton btnHuy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblSPHuy;
    private javax.swing.JTable tblSPKM;
    // End of variables declaration//GEN-END:variables
}
