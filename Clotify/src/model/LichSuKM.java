/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngo Nhan
 */
public class LichSuKM {
    int idLS,phanTramKM;
    String maKM, ngayBatDau,ngayKetThuc;

    public LichSuKM() {
    }

    public LichSuKM(int idLS, int phanTramKM, String maKM, String ngayBatDau, String ngayKetThuc) {
        this.idLS = idLS;
        this.phanTramKM = phanTramKM;
        this.maKM = maKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getIdLS() {
        return idLS;
    }

    public void setIdLS(int idLS) {
        this.idLS = idLS;
    }

    public int getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(int phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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
    
}
