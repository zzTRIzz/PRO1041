/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import raven.toast.*;
import gui.admin.Main_admin;
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
    
    
    
    
    
    
    public String generateRaOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return otp.toString();
    }
    
    public boolean guiXacNhanOTP_to(String to){
        String otp = generateRaOTP(6);
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
    
    public static void main(String[] args) {
        TaiKhoanService taiKhoanService =  new TaiKhoanService();
        taiKhoanService.guiXacNhanOTP_to("linhngo20032003@gmail.com");
    }
    
}
