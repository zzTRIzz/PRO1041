/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Surface
 */
public class KhuyenMai {
    String maKM,tenKM,trangThai,maNV,tenNV,loaiSP;
    int giamTheoGia,giamTheoPT;
    double mucApDung;
    Date ngayTao,ngayKetThuc;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String trangThai, String maNV, String tenNV, String loaiSP, int giamTheoGia, int giamTheoPT, double mucApDung, Date ngayTao, Date ngayKetThuc) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.loaiSP = loaiSP;
        this.giamTheoGia = giamTheoGia;
        this.giamTheoPT = giamTheoPT;
        this.mucApDung = mucApDung;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

   
}
