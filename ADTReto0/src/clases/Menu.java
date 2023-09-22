/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import adtreto0.Controlador;
import excepciones.ExcepcionConsultar;
import excepciones.ExcepcionCreacion;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Menu {

    public void visualizarMenu(Controlador controlador) throws ExcepcionCreacion, ExcepcionConsultar {
        int opc;

        do {
            opc = utilidades.Utilidades.leerInt("Introduce una opción: \n 1.Crear unidad didáctica. \n 2.Crear convocatoria. \n 3.Crear enunciado. \n 4.Consultar convocatoria. \n 5.Consultar enunciado. \n 6.Visualizar enunciado. \n 7.Asociar enunciado. \n 8.Asociar convocatoria.");

            switch (opc) {
                case 1:
                    crearUnidadDidactica(controlador);
                    break;
                case 2:
                    break;
                case 3:
                    crearConvocatoria(controlador);
                    break;
                case 4:
                    consultarConvocatoria(controlador);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        } while (opc != 9);
    }

    private void crearUnidadDidactica(Controlador controlador) {
        UnidadDidactica ud = new UnidadDidactica();
        ud.setDatos();
        controlador.crearUnidadDidactica(ud);
        
    }

    private void crearConvocatoria(Controlador controlador) throws ExcepcionCreacion {
        ConvocatoriaExamen ce = new ConvocatoriaExamen();
        ce.setDatos();
        controlador.crearConvocatoria(ce);
    }

    private void consultarConvocatoria(Controlador controlador) throws ExcepcionConsultar {
        String convocatoria = Utilidades.introducirCadena("Introduce la convocatoria deseada");
        ConvocatoriaExamen ce = controlador.consultarConvocatoria(convocatoria);
        ce.toString();
    }
}
