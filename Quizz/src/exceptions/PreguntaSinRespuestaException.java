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
public class PreguntaSinRespuestaException extends Exception {

    /**
     * Creates a new instance of <code>PreguntaSinRespuestaException</code>
     * without detail message.
     */
    public PreguntaSinRespuestaException() {
    }

    /**
     * Constructs an instance of <code>PreguntaSinRespuestaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PreguntaSinRespuestaException(String msg) {
        super(msg);
    }
}
