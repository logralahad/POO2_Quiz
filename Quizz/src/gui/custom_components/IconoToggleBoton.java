/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;



/**
 *
 * @author logra
 */
public class IconoToggleBoton extends JToggleButton{
    
    private Image imgBoton;
    private ImageIcon icnBoton;

    public IconoToggleBoton(String direccion, Integer tam) {
        ImageIcon temp = new ImageIcon(direccion);
        imgBoton = temp.getImage().getScaledInstance(tam, tam, Image.SCALE_SMOOTH);
        
        icnBoton = new ImageIcon(imgBoton);
        super.setIcon(icnBoton);
    }

}
