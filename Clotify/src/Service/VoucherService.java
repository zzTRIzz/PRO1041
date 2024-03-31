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
    public List<Voucher> getVoucher(){
        list.clear();
        try{
            String sql = " SELECT maVoucher, tenVoucher, dkApDung, giamTheoGia, ghiChu\n" +
"FROM   Voucher";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Voucher voucher = new Voucher();
                voucher.setMaVC(rs.getString(1));
                voucher.setTenVC(rs.getString(2));
                voucher.setDkAD(rs.getDouble(3));
                voucher.setGiamTheoGia(rs.getDouble(4));
                voucher.setGhiChu(rs.getString(5));
                list.add(voucher);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public Voucher getRow(int row){
        return list.get(row);
    }
    public boolean addVoucher(Voucher voucher){
        String sql = "insert into Voucher(maVoucher,tenVoucher,dkApDung,giamTheoGia,ghiChu) values (?,?,?,?,?)";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, voucher.getMaVC());
            stm.setString(2, voucher.getTenVC());
            stm.setDouble(3, voucher.getDkAD());
            stm.setDouble(4, voucher.getGiamTheoGia());
            stm.setString(5, voucher.getGhiChu());
            stm.executeUpdate();
            conn.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void updateVoucher(Voucher voucher){
        String sql = "update Voucher set tenVoucher = ?, dkApDung = ?,giamTheoGia = ?, ghiChu = ? where maVoucher = ?";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, voucher.getTenVC());
            stm.setDouble(2, voucher.getDkAD());
            stm.setDouble(3, voucher.getGiamTheoGia());
            stm.setString(4, voucher.getGhiChu());
            stm.setString(5, voucher.getMaVC());
            stm.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
