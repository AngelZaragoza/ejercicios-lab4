package Controlador;

import DTO.DTOReporte;
import DTO.DTOVenta;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class ConexionJDBC {
    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LaboIV";
    private String USER = "sa";
    private String PASS = "tekken5";
    
    
    //Manejo de la Conexión
    private Connection abrirConexion() {
        
        Connection con = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    private void cerrarConexion(Connection con) {
        try
        {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //MANEJO DE DATOS
    //Agrega un nuevo Producto en la DB
    public String addProducto(Producto nuevo) {
        Connection con = abrirConexion();
        String sql = "INSERT INTO Productos (nombre,precio) VALUES (?,?)";
        String result = "Error guardando Producto";
        try {            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nuevo.getNombre());
            st.setDouble(2, nuevo.getPrecio());
            
            st.executeUpdate();
            st.close();
            result = "Nuevo Producto Guardado:\n" +
                    nuevo.getNombre();
        }
        catch (Exception ex) {
            ex.printStackTrace();            
        }
        finally
        {
            cerrarConexion(con);            
        }
        
        return result;
    }
    
    //Actualiza los datos del Producto en la DB
    public String updateProducto(Producto prod) {
        Connection con = abrirConexion();
        String sql = "UPDATE Productos SET nombre=?, precio=? WHERE codigo=?";
        String result = "Error guardando Producto";
        
        try {            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, prod.getNombre());
            st.setDouble(2, prod.getPrecio());
            st.setInt(3, prod.getCodigo());
            
            st.executeUpdate();
            st.close();
            
            result = "Producto Actualizado:\n" +
                    prod.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally
        {
            cerrarConexion(con);
        }
        
        return result;
    }
    
    //Devuelve el listado de productos desde la DB
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        Connection con = abrirConexion();
        String sql = "SELECT * FROM Productos";
        
        try
        {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           while(rs.next())
           {
               int cod = rs.getInt("codigo");
               String nom = rs.getString("nombre");
               double precio = rs.getDouble("precio");
               
               Producto p = new Producto(cod, nom, precio);
               lista.add(p);
           }
           
           st.close();
           rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion(con);
        }
        
        return lista;        
    }
    
    public String addVenta(Venta venta) {
        Connection con = abrirConexion();
        String sql = "INSERT INTO Ventas (cliente,cantidad,codProducto) VALUES (?,?,?)";
        String result = "Error guardando Venta";
        try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setInt(2, venta.getCantidad());
            ps.setInt(3, venta.getProducto().getCodigo());
            
            
            ps.executeUpdate();
            ps.close();
            result = "Venta Registrada:\n" +
                    venta.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();            
        }
        finally
        {
            cerrarConexion(con);            
        }
        
        return result;
    }
    
    public ArrayList<DTOVenta> getVentasConDTO() {
        ArrayList<DTOVenta> lista = new ArrayList<>();
        Connection con = abrirConexion();
        String sql = "SELECT V.id, V.cliente, V.cantidad, P.nombre, P.precio FROM Ventas V JOIN Productos P ON V.codProducto = P.codigo";
        
        try
        {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           while(rs.next())
           {
               int idVenta = rs.getInt("id");
               String nombreCliente = rs.getString("cliente");
               int cantidad = rs.getInt("cantidad");
               String nombreProducto = rs.getString("nombre");
               double precio = rs.getDouble("precio");
               
               DTOVenta venta = new DTOVenta(nombreCliente, cantidad, nombreProducto, precio);
               lista.add(venta);
               
           }
           
           st.close();
           rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion(con);
        }
        
        return lista;        
    }
    
    public ArrayList<DTOReporte> cantidadVentasPorProducto() {
        ArrayList<DTOReporte> lista = new ArrayList<>();
        Connection con = abrirConexion();
        String sql = "SELECT COUNT(*) 'Cantidad', p.nombre 'Producto'\n" + 
                        "from Ventas v join Productos p ON v.codProducto = p.codigo\n" +
                        "GROUP by p.nombre";
        
        try
        {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           
           while(rs.next())
           {
               int cantidad  = rs.getInt("Cantidad");
               String nombreProducto = rs.getString("Producto");
                              
               DTOReporte reporte = new DTOReporte(nombreProducto, cantidad);
               lista.add(reporte);
               
           }
           
           st.close();
           rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion(con);
        }
        
        return lista;        
    }
}
