/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import adtreto0.Controlador;
import excepciones.ExcepcionAsociar;
import excepciones.ExcepcionConsultar;
import excepciones.ExcepcionCreacion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Menu {

    public void visualizarMenu(Controlador controlador) {
        int opc;

        do {
            opc = utilidades.Utilidades.leerInt("Introduce una opción: \n 1.Crear unidad didáctica. \n 2.Crear convocatoria. \n 3.Crear enunciado. \n 4.Consultar convocatoria. \n 5.Consultar enunciado. \n 6.Visualizar enunciado. \n 7.Asociar enunciado. \n 8.Salir.");

            switch (opc) {
                case 1:
                    crearUnidadDidactica(controlador);
                    break;
                case 2:
                    crearConvocatoria(controlador);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    visualizarEnunciado(controlador);
                    break;
                case 7:
                    asociarEnunciado(controlador);
                    break;

            }
        } while (opc != 8);
    }

    /**
     * Se crea una instancia de la clase UnidadDidactica y se configuran los
     * datos de la unidad didáctica utilizando el método setDatos. Se llama al
     * método del controlador para crear la unidad didáctica en la base de
     * datos.
     *
     * @param controlador
     */
    private void crearUnidadDidactica(Controlador controlador) {
        UnidadDidactica ud = new UnidadDidactica();
        ud.setDatos();
        controlador.crearUnidadDidactica(ud);
    }

    /**
     * Se crea una instancia de la clase ConvocatoriaExamen y se configuran los
     * datos de la convocatoria utilizando el método setDatos. Se llama al
     * método del controlador para crear la convocatoria en la base de datos
     *
     * @param controlador
     */
    private void crearConvocatoriaExamen(Controlador controlador) {
        try {
            ConvocatoriaExamen convocatoria = new ConvocatoriaExamen();
            convocatoria.setDatos();
            controlador.crearConvocatoria(convocatoria);
            System.out.println("Convocatoria creada correctamente");
        } catch (ExcepcionCreacion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Se crea una instancia de la clase Enunciado y se configuran los datos del
     * enunciado utilizando el método setDatos. Se llama al método del
     * controlador para crear el enunciado en la base de datos
     *
     * @param controlador
     */
    private void crearEnunciado(Controlador controlador) {
        Enunciado enunciado = new Enunciado();
        enunciado.setDatos();
        controlador.crearEnunciado(enunciado);
        System.out.println("Enunciado creado correctamente.");
    }

    /**
     * Se solicita al usuario que ingrese el id de la convocatoria que desea
     * consultar y se llama al método del controlador para consultar la
     * convocatoria. Después se verifica si la convocatoria existe: si existe se
     * la devuelve al usuario, sino le informa de que no existe.
     *
     * @param controlador
     */
    private void consultarConvocatoria(Controlador controlador) {
        try {
            String convocatoria = Utilidades.introducirCadena("Introduce la convocatoria deseada:");
            ConvocatoriaExamen ce = controlador.consultarConvocatoria(convocatoria);
            System.out.println(ce.toString());
        } catch (ExcepcionConsultar ex) {
            ex.mostrarError();
        }
    }
    
    /**
     * Se solicita al usuario que ingrese el id de la enunciado que desea
     * consultar y se llama al método del controlador para consultar el
     * enunciado. Después se verifica si el enunciado existe: si existe se lo
     * devuelve al usuario, sino le informa de que no existe.
     *
     * @param controlador
     */
    private void consultarEnunciado(Controlador controlador) {
        int idEnunciado = utilidades.Utilidades.leerInt("Por favor introduce identificador de la convocatoria: ");
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

    private void asociarEnunciado(Controlador controlador) throws ExcepcionAsociar {
        ConvocatoriaExamen conv;
        int idEnum = Utilidades.leerInt("Introduce el enunciado deseado:");
        Enunciado enun = controlador.consultarEnunciado(idEnum);
        if (enun != null) {
            String convocatoria = Utilidades.introducirCadena("Introduce la convocatoria:");
            controlador.asociarEnunciado(idEnum, convocatoria);
        } else {

        }

    }        

    

    

}
