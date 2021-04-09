/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.CustomPasswordField;
import gui.custom_components.ImageScaled;
import gui.custom_components.IconoToggleBoton;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import exceptions.*;

/**
 *
 * @author logra
 */
public class LoginPasswordPanel extends JPanel{
    
    private final char[] passwordProfesor = {'d', 'e', 's', 't', 'r', 'u', 'y', 'e'};
    private final char[] passwordEstudiante = {'r', 'e', 'p', 'r', 'u', 'e', 'b', 'a'};
    
    private ImageScaled lblNombre;
    private CustomPasswordField edtNombre;
    private IconoToggleBoton btnVisible;

    public LoginPasswordPanel() {
        super.setBackground(Color.WHITE);
        
        lblNombre = new ImageScaled("resources/iconos_login/lock.png", 20);
        edtNombre = new CustomPasswordField("Contraseña", 15);
        
        btnVisible = new IconoToggleBoton("resources/iconos_login/visible.png", 15);
        btnVisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(btnVisible.isSelected()){
                    edtNombre.setEchoChar((char)0);
                }else{
                    if(edtNombre.isTextWrittenIn()){
                        edtNombre.setEchoChar('•');
                    }
                }
            }
        });

        super.add(lblNombre);
        super.add(edtNombre);
        super.add(btnVisible);
    }

    public void clear(){
        this.edtNombre.setPlaceHolderFont();
    }
    
    public char[] obtenerPassword() throws PasswordVacioException{
        if(String.valueOf(edtNombre.getPassword()).equals("Contraseña")){
            throw new PasswordVacioException("Escriba la contraseña"); 
        }
        return edtNombre.getPassword();
    }
    
    public Integer comprobarPassword(char[] intento){
        if(Arrays.equals(intento, passwordProfesor)){
            return 1;
        }
        else if(Arrays.equals(intento, passwordEstudiante)){
            return 2;
        }
        return -1;
    }
}
