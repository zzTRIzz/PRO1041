/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.ArrayList;
import java.util.List;
import model.LichSuGia;

/**
 *
 * @author Ngo Nhan
 */
public interface LichSuGiaService {
    
    void addLSGia(LichSuGia lsg);
    List<LichSuGia> listLSNull();
    List<LichSuGia> getAllLSG();
    void upDateLSG(String ngayKetThuc,int idLS);
}
