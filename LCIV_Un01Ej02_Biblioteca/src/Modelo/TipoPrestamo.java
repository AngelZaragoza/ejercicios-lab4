package Modelo;

/**
 *
 * @author Angel
 */
class TipoPrestamo {
    private int idTipo;
    private String tipoPrestamo;

    //CONSTRUCTOR
    public TipoPrestamo(int idTipo, String tipoPrestamo) {
        this.idTipo = idTipo;
        this.tipoPrestamo = tipoPrestamo;
    }

    //GETTERS
    public int getIdTipo() {
        return idTipo;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    @Override
    public String toString() {
        return tipoPrestamo;
    }
    
    
}
