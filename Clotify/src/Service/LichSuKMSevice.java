/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.LichSuKM;
import java.sql.*;
/**
 *
 * @author Ngo Nhan
 */
public class LichSuKMSevice {
    List<LichSuKM> listLS =new ArrayList<>();
    public List<LichSuKM> getLSKM(String maKM){
        listLS.clear();
        try {
           String sql = "SELECT  idLS, maKM, ngayBatDau, ngayKetThuc, phanTramGiam\n" +
"FROM      LichSuKM where maKM=?";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKM);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {                
                LichSuKM lsKm = new LichSuKM();
                lsKm.setIdLS(rs.getInt(1));
                lsKm.setMaKM(rs.getString(2));
                lsKm.setNgayBatDau(rs.getString(3));
                lsKm.setNgayKetThuc(rs.getString(4));
                lsKm.setPhanTramKM(rs.getInt(5));
                listLS.add(lsKm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLS;
        
    }
    public void addLSKM(LichSuKM ls){
            String sql = "INSERT INTO LichSuKM\n" +
"                 (maKM, ngayBatDau, ngayKetThuc, phanTramGiam)\n" +
"VALUES  (?,?,?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ls.getMaKM());
            stm.setString(2, ls.getNgayBatDau());
            stm.setString(3, ls.getNgayKetThuc());
            stm.setInt(4, ls.getPhanTramKM());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    public void updateLSKM(String batDauNew, String ketThucNew,int phanTramNew,String maKM,String batDauOld, String ketThucOld ) {
        String sql = "UPDATE  LichSuKM\n" +
"SET          ngayBatDau =?, ngayKetThuc =?, phanTramGiam =?\n" +
"WHERE   maKM =? and ngayBatDau =? and ngayKetThuc =?  ";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, batDauNew);
            stm.setString(2, ketThucNew);
            stm.setInt(3, phanTramNew);
            stm.setString(4, maKM);
            stm.setString(5, batDauOld);
            stm.setString(6, ketThucOld);
            
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
