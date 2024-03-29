/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

import Interface.SanPhamCTImpl;
import Interface.ThuocTinhImpl;
import Service.SanPhamCTService;
import Service.ThuocTinhService;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.MauSac;
import model.SanPhamCT;
import model.Size;
import model.ThuongHieu;

/**
 *
 * @author ADMIN
 */
public class TrangSP extends javax.swing.JInternalFrame {

    /**
     * Creates new form Trang0
     */
    DefaultTableModel model;
    SanPhamCTImpl svSPCT = new SanPhamCTService();
    DefaultTableModel modeltt;
    ThuocTinhImpl svTT = new ThuocTinhService();

    public TrangSP() {
        initComponents();
        ui_custom.deleteTitle(this);
        model = (DefaultTableModel) tbSPCT.getModel();
        loadData();
        modeltt = (DefaultTableModel) tbThuocTinh.getModel();
        loadDataTT();
    }

    void loadData() {
        model.setRowCount(0);
        for (SanPhamCT spct : svSPCT.getAll()) {
            Object[] row = new Object[]{
                spct.getIdSP(),
                spct.getMaSP(),
                spct.getTenSP(),
                spct.getThuongHieu(),
                spct.getLoaiSP(),
                spct.getSize(),
                spct.getChatLieu(),
                spct.getMauSac(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getSoLuong(),
                spct.getNgayNhap(),
                spct.getTrangThai()
            };
            model.addRow(row);
        }
    }

    SanPhamCT getForm() {
        SanPhamCT spct = new SanPhamCT();
//        spct.setIdSP(Integer.valueOf(txtIdSp.getText()));
        spct.setMaSP(txtMaSp.getText());
        spct.setTenSP(txtTenSp.getText());
        spct.setThuongHieu(txtThuongHieu.getText());
        String LoaiSP = (String) cboLoai.getSelectedItem();
        String size = (String) cboSize.getSelectedItem();
        String chatLieu = (String) cboChatLieu.getSelectedItem();
        String mauSac = (String) cboMauSac.getSelectedItem();
        spct.setGiaBan(Double.valueOf(txtGiaBan.getText()));
        spct.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        spct.setNgayNhap(txtNgayNhap.getText());

        return spct;
    }
//

    void setForm(SanPhamCT spct) {
//        txtIdSp.setText(spct.getIdSP().toString());
        txtMaSp.setText(spct.getMaSP());
        txtTenSp.setText(spct.getTenSP());
        txtThuongHieu.setText(spct.getThuongHieu());

        String loaiSP = spct.getLoaiSP();
        cboLoai.setSelectedItem(loaiSP);

        String size = spct.getSize();
        cboSize.setSelectedItem(size);

        String chatLieu = spct.getChatLieu();
        cboChatLieu.setSelectedItem(chatLieu);

        String mauSac = spct.getMauSac();
        cboMauSac.setSelectedItem(mauSac);
        txtGiaBan.setText(spct.getGiaBan().toString());
        txtSoLuong.setText(spct.getSoLuong().toString());
        txtNgayNhap.setText(spct.getNgayNhap());

    }

    void loadDataTT() {
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
        for (ThuongHieu th : svTT.getAllTh()) {
            Object[] row = new Object[]{
                th.getIdTH(),
                th.getMaTH(),
                "Thương hiệu",
                th.getTenTH(),};
            modeltt.addRow(row);
        }
        for (ChatLieu cl : svTT.getAllCl()) {
            Object[] row = new Object[]{
                cl.getIdCL(),
                cl.getMaCL(),
                "Chất liệu",
                cl.getTenCL()
            };
            modeltt.addRow(row);
        }
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
        jPanel3 = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtThuongHieu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboLoai = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSPCT = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTenTT = new javax.swing.JTextField();
        rdThuongHieu = new javax.swing.JRadioButton();
        rdMauSac = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdSize = new javax.swing.JRadioButton();
        btAddTT = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(3, 1));

        btNew.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btNew.setForeground(new java.awt.Color(20, 70, 128));
        btNew.setText("New   ");
        jPanel3.add(btNew);

        btUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(20, 70, 128));
        btUpdate.setText("Update");
        jPanel3.add(btUpdate);

