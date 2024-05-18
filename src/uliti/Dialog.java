/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uliti;

import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class Dialog {
    public static void pass(String str){
        JOptionPane.showMessageDialog(null, str+" Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void fail(String str){
        JOptionPane.showMessageDialog(null, str+" Thất Bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
    }
}
