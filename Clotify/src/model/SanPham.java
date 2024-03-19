/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ZznamnhizZ
 */
public class SanPham {
        String maSP;
    String tenSP;
    Date ngayNhap;
    String maNV;
    Integer idSP;
    String loaiSP;
    Integer soLuong;
    Double giaNhap;
    Double giaBan;
    String trangThai;
    Integer idMauSac;
    Integer idSize;
    Integer idThuongHieu;
    Integer idChatLieu;
    String maThuongHieu;
    String tenThuongHieu;
    String noteThuongHieu;
    String maMauSac;
    String tenMauSac;
    String noteMauSac;
    String maSize;
    String tenSize;
    String noteSize;
    String maChatLieu;
    String tenChatLieu;
    String noteChatLieu;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, Date ngayNhap, String maNV, Integer idSP, String loaiSP, Integer soLuong, Double giaNhap, Double giaBan, String trangThai, Integer idMauSac, Integer idSize, Integer idThuongHieu, Integer idChatLieu, String maThuongHieu, String tenThuongHieu, String noteThuongHieu, String maMauSac, String tenMauSac, String noteMauSac, String maSize, String tenSize, String noteSize, String maChatLieu, String tenChatLieu, String noteChatLieu) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
        this.idSP = idSP;
        this.loaiSP = loaiSP;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
        this.noteThuongHieu = noteThuongHieu;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.noteMauSac = noteMauSac;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.noteSize = noteSize;
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.noteChatLieu = noteChatLieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
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

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public Integer getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(Integer idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public Integer getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(Integer idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getNoteThuongHieu() {
        return noteThuongHieu;
    }

    public void setNoteThuongHieu(String noteThuongHieu) {
        this.noteThuongHieu = noteThuongHieu;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getNoteMauSac() {
        return noteMauSac;
    }

    public void setNoteMauSac(String noteMauSac) {
        this.noteMauSac = noteMauSac;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getNoteSize() {
        return noteSize;
    }

    public void setNoteSize(String noteSize) {
        this.noteSize = noteSize;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getNoteChatLieu() {
        return noteChatLieu;
    }

    public void setNoteChatLieu(String noteChatLieu) {
        this.noteChatLieu = noteChatLieu;
    }
    
    
}
