/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPhamCT;
import Interface.SanPhamCTService;

public class SanPhamICTmpl implements SanPhamCTService {

    List<SanPhamCT> listSanPhamCT = new ArrayList<>();

    @Override
    public List<SanPhamCT> getSanPhamAll() {
        listSanPhamCT.clear();
        try {
            String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPham.tenSP, MauSac.tenMauSac, ChatLieu.tenChatLieu, Size.tenSize, ThuongHieu.tenThuongHieu,SanPhamCT.giaNhap, LichSuGia.gia, SanPhamCT.soLuong,SanPham.ngayNhap, SanPhamCT.trangThai\n"
                    + "FROM   ChatLieu INNER JOIN\n"
                    + "             SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n"
                    + "             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n"
                    + "             SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n"
                    + "             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n"
                    + "             ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n"
                    + "             LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setMauSac(rs.getString(4));
                spct.setChatLieu(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setThuongHieu(rs.getString(7));
                spct.setGiaNhap(rs.getDouble(8));
                spct.setGiaBan(rs.getDouble(9));
                spct.setSoLuong(rs.getInt(10));
                spct.setNgayNhap(rs.getString(11));
                spct.setTrangThai(rs.getString(12));
                
                listSanPhamCT.add(spct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPhamCT;
    }

}
