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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.tenNV, KhachHang.tenKH, HoaDon.trangThai,KhachHang.idKH\n"
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
                hd.setIdKH(7);
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
    public void addHoaDon(HoaDon hd) {
        try {
            String sql = "INSERT INTO HoaDon\n"
                    + "             (ngayTao, maNV, idKH, trangThai)\n"
                    + "VALUES (?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTao());
            ps.setString(2, hd.getMaNV());
            ps.setInt(3, hd.getIdKH());
            ps.setString(4, hd.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upDateHoaDon(HoaDon hd) {
        try {
            String sql = "UPDATE HoaDon\n"
                    + "SET       ngayTao =?, maNV =?, idKH =?, maVoucher =?, trangThai =? where idHD=?";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTao());
            ps.setString(2, hd.getMaNV());
            ps.setInt(3, hd.getIdKH());
            ps.setString(4, hd.getMaVoucher());
            ps.setString(5, hd.getTrangThai());
            ps.setInt(6, hd.getIdHD());
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            
            java.sql.Date Start = new java.sql.Date(batDau.getTime());
            java.sql.Date End = new java.sql.Date(ketThuc.getTime());
            psm.setDate(1, Start);
            psm.setDate(2, End);
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

    @Override
    public List<HoaDon> getHoaDonAllAdmin() {
                listHoaDon.clear();
        try {
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao,HoaDon.maNV, HoaDon.trangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV";
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
    
}
