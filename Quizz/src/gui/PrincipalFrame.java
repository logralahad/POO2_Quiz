/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.login.ProfesorPanel;
import controller.*;
import gui.crear_quiz.*;
import gui.login.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Inciso;

/**
 *
 * @author logra
 */
public class PrincipalFrame extends JFrame{
    
    private LoginPanel pnlLogin;
    private Controlador oController;
    private ProfesorPanel pnlProfesor;
    private AlumnoPanel pnlAlumno;
    
    public PrincipalFrame(){
        super("Cuestionario");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(800, 480);
        super.setResizable(false);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        oController = new Controlador();
        pnlLogin = new LoginPanel(this);
        pnlLogin.setVisible(true);
        
        if(pnlLogin.getNivelAcceso()== 1){
            pnlProfesor = new ProfesorPanel(this, oController);
            super.add(pnlProfesor);
        }
        else if(pnlLogin.getNivelAcceso() == 2){
            pnlAlumno = new AlumnoPanel(this, oController);
            super.add(pnlAlumno);
        }
        super.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }
    
}
