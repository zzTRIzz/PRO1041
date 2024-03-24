/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPhamKM;

/**
 *
 * @author Dell
 */
public interface SanPhamKMInterface {
    List<SanPhamKM> getSanPhamKM();
    void addSPKM(SanPhamKM spkm);
    SanPhamKM getRow(int row);
}
