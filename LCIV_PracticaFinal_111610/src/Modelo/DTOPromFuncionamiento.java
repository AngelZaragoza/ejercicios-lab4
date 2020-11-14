package Modelo;

/**
 *
 * @author Angel
 */
public class DTOPromFuncionamiento {
    private int numero;
    private String capacidad;
    private int promedio;

    //CONSTRUCTORES
    
    public DTOPromFuncionamiento() {
    }

    public DTOPromFuncionamiento(int numero, String capacidad, int promedio) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.promedio = promedio;
    }
    
    //GETTERS

    public int getNumero() {
        return numero;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public int getPromedio() {
        return promedio;
    }
    
    
}
