/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ZznamnhizZ
 */
public class MauSac {
    Integer idMauSac;
    String maMauSac;
    String tenMauSac;
    String ghiChu;

    public MauSac() {
    }

    public MauSac(Integer idMauSac, String maMauSac, String tenMauSac, String ghiChu) {
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.ghiChu = ghiChu;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
