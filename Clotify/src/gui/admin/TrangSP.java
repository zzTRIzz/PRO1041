/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

<<<<<<< Updated upstream
import model.SanPham;
import Service.SanPhamService;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.basic.BasicInternalFrameUI;
=======


import Interface.SanPhamCTImpl;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.SanPhamCT;

import Service.SanPhamCTService;
>>>>>>> Stashed changes

/**
 *
 * @author ADMIN
 */
public class TrangSP extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    SanPhamService service = new SanPhamService();

    /**
     * Creates new form Trang0
     */
<<<<<<< Updated upstream
=======
    SanPhamCTImpl svSPCT = new SanPhamCTService();
    DefaultTableModel defaultTableModel;
>>>>>>> Stashed changes
    public TrangSP() {
        initComponents();
        ui_custom.deleteTitle(this);
        model = (DefaultTableModel) tbSanPham.getModel();
        loadData();
    }
<<<<<<< Updated upstream

    void loadData() {
        model.setRowCount(0);
        for (SanPham sp : service.getAll()) {
            Object[] row = new Object[]{
<<<<<<< Updated upstream
                sp.getIdSP(),
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTenThuongHieu(),
                sp.getLoaiSP(),
                sp.getTenSize(),
                sp.getTenChatLieu(),
                sp.getTenMauSac(),
                sp.getGiaBan(),
                sp.getSoLuong(),
                sp.getNgayNhap(),
                sp.getTrangThai(),};
=======
                spCT.getIdSP(),
                spCT.getMaSP(),
                spCT.getTenSP(),
                spCT.getThuongHieu(),
                spCT.getLoaiSP(),
                spCT.getSize(),
                spCT.getChatLieu(),
                spCT.getMauSac(),
                spCT.getGiaBan(),
                spCT.getSoLuong(),
                spCT.getNgayNhap(),
                spCT.getTrangThai(),
            };
>>>>>>> Stashed changes
            model.addRow(row);
=======
    void loadData(){
        defaultTableModel = (DefaultTableModel) tblSanPhamCT.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamCT sanPhamCT : svSPCT.getAll()) {
            defaultTableModel.addRow(new Object[]{
                sanPhamCT.getIdSP(),
                sanPhamCT.getMaSP(),
                sanPhamCT.getTenSP(),
                sanPhamCT.getLoaiSP(),
                sanPhamCT.getMauSac(),
                sanPhamCT.getChatLieu(),
                sanPhamCT.getSize(),
                sanPhamCT.getThuongHieu(),
                sanPhamCT.getGiaNhap(),
                sanPhamCT.getGiaBan(),
                sanPhamCT.getSoLuong(),
                sanPhamCT.getNgayNhap(),
                sanPhamCT.getTrangThai(),
            });
>>>>>>> Stashed changes
        }
    }

    SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setIdSP(Integer.valueOf(txtIdSP.getText()));
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setTenThuongHieu(txtThuongHieu.getText());
        String LoaiSP = (String) cboLoaiSP.getSelectedItem();
        String size = (String) cboSize.getSelectedItem();
        String chatLieu = (String) cboChatLieu.getSelectedItem();
        String mauSac = (String) cboMauSac.getSelectedItem();
        sp.setGiaBan(Double.valueOf(txtGiaBan.getText()));
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayNhap = dateFormat.parse(txtNgayNhap.getText());
            sp.setNgayNhap(ngayNhap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       sp.setTrangThai(rdHoatDong.isSelected()?"Hoạt động":"Không hoạt động");

        return sp;
    }

    void setForm(SanPham sp) {
        txtIdSP.setText(sp.getIdSP().toString());
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtThuongHieu.setText(sp.getTenThuongHieu());

        String loaiSP = sp.getLoaiSP();
        cboLoaiSP.setSelectedItem(loaiSP);

        String size = sp.getTenSize();
        cboSize.setSelectedItem(size);

        String chatLieu = sp.getTenChatLieu();
        cboChatLieu.setSelectedItem(chatLieu);

        String mauSac = sp.getTenMauSac();
        cboMauSac.setSelectedItem(mauSac);
        txtGiaBan.setText(sp.getGiaBan().toString());
        txtSoLuong.setText(sp.getSoLuong().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngayNhapStr = dateFormat.format(sp.getNgayNhap());
        txtNgayNhap.setText(ngayNhapStr);
        String trangThai = sp.getTrangThai();
        if ("Hoạt động".equals(trangThai)) {
            rdHoatDong.setSelected(true);
        }else if("Không hoạt động".equals(trangThai)){
            rdKhongHoatDong.setSelected(true);
        }

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
<<<<<<< Updated upstream
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btDeleteSanPham = new javax.swing.JButton();
=======
        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
>>>>>>> Stashed changes
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
<<<<<<< Updated upstream
        txtThuongHieu = new javax.swing.JTextField();
=======
>>>>>>> Stashed changes
        jLabel9 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
<<<<<<< Updated upstream
        cboLoaiSP = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdSP = new javax.swing.JTextField();
        rdHoatDong = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
=======
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        txtLoai = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
>>>>>>> Stashed changes
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        btUpdate = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

<<<<<<< Updated upstream
        btNew.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btNew.setForeground(new java.awt.Color(20, 70, 128));
        btNew.setText("New   ");
        btNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNewMouseClicked(evt);
            }
        });
        jPanel3.add(btNew);
