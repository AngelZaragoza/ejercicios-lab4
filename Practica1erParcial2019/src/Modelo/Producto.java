
package Modelo;

/**
 *
 * @author Angel
 */
public class Producto {
    private int id;
    private String nombre;

    public Producto() {
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
        

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
