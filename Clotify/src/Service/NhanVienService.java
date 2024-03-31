/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
  import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVien;
/**
 *
 * @author THE PC
 */
public class NhanVienService {
    private List<NhanVien>ListNV;
  private Connection con = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  private String sql= null;
  public  List<NhanVien>getAll(){
      ListNV= new ArrayList<>();
      sql="SELECT maNV,vaiTro,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,email,trangThai FROM NhanVien Where trangThai=1";
      
      try {
          con=DBconnect.getConnection();
          ps= con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
             NhanVien nv =new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10),rs.getString(11));
             ListNV.add(nv);
              
          }
          return  ListNV;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
 
  public int add(NhanVien nv ){
      int kq=0;
      sql="INSERT INTO NhanVien(maNV,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,vaiTro,email,trangThai) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
      try {
          con=DBconnect.getConnection();
          ps=con.prepareStatement(sql);
          ps.setString(1, nv.getMaNV());
          ps.setString(2, nv.getTenNV());
          ps.setString(3, nv.getNgaySinh());
          ps.setString(4, nv.getGioiTinh());
          ps.setString(5, nv.getDiaChi());
          ps.setString(6, nv.getSdt());
          ps.setString(7, nv.getTaiKhoan());
          ps.setString(8, nv.getMatKhau());
          ps.setString(9, nv.getVaiTro());
          ps.setString(10, nv.getEmail());
          ps.setString(11,nv.getTrangThai());
          kq=ps.executeUpdate();
          return kq;
          
      } catch (Exception e) {
          e.printStackTrace();
          return 0;
      }    
  }
    public int update(String ma, NhanVien nv) {
        sql = "UPDATE NhanVien SET tenNV=?,ngaySinh=?,gioiTinh=?,diaChi=?,sdt=?,taiKhoan=?,matKhau=?,vaiTro=?,email=?,trangThai=? WHERE  maNV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getNgaySinh());
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getTaiKhoan());
            ps.setString(7, nv.getMatKhau());
            ps.setString(8, nv.getVaiTro());
            ps.setString(9, nv.getEmail());
            ps.setString(10, nv.getTrangThai());
            ps.setString(11, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
   }
  
  public int delete(String ma){
      sql="DELETE FROM NhanVien WHERE maNV=?";
      try {
          con=DBconnect.getConnection();
          ps=con.prepareStatement(sql);
          ps.setString(1, ma);
          return ps.executeUpdate();
      } catch (Exception e) {
          e.printStackTrace();
          return 0;
      }
  }
  public List<NhanVien> timKiem(String ma) {
        ListNV = new ArrayList<>();
        sql = "SELECT maNV,vaiTro,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,email,trangThai FROM NhanVien WHERE maNV like ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv=new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11));
                ListNV.add(nv);
            }
            return ListNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  public boolean existsMa(String ma) {
    sql = "SELECT COUNT(*) FROM NhanVien WHERE maNV = ?";
    try {
        con = DBconnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, ma);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Trả về true nếu tồn tại mã nhân viên, ngược lại trả về false
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Đóng kết nối và tài nguyên
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return false;
}
    public List<Object[]> getDisabledEmployees() {
        List<Object[]> disabledEmployees = new ArrayList<>();

        try (Connection connection = DBconnect.getConnection()) {
            String sql = "SELECT maNV,vaiTro,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,email,trangThai FROM NhanVien";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[11]; // S? l??ng tr??ng d? li?u c?a nhân viên
                rowData[0] = resultSet.getInt("maNV");
                rowData[1] = resultSet.getString("vaiTro");
                rowData[2] = resultSet.getString("tenNV");
                rowData[3] = resultSet.getString("ngaySinh");
                rowData[4] = resultSet.getString("gioiTinh");
                rowData[5] = resultSet.getString("diaChi");
                rowData[6] = resultSet.getString("sdt");
                rowData[7] = resultSet.getString("taiKhoan");
                rowData[9] = resultSet.getString("matKhau");
                rowData[10] = resultSet.getString("email");
                rowData[11] = resultSet.getString("trangThai");
               

                disabledEmployees.add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return disabledEmployees;
    }
 
}
