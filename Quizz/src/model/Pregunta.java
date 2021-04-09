/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author logra
 */
public class Pregunta implements Serializable{

    private String txtPregunta;
    private ArrayList<Inciso> incisos;
    
    public Pregunta(String pregunta){
        this.txtPregunta = pregunta;
        this.incisos = new ArrayList<>();
    }

    public void setPregunta(String Pregunta) {
        this.txtPregunta = txtPregunta;
    }

    public void setIncisos(ArrayList<Inciso> incisos) {
        this.incisos = incisos;
    }

    public String getPregunta() {
        return this.txtPregunta;
    }

    public ArrayList<Inciso> getIncisos() {
        return this.incisos;
    }
    
    public ArrayList<String> obtenerIncisosCorrecto(){
        ArrayList<String> respuesta = new ArrayList<>();
        for (Inciso inciso : incisos) {
            if(inciso.isCorrecto()){
                respuesta.add(inciso.getRespuesta());
            }
        }
        return respuesta;
    }

    @Override
    public boolean equals(Object o) {
        Pregunta pregunta = (Pregunta)o;
        return txtPregunta.equals(pregunta.getPregunta());
    }
    
    
}
