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

    int idSPKM,idSP;
    String maKM,tenKM,ngayTao,ngayKetThuc,trangThai,maNV,tenNV,tenSP,mauSac,chatLieu,thuongHieu,size,loaiSP, maSP,trangThaiSPKM;
    int giamTheoGia,giamTheoPT;
    double mucApDung;

    public SanPhamKM() {
    }

    public SanPhamKM(int idSP, String maKM, String trangThaiSPKM) {
        this.idSP = idSP;
        this.maKM = maKM;
        this.trangThaiSPKM = trangThaiSPKM;
    }

    public SanPhamKM(int idSPKM, int idSP, String maKM, String mauSac, String chatLieu, String thuongHieu, String size, String loaiSP, String maSP, String trangThaiSPKM) {
        this.idSPKM = idSPKM;
        this.idSP = idSP;
        this.maKM = maKM;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.size = size;
        this.loaiSP = loaiSP;
        this.maSP = maSP;
        this.trangThaiSPKM = trangThaiSPKM;
    }

    public SanPhamKM(int idSPKM, int idSP, String maKM, String tenKM, String ngayTao, String ngayKetThuc, String trangThai, String maNV, String tenNV, String tenSP, String mauSac, String chatLieu, String thuongHieu, String size, String loaiSP, String maSP, String trangThaiSPKM, int giamTheoGia, int giamTheoPT, double mucApDung) {
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
        this.loaiSP = loaiSP;
        this.maSP = maSP;
        this.trangThaiSPKM = trangThaiSPKM;
        this.giamTheoGia = giamTheoGia;
        this.giamTheoPT = giamTheoPT;
        this.mucApDung = mucApDung;
    }

    public int getIdSPKM() {
        return idSPKM;
    }

    public void setIdSPKM(int idSPKM) {
        this.idSPKM = idSPKM;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
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

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTrangThaiSPKM() {
        return trangThaiSPKM;
    }

    public void setTrangThaiSPKM(String trangThaiSPKM) {
        this.trangThaiSPKM = trangThaiSPKM;
    }

    public int getGiamTheoGia() {
        return giamTheoGia;
    }

    public void setGiamTheoGia(int giamTheoGia) {
        this.giamTheoGia = giamTheoGia;
    }

    public int getGiamTheoPT() {
        return giamTheoPT;
    }

    public void setGiamTheoPT(int giamTheoPT) {
        this.giamTheoPT = giamTheoPT;
    }

    public double getMucApDung() {
        return mucApDung;
    }

    public void setMucApDung(double mucApDung) {
        this.mucApDung = mucApDung;
    }

    
}
