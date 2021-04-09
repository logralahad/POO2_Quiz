/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contestar_quiz;

import controller.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import model.*;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class MostrarCuestionarioDialog extends JDialog{
    
    private JTabbedPane pnlPreguntas;
    private BotonesAlumnoPanel pnlBotones;
    
    public MostrarCuestionarioDialog(Window parent, Controlador oController){
        super(parent, Dialog.ModalityType.APPLICATION_MODAL);
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        super.setTitle(oController.getTitulo());
        super.setSize(650, 350);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        pnlPreguntas = new JTabbedPane();
        generarPreguntas(oController);
        
        pnlBotones = new BotonesAlumnoPanel();
        pnlBotones.setListener(new BotonesAlumnoListener() {
            @Override
            public void contestarButtonClick() {
                mensajeAdvertencia(oController);
            }

            @Override
            public void cancelarButtonClick() {
                mensajeAdvertencia(oController);
            }
        }); 
        
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mensajeAdvertencia(oController);
            }
        });
        
        super.add(pnlPreguntas);
        super.add(pnlBotones, BorderLayout.SOUTH);
    }
    
    private void mensajeAdvertencia(Controlador oController){
        int res = JOptionPane.showConfirmDialog(null, "¿Deseas salir el examen?"
                + "\nSe tomaran todas las preguntas en cuenta,\naunque no esten"
                + " contestadas.", "Salir", JOptionPane.YES_NO_CANCEL_OPTION);
        if(res == JOptionPane.YES_OPTION){
            calificarCuestionario(oController);
            JOptionPane.showMessageDialog(null, String.format("Calificacion: %.2f\nAciertos: %d"
                + "\nErrores: %d", oController.getCalificacion(), oController.getAciertos(),
                oController.getErrores()), "Resumen", JOptionPane.INFORMATION_MESSAGE);
            oController.setStatus(true);
            dispose();
        }
    }
    
    private void calificarCuestionario(Controlador oController){
        for (int i = 0; i < pnlPreguntas.getComponentCount(); i++) {
            MostrarPreguntaPanel pregunta = (MostrarPreguntaPanel)pnlPreguntas.getComponentAt(i);
            oController.calificar(pregunta.obtenerPregunta(), pregunta.obtenerSelecciones());
        }
    }
    
    private void generarPreguntas(Controlador oController){
        ArrayList<Pregunta> preguntas = oController.getPreguntas();
        Collections.shuffle(preguntas);
        Integer indice = 1;
        for (Pregunta pregunta : preguntas) {
            MostrarPreguntaPanel nuevo = new MostrarPreguntaPanel(pregunta.getPregunta(), pregunta.getIncisos());
            pnlPreguntas.addTab(String.format("Pregunta %d", indice), nuevo);
            indice++;
        }
    }
    
}
