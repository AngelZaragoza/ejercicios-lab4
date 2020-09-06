package Modelo;

/**
 *
 * @author Angel
 */
public class Producto {
    private int codigo;
    private String nombre;
    private double precio;

    //CONSTRUCTORES
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    //GETTERS Y SETTERS

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    @Override
    public String toString() {
        return nombre + " - $ " + String.format("%.2f", precio);
    }
        
}
