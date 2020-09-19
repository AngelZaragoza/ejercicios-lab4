package Controlador;

import DTO.DTOListaLibros;
import Modelo.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Angel
 */
public class ConexionJDBC {
    private final String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=Biblioteca";
    private final String USER = "sa";
    private final String PASS = "tekken5";
    private Connection conn;

    //CONSTRUCTOR
    public ConexionJDBC() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = null;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: driver no encontrado", "Error", 0);
        }
    }
    
    public void excelente() {
        System.out.println("Inicializado correctamente");
    }
    
    //MANEJO DE LA CONEXION
    private void abrirConexion() {
                
        try
        {            
            conn = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception ex)
        {            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        
    }
    
    private void cerrarConexion() {
        try
        {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        
    }
    
    //Este método lo dejo por las dudas, ya que también se puede recuperar
    //la cantidad de libros desde el ArrayList que trae todos los datos
    public int cantLibrosRegistrados() {
        int cant = 0;
        String sql = "SELECT COUNT(*) FROM Libros";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())            
                cant = rs.getInt(1);
            rs.close();
            st.close();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);   
        }
        finally {
            cerrarConexion();
        }
        
        return cant;
    }
    
    public ArrayList<DTOListaLibros> listaLibrosConAutores() {
        ArrayList<DTOListaLibros> lista = new ArrayList<>();
        String sql = "SELECT descripcion, nombre, nombrePais\n" +
                    "  FROM Libros L JOIN Autores A ON L.idAutor = A.idAutor\n" +
                    "  JOIN Paises P ON A.idNacionalidad = P.idPais";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                String nombreLibro = rs.getString("descripcion");
                String nombreAutor = rs.getString("nombre");
                String nacionalidadAutor = rs.getString("nombrePais");
                
                DTOListaLibros libro = new DTOListaLibros(nombreLibro, nombreAutor, nacionalidadAutor);
                lista.add(libro);
            }
            st.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return lista;
    }
    
    public ArrayList<Autor> listaAutores() {
        ArrayList<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autores";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                int idAutor = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                int dni = rs.getInt("dni");
                int idNac = rs.getInt("idNacionalidad");
                
//                Autor autor = new Autor(idAutor, nombreAutor, dni, nacionalidad);
//                autores.add(autor);
            }
            st.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        
        return autores;
    }
}
