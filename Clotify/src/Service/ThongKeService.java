package Service;

import static Service.TaiKhoanService.maNV;
import static Service.TaiKhoanService.tenNV;
import gui.admin.Main_admin;
import gui.nhanvien.Main_NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ThongKe;
import raven.toast.Notifications;

/**
 *
 * @author ADMIN
 */
public class ThongKeService {

    public static Double doanhThu_TatCa() {
        String sql = "SELECT SUM(hd.tongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.trangThai = N'Đã thanh toán'";
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
        String sql = "SELECT SUM(hd.TongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.NgayTao >= DATEADD(YEAR, -1, GETDATE()) AND hd.trangThai = N'Đã thanh toán'";
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
        String sql = "SELECT SUM(hd.TongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.NgayTao >= DATEADD(MONTH, -1, GETDATE()) AND hd.trangThai = N'Đã thanh toán'";
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
        String sql = "SELECT SUM(hd.TongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.NgayTao >= DATEADD(MONTH, ?, GETDATE()) AND hd.trangThai = N'Đã thanh toán'";
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
        String sql = "SELECT SUM(hd.TongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.NgayTao >= DATEADD(DAY, -7, GETDATE()) AND hd.trangThai = N'Đã thanh toán'";
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
        String sql = "SELECT SUM(hd.TongTienHD) AS DoanhThu\n"
                + "FROM HoaDon hd\n"
                + "WHERE hd.NgayTao >= DATEADD(DAY, -1, GETDATE()) AND hd.trangThai = N'Đã thanh toán'";
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
    public static ArrayList<Date> ngay7 = new ArrayList<>();
    public static ArrayList<Integer> nam = new ArrayList<>();
    public static ArrayList<Date> thang = new ArrayList<>();
    public static ArrayList<Double> doanhthu = new ArrayList<>();
    public static ArrayList<Double> doanhthu7 = new ArrayList<>();
    public static ArrayList<Double> doanhthuthang = new ArrayList<>();
    public static ArrayList<Double> doanhthunam = new ArrayList<>();

    public static void layDoanhThu_TheoNgay_LineChart() {
        ngay.clear();
        doanhthu.clear();
        String sql = "SELECT \n"
                + "    SUM(hd.TongTienHD) AS DoanhThu,\n"
                + "    hd.NgayTao AS Ngay\n"
                + "FROM \n"
                + "    HoaDon hd\n"
                + "WHERE \n"
                + "    hd.NgayTao >= DATEADD(MONTH, -12, GETDATE())\n AND hd.trangThai = N'Đã thanh toán'"
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

    public static void layDoanhThu_Theo7Ngay_LineChart() {
        ngay7.clear();
        doanhthu7.clear();
        String sql = "SELECT \n"
                + "    SUM(hd.TongTienHD) AS DoanhThu,\n"
                + "    hd.NgayTao AS Ngay\n"
                + "FROM \n"
                + "    HoaDon hd\n"
                + "WHERE \n"
                + "    hd.NgayTao >= DATEADD(DAY, -7, GETDATE()) AND hd.trangThai = N'Đã thanh toán'\n"
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
                ngay7.add(ngaySQL);
                doanhthu7.add(doannhThuSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void layDoanhThu_TheoThang_LineChart() {
        thang.clear();
        doanhthuthang.clear();
        String sql = "SELECT \n"
                + "    SUM(hd.TongTienHD) AS DoanhThu,\n"
                + "    CONVERT(date, DATEFROMPARTS(YEAR(hd.ngayTao), MONTH(hd.ngayTao), 1)) AS Thang\n"
                + "FROM \n"
                + "    HoaDon hd\n"
                + "WHERE \n"
                + "     hd.NgayTao >= DATEADD(MONTH, -12, GETDATE()) AND hd.trangThai = N'Đã thanh toán'\n"
                + "GROUP BY \n"
                + "    CONVERT(date, DATEFROMPARTS(YEAR(hd.ngayTao), MONTH(hd.ngayTao), 1));";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Date ngaySQL = rs.getDate("Thang");
                Double doannhThuSQL = rs.getDouble("DoanhThu");
                thang.add(ngaySQL);
                doanhthuthang.add(doannhThuSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void layDoanhThu_TheoNam_LineChart() {
        nam.clear();
        doanhthunam.clear();
        String sql = "SELECT \n"
                + "    SUM(hd.TongTienHD) AS DoanhThu,\n"
                + "	YEAR(hd.ngayTao) AS Nam\n"
                + "FROM \n"
                + "    HoaDon hd\n"
                + "WHERE \n"
                + "    hd.NgayTao >= DATEADD(YEAR, -100, GETDATE()) AND hd.trangThai = N'Đã thanh toán'\n"
                + "GROUP BY \n"
                + "    YEAR(hd.ngayTao)";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Integer ngaySQL = rs.getInt("Nam");
                Double doannhThuSQL = rs.getDouble("DoanhThu");
                nam.add(ngaySQL);
                doanhthunam.add(doannhThuSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<ThongKe> listBanChay = new ArrayList<>();

    public List<ThongKe> getAllBanChay() {
        listBanChay.clear();
        try {
            String sql = "SELECT SanPham.maSP, SanPham.tenSP, SanPhamCT.loaiSP, SanPhamCT.soLuong, SanPhamCT.giaNhap, ChatLieu.tenChatLieu, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu, SUM(HoaDonChiTiet.soLuongMua) AS SoLuongDaBan\n"
                    + "FROM     HoaDonChiTiet INNER JOIN\n"
                    + "                  SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n"
                    + "                  SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n"
                    + "                  ChatLieu ON SanPhamCT.idChatLieu = ChatLieu.idChatLieu INNER JOIN\n"
                    + "                  MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN\n"
                    + "                  Size ON SanPhamCT.idSize = Size.idSize INNER JOIN\n"
                    + "                  ThuongHieu ON SanPhamCT.idThuongHieu = ThuongHieu.idThuongHieu\n"
                    + "GROUP BY SanPham.maSP, SanPham.tenSP, SanPhamCT.loaiSP, SanPhamCT.soLuong, SanPhamCT.giaNhap, ChatLieu.tenChatLieu, MauSac.tenMauSac, Size.tenSize, ThuongHieu.tenThuongHieu\n"
                    + "ORDER BY SUM(HoaDonChiTiet.soLuongMua) DESC";
            Connection conn = DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ThongKe k = new ThongKe();
                k.setMa(rs.getString(1));
                k.setTen(rs.getString(2));
                k.setLoai(rs.getString(3));
                k.setSo(rs.getString(4));
                k.setGia(rs.getString(5));
                k.setChatlieu(rs.getString(6));
                k.setMau(rs.getString(7));
                k.setSize(rs.getString(8));
                k.setThuonghieu(rs.getString(9));
                k.setSoluongban(rs.getString(10));
                listBanChay.add(k);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBanChay;
    }

    public static Double loinhuan_ngay() {
        String sql = "SELECT \n"
                + "       SUM(((HoaDonChiTiet.soLuongMua * LichSuGia.gia) -COALESCE(Voucher.giamTheoGia, 0)- (HoaDonChiTiet.soLuongMua * SanPhamCT.giaNhap))) AS LoiNhuan,\n"
                + "	   HoaDon.ngayTao AS ThoiGian\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD \n"
                + "INNER JOIN SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP \n"
                + "INNER JOIN SanPham ON SanPhamCT.maSP = SanPham.maSP\n"
                + "INNER JOIN LichSuGia ON LichSuGia.idSP = SanPhamCT.idSP\n"
                + "LEFT JOIN Voucher ON Voucher.maVoucher = HoaDon.maVoucher\n"
                + "WHERE HoaDon.trangThai = N'Đã thanh toán' AND HoaDon.NgayTao >= DATEADD(DAY, -1, GETDATE())\n"
                + "GROUP BY HoaDon.ngayTao";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double loinhuan = resultSet.getDouble("loiNhuan");
                conn.close();
                return loinhuan;
            } else {
                System.out.println("Chưa có lợi nhuận");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double loinhuan_7ngay() {
        String sql = "SELECT \n"
                + "       SUM(((HoaDonChiTiet.soLuongMua * LichSuGia.gia) -COALESCE(Voucher.giamTheoGia, 0)- (HoaDonChiTiet.soLuongMua * SanPhamCT.giaNhap))) AS LoiNhuan\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD \n"
                + "INNER JOIN SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP \n"
                + "INNER JOIN SanPham ON SanPhamCT.maSP = SanPham.maSP\n"
                + "INNER JOIN LichSuGia ON LichSuGia.idSP = SanPhamCT.idSP\n"
                + "LEFT JOIN Voucher ON Voucher.maVoucher = HoaDon.maVoucher\n"
                + "WHERE HoaDon.trangThai = N'Đã thanh toán' AND HoaDon.NgayTao >= DATEADD(DAY, -7, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double loinhuan = resultSet.getDouble("loiNhuan");
                conn.close();
                return loinhuan;
            } else {
                System.out.println("Chưa có lợi nhuận");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Double loinhuan_thang() {
        String sql = "SELECT \n"
                + "       SUM(((HoaDonChiTiet.soLuongMua * LichSuGia.gia) -COALESCE(Voucher.giamTheoGia, 0)- (HoaDonChiTiet.soLuongMua * SanPhamCT.giaNhap))) AS LoiNhuan\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD \n"
                + "INNER JOIN SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP \n"
                + "INNER JOIN SanPham ON SanPhamCT.maSP = SanPham.maSP\n"
                + "INNER JOIN LichSuGia ON LichSuGia.idSP = SanPhamCT.idSP\n"
                + "LEFT JOIN Voucher ON Voucher.maVoucher = HoaDon.maVoucher\n"
                + "WHERE HoaDon.trangThai = N'Đã thanh toán' AND HoaDon.NgayTao >= DATEADD(MONTH, -1, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double loinhuan = resultSet.getDouble("loiNhuan");
                conn.close();
                return loinhuan;
            } else {
                System.out.println("Chưa có lợi nhuận");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static Double loinhuan_nam() {
        String sql = "SELECT \n"
                + "       SUM(((HoaDonChiTiet.soLuongMua * LichSuGia.gia) -COALESCE(Voucher.giamTheoGia, 0)- (HoaDonChiTiet.soLuongMua * SanPhamCT.giaNhap))) AS LoiNhuan\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD \n"
                + "INNER JOIN SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP \n"
                + "INNER JOIN SanPham ON SanPhamCT.maSP = SanPham.maSP\n"
                + "INNER JOIN LichSuGia ON LichSuGia.idSP = SanPhamCT.idSP\n"
                + "LEFT JOIN Voucher ON Voucher.maVoucher = HoaDon.maVoucher\n"
                + "WHERE HoaDon.trangThai = N'Đã thanh toán' AND HoaDon.NgayTao >= DATEADD(YEAR, -1, GETDATE())";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double loinhuan = resultSet.getDouble("loiNhuan");
                conn.close();
                return loinhuan;
            } else {
                System.out.println("Chưa có lợi nhuận");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static Double loinhuan_all() {
        String sql = "SELECT \n"
                + "       SUM(((HoaDonChiTiet.soLuongMua * LichSuGia.gia) -COALESCE(Voucher.giamTheoGia, 0)- (HoaDonChiTiet.soLuongMua * SanPhamCT.giaNhap))) AS LoiNhuan\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD \n"
                + "INNER JOIN SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP \n"
                + "INNER JOIN SanPham ON SanPhamCT.maSP = SanPham.maSP\n"
                + "INNER JOIN LichSuGia ON LichSuGia.idSP = SanPhamCT.idSP\n"
                + "LEFT JOIN Voucher ON Voucher.maVoucher = HoaDon.maVoucher\n"
                + "WHERE HoaDon.trangThai = N'Đã thanh toán'";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                Double loinhuan = resultSet.getDouble("loiNhuan");
                conn.close();
                return loinhuan;
            } else {
                System.out.println("Chưa có lợi nhuận");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        ThongKeService.layDoanhThu_TheoNgay_LineChart();
        System.out.println(ThongKeService.ngay);
        ThongKeService.layDoanhThu_TheoThang_LineChart();
        System.out.println(ThongKeService.thang);
        System.out.println(ThongKeService.doanhthuthang);

//        ThongKeService.layDoanhThu_Theo7Ngay_LineChart();
//        System.out.println(ThongKeService.ngay7);
//        System.out.println(ThongKeService.doanhthu7);
    }
}
