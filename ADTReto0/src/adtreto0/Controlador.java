/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtreto0;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ExcepcionAsociar;
import excepciones.ExcepcionConsultar;
import excepciones.ExcepcionCreacion;
import java.io.File;
import modelo.DAOFactoria;
import modelo.Dao;

/**
 *
 * @author 2dam
 */
public class Controlador {

    Dao daoBD = DAOFactoria.crearDaoBD();
    Dao daoFich = DAOFactoria.crearDaoFich();

    public void crearUnidadDidactica(UnidadDidactica ud) {
        daoBD.crearUnidadDidactica(ud);
    }

    public void crearConvocatoria(ConvocatoriaExamen ce) throws ExcepcionCreacion {
        daoFich.crearConvocatoria(ce);
    }

    public void crearEnunciado(Enunciado e) {
        daoBD.crearEnunciado(e);
    }

    public ConvocatoriaExamen consultarConvocatoria(String convocatoria) throws ExcepcionConsultar {
        ConvocatoriaExamen ce = daoFich.consultarConvocatoria(convocatoria);
        return ce;
    }

    public Enunciado consultarEnunciado(int idEnunciado) {
        Enunciado e = daoBD.consultarEnunciado(idEnunciado);
        return e;
    }

    public void asociarEnunciado(int idEnunciado, String convocatoria) throws ExcepcionAsociar {
        daoFich.asociarEnunciado(idEnunciado, convocatoria);

    }

}