=======
        jButton1.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(20, 70, 128));
        jButton1.setText("New   ");
        jPanel3.add(jButton1);

        btnSave.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(20, 70, 128));
        btnSave.setText("   Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave);
>>>>>>> Stashed changes

        btSave.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(20, 70, 128));
        btSave.setText("   Lưu");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btSave);

        btDeleteSanPham.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btDeleteSanPham.setForeground(new java.awt.Color(20, 70, 128));
        btDeleteSanPham.setText("Xóa");
        btDeleteSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteSanPhamActionPerformed(evt);
            }
        });
        jPanel3.add(btDeleteSanPham);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(20, 70, 128))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("Mã sản phẩm");

        txtMaSP.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        txtTenSP.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Giá bán");

        txtGiaBan.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Chất liệu");

        cboChatLieu.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cotton", "Polyester", "Denim", "Lụa", "Len", "Satin", "Thun lạnh", "Cashmere" }));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Thương hiệu");

<<<<<<< Updated upstream
        txtThuongHieu.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

=======
>>>>>>> Stashed changes
        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Màu sắc");

        cboMauSac.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trắng", "Đen", "Xanh", "Hồng", "Cam", "Vàng", "Hồng đậm", "Xám" }));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Loại");

<<<<<<< Updated upstream
        cboLoaiSP.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo thun", "Áo khoác", "Quần jeans", "Áo sơ mi", "Váy đầm", "Quần tây", "Chân váy" }));

        cboSize.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "XXL", "XS", "XXXL", "XXS" }));
=======
        jComboBox4.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "XS", "S", "M", "L", "XL", "XXL" }));
>>>>>>> Stashed changes

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Size");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Ngày nhập");

        txtNgayNhap.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel1.setText("Id sản phẩm");

        buttonGroup1.add(rdHoatDong);
        rdHoatDong.setText("Hoạt động");

        buttonGroup1.add(rdKhongHoatDong);
        rdKhongHoatDong.setText("Không hoạt động");

        jLabel4.setText("Trạng thái");

        jComboBox5.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Áo", "Quần" }));

        txtLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiActionPerformed(evt);
            }
        });

        jLabel1.setText("Giá nhập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
<<<<<<< Updated upstream
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                        .addComponent(txtTenSP)
                                        .addComponent(cboLoaiSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(txtIdSP))))
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
                                .addComponent(txtNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
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
                                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(rdHoatDong)
                                .addGap(41, 41, 41)
                                .addComponent(rdKhongHoatDong))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
=======
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox4, 0, 118, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, 0, 118, Short.MAX_VALUE)
                                    .addComponent(txtLoai)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(82, 82, 82))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(24, 24, 24)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNhap))))
>>>>>>> Stashed changes
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
<<<<<<< Updated upstream
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
>>>>>>> Stashed changes
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
<<<<<<< Updated upstream
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
=======
                                .addGap(18, 18, 18)
                                .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
>>>>>>> Stashed changes
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdHoatDong)
                    .addComponent(rdKhongHoatDong))
                .addGap(16, 16, 16))
        );

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
<<<<<<< Updated upstream
                "STT", "Mã", "Tên SP", "Thương Hiệu", "Loại SP", "Size", "Chất liệu", "Màu sắc", "Giá bán", "Số lượng", "Ngày nhập", "Trạng thái"
