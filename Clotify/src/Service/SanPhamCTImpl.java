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
        String sql = "SELECT SanPhamCT.idSP,SanPhamCT.maSP,tenSP,tenThuongHieu,LoaiSP,tenSize,tenChatLieu,tenMauSac,giaNhap,gia,soLuong, ngayNhap, trangThai \n"
                + "FROM SanPhamCT INNER JOIN \n"
                + " SanPham ON SanPham.maSP = SanPhamCT.maSP INNER JOIN \n "
                + " ThuongHieu on ThuongHieu.idThuongHieu = SanPhamCT.idThuongHieu INNER JOIN \n"
                + " Size on Size.idSize = SanPhamCT.idSize INNER JOIN \n"
                + "MauSac on MauSac.idMauSac = SanPhamCT.idMauSac INNER JOIN \n "
                + " ChatLieu on ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN \n"
                + "LichSuGia on LichSuGia.idSP = SanPhamCT.idSP \n"  //Do cái lsg này nên k load được 1 sp nữa lên table này
                + "WHERE SanPhamCT.trangThai = N'Hoạt động'and LichSuGia.ngayKetThuc ='NULL' ";

        try {
            Connection conn = DBconnect.getConnection();
//            ps.setString(1, trangThai);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();

                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setThuongHieu(rs.getString(4));
                spct.setLoaiSP(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setChatLieu(rs.getString(7));
                spct.setMauSac(rs.getString(8));
                spct.setGiaNhap(rs.getDouble(9));
                spct.setGiaBan(rs.getDouble(10));
                spct.setSoLuong(rs.getInt(11));
                spct.setNgayNhap(rs.getString(12));
                spct.setTrangThai(rs.getString(13));

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

    @Override
    public void updateSanPhamCT(int soLuong, int idSP) {
        try {
            String sql = "UPDATE SanPhamCT\n"
                    + "SET       soLuong =?\n"
                    + "WHERE (idSP=?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setDouble(2, idSP);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateSanPhamCTSauMua(int idSPCT, int soLuongCon) {
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
            String sql = "INSERT INTO SanPhamCT\n" +
"                 (maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)\n" +
"VALUES  (?,?,?,?,?,?,?,?,?)";
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
            String sql="SELECT  idSP\n" +
"FROM      SanPhamCT\n" +
"WHERE   (maSP =?) and\n" +
"                 (loaiSP=?) and (idThuongHieu=?) and(idMauSac=?) and(idSize=?) and(idChatLieu=?)";
            Connection conn =(Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, loaiSP);
            ps.setInt(3, idTH);
            ps.setInt(4, idMS);
            ps.setInt(5, idSize);
            ps.setInt(6, idCL);
            
            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {                
                SanPhamCT spct =new SanPhamCT();
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
    public List<SanPhamCT> searchSP(String key) {
        listspct.clear();
        String sql = "SELECT SanPhamCT.idSP,SanPhamCT.maSP,tenSP,tenThuongHieu,LoaiSP,tenSize,tenChatLieu,tenMauSac,giaNhap,gia,soLuong, ngayNhap, trangThai \n"
                + "FROM SanPhamCT INNER JOIN \n"
                + " SanPham ON SanPham.maSP = SanPhamCT.maSP INNER JOIN \n "
                + " ThuongHieu on ThuongHieu.idThuongHieu = SanPhamCT.idThuongHieu INNER JOIN \n"
                + " Size on Size.idSize = SanPhamCT.idSize INNER JOIN \n"
                + "MauSac on MauSac.idMauSac = SanPhamCT.idMauSac INNER JOIN \n "
                + " ChatLieu on ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN \n"
                + "LichSuGia on LichSuGia.idSP = SanPhamCT.idSP "  //Do cái lsg này nên k load được 1 sp nữa lên table này
                + "WHERE SanPhamCT.trangThai = N'Hoạt động' and (SanPhamCT.maSP =?)";

        try {
            Connection conn = DBconnect.getConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,key);
            
            
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setThuongHieu(rs.getString(4));
                spct.setLoaiSP(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setChatLieu(rs.getString(7));
                spct.setMauSac(rs.getString(8));
                spct.setGiaNhap(rs.getDouble(9));
                spct.setGiaBan(rs.getDouble(10));
                spct.setSoLuong(rs.getInt(11));
                spct.setNgayNhap(rs.getString(12));
                spct.setTrangThai(rs.getString(13));

                listspct.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listspct;
    }

}
