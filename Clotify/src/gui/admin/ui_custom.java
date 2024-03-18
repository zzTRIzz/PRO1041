/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.admin;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 *
 * @author ADMIN
 */
public class ui_custom {
    
    //dành cho Frame child
    public static void deleteTitle(javax.swing.JInternalFrame giaodien){
        // Loại bỏ icon
        // Loại bỏ tiêu đề (Title)
        // Loại bỏ đường kẻ trắng trong Frame
        giaodien.setFrameIcon(null);
        giaodien.setBorder(null);
        ((BasicInternalFrameUI) giaodien.getUI()).setNorthPane(null);
    }
    
    //dành cho Frame dad
    public static void disposeAllFrame(javax.swing.JDesktopPane desktopPane){
        // Xóa tất cả các InternalFrame hiện có
        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.dispose();
        }
    }
}
