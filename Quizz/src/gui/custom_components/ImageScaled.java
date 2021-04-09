/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author logra
 */
public class ImageScaled extends JLabel{
    
    private Image imgUser;
    private ImageIcon imbLabel;
    private ImageIcon temp;
    
    public ImageScaled(String direccion, Integer tam) {
        temp = new ImageIcon(direccion);
        imgUser = temp.getImage().getScaledInstance(tam, tam, Image.SCALE_SMOOTH);
        
        imbLabel = new ImageIcon(imgUser);
        super.setIcon(imbLabel);
        super.setHorizontalAlignment(SwingConstants.CENTER);
        super.setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public void cambiarTamanio(Integer i, Integer i2){
        imgUser = temp.getImage().getScaledInstance(i, i2, Image.SCALE_SMOOTH);
        
        imbLabel = new ImageIcon(imgUser);
        super.setIcon(imbLabel);
        super.setHorizontalAlignment(SwingConstants.CENTER);
        super.setVerticalAlignment(SwingConstants.CENTER);
    }
    
}
