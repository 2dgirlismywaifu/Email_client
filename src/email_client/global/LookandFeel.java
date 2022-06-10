/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email_client.global;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author notmiyouji
 */
public class LookandFeel {
    public static void setTheme() {
        try { 
            UIManager.setLookAndFeel(new FlatLightLaf()); 
        } catch (UnsupportedLookAndFeelException ex) { 
            ex.printStackTrace(); 
        }
            }
    
}
