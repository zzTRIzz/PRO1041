/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class KhuyenMaiService {
    List<KhuyenMai> list = new ArrayList<>();
    public List<KhuyenMai> getKhuyenMai(){
        list.clear();
        try{
        String sql = "select maKM,tenKM,giamTheoGia,giamTheoPT,ngayTao,ngayKetThuc,trangThai from KhuyenMai ";
        Connection conn = DBconnect.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            KhuyenMai km = new KhuyenMai();
            
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        return list;
    }
}
