/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class SanPhamKM {
    Integer idSPKM,idSP;
    String maKM,tenKM,ngayTao,ngayKetThuc,trangThai,maNV,tenNV,tenSP,mauSac,chatLieu,thuongHieu,size;
    Integer giamTheoGia,giamTheoPT;
    Double mucApDung;

    public SanPhamKM() {
    }

    public SanPhamKM(Integer idSPKM, Integer idSP, String maKM, String tenKM, String ngayTao, String ngayKetThuc, String trangThai, String maNV, String tenNV, String tenSP, String mauSac, String chatLieu, String thuongHieu, String size, Integer giamTheoGia, Integer giamTheoPT, Double mucApDung) {
        this.idSPKM = idSPKM;
        this.idSP = idSP;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.size = size;
        this.giamTheoGia = giamTheoGia;
        this.giamTheoPT = giamTheoPT;
        this.mucApDung = mucApDung;
    }

    public Integer getIdSPKM() {
        return idSPKM;
    }

    public void setIdSPKM(Integer idSPKM) {
        this.idSPKM = idSPKM;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getGiamTheoGia() {
        return giamTheoGia;
    }

    public void setGiamTheoGia(Integer giamTheoGia) {
        this.giamTheoGia = giamTheoGia;
    }

    public Integer getGiamTheoPT() {
        return giamTheoPT;
    }

    public void setGiamTheoPT(Integer giamTheoPT) {
        this.giamTheoPT = giamTheoPT;
    }

    public Double getMucApDung() {
        return mucApDung;
    }

    public void setMucApDung(Double mucApDung) {
        this.mucApDung = mucApDung;
    }


    
}
