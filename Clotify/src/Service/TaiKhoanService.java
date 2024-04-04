/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import raven.toast.*;
import gui.admin.Main_admin;
import gui.admin.login;
import gui.nhanvien.Main_NhanVien;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.ThongTinNhanVien;

/**
 *
 * @author ADMIN
 */
//by Tri
public class TaiKhoanService {

    public static String maNV, tenNV; // trả về mã và name

    public static String layThongTin_maNV() {
        return maNV;
    }

    public static String layThongTin_tenNV() {
        return tenNV;
    }

    public boolean dangnhap(String usename, String password) {
        String sql = "SELECT taiKhoan, matKhau, vaiTro, maNV, tenNV FROM NhanVien WHERE taiKhoan = ? and matKhau = ? and trangThai = 1";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, usename);
            stm.setString(2, password);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                String vaitro = resultSet.getString("vaiTro").trim();
                maNV = resultSet.getString("maNV").trim();
                tenNV = resultSet.getString("tenNV").trim();
                if (vaitro.equals("1")) {
                    Main_admin main_admin = new Main_admin();
                    main_admin.setVisible(true);
                    main_admin.setLocationRelativeTo(null);
                    Notifications.getInstance().setJFrame(main_admin);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Đăng nhập thành công với tài khoản admin");
                    return true;
                } else if (vaitro.equals("0")) {
                    Main_NhanVien main_NhanVien = new Main_NhanVien();
                    main_NhanVien.setVisible(true);
                    main_NhanVien.setLocationRelativeTo(null);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Đăng nhập thành công với tài khoản nhân viên");
                    return true;
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_CENTER, "Đăng nhập thất bại");

                }
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean timkiemGmail(String mail) {
        String sql = "SELECT taiKhoan, matKhau, vaiTro, email\n"
                + "FROM NhanVien WHERE email = ?";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, mail);
            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                String columnGmail = resultSet.getString("email");
                guiXacNhanOTP_to(columnGmail);
                conn.close();
                return true;
            } else {
                System.out.println("Email : khong ton tai trong csdl.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean guiXacNhanOTP_to(String to) {
        to = to.trim();
        final String from = "tringuyenquoc15102004@gmail.com";
        final String password = "nhej ckwm cglr zqyr";
//        final String to = "trinqph45719@gmail.com";
//        final String to = "bienndph45718@fpt.edu.vn";

        // Properties: khai bao thuoc tinh
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        };

        //Phiên làm việc
        Session session = Session.getInstance(props, auth);

        //Gửi email
        //Tạo tin nhắn
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset = UTF-8");

            //Người gửi
            msg.setFrom(from);

            //Người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            //Tiêu đề email
            msg.setSubject(otp + " " + " là mã khôi phục tài khoản Clotify của bạn");

            //Quy định ngày gửi
            msg.setSentDate(new java.util.Date());

            //Nội dung 
            //msg.setText("Đây là email gửi từ Java","UTF-8");
            msg.setContent("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "  <meta charset=\"UTF-8\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "  <title>Document</title>\n"
                    + "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                    + "  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                    + "  <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap\" rel=\"stylesheet\">\n"
                    + "  <style>\n"
                    + "    body {\n"
                    + "      font-family: 'Inter', sans-serif;\n"
                    + "    }\n"
                    + "  </style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "  <div style=\"min-width: 1000px; overflow: auto; line-height: 2;\">\n"
                    + "    <div style=\"margin: 50px auto; width: 70%; padding: 20px 0;\">\n"
                    + "      <div style=\"border-bottom: 1px solid #eee;\">\n"
                    + "        <a href=\"\" style=\"font-size: 1.2em; color: #2365d0; text-decoration: none; font-weight: bold;\">Quản lý tài khoản\n"
                    + "          Clotify</a>\n"
                    + "      </div>\n"
                    + "      <p style=\"font-size: 1em;\">Xin chào, chúng tôi đã nhận được yêu cầu đặt lại mật khẩu.</p>\n"
                    + "      <p style=\"font-size: 1em;\"><b>Lưu ý:</b> Mã OTP này nhằm mục đích thay đổi mật khẩu của tài khoản phần mềm quản lý\n"
                    + "        của hàng Clotify. Vui lòng không tiết lộ với người khác. Nhập mã dưới đây:</p>\n"
                    + "      <h2\n"
                    + "        style=\"background: #e1eefb; margin: 0 auto; width: max-content; padding: 0px 10px; color: #161616; border-radius: 5px; box-shadow: 0 0 0 1px #1877f2; font-size: 1.3em; font-weight: bold;\">\n"
                    + otp
                    + "      </h2>\n"
                    + "      <br>\n"
                    + "      <hr style=\"border: none; border-top: 1px solid #eee;\">\n"
                    + "      <div style=\"float: right; padding: 8px 0; color: #aaa; font-size: 0.9em; line-height: 1; font-weight: 300;\">\n"
                    + "        <p>Phần mềm quản lý cửa hàng quần áo Clotify</p>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</body>\n"
                    + "</html>", "text/html; charset=UTF-8");
            //Gửi email
            Transport.send(msg);

            System.out.println("Send email successfull");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public boolean ChangeMatKhatLogin(String password, String email) {
        String sql = "update NhanVien set matKhau = ? where email = ? ";
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, email);
            stm.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String generateRaOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return otp.toString();
    }
    public static String otp = generateRaOTP(6);

//    public static String getOTP(){
//    return otp;
//};
    public static void main(String[] args) {
        TaiKhoanService taiKhoanService = new TaiKhoanService();
//        taiKhoanService.guiXacNhanOTP_to("trinqph45719@fpt.edu.vn");
//        taiKhoanService.timkiemGmail("trinqph45719@gmail.com");
//        ThongTinNhanVien thongTinNhanVien = new ThongTinNhanVien();
        taiKhoanService.dangnhap("admin", "12345");
        System.out.println("" + TaiKhoanService.maNV);
        ThongTinNhanVien t = new ThongTinNhanVien();
        t.setMa(TaiKhoanService.maNV);
        System.out.println(t.getMa());
    }

}
