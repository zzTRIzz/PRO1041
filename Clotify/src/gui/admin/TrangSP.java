/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

import Interface.LichSuGiaService;
import Interface.SanPhamCTImpl;

import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.MauSac;
import model.SanPham;
import model.SanPhamCT;
import model.Size;
import model.ThuongHieu;
import Service.ThuocTinhService;
import Service.SanPhamCTService;
import Interface.SanPhamService;
import Interface.ThuocTinhImpl;
import Service.LichSuGiaImpl;
import Service.SanPhamImpl;
import Service.TaiKhoanService;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.LichSuGia;

/**
 *
 * @author ADMIN
 */
public class TrangSP extends javax.swing.JInternalFrame {

    /**
     * Creates new form Trang0
     */
    DefaultTableModel model;
    DefaultTableModel modeltt;
    SanPhamCTImpl svSPCT = new SanPhamCTService();
    ThuocTinhImpl svTT = new ThuocTinhService();
    SanPhamService svSP = new SanPhamImpl();
    LichSuGiaService lsg = new LichSuGiaImpl();

    String thoiGian;
    String strHinhAnh = null;

    public TrangSP() {
        initComponents();
        ui_custom.deleteTitle(this);

        modeltt = (DefaultTableModel) tbThuocTinh.getModel();
//        String ngayNhap = thoiGian;
//        txtNgayNhap.setText(ngayNhap);
        loadDataSPCT();
        loadDataSP();
        LoadComBoCL();
        LoadComBoTH();
        LoadComBoSize();
        LoadComBoMS();
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String thoiGian2 = now.format(dinhDang);
                txtNgayNhap.setText(thoiGian);
                thoiGian = thoiGian2;
            }
        }).start();

    }

    void loadDataSP() {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sanPham : svSP.getSPAll()) {
            model.addRow(new Object[]{
                sanPham.getMaSP(),
                sanPham.getTenSP(),
                sanPham.getNgayNhap(),
                sanPham.getTenNV()
            });

        }
    }

    void LoadComBoMS() {
        cboMauSac.removeAllItems();

        for (MauSac allM : svTT.getAllMs()) {
            cboMauSac.addItem(allM.getTenMS());
        }
    }

    void LoadComBoCL() {
        cboChatLieu.removeAllItems();

        for (ChatLieu cl : svTT.getAllCl()) {
            cboChatLieu.addItem(cl.getTenCL());
        }
    }

    void LoadComBoSize() {
        cboSize.removeAllItems();

        for (Size size : svTT.getAllSize()) {
            cboSize.addItem(size.getTenSize());
        }
    }

    void LoadComBoTH() {
        cboTH.removeAllItems();

        for (ThuongHieu th : svTT.getAllTh()) {
            cboTH.addItem(th.getTenTH());
        }
    }

    void loadDataSPByMa(String maSP) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sanPham : svSP.searchSanPham(maSP)) {
            model.addRow(new Object[]{
                sanPham.getMaSP(),
                sanPham.getTenSP(),
                sanPham.getNgayNhap(),
                sanPham.getTenNV()
            });

        }
    }

    void loadDataSPCT() {
        model = (DefaultTableModel) tblSPCT.getModel();
        model.setRowCount(0);
        for (SanPhamCT spct : svSPCT.getAll()) {
            Object[] row = new Object[]{
                spct.getIdSP(),
                //                spct.getMaSP(),
                spct.getLoaiSP(),
                spct.getTenMS(),
                spct.getTenSize(),
                spct.getTenTH(),
                spct.getTenCL(),
                spct.getSoLuong(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getHinhAnh(),
                spct.getTrangThai(),};
            model.addRow(row);
        }
    }

    void loadDataSPCTByMa(String maSP) {
        model = (DefaultTableModel) tblSPCT.getModel();
        model.setRowCount(0);
        for (SanPhamCT spct : svSPCT.searchSPCT(maSP)) {
            Object[] row = new Object[]{
                spct.getIdSP(),
                //                spct.getMaSP(),
                spct.getLoaiSP(),
                spct.getTenMS(),
                spct.getTenSize(),
                spct.getTenTH(),
                spct.getTenCL(),
                spct.getSoLuong(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getHinhAnh(),
                spct.getTrangThai()

            };
            model.addRow(row);
        }

    }

    void loadDataMS() {
        modeltt.setRowCount(0);
        for (MauSac ms : svTT.getAllMs()) {
            Object[] row = new Object[]{
                ms.getIdMS(),
                ms.getMaMS(),
                "Màu sắc",
                ms.getTenMS()
            };
            modeltt.addRow(row);
        }
    }

    void loadDataSize() {
        modeltt.setRowCount(0);
        for (Size size : svTT.getAllSize()) {
            Object[] row = new Object[]{
                size.getIdSize(),
                size.getMaSize(),
                "Size",
                size.getTenSize()
            };
            modeltt.addRow(row);
        }
    }

    void loadDataCL() {
        modeltt.setRowCount(0);
        for (ChatLieu cl : svTT.getAllCl()) {
            Object[] row = new Object[]{
                cl.getIdCL(),
                cl.getMaCL(),
                "Chất liệu",
                cl.getTenCL()
            };
            modeltt.addRow(row);
        }
    }

    void loadDataTH() {
        modeltt.setRowCount(0);
        for (ThuongHieu th : svTT.getAllTh()) {
            Object[] row = new Object[]{
                th.getIdTH(),
                th.getMaTH(),
                "Thương hiệu",
                th.getTenTH(),};
            modeltt.addRow(row);
        }
    }

    void reSet() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtLoai.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtSoLuong.setText("");
        cboChatLieu.setSelectedIndex(-1);
        cboMauSac.setSelectedIndex(-1);
        cboSize.setSelectedIndex(-1);
        cboTH.setSelectedIndex(-1);
        txtNgayNhap.setText(thoiGian);
    }

    SanPham getFormSP() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setNgayNhap(txtNgayNhap.getText());
        String maNV = "NV001";
        sp.setMaNV(maNV);
        return sp;
    }

    void setFormSP(SanPham sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtNgayNhap.setText(sp.getNgayNhap());
    }

    SanPhamCT getFormSPCT() {
        SanPhamCT spct = new SanPhamCT();
        spct.setMaSP(txtMaSP.getText());
        spct.setLoaiSP(txtLoai.getText());
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        spct.setGiaNhap(Double.parseDouble(txtGiaBan.getText()));
        String trangThai = "Hoạt động";
        spct.setTrangThai(trangThai);
        spct.setIdMauSac(cboMauSac.getSelectedIndex() + 1);

        spct.setIdSize(cboSize.getSelectedIndex() + 1);
        spct.setIdThuongHieu(cboTH.getSelectedIndex() + 1);
        spct.setIdChatLieu(cboChatLieu.getSelectedIndex() + 1);

        return spct;
    }

    void setFormSPCT(SanPhamCT spct) {

        txtMaSP.setText(spct.getMaSP());

        txtLoai.setText(spct.getLoaiSP());

        String thuongHieu = spct.getTenTH();
        cboTH.setSelectedItem(thuongHieu);

        String size = spct.getTenSize();
        cboSize.setSelectedItem(size);

        String chatLieu = spct.getTenCL();
        cboChatLieu.setSelectedItem(chatLieu);
        String mauSac = spct.getTenMS();
        cboMauSac.setSelectedItem(mauSac);
        txtGiaBan.setText(spct.getGiaBan().toString());
        txtGiaNhap.setText(spct.getGiaNhap().toString());
        txtSoLuong.setText(spct.getSoLuong().toString());
        if (spct.getHinhAnh().equalsIgnoreCase("No img")) {
            lblHinhAnh.setText("No img");
            lblHinhAnh.setIcon(null);
        } else {
//            lblHinhAnh.setText("");
//            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/" + spct.getHinhAnh()));
//            Image img = imgIcon.getImage();
//            img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), 0);
//            lblHinhAnh.setIcon(imgIcon);
            try {
                lblHinhAnh.setText("");
                // Tải hình ảnh
                BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("/img/" + spct.getHinhAnh()));

                // Thu nhỏ hình ảnh để phù hợp với kích thước của label
                Image scaledImage = originalImage.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);

                // Tạo ImageIcon từ hình ảnh đã thu nhỏ
                ImageIcon imgIcon = new ImageIcon(scaledImage);

                // Đặt ImageIcon vào label
                lblHinhAnh.setIcon(imgIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    MauSac getFormMs() {
        MauSac ms = new MauSac();
        ms.setTenMS(txtTenTT.getText());
        return ms;
    }

    ThuongHieu getFormTh() {
        ThuongHieu th = new ThuongHieu();
        th.setTenTH(txtTenTT.getText());
        return th;
    }

    ChatLieu getFormCl() {
        ChatLieu cl = new ChatLieu();
        cl.setTenCL(txtTenTT.getText());
        return cl;
    }

    Size getFormSize() {
        Size s = new Size();
        s.setTenSize(txtTenTT.getText());
        return s;
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
        jPanel1 = new javax.swing.JPanel();
        SanPham1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        btNew = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnAnSP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        btnSPAn = new javax.swing.JButton();
        btnLSG = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cboTH = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btSearch = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        lblHinhAnh = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTenTT = new javax.swing.JTextField();
        rdThuongHieu = new javax.swing.JRadioButton();
        rdMauSac = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdSize = new javax.swing.JRadioButton();
        btThemThuocTinh = new javax.swing.JButton();
        btAnTT = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThuocTinh = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setTitle("Trang 1");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(1140, 700));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setPreferredSize(new java.awt.Dimension(1140, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setMaximumSize(new java.awt.Dimension(1040, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1040, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 700));

        jPanel6.setBackground(new java.awt.Color(246, 246, 246));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("Mã sản phẩm");

        txtMaSP.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        txtTenSP.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Ngày nhập");

        txtNgayNhap.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        btNew.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btNew.setForeground(new java.awt.Color(20, 70, 128));
        btNew.setText("New   ");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(20, 70, 128));
        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btSave.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(20, 70, 128));
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btnAnSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnSP.setForeground(new java.awt.Color(20, 70, 128));
        btnAnSP.setText("Hide");
        btnAnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(txtTenSP)
                    .addComponent(txtNgayNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnSP)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Loại SP", "Màu sắc", "Size", "Thương hiệu", "Chất liệu", "Số lượng", "Giá nhập", "Giá bán", "Hình ảnh", "Trạng thái"
            }
        ));
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSPCT);

        btnSPAn.setText("Hiện sản phẩm ẩn");
        btnSPAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPAnActionPerformed(evt);
            }
        });

        btnLSG.setText("Lịch sử giá");
        btnLSG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLSGActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        cboTH.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Thương hiệu");

        cboSize.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Size");

        cboChatLieu.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboChatLieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboChatLieuItemStateChanged(evt);
            }
        });
        cboChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboChatLieuMouseClicked(evt);
            }
        });
        cboChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChatLieuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Chất liệu");

        cboMauSac.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Màu sắc");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Giá nhập");

        txtGiaNhap.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Giá bán");

        txtSoLuong.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Số lượng");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Loại");

        txtLoai.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboTH, 0, 124, Short.MAX_VALUE)))
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtGiaNhap)
                            .addComponent(txtGiaBan)
                            .addComponent(txtLoai, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 77, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Ngày nhập", "Tên NV"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        btSearch.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btSearch.setForeground(new java.awt.Color(20, 70, 128));
        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        lblHinhAnh.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblHinhAnh.setForeground(new java.awt.Color(20, 70, 128));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setText("Hình ảnh");
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addGap(146, 146, 146)
                                .addComponent(btnSPAn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLSG)
                                .addGap(21, 21, 21))
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLSG)
                            .addComponent(btnSPAn))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        SanPham1.addTab("Thông tin sản phẩm", jPanel6);

        jPanel7.setBackground(new java.awt.Color(246, 246, 246));

        jLabel16.setText("Tên thuộc tính");

        buttonGroup1.add(rdThuongHieu);
        rdThuongHieu.setText("Thương hiệu");
        rdThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdThuongHieuMouseClicked(evt);
            }
        });
        rdThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdThuongHieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdMauSac);
        rdMauSac.setText("Màu sắc");
        rdMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdMauSacMouseClicked(evt);
            }
        });
        rdMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdChatLieu);
        rdChatLieu.setText("Chất liệu");
        rdChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChatLieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdSize);
        rdSize.setText("Size");
        rdSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSizeActionPerformed(evt);
            }
        });

        btThemThuocTinh.setText("Thêm");
        btThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemThuocTinhActionPerformed(evt);
            }
        });

        btAnTT.setText("Ẩn");

        jPanel8.setBackground(new java.awt.Color(246, 246, 246));

        tbThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã thuộc tính", "Loại thuộc tính", "Tên thuộc tính"
            }
        ));
        jScrollPane2.setViewportView(tbThuocTinh);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btThemThuocTinh)
                        .addGap(18, 18, 18)
                        .addComponent(btAnTT))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(rdThuongHieu)
                        .addGap(51, 51, 51)
                        .addComponent(rdMauSac)
                        .addGap(49, 49, 49)
                        .addComponent(rdChatLieu)
                        .addGap(53, 53, 53)
                        .addComponent(rdSize)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdThuongHieu)
                    .addComponent(rdMauSac)
                    .addComponent(rdChatLieu)
                    .addComponent(rdSize))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemThuocTinh)
                    .addComponent(btAnTT))
                .addGap(51, 51, 51)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        SanPham1.addTab("Thuộc tính sản phẩm", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(SanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(SanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdThuongHieuActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        // TODO add your handling code here:
        int row = tblSPCT.getSelectedRow();
        if (row >= 0) {
            setFormSPCT(svSPCT.getRow(row));
        }
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void btThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemThuocTinhActionPerformed
        // TODO add your handling code here:

        if (txtTenTT.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính không trống");
            return;
        } else {
            if (rdMauSac.isSelected()) {
                svTT.addMauSac(getFormMs());
                loadDataMS();
            } else if (rdChatLieu.isSelected()) {
                svTT.addChatLieu(getFormCl());
//                cboChatLieu.addItem(ms);
                loadDataCL();
            } else if (rdSize.isSelected()) {
                svTT.addSize(getFormSize());
//                cboSize.addItem(ms);
                loadDataSize();
            } else if (rdThuongHieu.isSelected()) {
                svTT.addThuongHieu(getFormTh());
//                cboTH.addItem(ms);
                loadDataTH();
            }
        }
    }//GEN-LAST:event_btThemThuocTinhActionPerformed

    private void rdThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdThuongHieuMouseClicked
        // TODO add your handling code here:
        txtTenTT.setText("");
        loadDataTH();

    }//GEN-LAST:event_rdThuongHieuMouseClicked

    private void rdMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMauSacMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMauSacMouseClicked

    private void rdChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChatLieuActionPerformed
        // TODO add your handling code here:
        txtTenTT.setText("");
        loadDataCL();
    }//GEN-LAST:event_rdChatLieuActionPerformed

    private void rdSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSizeActionPerformed
        // TODO add your handling code here:
        txtTenTT.setText("");
        loadDataSize();
    }//GEN-LAST:event_rdSizeActionPerformed

    private void rdMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMauSacActionPerformed
        // TODO add your handling code here:
        txtTenTT.setText("");
        loadDataMS();
    }//GEN-LAST:event_rdMauSacActionPerformed

    private void cboChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboChatLieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChatLieuMouseClicked

    private void cboChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChatLieuActionPerformed
        // TODO add your handling code here:
