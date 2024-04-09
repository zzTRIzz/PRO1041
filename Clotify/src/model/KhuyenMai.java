/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Surface
 */
public class KhuyenMai {
    String maKM,tenKM,trangThai,maNV,tenNV,loaiSP,ngayTao,ngayKetThuc,ngayQuyetDinh;
    int giamTheoGia,giamTheoPT;
    double mucApDung;
//    Date ngayTao,ngayKetThuc;

    public KhuyenMai() {
    }

    


    public KhuyenMai(String maKM, String tenKM, String trangThai, String maNV, String tenNV, String loaiSP, String ngayTao, String ngayKetThuc, String ngayQuyetDinh, int giamTheoGia, int giamTheoPT, double mucApDung) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.loaiSP = loaiSP;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayQuyetDinh = ngayQuyetDinh;
        this.giamTheoGia = giamTheoGia;
        this.giamTheoPT = giamTheoPT;
        this.mucApDung = mucApDung;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNgayQuyetDinh() {
        return ngayQuyetDinh;
    }

    public void setNgayQuyetDinh(String ngayQuyetDinh) {
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    public int getGiamTheoGia() {
        return giamTheoGia;
    }

    public void setGiamTheoGia(int giamTheoGia) {
        this.giamTheoGia = giamTheoGia;
    }

    public int getGiamTheoPT() {
        return giamTheoPT;
    }

    public void setGiamTheoPT(int giamTheoPT) {
        this.giamTheoPT = giamTheoPT;
    }

    public double getMucApDung() {
        return mucApDung;
    }

    public void setMucApDung(double mucApDung) {
        this.mucApDung = mucApDung;
    }
    
// private List<Integer> danhSachIdSP;
//
//    // Constructor và các phương thức khác...
//
//    public void setDanhSachIdSP(List<Integer> danhSachIdSP) {
//        this.danhSachIdSP = danhSachIdSP;
//    }
    
   
}
