/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.editar_quiz;

import gui.crear_quiz.*;
import gui.custom_components.*;
import exceptions.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author logra
 */
public class EditarPreguntaPanel extends JPanel{
    
    private final Integer[] NUM_INCISOS = {1, 2, 3, 4, 5};
    private final String[] OPC_RESPUESTA = {"Unica", "Multiple"};

    private CustomTextField txtPregunta;
    private ComboLabelPanel pnlNumIncisos;
    private ComboLabelPanel pnlRespuesta;
    private ComboLabelPanel pnlQuitar;
    private JLabel lblPregunta;
    private JPanel pnlPregunta;
    private JPanel pnlIncisos;
    private JPanel pnlGeneral;
    
    public EditarPreguntaPanel(Pregunta pregunta, ArrayList<Inciso> incisos){
        super.setLayout(new BorderLayout());
        
        generarPaneles();
        crearIncisos(incisos);
        
        pnlRespuesta = new ComboLabelPanel("Tipo de respuesta", OPC_RESPUESTA); 
        if(pregunta.obtenerIncisosCorrecto().size() > 1){
            pnlRespuesta.setIndice(1);
        }else{
            pnlRespuesta.setIndice(0);
        }
        
        pnlQuitar = new ComboLabelPanel("Quitar inciso: ", obtenerNumeracionIncisos());
        pnlQuitar.setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Integer idx = pnlQuitar.getIndice();
                pnlIncisos.remove(idx);
                pnlQuitar.cambiarItems(obtenerNumeracionIncisos());
                enumerarPaneles();
            }
        });
        
        pnlNumIncisos = new ComboLabelPanel("Agregar incisos", NUM_INCISOS);
        pnlNumIncisos.setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                agregarIncisos();
                revalidate();
            }
        });
        pnlNumIncisos.add(pnlQuitar);

        lblPregunta = new JLabel("Pregunta: ");
        txtPregunta = new CustomTextField("Descripcion de la pregunta", 25);
        txtPregunta.setNormalFont(pregunta.getPregunta());
        pnlPregunta.add(lblPregunta);
        pnlPregunta.add(txtPregunta);

        pnlGeneral.add(pnlPregunta, BorderLayout.NORTH);
        pnlGeneral.add(pnlNumIncisos, BorderLayout.CENTER);
        pnlGeneral.add(pnlRespuesta, BorderLayout.SOUTH);

        super.add(pnlGeneral, BorderLayout.NORTH);
        super.add(pnlIncisos);
    }
    
    private void crearIncisos(ArrayList<Inciso> incisos){
        Integer cantidad = incisos.size();
        
        for (int i = 0; i < cantidad; i++) {
            Inciso resp = incisos.get(i);
            CrearIncisoPanel nuevo = new CrearIncisoPanel((char)(i + 65));
            nuevo.setTexto(resp.getRespuesta());
            nuevo.setCorrecto(resp.isCorrecto());
            pnlIncisos.add(nuevo);
        }
    }
    
    private void agregarIncisos(){
        Integer agregar = pnlNumIncisos.getIndice() + 1;
        Integer cantidad = pnlIncisos.getComponentCount();
        if((cantidad + agregar) > 6){
            if((6 - cantidad) > 0){
                JOptionPane.showMessageDialog(EditarPreguntaPanel.this, String.format("Solo puede agregar"
                    + " %d incisos, el limite son 6.", 6 - cantidad), "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(EditarPreguntaPanel.this, "Ya no puede agregar mas incisos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
            for (int i = cantidad; i < (cantidad + agregar); i++) {
                CrearIncisoPanel nuevo = new CrearIncisoPanel((char)(i + 65));
                pnlIncisos.add(nuevo);
                repaint();
            }
            pnlQuitar.cambiarItems(obtenerNumeracionIncisos());
        }
    }
    
    private void generarPaneles(){
        pnlGeneral = new JPanel(new BorderLayout());
        pnlPregunta = new JPanel(new FlowLayout());
        pnlIncisos = new JPanel();
        pnlIncisos.setLayout(new FlowLayout());
    }
    
    private void enumerarPaneles(){
        Component[] componentList = pnlIncisos.getComponents();
        Integer i = 0;
        for (Component component : componentList) {
            if(component instanceof CrearIncisoPanel){
                ((CrearIncisoPanel) component).cambiarEnumeracion((char)(i + 65));
                i++;
            }
        }
        pnlIncisos.revalidate();
        pnlIncisos.repaint();
    }
    
    private Character[] obtenerNumeracionIncisos(){
        Character[] incisos = new Character[pnlIncisos.getComponentCount()];
        for(int i = 0; i < pnlIncisos.getComponentCount(); i++){
            incisos[i] = ((char)(i + 65));
        }
        return incisos;
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
            if(inciso.getCorrecto()){
                correctos++;
            }
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
                incisos.add(new Inciso(inciso.getTexto(), inciso.getCorrecto()));
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

}
