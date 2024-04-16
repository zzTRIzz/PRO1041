/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.ChatLieu;
import model.MauSac;
import model.Size;
import model.ThuongHieu;

/**
 *
 * @author ZznamnhizZ
 */
public interface ThuocTinhImpl {
    List<MauSac> getAllMs(String trangThaiTT );
    List<ThuongHieu> getAllTh(String trangThaiTT );
    List<ChatLieu> getAllCl(String trangThaiTT );
    List<Size> getAllSize(String trangThaiTT );
    
    void addMauSac(MauSac ms);
    void addThuongHieu(ThuongHieu th);
    void addChatLieu(ChatLieu cl);
    void addSize(Size s);
    
    MauSac getMS(String tenMS);
    ThuongHieu getTH(String tenTH);
    ChatLieu getCL(String tenCL);
    Size getSize(String tenSize);
    
    MauSac getRowMS(int row);
    ThuongHieu getRowTH(int row);
    ChatLieu getRowCL(int row);
    Size getRowSize(int row);
    
    void updateMS(int idTT,String ghiChu);
    void updateTH(int idTT,String ghiChu);
    void updateCL(int idTT,String ghiChu);
    void updateSize(int idTT,String ghiChu);
    
    List<MauSac> getListMS(String tenMS);
    List<ThuongHieu> getListTH(String tenTH);
    List<ChatLieu> getListCL(String tenCL);
    List<Size> getListSize(String tenSize);
    
}
