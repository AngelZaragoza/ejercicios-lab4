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
    
    public ArrayList<Aula> obtenerEmpleados() {
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
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            cerrarConexion();
        }
        return aulas;
    }
//    
//    
//    public void agregarVisita(Visita nueva) {
//        String sql = "INSERT INTO Visitas (idPaciente,LegajoRecepcionista,Nombre,Duracion) VALUES (?,?,?,?)";
//        try
//        {
//            abrirConexion();            
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, nueva.getPaciente().getIdPaciente());
//            ps.setInt(2, nueva.getRecepcionista().getLegajo());
//            ps.setString(3, nueva.getNombre());
//            ps.setInt(4, nueva.getDuracion());
//            
//            ps.executeUpdate();
//            ps.close();
//            
//            
//        }
//        catch (SQLException ex)
//        {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
//        }
//        finally
//        {
//            cerrarConexion();
//        }
//        
//        
//    }   
//    
//    public ArrayList<DTOVisitas> listadoVisitas() {
//        ArrayList<DTOVisitas> listado = new ArrayList<>();
//        String sql = "SELECT P.Nombre AS paciente, V.Nombre AS visita, E.Nombre AS recep, V.Duracion\n" +
//            "FROM Empleados E INNER JOIN Visitas V ON E.Legajo = V.LegajoRecepcionista " +
//                "INNER JOIN Pacientes P ON V.IdPaciente = P.IdPaciente\n" +
//                "ORDER BY paciente";
//        try {
//            abrirConexion();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//
//                String paciente = rs.getString("paciente");
//                String visita = rs.getString("visita");
//                String recep = rs.getString("recep");
//                int duracion = rs.getInt("Duracion");
//                DTOVisitas v = new DTOVisitas(visita, paciente, recep, duracion);
//                listado.add(v);
//            }
//            rs.close();
//            st.close();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
//        } finally {
//            cerrarConexion();
//        }
//        return listado;
//        
//    }
//    
//    public ArrayList<DTOCantVisitas> cantVisitas() {
//        ArrayList<DTOCantVisitas> listado = new ArrayList<>();
//        String sql = "SELECT P.Nombre, COUNT(*) Cant\n" +
//                        " FROM Visitas V JOIN Pacientes P ON V.IdPaciente = P.IdPaciente\n" +
//                        "GROUP BY P.Nombre\n" +
//                        "ORDER BY P.Nombre";
//        try {
//            abrirConexion();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//
//                String paciente = rs.getString("Nombre");                
//                int cant = rs.getInt("Cant");
//                DTOCantVisitas c = new DTOCantVisitas(paciente, cant);
//                listado.add(c);
//            }
//            rs.close();
//            st.close();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
//        } finally {
//            cerrarConexion();
//        }
//        return listado;        
//    }
//    
//    public int promedioVisitasMasDeDiezMin() {
//        int promedio = 0;
//        String sql = "SELECT AVG(Duracion) promedio " +
//                    "FROM Visitas " +
//                    "WHERE Duracion > 10";
//        
//        try {
//            abrirConexion();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) 
//                promedio = rs.getInt("promedio");                
//            
//            rs.close();
//            st.close();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
//        } finally {
//            cerrarConexion();
//        }
//        return promedio;
//    }

}
