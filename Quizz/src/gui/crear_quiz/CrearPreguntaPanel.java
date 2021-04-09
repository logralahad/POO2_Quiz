/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crear_quiz;

import gui.custom_components.ComboLabelPanel;
import gui.custom_components.CustomTextField;
import exceptions.*;
import gui.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author logra
 */
public class CrearPreguntaPanel extends JPanel{
    
    private final Integer[] NUM_INCISOS = {2, 3, 4, 5, 6};
    private final String[] OPC_RESPUESTA = {"Unica", "Multiple"};

    private CustomTextField txtPregunta;
    private ComboLabelPanel pnlNumIncisos;
    private ComboLabelPanel pnlRespuesta;
    private JLabel lblPregunta;
    private JPanel pnlPregunta;
    private JPanel pnlIncisos;
    private JPanel pnlGeneral;
    
    public CrearPreguntaPanel(){
        super.setLayout(new BorderLayout());
        
        generarPaneles();
        pnlRespuesta = new ComboLabelPanel("Tipo de respuesta", OPC_RESPUESTA); 
        pnlNumIncisos = new ComboLabelPanel("Num. de incisos", NUM_INCISOS);
        pnlNumIncisos.setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crearIncisos();
                revalidate();
            }
        });
        pnlNumIncisos.add(pnlRespuesta);
        
        lblPregunta = new JLabel("Pregunta: ");
        txtPregunta = new CustomTextField("Descripcion de la pregunta", 25);
        pnlPregunta.add(lblPregunta);
        pnlPregunta.add(txtPregunta);

        pnlGeneral.add(pnlPregunta, BorderLayout.NORTH);
        pnlGeneral.add(pnlNumIncisos, BorderLayout.SOUTH);

        super.add(pnlGeneral, BorderLayout.NORTH);
        super.add(pnlIncisos);
    }
    
    public void crearIncisos(){
        if(pnlNumIncisos.getIndice() != -1){
            Integer incisos = pnlNumIncisos.getIndice() + 2;
            pnlIncisos.removeAll();
            repaint();

            for (int i = 0; i < incisos; i++) {
                CrearIncisoPanel nuevo = new CrearIncisoPanel((char)(i + 65));
                pnlIncisos.add(nuevo);
            }
        }
        
    }
    
    public String obtenerPregunta(){
        return txtPregunta.getText();
    }
    
    public ArrayList<Inciso> obtenerIncisos() throws Exception{
        
        if(txtPregunta.getText().equals("Descripcion de la pregunta")){
            txtPregunta.requestFocus();
            throw new PreguntaVaciaException("Agregue descripcion a la pregunta");
        }
        else if(pnlIncisos.getComponentCount() < 1){
            throw new PreguntaSinIncisosException("Debe agregar incisos.");
        }
        else if(pnlRespuesta.getIndice() == -1){
            throw new PreguntaSinModalidadException("Debe elegir que tipo de pregunta es.");
        }
        
        ArrayList<Boolean> opciones = new ArrayList<>();
        Integer correctos = 0;
        for (int i = 0; i < pnlIncisos.getComponentCount(); i++) {
            CrearIncisoPanel inciso = (CrearIncisoPanel)pnlIncisos.getComponent(i);
            if(inciso.getCorrecto()) correctos++;
            opciones.add(inciso.getCorrecto());
        }
        
        if(!opciones.contains(true)){
            throw new PreguntaSinRespuestaException("Debe elegir al menos una respuesta correcta");
        }
        else if(pnlRespuesta.getIndice() == 0 && correctos > 1){
            throw new SoloUnaRespuestaException("Solo debe elegir una respuesta correcta");
        }
        else if(pnlRespuesta.getIndice() == 1 && correctos < 2){
            throw new RespuestaUnicaException("Debe elegir mas de una respuesta correcta");
        }
        else{
            ArrayList<Inciso> incisos = new ArrayList<>();
            
            for (int i = 0; i < pnlIncisos.getComponentCount(); i++) {
                CrearIncisoPanel inciso = (CrearIncisoPanel)pnlIncisos.getComponent(i);
                Inciso nuevo = new Inciso(inciso.getTexto(), inciso.getCorrecto());
                if(incisos.contains(nuevo)){
                    inciso.requestFocus();
                    throw new IncisoRepetidoException("El inciso ya existe.");
                }
                else{
                    incisos.add(nuevo);
                }
                
            }
            return incisos;
        }
    }
    
    public void clear(){
        pnlIncisos.removeAll();
        repaint();
        
        pnlNumIncisos.setIndice(-1);
        pnlRespuesta.setIndice(-1);
        txtPregunta.setPlaceHolderFont();
    }
    
    public void generarPaneles(){
        pnlGeneral = new JPanel(new BorderLayout());
        pnlPregunta = new JPanel(new FlowLayout());
        pnlIncisos = new JPanel();
        pnlIncisos.setLayout(new FlowLayout());
    }
}
