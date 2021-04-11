/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crear_quiz;

import gui.contestar_quiz.MostrarPreguntaPanel;
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
public class AgregarPreguntaDialog extends JDialog{
    
    private CrearPreguntaPanel pnlPregunta;
    private BotonesPreguntaPanel pnlBotones;
    
    public AgregarPreguntaDialog(Controlador oC, JTabbedPane pnl){
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
                    ArrayList<Inciso> incisos = pnlPregunta.obtenerIncisos();
                    String pregunta = pnlPregunta.obtenerPregunta();
                    oC.agregarPregunta(pregunta, incisos);
                    MostrarPreguntaPanel nuevo = new MostrarPreguntaPanel(pregunta, incisos);
                    pnl.addTab(pregunta, nuevo);
                    JOptionPane.showMessageDialog(AgregarPreguntaDialog.this, "Pregunta agregada.", 
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    pnlPregunta.clear();
                    dispose();  
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(AgregarPreguntaDialog.this, ex.getMessage(), 
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
