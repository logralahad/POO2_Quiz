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
public class PreguntaSinModalidadException extends Exception {

    /**
     * Creates a new instance of <code>PreguntaSinModelidadException</code>
     * without detail message.
     */
    public PreguntaSinModalidadException() {
    }

    /**
     * Constructs an instance of <code>PreguntaSinModelidadException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PreguntaSinModalidadException(String msg) {
        super(msg);
    }
}
