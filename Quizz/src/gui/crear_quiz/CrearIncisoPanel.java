/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crear_quiz;

import exceptions.IncisoVacioException;
import gui.custom_components.CustomTextField;
import gui.custom_components.IconoToggleBoton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class CrearIncisoPanel extends JPanel{
    
    private JLabel lblNumero;
    private CustomTextField txtRespuesta;
    private IconoToggleBoton btnCorrecto;
    
    public CrearIncisoPanel(Character num_inciso){
        super.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        lblNumero = new JLabel(String.format("Inciso %c: ",num_inciso));
        txtRespuesta = new CustomTextField("Escriba la posible respuesta", 20);
        
        btnCorrecto = new IconoToggleBoton("resources/iconos_crear/incorrecto.png", 15);
        btnCorrecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(btnCorrecto.isSelected()){
                    Image temp = new ImageIcon("resources/iconos_crear/correcto.png").getImage()
                            .getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    btnCorrecto.setIcon(new ImageIcon(temp));
                }
                else{
                    Image temp = new ImageIcon("resources/iconos_crear/incorrecto.png").getImage()
                            .getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    btnCorrecto.setIcon(new ImageIcon(temp));
                }
                repaint();
            }
        }); 
        
        
        super.add(lblNumero);
        super.add(txtRespuesta);
        super.add(btnCorrecto);
    }
    
    public void cambiarEnumeracion(Character num_inciso){
        lblNumero.setText(String.format("Inciso %c: ",num_inciso));
    }
    
    public void setTexto(String texto){
        txtRespuesta.setNormalFont(texto);
    }
    
    public void setCorrecto(Boolean bool){
        if(bool){
            btnCorrecto.setSelected(true);
            Image temp = new ImageIcon("resources/iconos_crear/correcto.png").getImage()
                    .getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            btnCorrecto.setIcon(new ImageIcon(temp));
        }
    }
    
    public String getTexto() throws IncisoVacioException{
        if(txtRespuesta.getText().equals("Escriba la posible respuesta")){
            txtRespuesta.requestFocus();
            throw new IncisoVacioException("Agregue descripcion al inciso");
        }
        return txtRespuesta.getText();
    }
    
    public Boolean getCorrecto(){
        return btnCorrecto.isSelected();
    }
    
}
