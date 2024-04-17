/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Interface.HoaDonService;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Surface
 */
public class HoaDonImpl implements HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();

    @Override
    public List<HoaDon> getHoaDonAll() {
        listHoaDon.clear();
        try {
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.tenNV, KhachHang.tenKH, HoaDon.trangThai,KhachHang.idKH\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV\n"
                    + "where HoaDon.trangThai =N'Chưa thanh toán' ";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setTenKH(rs.getString(5));
                hd.setTrangThai(rs.getString(6));
                hd.setIdKH(7);
                listHoaDon.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public HoaDon getRowHD(int row) {
        return listHoaDon.get(row);
    }

    @Override
    public void addHoaDon(HoaDon hd) {
        try {
            String sql = "INSERT INTO HoaDon\n"
                    + "             (ngayTao, maNV, idKH, trangThai,tongTienHD)\n"
                    + "VALUES (?,?,?,?,0)";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTao());
            ps.setString(2, hd.getMaNV());
            ps.setInt(3, hd.getIdKH());
            ps.setString(4, hd.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upDateHoaDon(HoaDon hd) {
        try {
            String sql = "UPDATE HoaDon\n"
                    + "SET  trangThai =?, maNV =?,  maVoucher =?,tongTienHD=? where idHD=?";
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMaVoucher());
            ps.setString(1, hd.getTrangThai());
            ps.setDouble(4, hd.getTongTienHD());
            ps.setInt(5, hd.getIdHD());

            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDon> Search(String key) {
        String sql = "Select idHD,maHD,ngayTao,maNV,trangThai from HoaDon where maHD like ? or maNV like ? or ngayTao like ? ";
        listHoaDon.clear();
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, "%" + key + "%");
            psm.setString(2, "%" + key + "%");
            psm.setString(3, "%" + key + "%");
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHoaDon;

    }

    @Override
    public List<HoaDon> SearchTime(java.util.Date batDau, java.util.Date ketThuc) {
        String sql = "Select idHD,maHD,ngayTao,maNV,trangThai from HoaDon where ngayTao between ? and ?";
        listHoaDon.clear();
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);

            java.sql.Date sqlStart = new java.sql.Date(batDau.getTime());
            java.sql.Date sqlEnd = new java.sql.Date(ketThuc.getTime());

            psm.setDate(1, sqlStart);
            psm.setDate(2, sqlEnd);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;

    }

    @Override
    public List<HoaDon> getAllHoaDonAdmin() {
        listHoaDon.clear();
        try {
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.maNV, HoaDon.trangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV";
//                    + "where HoaDon.trangThai =N'Chưa thanh toán' ";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));

                listHoaDon.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public void InHoaDon() {
        String filePath = "invoice1.pdf";

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Sử dụng font Consolas
            BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\consola.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 16);
            com.itextpdf.text.Font fonts = new com.itextpdf.text.Font(bf, 13);

            // Vẽ bố cục tùy chỉnh
            // Tiêu đề
            Paragraph title = new Paragraph("HÓA ĐƠN", font);
            title.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(title);

            Paragraph tenSHOP = new Paragraph("SHOP BÁN QUẦN ÁO CLOTIFY", font);
            tenSHOP.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(tenSHOP);
            Paragraph address = new Paragraph("Địa chỉ: Phúc Diễn, Bắc Từ Liêm, Hà Nội ", font);
            address.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(address);
            Paragraph SDT = new Paragraph("SĐT : 0358168699", fonts);
            SDT.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(SDT);
            
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("Mã hóa đơn     : " +"#"+1234566 +  String.format("%45s", "Ngày tạo : " +ngayTaoHD) , fonts));
            document.add(new Paragraph("Tên khách hàng : " +ten , fonts));
            document.add(new Paragraph("Số điện thoại  : " +sdt + String.format("%43s", "Địa chỉ  : " +diachi), fonts));
            document.add(new Paragraph("                                                           "));
            

            document.add(new Paragraph("-----------------------------------------------------------", font));
            // Tiêu đề cột
            Paragraph columnTitle = new Paragraph("Sản phẩm           SL         Giá bán        Thành tiền", font);
            columnTitle.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(columnTitle);
            document.add(new Paragraph("-----------------------------------------------------------", font));

            DecimalFormat formatter = new DecimalFormat("###,###.###");
            // Duyệt qua danh sách tên sản phẩm và số lượng tương ứng và thêm chúng vào tài liệu PDF
            for (int i = 0; i < tenSPList.size(); i++) {
                String tenSP = tenSPList.get(i);
                int soLuong = soluongList.get(i);
                Double gia = giaList.get(i);
                document.add(new Paragraph(String.format("%-22s", tenSP) + String.format("%-10s", soLuong) + formatter.format(gia) + String.format("%18s", formatter.format(gia * soLuong)), font));
            }
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("-----------------------------------------------------------", font));

            // Tổng cộng
            Paragraph TongTien = new Paragraph("Tổng tiền      :" + String.format("%41s", formatter.format(tienHang)), font);
            Paragraph Voucher = new Paragraph("Giảm giá       :" + String.format("%41s", "-" + formatter.format(voucher)), font);
            Paragraph Total = new Paragraph("Tiền phải trả  :" + String.format("%41s", formatter.format(tientra)), font);
            document.add(TongTien);
            document.add(Voucher);
            document.add(Total);

            // Dòng cuối cùng
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            document.add(new Paragraph("                                                           "));
            
            
            document.add(new Paragraph("**********************************************************", font));
            Paragraph thanks = new Paragraph("Cảm ơn quý khách đã tin dùng sản phẩm Clotify", fonts);
            thanks.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(thanks);
            Paragraph nhom = new Paragraph("Phát triển bởi nhóm 5", fonts);
            nhom.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(nhom);
            document.add(new Paragraph("**********************************************************", font));
            
            
            Paragraph luuy = new Paragraph("Lưu ý : Quý khách có thể đổi trả hàng trong 7 ngày nếu sản phẩm bị lỗi", fonts);
            luuy.setAlignment(Element.ALIGN_CENTER); // Căn giữa
            document.add(luuy);

            document.close();

            System.out.println("In xong");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String ten, sdt, diachi;
    public static List<String> tenSPList = new ArrayList<>();
    public static List<Integer> soluongList = new ArrayList<>();
    public static List<Double> giaList = new ArrayList<>();
    public static Double tienHang, tientra, voucher;
    public static Date ngayTaoHD;

    @Override
    public void DataInHoaDon(Integer mahoadon) {
        tenSPList.clear();
        soluongList.clear();
        giaList.clear();
        tienHang = null;
        String sql = "SELECT HoaDon.maHD, HoaDon.ngayTao, SanPham.tenSP, HoaDonChiTiet.soLuongMua, HoaDonChiTiet.tongTien, HoaDonChiTiet.tongTien / HoaDonChiTiet.soLuongMua AS GiaBan, HoaDon.tongTienHD + COALESCE (Voucher.giamTheoGia, 0) \n"
                + "                  AS TienHang, Voucher.maVoucher, COALESCE (Voucher.giamTheoGia, 0) AS GiamGia, HoaDon.tongTienHD, KhachHang.tenKH, KhachHang.sdt, KhachHang.diaChi\n"
                + "FROM     HoaDon INNER JOIN\n"
                + "                  HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN\n"
                + "                  SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN\n"
                + "                  SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN\n"
                + "                  KhachHang ON HoaDon.idKH = KhachHang.idKH LEFT OUTER JOIN\n"
                + "                  Voucher ON HoaDon.maVoucher = Voucher.maVoucher\n"
                + "WHERE  HoaDon.maHD = ? ";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, mahoadon);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                //thông tin : Client
                ten = rs.getString("tenKH");
                sdt = rs.getString("sdt");
                diachi = rs.getString("diaChi");
                
                //thông tin : hóa đơn
                String tenSP = rs.getString("tenSP");
                tenSPList.add(tenSP);
                ngayTaoHD = rs.getDate("ngayTao");
                Integer sl = rs.getInt("soLuongMua");
                soluongList.add(sl);
                Double tt = rs.getDouble("GiaBan");
                giaList.add(tt);
                tienHang = rs.getDouble("TienHang");
                voucher = rs.getDouble("GiamGia");
                tientra = rs.getDouble("tongTienHD");

            }
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        HoaDonImpl hoaDonImpl = new HoaDonImpl();
        hoaDonImpl.DataInHoaDon(1234619);
        System.out.println(tenSPList);
        System.out.println(soluongList);
        System.out.println(giaList);
        hoaDonImpl.InHoaDon();
    }

    @Override
    public List<HoaDon> getHoaDon7Ngay() {
         listHoaDon.clear();
        try {
            String sql = "	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.tenNV, KhachHang.tenKH, HoaDon.trangThai,KhachHang.idKH\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN\n"
                    + "             NhanVien ON HoaDon.maNV = NhanVien.maNV\n"
                    + "WHERE HoaDon.NgayTao >= DATEADD(DAY, -7, GETDATE()) and HoaDon.trangThai != N'Chưa thanh toán' ";
            Connection conn = (Connection) DBconnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setTenKH(rs.getString(5));
                hd.setTrangThai(rs.getString(6));
                hd.setIdKH(7);
                listHoaDon.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public List<HoaDon> Search7Ngay(String keyword) {
       String sql = "SELECT idHD, maHD, ngayTao, maNV, trangThai \n" +
"FROM HoaDon \n" +
"WHERE NgayTao >= DATEADD(DAY, -7, GETDATE()) \n" +
"AND (maHD LIKE ? OR maNV LIKE ? OR CONVERT(nvarchar, ngayTao, 103) LIKE ?) and HoaDon.trangThai != N'Chưa thanh toán'";
        listHoaDon.clear();
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt(1));
                hd.setMaHD(rs.getInt(2));
                hd.setNgayTao(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setTrangThai(rs.getString(5));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHoaDon;

    }

    @Override
    public void updateTrangThai(HoaDon hd) {
        String sql = "Update HoaDon set trangThai = ? where idHD = ?";
        try{
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "Trả hàng");
            stm.setInt(2, hd.getIdHD());
            stm.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
