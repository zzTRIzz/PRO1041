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
<<<<<<< Updated upstream
    int idHoaDonCT,idSP,soLuongMua,khuyeMaiGia,khuyenMaiPT;
    String tenSP;
=======
    int idHoaDonCT,idSP,soLuongMua,khuyeMaiGia,khuyenMaiPT,idHD;
    String tenSP,tenKM;
>>>>>>> Stashed changes
    double giaBan,tongTien;

    public HoaDonCT() {
    }
<<<<<<< Updated upstream

    public HoaDonCT(int idHoaDonCT, int idSP, int soLuongMua, int khuyeMaiGia, int khuyenMaiPT, String tenSP, double giaBan, double tongTien) {
=======
    public HoaDonCT(int idSP,int idHD,double tongTien,int soLuongMua){
        this.idSP = idSP;
        this.idHD = idHD;
        this.soLuongMua = soLuongMua;
        this.tongTien = tongTien;
        
    }
    public HoaDonCT(int idHoaDonCT, int idSP, int soLuongMua, int khuyeMaiGia, int khuyenMaiPT, int idHD, String tenSP, String tenKM, double giaBan, double tongTien) {
>>>>>>> Stashed changes
        this.idHoaDonCT = idHoaDonCT;
        this.idSP = idSP;
        this.soLuongMua = soLuongMua;
        this.khuyeMaiGia = khuyeMaiGia;
        this.khuyenMaiPT = khuyenMaiPT;
        this.idHD = idHD;
        this.tenSP = tenSP;
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
<<<<<<< Updated upstream
=======




>>>>>>> Stashed changes
    
}
