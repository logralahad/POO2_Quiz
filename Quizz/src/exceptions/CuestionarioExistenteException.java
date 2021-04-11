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
public class CuestionarioExistenteException extends Exception {

    /**
     * Creates a new instance of <code>CuestionarioExistenteException</code>
     * without detail message.
     */
    public CuestionarioExistenteException() {
    }

    /**
     * Constructs an instance of <code>CuestionarioExistenteException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CuestionarioExistenteException(String msg) {
        super(msg);
    }
}
