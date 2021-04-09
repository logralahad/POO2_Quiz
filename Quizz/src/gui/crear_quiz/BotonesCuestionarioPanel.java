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
public class BotonesCuestionarioPanel extends JPanel{
    
    private BotonesCuestionarioListener listener;
    private IconoTextBoton btnPregunta;
    private IconoTextBoton btnCancelar;
    private IconoTextBoton btnGuardar;
    private JPanel pnlIzquierdo;
    private JPanel pnlDerecho;
    
    public BotonesCuestionarioPanel(){
        super.setLayout(new BorderLayout());
        
        btnPregunta = new IconoTextBoton("Agregar pregunta", "resources/iconos_crear/agregar.png", 15);
        btnPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.crearButtonClick();
            }
        }); 
        
        btnCancelar = new IconoTextBoton("Cancelar", "resources/iconos_crear/cancelar.png", 15);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.salirButtonClick();
            }
        });
        
        btnGuardar = new IconoTextBoton("Guardar examen", "resources/iconos_crear/guardar.png", 15);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.guardarButtonClick();
            }
        });
        
        pnlIzquierdo = new JPanel();
        pnlDerecho = new JPanel();
        
        pnlIzquierdo.add(btnCancelar);
        pnlDerecho.add(btnPregunta);
        pnlDerecho.add(btnGuardar);
        
        super.add(pnlIzquierdo, BorderLayout.WEST);
        super.add(pnlDerecho, BorderLayout.EAST);
    }

    public void setListener(BotonesCuestionarioListener listener) {
        this.listener = listener;
    }

}
