package Service;

import static Service.TaiKhoanService.maNV;
import static Service.TaiKhoanService.tenNV;
import gui.admin.Main_admin;
import gui.nhanvien.Main_NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import raven.toast.Notifications;

/**
 *
 * @author ADMIN
 */
public class ThongKeService {

    public static Double doanhThu_TatCa() {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double doanhThu_TheoNam() {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(YEAR, -1, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double doanhThu_TheoThang() {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(MONTH, -1, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double doanhThu_TheoThang_coThamSo(int thang) {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(MONTH, ?, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, -thang);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double doanhThu_Theo7ngay() {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(DAY, -7, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double doanhThu_TheoNgay() {
        String sql = "SELECT SUM(ct.tongTien) AS DoanhThu\n"
                + "FROM HoaDonChiTiet ct\n"
                + "INNER JOIN HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(DAY, -1, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double doanhThu = resultSet.getDouble("DoanhThu");
                conn.close();
                return doanhThu;
            } else {
                System.out.println("Chưa có doanh thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Integer TongKhachHang_Theo(int ngay) {
        String sql = "SELECT COUNT(idKH) FROM KhachHang kh\n"
                + "WHERE kh.ThoiGianTao >= DATEADD(DAY, ?, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, -ngay);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Integer khach = resultSet.getInt(1);
                conn.close();
                return khach;
            } else {
                System.out.println("Không có khách");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Integer TongHoaDon_Theo(int ngay) {
        String sql = "SELECT COUNT(idHD) AS TongHoaDon FROM HoaDon hd\n"
                + "WHERE hd.ngayTao >= DATEADD(DAY, ?, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, -ngay);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Integer hd = resultSet.getInt(1);
                conn.close();
                return hd;
            } else {
                System.out.println("Không có hóa đơn nào");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static ArrayList<Date> ngay = new ArrayList<>();
    public static ArrayList<Integer> nam = new ArrayList<>();
    public static ArrayList<Number> thang = new ArrayList<>();
    public static ArrayList<Double> doanhthu = new ArrayList<>();
    public static ArrayList<Double> doanhthuthang = new ArrayList<>();

    public static void layDoanhThu_TheoNgay_LineChart() {
        ngay.clear();
        doanhthu.clear();
        String sql = "SELECT \n"
                + "    SUM(ct.tongTien) AS DoanhThu,\n"
                + "    hd.NgayTao AS Ngay\n"
                + "FROM \n"
                + "    HoaDonChiTiet ct\n"
                + "INNER JOIN  \n"
                + "    HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE \n"
                + "    hd.NgayTao >= DATEADD(MONTH, -4, GETDATE())\n"
                + "GROUP BY\n"
                + "    hd.NgayTao\n"
                + "ORDER BY \n"
                + "    hd.NgayTao;";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Date ngaySQL = rs.getDate("Ngay");
                Double doannhThuSQL = rs.getDouble("DoanhThu");
                ngay.add(ngaySQL);
                doanhthu.add(doannhThuSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void layDoanhThu_TheoThang_LineChart() {
        thang.clear();
        doanhthuthang.clear();
        String sql = "SELECT \n"
                + "    SUM(ct.tongTien) AS DoanhThu,\n"
                + "    YEAR(hd.NgayTao) AS Nam,\n"
                + "    MONTH(hd.NgayTao) AS Thang\n"
                + "FROM \n"
                + "    HoaDonChiTiet ct\n"
                + "INNER JOIN  HoaDon hd ON ct.idHD = hd.idHD\n"
                + "WHERE hd.NgayTao >= DATEADD(MONTH, -12, GETDATE())\n"
                + "GROUP BY YEAR(hd.NgayTao), MONTH(hd.NgayTao)\n"
                ;
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Integer ngaySQL = rs.getInt("Thang");
                Double doannhThuSQL = rs.getDouble("DoanhThu");
                thang.add(ngaySQL);
                doanhthuthang.add(doannhThuSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ThongKeService.ngay);
        ThongKeService.layDoanhThu_TheoThang_LineChart();
        System.out.println(ThongKeService.thang);
        System.out.println(ThongKeService.doanhthuthang);
    }
}
