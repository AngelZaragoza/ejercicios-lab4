package Modelo;

/**
 *
 * @author Angel
 */
public class Estado {
    private int idEstado;
    private String descripcion;

    public Estado(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "E:" + idEstado + " - " + descripcion;
    }
    
    
}
