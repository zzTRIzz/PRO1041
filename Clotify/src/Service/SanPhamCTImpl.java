/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamCT;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import Interface.SanPhamCTService;

/**
 *
 * @author ZznamnhizZ
 */
public class SanPhamCTImpl implements SanPhamCTService {

    List<SanPhamCT> listspct = new ArrayList<>();

    @Override
    public List<SanPhamCT> getAll() {
        listspct.clear();
        String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPhamCT.loaiSP, SanPhamCT.soLuong, SanPhamCT.giaNhap, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu, ChatLieu.tenChatLieu, SanPhamCT.trangThai, LichSuGia.gia,SanPham.tenSP, LichSuGia.idLS\n"
                + "FROM      ChatLieu INNER JOIN\n"
                + "                 SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n"
                + "                 MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n"
                + "                 Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n"
                + "                 ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n"
                + "                 SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n"
                + "                 LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP\n"
                + "WHERE SanPhamCT.trangThai = N'Hoạt động'and LichSuGia.ngayKetThuc ='NULL' ";

        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();

                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setLoaiSP(rs.getString(3));
                spct.setSoLuong(rs.getInt(4));
                spct.setGiaNhap(rs.getDouble(5));

                spct.setTenMS(rs.getString(6));
                spct.setTenSize(rs.getString(7));
                spct.setTenTH(rs.getString(8));
                spct.setTenCL(rs.getString(9));
                spct.setTrangThai(rs.getString(10));
                spct.setGiaBan(rs.getDouble(11));
                spct.setTenSP(rs.getString(12));
                spct.setIdLS(rs.getInt(13));
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

//    @Override
//    public void updateSanPhamCT(int soLuong, int idSP) {
//        try {
//            String sql = "UPDATE SanPhamCT\n"
//                    + "SET       soLuong =?\n"
//                    + "WHERE (idSP=?)";
//            Connection conn = DBconnect.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, soLuong);
//            ps.setDouble(2, idSP);
//            ps.executeUpdate();
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void updateSanPhamCT(int idSPCT, int soLuongCon) {
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

    }

    @Override
    public void addSanPhamCT(SanPhamCT spct) {
        try {
            String sql = "INSERT INTO SanPhamCT\n"
                    + "                 (maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)\n"
                    + "VALUES  (?,?,?,?,?,?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spct.getMaSP());
            ps.setString(2, spct.getLoaiSP());
            ps.setInt(3, spct.getSoLuong());
            ps.setDouble(4, spct.getGiaNhap());
            ps.setString(5, spct.getTrangThai());
            ps.setInt(6, spct.getIdMauSac());
            ps.setInt(7, spct.getIdSize());
            ps.setInt(8, spct.getIdThuongHieu());
            ps.setInt(9, spct.getIdChatLieu());

            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPhamCT> searchID(String maSP, String loaiSP, int idTH, int idMS, int idSize, int idCL) {
        listspct.clear();
        try {
            String sql = "SELECT  idSP\n"
                    + "FROM      SanPhamCT\n"
                    + "WHERE   (maSP =?) and\n"
                    + "                 (loaiSP=?) and (idThuongHieu=?) and(idMauSac=?) and(idSize=?) and(idChatLieu=?)";
            Connection conn = (Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, loaiSP);
            ps.setInt(3, idTH);
            ps.setInt(4, idMS);
            ps.setInt(5, idSize);
            ps.setInt(6, idCL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                listspct.add(spct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

    @Override
    public List<SanPhamCT> searchSPCT(String key) {
        listspct.clear();
        String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPhamCT.loaiSP, SanPhamCT.soLuong, SanPhamCT.giaNhap, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu, ChatLieu.tenChatLieu, SanPhamCT.trangThai, LichSuGia.gia, LichSuGia.idLS\n"
                + "FROM      ChatLieu INNER JOIN\n"
                + "                 SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n"
                + "                 MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n"
                + "                 Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n"
                + "                 ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n"
                + "                 LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP\n" //Do cái lsg này nên k load được 1 sp nữa lên table này
                + "WHERE SanPhamCT.trangThai = N'Hoạt động' and (SanPhamCT.maSP =?) and LichSuGia.ngayKetThuc ='NULL'";

        try {
            Connection conn = DBconnect.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setLoaiSP(rs.getString(3));
                spct.setSoLuong(rs.getInt(4));
                spct.setGiaNhap(rs.getDouble(5));

                spct.setTenMS(rs.getString(6));
                spct.setTenSize(rs.getString(7));
                spct.setTenTH(rs.getString(8));
                spct.setTenCL(rs.getString(9));
                spct.setTrangThai(rs.getString(10));
                spct.setGiaBan(rs.getDouble(11));
                spct.setIdLS(rs.getInt(12));

                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

    @Override
    public void upDateTrangThai(String trangThai, int idSP) {
        try {
            String sql = "UPDATE SanPhamCT\n"
                    + "SET       trangThai =?\n"
                    + "WHERE (idSP=?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setInt(2, idSP);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
