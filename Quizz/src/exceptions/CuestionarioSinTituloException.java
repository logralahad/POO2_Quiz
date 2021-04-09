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
public class CuestionarioSinTituloException extends Exception {

    /**
     * Creates a new instance of <code>CuestionarioSinTituloException</code>
     * without detail message.
     */
    public CuestionarioSinTituloException() {
    }

    /**
     * Constructs an instance of <code>CuestionarioSinTituloException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CuestionarioSinTituloException(String msg) {
        super(msg);
    }
}
