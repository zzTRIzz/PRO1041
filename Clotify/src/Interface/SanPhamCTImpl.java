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
<<<<<<<< Updated upstream:Clotify/src/Interface/SanPhamCTServiceImp.java
public interface SanPhamCTServiceImp {

    List<SanPham> getAll();

    SanPham getRow(int row);

    void addSanPham(SanPham sp);

//    void deleteSanPhamCT(Integer id);

    void updateSPCT(SanPham sp);
    
    List<SanPham> searchSanPham(String key);
========
public interface SanPhamCTImpl {
    List<SanPhamCT> getAll();
    SanPhamCT getRow(int row);
    void addSanPhamCT(SanPhamCT spct);
    void updateSanPhamCT(SanPhamCT spct);
    List<SanPhamCT> searchSanPhamCT(String key);
>>>>>>>> Stashed changes:Clotify/src/Interface/SanPhamCTImpl.java
}
