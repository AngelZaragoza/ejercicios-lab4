
package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class GestorBD {
    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=Supermercado";
    private String USER = "sa";
    private String PASS = "tekken5";
    private Connection conn;

    public GestorBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = null;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: driver no encontrado", "Error", 0);
        }
    }
    
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
    
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Producto p = new Producto(id, nombre);
                
                lista.add(p);
            }
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
    
    public int agregarOferta(Oferta nueva) {
        String sql = "INSERT INTO Oferta (idProducto,precioNormal,precioOferta,"
                + "stockDisponible,fechaInicioOferta,diasVigencia) VALUES (?,?,?,?,?,?)";
        int result = 0;
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nueva.getProducto().getId());
            ps.setDouble(2, nueva.getPrecioNormal());
            ps.setDouble(3, nueva.getPrecioOferta());
            ps.setInt(4, nueva.getStockDisponible());
            ps.setString(5, nueva.getFechaInicio());
            ps.setInt(6, nueva.getDiasVigencia());
            result = ps.executeUpdate();            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally {
            cerrarConexion();
        }
        return result;
    }
    
    public ArrayList<DTOOfertas> listadoOfertas() {
        ArrayList<DTOOfertas> lista = new ArrayList<>();
        String sql = "SELECT p.nombre, precioNormal 'normal', precioOferta 'oferta', stockDisponible 'stock',\n" +
                        "fechaInicioOferta 'inicio', diasVigencia 'vigencia'\n" +
                        "   FROM Oferta o JOIN Producto P\n" +
                        "     ON O.idProducto = P.id";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                double normal = rs.getDouble("normal");
                double oferta = rs.getDouble("oferta");
                int stock = rs.getInt("stock");
                String inicio = rs.getString("inicio");
                int vigencia = rs.getInt("vigencia");
                
                DTOOfertas of = new DTOOfertas(nombre, normal, oferta, stock, inicio, vigencia);
                lista.add(of);
            }
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally {
            cerrarConexion();
        }        
        
        return lista;
    }
    
    public double montoNoGanado(int idProd) {
        double monto = 0;
        String sql = "SELECT SUM ((precioNormal-precioOferta)*stockDisponible)" +
                     "FROM Oferta " +
                     "WHERE idProducto=?";
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProd);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                monto = rs.getDouble(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally {
            cerrarConexion();
        }
        
        return monto;
    }
    
    public int ofertasMasDeCincoDias() {
        int cant = 0;
        String sql = "SELECT COUNT (*) 'cant'\n" +
                    "  FROM Oferta \n" +
                    "WHERE diasVigencia > 5";
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
                cant = rs.getInt(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        finally {
            cerrarConexion();
        }
        
        return cant;
    }
}
