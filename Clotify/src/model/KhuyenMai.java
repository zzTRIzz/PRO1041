/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class KhuyenMai {
    String maKM,tenKM,ngayTao,ngayKetThuc,trangThai,maNV,tenNV;
    int giamTheoGia,giamTheoPT;
    double mucApDung;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String ngayTao, String ngayKetThuc, String trangThai, String maNV, String tenNV, int giamTheoGia, int giamTheoPT, double mucApDung) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.tenNV = tenNV;
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
    
}
