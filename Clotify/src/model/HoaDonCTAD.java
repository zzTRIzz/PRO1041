/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ZznamnhizZ
 */
public class HoaDonCTAD {
    int idHoaDonCT, idSP, soLuongMua, khuyeMaiGia, khuyenMaiPT;
    String tenSP, tenKM, maHD, maNV, ngayTao, tenKH, ctMaSP, ctTenSP;
    double giaBan,tongTien;

    public HoaDonCTAD() {
    }

    public HoaDonCTAD(int idHoaDonCT, int idSP, int soLuongMua, int khuyeMaiGia, int khuyenMaiPT, String tenSP, String tenKM, String maHD, String maNV, String ngayTao, String tenKH, String ctMaSP, String ctTenSP, double giaBan, double tongTien) {
        this.idHoaDonCT = idHoaDonCT;
        this.idSP = idSP;
        this.soLuongMua = soLuongMua;
        this.khuyeMaiGia = khuyeMaiGia;
        this.khuyenMaiPT = khuyenMaiPT;
        this.tenSP = tenSP;
        this.tenKM = tenKM;
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.tenKH = tenKH;
        this.ctMaSP = ctMaSP;
        this.ctTenSP = ctTenSP;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
    }

    public int getIdHoaDonCT() {
        return idHoaDonCT;
    }

    public void setIdHoaDonCT(int idHoaDonCT) {
        this.idHoaDonCT = idHoaDonCT;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public int getKhuyeMaiGia() {
        return khuyeMaiGia;
    }

    public void setKhuyeMaiGia(int khuyeMaiGia) {
        this.khuyeMaiGia = khuyeMaiGia;
    }

    public int getKhuyenMaiPT() {
        return khuyenMaiPT;
    }

    public void setKhuyenMaiPT(int khuyenMaiPT) {
        this.khuyenMaiPT = khuyenMaiPT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCtMaSP() {
        return ctMaSP;
    }

    public void setCtMaSP(String ctMaSP) {
        this.ctMaSP = ctMaSP;
    }

    public String getCtTenSP() {
        return ctTenSP;
    }

    public void setCtTenSP(String ctTenSP) {
        this.ctTenSP = ctTenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
