/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.custom_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class ComboLabelPanel extends JPanel{
    
    private JLabel lblNumero;
    private JComboBox cmbNumero;
    
    public ComboLabelPanel(String texto, Object[] es){
        super.setLayout(new FlowLayout());
        
        lblNumero = new JLabel(texto);
        cmbNumero = new JComboBox(es);
        cmbNumero.setSelectedItem(null);
        
        super.add(lblNumero);
        super.add(cmbNumero);
    }
    
    public void cambiarItems(Object[] es){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(es);
        model.setSelectedItem(null);
        cmbNumero.setModel(model);
    }
    
    public Integer getIndice(){
        return cmbNumero.getSelectedIndex();
    }
    
    public void setIndice(Integer idx){
        if(idx == -1){
            cmbNumero.setSelectedItem(null);
        }else{
            cmbNumero.setSelectedIndex(idx);
        }
    }
    
    public void setListener(ActionListener ae){
        cmbNumero.addActionListener(ae);
    }
    
}
