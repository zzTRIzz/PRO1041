/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPham;

/**
 *
 * @author ZznamnhizZ
 */
public interface SanPhamCTServiceImp {

    List<SanPham> getAll();

    SanPham getRow(int row);

    void addSanPham(SanPham sp);

//    void deleteSanPhamCT(Integer id);

    void updateSPCT(SanPham sp);
    
    List<SanPham> searchSanPham(String key);
}
