/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

import Interface.SanPhamKMInterface;
import Service.KhuyenMaiService;
import Service.SanPhamCTService;
import Service.SanPhamKMService;
import Service.VoucherService;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import model.SanPhamCT;
import model.SanPhamKM;
import model.Voucher;

/**
 *
 * @author ADMIN
 */
public class TrangKhuyenMai extends javax.swing.JInternalFrame {

    /**
     * Creates new form Trang0
     */
    DefaultTableModel model;
    SanPhamKMInterface svSPKM = new SanPhamKMService();
    SanPhamCTService svCT = new SanPhamCTService();
    KhuyenMaiService svKM = new KhuyenMaiService();
    VoucherService svVC = new VoucherService();

    public TrangKhuyenMai() {

        initComponents();
        ui_custom.deleteTitle(this);
        svVC.updateTrangThaiVoucher();
        loadDataKhuyenMai();
        loadDataSPCT();
        loadDataVoucher();

    }

    void loadDataKhuyenMai() {
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        for (SanPhamKM spkm : svSPKM.getSanPhamKM()) {
            model.addRow(new Object[]{
                spkm.getMaKM(),
                spkm.getTenKM(),
                spkm.getNgayTao(),
                spkm.getNgayKetThuc(),
                spkm.getLoaiSP(),
                spkm.getGiamTheoPT(),
                spkm.getTrangThai()
            });
        }
    }

    void loadDataSPCT() {
        model = (DefaultTableModel) tblSPCT.getModel();
        model.setRowCount(0);
        for (SanPhamCT spct : svCT.getAll()) {
            model.addRow(new Object[]{
                spct.getIdSP(),
                spct.getMaSP(),
                spct.getTenSP(),
                spct.getTenSize(),
                spct.getTenMS(),
                spct.getTenCL(),
                spct.getGiaBan(),});
        }
    }

