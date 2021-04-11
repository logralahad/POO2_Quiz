/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author logra
 */
public class Inciso implements Serializable{
    
    private String respuesta;
    private Boolean correcto;

    public Inciso(String texto, Boolean correcto) {
        this.respuesta = texto;
        this.correcto = correcto;
    }
    
    public Boolean isCorrecto() {
        return correcto;
    } 

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        Inciso inciso = (Inciso)o;
        return this.respuesta.equals(inciso.getRespuesta());
    }
    
    
}
