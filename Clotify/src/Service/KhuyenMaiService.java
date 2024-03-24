/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.KhachHang;
import model.SanPhamCT;

/**
 *
 * @author Dell
 */
public class KhuyenMaiService {
    List<KhuyenMai> list = new ArrayList<>();
    public List<KhuyenMai> getKhuyenMai(){
        list.clear();
        try{
        String sql = "SELECT KhuyenMai.maKM, KhuyenMai.tenKM, KhuyenMai.ngayTao, KhuyenMai.ngayKetThuc, SanPhamCT.loaiSP, KhuyenMai.giamTheoPT, KhuyenMai.trangThai\n" +
"FROM   KhuyenMai INNER JOIN\n" +
"             SanPhamKM ON KhuyenMai.maKM = SanPhamKM.maKM INNER JOIN\n" +
"             SanPhamCT ON SanPhamKM.idSP = SanPhamCT.idSP";
        Connection conn = DBconnect.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            KhuyenMai km = new KhuyenMai();
            km.setMaKM(rs.getString(1));
            km.setTenKM(rs.getString(2));
            km.setNgayTao(rs.getDate(3));
            km.setNgayKetThuc(rs.getDate(4));
            km.setLoaiSP(rs.getString(5));

            km.setGiamTheoPT(rs.getInt(6));
            km.setTrangThai(rs.getString(7));
            list.add(km);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        return list;
    }
   
       public boolean addKhuyenMai(KhuyenMai km){
    String sql = "INSERT INTO KhuyenMai (maKM, tenKM, ngayTao, ngayKetThuc, giamTheoPT, trangThai) VALUES (?, ?, ?, ?, ?, ?)";
    try{
        Connection conn = DBconnect.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, km.getMaKM());
        stm.setString(2, km.getTenKM());
        
// Chuyển đổi ngày từ chuỗi sang đối tượng Date
//        java.sql.Date sqlBatDau = new java.sql.Date(batDau.getTime());
//           java.sql.Date sqlKetThuc = new java.sql.Date(ketThuc.getTime());
////        
////        // Đặt tham số ngày vào câu lệnh SQL
//      stm.setDate(3, new java.sql.Date(batDau.getTime()));
//       stm.setDate(4, new java.sql.Date(ketThuc.getTime()));
     stm.setDate(3, (Date) km.getNgayTao());
        stm.setDate(4, (Date) km.getNgayKetThuc());
        
        stm.setInt(5, km.getGiamTheoPT());
        stm.setString(6, km.getTrangThai());
        
        stm.executeUpdate();
        conn.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
    return false;
}
    
    public KhuyenMai getRow(int row){
        return list.get(row);
    }
    List<SanPhamCT> listSPCT = new ArrayList<>();
    public List<SanPhamCT> getSanPhamCT(){
        listSPCT.clear();
        try{
            String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPham.tenSP, Size.tenSize, MauSac.tenMauSac, ChatLieu.tenChatLieu, SanPhamCT.giaNhap\n" +
"FROM   ChatLieu INNER JOIN\n" +
"             SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n" +
"             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n" +
"             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n" +
"             SanPham ON SanPhamCT.maSP = SanPham.maSP";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setSize(rs.getString(4));
                spct.setMauSac(rs.getString(5));
                spct.setChatLieu(rs.getString(6));
                spct.setGiaBan(rs.getDouble(7));
                listSPCT.add(spct);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listSPCT;
    }
    private static java.util.Date chuyenChuoiSangDate(String ngayNhap) {
        // Chuyển đổi chuỗi thành đối tượng Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (java.util.Date) sdf.parse(ngayNhap.replace("thg", ""));
           
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void searchTheoLoaiSP(String key){
        String sql = "SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPham.tenSP, Size.tenSize, MauSac.tenMauSac, ChatLieu.tenChatLieu, SanPhamCT.giaNhap\n" +
"FROM   ChatLieu INNER JOIN\n" +
"             SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN\n" +
"             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n" +
"             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n" +
"             SanPham ON SanPhamCT.maSP = SanPham.maSP"
                + "where SanPhamCT.loaiSP like ?";
        listSPCT.clear();
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + key + "%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                SanPhamCT spct = new SanPhamCT();
                spct.setIdSP(rs.getInt(1));
                spct.setMaSP(rs.getString(2));
                spct.setTenSP(rs.getString(3));
                spct.setSize(rs.getString(4));
                spct.setMauSac(rs.getString(5));
                spct.setChatLieu(rs.getString(6));
                spct.setGiaBan(rs.getDouble(7));
                listSPCT.add(spct);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
