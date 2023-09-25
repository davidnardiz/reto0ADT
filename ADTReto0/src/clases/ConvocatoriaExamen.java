/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import utilidades.Utilidades;

/**
 *
 * @author Gonzalo, David
 */
public class ConvocatoriaExamen implements Serializable {

    //Propiedades de la clase.
    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private int idEnunciado;

    //Getters y Setters
    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    //ToString
    @Override
    public String toString() {
        return "ConvocatoriaExamen{" + "convocatoria=" + convocatoria + ", descripcion=" + descripcion + ", fecha=" + fecha + ", curso=" + curso + ", idEnunciado=" + idEnunciado + '}';
    }

    public void setDatos() {
        this.convocatoria = utilidades.Utilidades.introducirCadena("Introduce la convocatoria");
        this.descripcion = utilidades.Utilidades.introducirCadena("Introduce el descripción:");
        this.fecha = utilidades.Utilidades.introducirFecha("Introduce la fecha:");
        this.curso = utilidades.Utilidades.introducirCadena("Introduce el curso:");

    }

}
