/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.*;
import model.*;
import exceptions.*;
import javax.swing.JOptionPane;

/**
 *
 * @author logra
 */
public class Controlador implements Serializable{
    
    private ArrayList<Pregunta> preguntas;
    private Boolean status;
    private String materia;
    private Double calificacion;
    private Integer aciertos;
    private Integer errores;
    
    public Controlador(){
        this.preguntas = new ArrayList<>();
        this.status = false;
        this.materia = "Sin titulo";
        this.calificacion = 0.0;
        this.aciertos = 0;
        this.errores = 0;
    }
    
    public String getTitulo(){
        return this.materia;
    }
    
    public Integer getNumeroPreguntas(){
        return preguntas.size();
    }
    
    public ArrayList<Pregunta> getPreguntas(){
        return this.preguntas;
    }
    
    public Double getCalificacion() {
        return (double)(this.aciertos * 100) / (double)(this.aciertos + this.errores);
    }

    public Integer getAciertos() {
        return this.aciertos;
    }

    public Integer getErrores() {
        return this.errores;
    }
    
    public Boolean getStatus(){
        return this.status;
    }
    
    public void setPreguntas(ArrayList<Pregunta> preguntas){
        this.preguntas = preguntas;
    }
    
    public void setStatus(Boolean status){
        this.status = status;
    }
    
    public void agregarPregunta(String descripcion, ArrayList<Inciso> incisos) throws PreguntaRepetidaException{
        Pregunta pregunta = new Pregunta(descripcion);
        pregunta.setIncisos(incisos);
        
        if(preguntas.contains(pregunta)){
            throw new PreguntaRepetidaException("La pregunta ya existe.");
        }else{
            this.preguntas.add(pregunta);
        }
    }
    
    public void calificar(String descripcion, ArrayList<String> selecciones){
        Pregunta nueva = new Pregunta(descripcion);
        Pregunta pregunta = preguntas.get(preguntas.indexOf(nueva));
        ArrayList<String> respuestas = pregunta.obtenerIncisosCorrecto();
        
        for (String respuesta : respuestas) {
            if(selecciones.contains(respuesta)){
                this.aciertos++;
            }
            else{
                this.errores++;
            }
        }
    }

    public void save(String nombre_archivo) throws Exception{
        try {
            if(new File(String.format("cuestionarios_guardados/%s.dat", nombre_archivo)).isFile()){
                File file = new File(String.format("cuestionarios_guardados/%s.dat", nombre_archivo));
                FileOutputStream output = new FileOutputStream(file);
                ObjectOutputStream writer = new ObjectOutputStream(output);
                
                int res = JOptionPane.showConfirmDialog(null, "Desea sobreescribir el archivo?", 
                    "Seleccione una opcion", JOptionPane.YES_NO_CANCEL_OPTION);
                if(res == JOptionPane.YES_OPTION){
                    materia = nombre_archivo;
                    writer.writeObject(preguntas);
                    writer.close();
                    output.close();
                }
                else if(res == JOptionPane.NO_OPTION){
                    throw new CuestionarioExistenteException("Elija otro nombre para el archivo");
                }
            }else{
                File file = new File(String.format("cuestionarios_guardados/%s.dat", nombre_archivo));
                FileOutputStream output = new FileOutputStream(file);
                ObjectOutputStream writer = new ObjectOutputStream(output);
                materia = nombre_archivo;
                writer.writeObject(preguntas);
                writer.close();
                output.close();
            } 
        }
        catch(CuestionarioExistenteException ex){
            throw new CuestionarioExistenteException("Elija otro nombre para el archivo");
        }
        catch(Exception ex){
            throw new GuardarArchivoException("Hubo un error al guardar los datos.");  
        }
    }
    
    public void load(File archivo) throws CargarArchivoException, ArchivoInvalidoException{
        File file = archivo;
        try {
            FileInputStream input = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(input);
            materia = archivo.getName().substring(0, archivo.getName().length() - 4);
            preguntas = (ArrayList<Pregunta>)reader.readObject(); 

            reader.close();
            input.close();
        }
        catch(IOException ex){
            throw new CargarArchivoException("Error al cargar el archivo inicial.");  
        }
        catch(ClassNotFoundException ex){
            throw new ArchivoInvalidoException("El archivo de origen esta corrupto.");  
        }
    }

}
