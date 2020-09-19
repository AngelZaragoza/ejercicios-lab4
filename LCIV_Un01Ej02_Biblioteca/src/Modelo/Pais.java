package Modelo;

/**
 *
 * @author Angel
 */
class Pais {
    private int idPais;
    private String nombrePais;

    //CONSTRUCTOR
    public Pais(int idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }

    //GETTERS
    public int getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    @Override
    public String toString() {
        return nombrePais;
    }
    
    
}
