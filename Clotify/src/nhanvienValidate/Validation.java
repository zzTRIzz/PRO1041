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
          String strPtn="^[a-zA-Z]\\w{2,}@\\w{2,}(\\.\\w{2,3}){1,2}$";//regular Expression jn Java
        if (!txtValue.matches(strPtn)) {
            JOptionPane.showMessageDialog(null,msg);
            txtField.setBackground(Color.red);
            txtField.setFocusable(true);
            return false;
        }
        txtField.setBackground(Color.GRAY);
        return  true;
    }
          public static boolean isSDT(JTextField txtField,String msg){
          String txtValue=txtField.getText().trim();
          String strPtn="^\\d{1,}$";//regular Expression jn Java
        if (!txtValue.matches(strPtn)) {
            JOptionPane.showMessageDialog(null,msg);
            txtField.setBackground(Color.red);
            txtField.setFocusable(true);
            return false;
        }
        txtField.setBackground(Color.GRAY);
        return  true;
    }
             public static boolean isNamSinh(JTextField txtField,String msg){
          String txtValue=txtField.getText().trim();
          String strPtn="^[0-3][0-9]/[01][0-9]/(19|20)[0-9]{2}$";//regular Expression jn Java
        if (!txtValue.matches(strPtn)) {
            JOptionPane.showMessageDialog(null,msg);
            txtField.setBackground(Color.red);
            txtField.setFocusable(true);
            return false;
            
        }
        txtField.setBackground(Color.GRAY);
        return  true;
    }
}
