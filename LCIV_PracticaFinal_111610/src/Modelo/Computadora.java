package Modelo;

/**
 *
 * @author Angel
 */
public class Computadora {
    private int nroComputadora;
    private Aula aula;
    private Estado estado;
    private int funcionamiento;

    
    //CONSTRUCTORES
    public Computadora() {
    }

    public Computadora(int nroComputadora, Aula aula, Estado estado, int funcionamiento) {
        this.nroComputadora = nroComputadora;
        this.aula = aula;
        this.estado = estado;
        this.funcionamiento = funcionamiento;
    }
    
    //GETTERS Y SETTERS

    public int getNroComputadora() {
        return nroComputadora;
    }

    public void setNroComputadora(int nroComputadora) {
        this.nroComputadora = nroComputadora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getFuncionamiento() {
        return funcionamiento;
    }

    public void setFuncionamiento(int funcionamiento) {
        this.funcionamiento = funcionamiento;
    }

    @Override
    public String toString() {
        return "Aula: " + aula.getNroAula() + "\nEstado: " + estado.getDescripcion()
                + "\nValor Funcionamiento: " + funcionamiento;
    }
    
    
}
