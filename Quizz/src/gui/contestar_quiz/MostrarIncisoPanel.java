/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contestar_quiz;

import gui.custom_components.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

/**
 *
 * @author logra
 */
public class MostrarIncisoPanel extends JPanel{
    
    private ImageScaled imgOpc;
    private JToggleButton btnCorrecto;
    
    public MostrarIncisoPanel(String direccion, String respuesta, Integer width, Integer height){
        super.setLayout(new FlowLayout(FlowLayout.LEADING));
        super.setBackground(Color.WHITE);
        
        imgOpc = new ImageScaled(direccion, height);
        
        btnCorrecto = new JToggleButton(respuesta);
        btnCorrecto.setFont(new Font("Lucila Grande", Font.ITALIC, 20));
        btnCorrecto.setPreferredSize(new Dimension(width, height));
        btnCorrecto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        btnCorrecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(btnCorrecto.isSelected()){
                    btnCorrecto.setContentAreaFilled(false);
                    btnCorrecto.setOpaque(true);
                    btnCorrecto.setBackground(Color.GREEN);
                }
                else{
                    btnCorrecto.setBackground(new JButton().getBackground());
                }
            }
        }); 
        
        super.add(imgOpc);
        super.add(btnCorrecto);
        super.setEnabled(false);
    }
    
    public void setCorrecto(Boolean bool){
        if(bool){
            btnCorrecto.setSelected(true);
            btnCorrecto.setContentAreaFilled(false);
            btnCorrecto.setOpaque(true);
            btnCorrecto.setBackground(Color.GREEN);
        }
    }
    
    public String getTexto(){
        return btnCorrecto.getText();
    }
    
    public Boolean getCorrecto(){
        return btnCorrecto.isSelected();
    }
    
    public void disableButton(){
        btnCorrecto.setEnabled(false);
        btnCorrecto.setUI(new MetalButtonUI(){
            @Override
            protected Color getDisabledTextColor(){
                return Color.BLACK;
            }
        });
    }
    
}
