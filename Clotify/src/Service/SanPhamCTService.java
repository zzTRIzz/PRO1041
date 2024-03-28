/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamCT;
import java.sql.*;
import Interface.SanPhamCTImpl;
<<<<<<< HEAD
import javax.swing.JComboBox;
import javax.swing.JFrame;
=======
>>>>>>> main

/**
 *
 * @author ZznamnhizZ
 */
public class SanPhamCTService implements SanPhamCTImpl {

    List<SanPhamCT> listspct = new ArrayList<>();

    @Override
    public List<SanPhamCT> getAll() {
        listspct.clear();
        String sql = "SELECT SanPhamCT.idSP,SanPhamCT.maSP,tenSP,tenThuongHieu,LoaiSP,tenSize,tenChatLieu,tenMauSac,giaNhap,gia,soLuong, ngayNhap, trangThai \n"
                + "FROM SanPhamCT INNER JOIN \n"
                + " SanPham ON SanPham.maSP = SanPhamCT.maSP INNER JOIN \n "
                + " ThuongHieu on ThuongHieu.idThuongHieu = SanPhamCT.idThuongHieu INNER JOIN \n"
                + " Size on Size.idSize = SanPhamCT.idSize INNER JOIN \n"
                + "MauSac on MauSac.idMauSac = SanPhamCT.idMauSac INNER JOIN \n "
                + " ChatLieu on ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN \n"
                + "LichSuGia on LichSuGia.idSP = SanPhamCT.idSP ";  //Do cái lsg này nên k load được 1 sp nữa lên table này
//                + "WHERE SanPhamCT.trangThai = N'Hoạt động'";

        try {
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();

                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setThuongHieu(rs.getString(4));
                spct.setLoaiSP(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setChatLieu(rs.getString(7));
                spct.setMauSac(rs.getString(8));
                spct.setGiaNhap(rs.getDouble(9));
                spct.setGiaBan(rs.getDouble(10));
                spct.setSoLuong(rs.getInt(11));
                spct.setNgayNhap(rs.getString(12));
                spct.setTrangThai(rs.getString(13));

                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

    @Override
    public SanPhamCT getRow(int row) {
        return listspct.get(row);
    }

    @Override
    public void updateSanPhamCT(SanPhamCT spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamCT> searchSanPhamCT(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
<<<<<<< HEAD
    public boolean addSanPhamCT(SanPhamCT spct) {
//1.    String sql = "INSERT INTO SanPhamCT (idSP, maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu) " +
//                   "SELECT ?, ?, ?, ?, ?, ?, ms.idMauSac, sz.idSize, th.idThuongHieu, cl.idChatLieu " +
//                   "FROM SanPham sp " +
//                   "INNER JOIN ThuongHieu th ON sp.idThuongHieu = th.idThuongHieu " +
//                   "INNER JOIN ChatLieu cl ON sp.idChatLieu = cl.idChatLieu " +
//                   "INNER JOIN Size sz ON sp.idSize = sz.idSize " +
//                   "INNER JOIN MauSac ms ON sp.idMauSac = ms.idMauSac " ;
////                   "WHERE sp.maSP = ?";

        String sql = "Insert into SanPhamCT(idSP, maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)\n"
                + "select th.idThuongHieu,s.idSize,cl.idChatLieu,ms.idMauSac,?,?,?,? from ThuongHieu th,Size s, ChatLieu cl,MauSac ms where th.idThuongHieu=? and s.idSize=? and cl.idChatLieu=? and ms.idMausac=? ";

        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
//1.            psm.setInt(1, spct.getIdSP());
//            psm.setString(2, spct.getMaSP());
//            psm.setString(3, spct.getTenSP());
//            psm.setInt(4, spct.getIdThuongHieu());
//            psm.setString(5, spct.getLoaiSP());
//            psm.setInt(6, spct.getIdSize());
//            psm.setInt(7, spct.getIdChatLieu());
//            psm.setInt(8, spct.getIdMauSac());
//            psm.setDouble(9, spct.getGiaNhap());
//            psm.setDouble(10, spct.getGiaBan());
//            psm.setInt(11, spct.getSoLuong());
//            psm.setString(12, spct.getNgayNhap());
//            psm.setString(13, spct.getTrangThai());

            psm.setObject(1, spct.getIdSP());
            psm.setObject(2, spct.getMaSP());
//            psm.setObject(3, spct.getTenSP());
            psm.setObject(3, spct.getLoaiSP());
            psm.setObject(4, spct.getSoLuong());
            psm.setObject(5, spct.getGiaNhap());
            psm.setObject(6, spct.getTrangThai());
            psm.setObject(7, spct.getIdMauSac());
            psm.setObject(8, spct.getIdSize());
            psm.setObject(9, spct.getIdThuongHieu());
            psm.setObject(10, spct.getIdChatLieu());
//            psm.setObject(10, spct.getGiaBan());
//            psm.setObject(12, spct.getNgayNhap());
            psm.setObject(1, spct.getIdSP());

            psm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
=======
    public void updateSanPhamCTSauMua(int idSPCT, int soLuongCon) {
        try {
            String sql = "UPDATE SanPhamCT\n"
                    + "SET       soLuong =?\n"
                    + "WHERE (idSP=?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongCon);
            ps.setInt(2, idSPCT);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> main
    }

}
