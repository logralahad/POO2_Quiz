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
import javax.swing.SwingConstants;

/**
 *
 * @author logra
 */
public class BotonesResultadosPanel extends JPanel{
    
    private BotonesResultadosListener listener;
    private IconoTextBoton btnVer;
    private IconoTextBoton btnSalir;
    private JPanel pnlIzquierdo;
    private JPanel pnlDerecho;
    
    public BotonesResultadosPanel(){
        super.setLayout(new BorderLayout());

        btnVer = new IconoTextBoton("Ver calificacion", "resources/iconos_crear/ver.png", 25);
        btnVer.cambiarPosicionTexto(SwingConstants.CENTER, SwingConstants.LEFT);
        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.verButtonClick();
            }
        }); 
        
        btnSalir = new IconoTextBoton("Salir", "resources/iconos_crear/salir.png", 25);
        btnSalir.cambiarPosicionTexto(SwingConstants.CENTER, SwingConstants.RIGHT);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.salirButtonClick();
            }
        });
        
        pnlIzquierdo = new JPanel();
        pnlDerecho = new JPanel();
        
        pnlIzquierdo.add(btnSalir);
        pnlDerecho.add(btnVer);
        
        super.add(pnlIzquierdo, BorderLayout.WEST);
        super.add(pnlDerecho, BorderLayout.EAST);
    }

    public void setListener(BotonesResultadosListener listener) {
        this.listener = listener;
    }
    
}
