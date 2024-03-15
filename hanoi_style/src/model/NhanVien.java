/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author THE PC
 */
public class NhanVien {
    String MaNV;
    String HoTen;
    String GioiTinh;
    String NamSinh;
    String CaLam;
    String VaiTro;
    String Luong;
    String SDT;
    String QueQuan;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, String GioiTinh, String NamSinh, String CaLam, String VaiTro, String Luong, String SDT, String QueQuan) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NamSinh = NamSinh;
        this.CaLam = CaLam;
        this.VaiTro = VaiTro;
        this.Luong = Luong;
        this.SDT = SDT;
        this.QueQuan = QueQuan;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getCaLam() {
        return CaLam;
    }

    public void setCaLam(String CaLam) {
        this.CaLam = CaLam;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getLuong() {
        return Luong;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }
    
    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    
    public Object[]toDataRow(){
        return new Object[]{
            this.getMaNV(),this.getHoTen(),this.getGioiTinh(),this.getNamSinh(),this.getCaLam(),this.getVaiTro(),this.getSDT(),this.getQueQuan()
        };
    }
    
}
