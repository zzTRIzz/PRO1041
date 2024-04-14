/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.nhanvien;

import Interface.HoaDonCTService;
import Interface.HoaDonService;
import Interface.SanPhamCTImpl;
import Service.HoaDonCTImpl;
import Service.HoaDonImpl;
import Service.KhachHangService;
import Service.SanPhamCTService;
import Service.TaiKhoanService;
import Service.VoucherService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.ds.buildin.WebcamDefaultDriver;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import gui.admin.*;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.lang.System.Logger;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.SanPhamCT;
import model.Voucher;

/**
 *
 * @author ADMIN
 */
public class TrangBanHang extends javax.swing.JInternalFrame {

    LocalDate thoiGian = LocalDate.now();
    DefaultTableModel defaultTableModel;
    SanPhamCTImpl svSP = new SanPhamCTService();
    HoaDonService svHd = new HoaDonImpl();
    HoaDonCTService svHDCT = new HoaDonCTImpl();
    KhachHangService svKH = new KhachHangService();
    VoucherService svVC = new VoucherService();

    /**
     * Creates new form Trang0
     */
    private Webcam webcam = null;
    private QRScanner qr = new QRScanner();

    public TrangBanHang() {
        initComponents();
        initWebcam();
        ui_custom.deleteTitle(this);
        loadSanPham();
        loadHoaDon();
        loadVoucher();
        lblTenNV.setText(TaiKhoanService.layThongTin_tenNV());
        cboVoucher.setSelectedIndex(-1);

    }

    private void initWebcam() {

        Thread loadQR = new Thread(() -> {
//            qr.closeCamera(); // Đảm bảo camera đóng trước khi thay đổi độ phân giải

            // Thay đổi độ phân giải của webcam và mở nó
//            qr.getWebcam().setViewSize(WebcamResolution.QVGA.getSize());
//            qr.toggleCamera();

            // Thêm panel của QRScanner vào panelQRCode
            panelQRCode.add(qr.getWebcamPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 184, 184));
            revalidate();
            repaint();
        });
        loadQR.start();
    }

    void loadVoucher() {
        cboVoucher.removeAllItems();
        for (Voucher voucher : svVC.getVoucherHD()) {
            cboVoucher.addItem(voucher.getMaVC());
        }

    }

    void loadSanPham() {
        defaultTableModel = (DefaultTableModel) tblSP.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamCT spct : svSP.getAll()) {
            defaultTableModel.addRow(new Object[]{
                spct.getIdSP(),
                //                spct.getMaSP(),
                spct.getTenSP(),
                spct.getTenTH(),
                spct.getTenSize(),
                spct.getTenCL(),
                spct.getTenMS(),
                spct.getGiaBan(),
                spct.getSoLuong(),
                spct.getTrangThai()
            });
        }
    }

    void loadHoaDon() {
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : svHd.getHoaDonAll()) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getIdHD(),
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getTenNV(),
                hoaDon.getTenKH(),
                hoaDon.getTrangThai()
            });
        }
    }

    void loadHoaDonCT(int idHD) {
        defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonCT hoaDonCT : svHDCT.getHoaDonCTAll(idHD)) {
            defaultTableModel.addRow(new Object[]{
                hoaDonCT.getIdHoaDonCT(),
                hoaDonCT.getTenSP(),
                hoaDonCT.getGiaBan(),
                hoaDonCT.getSoLuongMua(),
                //                hoaDonCT.getTenKM(),
                //                hoaDonCT.getKhuyenMaiPT(),
                //                hoaDonCT.getTrangThaiKM(),

                hoaDonCT.phanTramKM(),
                hoaDonCT.getTongTien()
            });
        }
//        
    }

