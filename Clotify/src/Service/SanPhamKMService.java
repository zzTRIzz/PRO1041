/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.SanPhamKMInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SanPhamKM;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class SanPhamKMService implements SanPhamKMInterface {

    List<SanPhamKM> list = new ArrayList<>();

    @Override
    public List<SanPhamKM> getSanPhamKM() {
        list.clear();
        try {
            String sql = "SELECT KhuyenMai.maKM, KhuyenMai.tenKM, KhuyenMai.ngayTao, KhuyenMai.ngayKetThuc, SanPhamCT.loaiSP, KhuyenMai.giamTheoPT, KhuyenMai.trangThai\n"
                    + "FROM   KhuyenMai INNER JOIN\n"
                    + "             SanPhamKM ON KhuyenMai.maKM = SanPhamKM.maKM INNER JOIN\n"
                    + "             SanPhamCT ON SanPhamKM.idSP = SanPhamCT.idSP";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamKM spKM = new SanPhamKM();
                spKM.setMaKM(rs.getString(1));
                spKM.setTenKM(rs.getString(2));
                spKM.setNgayTao(rs.getString(3));
                spKM.setNgayKetThuc(rs.getString(4));
                spKM.setLoaiSP(rs.getString(5));

                spKM.setGiamTheoPT(rs.getInt(6));
                spKM.setTrangThai(rs.getString(7));
                list.add(spKM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addSPKM(int idSP, String maKM, String trangThai, String ngayBatDau) {
        String sql = "INSERT INTO SanPhamKM (maKM, idSP, trangThai)\n"
                + "SELECT ?, ?, ?\n"
                + "Where NOT EXISTS (\n"
                + "    SELECT 1 FROM KhuyenMai \n"
                + "    INNER JOIN SanPhamKM ON KhuyenMai.maKM = SanPhamKM.maKM \n"
                + "    WHERE SanPhamKM.idSP = ? \n"
                + "    AND KhuyenMai.ngayTao = ?\n"
                + ");";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maKM);
            stm.setInt(2, idSP);
            stm.setString(3, trangThai);
            stm.setInt(4,idSP);
            stm.setString(5,ngayBatDau);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SanPhamKM getRow(int row) {
        return list.get(row);
    }

    @Override
    public List<SanPhamKM> searchIDSP(String maKM) {
        String sql = "select idSPKM from SanPhamKM where  trangThai =N'Hoạt động'and maKM=?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, maKM);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPhamKM spkm = new SanPhamKM();
                spkm.setIdSPKM(rs.getInt(1));
                list.add(spkm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPhamKM> getSPKM(String maKM, String trangThai) {
        list.clear();
        String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPhamCT.loaiSP, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu, ChatLieu.tenChatLieu,idSPKM,SanPhamKM.maKM,SanPhamKM.trangThai,SanPhamCT.giaNhap,LichSuGia.gia,KhuyenMai.giamTheoPT\n"
                + "FROM      ChatLieu INNER JOIN\n"
                + "                 SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n"
                + "                 MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n"
                + "                 Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n"
                + "                 ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n"
                + "                 LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP INNER JOIN\n"
                + "                 SanPhamKM ON SanPhamKM.idSP = SanPhamCT.idSP left JOIN \n"//Do cái lsg này nên k load được 1 sp nữa lên table này
                + "                 KhuyenMai ON KhuyenMai.maKM  = SanPhamKM.maKM\n"
                + "WHERE SanPhamCT.trangThai = N'Hoạt động' and (SanPhamKM.maKM =?) and LichSuGia.ngayKetThuc is NULL and SanPhamKM.trangThai = ? ";

        try {
            Connection conn = DBconnect.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKM);
            ps.setString(2, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamKM spkm = new SanPhamKM();
                spkm.setIdSP(rs.getInt(1));
                spkm.setMaSP(rs.getString(2));
                spkm.setLoaiSP(rs.getString(3));
                spkm.setMauSac(rs.getString(4));
                spkm.setSize(rs.getString(5));
                spkm.setThuongHieu(rs.getString(6));
                spkm.setChatLieu(rs.getString(7));
                spkm.setIdSPKM(rs.getInt(8));
                spkm.setMaKM(rs.getString(9));
                spkm.setTrangThaiSPKM(rs.getString(10));
                spkm.setGiaNhap(rs.getDouble(11));
                spkm.setGiaBan(rs.getDouble(12));
                spkm.setGiamTheoPT(rs.getInt(13));
                list.add(spkm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
//    public void addSPKMKT(int idSP, String maKM, String trangThai) {
//        String sql = "INSERT INTO SanPhamKM (maKM, idSP, trangThai)\n"
//                + "SELECT ?, ?, ?\n"
//                + "WHERE NOT EXISTS (\n"
//                + "    SELECT 1 FROM SanPhamKM \n"
//                + "    WHERE maKM = ? \n"
//                + "    AND idSP = ?\n"
//                + ");";
//        try {
//            Connection conn = DBconnect.getConnection();
//            PreparedStatement stm = conn.prepareStatement(sql);
//            stm.setString(1, maKM);
//            stm.setInt(2, idSP);
//            stm.setString(3, trangThai);
//            stm.setString(4, maKM);
//            stm.setInt(5, idSP);
//            stm.executeUpdate();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void addSPKMKT(int idSP, String maKM, String trangThai, String ngayBatDau) {
        String sql = "INSERT INTO SanPhamKM (maKM, idSP, trangThai)\n"
                + "SELECT ?, ?, ?\n"
                + "WHERE NOT EXISTS (\n"
                + "    SELECT 1 FROM SanPhamKM \n"
                + "    WHERE maKM = ? \n"
                + "    AND idSP = ?\n"
                + ")\n"
                + "AND NOT EXISTS (\n"
                + "    SELECT 1 FROM KhuyenMai \n"
                + "    INNER JOIN SanPhamKM ON KhuyenMai.maKM = SanPhamKM.maKM \n"
                + "    WHERE SanPhamKM.idSP = ? \n"
                + "    AND KhuyenMai.ngayTao = ?\n"
                + ");";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maKM);
            stm.setInt(2, idSP);
            stm.setString(3, trangThai);
            stm.setString(4, maKM);
            stm.setInt(5, idSP);
            stm.setInt(6, idSP);
            stm.setString(7, ngayBatDau);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int idSPKM, String trangThai) {
        try {
            String sql = "UPDATE SanPhamKM SET trangThai = ? WHERE idSPKM = ?";
            Connection conn = DBconnect.getConnection();

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, trangThai);
                ps.setInt(2, idSPKM);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }

}
