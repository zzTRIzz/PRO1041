/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
/**
 *
 * @author THE PC
 */
public class NhanVienService {
    private List<NhanVien>ListNV;
    private Connection con = null;
    private PreparedStatement ps =null;
    private ResultSet rs =null;
    private String sql=null;
    public List<NhanVien>getAll(){
        ListNV= new ArrayList<>();
        sql="SELECT maNV,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,vaiTro FROM NhanVien";
        try {
            con=DBconnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getString(9));
                ListNV.add(nv);
            }
            return ListNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
