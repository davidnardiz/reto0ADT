/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.io.File;
import java.io.ObjectOutputStream;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionFich implements Dao{

    File fich = new File("convocatorias.obj");
    
    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //fich
    @Override
    public void crearConvocatoria(ConvocatoriaExamen ce) {
        ObjectOutputStream oos;
        
        
        
    }

    @Override
    public void crearEnunciado(Enunciado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //fich
    @Override
    public ConvocatoriaExamen consultarConvocatoria(String convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado consultarEnunciado(int idenunciado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
