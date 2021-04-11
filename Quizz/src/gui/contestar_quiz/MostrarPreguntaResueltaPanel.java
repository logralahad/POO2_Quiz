/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contestar_quiz;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.*;

/**
 *
 * @author logra
 */
public class MostrarPreguntaResueltaPanel extends JSplitPane{
    
    private JTextArea pnlPregunta;
    private JScrollPane scbPregunta;
    private JPanel pnlRespuestas;
    private JPanel pnlBordes;
    
    public MostrarPreguntaResueltaPanel(String pregunta, ArrayList<Inciso> incisos){
        super(JSplitPane.HORIZONTAL_SPLIT);
        super.setSize(new Dimension(580, 290));
        super.setDividerSize(0);
        super.setEnabled(false);
        super.setDividerLocation((getWidth() / 2) - 40);

        crearPreguntaPanel(pregunta, incisos.size());
        crearIncisos(incisos);
        
        super.setLeftComponent(pnlBordes);
        super.setRightComponent(pnlRespuestas);
    }
    
    private void crearIncisos(ArrayList<Inciso> incisos){
        Collections.shuffle(incisos);
        for (int i = 0; i < incisos.size(); i++) {
            Inciso inciso = incisos.get(i);
            String direccion = String.format("resources/iconos_letras/%d.png", (i + 1));
            MostrarIncisoPanel opcion = new MostrarIncisoPanel(direccion, inciso.getRespuesta(), 
                    getWidth() / 2, (getHeight() - (getHeight() / 2)) / (incisos.size() + 1));
            opcion.setCorrecto(inciso.isCorrecto());
            opcion.disableButton();
            pnlRespuestas.add(opcion);
        }
    }
    
    private void crearPreguntaPanel(String pregunta, Integer size){
        pnlPregunta = new JTextArea();
        pnlPregunta.setText(pregunta);
        pnlPregunta.setEditable(false);
        pnlPregunta.setLineWrap(true);
        pnlPregunta.setWrapStyleWord(true);
        pnlPregunta.setFont(new Font("Lucila Grande", Font.BOLD, 25));
        pnlPregunta.setCaretPosition(pnlPregunta.getDocument().getLength());
        
        scbPregunta = new JScrollPane(pnlPregunta);
        scbPregunta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        pnlBordes = new JPanel();
        pnlBordes.setLayout(new BorderLayout());
        Color color = Color.ORANGE;
        
        GridLayout layout = new GridLayout(0, 1);
        layout.setHgap(0);
        pnlRespuestas = new JPanel();
        pnlRespuestas.setLayout(layout);
        
        JPanel pnlTop = new JPanel();
        pnlTop.setBackground(color);
        pnlTop.setPreferredSize(new Dimension(60, 20));
        
        JPanel pnlBottom = new JPanel();
        pnlBottom.setBackground(color);
        pnlBottom.setPreferredSize(new Dimension(60, 20));
        
        JPanel pnlLeft = new JPanel();
        pnlLeft.setBackground(color);
        pnlLeft.setPreferredSize(new Dimension(20, 20));
        
        JPanel pnlRight = new JPanel();
        pnlRight.setBackground(color);
        pnlRight.setPreferredSize(new Dimension(20, 20));
        
        pnlBordes.add(pnlTop, BorderLayout.NORTH);
        pnlBordes.add(pnlBottom, BorderLayout.SOUTH);
        pnlBordes.add(scbPregunta, BorderLayout.CENTER);
        pnlBordes.add(pnlLeft, BorderLayout.WEST);
        pnlBordes.add(pnlRight, BorderLayout.EAST);
    }
    
}
    