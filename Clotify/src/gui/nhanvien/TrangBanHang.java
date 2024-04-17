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
import static Service.HoaDonImpl.diachi;
import static Service.HoaDonImpl.giaList;
import static Service.HoaDonImpl.sdt;
import static Service.HoaDonImpl.soluongList;
import static Service.HoaDonImpl.ten;
import static Service.HoaDonImpl.tenSPList;
import static Service.HoaDonImpl.tienHang;
import static Service.HoaDonImpl.tientra;
import static Service.HoaDonImpl.voucher;
import static Service.HoaDonImpl.ngayTaoHD;
import Service.KhachHangService;
import Service.SanPhamCTService;
import Service.TaiKhoanService;
import Service.VoucherService;

import gui.admin.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.SanPhamCT;
import model.Voucher;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.text.DecimalFormat;

/**
 *
 * @author ADMIN
 */
public class TrangBanHang extends javax.swing.JInternalFrame implements QRCodeListener {

    LocalDate thoiGian = LocalDate.now();
    DefaultTableModel defaultTableModel;
    SanPhamCTImpl svSP = new SanPhamCTService();
    HoaDonService svHd = new HoaDonImpl();
    HoaDonCTService svHDCT = new HoaDonCTImpl();
    KhachHangService svKH = new KhachHangService();
    VoucherService svVC = new VoucherService();
    QRScanner qrTest = new QRScanner();
    /**
     * Creates new form Trang0
     */
    private QRScanner qr = new QRScanner();

