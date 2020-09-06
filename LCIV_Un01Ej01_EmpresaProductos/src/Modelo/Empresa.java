package Modelo;

import Controlador.ConexionJDBC;
import DTO.DTOReporte;
import DTO.DTOVenta;
import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class Empresa {
    private ArrayList<Producto> productos;
    private ArrayList<DTOVenta> ventas;
    private ArrayList<DTOReporte> reporte;
    private ConexionJDBC conn;

    //CONSTRUCTOR
    public Empresa() {
        //productos = new ArrayList<>();
        conn = new ConexionJDBC();
    }

    //GETTERS
    public ArrayList<Producto> getProductos() {        
        if (productos == null)        
            productos = conn.getProductos();
                
        return productos;
    }
    
    public ArrayList<DTOVenta> getVentasConDTO() {        
        if (ventas == null)        
            ventas = conn.getVentasConDTO();
                
        return ventas;
    }
    
    public ArrayList<DTOReporte> cantidadVentasPorProducto() {        
        if (reporte == null)        
            reporte = conn.cantidadVentasPorProducto();
                
        return reporte;
    }
    
    //METODOS
    public String addProducto (Producto prod) {
        String result = conn.addProducto(prod);
        productos = conn.getProductos();
        
        return result;
    }
    
    public String updateProducto (Producto prod) {
        String result = conn.updateProducto(prod);
        productos = conn.getProductos();
        
        return result;
    }
    
    public String addVenta (Venta vta) {
        String result = conn.addVenta(vta);
        //productos = conn.getProductos();
        
        return result;
    }
    
        
}
