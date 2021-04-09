/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crear_quiz;

import controller.Controlador;
import exceptions.*;
import gui.custom_components.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class CrearCuestionarioDialog extends JDialog{
    
    private BotonesCuestionarioPanel pnlBotones;
    private AgregarPreguntaDialog dlgPregunta;
    private JTabbedPane pnlPreguntas;
    private CustomTextField txtTitulo;
    private JLabel lblTitulo;
    private JPanel pnlTitulo;
    
    public CrearCuestionarioDialog(JFrame parent, Controlador oC){
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Crear cuestionario");
        super.setLayout(new BorderLayout());
        super.setSize(new Dimension(600, 450));
        super.setLocationRelativeTo(null);
        
        
        pnlPreguntas = new JTabbedPane();
        dlgPregunta = new AgregarPreguntaDialog(oC, pnlPreguntas);
        pnlBotones = new BotonesCuestionarioPanel();
        pnlBotones.setListener(new BotonesCuestionarioListener() {
            @Override
            public void crearButtonClick() {
                dlgPregunta.setVisible(true);
            }

            @Override
            public void guardarButtonClick() {
                try {
                    checarCuestionario(oC);
                    oC.save(obtenerNombre());
                    JOptionPane.showMessageDialog(CrearCuestionarioDialog.this, "Examen guardado", 
                        "Guardado", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(CrearCuestionarioDialog.this, ex.getMessage(), 
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
        lblTitulo.setFont(new Font("Lucila Grande", Font.BOLD, 20));
        txtTitulo = new CustomTextField("Escriba el nombre", 20);
        pnlTitulo.add(lblTitulo);
        pnlTitulo.add(txtTitulo);
        
        super.add(pnlTitulo, BorderLayout.NORTH);
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(pnlPreguntas);
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
