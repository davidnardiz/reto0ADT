/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtreto0;

import clases.Enunciado;
import clases.UnidadDidactica;
import modelo.DAOFactoria;
import modelo.Dao;

/**
 *
 * @author 2dam
 */
public class Controlador {
    Dao daoBD = DAOFactoria.crearDaoBD();
    Dao daoFIch = DAOFactoria.crearDaoFich();
    public void crearUnidadDidactica(UnidadDidactica ud) {
        daoBD.crearUnidadDidactica(ud);
    }
    
     public void crearEnunciado(Enunciado e) {
        daoBD.crearEnunciado(e);
    }
      public Enunciado consultarEnunciado(int idEnunciado) {
        Enunciado e = daoBD.consultarEnunciado(idEnunciado);
        return e;
    }

}
