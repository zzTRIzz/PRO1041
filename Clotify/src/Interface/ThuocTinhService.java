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
public interface ThuocTinhService {
    List<MauSac> getAllMs();
    List<ThuongHieu> getAllTh();
    List<ChatLieu> getAllCl();
    List<Size> getAllSize();
//    boolean addTT(String loaiTT);
//    boolean addTT(ThuongHieu th,ChatLieu cl,MauSac ms, Size s,String loaiTT);
//    boolean addTT();
    boolean addMauSac(MauSac ms);
    boolean addThuongHieu(ThuongHieu th);
    boolean addChatLieu(ChatLieu cl);
    boolean addSize(Size s);
}