//        int soTT = cboChatLieu.getSelectedIndex()+1;
//        System.out.println("so tt"+soTT);
    }//GEN-LAST:event_cboChatLieuActionPerformed

    private void cboChatLieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboChatLieuItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cboChatLieuItemStateChanged

    private void btnLSGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLSGActionPerformed
        // TODO add your handling code here:
        new LichSuGiaDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnLSGActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin");
            loadDataSP();

        } else {
            String maSP = txtTimKiem.getText();
            loadDataSPByMa(maSP);
            loadDataSPCTByMa(maSP);
        }

    }//GEN-LAST:event_btSearchActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        String ngayNhap = thoiGian;
        System.out.println(ngayNhap);
        String maNV = TaiKhoanService.maNV;
        int row = tblSanPham.getSelectedRow();
        // add SanPham
        int count = svSP.searchSanPham(maSP).size();
        if (count == 0) {
            svSP.addSanPham(new SanPham(maSP, tenSP, ngayNhap, maNV));
            loadDataSP();
            return;
        }
        String hinhAnh;
        if (strHinhAnh == null) {
            hinhAnh = "No img";

        } else {
            hinhAnh = strHinhAnh;
        }
        int idCL = cboChatLieu.getSelectedIndex() + 1;
        System.out.println(idCL);
        int idMS = cboMauSac.getSelectedIndex() + 1;
        System.out.println(idMS);
        int idTH = cboTH.getSelectedIndex() + 1;
        System.out.println(idTH);
        int idSize = cboSize.getSelectedIndex() + 1;
        System.out.println(idSize);
        String loaiSP = txtLoai.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        String trangThai = "Hoạt động";
        //         add SanPhamCT
        svSPCT.addSanPhamCT(new SanPhamCT(soLuong, idMS, idSize, idTH, idCL, maSP, loaiSP, trangThai, giaNhap, hinhAnh));
        loadDataSPCTByMa(maSP);
        double giaBan = Double.parseDouble(txtGiaBan.getText());
