/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.ThuocTinhImpl;
import java.util.ArrayList;
import java.util.List;
import model.ThuongHieu;
import model.ChatLieu;
import model.Size;
import model.MauSac;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ZznamnhizZ
 */
public class ThuocTinhService implements ThuocTinhImpl {

    List<ThuongHieu> listTH = new ArrayList<>();
    List<ChatLieu> listCL = new ArrayList<>();
    List<Size> listSize = new ArrayList<>();
    List<MauSac> listMS = new ArrayList<>();

    @Override
    public List<MauSac> getAllMs(String trangThaiTT) {
        listMS.clear();
        String sql = "Select idMauSac,maMauSac,tenMauSac from MauSac where ghiChu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThaiTT);
            ResultSet rs = stm.executeQuery();
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
    public List<ThuongHieu> getAllTh(String trangThaiTT) {
        listTH.clear();
        String sql = "Select idThuongHieu,maThuongHieu,tenThuongHieu from ThuongHieu where ghiChu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThaiTT);
            ResultSet rs = stm.executeQuery();
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
    public List<ChatLieu> getAllCl(String trangThaiTT) {
        listCL.clear();
        String sql = "Select idChatLieu,maChatLieu,tenChatLieu from ChatLieu where ghiChu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThaiTT);
            ResultSet rs = stm.executeQuery();
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
    public List<Size> getAllSize(String trangThaiTT) {
        listSize.clear();
        String sql = "Select idSize,maSize,tenSize from Size where ghiChu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThaiTT);
            ResultSet rs = stm.executeQuery();
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

    @Override
    public void addMauSac(MauSac ms) {
        listMS.clear();
        String sql = "Insert into MauSac(tenMauSac,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, ms.getTenMS());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addThuongHieu(ThuongHieu th) {
        listTH.clear();
        String sql = "Insert into ThuongHieu(tenThuongHieu,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, th.getTenTH());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addChatLieu(ChatLieu cl) {
        listCL.clear();
        String sql = "Insert into ChatLieu(tenChatLieu,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, cl.getTenCL());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addSize(Size s) {
        listSize.clear();
        String sql = "Insert into Size(tenSize,ghiChu)"
                + "Values(?,?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, s.getTenSize());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public MauSac getMS(String tenMS) {
        MauSac ms = new MauSac();
        String sql = "Select idMauSac,maMauSac,tenMauSac from MauSac where tenMauSac =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenMS);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                ms.setIdMS(rs.getInt(1));
                ms.setMaMS(rs.getString(2));
                ms.setTenMS(rs.getString(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    @Override
    public ThuongHieu getTH(String tenTH) {
        ThuongHieu th = new ThuongHieu();
        String sql = "Select idThuongHieu,maThuongHieu,tenThuongHieu from ThuongHieu where tenThuongHieu=?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenTH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                th.setIdTH(rs.getInt(1));
                th.setMaTH(rs.getString(2));
                th.setTenTH(rs.getString(3));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return th;
    }

    @Override
    public ChatLieu getCL(String tenCL) {
        ChatLieu cl = new ChatLieu();
        String sql = "Select idChatLieu,maChatLieu,tenChatLieu from ChatLieu where tenChatLieu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenCL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                cl.setIdCL(rs.getInt(1));
                cl.setMaCL(rs.getString(2));
                cl.setTenCL(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public Size getSize(String tenSize) {
        Size size = new Size();
        String sql = "Select idSize,maSize,tenSize from Size where tenSize=?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                size.setIdSize(rs.getInt(1));
                size.setMaSize(rs.getString(2));
                size.setTenSize(rs.getString(3));              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public MauSac getRowMS(int row) {
        return listMS.get(row);
    }

    @Override
    public ThuongHieu getRowTH(int row) {
        return listTH.get(row);
    }

    @Override
    public ChatLieu getRowCL(int row) {
        return listCL.get(row);
    }

    @Override
    public Size getRowSize(int row) {
        return listSize.get(row);
    }

    @Override
    public void updateMS(int idTT, String ghiChu) {
        String sql = "UPDATE  MauSac\n" +
"SET          ghiChu =?\n" +
"WHERE   ( idMauSac=?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ghiChu);
            ps.setInt(2, idTT);
            ps.executeUpdate();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTH(int idTT, String ghiChu) {
        String sql = "UPDATE  ThuongHieu\n" +
"SET          ghiChu =?\n" +
"WHERE   ( idThuongHieu=?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ghiChu);
            ps.setInt(2, idTT);
            ps.executeUpdate();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCL(int idTT, String ghiChu) {
        String sql = "UPDATE  ChatLieu\n" +
"SET          ghiChu =?\n" +
"WHERE   ( idChatLieu=?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ghiChu);
            ps.setInt(2, idTT);
            ps.executeUpdate();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSize(int idTT, String ghiChu) {
        String sql = "UPDATE  Size\n" +
"SET          ghiChu =?\n" +
"WHERE   ( idSize=?)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ghiChu);
            ps.setInt(2, idTT);
            ps.executeUpdate();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MauSac> getListMS(String tenMS) {
        listMS.clear();
        String sql = "Select idMauSac,maMauSac,tenMauSac from MauSac where tenMauSac =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenMS);
            ResultSet rs = stm.executeQuery();
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
    public List<ThuongHieu> getListTH(String tenTH) {
        listTH.clear();
        String sql = "Select idThuongHieu,maThuongHieu,tenThuongHieu from ThuongHieu where tenThuongHieu=?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenTH);
            ResultSet rs = stm.executeQuery();
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
    public List<ChatLieu> getListCL(String tenCL) {
        listCL.clear();
        String sql = "Select idChatLieu,maChatLieu,tenChatLieu from ChatLieu where tenChatLieu =?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenCL);
            ResultSet rs = stm.executeQuery();
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
    public List<Size> getListSize(String tenSize) {
        listSize.clear();
        String sql = "Select idSize,maSize,tenSize from Size where tenSize=?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenSize);
            ResultSet rs = stm.executeQuery();
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

}
