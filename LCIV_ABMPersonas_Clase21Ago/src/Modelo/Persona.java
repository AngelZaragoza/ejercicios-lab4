package Modelo;

/**
 *
 * @author Angel
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private EstadoCivil estadoCivil;

    //CONSTRUCTORES
    public Persona() {}   
    
    public Persona(int id, String nombre, String apellido, int edad, EstadoCivil estadoCivil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Id: " + id + ". Ape: " + apellido + " Nom: " + nombre + 
                " - Edad: " + edad + " - E.Civil: " + estadoCivil.getNombre();
    }
    
    
    
}
