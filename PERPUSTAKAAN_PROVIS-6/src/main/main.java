/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author rifki
 */
public class main {
public static class UIbaru extends Component {
        
        //konstruktor
        public UIbaru() {
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        try {
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new main.UIbaru());
            
            //Mac OS on a budget :v
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(new UIbaru());
            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(new UIbaru());
            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(new UIbaru());
            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(new UIbaru());
            
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(new UIbaru());
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error Karena: "+ e);
        } 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formLogin().setVisible(true);
            }
        });
    }
    
}
    
    

