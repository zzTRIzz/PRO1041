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
//    void updateSanPhamCT(int soLuong, int idSP);
    void updateSanPhamCT(int idSPCT,int soLuongCon);
    List<SanPhamCT> searchID(String maSP,String loaiSP,int idTH,int idMS,int idSize,int idCL);
    List<SanPhamCT> searchSPCT(String key);
    void upDateTrangThai(String trangThai,int idSP);
    List<SanPhamCT> getAllSPAn();
    List<SanPhamCT> getCheckKM(int idSP);
    void updateSanPhamCT2(int idSPCT,int soLuongCon,String hinhAnh);
    SanPhamCT timSP(int idSPCT);
}
