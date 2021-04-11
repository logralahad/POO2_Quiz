/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contestar_quiz;

import gui.custom_components.IconoTextBoton;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author logra
 */
public class BotonesAlumnoPanel extends JPanel{
    
    private BotonesAlumnoListener listener;
    private IconoTextBoton btnContestar;
    private IconoTextBoton btnCancelar;
    private JPanel pnlIzquierdo;
    private JPanel pnlDerecho;
    
    public BotonesAlumnoPanel(){
        super.setLayout(new BorderLayout());

        btnContestar = new IconoTextBoton("Enviar", "resources/iconos_crear/enviar.png", 15);
        btnContestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.contestarButtonClick();
            }
        }); 
        
        btnCancelar = new IconoTextBoton("Salir", "resources/iconos_crear/cancelar.png", 15);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarButtonClick();
            }
        });
        
        pnlIzquierdo = new JPanel();
        pnlDerecho = new JPanel();
        
        pnlIzquierdo.add(btnCancelar);
        pnlDerecho.add(btnContestar);
        
        super.add(pnlIzquierdo, BorderLayout.WEST);
        super.add(pnlDerecho, BorderLayout.EAST);
    }

    public void setListener(BotonesAlumnoListener listener) {
        this.listener = listener;
    }
    
}
