/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THE PC
 */
public class NhanVienVoHieuSV {
    public List<Object[]> getDisabledEmployees() {
        List<Object[]> disabledEmployees = new ArrayList<>();

        try (Connection connection = DBconnect.getConnection()) {
            String sql = "SELECT maNV,vaiTro,tenNV,ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau,email,trangThai FROM NhanVien Where trangThai=0";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[11]; // S? l??ng tr??ng d? li?u c?a nhân viên
                rowData[0] = resultSet.getString("maNV");
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
