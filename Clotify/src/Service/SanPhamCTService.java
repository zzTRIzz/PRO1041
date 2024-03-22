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
/**
 *
 * @author ZznamnhizZ
 */
public class SanPhamCTService implements SanPhamCTImpl{

    List<SanPhamCT> listspct = new ArrayList<>();
    @Override
    public List<SanPhamCT> getAll() {
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
    public void addSanPhamCT(SanPhamCT spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateSanPhamCT(SanPhamCT spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamCT> searchSanPhamCT(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
