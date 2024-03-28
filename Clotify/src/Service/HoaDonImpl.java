/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.HoaDonService;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import java.sql.*;

/**
 *
 * @author Surface
 */
public class HoaDonImpl implements HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();

    @Override
    public List<HoaDon> getHoaDonAll() {
        listHoaDon.clear();
        try {
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, HoaDon.maNV, HoaDon.trangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV\n";
//                    + "where HoaDon.trangThai =N'Chưa thanh toán' ";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public HoaDon getRowHD(int row) {
        return listHoaDon.get(row);
    }

    @Override
    public List<HoaDon> Search(String key) {
        String sql = "Select idHD,maHD,ngayTao,maNV,trangThai from HoaDon where maHD like ? or maNV like ? or ngayTao like ? ";
        listHoaDon.clear();
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, "%" + key + "%");
            psm.setString(2, "%" + key + "%");
            psm.setString(3, "%" + key + "%");
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHoaDon;
    }

    @Override
    public List<HoaDon> SearchTime(java.util.Date batDau, java.util.Date ketThuc) {
        String sql = "Select idHD,maHD,ngayTao,maNV,trangThai from HoaDon where ngayTao between ? and ?";
        listHoaDon.clear();
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);

            java.sql.Date sqlStart = new java.sql.Date(batDau.getTime());
            java.sql.Date sqlEnd = new java.sql.Date(ketThuc.getTime());

            psm.setDate(1, sqlStart);
            psm.setDate(2, sqlEnd);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

}
