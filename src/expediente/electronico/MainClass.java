/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expediente.electronico;

import Vista.MainFrame;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Jonatan Lara
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           JFrame.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
        } catch (Exception e) {
        }
        MainFrame Windows = new MainFrame();
        Windows.setVisible(true);
    }
    
}
