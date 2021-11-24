/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nhatd
 */
public class validateHelper {
    public static boolean checkNullText(JTextField txt){
        if(txt.getText().trim().length()>0){
            return true;
        }else{
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+ " không được trống!");
            return false;
        }
    }
    
    public static boolean checkTenDV(JTextField txt){
        String ten=txt.getText();
        String rgx=".{1,50}";
        if(ten.matches(rgx)){
            return true;
        }else{
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+ " không đúng định dạng!");
            return false;
        }
    }
    
    
    public static boolean checkGioiThieu(JTextArea txt){
        String ten=txt.getText();
        String rgx=".{1,225}";
        if(ten.matches(rgx)==true){
            return true;
        }else{
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+ " không đúng định dạng!");
            return false;
        }
    }
    
    public static boolean checkGiaTien(JTextField txt){
        String tien=txt.getText();
        String tienString="\\d{5,20}";
        try {
            if(tien.matches(tienString)==true){
            return true;
        }else{
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+ " phải từ 5 đến 20 số");
            return false;
        }
        } catch (Exception e) {
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+ " không đúng định dạng!");
            return false;
        }
            
    }
}
