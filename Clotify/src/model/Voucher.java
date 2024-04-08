/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class Voucher {
    String maVC,tenVC,ghiChu,maNV,ngayBatDau,ngayKetThuc,trangThai;
    
    Double dkAD,giamTheoGia;

    public Voucher() {
    }

    public Voucher(String maVC, String tenVC, String ghiChu, String maNV, String ngayBatDau, String ngayKetThuc, String trangThai, Double dkAD, Double giamTheoGia) {
        this.maVC = maVC;
        this.tenVC = tenVC;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.dkAD = dkAD;
        this.giamTheoGia = giamTheoGia;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getTenVC() {
        return tenVC;
    }

    public void setTenVC(String tenVC) {
        this.tenVC = tenVC;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
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

    public Double getDkAD() {
        return dkAD;
    }

    public void setDkAD(Double dkAD) {
        this.dkAD = dkAD;
    }

    public Double getGiamTheoGia() {
        return giamTheoGia;
    }

    public void setGiamTheoGia(Double giamTheoGia) {
        this.giamTheoGia = giamTheoGia;
    }

    

   


    
}
