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
public interface SanPhamCTService {
    List<SanPhamCT> getAll();
    SanPhamCT getRow(int row);
    void addSanPhamCT(SanPhamCT spct);
    void updateSanPhamCT(int soLuong, int idSP);
    void updateSanPhamCTSauMua(int idSPCT,int soLuongCon);
    List<SanPhamCT> searchID(String maSP,String loaiSP,int idTH,int idMS,int idSize,int idCL);
    List<SanPhamCT> searchSP(String key);
}
