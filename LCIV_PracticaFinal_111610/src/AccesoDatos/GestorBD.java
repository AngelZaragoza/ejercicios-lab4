package AccesoDatos;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class GestorBD {

    private final String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=PracticaLabIV";
    private final String USER = "sa";
    private final String PASS = "tekken5";
    private Connection conn;

    public GestorBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = null;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: driver no encontrado", "Error", 0);
        }
    }

    //MANEJO DE LA CONEXION
    private void abrirConexion() {

        try {
            conn = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }

    }

    private void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }

    }
    
    

    public ArrayList<Estado> getEstados() {
        ArrayList<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM Estados";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int idEstado = rs.getInt("idEstado");
                String descripcion = rs.getString("descripcion");
                
                Estado p = new Estado(idEstado, descripcion);
                estados.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            cerrarConexion();
        }
        return estados;
    }
    
    public ArrayList<Aula> getAulas() {
        ArrayList<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM Aulas";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int numero = rs.getInt("numero");
                String capacidad = rs.getString("capacidad");
                
                Aula emp = new Aula(numero, capacidad);
                aulas.add(emp);
            }
            rs.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            cerrarConexion();
        }
        return aulas;
    }
    
    
    public void agregarComputadora(Computadora nueva) {
        String sql = "INSERT INTO Computadoras(nroAula,idEstado,funcionamiento) VALUES (?,?,?)";
        try
        {
            abrirConexion();            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nueva.getAula().getNroAula());
            ps.setInt(2, nueva.getEstado().getIdEstado());            
            ps.setInt(3, nueva.getFuncionamiento());
            
            ps.executeUpdate();            
            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally
        {
            cerrarConexion();
        }
        
        
    }   
    
    public int computadorasEnRevision() {
        int cant = 0;
        String sql = "SELECT COUNT(*) AS cant FROM Computadoras WHERE idEstado = 2";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cant = rs.getInt("cant");                
            }
            rs.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            cerrarConexion();
        }
        return cant;
    }
    
    public ArrayList<DTOPromFuncionamiento> promedioFuncionamiento() {
        ArrayList<DTOPromFuncionamiento> lista = new ArrayList<>();
        String sql = "SELECT A.numero, A.capacidad, AVG(funcionamiento) AS promedio\n" +
                    "	FROM Computadoras C JOIN Aulas A ON C.nroAula=A.numero\n" +
                    "	GROUP BY A.numero, A.capacidad";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int numero = rs.getInt("numero");
                String capacidad = rs.getString("capacidad");
                int promedio = rs.getInt("promedio");
                DTOPromFuncionamiento item = new DTOPromFuncionamiento(numero, capacidad, promedio);
                lista.add(item);
            }
            rs.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
        
    }

}
