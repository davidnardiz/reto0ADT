/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static org.omg.CosNaming.NamingContextPackage.NotFoundHelper.id;

/**
 *
 * @author Gonzalo
 */
public class UnidadDidactica {

    public static String crearUnidadDidactica(int i, String hola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    //Propiedades de la clase Unidad Didáctica
   
    private int id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;
   
    //Getters de la clase Unidad Didáctica

    public int getId() {
        return id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
   
   
    //Setters de la clase Unidad Didáctica

    public void setId(int id) {
        this.id = id;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setDatos(){
        this.id = utilidades.Utilidades.leerInt("Introduce el Id:");
        this.acronimo = utilidades.Utilidades.introducirCadena("Introduce el acrónimo:");
        this.titulo = utilidades.Utilidades.introducirCadena("Introduce el título:");
        this.evaluacion = utilidades.Utilidades.introducirCadena("Introduce la evaluación:");  
    }
   
}

