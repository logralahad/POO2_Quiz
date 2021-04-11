/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import gui.custom_components.ImageScaled;
import exceptions.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class LoginPanel extends JDialog{
    
    private ImageScaled lblImagen;
    private ImageScaled lblUlsa;
    private JPanel pnlDatos;
    private JSplitPane pnlLogin;
    private JButton btnIngresar;
    private JButton btnLimpiar;
    private LoginPasswordPanel pnlPassword;
    private LoginUsernamePanel pnlUser;
    private Integer nivelAcceso;
    
    public LoginPanel(JFrame parent){
        super(parent, Dialog.ModalityType.APPLICATION_MODAL);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Inicio de sesion");
        super.setSize(650, 350);
        super.setLocationRelativeTo(null);
        
        nivelAcceso = 0;
        pnlLogin = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        pnlLogin.setDividerSize(0);
        pnlLogin.setEnabled(false);
        pnlLogin.setDividerLocation(getWidth() / 2);
        
        pnlDatos = new JPanel();
        pnlDatos.setLayout(new BorderLayout());
        pnlPassword = new LoginPasswordPanel();
        pnlUser = new LoginUsernamePanel();
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = pnlUser.obtenerUsername();
                    char[] intento = pnlPassword.obtenerPassword();
                    Integer dlgNumero = pnlPassword.comprobarPassword(intento);
                    if(dlgNumero == 1){
                        JOptionPane.showMessageDialog(null, String.format("Bievenido, profesor %s", 
                            username), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else if(dlgNumero == 2){
                        JOptionPane.showMessageDialog(null, String.format("Bievenido, alumno %s", 
                            username), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", 
                            "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                    }
                    nivelAcceso = dlgNumero;
                }
                catch (UsuarioVacioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (PasswordVacioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clear();
            }
        });
        
        lblUlsa = new ImageScaled("resources/iconos_login/ulsa_logo.png", 80);
        lblImagen = new ImageScaled("resources/imagenes/la_salle_banner.jpg", getWidth() / 2);
        modifyDatosPanel();
        
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); 
            }
        });

        pnlLogin.setLeftComponent(lblImagen);
        pnlLogin.setRightComponent(pnlDatos);
        super.add(pnlLogin);
    }
    
    public void clear(){
        pnlPassword.clear();
        pnlUser.clear();
    }
    
    public Integer getNivelAcceso(){
        return this.nivelAcceso;
    }

    private void modifyDatosPanel(){
        JPanel pnlTemp = new JPanel();
        pnlTemp.setBackground(Color.WHITE);
        
        JPanel nuevo = new JPanel();
        nuevo.setBackground(Color.WHITE);
        nuevo.setPreferredSize(new Dimension(100, 60));
        
        JPanel pnlMid = new JPanel();
        pnlMid.setBackground(Color.WHITE);
        pnlMid.setLayout(new BorderLayout());

        pnlTemp.add(pnlUser);
        pnlTemp.add(pnlPassword);
        pnlTemp.add(btnIngresar);
        pnlTemp.add(btnLimpiar);
        pnlMid.add(lblUlsa, BorderLayout.NORTH);
        pnlMid.add(pnlTemp);
        
        pnlDatos.add(nuevo, BorderLayout.NORTH);
        pnlDatos.add(pnlMid);
    }
    
}
