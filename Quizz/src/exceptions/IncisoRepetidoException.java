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
public class IncisoRepetidoException extends Exception {

    /**
     * Creates a new instance of <code>IncisoRepetidoException</code> without
     * detail message.
     */
    public IncisoRepetidoException() {
    }

    /**
     * Constructs an instance of <code>IncisoRepetidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IncisoRepetidoException(String msg) {
        super(msg);
    }
}
