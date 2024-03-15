/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ZznamnhizZ
 */
public class SanPham {
    Integer maSP;
    String tenSP;
    Date ngayNhap;
    String maNV;

    public SanPham() {
    }

    public SanPham(Integer maSP, String tenSP, Date ngayNhap, String maNV) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}
