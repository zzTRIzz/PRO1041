/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.SanPhamService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import java.sql.*;

/**
 *
 * @author Ngo Nhan
 */
public class SanPhamImpl implements SanPhamService{
    List<SanPham> listSanPham = new ArrayList<>();
    @Override
    public void addSanPham(SanPham sp) {
        try {
            String sql = "INSERT INTO SanPham\n" +
"                 (maSP, tenSP, ngayNhap, maNV)\n" +
"VALUES  (?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getNgayNhap());
            ps.setString(4, sp.getMaNV());

            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPham> searchSanPham(String maSP) {
        listSanPham.clear();
        try {
            String sql="SELECT  SanPham.maSP, SanPham.tenSP, SanPham.ngayNhap, NhanVien.tenNV\n" +
"FROM      SanPham INNER JOIN\n" +
"                 NhanVien ON SanPham.maNV = NhanVien.maNV\n" +
"WHERE   (maSP = ?)";
            Connection conn =(Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {                
                SanPham sp =new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setNgayNhap(rs.getString(3));
                sp.setTenNV(rs.getString(4));
                listSanPham.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    @Override
    public List<SanPham> getSPAll() {
          listSanPham.clear();
        try {
            String sql="SELECT  SanPham.maSP, SanPham.tenSP, SanPham.ngayNhap, NhanVien.tenNV\n"
                    + "FROM      SanPham INNER JOIN\n"
                    + "                 NhanVien ON SanPham.maNV = NhanVien.maNV";
            Connection conn =(Connection) DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while (rs.next()) {                
                SanPham sp =new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setNgayNhap(rs.getString(3));
                sp.setTenNV(rs.getString(4));
                listSanPham.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    @Override
    public SanPham getRow(int row) {
        return listSanPham.get(row);
    }
    
}
