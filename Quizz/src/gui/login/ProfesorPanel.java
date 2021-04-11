/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.*;
import controller.Controlador;
import gui.crear_quiz.*;
import gui.editar_quiz.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class ProfesorPanel extends JSplitPane{
    
    private CrearCuestionarioDialog dlgCrear;
    private EditarCuestionarioDialog dlgEditar;
    private JFileChooser flcArchivo;
    private BotonesProfesorPanel pnlBotones;
    private ImageScaled lblImagen;

    public ProfesorPanel(JFrame parent, Controlador oController){
        super(JSplitPane.HORIZONTAL_SPLIT);
        super.setSize(new Dimension(800, 480));
        super.setDividerSize(0);
        super.setEnabled(false);
        super.setDividerLocation(getWidth() / 3);
        
        dlgCrear = new CrearCuestionarioDialog(parent, oController);
        flcArchivo = new JFileChooser("cuestionarios_guardados");
        pnlBotones = new BotonesProfesorPanel();
        pnlBotones.setListener(new BotonesProfesorPanelListener() {
            @Override
            public void crearButtonClick() {
                dlgCrear.setVisible(true);
            }

            @Override
            public void editarButtonClick() {
                Integer resultado = flcArchivo.showOpenDialog(parent);
                if(resultado == JFileChooser.APPROVE_OPTION){
                    File archivo = flcArchivo.getSelectedFile();
                    try {
                        oController.load(archivo);
                        dlgEditar = new EditarCuestionarioDialog(parent, oController);
                        dlgEditar.setVisible(true);
                    }
                    catch (Exception ex) {
                    JOptionPane.showMessageDialog(ProfesorPanel.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void cargarButtonClick() {
                Integer resultado = flcArchivo.showOpenDialog(parent);
                if(resultado == JFileChooser.APPROVE_OPTION){
                    File archivo = flcArchivo.getSelectedFile();
                    try {
                        oController.asignar(archivo);
                        JOptionPane.showMessageDialog(ProfesorPanel.this, "Cuestionario asignado", 
                            "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (Exception ex) {
                    JOptionPane.showMessageDialog(ProfesorPanel.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void salirButtonClick() {
                System.exit(0);
            }
        }); 
        
        lblImagen = new ImageScaled("resources/iconos_crear/ulsa_logo.jpg", getHeight());

        super.setLeftComponent(lblImagen);
        super.setRightComponent(pnlBotones);
    }
}
