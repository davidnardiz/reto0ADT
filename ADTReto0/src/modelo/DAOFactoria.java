/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.InterfaceAddress;

/**
 *
 * @author Gonzalo
 */
public class DAOFactoria {
    public static DAOInterface crearDaoBD(){
        return new ImplementacionBD();
        
    }
    
    public static DAOInterface crearDaoFich(){
        return new ImplementacionFich();
    }
}