        btSave.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(20, 70, 128));
        btSave.setText("   Lưu");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btSave);

        btSearch.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btSearch.setForeground(new java.awt.Color(20, 70, 128));
        btSearch.setText("  Tìm ");
        jPanel3.add(btSearch);
        jPanel3.add(txtTimKiem);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("Mã sản phẩm");

        txtMaSp.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        txtTenSp.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Giá bán");

        txtGiaBan.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Chất liệu");

        cboChatLieu.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contton", "Polyester", "Denim", "Lụa", "Len", "Satin", "Thun lạnh", "Cashmere" }));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Thương hiệu");

        txtThuongHieu.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Màu sắc");

        cboMauSac.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trắng", "Đen", "Xanh", "Hồng", "Cam", "Vàng", "Hồng đậm", "Xám" }));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Loại");

        cboLoai.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo thun", "Áo khoác", "Quần jeans", "Áo sơ mi", "Váy đầm", "Quần tây", "Chân váy" }));

        cboSize.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "XXL", "XS", "XXXL", "XXS" }));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Size");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Ngày nhập");

        txtNgayNhap.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtThuongHieu)
                                .addComponent(txtTenSp)
                                .addComponent(cboLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(txtSoLuong)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayNhap))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8))
                            .addComponent(txtThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))))
        );

        tbSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên SP", "Thương hiệu", "Loại SP", "Size", "Chất liệu", "Màu sắc", "Giá nhập", "Giá bán", "Số lượng", "Ngày nhập", "Trạng thái"
            }
        ));
        tbSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSPCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSPCT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        SanPham1.addTab("Thông tin sản phẩm", jPanel6);

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

        buttonGroup1.add(rdChatLieu);
        rdChatLieu.setText("Chất liệu");
        rdChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdChatLieuMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdSize);
        rdSize.setText("Size");
        rdSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdSizeMouseClicked(evt);
            }
        });

        btAddTT.setText("Thêm");
        btAddTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddTTMouseClicked(evt);
            }
        });

        jButton5.setText("Ẩn");

        jPanel8.setBackground(new java.awt.Color(246, 246, 246));

        tbThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Thuộc tính", "Mã thuộc tính", "Loại thuộc tính", "Tên thuộc tính"
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
                        .addComponent(btAddTT)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
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
                    .addComponent(btAddTT)
                    .addComponent(jButton5))
                .addGap(51, 51, 51)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(SanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSaveActionPerformed

    private void rdThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdThuongHieuActionPerformed

    private void tbSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPCTMouseClicked
        // TODO add your handling code here:
        int row = tbSPCT.getSelectedRow();
        if (row >= 0) {
            setForm(svSPCT.getRow(row));
        }
    }//GEN-LAST:event_tbSPCTMouseClicked

    private void btAddTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddTTMouseClicked
        // TODO add your handling code here:
        boolean check = !rdThuongHieu.isSelected() && !rdChatLieu.isSelected() && !rdMauSac.isSelected() && !rdSize.isSelected();
        if (check) {
            JOptionPane.showMessageDialog(this, "Chọn một thuộc tính để thêm");
        } else if (rdChatLieu.isSelected()) {
            if (txtTenTT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên chất liệu không được bỏ trống");
                return;
            } else {
                svTT.addChatLieu(getFormCl());
                loadDataCL();
            }
        } else if (rdSize.isSelected()) {
            if (txtTenTT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên size không được bỏ trống");
                return;
            } else {
                svTT.addSize(getFormSize());
                loadDataSize();
            }
        } else if (rdThuongHieu.isSelected()) {
            if (txtTenTT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên thương hiệu không được bỏ trống");
                return;
            } else {
                svTT.addThuongHieu(getFormTh());
                loadDataTH();
            }
        } else if (rdMauSac.isSelected()) {
            if (txtTenTT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên màu sắc không được bỏ trống");
                return;
            } else {
                svTT.addMauSac(getFormMs());
                loadDataMS();
            }
        }
    }//GEN-LAST:event_btAddTTMouseClicked

    private void rdThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdThuongHieuMouseClicked
        // TODO add your handling code here:
        loadDataTH();
    }//GEN-LAST:event_rdThuongHieuMouseClicked

    private void rdMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMauSacMouseClicked
        // TODO add your handling code here:
        loadDataMS();
    }//GEN-LAST:event_rdMauSacMouseClicked

    private void rdChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdChatLieuMouseClicked
        // TODO add your handling code here:
        loadDataCL();
    }//GEN-LAST:event_rdChatLieuMouseClicked

    private void rdSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdSizeMouseClicked
        // TODO add your handling code here:
        loadDataSize();
    }//GEN-LAST:event_rdSizeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SanPham1;
    private javax.swing.JButton btAddTT;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdMauSac;
    private javax.swing.JRadioButton rdSize;
    private javax.swing.JRadioButton rdThuongHieu;
    private javax.swing.JTable tbSPCT;
    private javax.swing.JTable tbThuocTinh;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTenTT;
    private javax.swing.JTextField txtThuongHieu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
