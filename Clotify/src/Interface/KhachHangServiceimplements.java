/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author Dell
 */
public interface KhachHangServiceimplements {
    public List<KhachHang> getKhachHang();

    public KhachHang getRow(int row);

    public boolean addKhachHang(KhachHang kh);

    public void update(KhachHang kh);

    public List<KhachHang> searchKhachHang(String key);

    public List<KhachHang> getChiTietKhachHang(int idKH);
}