=======
                "STT", "Mã", "Tên SP", "Loại", "Màu sắc", "Chất liệu", "Size", "Thương hiệu", "Giá nhập", "Giá bán", "Số lượng", "Ngày tạo", "Trạng thái"
>>>>>>> Stashed changes
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

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
                        .addGap(10, 10, 10)
                        .addComponent(btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btUpdate)
                        .addGap(85, 85, 85))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< Updated upstream
                .addContainerGap(99, Short.MAX_VALUE))
=======
                .addContainerGap(95, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );

        SanPham1.addTab("Thông tin sản phẩm", jPanel6);

        jLabel16.setText("Tên thuộc tính");

        jRadioButton4.setText("Thương hiệu");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Màu sắc");

        jRadioButton6.setText("Chất liệu");

        jRadioButton7.setText("Size");

        jButton3.setText("Thêm");

        jButton5.setText("Ẩn");

        jPanel8.setBackground(new java.awt.Color(246, 246, 246));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Loại thuộc tính", "Tên thuộc tính"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

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
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jRadioButton4)
                        .addGap(51, 51, 51)
                        .addComponent(jRadioButton5)
                        .addGap(49, 49, 49)
                        .addComponent(jRadioButton6)
                        .addGap(53, 53, 53)
                        .addComponent(jRadioButton7)))
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
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(51, 51, 51)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< Updated upstream
                .addContainerGap(74, Short.MAX_VALUE))
=======
                .addContainerGap(77, Short.MAX_VALUE))
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            .addGap(0, 703, Short.MAX_VALUE)
=======
            .addGap(0, 706, Short.MAX_VALUE)
>>>>>>> Stashed changes
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(SanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< Updated upstream
    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btSaveActionPerformed
=======
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String trangThai = "Hoạt động";
    }//GEN-LAST:event_btnSaveActionPerformed
>>>>>>> Stashed changes

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

<<<<<<< Updated upstream
    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tbSanPham.getSelectedRow();
        if (row >= 0) {
            setForm(service.getRow(row));
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewMouseClicked
        // TODO add your handling code here:
        int i = tbSanPham.getSelectedRow();
        String maSp = "";
        txtMaSP.setText(maSp);
        String tenSp = "";
        txtTenSP.setText(tenSp);
        String tenTH = "";
        txtThuongHieu.setText(tenTH);
        String giaBan = "";
        txtGiaBan.setText(giaBan);
        String soLuong = "";
        txtSoLuong.setText(soLuong);
        String ngayNhap = "";
        txtNgayNhap.setText(ngayNhap);
        cboChatLieu.setSelectedIndex(-1);
        cboLoaiSP.setSelectedIndex(-1);
        cboSize.setSelectedIndex(-1);
        cboMauSac.setSelectedIndex(-1);
    }//GEN-LAST:event_btNewMouseClicked

    private void btDeleteSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteSanPhamActionPerformed
        // TODO add your handling code here:
//        int row = tbSanPham.getSelectedRow();
//        if (row >= 0) {
//            String ma = service.getRow(row).getMaSP();
//            service.deleteSanPham(ma);
//            loadData();
//
//        }
    }//GEN-LAST:event_btDeleteSanPhamActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
//        int row = tbSanPham.getSelectedRow();
//        if (row >= 0) {
//            String ma = service.getRow(row).getMaSP();
//            SanPham sp = getForm();
//            sp.setMaSP(ma);
//            service.updateSPCT(sp);
//            loadData();
//
//        }
        int row = tbSanPham.getSelectedRow();
        if (row >= 0) {
            Integer id = service.getRow(row).getIdSP();
            SanPham sp = getForm();
            sp.setMaSP(id.toString());
            service.updateSPCT(sp);
            loadData();

        }
    }//GEN-LAST:event_btUpdateActionPerformed
=======
    private void txtLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiActionPerformed
>>>>>>> Stashed changes


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SanPham1;
<<<<<<< Updated upstream
    private javax.swing.JButton btDeleteSanPham;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
=======
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
>>>>>>> Stashed changes
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
<<<<<<< Updated upstream
=======
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
>>>>>>> Stashed changes
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
<<<<<<< Updated upstream
    private javax.swing.JTextField jTextField8;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdKhongHoatDong;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtIdSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThuongHieu;
=======
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tblSanPhamCT;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtLoai;
>>>>>>> Stashed changes
    // End of variables declaration//GEN-END:variables
}
