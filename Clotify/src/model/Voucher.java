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
    String maVC,tenVC,ghiChu,maNV;
    
    Double dkAD,giamTheoGia;

    

    public Voucher() {
    }
     
    public Voucher(String maVC, String tenVC, String ghiChu, String maNV, Double dkAD, Double giamTheoGia) {
        this.maVC = maVC;
        this.tenVC = tenVC;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
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
