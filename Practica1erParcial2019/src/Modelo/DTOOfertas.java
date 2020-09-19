
package Modelo;

/**
 *
 * @author Angel
 */
public class DTOOfertas {
    private String nombre;
    private double precioNormal;
    private double precioOferta;
    private int stockDisponible;
    private String fechaInicio;
    private int diasVigencia;

    public DTOOfertas(String nombre, double precioNormal, double precioOferta, int stockDisponible, String fechaInicio, int diasVigencia) {
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.stockDisponible = stockDisponible;
        this.fechaInicio = fechaInicio;
        this.diasVigencia = diasVigencia;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }
    
    
}
