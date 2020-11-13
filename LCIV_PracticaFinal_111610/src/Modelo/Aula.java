package Modelo;

/**
 *
 * @author Angel
 */
public class Aula {
    private int nroAula;
    private String capacidad;

    public Aula() {
    }

    public Aula(int nroAula, String capacidad) {
        this.nroAula = nroAula;
        this.capacidad = capacidad;
    }

    public int getNroAula() {
        return nroAula;
    }

    public String getCapacidad() {
        return capacidad;
    }
    
    
}
