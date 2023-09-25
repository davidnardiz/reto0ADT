/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author David.
 */
public class ExcepcionAsociar extends Exception {

    private String mensaje;

    public ExcepcionAsociar(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarError() {
        System.out.println(mensaje);
    }
}
