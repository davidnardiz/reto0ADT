/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtreto0;

import clases.Menu;
import excepciones.ExcepcionAsociar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class ADTReto0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Menu menu = new Menu();
            menu.visualizarMenu(new Controlador());
        } catch (ExcepcionAsociar ex) {
            Logger.getLogger(ADTReto0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
