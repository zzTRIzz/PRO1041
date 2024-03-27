/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPham;

/**
 *
 * @author Ngo Nhan
 */
public interface SanPhamService {
    void addSanPham(SanPham sp);
    List<SanPham> searchSanPham(String maSP);
}