//        String ngayKetThuc = "NULL";
        List<SanPhamCT> listIdSP = svSPCT.searchID(maSP, loaiSP, idTH, idMS, idSize, idCL);
        int count2 = svSPCT.searchID(maSP, loaiSP, idTH, idMS, idSize, idCL).size();
        if (count2 == 1) {
            for (SanPhamCT sanPhamCT : listIdSP) {
                int idSP = sanPhamCT.getIdSP();
                System.out.println(idSP);
                lsg.addLSGia(new LichSuGia(idSP, giaBan, ngayNhap));

            }
        } else {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại");
        }

        loadDataSP();
        loadDataSPCTByMa(maSP);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        
        int rowSP = tblSanPham.getSelectedRow();
        int rowSPCT = tblSPCT.getSelectedRow();
        SanPhamCT spct = svSPCT.getRow(rowSPCT);
        int idSPCT = spct.getIdSP();
        String ma = spct.getMaSP();
        System.out.println("ma" + ma);
        int soLuongTon = spct.getSoLuong();
        System.out.println("so luong ton" + soLuongTon);
        int idLS = spct.getIdLS();

        String maSP = spct.getMaSP();
        String ngayUpdate = thoiGian;
//        String ngayKetThuc = "NULL";
        double giaBanCu = spct.getGiaBan();
        String hinhAnh;
        if (strHinhAnh == null) {
            hinhAnh = "No img";

        } else {
            hinhAnh = strHinhAnh;
        }
        if (rowSP >= 0 &&rowSPCT >= 0) {
            
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn update sản phẩm không?", "Update số lượng tồn và giá bán", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        int soLuong = Integer.parseInt(txtSoLuong.getText());
                        double giaBan = Double.parseDouble(txtGiaBan.getText());
                        System.out.println("so luong moi" + soLuong);
                        if (soLuong<=0) {
                            JOptionPane.showMessageDialog(this, "Số lượng > 0");
                            return;
                        }
                        if (giaBan<=0) {
                            JOptionPane.showMessageDialog(this, "Gia bán > 0");
                            return;
                        }                                              
                        if (giaBan != giaBanCu) {
                            lsg.upDateLSG(ngayUpdate, idLS);
                            loadDataSPCTByMa(maSP);                           
                            lsg.addLSGia(new LichSuGia(idSPCT, giaBan, ngayUpdate));
                            svSPCT.updateSanPhamCT2(idSPCT, soLuong,hinhAnh);
                            JOptionPane.showMessageDialog(this, "Update sản phẩm thành công");
                        }else{
                            System.out.println("id" + idSPCT);
                            
                            svSPCT.updateSanPhamCT2(idSPCT, soLuong,hinhAnh);

                            JOptionPane.showMessageDialog(this, "Update sản phẩm thành công");
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Dữ liệu nhập mới không hợp lệ");
                    }

                    loadDataSPCTByMa(maSP);
                }
            
        } else {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm trong bảng");
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tblSanPham.getSelectedRow();
        if (row >= 0) {
            setFormSP(svSP.getRow(row));
            SanPham sp = svSP.getRow(row);
            String maSP = sp.getMaSP();
            loadDataSPCTByMa(maSP);
        }
        System.out.println("vi tri" + row);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnSPAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPAnActionPerformed
        // TODO add your handling code here:
        new SanPhanAnDialog(null, true).setVisible(true);

    }//GEN-LAST:event_btnSPAnActionPerformed

    private void btnAnSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnSPActionPerformed
        // TODO add your handling code here:
        int rowSP = tblSanPham.getSelectedRow();
        SanPham sp = svSP.getRow(rowSP);
        String maSP = sp.getMaSP();
        int rowSPCT = tblSPCT.getSelectedRow();
        SanPhamCT spct = svSPCT.getRow(rowSPCT);
        int idSP = spct.getIdSP();
        String trangThai = "Không hoạt động";
        if (rowSP >= 0) {
            if (rowSPCT >= 0) {
                int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn ẩn sản phẩm không?", "Chi tiết sản phẩm", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    svSPCT.upDateTrangThai(trangThai, idSP);
                    JOptionPane.showMessageDialog(this, "Ẩn sản phẩm thành công");
                    reSet();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm chi tiết trong bảng");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm trong bảng");
        }
        loadDataSPCTByMa(maSP);
    }//GEN-LAST:event_btnAnSPActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        // TODO add your handling code here:
        reSet();

    }//GEN-LAST:event_btNewActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("D:\\Pro1041\\Clotify\\src\\img");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();

            Image img = ImageIO.read(file);
            strHinhAnh = file.getName();
            lblHinhAnh.setText("");
            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();
            lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_lblHinhAnhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SanPham1;
    private javax.swing.JButton btAnTT;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btThemThuocTinh;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btnAnSP;
    private javax.swing.JButton btnLSG;
    private javax.swing.JButton btnSPAn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdMauSac;
    private javax.swing.JRadioButton rdSize;
    private javax.swing.JRadioButton rdThuongHieu;
    private javax.swing.JTable tbThuocTinh;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenTT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
