/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;
import java.util.List;
import model.HoaDon;
/**
 *
 * @author Surface
 */
public interface HoaDonService {
    List<HoaDon> getHoaDonAll();
    HoaDon getRowHD(int row);
}
