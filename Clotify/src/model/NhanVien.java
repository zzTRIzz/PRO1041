/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;

/**
 *
 * @author Surface
 */
public class NhanVien {
    String  maNV,vaiTro;
    String tenNV, ngaySinh,gioiTinh,diaChi,sdt,taiKhoan,matKhau, email,trangThai;

    public NhanVien() {
    }

    public NhanVien(String maNV, String vaiTro, String tenNV, String ngaySinh, String gioiTinh, String diaChi, String sdt, String taiKhoan, String matKhau, String email, String trangThai) {
        this.maNV = maNV;
        this.vaiTro = vaiTro;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", vaiTro=" + vaiTro + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", email=" + email + ", trangThai=" + trangThai + '}';
    }

    
    
    
    
    
      
    public Object[] toDataRow() {
       
        Object[] dataRow = Arrays.copyOf(new Object[]{this.maNV, this.tenNV, this.gioiTinh, this.ngaySinh, this.diaChi, this.sdt, this.taiKhoan, this.matKhau, this.vaiTro,this.email,this.trangThai}, 11);
        
        dataRow[7] = encryptMatKhau(this.matKhau);
        return dataRow;
    }

    private String encryptMatKhau(String matKhau) {
       
        return "********";
    }
    
   
}
