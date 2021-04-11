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
public class PreguntaSinIncisosException extends Exception {

    /**
     * Creates a new instance of <code>PreguntaSinIncisosException</code>
     * without detail message.
     */
    public PreguntaSinIncisosException() {
    }

    /**
     * Constructs an instance of <code>PreguntaSinIncisosException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PreguntaSinIncisosException(String msg) {
        super(msg);
    }
}
