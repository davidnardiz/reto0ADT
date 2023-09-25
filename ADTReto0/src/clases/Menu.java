/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import adtreto0.Controlador;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author 2dam
 */
public class Menu {

    public void visualizarMenu(Controlador controlador) {
        int opc;

        do {
            opc = utilidades.Utilidades.leerInt("Introduce una opción: \n 1.Crear unidad didáctica. \n 2.Crear convocatoria. \n 3.Crear enunciado. \n 4.Consultar convocatoria. \n 5.Consultar enunciado. \n 6.Visualizar enunciado. \n 7.Asociar enunciado.");

            switch (opc) {
                case 1:
                    crearUnidadDidactica(controlador);
                    break;
                case 2:
                    crearConvocatoriaExamen(controlador);
                    break;
                case 3:
                    crearEnunciado(controlador);
                    break;
                case 4:
                    consultarConvocatoria();
                    break;
                case 5:
                    consultarEnunciado();
                    break;
                case 6:
                    visualizarEnunciado(controlador);
                    break;
                case 7:
                    asociarEnunciado(controlador);
                    break;
            }
        } while (opc != 9);
    }

    /**
     * Se crea una instancia de la clase UnidadDidactica y se configuran los datos de la unidad didáctica utilizando
     * el método setDatos. Se llama al método del controlador para crear la unidad didáctica en la base de datos.
     * @param controlador 
     */
    private void crearUnidadDidactica(Controlador controlador){
        UnidadDidactica ud = new UnidadDidactica();
        ud.setDatos();
        controlador.crearUnidadDidactica(ud);
        System.out.println("Unidad Didactica creada correctamente");
        
    }
    /**
     * Se crea una instancia de la clase ConvocatoriaExamen y se configuran los datos de la convocatoria utilizando el método setDatos. 
     * Se llama al método del controlador para crear la convocatoria en la base de datos
     * @param controlador 
     */
    private void crearConvocatoriaExamen(Controlador controlador) {
        ConvocatoriaExamen convocatoria = new ConvocatoriaExamen();
        convocatoria.setDatos();
        controlador.crearConvocatoria(convocatoria);
        System.out.println("Convocatoria creada correctamente");
    }
    /**
     * Se crea una instancia de la clase Enunciado y se configuran los datos del enunciado utilizando el método setDatos. 
     * Se llama al método del controlador para crear el enunciado en la base de datos
     * @param controlador 
     */
    private void crearEnunciado(Controlador controlador) {
        Enunciado enunciado = new Enunciado();
        enunciado.setDatos();
        controlador.crearEnunciado(enunciado);
        System.out.println("Enunciado creado correctamente.");
    }
    
    /**
     * Se solicita al usuario que ingrese el id de la convocatoria que desea consultar y se llama al método del controlador para consultar la convocatoria.
     * Después se verifica si la convocatoria existe: si existe se la devuelve al usuario, sino le informa de que no existe.
     * @param controlador 
     */
    private void consultarConvocatoria() {
    String idConvocatoria = utilidades.Utilidades.introducirCadena("Por favor, introduce identificador de la convocatoria: ");
    ConvocatoriaExamen convocatoria = controlador.consultarConvocatoria(idConvocatoria);
    if (convocatoria != null) {
        System.out.println("Detalles de la convocatoria: \n"+convocatoria.toString());
    } else {
        System.out.println("Lo siento, la convocatoria no existe.");
    }
}
     
    /**
     * Se solicita al usuario que ingrese el id de la enunciado que desea consultar y se llama al método del controlador para consultar el enunciado.
     * Después se verifica si el enunciado existe: si existe se lo devuelve al usuario, sino le informa de que no existe.
     * @param controlador 
     */
    private void consultarEnunciado() {
    String idEnunciado = utilidades.Utilidades.introducirCadena("Por favor introduce identificador del enunciado: ");
    Enunciado enunciado = controlador.consultarEnunciado(idEnunciado);
    if (enunciado != null) {
        System.out.println("Detalles del enunciado:");
        System.out.println(enunciado.toString());
    } else {
        System.out.println("Lo siento, el enunciado no existe.");
    }
}
    public void visualizarEnunciado(Controlador controlador) {
    int idEnunciado = utilidades.Utilidades.leerInt("Introduce el ID del enunciado que deseas visualizar: ");
    Enunciado enunciado = controlador.consultarEnunciado(idEnunciado);
    if (enunciado != null) {
        try {
            File archivo = new File(enunciado.getRuta());
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivo);
            } else {
                System.out.println("No es posible abrir el documento dado que no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el documento: " + e.getMessage());
        }
    } else {
        System.out.println("El enunciado no se encontró.");
    }
}
  
    /**
     * Se solicita al usuario que introduzca el id de la convocatoria a la que dese asociar el anunciado.
     * Si la convocatoria existe, se confirma por consola que se han asociado. Si no existe, se le informa al usuario
     * por consola de que la convocatoria introducida no existe.
     * @param controlador
     */
   private void asociarEnunciado(Controlador controlador) {

    String Convocatoria = utilidades.Utilidades.introducirCadena("Introduce el ID de la unidad didáctica: ");
    int idEnunciado = utilidades.Utilidades.leerInt("Introduce el ID del enunciado: ");


    Enunciado enunciado = controlador.consultarEnunciado();


    if (enunciado != null) {

        String idConvocatoria = convocatoria.getConvocatoria();

    }
   }
}
