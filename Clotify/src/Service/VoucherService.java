/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.Voucher;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class VoucherService {

    List<Voucher> list = new ArrayList<>();

    public List<Voucher> getVoucher() {
        list.clear();
        try {
            String sql = "SELECT maVoucher, tenVoucher, dkApDung, giamTheoGia, ngayBatDau, ngayKetThuc, trangThai, ghiChu\n"
                    + "FROM   Voucher";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setNgayBatDau(rs.getString(5));
                voucher.setNgayKetThuc(rs.getString(6));
                voucher.setTrangThai(rs.getString(7));
                voucher.setGhiChu(rs.getString(8));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Voucher getRow(int row) {
        return list.get(row);
    }

    public boolean addVoucher(Voucher voucher) {
        String sql = "insert into Voucher(maVoucher,tenVoucher,dkApDung,giamTheoGia,ngayBatDau,ngayKetThuc,trangThai,ghiChu) values (?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, voucher.getMaVC());
            stm.setString(2, voucher.getTenVC());
            stm.setDouble(3, voucher.getDkAD());
            stm.setDouble(4, voucher.getGiamTheoGia());
            stm.setString(5, voucher.getNgayBatDau());
            stm.setString(6, voucher.getNgayKetThuc());
            stm.setString(7, voucher.getTrangThai());
            stm.setString(8, voucher.getGhiChu());
            stm.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateVoucher(Voucher voucher) {
        String sql = "update Voucher set tenVoucher = ?, dkApDung = ?,giamTheoGia = ?,ngayBatDau=?,ngayKetThuc=?,trangThai=?, ghiChu = ? where maVoucher = ?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, voucher.getTenVC());
            stm.setDouble(2, voucher.getDkAD());
            stm.setDouble(3, voucher.getGiamTheoGia());
            stm.setString(4, voucher.getNgayBatDau());
            stm.setString(5, voucher.getNgayKetThuc());
            stm.setString(6, voucher.getTrangThai());
            stm.setString(7, voucher.getGhiChu());
            stm.setString(8, voucher.getMaVC());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Voucher> searchVoucher(String key) {
        list.clear();
        String sql = "select * from Voucher where maVoucher like ? or tenVoucher like ?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + key + "%");
            stm.setString(2, "%" + key + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setNgayBatDau(rs.getString(5));
                voucher.setNgayKetThuc(rs.getString(6));
                voucher.setTrangThai(rs.getString(7));
                voucher.setGhiChu(rs.getString(8));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateTrangThaiVoucher() {
        String sql = "UPDATE Voucher \n"
                + "SET TrangThai = ? \n"
                + "WHERE NgayKetThuc < getdate() ";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,"Ngừng hoạt động");

            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateTrangThai(){
         String sql = "UPDATE Voucher \n"
                + "SET TrangThai = ? \n"
                + "WHERE ngayBatDau <= getdate() and ngayKetThuc >= getdate() ";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,"Hoạt động");

            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Voucher> searchTrangThaiVoucher(String keyword){
        list.clear();
        String sql = "select * from Voucher where trangThai = ?";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,keyword );
           
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setNgayBatDau(rs.getString(5));
                voucher.setNgayKetThuc(rs.getString(6));
                voucher.setTrangThai(rs.getString(7));
                voucher.setGhiChu(rs.getString(8));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Voucher> getVoucherHD() {
        list.clear();
        try {
            String sql = "SELECT maVoucher, tenVoucher, dkApDung, giamTheoGia, ngayBatDau, ngayKetThuc, trangThai, ghiChu\n"
                    + "FROM   Voucher where trangThai =N'Hoạt động'";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setNgayBatDau(rs.getString(5));
                voucher.setNgayKetThuc(rs.getString(6));
                voucher.setTrangThai(rs.getString(7));
                voucher.setGhiChu(rs.getString(8));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Voucher timVC(String maVC) {
        Voucher voucher = new Voucher();
        try {
            String sql = "SELECT maVoucher, tenVoucher, dkApDung, giamTheoGia, ngayBatDau, ngayKetThuc, trangThai, ghiChu\n"
                    + "FROM   Voucher where maVoucher=?";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maVC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setNgayBatDau(rs.getString(5));
                voucher.setNgayKetThuc(rs.getString(6));
                voucher.setTrangThai(rs.getString(7));
                voucher.setGhiChu(rs.getString(8));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voucher;
    }
}

