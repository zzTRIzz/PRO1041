/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class HoaDon {
        int idHD,maHD,idKH;
    String ngayTao,tenNV,trangThai,maNV,maKH,tenKH,maVoucher,giaTri;

    public HoaDon() {
    }
    public HoaDon(int idKH,String ngayTao, String trangThai,String maNV){
        this.idKH = idKH;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maNV = maNV;
        
    }
        public HoaDon(int idKH,String ngayTao, String trangThai,String maNV,String maVoucher,int idHD){
        this.idKH = idKH;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.maVoucher = maVoucher;
        this.idHD = idHD;
    }
    public HoaDon(int idHD, int maHD, int idKH, String ngayTao, String tenNV, String trangThai, String maNV, String maKH, String tenKH, String maVoucher, String giaTri) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.idKH = idKH;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maVoucher = maVoucher;
        this.giaTri = giaTri;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }


    
}
