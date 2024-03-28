/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.HoaDonCTService;
import java.util.List;
import model.HoaDonCT;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Surface
 */
public class HoaDonCTImpl implements HoaDonCTService {

    List<HoaDonCT> listHoaDonCT = new ArrayList<>();

    @Override
    public List<HoaDonCT> getHoaDonCTAll(int idHD) {
        listHoaDonCT.clear();
        try {
            String sql = "SELECT HoaDonChiTiet.idHoaDonCT,maHD,HoaDon.maNV,HoaDon.ngayTao,KhachHang.tenKH,SanPham.maSP, SanPham.tenSP, HoaDonChiTiet.soLuongMua,HoaDonChiTiet.tongTien\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN\n"
                    + "             SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n"
                    + "             LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP INNER JOIN\n"
                    + "             SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n"
                    + "             SanPhamKM ON SanPhamCT.idSP = SanPhamKM.idSP INNER JOIN\n"
                    + "             KhuyenMai ON SanPhamKM.maKM = KhuyenMai.maKM INNER JOIN\n"
                    + "             KhachHang ON KhachHang.idKH = HoaDon.idKH \n "
                    + "where HoaDon.idHD =?";
            Connection conn = (Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setIdHoaDonCT(rs.getInt(1));
                hdct.setMaHD(rs.getString(2));
                hdct.setMaNV(rs.getString(3));
                hdct.setNgayTao(rs.getString(4));
                hdct.setTenKH(rs.getString(5));
                hdct.setCtMaSP(rs.getString(6));
                hdct.setTenSP(rs.getString(7));
                hdct.setSoLuongMua(rs.getInt(8));
                hdct.setTongTien(rs.getDouble(9));
                listHoaDonCT.add(hdct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonCT;
    }

}
