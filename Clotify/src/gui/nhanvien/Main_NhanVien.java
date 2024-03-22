/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.nhanvien;



import gui.admin.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import java.util.Locale;
import javax.swing.*;
/**
 *
 * @author ADMIN
 */
public class Main_NhanVien extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    public Main_NhanVien() {
        initComponents();
        init();
        trang2();
    }

    private void init() {
        setLocationRelativeTo(null);
    }

    void trang1() {
        System.out.println("Truy cap menu : 1");
        DesktopPane.removeAll();
        TrangSP_nv trang1 = new TrangSP_nv();
        trang1.setSize(DesktopPane.getSize());
        DesktopPane.add(trang1).setVisible(true);
    }

    void trang2() {
        System.out.println("Truy cap menu : 2");
        ui_custom.disposeAllFrame(DesktopPane);
        TrangBanHang trang2 = new TrangBanHang();
        trang2.setSize(DesktopPane.getSize());
        DesktopPane.add(trang2).setVisible(true);
    }

    void trang3() {
        System.out.println("Truy cap menu : 3");
        ui_custom.disposeAllFrame(DesktopPane);
        TrangKhachHang trang3 =  new TrangKhachHang();
        DesktopPane.add(trang3).setVisible(true);
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
        background = new javax.swing.JPanel();
        menubar = new keeptoo.KGradientPanel();
        menu = new javax.swing.JLabel();
        trang1 = new javax.swing.JLabel();
        trang2 = new javax.swing.JLabel();
        trang3 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        setSize(new java.awt.Dimension(1260, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setMaximumSize(new java.awt.Dimension(1260, 700));
        background.setMinimumSize(new java.awt.Dimension(1260, 700));
        background.setPreferredSize(new java.awt.Dimension(1260, 700));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menubar.setForeground(new java.awt.Color(255, 255, 255));
        menubar.setkStartColor(new java.awt.Color(9, 4, 62));
        menubar.setPreferredSize(new java.awt.Dimension(90, 900));
        menubar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.setText("Clotify");
        menubar.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 160, 18));

        trang1.setFont(new java.awt.Font("Raleway SemiBold", 1, 13)); // NOI18N
        trang1.setForeground(new java.awt.Color(255, 255, 255));
        trang1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8-t-shirt-24 (2).png"))); // NOI18N
        trang1.setText("     Sản phẩm");
        trang1.setToolTipText("");
        trang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trang1MouseClicked(evt);
            }
        });
        menubar.add(trang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 18));

        trang2.setFont(new java.awt.Font("Raleway SemiBold", 1, 13)); // NOI18N
        trang2.setForeground(new java.awt.Color(255, 255, 255));
        trang2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8-t-shirt-24 (3).png"))); // NOI18N
        trang2.setText("     Bán hàng");
        trang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trang2MouseClicked(evt);
            }
        });
        menubar.add(trang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 18));

        trang3.setFont(new java.awt.Font("Raleway SemiBold", 1, 13)); // NOI18N
        trang3.setForeground(new java.awt.Color(255, 255, 255));
        trang3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trang3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/insert_chart_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        trang3.setText("     Khách hàng");
        trang3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trang3MouseClicked(evt);
            }
        });
        menubar.add(trang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 150, 20));

        menu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu1.setForeground(new java.awt.Color(255, 255, 255));
        menu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu1.setText("Nhân viên");
        menubar.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 18));

        background.add(menubar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 900));

        DesktopPane.setBackground(new java.awt.Color(244, 244, 244));
        DesktopPane.setMaximumSize(new java.awt.Dimension(1140, 700));
        DesktopPane.setMinimumSize(new java.awt.Dimension(1140, 700));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        background.add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trang2MouseClicked
        // TODO add your handling code here:
        trang2();
    }//GEN-LAST:event_trang2MouseClicked

    private void trang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trang1MouseClicked
        // TODO add your handling code here:
        trang1();
    }//GEN-LAST:event_trang1MouseClicked

    private void trang3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trang3MouseClicked
        // TODO add your handling code here:
        trang3();
    }//GEN-LAST:event_trang3MouseClicked

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_NhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JPanel background;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private keeptoo.KGradientPanel menubar;
    private javax.swing.JLabel trang1;
    private javax.swing.JLabel trang2;
    private javax.swing.JLabel trang3;
    // End of variables declaration//GEN-END:variables
}
