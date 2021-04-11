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
public class RespuestaUnicaException extends Exception {

    /**
     * Creates a new instance of <code>RespuestaUnicaException</code> without
     * detail message.
     */
    public RespuestaUnicaException() {
    }

    /**
     * Constructs an instance of <code>RespuestaUnicaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RespuestaUnicaException(String msg) {
        super(msg);
    }
}
