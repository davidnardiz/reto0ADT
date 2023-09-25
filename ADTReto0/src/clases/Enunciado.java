/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Gonzalo, David
 */
public class Enunciado {

    //Propiedades de la clase
    private int id;
    private String descripcion;
    private Dificultad dificultad;
    private boolean disponible;
    private String ruta;

    Enunciado() {
        
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Enunciado(int id, String descripcion, String dif, int disp, String ruta) {
        this.id = id;
        this.descripcion = descripcion;
        if (dif.equalsIgnoreCase("Alto")) {
            this.dificultad = Dificultad.ALTA;
        }
        if (dif.equalsIgnoreCase("Medio")) {
            this.dificultad = Dificultad.MEDIA;
        }
        if (dif.equalsIgnoreCase("Bajo")) {
            this.dificultad = Dificultad.BAJA;
        }
        if (disp == 0) {
            this.disponible = false;
        } else {
            this.disponible = true;
        }
        this.ruta = ruta;
    }

    //ToString
    @Override
    public String toString() {
        return "Enunciado{" + "id=" + id + ", descripcion=" + descripcion + ", dificultad=" + dificultad + ", disponible=" + disponible + ", ruta=" + ruta + '}';
    }

    public void setDatos() {
        String[] dificultades = {"Alta", "Media", "Baja"};

        this.id = utilidades.Utilidades.leerInt("Introduce el id");
        this.descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripción:");

        this.disponible = utilidades.Utilidades.esBoolean("¿Está disponible?");
        this.ruta = utilidades.Utilidades.introducirCadena("Introduce la ruta:");

        String dif = utilidades.Utilidades.leerStringArray(dificultades, "Introduce la dificultad");
        if (dif.equalsIgnoreCase("Alta")) {
            this.dificultad = Dificultad.ALTA;
        } else if (dif.equalsIgnoreCase("Media")) {
            this.dificultad = Dificultad.MEDIA;
        } else {
            this.dificultad = Dificultad.BAJA;
        }
    }

}
