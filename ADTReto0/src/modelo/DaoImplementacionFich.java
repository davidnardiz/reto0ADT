/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ExcepcionAsociar;
import excepciones.ExcepcionConsultar;
import excepciones.ExcepcionCreacion;
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
    public ConvocatoriaExamen consultarConvocatoria(String convocatoria) throws ExcepcionConsultar {
        ObjectInputStream ois = null;
        ConvocatoriaExamen ce = null;
        int j = Utilidades.calculoFichero(fich);

        try {
            ois = new ObjectInputStream(new FileInputStream(fich));

            for (int i = 0; i < j; i++) {
                ConvocatoriaExamen ce1 = (ConvocatoriaExamen) ois.readObject();
                if (ce1.getConvocatoria().equalsIgnoreCase(convocatoria)) {
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
        return new Enunciado();
    }

    @Override
    public void asociarEnunciado(int idEnunciado, String convocatoria) throws ExcepcionAsociar {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ConvocatoriaExamen ce = null;
        int j = Utilidades.calculoFichero(fich);
        File fich2 = new File("aux.obj");

        try {
            ois = new ObjectInputStream(new FileInputStream(fich));
            oos = new ObjectOutputStream(new FileOutputStream(fich2));

            for (int i = 0; i < j; i++) {
                ce = (ConvocatoriaExamen) ois.readObject();
                if (ce.getConvocatoria().equalsIgnoreCase(convocatoria)) {
                    ce.setIdEnunciado(idEnunciado);

                }
                oos.writeObject(ce);
            }

        } catch (FileNotFoundException ex) {
            throw new ExcepcionAsociar("Ha habido un fallo al asociar.");
        } catch (IOException ex) {
            throw new ExcepcionAsociar("Ha habido un fallo al asociar.");
        } catch (ClassNotFoundException ex) {
            throw new ExcepcionAsociar("Ha habido un fallo al asociar.");
        } finally {
            try {
                oos.flush();
                oos.close();
                ois.close();

                fich.delete();
                fich2.renameTo(fich);
            } catch (IOException ex) {
                throw new ExcepcionAsociar("Ha habido un fallo al asociar.");
            }
        }
    }
    
}
