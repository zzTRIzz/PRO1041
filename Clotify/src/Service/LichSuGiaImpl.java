/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.LichSuGiaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.LichSuGia;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ngo Nhan
 */
public class LichSuGiaImpl implements LichSuGiaService {
    List<LichSuGia> listLS = new ArrayList<>();
    @Override
    public void addLSGia(LichSuGia lsg) {
        try {
            String sql = "INSERT INTO LichSuGia\n"
                    + "                 (idSP, gia, ngayBatDau, ngayKetThuc)\n"
                    + "VALUES  (?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lsg.getIdSP());
            ps.setDouble(2, lsg.getGiaBan());
            ps.setString(3, lsg.getNgayBatDau());
            ps.setString(4, lsg.getNgayKetThuc());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LichSuGia> listLSNull() {
        listLS.clear();
        try {
            String sql = "SELECT  idLS, idSP, gia, ngayBatDau, ngayKetThuc\n" +
"FROM      LichSuGia\n" +
"WHERE   (ngayKetThuc=NULL)";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LichSuGia lsg = new LichSuGia();
                lsg.setIdLS(rs.getInt(1));
                lsg.setIdSP(rs.getInt(2));
                lsg.setGiaBan(rs.getDouble(3));
                lsg.setNgayBatDau(rs.getString(4));
                lsg.setNgayKetThuc(rs.getString(5));               
                listLS.add(lsg);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLS;
    }

    @Override
    public List<LichSuGia> getAllLSG() {
        listLS.clear();
        try {
            String sql = "SELECT  LichSuGia.idLS, SanPham.maSP, SanPham.tenSP, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu, ChatLieu.tenChatLieu, SanPhamCT.giaNhap, LichSuGia.gia, LichSuGia.ngayBatDau, LichSuGia.ngayKetThuc\n" +
"FROM      LichSuGia INNER JOIN\n" +
"                 SanPhamCT ON LichSuGia.idSP = SanPhamCT.idSP INNER JOIN\n" +
"                 SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n" +
"                 Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n" +
"                 ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n" +
"                 ChatLieu ON SanPhamCT.idChatLieu = ChatLieu.idChatLieu INNER JOIN\n" +
"                 MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LichSuGia lsg = new LichSuGia();
                lsg.setIdLS(rs.getInt(1));
                lsg.setMaSP(rs.getString(2));
                lsg.setTenSP(rs.getString(3));
                lsg.setMauSac(rs.getString(4));
                lsg.setSize(rs.getString(5));
                lsg.setThuongHieu(rs.getString(6));
                lsg.setChatLieu(rs.getString(7));
                lsg.setGiaNhap(rs.getDouble(8));
                lsg.setGiaBan(rs.getDouble(9));
                lsg.setNgayBatDau(rs.getString(10));
                lsg.setNgayKetThuc(rs.getString(11));               
                listLS.add(lsg);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLS;
    }

    @Override
    public void upDateLSG(String ngayKetThuc,int idLS) {
        try {
            String sql = "UPDATE  LichSuGia\n" +
"SET          ngayKetThuc =?\n" +
"WHERE   (idLS=?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayKetThuc);
            ps.setInt(2, idLS);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
