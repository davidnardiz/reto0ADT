/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gonzalo
 */
public interface DAOInterface {
    
    public void crearUnidadDidactica();
    public void crearConvocatoria();
    public void crearEnunciado();
    public void consultarConvocatoria();
    public void consultarEnunciado();
    public void visualizarEnuciado();
    public void asociarEnunciado();
    public void asociarConvocatoria();
    
}
