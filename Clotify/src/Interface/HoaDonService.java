/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.HoaDon;
import java.util.Date;

/**
 *
 * @author Surface
 */
public interface HoaDonService {

    List<HoaDon> getHoaDonAll();

    HoaDon getRowHD(int row);

    List<HoaDon> Search(String key);

    List<HoaDon> SearchTime(java.util.Date batDau, java.util.Date ketThuc);

    void addHoaDon(HoaDon hd);

    void upDateHoaDon(HoaDon hd);

}
