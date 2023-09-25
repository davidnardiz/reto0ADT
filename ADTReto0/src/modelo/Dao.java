/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;

/**
 *
 * @author 2dam
 */
public interface Dao {
    
    /**
     * Método que crea una Unidad Didáctica en la base de datos a partir de la UD.
     * @param ud la unidad didáctica que vamos a añadir a la base de datos.
     */
    public void crearUnidadDidactica(UnidadDidactica ud);
    
    /**
     * Método que crea una Convocatoria en el fichero a partir de la partir de la Convocatoria.
     * @param ce la convocatoria que vamos a añadir al fichero. 
     */
    public void crearConvocatoria(ConvocatoriaExamen ce);
    
    /**
     * Método que crea un Enunciado en la base de datos partir del propio Enunciado.
     * @param e el enunciado que vamos a añadir a la base de datos.
     */
    public void crearEnunciado(Enunciado e);
    
    /**
     * Método que mediante la convocatoria busca en el fichero todos los datos de esa convocatoria y los devuelve en forma de objeto.
     * @param convocatoria
     * @return 
     */
    public ConvocatoriaExamen consultarConvocatoria(String convocatoria);
    
    /**
     * 
     * @param idenunciado
     * @return 
     */
    public Enunciado consultarEnunciado(int idenunciado);
    
    
}
