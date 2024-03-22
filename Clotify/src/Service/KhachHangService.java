/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Interface.KhachHangServiceimplements;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.MauSac;
import model.SanPham;
import model.SanPhamCT;
import model.Size;
import model.ThuongHieu;
/**
 *
 * @author Dell
 */
public class KhachHangService implements KhachHangServiceimplements{
    List<KhachHang> list = new ArrayList<>();
    public List<KhachHang> getKhachHang(){
        list.clear();
        try{
           String sql = "select idKH, maKH, tenKH, gioiTinh, sdt, diaChi from KhachHang"; 
           Connection conn = DBconnect.getConnection();
           Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           while(rs.next()){
               KhachHang kh = new KhachHang();
               kh.setIdKH(rs.getInt(1));
               kh.setMaKH(rs.getInt(2));
               kh.setTenKH(rs.getString(3));
               kh.setGioiTinh(rs.getString(4));
               kh.setSdt(rs.getString(5));
               kh.setDiaChi(rs.getString(6));
               list.add(kh);
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public KhachHang getRow(int row){
        return list.get(row);
    }
    
    public boolean addKhachHang(KhachHang kh){
        String sql = "insert into KhachHang(tenKH,gioiTinh,sdt,diaChi) values (?,?,?,?)";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getTenKH());
            stm.setString(2, kh.getGioiTinh());
            stm.setString(3, kh.getSdt());
            stm.setString(4, kh.getDiaChi());
            stm.executeUpdate();
            conn.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void update(KhachHang kh){
        String sql = "Update KhachHang set tenKH=?,gioiTinh=?,sdt=?,diaChi=? where idKH=? ";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getTenKH());
            stm.setString(2, kh.getGioiTinh());
            stm.setString(3, kh.getSdt());
            stm.setString(4, kh.getDiaChi());
            stm.setInt(5, kh.getIdKH());
            stm.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<KhachHang> searchKhachHang(String key){
        String sql = "select idKH, maKH,tenKH, gioiTinh, sdt, diaChi from KhachHang where maKH like ? or tenKH like ? or sdt like ?";
       list.clear();
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + key + "%");
            stm.setString(2, "%" + key + "%");
            stm.setString(3, "%" + key + "%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setIdKH(rs.getInt(1));
               kh.setMaKH(rs.getInt(2));
               kh.setTenKH(rs.getString(3));
               kh.setGioiTinh(rs.getString(4));
               kh.setSdt(rs.getString(5));
               kh.setDiaChi(rs.getString(6));
               list.add(kh);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    List<KhachHang> listChiTietKH = new ArrayList<>();
    public List<KhachHang> getChiTietKhachHang(int idKH){
        listChiTietKH.clear();
        String sql = "SELECT HoaDon.maHD, SanPhamCT.maSP,SanPham.tenSP, MauSac.tenMauSac, ChatLieu.tenChatLieu, Size.tenSize, ThuongHieu.tenThuongHieu,HoaDon.NgayTao,HoaDonChiTiet.tongTien\n" +
"FROM   KhachHang INNER JOIN\n" +
"             HoaDon ON KhachHang.idKH = HoaDon.idKH INNER JOIN\n" +
"             HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN\n" +
"             SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n" +
"             SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n" +
"             ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu INNER JOIN\n" +
"             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n" +
"             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n" +
"             ChatLieu ON SanPhamCT.idChatLieu = ChatLieu.idChatLieu where KhachHang.idKH = ?";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idKH);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
//                SanPham sp = new SanPham();
//                SanPhamCT spct = new SanPhamCT();
//                HoaDon hd = new HoaDon();
//                HoaDonCT hdct = new HoaDonCT();
//                MauSac ms = new MauSac();
//                ChatLieu cl = new ChatLieu();
//                ThuongHieu th = new ThuongHieu();
//                Size s = new Size();
                kh.setMaHD(rs.getInt(1));
                kh.setMaSP(rs.getString(2));
                kh.setTenSP(rs.getString(3));
                kh.setTenMS(rs.getString(4));
                kh.setTenCL(rs.getString(5));
                kh.setTenSize(rs.getString(6));
                kh.setTenTH(rs.getString(7));
                kh.setNgayTao(rs.getString(8));
                kh.setTongTien(rs.getDouble(9));
                listChiTietKH.add(kh);
               
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listChiTietKH;
    }
  
}
