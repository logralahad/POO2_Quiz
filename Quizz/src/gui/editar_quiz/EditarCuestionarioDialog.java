/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.editar_quiz;

import gui.crear_quiz.*;
import controller.Controlador;
import exceptions.*;
import gui.custom_components.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.*;

/**
 *
 * @author logra
 */
public class EditarCuestionarioDialog extends JDialog{
    
    private BotonesCuestionarioPanel pnlBotones;
    private EditarNumeroPreguntasPanel dlgPregunta;
    private JTabbedPane pnlPreguntas;
    private CustomTextField txtTitulo;
    private JLabel lblTitulo;
    private JPanel pnlTitulo;
    
    public EditarCuestionarioDialog(JFrame parent, Controlador oC){
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Editar cuestionario");
        super.setLayout(new BorderLayout());
        super.setSize(new Dimension(500, 550));
        super.setLocationRelativeTo(null);
        
        
        pnlPreguntas = new JTabbedPane();
        crearPreguntas(oC);
        dlgPregunta = new EditarNumeroPreguntasPanel(oC, pnlPreguntas);
        pnlBotones = new BotonesCuestionarioPanel();
        pnlBotones.setListener(new BotonesCuestionarioListener() {
            @Override
            public void crearButtonClick() {
                dlgPregunta.setVisible(true);
            }

            @Override
            public void guardarButtonClick() {
                try {
                    obtenerPreguntas(oC);
                    checarCuestionario(oC);
                    oC.save(obtenerNombre());
                    JOptionPane.showMessageDialog(EditarCuestionarioDialog.this, "Examen guardado", 
                        "Guardado", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditarCuestionarioDialog.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void salirButtonClick() {
                clear();
                dispose();
            }
        }); 
        
        pnlTitulo = new JPanel();
        lblTitulo = new JLabel("Nombre del cuestionario: ");
        lblTitulo.setFont(new Font("Lucila Grande", Font.BOLD, 15));
        txtTitulo = new CustomTextField("Escriba el nombre", 20);
        txtTitulo.setNormalFont(oC.getTitulo());
        
        pnlTitulo.add(lblTitulo);
        pnlTitulo.add(txtTitulo);
        
        super.add(pnlTitulo, BorderLayout.NORTH);
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(pnlPreguntas);
    }
    
    private void crearPreguntas(Controlador oC){
        ArrayList<Pregunta> preguntas = oC.getPreguntas();
        for (Pregunta pregunta : preguntas) {
            pnlPreguntas.addTab(pregunta.getPregunta(), new EditarPreguntaPanel
                (pregunta, pregunta.getIncisos()));
        }
    }
    
    private void obtenerPreguntas(Controlador oC) throws Exception{
        ArrayList<Pregunta> preguntas = oC.getPreguntas();
        for (int i = 0; i < pnlPreguntas.getComponentCount(); i++) {
            EditarPreguntaPanel pregunta = (EditarPreguntaPanel)pnlPreguntas.getComponent(i);
            Pregunta nueva = new Pregunta(pregunta.obtenerPregunta());
            nueva.setIncisos(pregunta.obtenerIncisos());
            preguntas.set(i, nueva);
        }
        oC.setPreguntas(preguntas);
    }
    
    public void clear(){
       txtTitulo.setPlaceHolderFont();
       pnlPreguntas.removeAll();
    }
    
    private String obtenerNombre() throws CuestionarioSinTituloException{
        if(txtTitulo.getText().equals("Escriba el nombre")){
            throw new CuestionarioSinTituloException("Debe asignarle un nombre al cuestionario");
        }
        return txtTitulo.getText();
    }
    
    private void checarCuestionario(Controlador oC) throws CuestionarioVacioException{
        if(oC.getNumeroPreguntas() == 0){
            throw new CuestionarioVacioException("El cuestionario no tiene preguntas");
        }
    }
    
}
