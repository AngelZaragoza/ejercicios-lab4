
package Gestores;

import Modelo.EstadoCivil;
import Modelo.Persona;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class GestorPersonas {
    //Aquí irá toda la lógica de manejo de la conexión a la DB
    
    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LaboIV";
    private String USER = "sa";
    private String PASS = "tekken5";
    private Connection con;
    
    //CONSTRUCTOR
    public GestorPersonas() {
        this.con = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //METODOS
    private void abrirConexion() {
        try {        
            con = DriverManager.getConnection(CONN, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cerrarConexion() {
        try
        {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String agregarPersona (Persona nueva) {
        String result = "Error agregando Persona";
        try
        {
            abrirConexion();
            
            PreparedStatement st = con.prepareStatement("INSERT INTO Personas (nombre,apellido,edad,idEstadoCivil) values (?,?,?,?)");
            st.setString(1, nueva.getNombre());
            st.setString(2, nueva.getApellido());
            st.setInt(3, nueva.getEdad());
            st.setInt(4, nueva.getEstadoCivil().getId());
            
            st.executeUpdate();
            st.close();
            cerrarConexion();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public ArrayList<Persona> obtenerPersonas() {
        
        ArrayList<Persona> lista = new ArrayList<>();
        try
        {
            abrirConexion();
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT P.*, EC.descripcion FROM Personas P JOIN EstadosCiviles EC" +
                                            " ON P.idEstadoCivil = EC.idEstado");
            while(rs.next()) {
                
                int id = rs.getInt("id");
                String nom = rs.getString("nombre");
                String ape = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idEstadoCivil = rs.getInt("idEstadoCivil");
                String nombreEstadoCivil = rs.getString("descripcion");
                EstadoCivil ec = new EstadoCivil(idEstadoCivil, nombreEstadoCivil);
                
                Persona p = new Persona(id, nom, ape, edad, ec);
                lista.add(p);
                
            }            
            rs.close();
            st.close();
            cerrarConexion();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public Persona obtenerUna (int id) {
        Persona p = new Persona();
        
        return p;
    }
    
    public ArrayList<EstadoCivil> obtenerEstadosCiviles() {
        ArrayList<EstadoCivil> lista = new ArrayList<>();
        try {
            abrirConexion();
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EstadosCiviles");
            
            while(rs.next()) {
                int id = rs.getInt("idEstado");
                String desc = rs.getString("descripcion");
                
                EstadoCivil ec = new EstadoCivil(id, desc);
                lista.add(ec);
            }
            
            rs.close();
            st.close();
            
            cerrarConexion();
            
        } catch (Exception ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