////    private WebcamPanel panel = null;
////    QRScanner qr = new QRScanner();
//    private void initWebcam() {
////        Dimension size = WebcamResolution.QVGA.getSize();
////        webcam = Webcam.getWebcams().get(0);
////        webcam.setViewSize(size);
////
////        panel = new WebcamPanel(webcam);
////        panel.setPreferredSize(size);
////        panel.setFPSDisplayed(true);
//
////        panelQRCode.removeAll();
////
////        // Kiểm tra nếu webcam đang mở thì đóng trước khi thay đổi độ phân giải
////        if (qr.getWebcam().isOpen()) {
////            qr.closeCamera();
//////            qr.toggleCamera();
////        }
////
////        panelQRCode.add(qr.getWebcamPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 184, 184));
////        revalidate();
////        repaint();
//         panelQRCode.removeAll();
//
//    // Đóng webcam trước khi thay đổi độ phân giải
//    qr.closeCamera();
//
//    // Kiểm tra xem camera đã mở trong một JInternalFrame khác hay không
//    if (!qr.getWebcam().isOpen()) {
//        // Thay đổi độ phân giải của webcam
//        qr.getWebcam().setViewSize(WebcamResolution.QVGA.getSize());
//        
//        // Mở camera và bắt đầu panel
//        qr.toggleCamera();
//    }
//
//    panelQRCode.add(qr.getWebcamPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 184, 184));
//    revalidate();
//    repaint();
//        
//
//    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSPGH = new javax.swing.JButton();
        btnDoiSL = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtSDT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txttienKhachDua = new javax.swing.JTextField();
        cboVoucher = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblCanTra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        lblBangVoucher = new javax.swing.JLabel();
        panelQRCode = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setResizable(true);
        setTitle("Trang 2");
        setMaximumSize(new java.awt.Dimension(1140, 700));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setPreferredSize(new java.awt.Dimension(1140, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 700));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ Hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên SP", "Giá Bán", "SL Mua", "% KM", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        btnXoaSPGH.setText("Xóa");
        btnXoaSPGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPGHActionPerformed(evt);
            }
        });

        btnDoiSL.setText("Đổi SL");
        btnDoiSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiSLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnXoaSPGH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDoiSL)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSPGH)
                    .addComponent(btnDoiSL)))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tên nhân viên", "Tên khách hàng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên SP", "Thương hiệu", "Size", "Chất liệu", "Màu Sắc", "Giá bán", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSP);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 70, 128), 1, true), "Tạo hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(20, 70, 128))); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        jLabel18.setText("Số ĐT");

        jLabel17.setText("Tên KH");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel19.setText("Tổng tiền");

        jLabel20.setText("Khách đưa");

        jLabel21.setText("Tiền thừa");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txttienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttienKhachDuaKeyReleased(evt);
            }
        });

        cboVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVoucherActionPerformed(evt);
            }
        });

        jLabel52.setText("Mã voucher");

        jLabel53.setText("Tên NV");

        lblTenNV.setText("Nguyễn Văn A");

        lblTongTien.setText("0");

        lblCanTra.setText("0");

        jLabel2.setText("Cần trả");

        lblTienThua.setText("0");

        lblBangVoucher.setText("Xem");
        lblBangVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBangVoucherMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBangVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19)
                            .addComponent(jLabel2))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttienKhachDua)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(lblTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel52)
                    .addComponent(cboVoucher)
                    .addComponent(lblBangVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCanTra)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txttienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelQRCode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Mở / tắt camera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelQRCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(panelQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnXoaSPGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPGHActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        System.out.println("vi tri" + row);
        if (row >= 0 && row < tblGioHang.getRowCount()) {
            HoaDonCT hdct = svHDCT.getRowHDCT(row);

            int idHDCT = hdct.getIdHoaDonCT();
            int idHD = hdct.getIdHD();
            int idSP = hdct.getIdSP();
            String tenSP = hdct.getTenSP();
            int soLuongMua = hdct.getSoLuongMua();
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm: " + tenSP + " không?", "Xóa sản phẩm trong giỏ hàng", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                svHDCT.deleteHDCT(idHDCT);
                JOptionPane.showMessageDialog(this, "Bạn xóa thành công");
            } else {
            }
            loadHoaDonCT(idHD);
            double tongTienTra = 0;
            for (HoaDonCT hoaDonCT : svHDCT.getHoaDonCTAll(idHD)) {
                if (hoaDonCT.getIdHD() == idHD) {
                    tongTienTra += hoaDonCT.getTongTien();
                }
            }
//                            System.out.println(tongTienTra);
            String tien = String.valueOf(tongTienTra);

            lblTongTien.setText(tien);
            lblCanTra.setText(tien);
            for (SanPhamCT sanPhamCT : svSP.getAll()) {
                if (sanPhamCT.getIdSP().equals(idSP)) {
                    int soLuongTon = sanPhamCT.getSoLuong();
                    int soLuongMoi = soLuongMua + soLuongTon;
                    svSP.updateSanPhamCT(idSP, soLuongMoi);
                }
            }
            loadSanPham();
        }
    }//GEN-LAST:event_btnXoaSPGHActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            HoaDon hd = svHd.getRowHD(row);
            int idHD = hd.getIdHD();
            String tenKH = hd.getTenKH();
            lblTenKH.setText(tenKH);

            loadHoaDonCT(idHD);
            double tongTienTra = 0;
            for (HoaDonCT hoaDonCT : svHDCT.getHoaDonCTAll(idHD)) {
                if (hoaDonCT.getIdHD() == idHD) {
                    tongTienTra += hoaDonCT.getTongTien();
                }
            }
