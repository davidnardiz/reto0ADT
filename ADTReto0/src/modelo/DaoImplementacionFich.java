/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ExcepcionConsultar;
import excepciones.ExcepcionCreacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MiObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionFich implements Dao {

    File fich = new File("convocatorias.obj");

    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //fich
    @Override
    public void crearConvocatoria(ConvocatoriaExamen ce) throws ExcepcionCreacion {
        ObjectOutputStream oos = null;

        try {
            if (!fich.exists()) {
                oos = new MiObjectOutputStream(new FileOutputStream(fich, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fich));
            }

            oos.writeObject(ce);

        } catch (FileNotFoundException ex) {
            throw new ExcepcionCreacion("Ha habido un fallo en la creación");
        } catch (IOException ex) {
            throw new ExcepcionCreacion("Ha habido un fallo en la creación");
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                throw new ExcepcionCreacion("Ha habido un fallo en la creación");
            }
        }
    }

    @Override
    public void crearEnunciado(Enunciado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //fich
    @Override
    public ConvocatoriaExamen consultarConvocatoria(String convocatoria) throws ExcepcionConsultar{
        ObjectInputStream ois = null;
        ConvocatoriaExamen ce = null;
        int j = Utilidades.calculoFichero(fich);
        
        try {
            ois = new ObjectInputStream(new FileInputStream(fich));
            
            for (int i = 0; i < j; i++) {
                ConvocatoriaExamen ce1 = (ConvocatoriaExamen) ois.readObject();
                if(ce1.getConvocatoria().equalsIgnoreCase(convocatoria)){
                    ce = ce1;
                    i = j;
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            throw new ExcepcionConsultar("Ha habido un fallo al consultar.");
        } catch (IOException ex) {
            throw new ExcepcionConsultar("Ha habido un fallo al consultar.");
        } catch (ClassNotFoundException ex) {
            throw new ExcepcionConsultar("Ha habido un fallo al consultar.");
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                throw new ExcepcionConsultar("Ha habido un fallo al consultar.");
            }
        }
        
        return ce;
    }

    @Override
    public Enunciado consultarEnunciado(int idenunciado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
