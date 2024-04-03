/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class HoaDonCT {
    int idHoaDonCT,idSP,soLuongMua,khuyeMaiGia,khuyenMaiPT,idHD;
    String tenSP,tenKM,trangThaiKM;
    double giaBan,tongTien;

    public HoaDonCT() {
    }
    public HoaDonCT(int idSP,int idHD, double tongTien, int soLuongMua){
        this.idSP = idSP;
        this.idHD = idHD;
        this.tongTien = tongTien;
        this.soLuongMua = soLuongMua;
        
    }

    public HoaDonCT(int idHoaDonCT, int idSP, int soLuongMua, int khuyeMaiGia, int khuyenMaiPT, int idHD, String tenSP, String tenKM, String trangThaiKM, double giaBan, double tongTien) {
        this.idHoaDonCT = idHoaDonCT;
        this.idSP = idSP;
        this.soLuongMua = soLuongMua;
        this.khuyeMaiGia = khuyeMaiGia;
        this.khuyenMaiPT = khuyenMaiPT;
        this.idHD = idHD;
        this.tenSP = tenSP;
        this.tenKM = tenKM;
        this.trangThaiKM = trangThaiKM;
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

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
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

    public String getTrangThaiKM() {
        return trangThaiKM;
    }

    public void setTrangThaiKM(String trangThaiKM) {
        this.trangThaiKM = trangThaiKM;
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
    
    public Integer phanTramKM(){
    int soLuong = getSoLuongMua();
    double tongTien = getTongTien();
    double giaBan = getGiaBan();
    double phanTramKM = 100 -((tongTien / (soLuong * giaBan)) * 100);
    return (int) phanTramKM;
    }
    
}
