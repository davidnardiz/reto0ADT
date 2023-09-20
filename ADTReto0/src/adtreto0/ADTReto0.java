/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtreto0;


import modelo.DAOFactoria;
import modelo.DAOInterface;


/**
 *
 * @author Gonzalo
 */
public class ADTReto0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAOInterface daoBD = DAOFactoria.crearDaoBD();
        DAOInterface daoFich = DAOFactoria.crearDaoFich();
        Menu menu = new Menu();
        menu.visualizarMenu();
    }
    
}
