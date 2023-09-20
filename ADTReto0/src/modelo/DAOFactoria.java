/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 2dam
 */
public class DAOFactoria {
    public static Dao crearDaoBD(){
        return new DaoImplementacionBD();
    }
    
    public static Dao crearDaoFich(){
        return new DaoImplementacionFich();
    }
    
}