    void loadDataVoucher() {
        model = (DefaultTableModel) tblVoucher.getModel();
        model.setRowCount(0);
        for (Voucher voucher : svVC.getVoucher()) {
            model.addRow(new Object[]{
                voucher.getMaVC(),
                voucher.getTenVC(),
                voucher.getDkAD(),
                voucher.getGiamTheoGia(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.getTrangThai()

            });
        }
    }

    Voucher getFormVoucher() {
        Voucher voucher = new Voucher();
        voucher.setMaVC(txtMaVoucher.getText());
        voucher.setTenVC(txtTenVoucher.getText());
        voucher.setDkAD(Double.parseDouble(txtDieuKien.getText()));
        voucher.setGiamTheoGia(Double.parseDouble(txtGiamTheoGia.getText()));
//        LocalDateTime ngayTao = LocalDateTime.now();
//        LocalDateTime ngayKetThuc = LocalDateTime.now();
//        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String ngayBatDauVoucher = ngayTao.format(dinhDang);
//        String ngayKetThucVoucher = ngayKetThuc.format(dinhDang);
//        voucher.setNgayBatDau(ngayBatDauVoucher);
//        voucher.setNgayKetThuc(ngayKetThucVoucher);

//========================================================================
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // Lấy ngày bắt đầu từ JDateChooser và chuyển đổi sang chuỗi
        String ngayBatDau = dateFormat.format(txtNgayBatDauVoucher.getDate());
        // Lấy ngày kết thúc từ JDateChooser và chuyển đổi sang chuỗi
        String ngayKetThuc = dateFormat.format(txtNgayKetThucVoucher.getDate());
        // Sử dụng chuỗi này để thiết lập các trường trong đối tượng voucher
        voucher.setNgayBatDau(ngayBatDau);
        voucher.setNgayKetThuc(ngayKetThuc);
//=========================================================================

        String trangThai = "";
        if (rdHoatDongVoucher.isSelected()) {
            trangThai = "Hoạt động";
        } else {
            trangThai = "Ngừng hoạt động";
        }
        voucher.setTrangThai(trangThai);
        return voucher;
    }

    void setFormVoucher(Voucher voucher) {
        txtMaVoucher.setText(voucher.getMaVC());
        txtTenVoucher.setText(voucher.getTenVC());
        txtDieuKien.setText(String.valueOf(voucher.getDkAD()));
        txtGiamTheoGia.setText(String.valueOf(voucher.getGiamTheoGia()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // or your desired date format
        try {
            Date ngayBatDauVoucher = sdf.parse(voucher.getNgayBatDau());
            Date ngayKetThucVoucher = sdf.parse(voucher.getNgayKetThuc());

            // Set the Date objects to date pickers
            txtNgayBatDauVoucher.setDate(ngayBatDauVoucher);
            txtNgayKetThucVoucher.setDate(ngayKetThucVoucher);
          
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (voucher.getTrangThai().equals("Hoạt động")) {
            rdHoatDongVoucher.setSelected(true);
        } else {
            rdNgungHoatDongVoucher.setSelected(true);
        }

    }

    KhuyenMai getForm() {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(txtMaKM.getText());
        km.setTenKM(txtTenKM.getText());
//    km.setNgayTao(txtNgayBatDau.getDate());
//    km.setNgayKetThuc(txtNgayKetThuc.getDate());
//        Date ngayTao = txtNgayBatDau.getDate();
//        Date ngayKetThuc = txtNgayKetThuc.getDate();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String ngayKetThucString = dateFormat.format(ngayKetThuc);
//        String ngayKetTaoString = dateFormat.format(ngayTao);
        LocalDateTime ngayTao = LocalDateTime.now();
        LocalDateTime ngayKetThuc = LocalDateTime.now();
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String thoiGian2 = ngayTao.format(dinhDang);
        String thoiGian3 = ngayKetThuc.format(dinhDang);
        km.setNgayTao(thoiGian2);
        km.setNgayKetThuc(thoiGian3);
        km.setLoaiSP(cboLoaiSP.getSelectedItem().toString());
        km.setGiamTheoPT(Integer.parseInt(txtMucGiam.getText()));
        String trangThai = "Đang áp dụng";
        km.setTrangThai(trangThai);
//        List<String> danhSachIdSanPhamDaChon = new ArrayList<>();
//    for (JCheckBox checkbox :  ) {
//        if (checkbox.isSelected()) {
//            danhSachIdSanPhamDaChon.add(checkbox.getText()); // Giả sử text của checkbox chứa mã sản phẩm
//        }
//    }
//    km.setDanhSachIdSP(danhSachIdSanPhamDaChon);
        return km;

    }

    void setForm(SanPhamKM km) {
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());

        // Convert String date to Date object
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // or your desired date format
        try {
            Date ngayBatDau = sdf.parse(km.getNgayTao());
            Date ngayKetThuc = sdf.parse(km.getNgayKetThuc());

            // Set the Date objects to date pickers
            txtNgayBatDau.setDate(ngayBatDau);
            txtNgayKetThuc.setDate(ngayKetThuc);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        txtMucGiam.setText(String.valueOf(km.getGiamTheoPT()));
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        KhuyenMai = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtTenKM = new javax.swing.JTextField();
        txtMucGiam = new javax.swing.JTextField();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtMaKM = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        txtGiaBatDau = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGiaKetThuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdNgungHoatDong = new javax.swing.JRadioButton();
        rdHoatDong = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaVoucher = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenVoucher = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiamTheoGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdHoatDongVoucher = new javax.swing.JRadioButton();
        rdNgungHoatDongVoucher = new javax.swing.JRadioButton();
        txtNgayBatDauVoucher = new com.toedter.calendar.JDateChooser();
        txtNgayKetThucVoucher = new com.toedter.calendar.JDateChooser();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        txtTimKiemVoucher = new javax.swing.JTextField();

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

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1140, 700));

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Size", "Màu sắc", "Chất liệu", "Đơn giá", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSPCT.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(tblSPCT);
        if (tblSPCT.getColumnModel().getColumnCount() > 0) {
            tblSPCT.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblSPCT.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Ngày BĐ", "Ngày KT", "Loại SP", "Giảm giá", "Trạng thái"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblKhuyenMai);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khuyến mãi"));

        jLabel22.setText("Tên KM");

        jLabel23.setText("Giảm %");

        jLabel24.setText("TG bắt đầu");

        jLabel25.setText("TG kết thúc");

        btnNew.setText("New");

        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        txtNgayBatDau.setDateFormatString("yyyy-MM-dd HH:mm");

        txtNgayKetThuc.setDateFormatString("yyyy-MM-dd HH:mm");

        jLabel27.setText("Mã KM");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(36, 36, 36)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnNew)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo ", "Quần", "Váy", "Chân váy", "Tất cả sản phẩm" }));
        cboLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiSPItemStateChanged(evt);
            }
        });
        cboLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLoaiSPMouseClicked(evt);
            }
        });
        cboLoaiSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboLoaiSPKeyReleased(evt);
            }
        });

        jLabel1.setText("Từ");

        jLabel2.setText("Đến");

        txtGiaKetThuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaKetThucKeyReleased(evt);
            }
        });

        jLabel3.setText("Loại sản phẩm");

        rdNgungHoatDong.setText("Ngưng hoạt động");
        rdNgungHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdNgungHoatDongMouseClicked(evt);
            }
        });

        rdHoatDong.setText("Hoạt động");

        jLabel26.setText("Trạng thái");

        javax.swing.GroupLayout KhuyenMaiLayout = new javax.swing.GroupLayout(KhuyenMai);
        KhuyenMai.setLayout(KhuyenMaiLayout);
        KhuyenMaiLayout.setHorizontalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhuyenMaiLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel26)
                        .addGap(32, 32, 32)
                        .addComponent(rdNgungHoatDong)
                        .addGap(33, 33, 33)
                        .addComponent(rdHoatDong)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(KhuyenMaiLayout.createSequentialGroup()
                        .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(KhuyenMaiLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(173, 173, 173)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtGiaBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGiaKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))))
        );
        KhuyenMaiLayout.setVerticalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhuyenMaiLayout.createSequentialGroup()
                        .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txtGiaKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhuyenMaiLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNgungHoatDong)
                    .addComponent(rdHoatDong)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jTabbedPane1.addTab("Khuyến mãi", KhuyenMai);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setText("Mã voucher:");

        jLabel5.setText("Tên voucher:");

        jLabel6.setText("Điều kiện áp dụng:");

        jLabel7.setText("Giảm giá:");

        jLabel8.setText("Ngày bắt đầu:");

        jLabel9.setText("Ngày kết thúc:");

        jLabel10.setText("Trạng thái:");

        buttonGroup1.add(rdHoatDongVoucher);
        rdHoatDongVoucher.setText("Hoạt động");

        buttonGroup1.add(rdNgungHoatDongVoucher);
        rdNgungHoatDongVoucher.setText("Ngưng hoạt động");

        txtNgayBatDauVoucher.setDateFormatString("yyyy-MM-dd HH:mm");

        txtNgayKetThucVoucher.setDateFormatString("yyyy-MM-dd HH:mm");

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDieuKien)
                            .addComponent(txtMaVoucher)
                            .addComponent(txtTenVoucher)
                            .addComponent(txtGiamTheoGia)
                            .addComponent(txtNgayBatDauVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(txtNgayKetThucVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdHoatDongVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNgungHoatDongVoucher))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnLuu)
                                .addGap(69, 69, 69)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiamTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBatDauVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKetThucVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdHoatDongVoucher)
                    .addComponent(rdNgungHoatDongVoucher))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã voucher", "Tên Voucher", "Điều kiện áp dụng", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);

        txtTimKiemVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemVoucherMouseClicked(evt);
            }
        });
        txtTimKiemVoucher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemVoucherKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Voucher", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
