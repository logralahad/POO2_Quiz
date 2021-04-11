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
public class BotonesProfesorPanel extends JPanel{
    
    private BotonesProfesorPanelListener listener;
    private IconoTextBoton btnCrear;
    private IconoTextBoton btnEditar;
    private IconoTextBoton btnSalir;
    private IconoTextBoton btnCargar;
    private ImageScaled lblUlsa;
    private JPanel pnlTemp;
    private JPanel pnlMid;
    private JPanel pnlTop;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    
    
    public BotonesProfesorPanel(){
        super.setLayout(new BorderLayout());
        
        lblUlsa = new ImageScaled("resources/iconos_crear/ulsaoaxaca.png", 80);
        lblUlsa.cambiarTamanio(250, 100);
        
        btnCrear = new IconoTextBoton("Crear examen", "resources/iconos_crear/crear.png", 50);
        btnCrear.setPreferredSize(new Dimension(150, 120));
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.crearButtonClick();
            }
        });
        
        btnEditar = new IconoTextBoton("Editar examen", "resources/iconos_crear/modificar.png", 50);
        btnEditar.setPreferredSize(new Dimension(150, 120));
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.editarButtonClick();
            }
        });
        
        btnCargar = new IconoTextBoton("Asignar examen", "resources/iconos_crear/subir.png", 50);
        btnCargar.setPreferredSize(new Dimension(150, 120));
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cargarButtonClick();
            }
        });
        
        btnSalir = new IconoTextBoton("Salir", "resources/iconos_crear/cerrar.jpg", 50);
        btnSalir.setPreferredSize(new Dimension(150, 120));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.salirButtonClick();
            }
        });
        
        pnlTemp = new JPanel();
        pnlTemp.setBackground(Color.WHITE);
        pnlTemp.add(btnCrear);
        pnlTemp.add(btnEditar);
        pnlTemp.add(btnCargar);
        pnlTemp.add(btnSalir);
        
        crearPaneles();
        pnlMid.add(lblUlsa, BorderLayout.NORTH);
        pnlMid.add(pnlTemp, BorderLayout.CENTER);
        
        
        super.add(pnlTop, BorderLayout.NORTH);
        super.add(pnlLeft, BorderLayout.WEST);
        super.add(pnlRight, BorderLayout.EAST);
        super.add(pnlMid, BorderLayout.CENTER);
    }
    
    public void setListener(BotonesProfesorPanelListener listener){
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
