/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.LichSuGiaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.LichSuGia;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ngo Nhan
 */
public class LichSuGiaImpl implements LichSuGiaService {
    List<LichSuGia> listLS = new ArrayList<>();
    @Override
    public void addLSGia(LichSuGia lsg) {
        try {
            String sql = "INSERT INTO LichSuGia\n"
                    + "                 (idSP, gia, ngayBatDau, ngayKetThuc)\n"
                    + "VALUES  (?,?,?,?)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lsg.getIdSP());
            ps.setDouble(2, lsg.getGiaBan());
            ps.setString(3, lsg.getNgayBatDau());
            ps.setString(4, lsg.getNgayKetThuc());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LichSuGia> listLSNull() {
        listLS.clear();
        try {
            String sql = "SELECT  idLS, idSP, gia, ngayBatDau, ngayKetThuc\n" +
"FROM      LichSuGia\n" +
"WHERE   (ngayKetThuc=NULL)";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LichSuGia lsg = new LichSuGia();
                lsg.setIdLS(rs.getInt(1));
                lsg.setIdSP(rs.getInt(2));
                lsg.setGiaBan(rs.getDouble(3));
                lsg.setNgayBatDau(rs.getString(4));
                lsg.setNgayKetThuc(rs.getString(5));               
                listLS.add(lsg);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLS;
    }
}