//         int row = tblSPCT.getSelectedRow();
//         if(row>=0){
//             
//             SanPhamCT spct = svCT.getRow(row);
//             int idSP = spct.getIdSP();
//             String maKM = txtMaKM.getText();
////             for (KhuyenMai khuyenMai : svKM.getKhuyenMai()) {
////                 if (!khuyenMai.getMaKM().equals(maKM)) {
////                     
////                 
////                     svKM.addKhuyenMai(getForm());
////                 
////             }
////             }
//             
//            int count =svKM.searchKhuyeMaiTheoMa(maKM).size();
//             if (count ==0) {
//                 svKM.addKhuyenMai(getForm());
//             }
//             svSPKM.addSPKM(new SanPhamKM(idSP, maKM));
//             loadDataKhuyenMai();
//         }

//        String maKM = txtMaKM.getText();
//        List<SanPhamKM> danhSachSPKM = new ArrayList<>();
//       
////        int[] selectedRows = tblSPCT.getSelectedRows(); // Lấy các dòng được chọn
//   
//        
//        for (int row = 0; row < tblSPCT.getRowCount(); row++) {
//
//            if (tblSPCT.getModel().getValueAt(row, 7) != null) {
//                Boolean trangThai = (Boolean) tblSPCT.getModel().getValueAt(row, 7);
//                if (trangThai) {
//                    SanPhamCT spct = svCT.getRow(row);
//                    int idSP = spct.getIdSP();
//                    danhSachSPKM.add(new SanPhamKM(idSP, maKM));
//                }
//            }
//
//        }
//        
//
//// Kiểm tra nếu danh sách sản phẩm khuyến mãi không trống
//        if (!danhSachSPKM.isEmpty()) {
//            int count = svKM.searchKhuyeMaiTheoMa(maKM).size();
//            if (count == 0) {
//                svKM.addKhuyenMai(getForm());
//            }
//
//            for (SanPhamKM spkm : danhSachSPKM) {
//                svSPKM.addSPKM(spkm);
//            }
//
//            loadDataKhuyenMai();
//        } else {
//            // Xử lý khi không có sản phẩm nào được chọn
//            System.out.println("Vui lòng chọn ít nhất một sản phẩm để thêm vào khuyến mãi!");
//        }
//      
        StringBuilder dinhDangThongBao = new StringBuilder();
        String maKM = txtMaKM.getText();
        List<SanPhamKM> danhSachSPKM = new ArrayList<>();

        for (int row = 0; row < tblSPCT.getRowCount(); row++) {
            if (tblSPCT.getModel().getValueAt(row, 7) != null) {
                Boolean trangThai = (Boolean) tblSPCT.getModel().getValueAt(row, 7);
                if (trangThai) {
                    SanPhamCT spct = svCT.getRow(row);
                    int idSP = spct.getIdSP();

                    // Kiểm tra xem sản phẩm đã tồn tại trong danh sách chưa
                    boolean daTonTai = false;
                    for (SanPhamKM sanPhamKM : svSPKM.searchIDSP(idSP)) {
                        if (sanPhamKM.getIdSP() == idSP) {
                            daTonTai = true;
                            dinhDangThongBao.append(spct.getIdSP()).append(",");

                        }

                    }
                    if (daTonTai) {
                        // Kiểm tra nếu có sản phẩm trùng
                        String thongBao = "Sản phẩm  đã tồn tại trong danh sách khuyến mãi: " + dinhDangThongBao.toString();
                        JOptionPane.showMessageDialog(this, thongBao);
                        return;
                    }

                    if (!daTonTai) {
                        danhSachSPKM.add(new SanPhamKM(idSP, maKM));
                    }
                }
            }
        }

