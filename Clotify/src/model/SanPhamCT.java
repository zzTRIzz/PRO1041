/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class SanPhamCT {
    int idSP,soLuong,idMauSac,idSize,idThuongHieu,idChatLieu;
    String maSP,loaiSP,tenSP,mauSac,size,thuongHieu,chatLieu,ngayNhap,trangThai;
    double giaNhap,giaBan;   

    public SanPhamCT() {
    }

    public SanPhamCT(int idSP, int soLuong, int idMauSac, int idSize, int idThuongHieu, int idChatLieu, String maSP, String loaiSP, String tenSP, String mauSac, String size, String thuongHieu, String chatLieu, String ngayNhap, String trangThai, double giaNhap, double giaBan) {
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.maSP = maSP;
        this.loaiSP = loaiSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.size = size;
        this.thuongHieu = thuongHieu;
        this.chatLieu = chatLieu;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
}
