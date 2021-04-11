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
public class SoloUnaRespuestaException extends Exception {

    /**
     * Creates a new instance of <code>SoloUnaRespuestaException</code> without
     * detail message.
     */
    public SoloUnaRespuestaException() {
    }

    /**
     * Constructs an instance of <code>SoloUnaRespuestaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SoloUnaRespuestaException(String msg) {
        super(msg);
    }
}