// Kiểm tra nếu danh sách sản phẩm khuyến mãi không trống
        if (!danhSachSPKM.isEmpty()) {
            int count = svKM.searchKhuyeMaiTheoMa(maKM).size();
            if (count == 0) {
                svKM.addKhuyenMai(getForm());
            }

            for (SanPhamKM spkm : danhSachSPKM) {
                svSPKM.addSPKM(spkm);
            }

            loadDataKhuyenMai();
        } else {
            // Xử lý khi không có sản phẩm nào được chọn
            System.out.println("Vui lòng chọn ít nhất một sản phẩm để thêm vào khuyến mãi!");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
        int i = tblKhuyenMai.getSelectedRow();
        if (i >= 0) {
            setForm(svSPKM.getRow(i));
            loadDataKhuyenMai();
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void cboLoaiSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboLoaiSPKeyReleased
        // TODO add your handling code here:
//        String key = cboLoaiSP.getSelectedItem().toString();
//        DefaultTableModel modelLoaiSP = (DefaultTableModel) tblSPCT.getModel();
//        modelLoaiSP.setRowCount(0);
//        for (SanPhamCT spct : kms.searchTheoLoaiSP(key)) {
//            
//        }
    }//GEN-LAST:event_cboLoaiSPKeyReleased

    private void cboLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLoaiSPMouseClicked
        // TODO add your handling code here:
//        String key = cboLoaiSP.getSelectedItem().toString();
//        DefaultTableModel modelLoaiSP = (DefaultTableModel) tblSPCT.getModel();
//        modelLoaiSP.setRowCount(0);
//        for (SanPhamCT spct : svKM.searchTheoLoaiSP(key) ) {
//            modelLoaiSP.addRow(new Object[]{
//                spct.getIdSP(),
//                spct.getMaSP(),
//                spct.getTenSP(),
//                spct.getSize(),
//                spct.getMauSac(),
//                spct.getChatLieu(),
//                spct.getGiaBan()
//            });
//        }
    }//GEN-LAST:event_cboLoaiSPMouseClicked

    private void cboLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiSPItemStateChanged
        // TODO add your handling code here:
        String key = cboLoaiSP.getSelectedItem().toString();
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {

            DefaultTableModel modelLoaiSP = (DefaultTableModel) tblSPCT.getModel();
            modelLoaiSP.setRowCount(0);
            try {
                for (SanPhamCT spct : svKM.searchTheoLoaiSP(key)) {
                    modelLoaiSP.addRow(new Object[]{
                        spct.getIdSP(),
                        spct.getMaSP(),
                        spct.getTenSP(),
                        spct.getTenSize(),
                        spct.getTenMS(),
                        spct.getTenCL(),
                        spct.getGiaBan()
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Xử lý ngoại lệ một cách thích hợp, có thể hiển thị một thông báo lỗi cho người dùng
            }

        }
        if (key.equals("Tất cả sản phẩm")) {
            loadDataSPCT();
        }
    }//GEN-LAST:event_cboLoaiSPItemStateChanged

    private void txtGiaKetThucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKetThucKeyReleased
        // TODO add your handling code here:
        try {
            Double giaBatDau = Double.parseDouble(txtGiaBatDau.getText());
            Double giaKetThuc = Double.parseDouble(txtGiaKetThuc.getText());

            // Tiếp tục xử lý chỉ khi chuyển đổi thành công
            DefaultTableModel modelTimTheoGia = (DefaultTableModel) tblSPCT.getModel();
            modelTimTheoGia.setRowCount(0);
            for (SanPhamCT spct : svKM.searchTheoKhoangGia(giaBatDau, giaKetThuc)) {
                modelTimTheoGia.addRow(new Object[]{
                    spct.getIdSP(),
                    spct.getMaSP(),
                    spct.getTenSP(),
                    spct.getTenSize(),
                    spct.getTenMS(),
                    spct.getTenCL(),
                    spct.getGiaBan()
                });
            }
        } catch (NumberFormatException e) {
            // Xử lý trường hợp nhập liệu không hợp lệ ở đây...
            // Ví dụ: Hiển thị thông báo lỗi, yêu cầu nhập lại giá trị hợp lệ.
            JOptionPane.showMessageDialog(this, "Giá bắt đầu hoặc giá kết thúc không hợp lệ. Vui lòng nhập lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtGiaKetThucKeyReleased

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        int row = tblKhuyenMai.getSelectedRow();
        if (row >= 0) {
            String maKM = svKM.getRow(row).getMaKM();
            KhuyenMai km = getForm();
            km.setMaKM(maKM);
            svKM.updateKhuyenMai(km);
            loadDataKhuyenMai();
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void rdNgungHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdNgungHoatDongMouseClicked
        // TODO add your handling code here:

        int i = tblKhuyenMai.getSelectedRow();
        if (i != -1 && rdNgungHoatDong.isSelected()) {
            model = (DefaultTableModel) tblKhuyenMai.getModel();

            model.setValueAt("Hết khuyến mại", i, 6);
            String maKM = (String) model.getValueAt(i, 0);
            svKM.updateTrangThai(maKM, "Hết khuyến mại");
        }
    }//GEN-LAST:event_rdNgungHoatDongMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        svVC.addVoucher(getFormVoucher());
        loadDataVoucher();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        int i = tblVoucher.getSelectedRow();
        if (i >= 0) {
            String maVC = svVC.getRow(i).getMaVC();
            Voucher voucher = getFormVoucher();
            voucher.setMaVC(maVC);
            svVC.updateVoucher(voucher);
            loadDataVoucher();
        }
    }//GEN-LAST:event_btnLuuMouseClicked

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        // TODO add your handling code here:
        int i = tblVoucher.getSelectedRow();
        if (i >= 0) {
            setFormVoucher(svVC.getRow(i));
        }
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void txtTimKiemVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemVoucherMouseClicked
        // TODO add your handling code here:
//        String key = txtTimKiemVoucher.getText();
//        DefaultTableModel modelTimKiemVoucher = (DefaultTableModel) tblVoucher.getModel();
//        modelTimKiemVoucher.setRowCount(0);
//        for (Voucher voucher : svVC.searchVoucher(key) ) {
//            modelTimKiemVoucher.addRow(new Object[]{
//                  voucher.getMaVC(),
//                voucher.getTenVC(),
//                voucher.getDkAD(),
//                voucher.getGiamTheoGia(),
//                voucher.getNgayBatDau(),
//                voucher.getNgayKetThuc(),
//                voucher.getTrangThai()
//            });
//        }
    }//GEN-LAST:event_txtTimKiemVoucherMouseClicked

    private void txtTimKiemVoucherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemVoucherKeyReleased
        // TODO add your handling code here:
        String key = txtTimKiemVoucher.getText();
        DefaultTableModel modelTimKiemVoucher = (DefaultTableModel) tblVoucher.getModel();
        modelTimKiemVoucher.setRowCount(0);
        for (Voucher voucher : svVC.searchVoucher(key)) {
            modelTimKiemVoucher.addRow(new Object[]{
                voucher.getMaVC(),
                voucher.getTenVC(),
                voucher.getDkAD(),
                voucher.getGiamTheoGia(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.getTrangThai()
            });
        }
    }//GEN-LAST:event_txtTimKiemVoucherKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KhuyenMai;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdHoatDongVoucher;
    private javax.swing.JRadioButton rdNgungHoatDong;
    private javax.swing.JRadioButton rdNgungHoatDongVoucher;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtGiaBatDau;
    private javax.swing.JTextField txtGiaKetThuc;
    private javax.swing.JTextField txtGiamTheoGia;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaVoucher;
    private javax.swing.JTextField txtMucGiam;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayBatDauVoucher;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private com.toedter.calendar.JDateChooser txtNgayKetThucVoucher;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTenVoucher;
    private javax.swing.JTextField txtTimKiemVoucher;
    // End of variables declaration//GEN-END:variables
}
