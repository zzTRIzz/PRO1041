/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import raven.toast.*;
import gui.admin.Main_admin;
import gui.nhanvien.Main_NhanVien;

/**
 *
 * @author ADMIN
 */
//by Tri
public class TaiKhoanService {

    Main_admin main_admin = new Main_admin();
    Main_NhanVien main_NhanVien = new Main_NhanVien();

    public boolean dangnhap(String usename, String password) {
        String sql = "SELECT taiKhoan, matKhau, vaiTro FROM NhanVien WHERE taiKhoan = ? and matKhau = ?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, usename);
            stm.setString(2, password);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                String vaitro = resultSet.getString("vaiTro").trim();
                if (vaitro.equals("1")) {
                    main_admin.setVisible(true);
                    main_admin.setLocationRelativeTo(null);
                    Notifications.getInstance().setJFrame(main_admin);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Đăng nhập thành công với tài khoản admin");
                    return true;
                }else if (vaitro.equals("0")) {
                    main_NhanVien.setVisible(true);
                    main_NhanVien.setLocationRelativeTo(null);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Đăng nhập thành công với tài khoản nhân viên");
                    return true;
                }else{
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_CENTER,"Đăng nhập thất bại");
                   
                }
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
