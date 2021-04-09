/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.editar_quiz;

import gui.crear_quiz.*;
import javax.swing.JDialog;
import controller.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


/**
 *
 * @author logra
 */
public class EditarNumeroPreguntasPanel extends JDialog{
    
    private CrearPreguntaPanel pnlPregunta;
    private BotonesPreguntaPanel pnlBotones;
    
    public EditarNumeroPreguntasPanel(Controlador oC, JTabbedPane pnl){
        super.setTitle("Crear pregunta");
        super.setLayout(new BorderLayout());
        super.setSize(new Dimension(450, 450));
        super.setLocationRelativeTo(null);
        
        pnlPregunta = new CrearPreguntaPanel();
        pnlBotones = new BotonesPreguntaPanel();
        pnlBotones.setListener(new BotonesPreguntasListener() {
            @Override
            public void crearButtonClick() {
                try {
                    Pregunta pregunta = new Pregunta(pnlPregunta.obtenerPregunta());
                    ArrayList<Inciso> incisos = pnlPregunta.obtenerIncisos();
                    pregunta.setIncisos(incisos);
                    oC.agregarPregunta(pregunta.getPregunta(), incisos);
                    EditarPreguntaPanel nuevo = new EditarPreguntaPanel(pregunta, incisos);
                    pnl.addTab(pregunta.getPregunta(), nuevo);
                    JOptionPane.showMessageDialog(EditarNumeroPreguntasPanel.this, "Pregunta agregada.", 
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    pnlPregunta.clear();
                    dispose();  
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarNumeroPreguntasPanel.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void cancelarButtonClick() {
                dispose();
            }

            @Override
            public void limpiarButtonClick() {
                pnlPregunta.clear();
            }
        });
        
        super.add(pnlPregunta);
        super.add(pnlBotones, BorderLayout.SOUTH);
    }
}
