/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.*;
import gui.custom_components.ImageScaled;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class BotonesAlumnoPanel extends JPanel{
    
    private BotonesAlumnoPanelListener listener;
    private IconoTextBoton btnResponder;
    private IconoTextBoton btnVer;
    private IconoTextBoton btnSalir;
    private ImageScaled lblUlsa;
    private JPanel pnlTemp;
    private JPanel pnlMid;
    private JPanel pnlTop;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    
    
    public BotonesAlumnoPanel(){
        super.setLayout(new BorderLayout());
        
        lblUlsa = new ImageScaled("resources/iconos_crear/ulsaoaxaca.png", 80);
        lblUlsa.cambiarTamanio(250, 100);
        
        btnResponder = new IconoTextBoton("Responder examen", "resources/iconos_crear/contestar.png", 50);
        btnResponder.setPreferredSize(new Dimension(250, 85));
        btnResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.responderButtonClick();
            }
        });
        
        btnVer = new IconoTextBoton("Ver resultados", "resources/iconos_crear/resultados.png", 50);
        btnVer.setPreferredSize(new Dimension(250, 85));
        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.verButtonClick();
            }
        });
        
        btnSalir = new IconoTextBoton("Salir", "resources/iconos_crear/cerrar.jpg", 50);
        btnSalir.setPreferredSize(new Dimension(250, 85));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.salirButtonClick();
            }
        });
        
        pnlTemp = new JPanel();
        pnlTemp.setBackground(Color.WHITE);
        pnlTemp.add(btnResponder);
        pnlTemp.add(btnVer);
        pnlTemp.add(btnSalir);
        
        crearPaneles();
        pnlMid.add(lblUlsa, BorderLayout.NORTH);
        pnlMid.add(pnlTemp, BorderLayout.CENTER);
        
        
        super.add(pnlTop, BorderLayout.NORTH);
        super.add(pnlLeft, BorderLayout.WEST);
        super.add(pnlRight, BorderLayout.EAST);
        super.add(pnlMid, BorderLayout.CENTER);
    }
    
    public void setListener(BotonesAlumnoPanelListener listener){
        this.listener = listener;
    }
    
    private void crearPaneles(){
        pnlTop = new JPanel();
        pnlTop.setBackground(Color.WHITE);
        pnlTop.setPreferredSize(new Dimension(60, 40));
        
        pnlLeft = new JPanel();
        pnlLeft.setBackground(Color.WHITE);
        pnlLeft.setPreferredSize(new Dimension(60, 60));
        
        pnlRight = new JPanel();
        pnlRight.setBackground(Color.WHITE);
        pnlRight.setPreferredSize(new Dimension(60, 60));
        
        pnlMid = new JPanel();
        pnlMid.setBackground(Color.WHITE);
        pnlMid.setLayout(new BorderLayout());
        pnlMid.setPreferredSize(new Dimension(30, 30));
    }
    
}
