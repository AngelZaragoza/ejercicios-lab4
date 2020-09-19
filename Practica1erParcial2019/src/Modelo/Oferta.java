
package Modelo;

/**
 *
 * @author Angel
 */
public class Oferta {
    private int id;
    private double precioNormal;
    private double precioOferta;
    private int stockDisponible;
    private String fechaInicio;
    private int diasVigencia;
    private Producto producto;

    public Oferta() {
    }

    public Oferta(int id, double precioNormal, double precioOferta, int stockDisponible, String fechaInicio, int diasVigencia, Producto producto) {
        this.id = id;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.stockDisponible = stockDisponible;
        this.fechaInicio = fechaInicio;
        this.diasVigencia = diasVigencia;
        this.producto = producto;
    }

    public int getId() {
        return id;
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

    public Producto getProducto() {
        return producto;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Oferta{" + "stockDisponible=" + stockDisponible + ", fechaInicio=" + fechaInicio + ", diasVigencia=" + diasVigencia + ", producto=" + producto + '}';
    }

    
    
    
    
}
