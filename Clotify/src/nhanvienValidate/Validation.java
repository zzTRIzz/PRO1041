/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanvienValidate;

import java.awt.Color;
import java.awt.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author THE PC
 */
public class Validation {
     public static boolean isEmpty(JTextField txtField,String msg){
          String txtValue=txtField.getText().trim();
        if (txtValue.length()==0) {
            JOptionPane.showMessageDialog(null,msg);
            txtField.setBackground(Color.red);
            txtField.setFocusable(true);
            return true;
        }
        txtField.setBackground(Color.GRAY);
        return  false;
    }
        public static boolean isEmailFormat(JTextField txtField,String msg){
          String txtValue=txtField.getText().trim();
          String strPtn="^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";//regular Expression jn Java
        if (!txtValue.matches(strPtn)) {
            JOptionPane.showMessageDialog(null,msg);
            txtField.setBackground(Color.red);
            txtField.setFocusable(true);
            return false;
        }
        txtField.setBackground(Color.GRAY);
        return  true;
    }
         public static boolean isSDT(JTextField txtField, String msg) {
    String txtValue = txtField.getText().trim();
    String strPtn = "^09\\d*$"; // Biểu thức chính quy chỉ kiểm tra số điện thoại bắt đầu bằng "09" và không chứa chữ

    if (!txtValue.matches(strPtn)) {
        JOptionPane.showMessageDialog(null, msg);
        txtField.setBackground(Color.RED);
        txtField.requestFocusInWindow();
        return false;
    }

    txtField.setBackground(Color.GRAY);
    return true;
}
//             public static boolean isNamSinh(JTextField txtField,String msg){
//          String txtValue=txtField.getText().trim();
//          String strPtn="^[0-3][0-9]/[01][0-9]/(19|20)[0-9]{2}$";//regular Expression jn Java
//        if (!txtValue.matches(strPtn)) {
//            JOptionPane.showMessageDialog(null,msg);
//            txtField.setBackground(Color.red);
//            txtField.setFocusable(true);
//            return false;
//            
//        }
//        txtField.setBackground(Color.GRAY);
//        return  true;
//    }
         
}
