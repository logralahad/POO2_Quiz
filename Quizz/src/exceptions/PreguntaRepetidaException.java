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
public class PreguntaRepetidaException extends Exception {

    /**
     * Creates a new instance of <code>PreguntaRepetidaException</code> without
     * detail message.
     */
    public PreguntaRepetidaException() {
    }

    /**
     * Constructs an instance of <code>PreguntaRepetidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PreguntaRepetidaException(String msg) {
        super(msg);
    }
}
