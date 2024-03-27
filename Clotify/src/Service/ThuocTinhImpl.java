/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import model.ThuongHieu;
import model.ChatLieu;
import model.Size;
import model.MauSac;
import java.sql.*;
import javax.swing.*;
import Interface.ThuocTinhService;

/**
 *
 * @author ZznamnhizZ
 */
public class ThuocTinhImpl implements ThuocTinhService {

    List<ThuongHieu> listTH = new ArrayList<>();
    List<ChatLieu> listCL = new ArrayList<>();
    List<Size> listSize = new ArrayList<>();
    List<MauSac> listMS = new ArrayList<>();

    @Override
    public List<MauSac> getAllMs() {
        listMS.clear();
        String sql = "Select idMauSac,maMauSac,tenMauSac from MauSac";
        try {
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setIdMS(rs.getInt(1));
                ms.setMaMS(rs.getString(2));
                ms.setTenMS(rs.getString(3));
                listMS.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMS;
    }

    @Override
    public List<ThuongHieu> getAllTh() {
        listTH.clear();
        String sql = "Select idThuongHieu,maThuongHieu,tenThuongHieu from ThuongHieu";
        try {
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setIdTH(rs.getInt(1));
                th.setMaTH(rs.getString(2));
                th.setTenTH(rs.getString(3));
                listTH.add(th);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTH;
    }

    @Override
    public List<ChatLieu> getAllCl() {
        listCL.clear();
        String sql = "Select idChatLieu,maChatLieu,tenChatLieu from ChatLieu";
        try {
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setIdCL(rs.getInt(1));
                cl.setMaCL(rs.getString(2));
                cl.setTenCL(rs.getString(3));
                listCL.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCL;
    }

    @Override
    public List<Size> getAllSize() {
        listSize.clear();
        String sql = "Select idSize,maSize,tenSize from Size";
        try {
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Size size = new Size();
                size.setIdSize(rs.getInt(1));
                size.setMaSize(rs.getString(2));
                size.setTenSize(rs.getString(3));
                listSize.add(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSize;
    }

//    @Override
//    public boolean addTT(ThuongHieu th, ChatLieu cl, MauSac ms, Size s, String loaiTT) {
//        String sql;
//        if (loaiTT.equals("MauSac")) {
//            sql = "Insert into MauSac(tenMauSac,ghiChu)"
//                    + "Values(?,?)";
//            try {
//                Connection conn = DBconnect.getConnection();
//                PreparedStatement psm = conn.prepareStatement(sql);
////                psm.setInt(1, ms.getIdMS());
////                psm.setString(2, ms.getMaMS());
//                psm.setString(1, ms.getTenMS());
//                psm.setString(2, "Ghi chú màu sắc");
//                psm.executeUpdate();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//    @Override
//    public boolean addTT() {
//        String sql;
//        String loaiTT ="";
//        MauSac ms = new MauSac();
//        if (loaiTT.equals("MauSac")) {
//            sql = "Insert into MauSac(tenMauSac,ghiChu)"
//                    + "Values(?,?)";
//            try {
//                Connection conn = DBconnect.getConnection();
//                PreparedStatement psm = conn.prepareStatement(sql);
////                psm.setInt(1, ms.getIdMS());
////                psm.setString(2, ms.getMaMS());
//                psm.setString(1, ms.getTenMS());
//                psm.setString(2, "Ghi chú màu sắc");
//                psm.executeUpdate();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
    @Override
    public boolean addMauSac(MauSac ms) {
        listMS.clear();
        String sql = "Insert into MauSac(tenMauSac,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, ms.getTenMS());
            psm.setString(2, "Ghi chú màu sắc");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addThuongHieu(ThuongHieu th) {
        listTH.clear();
        String sql = "Insert into ThuongHieu(tenThuongHieu,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, th.getTenTH());
            psm.setString(2, "Ghi chú thương hiệu");
            psm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addChatLieu(ChatLieu cl) {
        listCL.clear();
        String sql = "Insert into ChatLieu(tenChatLieu,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, cl.getTenCL());
            psm.setString(2, "Ghi chú chất liệu");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addSize(Size s) {
        listSize.clear();
        String sql = "Insert into Size(tenSize,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, s.getTenSize());
            psm.setString(2, "Ghi chú size");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
