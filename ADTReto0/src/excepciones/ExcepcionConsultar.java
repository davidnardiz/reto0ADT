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

    private String mensaje;

    public ExcepcionConsultar(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarError() {
        System.out.println(mensaje);
    }
}
