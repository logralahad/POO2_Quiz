/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author logra
 */
public class AlumnoSinExamenException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoSinExamenException</code> without
     * detail message.
     */
    public AlumnoSinExamenException() {
    }

    /**
     * Constructs an instance of <code>AlumnoSinExamenException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoSinExamenException(String msg) {
        super(msg);
    }
}
