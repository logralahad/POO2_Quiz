/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crear_quiz;

import gui.custom_components.IconoTextBoton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class BotonesPreguntaPanel extends JPanel{
    
    private BotonesPreguntasListener listener;
    private IconoTextBoton btnCrear;
    private IconoTextBoton btnCancelar;
    private IconoTextBoton btnLimpiar;
    private JPanel pnlIzquierdo;
    private JPanel pnlDerecho;
    
    public BotonesPreguntaPanel(){
        super.setLayout(new BorderLayout());
        
        btnCrear = new IconoTextBoton("Añadir", "resources/iconos_crear/anadir.png", 15);
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.crearButtonClick();
            }
        }); 
        
        btnCancelar = new IconoTextBoton("Cancelar", "resources/iconos_crear/cancelar.png", 15);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarButtonClick();
            }
        });
        
        btnLimpiar = new IconoTextBoton("Limpiar", "resources/iconos_crear/limpiar.png", 15);
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.limpiarButtonClick();
            }
        });
        
        pnlIzquierdo = new JPanel();
        pnlDerecho = new JPanel();
        
        pnlIzquierdo.add(btnCancelar);
        pnlDerecho.add(btnCrear);
        pnlDerecho.add(btnLimpiar);
        
        super.add(pnlIzquierdo, BorderLayout.WEST);
        super.add(pnlDerecho, BorderLayout.EAST);
    }

    public void setListener(BotonesPreguntasListener listener) {
        this.listener = listener;
    }

}
