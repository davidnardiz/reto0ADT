/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author 2dam
 */
public class ExcepcionCreacion extends Exception {

    /**
     * Creates a new instance of <code>excepcionCreacion</code> without detail
     * message.
     */
    public ExcepcionCreacion() {
        super();
    }

    /**
     * Constructs an instance of <code>excepcionCreacion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionCreacion(String msg) {
        super(msg);
    }
}
