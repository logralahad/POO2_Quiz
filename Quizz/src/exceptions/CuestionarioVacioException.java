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
public class CuestionarioVacioException extends Exception {

    /**
     * Creates a new instance of <code>CuestionarioVacioException</code> without
     * detail message.
     */
    public CuestionarioVacioException() {
    }

    /**
     * Constructs an instance of <code>CuestionarioVacioException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CuestionarioVacioException(String msg) {
        super(msg);
    }
}
