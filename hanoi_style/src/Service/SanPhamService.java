/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

<<<<<<< Updated upstream:hanoi_style/src/Service/SanPhamService.java
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import Interface.SanPhamCTServiceImp;

>>>>>>> Stashed changes:Clotify/src/Service/SanPhamService.java
/**
 *
 * @author ZznamnhizZ
 */
<<<<<<< Updated upstream:hanoi_style/src/Service/SanPhamService.java
public class SanPhamService {
    
=======
public class SanPhamService implements SanPhamCTServiceImp {

    List<SanPham> list = new ArrayList<>();

    @Override
    public List<SanPham> getAll() {
        list.clear();
        String sql = "SELECT SanPhamCT.idSP,SanPhamCT.maSP,tenSP,tenThuongHieu,LoaiSP,tenSize,tenChatLieu,tenMauSac,gia,soLuong, ngayNhap, trangThai \n"
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
                SanPham sp = new SanPham();

                sp.setIdSP(rs.getInt(1));
                sp.setMaSP(rs.getString(2));
                sp.setTenSP(rs.getString(3));
                sp.setTenThuongHieu(rs.getString(4));
                sp.setLoaiSP(rs.getString(5));
                sp.setTenSize(rs.getString(6));
                sp.setTenChatLieu(rs.getString(7));
                sp.setTenMauSac(rs.getString(8));
                sp.setSoLuong(rs.getInt(10));
                sp.setGiaBan(rs.getDouble(9));
                sp.setNgayNhap(rs.getDate(11));
                sp.setTrangThai(rs.getString(12));

                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SanPham getRow(int row) {
        return list.get(row);
    }

    @Override
    public void addSanPham(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateSPCT(SanPham sp) {
        //Update theo id đang false
        String sql = "UPDATE SanPhamCT SET soLuong=?, trangThai=? WHERE idSP = ?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, sp.getSoLuong());
            psm.setString(2, sp.getTrangThai());
            psm.setInt(3, sp.getIdSP());

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Update theo mã
//                String sql = "Update SanPhamCT set soLuong=?,trangThai=? where maSP = ?";
//        try {
//            Connection conn = DBconnect.getConnection();
//            PreparedStatement psm = conn.prepareStatement(sql);
//            psm.setInt(1, sp.getSoLuong());
//            psm.setString(2, sp.getTrangThai());
//            psm.setString(3, sp.getMaSP());
//            psm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<SanPham> searchSanPham(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

>>>>>>> Stashed changes:Clotify/src/Service/SanPhamService.java
}
