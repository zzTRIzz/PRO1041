/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPhamCT;

/**
 *
 * @author ZznamnhizZ
 */
public interface SanPhamCTImpl {
    List<SanPhamCT> getAll();
    SanPhamCT getRow(int row);
    void addSanPhamCT(SanPhamCT spct);
//    void deleteSanPhamCT(Integer id);
    void updateSanPhamCT(SanPhamCT spct);
    List<SanPhamCT> searchSanPhamCT(String key);
}