//                            System.out.println(tongTienTra);
            String tien = String.valueOf(tongTienTra);

            lblTongTien.setText(tien);
            lblCanTra.setText(tien);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
            int rowSanPham = tblSP.getSelectedRow();
            SanPhamCT sp = svSP.getRow(rowSanPham);
            int soLuongTonTai = sp.getSoLuong();
            int idSP = sp.getIdSP();
            double giaSP = sp.getGiaBan();
            int soLuong;
            int tongSoLuong;
            double thanhTien;
            int soLuongCon;

//            String trangThai = "Hoạt động";
            HoaDon hd = svHd.getRowHD(rowHoaDon);
            int idHD = hd.getIdHD();
            //data gắn

            int phanTramKM;
            double phanTramDouble;
            //
            double tongTien;
            if (rowSanPham >= 0) {
                // Hiển thị hộp thoại yêu cầu nhập số lượng
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn nhập số lượng không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn Yes
                if (option == JOptionPane.YES_OPTION) {
                    String input = JOptionPane.showInputDialog(null, "Nhập số lượng:", "Thêm sản phẩm vào giỏ hàng", HEIGHT);
                    if (input != null && !input.isEmpty()) {

                        try {
                            soLuong = Integer.parseInt(input);
                            if (soLuong <= soLuongTonTai && soLuong > 0) {
//                            System.out.println("Số lượng đã nhập: " + soLuong);
                            } else {
                                do {
                                    String input2 = JOptionPane.showInputDialog(null, "Số lượng không hợp lệ, mời nhập lại:", "Thêm sản phẩm vào giỏ hàng", HEIGHT);
                                    soLuong = Integer.parseInt(input2);

                                } while (soLuong <= 0 || soLuong > soLuongTonTai);

                            }
                            System.out.println("Số lượng đã nhập: " + soLuong);
                            soLuongCon = soLuongTonTai - soLuong;
                            System.out.println("So luong con:" + soLuongCon);
                            svSP.updateSanPhamCT(idSP, soLuongCon);
//
//                            phanTramDouble = Double.valueOf(phanTramKM);
//                            tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
//                            System.out.println(tongTien);
//                            // them id =SPKM de check
                            int count = svHDCT.getSanPhamTonTai(idHD, idSP).size();

                            System.out.println("count" + count);
                            if (count == 1) {

                                HoaDonCT hdct = svHDCT.getSanPhamTonTai(idHD, idSP).get(0);
                                phanTramKM = hdct.phanTramKM();
                                phanTramDouble = Double.valueOf(phanTramKM);
                                int idHDCT = hdct.getIdHoaDonCT();
//                                System.out.println(idHDCT);
                                tongSoLuong = hdct.getSoLuongMua() + soLuong;
//                                System.out.println(tongSoLuong);
                                thanhTien = tongSoLuong * giaSP * (1 - phanTramDouble / 100);
//                                System.out.println(thanhTien);

//                              gop sp cung 
                                svHDCT.gopSanPhamTonTai(idHDCT, tongSoLuong, thanhTien);
                                loadHoaDonCT(idHD);

                            } else {
                                // tach luong san pham co khuyen mai
                                int countSPKM = svSP.getCheckKM(idSP).size();
                                String trangThai;
                                //sp ko co km
                                switch (countSPKM) {
                                    case 0:
                                        phanTramKM = 0;
                                        phanTramDouble = Double.valueOf(phanTramKM);
                                        tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
                                        svHDCT.addHoaDonCT(new HoaDonCT(idSP, idHD, tongTien, soLuong));
                                        loadHoaDonCT(idHD);
                                        break;
                                    //ok
                                    case 1:
                                        SanPhamCT spct = svSP.getCheckKM(idSP).get(0);
                                        trangThai = spct.getTrangThaiKM();
                                        if (trangThai.equals("Đang áp dụng")) {
                                            // add san pham co km
                                            phanTramKM = spct.getPhanTramKM();
                                            phanTramDouble = Double.valueOf(phanTramKM);
                                            tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
                                            svHDCT.addHoaDonCT(new HoaDonCT(idSP, idHD, tongTien, soLuong));
                                            loadHoaDonCT(idHD);
                                            //ok
                                        } else if (trangThai.equals("Hết hạn")) {
                                            // add san pham ko km
                                            phanTramKM = 0;
                                            phanTramDouble = Double.valueOf(phanTramKM);
                                            tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
                                            svHDCT.addHoaDonCT(new HoaDonCT(idSP, idHD, tongTien, soLuong));
                                            loadHoaDonCT(idHD);
                                            //ok
                                        }
                                        break;
                                    default:
                                        List<SanPhamCT> listSPKM = svSP.getCheckKM(idSP);

                                        String maxNgayQuyetDinh = null;
                                        SanPhamCT spct2 = null;
                                        String maKM = null;

                                        boolean daCapNhatMaxNgayQuyetDinh = false;
                                        for (int i = 0; i < listSPKM.size(); i++) {
                                            if (maxNgayQuyetDinh == null || listSPKM.get(i).getNgayQuyetDinh().compareTo(maxNgayQuyetDinh) > 0) {
                                                maxNgayQuyetDinh = listSPKM.get(i).getNgayQuyetDinh();
                                                spct2 = listSPKM.get(i);
                                                maKM = spct2.getMaKM();
                                                daCapNhatMaxNgayQuyetDinh = true;
                                                System.out.println("ngay quyet dinh" + maxNgayQuyetDinh);
                                                spct2.getTrangThaiKM();
                                            }
                                        }
                                        System.out.println("ngay quyet dinh" + maxNgayQuyetDinh);
                                        System.out.println("ma KM " + maKM);
                                        System.out.println("Trang thai " + spct2.getTrangThaiKM());
                                        if (daCapNhatMaxNgayQuyetDinh) {

                                            if (spct2 != null && spct2.getTrangThaiKM().equals("Đang áp dụng")) {
                                                phanTramKM = spct2.getPhanTramKM();
                                                phanTramDouble = Double.valueOf(phanTramKM);
                                                tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
                                                svHDCT.addHoaDonCTKM(idHD, soLuong, idSP, tongTien);
                                                loadHoaDonCT(idHD);
                                            } else if (spct2 != null && spct2.getTrangThaiKM().equals("Hết hạn")) {
                                                phanTramKM = 0;
                                                phanTramDouble = Double.valueOf(phanTramKM);
                                                tongTien = soLuong * giaSP * (1 - phanTramDouble / 100);
                                                svHDCT.addHoaDonCTKM(idHD, soLuong, idSP, tongTien);
                                                loadHoaDonCT(idHD);
                                            }
                                        }

                                        break;

                                }

                            }

                            double tongTienTra = 0;
                            for (HoaDonCT hoaDonCT : svHDCT.getHoaDonCTAll(idHD)) {
                                if (hoaDonCT.getIdHD() == idHD) {
                                    tongTienTra += hoaDonCT.getTongTien();
                                }
                            }
//                            System.out.println(tongTienTra);
                            String tien = String.valueOf(tongTienTra);
                            lblTongTien.setText(tien);
                            lblCanTra.setText(tien);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Nhập số nguyên hợp lệ!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập số lượng!");
                    }
                } else {
                }

            }

        }
        loadSanPham();

    }//GEN-LAST:event_tblSPMouseClicked

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        // 
        String maNV = TaiKhoanService.layThongTin_maNV();
        String ngayTao = thoiGian.toString();
        String trangThai = "Chưa thanh toán";
        String sdt = txtSDT.getText();
        if (sdt.isEmpty()) {
            int idKH = 1;
            svHd.addHoaDon(new HoaDon(idKH, ngayTao, trangThai, maNV));

        } else {
            for (KhachHang khachHang : svKH.getKhachHang()) {
                if (khachHang.getSdt().equals(sdt)) {
                    int idKH = khachHang.getIdKH();
                    svHd.addHoaDon(new HoaDon(idKH, ngayTao, trangThai, maNV));
                }
            }
        }

        loadHoaDon();
        defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
        defaultTableModel.setRowCount(0);
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            HoaDon hd = svHd.getRowHD(row);
            int maHD = hd.getMaHD();
            int idHD = hd.getIdHD();

            String maNV = TaiKhoanService.layThongTin_maNV();
            String ngayTao = thoiGian.toString();
            String trangThai = "Đã hủy";
            String tenKH = hd.getTenKH();
            String maVoucher = null;
            List<KhachHang> listKhachHang = svKH.getKhachHang();
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy hóa đơn: " + maHD + " không?", "Hủy hóa đơn", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // trả sp về

                List<HoaDonCT> listHDCT = svHDCT.getHoaDonCTAll(idHD);

                for (int i = 0; i < listHDCT.size(); i++) {
                    int idSP = listHDCT.get(i).getIdSP();
                    SanPhamCT sp = svSP.timSP(idSP);
                    int soLuongTon = sp.getSoLuong();
                    int soLuong = listHDCT.get(i).getSoLuongMua();
                    int soLuongTong = soLuong + soLuongTon;
                    svSP.updateSanPhamCT(idSP, soLuongTong);
                    loadSanPham();
                    System.out.println("id SP" + idSP);
                }

                // update trang thái
                for (int i = 0; i < listKhachHang.size(); i++) {
                    if (listKhachHang.get(i).getTenKH().equals(tenKH)) {
                        int idKH = listKhachHang.get(i).getIdKH();
                        svHd.upDateHoaDon(new HoaDon(idKH, ngayTao, trangThai, maNV, maVoucher, idHD));
                    }
                }
                JOptionPane.showMessageDialog(this, "Hủy hóa đơn " + maHD + " thành công");
                loadHoaDon();
                defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
                defaultTableModel.setRowCount(0);
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn hóa đơn");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        // TODO add your handling code here:
        String sdt = txtSDT.getText();
        List<KhachHang> listKhachHang = svKH.getKhachHang();
        for (int i = 0; i < listKhachHang.size(); i++) {

            if (listKhachHang.get(i).getSdt().equals(sdt)) {
                lblTenKH.setText(listKhachHang.get(i).getTenKH());
            }
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            HoaDon hd = svHd.getRowHD(row);
            int maHD = hd.getMaHD();
            int idHD = hd.getIdHD();
            int idKH = hd.getIdKH();
            String maNV = TaiKhoanService.layThongTin_maNV();
            String ngayTao = thoiGian.toString();
            String trangThai = "Đã thanh toán ";
//            String tenKH = hd.getTenKH();
            double tienCanTra = Double.parseDouble(lblCanTra.getText());
            double tienKhachDua = Double.parseDouble(lblCanTra.getText());

            String maVoucher = null;
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh hóa đơn: " + maHD + " không?", "Thanh toán hóa đơn", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                svHd.upDateHoaDon(new HoaDon(idKH, ngayTao, trangThai, maNV, maVoucher, idHD));
                JOptionPane.showMessageDialog(this, "Thanh toán hóa đơn " + maHD + " thành công");
                loadHoaDon();
                defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
                defaultTableModel.setRowCount(0);
            } else {
            }
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnDoiSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiSLActionPerformed
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        if (row >= 0) {
            HoaDonCT hdct = svHDCT.getRowHDCT(row);
            int soLuongMua = hdct.getSoLuongMua();
            int soLuongDoi;
            int idHDCT = hdct.getIdHoaDonCT();
            int idHD = hdct.getIdHD();
            int idSP = hdct.getIdSP();
            double giaSP = hdct.getGiaBan();
            double thanhTien;
            int phanTramKM = hdct.phanTramKM();
            double phanTramDouble = Double.valueOf(phanTramKM);
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn đổi số lượng không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            // Nếu người dùng chọn Yes
            if (option == JOptionPane.YES_OPTION) {
                String input = JOptionPane.showInputDialog(null, "Nhập số lượng cần đổi:", "Thay đổi sản phẩm trong giỏ hàng", HEIGHT);
                if (input != null && !input.isEmpty()) {

                    try {
                        soLuongDoi = Integer.parseInt(input);
                        if (soLuongDoi <= 0) {
                            do {
                                String input2 = JOptionPane.showInputDialog(null, "Số lượng không hợp lệ, mời nhập lại:", "Thay đổi sản phẩm trong giỏ hàng", HEIGHT);
                                soLuongDoi = Integer.parseInt(input2);
                            } while (soLuongDoi <= 0);
                        }
                        if (soLuongDoi <= soLuongMua) {
                            System.out.println("Số lượng đã nhập: " + soLuongDoi);
                            thanhTien = soLuongDoi * giaSP * (1 - phanTramDouble / 100);
                            svHDCT.gopSanPhamTonTai(idHDCT, soLuongDoi, thanhTien);
                            loadHoaDonCT(idHD);
                            for (SanPhamCT sanPhamCT : svSP.getAll()) {
                                if (sanPhamCT.getIdSP().equals(idSP)) {
                                    int soLuongTon = sanPhamCT.getSoLuong();
                                    int soLuongMoi = soLuongMua - soLuongDoi + soLuongTon;
                                    svSP.updateSanPhamCT(idSP, soLuongMoi);
                                }
                            }
                        } else if (soLuongDoi > soLuongMua) {
                            System.out.println("Số lượng đã nhập: " + soLuongDoi);
                            thanhTien = soLuongDoi * giaSP * (1 - phanTramDouble / 100);
                            svHDCT.gopSanPhamTonTai(idHDCT, soLuongDoi, thanhTien);
                            loadHoaDonCT(idHD);
                            for (SanPhamCT sanPhamCT : svSP.getAll()) {
                                if (sanPhamCT.getIdSP().equals(idSP)) {
                                    int soLuongTon = sanPhamCT.getSoLuong();
                                    int soLuongMoi = soLuongTon - (soLuongDoi - soLuongMua);
                                    svSP.updateSanPhamCT(idSP, soLuongMoi);
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Nhập số nguyên hợp lệ!");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập số lượng!");
                }
            } else {
            }
            double tongTienTra = 0;
            for (HoaDonCT hoaDonCT : svHDCT.getHoaDonCTAll(idHD)) {
                if (hoaDonCT.getIdHD() == idHD) {
                    tongTienTra += hoaDonCT.getTongTien();
                }
            }
//                            System.out.println(tongTienTra);
            String tien = String.valueOf(tongTienTra);

            lblTongTien.setText(tien);
            lblCanTra.setText(tien);
        }

        loadSanPham();

    }//GEN-LAST:event_btnDoiSLActionPerformed

    private void cboVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVoucherActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboVoucherActionPerformed

    private void txttienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienKhachDuaKeyReleased
        // TODO add your handling code here:
        double tienCanTra = Double.parseDouble(lblCanTra.getText());
        double tienKhachDua = Double.parseDouble(txttienKhachDua.getText());
        double tienThua = tienKhachDua - tienCanTra;
        lblTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txttienKhachDuaKeyReleased

    private void txttienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienKhachDuaKeyPressed
        // TODO add your handling code here:
//        double tienCanTra = Double.parseDouble(lblCanTra.getText());
//        double tienKhachDua = Double.parseDouble(lblCanTra.getText());
//        double tienThua =tienKhachDua-tienCanTra;
//        lblTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txttienKhachDuaKeyPressed

    private void lblBangVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBangVoucherMouseClicked
        // TODO add your handling code here:
        new VoucherDialog(null, true).setVisible(true);
    }//GEN-LAST:event_lblBangVoucherMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formInternalFrameOpened

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:


    }//GEN-LAST:event_formComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        qr.toggleCamera();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        System.out.println("Webcam is closed when u switch menu");
        qr.closeCamera();

    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiSL;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaSPGH;
    private javax.swing.JComboBox<String> cboVoucher;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblBangVoucher;
    private javax.swing.JLabel lblCanTra;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel panelQRCode;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txttienKhachDua;
    // End of variables declaration//GEN-END:variables

    private volatile boolean isCameraRunning = true; // Biến để kiểm soát việc chạy của camera

    public void stopCamera() {
        isCameraRunning = false; // Phương thức để dừng camera
    }
//    @Override
//    public void run() {
//        do {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                java.util.logging.Logger.getLogger(TrangBanHang.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            if (!isCameraRunning) {
//                break; // Nếu biến/cờ được đặt thành false, thoát khỏi vòng lặp
//            }
//
//            Result result = null;
//            BufferedImage image = null;
//
//            if (webcam.isOpen()) {
//                if ((image = webcam.getImage()) == null) {
//                    continue;
//                }
//            }
//
//            LuminanceSource source = new BufferedImageLuminanceSource(image);
//            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//
//            try {
//                result = new MultiFormatReader().decode(bitmap);
//            } catch (NotFoundException ex) {
//                java.util.logging.Logger.getLogger(TrangBanHang.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            if (result != null) {
//                System.out.println("Cha" + result.getText());
//            }
//        } while (true);
//    }
//
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r); // Sử dụng Thread thay vì gọi lại newThread(r)
//        t.setDaemon(true);
//        return t;
//    }

}
