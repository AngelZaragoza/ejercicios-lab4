
package Modelo;

/**
 *
 * @author Angel
 */
public class Servicio {
    private int numero;
    private String tipo;
    private String descripcion;
    private double costo;

    public Servicio() {
    }

    public Servicio(int numero, String tipo, String descripcion, double costo) {
        this.numero = numero;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Id: " + numero + " - Tipo: " + tipo + " - " + descripcion + " - $ " + costo;
    }
    
    
}
