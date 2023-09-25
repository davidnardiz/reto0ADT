/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Dificultad;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionBD implements Dao {

    private String insertQueryUD = "INSERT INTO unidad (id, acronimo, titulo, evaluacion, descripcion) VALUES (?, ?, ?, ?, ?)";
    private String insertQueryE = "INSERT INTO enunciado (id, descripcion, nivel, disponible, ruta) VALUES (?, ?, ?, ?, ?)";
    private String selecQueryE = "SELECT * FROM enunciado WHERE id = ?";

    private Connection conex;
    private PreparedStatement stmt;
    private ResultSet  rs;
    private ResourceBundle archivoConfig;
    private String url;
    private String usuario;
    private String contraseña;
    private String driver;

    public DaoImplementacionBD() {
        this.archivoConfig = ResourceBundle.getBundle("modelo.configBD");
        this.url = archivoConfig.getString("Conn");
        this.usuario = archivoConfig.getString("BDUser");
        this.contraseña = archivoConfig.getString("DBPass");
        this.driver = archivoConfig.getString("Driver");
    }

    public void openConnection() {
        try {
            conex = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        if (conex != null) {
            conex.close();
        }
        if (stmt != null) {
            conex.close();
        }
    }

    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) {
        openConnection();
        try {
            stmt = conex.prepareStatement(insertQueryUD);
            stmt.setInt(1, ud.getId());
            stmt.setString(2, ud.getAcronimo());
            stmt.setString(3, ud.getTitulo());
            stmt.setString(4, ud.getEvaluacion());
            stmt.setString(5, ud.getDescripcion());

            stmt.executeUpdate();

            stmt.close();
            conex.close();

            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearEnunciado(Enunciado e) {
        openConnection();
        try {
            stmt = conex.prepareStatement(insertQueryE);
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getDescripcion());
            if (e.getDificultad().equals(Dificultad.ALTA)) {
                stmt.setString(3, "Alto");
            }
            if (e.getDificultad().equals(Dificultad.MEDIA)) {
                stmt.setString(3, "Medio");
            }
            if (e.getDificultad().equals(Dificultad.BAJA)) {
                stmt.setString(3, "Bajo");
            }

            if (e.isDisponible() == true) {
                stmt.setInt(4, 1);
            }
            if (e.isDisponible() == false) {
                stmt.setInt(4, 0);
            }
            stmt.setString(5, e.getRuta());

            stmt.executeUpdate();

            stmt.close();
            conex.close();

            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ConvocatoriaExamen consultarConvocatoria(String convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado consultarEnunciado(int idenunciado) {
        openConnection();
        Enunciado en = null;       
        try {            
            stmt = conex.prepareStatement(selecQueryE);
            stmt.setInt(1, idenunciado);
            rs = stmt.executeQuery();
            
                
            if(rs.next()){
                en = new Enunciado(rs.getInt("id"), rs.getString("descripcion"), rs.getString("nivel") , rs.getInt("disponible"), rs.getString("ruta"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return en;
        }

}
