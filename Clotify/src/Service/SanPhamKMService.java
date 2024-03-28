/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.SanPhamKMInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SanPhamKM;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class SanPhamKMService implements SanPhamKMInterface{
    List<SanPhamKM> list = new ArrayList<>();
    

    @Override
    public List<SanPhamKM> getSanPhamKM() {
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
            SanPhamKM spKM = new SanPhamKM();
            spKM.setMaKM(rs.getString(1));
            spKM.setTenKM(rs.getString(2));
            spKM.setNgayTao(rs.getString(3));
           spKM.setNgayKetThuc(rs.getString(4));
            spKM.setLoaiSP(rs.getString(5));

            spKM.setGiamTheoPT(rs.getInt(6));
            spKM.setTrangThai(rs.getString(7));
            list.add(spKM);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
        return list;
    }

    @Override
    public void addSPKM(SanPhamKM spkm) {
        String sql = "INSERT INTO SanPhamKM\n" +
"             (maKM, idSP)\n" +
"VALUES (?,?)";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, spkm.getMaKM());
            stm.setInt(2, spkm.getIdSP());
            stm.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public SanPhamKM getRow(int row) {
        return list.get(row);
    }
    
}