    public TrangBanHang() {
        initComponents();
        ui_custom.deleteTitle(this);
//        String trangThai = "Hoạt động";
        loadSanPham();
        loadHoaDon();
        loadVoucher();
        lblTenNV.setText(TaiKhoanService.layThongTin_tenNV());
        cboVoucher.setSelectedIndex(-1);
        initWebcam();
        qr.addQRCodeListener(this);
        new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadVoucher();
            }
        }).start();

    }

    void reSet() {
        lblTongTien.setText("");
        cboVoucher.setSelectedIndex(-1);
        lblCanTra.setText("");
        txttienKhachDua.setText("");
        lblTienThua.setText("");
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

    private static final long serialVersionUID = 1L;

    private void initWebcam() {
        System.out.println("Run camera");
        Thread loadQR = new Thread(() -> {

            // Thêm panel của QRScanner vào panelQRCode
            panelQRCode.add(qr.getWebcamPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 184, 184));
            revalidate();
            repaint();
        });
        loadQR.start();
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 70, 128), 1, true), "Tạo hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(20, 70, 128))); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Số ĐT");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tổng tiền");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Khách đưa");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Tiền thừa");

        btnThanhToan.setBackground(new java.awt.Color(51, 153, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHD.setBackground(new java.awt.Color(204, 235, 215));
        btnTaoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 235, 215));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(204, 0, 51));
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

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setText("Mã voucher");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setText("Tên NV");

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblTenNV.setText("Nguyễn Văn A");

        lblTongTien.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblTongTien.setText("0");

        lblCanTra.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblCanTra.setText("0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Cần trả");

        lblTienThua.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblTienThua.setText("0");

        lblBangVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBangVoucher.setForeground(new java.awt.Color(0, 0, 204));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(cboVoucher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBangVoucher))))
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
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
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBangVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelQRCode, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(panelQRCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
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
                JOptionPane.showMessageDialog(null, "Bạn xóa thành công");
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
            String maVC = (String) cboVoucher.getSelectedItem();
            System.out.println("ma KM" + maVC);
            if (maVC != null) {
                Voucher vC = svVC.timVC(maVC);
                double tienGiam = vC.getGiamTheoGia();
                double dkGiam = vC.getDkAD();
                System.out.println("dk giam" + dkGiam);
                if (tongTienTra >= dkGiam) {
                    double tienCanTra = tongTienTra - tienGiam;
                    lblCanTra.setText(String.valueOf(tienCanTra));
                    JOptionPane.showMessageDialog(null, "Áp dụng thành công");
                }

            }

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
                            String maVC = (String) cboVoucher.getSelectedItem();
                            System.out.println("ma KM" + maVC);
                            if (maVC != null) {
                                Voucher vC = svVC.timVC(maVC);
                                double tienGiam = vC.getGiamTheoGia();
                                double dkGiam = vC.getDkAD();
                                System.out.println("dk giam" + dkGiam);
                                if (tongTienTra >= dkGiam) {
                                    double tienCanTra = tongTienTra - tienGiam;
                                    lblCanTra.setText(String.valueOf(tienCanTra));
                                    JOptionPane.showMessageDialog(null, "Áp dụng thành công");
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
            txtSDT.setText("");
            lblTenKH.setText("");
            reSet();

        } else {
            for (KhachHang khachHang : svKH.getKhachHang()) {
                if (khachHang.getSdt().equals(sdt)) {
                    int idKH = khachHang.getIdKH();
                    svHd.addHoaDon(new HoaDon(idKH, ngayTao, trangThai, maNV));
                    txtSDT.setText("");
                    lblTenKH.setText("");
                    reSet();
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
            String trangThai = "Đã hủy";
            String maVoucher = null;

            double tienCanTra = Double.parseDouble(lblCanTra.getText());
            double tongTien = Double.parseDouble(lblTongTien.getText());
            if (tongTien != tienCanTra) {
                maVoucher = (String) cboVoucher.getSelectedItem();
            }
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
                svHd.upDateHoaDon(new HoaDon(trangThai, maNV, maVoucher, tienCanTra, idHD));
                txtSDT.setText("");
                lblTenKH.setText("");
                reSet();
                JOptionPane.showMessageDialog(null, "Hủy hóa đơn " + maHD + " thành công");
                loadHoaDon();
                defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
                defaultTableModel.setRowCount(0);
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mời bạn chọn hóa đơn");
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
            String maNV = TaiKhoanService.layThongTin_maNV();
            String trangThai = "Đã thanh toán ";
            double tongTien = Double.parseDouble(lblTongTien.getText());
            double tienCanTra = Double.parseDouble(lblCanTra.getText());
            double tienThua = Double.parseDouble(lblTienThua.getText());
            String maVoucher = null;
            if (tongTien != tienCanTra) {
                maVoucher = (String) cboVoucher.getSelectedItem();
            }

            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh hóa đơn: " + maHD + " không?", "Thanh toán hóa đơn", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                if (txttienKhachDua.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Chưa nhập tiền khách đưa");
                    return;
                }
                
                if (tienThua >= 0) {
                    khachTra = Double.valueOf(txttienKhachDua.getText());
                    traLai = Double.valueOf(lblTienThua.getText());
                    
                    svHd.upDateHoaDon(new HoaDon(trangThai, maNV, maVoucher, tienCanTra, idHD));
                    txtSDT.setText("");
                    lblTenKH.setText("");
                    reSet();

                    JOptionPane.showMessageDialog(null, "Thanh toán hóa đơn " + maHD + " thành công");
                    loadHoaDon();
                    int choise = JOptionPane.showConfirmDialog(null, "Bạn muốn thực hiện in hóa đơn không");
                    if (choise == JOptionPane.YES_OPTION) {
                        maInHD = maHD;
                        InHoaDon();
                    }
                    defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
                    defaultTableModel.setRowCount(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Tiền khách trả còn thiếu");
                }

            } else {
            }
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    public Integer maInHD;
    public double khachTra, traLai;

    void InHoaDon() {
        svHd.DataInHoaDon(maInHD);

        String filePath = "bill/" +maInHD+ ".pdf";

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Sử dụng font Consolas
            BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\consola.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 16);
            com.itextpdf.text.Font fonts = new com.itextpdf.text.Font(bf, 13);

            // Vẽ bố cục tùy chỉnh
            // Tiêu đề
            Paragraph title = new Paragraph("HÓA ĐƠN", font);
            title.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(title);

            Paragraph tenSHOP = new Paragraph("SHOP BÁN QUẦN ÁO CLOTIFY", font);
            tenSHOP.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(tenSHOP);
            Paragraph address = new Paragraph("Địa chỉ: Phúc Diễn, Bắc Từ Liêm, Hà Nội ", font);
            address.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(address);
            Paragraph SDT = new Paragraph("SĐT : 0358168699", fonts);
            SDT.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(SDT);
            
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("Mã hóa đơn     : " +"#"+1234566 +  String.format("%45s", "Ngày tạo : " +ngayTaoHD) , fonts));
            document.add(new Paragraph("Tên khách hàng : " +ten , fonts));
            document.add(new Paragraph("Số điện thoại  : " +sdt + String.format("%43s", "Địa chỉ  : " +diachi), fonts));
            document.add(new Paragraph("                                                           "));
            

            document.add(new Paragraph("-----------------------------------------------------------", font));
            // Tiêu đề cột
            Paragraph columnTitle = new Paragraph("Sản phẩm           SL         Giá bán        Thành tiền", font);
            columnTitle.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(columnTitle);
            document.add(new Paragraph("-----------------------------------------------------------", font));

            DecimalFormat formatter = new DecimalFormat("###,###.###");
            // Duyệt qua danh sách tên sản phẩm và số lượng tương ứng và thêm chúng vào tài liệu PDF
            for (int i = 0; i < tenSPList.size(); i++) {
                String tenSP = tenSPList.get(i);
                int soLuong = soluongList.get(i);
                Double gia = giaList.get(i);
                document.add(new Paragraph(String.format("%-22s", tenSP) + String.format("%-10s", soLuong) + formatter.format(gia) + String.format("%18s", formatter.format(gia * soLuong)), font));
            }
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("-----------------------------------------------------------", font));

            // Tổng cộng
            Paragraph TongTien = new Paragraph("Tổng tiền      :" + String.format("%41s", formatter.format(tienHang)), font);
            Paragraph Voucher = new Paragraph ("Giảm giá       :" + String.format("%41s", "-" + formatter.format(voucher)), font);
            Paragraph Total = new Paragraph("Tiền phải trả  :" + String.format("%41s", formatter.format(tientra)), font);
            document.add(TongTien);
            document.add(Voucher);
            document.add(Total);
            document.add(new Paragraph("                                                           "));
            Paragraph KhachTra = new Paragraph("Khách trả      :" + String.format("%41s", formatter.format(khachTra)), font);
            Paragraph TienThua = new Paragraph("Trả lại        :" + String.format("%41s", formatter.format(traLai)), font);
            document.add(KhachTra);
            document.add(TienThua);
            

            // Dòng cuối cùng
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            
            
            document.add(new Paragraph("**********************************************************", font));
            Paragraph thanks = new Paragraph("Cảm ơn quý khách đã tin dùng sản phẩm Clotify", fonts);
            thanks.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(thanks);
            Paragraph nhom = new Paragraph("Phát triển bởi nhóm 5", fonts);
            nhom.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(nhom);
            document.add(new Paragraph("**********************************************************", font));
            
            
            Paragraph luuy = new Paragraph("Lưu ý : Quý khách có thể đổi trả hàng trong 7 ngày nếu sản phẩm bị lỗi", fonts);
            luuy.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(luuy);

            document.close();

            System.out.println("In xong");
            System.out.println("In xong");

            JOptionPane.showMessageDialog(null, "Hóa đơn được tạo thành công: " + filePath);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy tệp: " + e.getMessage());
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi tạo PDF: " + e.getMessage());
        }
    }
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
            String maVC = (String) cboVoucher.getSelectedItem();
            System.out.println("ma KM" + maVC);
            if (maVC != null) {
                Voucher vC = svVC.timVC(maVC);
                double tienGiam = vC.getGiamTheoGia();
                double dkGiam = vC.getDkAD();
                System.out.println("dk giam" + dkGiam);
                if (tongTienTra >= dkGiam) {
                    double tienCanTra = tongTienTra - tienGiam;
                    lblCanTra.setText(String.valueOf(tienCanTra));
                    JOptionPane.showMessageDialog(null, "Áp dụng thành công");
                }

            }
        }

        loadSanPham();

    }//GEN-LAST:event_btnDoiSLActionPerformed

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

    private void cboVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVoucherActionPerformed
        // TODO add your handling code here:
        String maVC = (String) cboVoucher.getSelectedItem();
        System.out.println("ma KM" + maVC);
        if (maVC != null) {
            Voucher vC = svVC.timVC(maVC);
            double tienGiam = vC.getGiamTheoGia();
            double dkGiam = vC.getDkAD();
            System.out.println("dk giam" + dkGiam);
            double tongTien = Double.parseDouble(lblTongTien.getText());
            if (tongTien >= dkGiam) {
                double tienCanTra = tongTien - tienGiam;
                lblCanTra.setText(String.valueOf(tienCanTra));
                JOptionPane.showMessageDialog(null, "Áp dụng thành công");
            } else {
                lblCanTra.setText(String.valueOf(tongTien));
            }

        }


    }//GEN-LAST:event_cboVoucherActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        qr.closeCamera();

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiSL;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaSPGH;
    private javax.swing.JComboBox<String> cboVoucher;
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

    @Override
    public void onQRCodeScanned(String qrCode) {

        int idSP = Integer.parseInt(qrCode);
        SanPhamCT sp = svSP.timSP(idSP);
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon >= 0) {
//            int rowSanPham = tblSP.getSelectedRow();
//            SanPhamCT sp = svSP.getRow(rowSanPham);
            int soLuongTonTai = sp.getSoLuong();
//            int idSP = sp.getIdSP();
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
                        String maVC = (String) cboVoucher.getSelectedItem();
                        System.out.println("ma KM" + maVC);
                        if (maVC != null) {
                            Voucher vC = svVC.timVC(maVC);
                            double tienGiam = vC.getGiamTheoGia();
                            double dkGiam = vC.getDkAD();
                            System.out.println("dk giam" + dkGiam);
                            if (tongTienTra >= dkGiam) {
                                double tienCanTra = tongTienTra - tienGiam;
                                lblCanTra.setText(String.valueOf(tienCanTra));
                                JOptionPane.showMessageDialog(null, "Áp dụng thành công");
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

        } else {
            JOptionPane.showMessageDialog(null, "Chọn hoá đơn");
        }
        loadSanPham();

    }
}
