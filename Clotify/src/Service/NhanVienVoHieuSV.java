/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author THE PC
 */
public class NhanVienVoHieuSV {

    private List<NhanVien> disabledEmployees;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<NhanVien> getDisabledEmployees() {
        disabledEmployees = new ArrayList<>();

        sql = "SELECT maNV,vaiTro,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,email,trangThai FROM NhanVien Where trangThai=0";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                disabledEmployees.add(nv);

            }
            return disabledEmployees;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    
    
    public int khoiPhucTrangThaiHoatDong(String ma) {
        sql = "UPDATE NhanVien SET trangThai=1 WHERE  maNV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
