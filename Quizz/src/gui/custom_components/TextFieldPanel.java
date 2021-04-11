/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author logra
 */
public class TextFieldPanel extends JPanel{
    
    private JLabel lblNombre;
    private JTextField edtNombre;

    public TextFieldPanel(String texto) {
        super.setBackground(Color.ORANGE);
        
        lblNombre = new JLabel(texto);
        edtNombre = new JTextField(20);
        
        super.add(lblNombre);
        super.add(edtNombre);
    }

    public void clear(){
        this.edtNombre.setText("");
    }
    
    public String obtenerTexto(){
        return edtNombre.getText();
    }
}
