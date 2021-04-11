/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.Font;
import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author logra
 */
public class IconoTextBoton extends JButton{
    
    private ImageIcon temp;
    private Image imgBoton;
    private ImageIcon icnBoton;

    public IconoTextBoton(String texto, String direccion, Integer tam) {
        super(texto);
        super.setVerticalTextPosition(AbstractButton.BOTTOM);
        super.setHorizontalTextPosition(AbstractButton.CENTER);
        super.setFont(new Font("Lucila Grande", Font.BOLD, 14));
        
        temp = new ImageIcon(direccion);
        imgBoton = temp.getImage().getScaledInstance(tam, tam, Image.SCALE_SMOOTH);
        
        icnBoton = new ImageIcon(imgBoton);
        super.setIcon(icnBoton);
    }
    
    public void cambiarPosicionTexto(Integer v, Integer h){
        super.setVerticalTextPosition(v);
        super.setHorizontalTextPosition(h);
    }
}
