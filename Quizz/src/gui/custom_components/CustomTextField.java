/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
/**
 *
 * @author logra
 */
public class CustomTextField extends JTextField {
    
    private String txtPlaceHolder;
    
    public CustomTextField(String texto, Integer tam){
        super(texto, tam);
        txtPlaceHolder = texto;
        setPlaceHolderFont();
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setPlaceHolderFont();
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(texto)) {
                    setNormalFont("");
                }
            }
        });
    }
    
    public void setPlaceHolderFont(){
        setText(txtPlaceHolder);
        setFont(new Font("Lucila Grande", Font.ITALIC, 12));
        setForeground(Color.GRAY);
    }
    
    public void setNormalFont(String texto){
        setText(texto);
        setFont(new Font("Lucila Grande", Font.PLAIN, 12));
        setForeground(Color.BLACK);
    }
    
}
