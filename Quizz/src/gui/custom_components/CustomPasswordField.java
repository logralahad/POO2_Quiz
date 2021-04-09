/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPasswordField;
/**
 *
 * @author logra
 */
public class CustomPasswordField extends JPasswordField {
    
    private String txtPlaceHolder;
    
    public CustomPasswordField(String texto, Integer tam){
        super(texto, tam);
        txtPlaceHolder = texto;
        setPlaceHolderFont();
        
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if(getPassword().length == 0) {
                    setPlaceHolderFont();
                }
            }

            @Override
            public void focusGained(FocusEvent e) {  
                if(String.valueOf(getPassword()).equals(texto)) {
                    setPasswordFont();
                }
            }
        });
    }
    
    public Boolean isTextWrittenIn(){
        if(getForeground().equals(Color.GRAY)){
            return false;
        }
        return true;
    }
    
    public void setPlaceHolderFont(){
        setText(txtPlaceHolder);
        setEchoChar((char)0);
        setFont(new Font("Lucila Grande", Font.ITALIC, 12));
        setForeground(Color.GRAY);
    }
    
    public void setPasswordFont(){
        setText("");
        setEchoChar('•');
        setFont(new Font("Lucila Grande", Font.PLAIN, 12));
        setForeground(Color.BLACK);
    }
    
}
