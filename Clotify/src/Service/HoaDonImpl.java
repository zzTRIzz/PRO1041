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
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.tenNV, KhachHang.tenKH, HoaDon.trangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV\n"
                    + "where HoaDon.trangThai =N'Chưa thanh toán' ";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setTenKH(rs.getString(5));
                hd.setTrangThai(rs.getString(6));
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

}
