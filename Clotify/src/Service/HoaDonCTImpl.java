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
            String sql = "SELECT HoaDonChiTiet.idHoaDonCT, SanPham.tenSP, HoaDonChiTiet.soLuongMua, LichSuGia.gia,HoaDonChiTiet.tongTien,HoaDon.idHD,SanPhamCT.idSP\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN\n"
                    + "             SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n"
                    + "             LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP INNER JOIN\n"
                    + "             SanPham ON SanPhamCT.maSP = SanPham.maSP \n"
//                    + "             SanPhamKM ON SanPhamCT.idSP = SanPhamKM.idSP left JOIN\n"
//                    + "             KhuyenMai ON SanPhamKM.maKM = KhuyenMai.maKM\n"
                    //                    + "where HoaDon.idHD =? and KhuyenMai.trangThai=N'Đang áp dụng' and LichSuGia.ngayKetThuc is NULL";
//                    + "where HoaDon.idHD =? and (KhuyenMai.trangThai=N'Đang áp dụng' or KhuyenMai.trangThai = N'Hết hạn' OR SanPhamCT.idSP NOT IN (SELECT SanPhamKM.idSP FROM SanPhamKM)) and LichSuGia.ngayKetThuc is NULL";
                    + "where HoaDon.idHD =? and LichSuGia.ngayKetThuc is NULL";
            Connection conn = (Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setIdHoaDonCT(rs.getInt(1));
                hdct.setTenSP(rs.getString(2));
                hdct.setSoLuongMua(rs.getInt(3));
                hdct.setGiaBan(rs.getDouble(4));
//                hdct.setTenKM(rs.getString(5));
//                hdct.setKhuyenMaiPT(rs.getInt(6));

                hdct.setTongTien(rs.getDouble(5));
                hdct.setIdHD(rs.getInt(6));
                hdct.setIdSP(rs.getInt(7));
//                hdct.setTrangThaiKM(rs.getString(10));
                listHoaDonCT.add(hdct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonCT;

    }

    @Override
    public void addHoaDonCT(HoaDonCT hdct) {
        try {
            String sql = "INSERT INTO HoaDonChiTiet\n"
                    + "             (idSP, idHD, soLuongMua, tongTien)\n"
                    + "VALUES (?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getIdSP());
            ps.setInt(3, hdct.getSoLuongMua());
            ps.setInt(2, hdct.getIdHD());
            ps.setDouble(4, hdct.getTongTien());

            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDonCT> getSanPhamTonTai(int idHD, int idSP) {
        listHoaDonCT.clear();
        try {
            String sql = "SELECT HoaDonChiTiet.idHoaDonCT, SanPham.tenSP, HoaDonChiTiet.soLuongMua, LichSuGia.gia,HoaDonChiTiet.tongTien\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "            HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN \n"
                    + "           SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n"
                    + "            LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP INNER JOIN\n"
                    + "            SanPham ON SanPhamCT.maSP = SanPham.maSP \n"
//                    + "            SanPhamKM ON SanPhamCT.idSP = SanPhamKM.idSP inner JOIN\n"
//                    + "            KhuyenMai ON SanPhamKM.maKM = KhuyenMai.maKM \n"
                    + "where HoaDon.idHD =? and SanPhamCT.idSP=? and LichSuGia.ngayKetThuc is NULL";
            Connection conn = (Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.setInt(2, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setIdHoaDonCT(rs.getInt(1));
                hdct.setTenSP(rs.getString(2));
                hdct.setSoLuongMua(rs.getInt(3));
                hdct.setGiaBan(rs.getDouble(4));
//                hdct.setTenKM(rs.getString(5));
//                hdct.setKhuyenMaiPT(rs.getInt(6));

                hdct.setTongTien(rs.getDouble(5));

                listHoaDonCT.add(hdct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonCT;
    }

    @Override
    public void gopSanPhamTonTai(int idHDCT, int soLuongMua, double tongTien) {
        try {
            String sql = "UPDATE HoaDonChiTiet\n"
                    + "SET       soLuongMua =?, tongTien =?\n"
                    + "WHERE (idHoaDonCT=?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongMua);
            ps.setDouble(2, tongTien);
            ps.setInt(3, idHDCT);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HoaDonCT getRowHDCT(int row) {
        return listHoaDonCT.get(row);
    }

    @Override
    public void deleteHDCT(int idHDCT) {
        try {
            String sql = "delete from HoaDonChiTiet where idHoaDonCT=?";
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idHDCT);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDonCT> getSanPhamTonTaiKoKM(int idHD, int idSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addHoaDonCTKM(int idHD, int soLuongMua, int idSP, double tongTien) {
        try {
            String sql = "INSERT INTO HoaDonChiTiet (idSP, idHD, soLuongMua, tongTien)\n"
                    + "SELECT TOP 1 SP.idSP, ?, ?, ?\n"
                    + "FROM SanPhamCT SP\n"
                    + "INNER JOIN SanPhamKM KM ON SP.idSP = KM.idSP\n"
                    + "INNER JOIN KhuyenMai K ON KM.maKM = K.maKM\n"
                    + "WHERE SP.idSP = ?\n"
                    + "ORDER BY K.ngayQuyetDinh DESC;";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(4, idSP);
            ps.setInt(2, soLuongMua);
            ps.setInt(1, idHD);
            ps.setDouble(3, tongTien);

            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
