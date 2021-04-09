/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.ImageScaled;
import gui.custom_components.CustomTextField;
import java.awt.Color;
import javax.swing.*;
import exceptions.*;

/**
 *
 * @author logra
 */
public class LoginUsernamePanel extends JPanel{
    
    private ImageScaled lblNombre;
    private CustomTextField edtNombre;

    public LoginUsernamePanel() {
        super.setBackground(Color.WHITE);
        
        lblNombre = new ImageScaled("resources/iconos_login/username.png", 20);
        edtNombre = new CustomTextField("Nombre de usuario", 20);
        
        super.add(lblNombre);
        super.add(edtNombre);
    }

    public void clear(){
        this.edtNombre.setPlaceHolderFont();
    }
    
    public String obtenerUsername() throws UsuarioVacioException{
        if(edtNombre.getText().equals("Nombre de usuario")){
            throw new UsuarioVacioException("Debe escribir su nombre de usuario");
        }
        return edtNombre.getText();
    }
}
