/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.*;
import controller.Controlador;
import gui.contestar_quiz.MostrarCuestionarioDialog;
import gui.contestar_quiz.MostrarResultadosDialog;
import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class AlumnoPanel extends JSplitPane{
    
    private MostrarCuestionarioDialog dlgCuestionario;
    private MostrarResultadosDialog dlgResultados;
    private Controlador oController;
    private BotonesAlumnoPanel pnlBotones;
    private ImageScaled lblImagen;

    public AlumnoPanel(JFrame parent, Controlador oC){
        super(JSplitPane.HORIZONTAL_SPLIT);
        super.setSize(new Dimension(800, 480));
        super.setDividerSize(0);
        super.setEnabled(false);
        super.setDividerLocation(getWidth() / 2);
        
        oController = oC;
        pnlBotones = new BotonesAlumnoPanel();
        pnlBotones.setListener(new BotonesAlumnoPanelListener() {
            @Override
            public void responderButtonClick() {
                try {
                    oController.cargarAlumno(new File("cuestionarios_guardados/asignacion/examen.dat"));
                    dlgCuestionario = new MostrarCuestionarioDialog(parent, oController);
                    if(!oController.getStatus()){
                        dlgCuestionario.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(AlumnoPanel.this, "El examen ya fue contestado.\nSolo habia"
                            + " un intento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AlumnoPanel.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void verButtonClick() {
                dlgResultados = new MostrarResultadosDialog(parent, oController);
                if(!oController.getStatus()){
                    JOptionPane.showMessageDialog(AlumnoPanel.this, "Debes contestar el examen primero",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    dlgResultados.setVisible(true);
                }
            }

            @Override
            public void salirButtonClick() {
                System.exit(0);
                JOptionPane.showMessageDialog(AlumnoPanel.this, "O", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        lblImagen = new ImageScaled("resources/iconos_crear/ulsa_logo2.jpg", getHeight());

        super.setLeftComponent(lblImagen);
        super.setRightComponent(pnlBotones);
    }
}
