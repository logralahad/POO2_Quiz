/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contestar_quiz;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import model.Pregunta;

/**
 *
 * @author logra
 */
public class MostrarResultadosDialog extends JDialog{
    
    private JTabbedPane pnlPreguntas;
    private BotonesResultadosPanel pnlBotones;
    
    public MostrarResultadosDialog(Window parent, Controlador oController){
        super(parent, Dialog.ModalityType.APPLICATION_MODAL);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle(oController.getTitulo());
        super.setSize(650, 350);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        pnlPreguntas = new JTabbedPane();
        generarPreguntas(oController);
        
        pnlBotones = new BotonesResultadosPanel();
        pnlBotones.setListener(new BotonesResultadosListener() {
            @Override
            public void verButtonClick() {
                JOptionPane.showMessageDialog(null, String.format("Calificacion: %.2f\nAciertos: %d"
                    + "\nErrores: %d", oController.getCalificacion(), oController.getAciertos(),
                    oController.getErrores()), "Resumen", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void salirButtonClick() {
                dispose();
            }
        }); 
        
        super.add(pnlPreguntas);
        super.add(pnlBotones, BorderLayout.SOUTH);
    }
    
    private void generarPreguntas(Controlador oController){
        ArrayList<Pregunta> preguntas = oController.getPreguntas();
        Collections.shuffle(preguntas);
        Integer indice = 1;
        for (Pregunta pregunta : preguntas) {
            MostrarPreguntaResueltaPanel nuevo;
            nuevo  = new MostrarPreguntaResueltaPanel(pregunta.getPregunta(), pregunta.getIncisos());
            pnlPreguntas.addTab(String.format("Pregunta %d", indice), nuevo);
            indice++;
        }
    }
    
}
