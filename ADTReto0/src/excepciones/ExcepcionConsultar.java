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
public class ExcepcionConsultar extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionConsultar</code> without detail
     * message.
     */
    public ExcepcionConsultar() {
        super();
    }

    /**
     * Constructs an instance of <code>ExcepcionConsultar</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionConsultar(String msg) {
        super(msg);
    }
}
