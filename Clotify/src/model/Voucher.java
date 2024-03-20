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
    Integer pTram;
    Double dkAD;

    public Voucher() {
    }

    public Voucher(String maVC, String tenVC, String ghiChu, String maNV, Integer pTram, Double dkAD) {
        this.maVC = maVC;
        this.tenVC = tenVC;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.pTram = pTram;
        this.dkAD = dkAD;
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

    public Integer getpTram() {
        return pTram;
    }

    public void setpTram(Integer pTram) {
        this.pTram = pTram;
    }

    public Double getDkAD() {
        return dkAD;
    }

    public void setDkAD(Double dkAD) {
        this.dkAD = dkAD;
    }




    
}
